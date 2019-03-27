/**
 * 
 */
package com.sinosoft.platform.core.application.impl;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SqlParamService;
import com.sinosoft.platform.core.application.SqlUtilService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.domain.model.TDefSqlParamsExample;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;

/**
 * @author Darker.Wang
 * @date 2016-7-26 上午9:10:04
 * @company SINOSOFT
 */
@Service
public class SqlParamServiceImpl implements SqlParamService{
	
	private static Logger logger = Logger.getLogger(SqlParamServiceImpl.class);
	@Autowired 
	TDefSqlParamsMapper tDefSqlParamsMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired
	SqlUtilService sqlUtilService;
	public SqlParamServiceImpl() {
		
	}

	/**
	 * 参数赋值
	 * @param sql
	 * @param sqlParams
	 * @return
	 */
	@Override
	public String doSqlParamed(String sql,Map<String,String> sqlParams){
		// TODO 如果系统参数和自定义参数同时存在，则取自定义参数
		sql = sqlUtilService.paramedSql(sqlParams, sql);
		return sql;
	}
	/**
	 * 初始化并获取系统参数
	 * @param pojo
	 * @return
	 */
	@Override
	public Map<String,String> getSysParams(ParamPOJO pojo) {
		if(!defaultParams.isEmpty()){
			//System.out.println("- system params was inited ："+defaultParams.toString());
			return defaultParams;
		}
		return initDefaultParams(pojo);
	}
	/**
	 * 获取SQL对应的参数
	 * @param pojo
	 * @return
	 */
	@Override
	public Map<String,String> getSqlParams(BigDecimal sqlId,ParamPOJO pojo,Map<String,String> selfParam){
		// TODO 获取SQL对应的参数
		Map<String,String> sqlParams = new HashMap<String,String>();
		TDefSqlParamsExample example = new TDefSqlParamsExample();
		TDefSqlParamsExample.Criteria criteria = example.createCriteria();
		criteria.andSqlIdEqualTo(sqlId);
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		criteria.andParamSubTypeNotEqualTo(Short.parseShort("0"));//SQL 自己对应的参数
		sqlParams.putAll(initParams(example,pojo,selfParam));
		logger.debug("init sqlId "+sqlId+" parameters ： "+sqlParams.toString());
		return sqlParams;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgNodeService#initdefaultParams()
	 */
	@Override
	public Map<String,String> initParams(TDefSqlParamsExample example,ParamPOJO pojo) {
		// TODO 参数获取
		Map<String,String> params = new HashMap<String,String>();
		List<TDefSqlParams> sqlParams = tDefSqlParamsMapper.selectByExample(example);
		for(TDefSqlParams sqlParam : sqlParams){
			String key = sqlParam.getParamCode();//参数编码
			String valueType = sqlParam.getParamValueType();//参数值类型
			String value = sqlParam.getParamValue();//参数值：用于默认
			/**
			描述参数类型 
		    0：参数屏蔽，设置空 
			1：取其外部传入POJO的值，默认 
			2：参数通过可执行SQL获得 
			3：取其Value对应的值(固定值)
			4：向前节点获取（用于节点构造）
			**/
			String paramType = sqlParam.getParamType();
			logger.debug("- paramType："+paramType);
			logger.debug("- valueType："+valueType);
			//参数屏蔽，设置空 
			Map<String,String> tMap = _initParam(paramType,key,value,pojo,null);
			if(tMap != null){
				params.putAll(tMap);
			}
		}
		return params;
	}
	/**
	 * 
	 * @param paramType
	 * @param key
	 * @param value
	 * @param pojo
	 * @param otherParams
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Map<String,String> _initParam(String paramType,String key,String value,ParamPOJO pojo,Map<String,String> otherParams){
		logger.debug("_initParam： paramType = "+paramType+" key = "+key+" value = "+value);
		Map<String,String> params = new HashMap<String,String>();
		if(paramType == null || paramType.equals("")||paramType.equals("0")){
			value = "NULL";
			params.put(key, value);
			return params;
		}
		//取其Value对应的值(固定值)
		if(paramType.equals("3")){
			params.put(key, value);
			return params;
		}
		//取其外部传入POJO的值，默认 
		if(paramType.equals("1") && pojo != null){
			String name = "get"+key.substring(0, 1).toUpperCase()+key.substring(1,key.length());
			logger.debug("Param get name ： "+name);
			Method method;
			try {
				Class<ParamPOJO> clazz = ParamPOJO.class;
				method = clazz.getMethod(name);
				if(method != null){
					value = getValueByType(method.invoke(pojo));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("参数类型为1，参数值属性未在ParamPOJO中定义，导致取不到值：sqlParam.key="+key);
			} 
			params.put(key, value);
			return params;
		}
		//参数通过可执行SQL获得 
		if(paramType.equals("2")){
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(value);
			List<Map> values = null;
			try{
				values = sqlAdapterMapper.excuteQuery(sqlAdapter);
				if(values != null && values.size() > 0){
					Map<?,?> map = values.get(0);
					if(map != null && map.size() > 0 ){
						if(map.containsKey(key.toUpperCase())){
							//存在接取
							value = (String) map.get(key.toUpperCase());
						}else{
							//不存在，转换成数组获取第一个
							value = (String) map.values().toArray()[0];
						}
					}
				}
			}catch(Exception e){
				e.printStackTrace();
				logger.info("参数类型为2，参数值不是有效SQL：sqlParam.key="+key);
			} 
			params.put(key, value);
			return params;
		}
		//向前节点获取（用于节点构造）
		if(paramType.equals("4") && otherParams != null){
			//value = otherParams.get(key);
			logger.debug("参数类型为4，参数值来自前节点：sqlParam.key="+key+" value="+value);
			params.put(key, otherParams.get(value));
			return params;
		}else{
			logger.info("参数类型: "+paramType+" 不支持");
			return null;
		}
	}
	/**
	 * 根据类型获取字符串值
	 * @param obj
	 * @return
	 */
	private String getValueByType(Object obj){
		if(obj == null){
			return null;
		}
		if(obj instanceof java.lang.String){
			return (String) obj;
		}
		if(obj instanceof java.math.BigInteger){
			return obj.toString();
		}
		if(obj instanceof java.math.BigDecimal){
			return obj.toString();
		}
		return obj.toString();
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SqlParamService#getSqlBySqlId(java.math.BigDecimal, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public String getSqlBySqlId(BigDecimal sqlId, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		//获取SQL
		List<TDefSqlInfo> sqlInfos = tDefSqlInfoMapper.selectBySqlIdWithBLOBs(sqlId);
		String sql = sqlInfos.get(0).getSqlInfo();
		if(sql == null || sql.trim().equals("")){
			return null;
		}
		//获取SQL对应的参数
		Map<String,String> sqlParams = new HashMap<String,String>();
		//初始化本地参数
		sqlParams.putAll(initDefaultParams(pojo));
		TDefSqlParamsExample exampleParams = new TDefSqlParamsExample();
		exampleParams.createCriteria().andSqlIdEqualTo(sqlId);
		//初始化指定参数
		sqlParams.putAll(initParams(exampleParams,pojo));
		sql = doSqlParamed(sql,sqlParams);
		return sql;
	}
	
	@Override
	public String getSqlBySqlId(BigDecimal sqlId, ParamPOJO pojo,Map<String,String> param) {
		//获取SQL
		List<TDefSqlInfo> sqlInfos = tDefSqlInfoMapper.selectBySqlIdWithBLOBs(sqlId);
		String sql = sqlInfos.get(0).getSqlInfo();
		if(sql == null || sql.trim().equals("")){
			return null;
		}
		//获取SQL对应的参数
		Map<String,String> sqlParams = new HashMap<String,String>();
		//初始化本地参数
		sqlParams.putAll(initDefaultParams(pojo));
		TDefSqlParamsExample exampleParams = new TDefSqlParamsExample();
		exampleParams.createCriteria().andSqlIdEqualTo(sqlId);
		//初始化指定参数
		sqlParams.putAll(initParams(exampleParams,pojo));
		//初始化自定义参数
		if(param != null && !param.values().isEmpty()){
			sqlParams.putAll(param);
		}
		sql = doSqlParamed(sql,sqlParams);
		return sql;
	}
	/**
	 * 获取SQL<br>
	 * 注意：<br>
	 * 1、调用前若有需要请先调用：getSysParams 初始化系统参数的方法获取到系统参数<br>
	 * 2、也可以传递自定义的参数进入,自定义的级别优先配置的级别
	 * @param sqlId
	 * @param pojo
	 * @param selfParam
	 * @return
	 */
	@Override
	public String getSql(BigDecimal sqlId,ParamPOJO pojo,Map<String,String> selfParam){
		//TODO 获取SQL
		List<TDefSqlInfo> sqlInfos = tDefSqlInfoMapper.selectBySqlIdWithBLOBs(sqlId);
		String sql = sqlInfos.get(0).getSqlInfo();
		if(sql == null || sql.trim().equals("")){
			return null;
		}
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String> sqlParams = getSqlParams(sqlId, pojo,selfParam);
		params.putAll(getSysParams(pojo));//系统参数级别最低，默认
		params.putAll(sqlParams);//其次级别是SQL对应的参数
		if(!selfParam.isEmpty()){
			params.putAll(selfParam);//最后是自定义参数
		}
		//如果按日期取查询到batchNo,那么系统已经初始化的参数中不会再更新batchNo的值，故加之
		if(params.get("batchNo") == "" || params.get("batchNo") == null){
			params.put("batchNo", pojo.getBatchNo());
		}
		sql = doSqlParamed(sql,params);
		return sql;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SqlParamService#initDefaultParams(com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public Map<String, String> initDefaultParams(ParamPOJO pojo) {
		// TODO initDefaultParams
		TDefSqlParamsExample example = new TDefSqlParamsExample();
		TDefSqlParamsExample.Criteria criteria = example.createCriteria();
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		criteria.andParamSubTypeEqualTo(Short.parseShort("0"));//系统默认
		defaultParams.putAll(initParams(example,pojo));
		logger.debug("init system default parameters ： "+defaultParams.toString());
		return defaultParams;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SqlParamService#initParams(com.sinosoft.ummp.domain.model.TDefSqlParamsExample, com.sinosoft.platform.core.domain.pojo.ParamPOJO, java.util.Map)
	 */
	@Override
	public Map<String, String> initParams(TDefSqlParamsExample example,
			ParamPOJO pojo, Map<String, String> otherParam) {
		// TODO 参数获取
		Map<String,String> params = new HashMap<String,String>();
		List<TDefSqlParams> sqlParams = tDefSqlParamsMapper.selectByExample(example);
		for(TDefSqlParams sqlParam : sqlParams){
			String key = sqlParam.getParamCode();//参数编码
			String valueType = sqlParam.getParamValueType();//参数值类型
			String value = sqlParam.getParamValue();//参数值：用于默认
			/**
			描述参数类型 
		    0：参数屏蔽，设置空 
			1：取其外部传入POJO的值，默认 
			2：参数通过可执行SQL获得 
			3：取其Value对应的值(固定值)
			4：向前节点获取（用于节点构造）
			**/
			String paramType = sqlParam.getParamType();
			logger.debug("- paramType："+paramType);
			logger.debug("- valueType："+valueType);
			//参数屏蔽，设置空 
			Map<String,String> tMap = _initParam(paramType,key,value,pojo,otherParam);
			if(tMap != null){
				params.putAll(tMap);
			}
		}
		return params;
	}

	@Override
	public Map<String, String> getDefaultParam() {
		// TODO Auto-generated method stub
		return defaultParams;
	}

	@Override
	public void setDefaultParam(Map<String, String> dm) {
		// TODO Auto-generated method stub
		//defaultParams.clear();
		defaultParams.putAll(dm);
	}
}
