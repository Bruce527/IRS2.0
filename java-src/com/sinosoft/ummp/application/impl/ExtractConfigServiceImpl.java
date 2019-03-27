/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import oracle.sql.CLOB;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.TDefJdbcMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefJdbcExample;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlExample;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlInfoExample;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.domain.model.TDefSqlParamsExample;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.ExtractConfigService;
import com.sinosoft.ummp.domain.mapper.TDefTransexcActionMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcAfterMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcBeforeMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcMapper;
import com.sinosoft.ummp.domain.model.TDefTransexc;
import com.sinosoft.ummp.domain.model.TDefTransexcAction;
import com.sinosoft.ummp.domain.model.TDefTransexcActionExample;
import com.sinosoft.ummp.domain.model.TDefTransexcAfter;
import com.sinosoft.ummp.domain.model.TDefTransexcAfterExample;
import com.sinosoft.ummp.domain.model.TDefTransexcBefore;
import com.sinosoft.ummp.domain.model.TDefTransexcBeforeExample;
import com.sinosoft.ummp.domain.model.TDefTransexcExample;
import com.sinosoft.ummp.exception.CISException;



/**
 * 提数配置实现层
 * @author Darker.Wang
 * @date 2016-9-1 上午10:40:57
 * @company SINOSOFT
 */
@Service
public class ExtractConfigServiceImpl implements ExtractConfigService {

	@Autowired
	private CommonServiceMapper commonServiceMapper;
	@Autowired
	private TDefJdbcMapper  tDefJdbcMapper;
	@Autowired
	private TDefSqlMapper  tDefSqlMapper;
	@Autowired
	private TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired
	private TDefSqlParamsMapper tDefSqlParamsMapper;
	@Autowired
	private TDefTransexcMapper tDefTransexcMapper;
	@Autowired
	private TDefTransexcBeforeMapper  tDefTransexcBeforeMapper;
	@Autowired
	private TDefTransexcActionMapper  tDefTransexcActionMapper;
	@Autowired
	private TDefTransexcAfterMapper   tDefTransexcAfterMapper;
	
	@Override
	@Transactional
	public BigDecimal saveGetDataSqlConfigInfo(String param,LoginInfo loginInfo) throws CISException {
		
		JSONObject jo = JSONObject.fromObject(param);
		
		String transportType = (String) jo.get("transportType");     //传输类型的ID
		String targetTableName = (String) jo.get("targetTableName"); //目标表名
		String sqlCode = (String) jo.get("sqlCode");                 //算法编码
		String dataSourceName = (String) jo.get("dataSourceName");   //数据源名称
		String targetDatabase = (String) jo.get("targetDatabase");   //目标数据库
		String sqlType = (String) jo.get("sqlType");                 //提取类型
		String validity = (String) jo.get("validity");               //有效性
		String sql = (String) jo.get("sql");                         // SQL
		String desc = (String) jo.get("desc");                       //描述
		String order = (String) jo.get("order");                     //执行顺序
		String flag = (String) jo.get("flag");                       //子类型
		
		
		//获取主键
		BigDecimal sqlId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL");
		//获取主键
		BigDecimal sqlInfoId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_INFO");
		
		
		//获取主键
		BigDecimal beforeId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_TRANSEXC_BEFORE"); //传输配置
		//获取主键
		BigDecimal actionId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_TRANSEXC_ACTION"); //传输配置
		//获取主键
		BigDecimal aftefId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_TRANSEXC_AFTER"); //传输配置

		
		TDefSqlExample tDefSqlExample = new TDefSqlExample();
		tDefSqlExample.createCriteria().andSqlCodeEqualTo(sqlCode);
		List<TDefSql> tDefSqls = this.tDefSqlMapper.selectByExample(tDefSqlExample);
		if(tDefSqls!= null && tDefSqls.size()>=1){
			throw new CISException("该算法编码已存在，请重新定义！");
		}
		
		
		if(flag.equals("DATA_TRANSPORT_AGO_CONFIG")){
			TDefTransexcBeforeExample example11 = new TDefTransexcBeforeExample();
			example11.createCriteria().andExcNumEqualTo(new Long(order)).andExcIdEqualTo(new BigDecimal(transportType));
			List<TDefTransexcBefore>  tDefTransexcBefores = this.tDefTransexcBeforeMapper.selectByExample(example11);
			if(tDefTransexcBefores!=null&&tDefTransexcBefores.size()>=1){
				throw new CISException("执行顺序重复,请重新填写!");
			}
		}else if(flag.equals("DATA_TRANSPORT_CONFIG")){
			TDefTransexcActionExample example = new TDefTransexcActionExample();
			example.createCriteria().andExcNumEqualTo(new Long(order)).andExcIdEqualTo(new BigDecimal(transportType));
			List<TDefTransexcAction> selectByExample = this.tDefTransexcActionMapper.selectByExample(example  );
			if(selectByExample!=null&&selectByExample.size()>=1){
				throw new CISException("执行顺序重复,请重新填写!");
			}
		}else{
			TDefTransexcAfterExample example = new TDefTransexcAfterExample();
			example.createCriteria().andExcNumEqualTo(new Long(order)).andExcIdEqualTo(new BigDecimal(transportType));
			List<TDefTransexcAfter> selectByExample = this.tDefTransexcAfterMapper.selectByExample(example );
			if(selectByExample!=null&&selectByExample.size()>=1){
				throw new CISException("执行顺序重复,请重新填写!");
			}
		}
		
		
		TDefJdbcExample example = new TDefJdbcExample();
		example.createCriteria().andJdbcCodeEqualTo(dataSourceName);
		List<TDefJdbc> tDefJdbcs = this.tDefJdbcMapper.selectByExample(example);
		BigDecimal jdbcId = null;      				//获取jdbc的主键
		if(tDefJdbcs!=null && tDefJdbcs.size()>0){
			jdbcId = tDefJdbcs.get(0).getId();
		}
		
		
		TDefJdbcExample example1 = new TDefJdbcExample();
		example1.createCriteria().andJdbcCodeEqualTo(targetDatabase);
		List<TDefJdbc> tDefJdbcs1 = this.tDefJdbcMapper.selectByExample(example1);
		
		
		TDefSql tDefSql = new TDefSql();
		tDefSql.setSqlId(sqlId);                       //P
		tDefSql.setComId(loginInfo.getCompanyId());    //机构ID
		tDefSql.setInsertTime(new Date());             //入库时间
		tDefSql.setOperator(loginInfo.getUserCode());  //用户code
		tDefSql.setEsStatus(new Short(validity));      //有效性
		tDefSql.setSqlDesc(desc);                      //描述信息
		tDefSql.setSqlCode(sqlCode);                   //算法编码
		tDefSql.setSqlInto(dataSourceName);            //数据源名称      
		tDefSql.setSqlType(sqlType);                  //提取类型
		tDefSql.setSqlFromJdbcId(jdbcId);              //F 
		tDefSql.setSqlFrom(dataSourceName);
		tDefSql.setSqlIntoJdbcId(tDefJdbcs1.get(0).getId());//F
		tDefSql.setSqlInto(targetDatabase);
		tDefSql.setSqlIntoTargetTable(targetTableName); //目标表名
		tDefSql.setSubBussType(flag);                   //子类型
		this.tDefSqlMapper.insert(tDefSql);  			//入库操作    
		
		TDefSqlInfo tDefSqlInfo = new TDefSqlInfo();
		tDefSqlInfo.setId(sqlInfoId);                  	//P
		tDefSqlInfo.setSqlType(sqlType);
		tDefSqlInfo.setSqlId(sqlId);                    //F 
		tDefSqlInfo.setSqlInfo(sql);					//sql
		this.tDefSqlInfoMapper.insert(tDefSqlInfo);     //入库操作    
		
		if(flag.equals("DATA_TRANSPORT_AGO_CONFIG")){
			
			TDefTransexcBefore tDefTransexcBefore = new TDefTransexcBefore();
			tDefTransexcBefore.setId(beforeId);                         //p
			tDefTransexcBefore.setExcId(new BigDecimal(transportType)); //F
			tDefTransexcBefore.setSqlId(sqlId);                         //F
			tDefTransexcBefore.setExcNum(new Long(order));				//执行顺序
			tDefTransexcBefore.setRcStatus(new Short(validity));		//有效性	
			this.tDefTransexcBeforeMapper.insert(tDefTransexcBefore);   //入库传输前
			
		}else if(flag.equals("DATA_TRANSPORT_CONFIG")){
			
			TDefTransexcAction tDefTransexcAction = new TDefTransexcAction();
			tDefTransexcAction.setId(actionId);							 //P
			tDefTransexcAction.setExcId(new BigDecimal(transportType));  //F
			tDefTransexcAction.setSqlId(sqlId); 						 //F
			tDefTransexcAction.setExcNum(new Long(order)); 				//执行顺序
			tDefTransexcAction.setRcStatus(new Short(validity));        //有效性	
			this.tDefTransexcActionMapper.insert(tDefTransexcAction );  //入库传输中
			
		}else{

			TDefTransexcAfter tDefTransexcAfter = new TDefTransexcAfter();
			tDefTransexcAfter.setId(aftefId);							//P
			tDefTransexcAfter.setExcId(new BigDecimal(transportType));	//F
			tDefTransexcAfter.setSqlId(sqlId);							//F
			tDefTransexcAfter.setRcStatus(new Short(validity)); 		//有效性
			tDefTransexcAfter.setExcNum(new Long(order));				//执行顺序
			this.tDefTransexcAfterMapper.insert(tDefTransexcAfter);     //入库传输后
			
		}
		return sqlId;
	}


	@Override
	@Transactional
	public void addConfigInfo(String param, LoginInfo loginInfo) {
		
		JSONObject jo = JSONObject.fromObject(param);
		
//		String transportType1 = (String) jo.get("transportType1");  //传输类型
		String transport = (String) jo.get("transport");            //传输方式
		String targetTableName = (String) jo.get("targetTableName");//目标表名
		String executionOrder = (String) jo.get("executionOrder");  //执行顺序
//		String sourceDatabase = (String) jo.get("sourceDatabase");  //源数据库
//		String targetDatabase = (String) jo.get("targetDatabase");  //目标数据库
//		String targetTablePk = (String) jo.get("targetTablePk");    //目标表主键名称
//		String sequence = (String) jo.get("sequence");              //sequence名称
		String validity = (String) jo.get("validity");				//是否有效
		String querysql = (String) jo.get("querysql");              //查询SQL
		String desc = (String) jo.get("desc");                      //描述
		
		
		//获取主键
		BigDecimal sqlId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL");
		//获取主键
		BigDecimal sqlInfoId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_INFO");
		//获取主键
		BigDecimal sqlParamId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_PARAMS");

		
		TDefSql tDefSql = new TDefSql();
		tDefSql.setSqlId(sqlId);
		tDefSql.setBussType(transport);
		tDefSql.setSqlNum(new Long(executionOrder));
		tDefSql.setComId(loginInfo.getCompanyId());
		tDefSql.setInsertTime(new Date());
		tDefSql.setOperator(loginInfo.getUserCode());
		tDefSql.setEsStatus(new Short(validity));
		tDefSql.setSqlDesc(desc);
		tDefSql.setSqlIntoTargetTable(targetTableName);
		this.tDefSqlMapper.insert(tDefSql);
		
		TDefSqlInfo tDefSqlInfo = new TDefSqlInfo();
		tDefSqlInfo.setId(sqlInfoId);
		tDefSqlInfo.setSqlId(sqlId);
		tDefSqlInfo.setSqlInfo(querysql);
		this.tDefSqlInfoMapper.insert(tDefSqlInfo);
		
		TDefSqlParams tDefSqlParams = new TDefSqlParams();
		tDefSqlParams.setId(sqlParamId);
		tDefSqlParams.setSqlId(sqlId);
		this.tDefSqlParamsMapper.insert(tDefSqlParams);
		
	}


	@Override
	@Transactional
	public void saveDataTransportAgoConfigInfo(String param, LoginInfo loginInfo) {
		
		JSONObject jo = JSONObject.fromObject(param);
		
//		String transportType = (String) jo.get("transportType");    //传输类型
		String executionOrder = (String) jo.get("executionOrder");  //执行顺序
//		String dataSourceName = (String) jo.get("dataSourceName");  //目标表名
		String executeSql = (String) jo.get("executeSql");          //执行SQL
		String desc = (String) jo.get("desc");                      //描述
		
		
		//获取主键
		BigDecimal sqlId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL");
		//获取主键
		BigDecimal sqlInfoId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_INFO");
		//获取主键
		BigDecimal sqlParamId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_PARAMS");

		
		TDefSql tDefSql = new TDefSql();
		tDefSql.setSqlId(sqlId);
		tDefSql.setSqlNum(new Long(executionOrder));
		tDefSql.setComId(loginInfo.getCompanyId());
		tDefSql.setInsertTime(new Date());
		tDefSql.setOperator(loginInfo.getUserCode());
		tDefSql.setSqlDesc(desc);
		this.tDefSqlMapper.insert(tDefSql);
		
		TDefSqlInfo tDefSqlInfo = new TDefSqlInfo();
		tDefSqlInfo.setId(sqlInfoId);
		tDefSqlInfo.setSqlId(sqlId);
		tDefSqlInfo.setSqlInfo(executeSql);
		this.tDefSqlInfoMapper.insert(tDefSqlInfo);
		
		TDefSqlParams tDefSqlParams = new TDefSqlParams();
		tDefSqlParams.setId(sqlParamId);
		tDefSqlParams.setSqlId(sqlId);
		this.tDefSqlParamsMapper.insert(tDefSqlParams);
		
		
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map<String, Object> queryTransportList(DataGridModel dgm,String param) {
		Map paramMap = new HashMap();
		Map<String,Object> result = new HashMap<String, Object>();
		
		String transportType = null;
		String transportDesc = null;
		BigDecimal comId=null;
		
		if(StringUtils.isNotBlank(param)&&!param.equals("{}")){
			JSONObject jo = JSONObject.fromObject(param);
			 transportType = (String) jo.get("transportType");
			 transportDesc = (String) jo.get("transportDesc");
			 if((String) jo.get("comId") != null){
				 comId=new BigDecimal((String)jo.get("comId"));
			 }
		}
		
		paramMap.put("transportType", transportType);
		paramMap.put("transportDesc", transportDesc);
		paramMap.put("comId", comId);
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		
		int total = this.tDefTransexcMapper.countTransport(paramMap);
		List<TDefTransexc> list  = this.tDefTransexcMapper.getTransportInfoList(paramMap);
		
		result.put("total", total);
		result.put("rows", list);
		return result;
	}


	@Override
	@Transactional
	public void updateTransportInfo(String param, LoginInfo loginInfo) {
		
		JSONObject jo = JSONObject.fromObject(param);
		String  excId = (String) jo.get("excId");
		String  excCode = (String) jo.get("excCode");
		String  excDesc = (String) jo.get("excDesc");
		
		TDefTransexc tDefTransexc = this.tDefTransexcMapper.selectByPrimaryKey(new BigDecimal(excId));
		if(tDefTransexc !=null ){
			tDefTransexc.setExcCode(excCode);
			tDefTransexc.setExcDesc(excDesc);
			this.tDefTransexcMapper.updateByPrimaryKeySelective(tDefTransexc );
		}
		
		
	}

	/////////////////////////////传输中配置/////////////////////////////////
	@SuppressWarnings("rawtypes")
	@Override
	public List getTransportType() {
		
		TDefTransexcExample tDefTransexcExample = new TDefTransexcExample();
		 List<TDefTransexc> tDefTransexcs = this.tDefTransexcMapper.selectByExample(tDefTransexcExample);
		 return tDefTransexcs;
	}


	@Override
	public Map<String, Object> getSqlCodeInfoById(BigDecimal id,String flag) {
		//TODO
		Map<String,Object> map = new HashMap<String,Object>();
	
		TDefTransexcBefore tDefTransexcBefore = null;

		TDefTransexcAction tDefTransexcAction = null;

		TDefTransexcAfter tDefTransexcAfter = null;
		
		if(flag.equals("DATA_TRANSPORT_AGO_CONFIG")){
			
			 tDefTransexcBefore = this.tDefTransexcBeforeMapper.selectByPrimaryKey(id);
			
		}else if(flag.equals("DATA_TRANSPORT_CONFIG")){
			
			 tDefTransexcAction = this.tDefTransexcActionMapper.selectByPrimaryKey(id);
			
		}else{
			
			 tDefTransexcAfter = this.tDefTransexcAfterMapper.selectByPrimaryKey(id);
		}
		
		
		
		BigDecimal sqlId = null;
		
		if(tDefTransexcBefore!= null){
			 sqlId = tDefTransexcBefore.getSqlId();
		}
		
		if(tDefTransexcAction!= null){
			 sqlId = tDefTransexcAction.getSqlId();
		}
		
		if(tDefTransexcAfter!= null){
			 sqlId = tDefTransexcAfter.getSqlId();
		}
		
		TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(sqlId);
		
		
		TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
		tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(sqlId);
		List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(tDefSqlInfoExample);
		TDefSqlInfo tDefSqlInfo = tDefSqlInfos.get(0);
		
		//获取数据源名称
		BigDecimal idd  =  tDefSql.getSqlFromJdbcId();  //null
		TDefJdbc tDefJdbc= this.tDefJdbcMapper.selectByPrimaryKey(idd);

		map.put("tDefTransexcBefore", tDefTransexcBefore);
		map.put("tDefTransexcAction", tDefTransexcAction);
		map.put("tDefTransexcAfter", tDefTransexcAfter);
		
		map.put("tDefSql", tDefSql);
		map.put("tDefSqlInfo", tDefSqlInfo);
		map.put("tDefJdbc", tDefJdbc);
		
		
		return map;
	}


	/**
	 * 更新
	 * @throws CISException 
	 */
	@Override
	@Transactional
	public void saveUpdateGetDataSqlConfigInfo(Map<String,Object> map, LoginInfo loginInfo) throws CISException {
		

		String PID = (String) map.get("PID");                        //PID
		String sqlId = (String) map.get("sqlId");                    //sqlId
		String transportType = (String) map.get("transportType");  //传输类型的ID
		String targetTableName = (String) map.get("targetTableName");//目标表名
		String sqlCode = (String) map.get("sqlCode");				 //算法编码
		String dataSourceName = (String) map.get("dataSourceName");  //数据源名称
		String targetDatabase = (String) map.get("targetDatabase");  //目标数据库
		String sqlType = (String) map.get("sqlType");  				 //sql类型
		String validity = (String) map.get("validity");    			 //有效性
		String sql = (String) map.get("sql");              			 // SQL
		String desc = (String) map.get("desc");                      //描述
		String order = (String) map.get("order");                    //排序字段
		String flag = (String) map.get("flag");                      //子类型        
		
		if(flag.equals("DATA_TRANSPORT_AGO_CONFIG")){
			TDefTransexcBeforeExample example11 = new TDefTransexcBeforeExample();
			example11.createCriteria().andExcNumEqualTo(new Long(order))
			.andExcIdEqualTo(new BigDecimal(transportType)).andSqlIdNotEqualTo(new BigDecimal(sqlId));
			List<TDefTransexcBefore>  tDefTransexcBefores = this.tDefTransexcBeforeMapper.selectByExample(example11);
			if(tDefTransexcBefores!=null&&tDefTransexcBefores.size()>=1){
				throw new CISException("执行顺序重复,请重新填写!");
			}
		}else if(flag.equals("DATA_TRANSPORT_CONFIG")){
			TDefTransexcActionExample example = new TDefTransexcActionExample();
			example.createCriteria().andExcNumEqualTo(new Long(order))
			.andExcIdEqualTo(new BigDecimal(transportType)).andSqlIdNotEqualTo(new BigDecimal(sqlId));
			List<TDefTransexcAction> selectByExample = this.tDefTransexcActionMapper.selectByExample(example  );
			if(selectByExample!=null&&selectByExample.size()>=1){
				throw new CISException("执行顺序重复,请重新填写!");
			}
		}else{
			TDefTransexcAfterExample example = new TDefTransexcAfterExample();
			example.createCriteria().andExcNumEqualTo(new Long(order))
			.andExcIdEqualTo(new BigDecimal(transportType)).andSqlIdNotEqualTo(new BigDecimal(sqlId));
			List<TDefTransexcAfter> selectByExample = this.tDefTransexcAfterMapper.selectByExample(example );
			if(selectByExample!=null&&selectByExample.size()>=1){
				throw new CISException("执行顺序重复,请重新填写!");
			}
		}
		
		
		
		/*先判断算法编码是否存在*/
		TDefSqlExample tDefSqlExample = new TDefSqlExample();
		tDefSqlExample.createCriteria().andSqlCodeEqualTo(sqlCode);
		List<TDefSql> tDefSqls = this.tDefSqlMapper.selectByExample(tDefSqlExample);
		if(tDefSqls!= null && tDefSqls.size()>=2){
			throw new CISException("该算法编码已存在，请重新定义！");
		}
		
		/*更新T_DEF_TRANSEXC_BEFORE表*/
		if(flag.equals("DATA_TRANSPORT_AGO_CONFIG")){
			TDefTransexcBefore tDefTransexcBefore = this.tDefTransexcBeforeMapper.selectByPrimaryKey(new BigDecimal(PID));
			tDefTransexcBefore.setExcNum(new Long(order));			 //更新执行顺序
			tDefTransexcBefore.setRcStatus(new Short(validity));     //更新有效性
			this.tDefTransexcBeforeMapper.updateByPrimaryKeySelective(tDefTransexcBefore);   
		/*更新T_DEF_TRANSEXC_ACTION表*/	
		}else if(flag.equals("DATA_TRANSPORT_CONFIG")){
			TDefTransexcAction tDefTransexcAction = this.tDefTransexcActionMapper.selectByPrimaryKey(new BigDecimal(PID));
			tDefTransexcAction.setExcNum(new Long(order));           //更新执行顺序
			tDefTransexcAction.setRcStatus(new Short(validity));     //更新有效性
			this.tDefTransexcActionMapper.updateByPrimaryKeySelective(tDefTransexcAction);  //传输中
		/*更新T_DEF_TRANSEXC_AFTER表*/		
		}else{
			TDefTransexcAfter tDefTransexcAfter = this.tDefTransexcAfterMapper.selectByPrimaryKey(new BigDecimal(PID));
			tDefTransexcAfter.setExcNum(new Long(order));			 //执行顺序
			tDefTransexcAfter.setRcStatus(new Short(validity));		 //有效性
			this.tDefTransexcAfterMapper.updateByPrimaryKeySelective(tDefTransexcAfter);    //传输后
			
		}
		
		
		
		TDefJdbcExample example = new TDefJdbcExample();
		example.createCriteria().andJdbcCodeEqualTo(dataSourceName);
		List<TDefJdbc> tDefJdbcs = this.tDefJdbcMapper.selectByExample(example);
		BigDecimal fromJdbcId = null;      				//获取jdbc的主键
		if(tDefJdbcs!=null && tDefJdbcs.size()>0){
			fromJdbcId = tDefJdbcs.get(0).getId();
		}
		
		
		TDefJdbcExample example1 = new TDefJdbcExample();
		example1.createCriteria().andJdbcCodeEqualTo(targetDatabase);
		List<TDefJdbc> tDefJdbcs1 = this.tDefJdbcMapper.selectByExample(example1);
		BigDecimal IntoJdbcId = null;      				//获取jdbc的主键
		if(tDefJdbcs!=null && tDefJdbcs1.size()>0){
			IntoJdbcId = tDefJdbcs1.get(0).getId();
		}
		
		
		
		/*更新T_DEF_SQL表字段*/
		TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(new BigDecimal(sqlId));
		
		tDefSql.setSqlCode(sqlCode);                                //更新算法编码
		tDefSql.setSqlType(sqlType);
		tDefSql.setSqlDesc(desc);									//更新算法描述
		tDefSql.setLastModifyTime(new Date());                      //更新修改时间
		tDefSql.setComId(loginInfo.getCompanyId());                 //更新机构ID
		tDefSql.setOperator(loginInfo.getUserCode());				//更新操作人编码
		tDefSql.setEsStatus(new Short(validity));					//更新状态
		tDefSql.setSqlIntoTargetTable(targetTableName);				//更新目标表
		tDefSql.setSqlIntoTargetTable(targetTableName);				//更新目标表
		tDefSql.setSqlFromJdbcId(fromJdbcId);                       //F 
		tDefSql.setSqlFrom(dataSourceName);                         //数据源名称
		tDefSql.setSqlIntoJdbcId(IntoJdbcId);        				//F
		tDefSql.setSqlInto(targetDatabase);							//目标数据源名称
		this.tDefSqlMapper.updateByPrimaryKeySelective(tDefSql);
		
		
		/*更新T_DEF_SQL_INFO表字段*/
		TDefSqlInfo tDefSqlInfo = new TDefSqlInfo();
		TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
		tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(new BigDecimal(sqlId));
		List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExample(tDefSqlInfoExample );
		TDefSqlInfo TDefSqlInfo = tDefSqlInfos.get(0);
		BigDecimal  sqlInfoId = TDefSqlInfo.getId();
		
		tDefSqlInfo.setId(sqlInfoId);       
		tDefSqlInfo.setSqlType(sqlType);
		tDefSqlInfo.setSqlInfo(sql);                              //SQL脚本
		this.tDefSqlInfoMapper.updateByPrimaryKeySelective(tDefSqlInfo);
		
	}


	@Override
	public Map<String, Object> dataTransportAgoTable(DataGridModel dgm,String queryParam) throws SQLException, IOException {
		
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		paramMap.put("id", new BigDecimal(queryParam));
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		
		int total = this.tDefTransexcMapper.dataTransportAgoTableCounts(paramMap);
		List<Map<String, Object>> lists  = this.tDefTransexcMapper.dataTransportAgoTableList(paramMap);
		for (Map<String, Object> map : lists) {
			CLOB value = (CLOB) map.get("sqlInfo");
			if(value!=null){
				map.put("sqlInfo", ClobToString(value));
			}
		}
		
		result.put("total", total);
		result.put("rows", lists);
		
		return result;
	}

	@Override
	public Map<String, Object> dataTransportConfigTable(DataGridModel dgm,String queryParam) throws SQLException, IOException {
		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		paramMap.put("id", new BigDecimal(queryParam));
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		
		int total = this.tDefTransexcMapper.dataTransportConfigTableCounts(paramMap);
		List<Map<String, Object>> lists  = this.tDefTransexcMapper.dataTransportConfigTableList(paramMap);
		
		result.put("total", total);
		result.put("rows", lists);
		
		return result;
		
	}
	
	@Override
	public Map<String, Object> dataTransportAfterTable(DataGridModel dgm,String queryParam) throws SQLException, IOException {

		Map<String,Object> paramMap = new HashMap<String,Object>();
		
		Map<String,Object> result = new HashMap<String, Object>();
		
		paramMap.put("id", new BigDecimal(queryParam));
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		
		int total = this.tDefTransexcMapper.dataTransportAfterTableCounts(paramMap);
		List<Map<String, Object>> lists  = this.tDefTransexcMapper.dataTransportAfterTableList(paramMap);
		for (Map<String, Object> map : lists) {
			CLOB value = (CLOB) map.get("sqlInfo");
			if(value!=null){
				map.put("sqlInfo", ClobToString(value));
			}
		}
		
		result.put("total", total);
		result.put("rows", lists);
		
		return result;
	}


	@Override
	public void deleteDataTransportConfigById(BigDecimal id,Integer num) {
		
		
		//先查询后删除
		TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(id);
		
		if(num == 1){
			
			TDefTransexcBeforeExample tDefTransexcBeforeExample = new TDefTransexcBeforeExample();
			tDefTransexcBeforeExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
			this.tDefTransexcBeforeMapper.deleteByExample(tDefTransexcBeforeExample);
			
		}else if(num == 2){
			
			TDefTransexcActionExample tDefTransexcActionExample = new TDefTransexcActionExample();
			tDefTransexcActionExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
			this.tDefTransexcActionMapper.deleteByExample(tDefTransexcActionExample );
			
		}else{
			
			TDefTransexcAfterExample tDefTransexcAfterExample = new TDefTransexcAfterExample();
			tDefTransexcAfterExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
			this.tDefTransexcAfterMapper.deleteByExample(tDefTransexcAfterExample);
		}
		
		this.tDefSqlMapper.deleteByPrimaryKey(tDefSql.getSqlId());
		
		TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
		tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
		this.tDefSqlInfoMapper.deleteByExample(tDefSqlInfoExample);
		
		TDefSqlParamsExample tDefSqlParamsExample = new TDefSqlParamsExample();
		tDefSqlParamsExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
		this.tDefSqlParamsMapper.deleteByExample(tDefSqlParamsExample);
		
	}


	@Override
	public void saveSqlParam(Integer flag, TDefSqlParams params) throws CISException {

		if(flag==0){//新增
			TDefSqlParamsExample example=new TDefSqlParamsExample();
			TDefSqlParamsExample.Criteria criteria = example.createCriteria();
				 criteria.andSqlIdEqualTo(params.getSqlId()).andParamCodeEqualTo(params.getParamCode());
			List<TDefSqlParams> list = tDefSqlParamsMapper.selectByExample(example);
			if(list !=null && list.size()>0){
				throw new CISException("参数："+params.getParamName()+"已经存在！");
			}
			BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_PARAMS");
			params.setId(id);
			params.setEsStatus((short) 1);
			this.tDefSqlParamsMapper.insert(params);
		}else{//修改
			TDefSqlParamsExample example1=new TDefSqlParamsExample();
			example1.createCriteria().andIdEqualTo(params.getId());
			params.setEsStatus((short) 1);
			tDefSqlParamsMapper.updateByExample(params, example1);
		}
	
		
	}

	private String ClobToString(CLOB clob) throws SQLException, IOException{
		String date = null; 
		Reader r = clob.getCharacterStream();
		char[] c = new char[(int) (clob.length())];
		r.read(c);
		date = new String(c);
		return date;
	}


	@Override
	@Transactional
	public void saveUpdate(TDefTransexc tDefTransexc,LoginInfo loginInfo) throws CISException {
		
		TDefTransexcExample example = new TDefTransexcExample();
		example.createCriteria().andComIdEqualTo(tDefTransexc.getComId()).andExcCodeEqualTo(tDefTransexc.getExcCode());
		List<TDefTransexc> tDefTransexcs = this.tDefTransexcMapper.selectByExample(example);
		if(tDefTransexcs.size()>=1){
			throw new CISException("传输类型重复、请重新填写");
		}
		
		TDefTransexcExample example1 = new TDefTransexcExample();
		example1.createCriteria().andComIdEqualTo(tDefTransexc.getComId()).andExcNumEqualTo(tDefTransexc.getExcNum());
		List<TDefTransexc> tDefTransexcs1 = this.tDefTransexcMapper.selectByExample(example1);
		if(tDefTransexcs1.size()>=1){
			throw new CISException("执行排序重复、请重新填写");
		}
		
		BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_TRANSEXC");
		tDefTransexc.setExcId(id);
//		tDefTransexc.setComId(loginInfo.getCompanyId());
		tDefTransexc.setInsertTime(new Date());
//		tDefTransexc.setRcStatus((short)1);
		tDefTransexc.setOperator(loginInfo.getUserCode());
		this.tDefTransexcMapper.insert(tDefTransexc);
	}


	@Override
	public TDefTransexc getById(BigDecimal id) {
		TDefTransexc tDefTransexc = this.tDefTransexcMapper.selectByPrimaryKey(id);
		return tDefTransexc;
	}


	@Override
	@Transactional
	public void updateSave(TDefTransexc tDefTransexc, LoginInfo loginInfo) throws CISException {
		
		TDefTransexcExample example = new TDefTransexcExample();
		example.createCriteria().andComIdEqualTo(tDefTransexc.getComId()).andExcCodeEqualTo(tDefTransexc.getExcCode())
		.andExcIdNotEqualTo(tDefTransexc.getExcId());
		List<TDefTransexc> tDefTransexcs = this.tDefTransexcMapper.selectByExample(example);
		if(tDefTransexcs.size()>0){
			throw new CISException("传输类型重复、请重新填写");
		}
		
		TDefTransexcExample example1 = new TDefTransexcExample();
		example1.createCriteria().andComIdEqualTo(tDefTransexc.getComId()).andExcNumEqualTo(tDefTransexc.getExcNum())
		.andExcIdNotEqualTo(tDefTransexc.getExcId());
		List<TDefTransexc> tDefTransexcs1 = this.tDefTransexcMapper.selectByExample(example1);
		if(tDefTransexcs1.size()>0){
			throw new CISException("执行排序重复、请重新填写");
		}
		
//		tDefTransexc.setComId(loginInfo.getCompanyId());
		tDefTransexc.setLastModifyTime(new Date());
		tDefTransexc.setOperator(loginInfo.getUserCode());
		this.tDefTransexcMapper.updateByPrimaryKeySelective(tDefTransexc);
	}

	/**
	 * 一旦删除传输，将删除所有的传输配置，包括sql,以及sql的参数
	 * @throws CoreException 
	 */
	@Override
	@Transactional
	public int deleById(List<BigDecimal> ids,String flag) throws CoreException {
		List<BigDecimal> sqlIds=new ArrayList<BigDecimal>();
		//查询出所有的sql_id
		for(BigDecimal id:ids){
			TDefTransexcBeforeExample aa=new TDefTransexcBeforeExample();
			aa.createCriteria().andExcIdEqualTo(id);
			List<TDefTransexcBefore> before = this.tDefTransexcBeforeMapper.selectByExample(aa);
			for(TDefTransexcBefore bb:before){
				if(bb.getSqlId() != null && !sqlIds.contains(bb.getSqlId())){
					sqlIds.add(bb.getSqlId());
				}
			}
			
			TDefTransexcActionExample ee=new TDefTransexcActionExample();
			ee.createCriteria().andExcIdEqualTo(id);
			List<TDefTransexcAction> list = this.tDefTransexcActionMapper.selectByExample(ee);
			for(TDefTransexcAction action:list){
				if(action.getSqlId() != null && !sqlIds.contains(action.getSqlId())){
					sqlIds.add(action.getSqlId());
				}
			}
			
			TDefTransexcAfterExample dd=new TDefTransexcAfterExample();
			dd.createCriteria().andExcIdEqualTo(id);
			List<TDefTransexcAfter> list2 = this.tDefTransexcAfterMapper.selectByExample(dd);
			for(TDefTransexcAfter after:list2){
				if(after.getSqlId() != null && !sqlIds.contains(after.getSqlId())){
					sqlIds.add(after.getSqlId());
				}
			}
		}
		int count = 0;
		if(sqlIds.isEmpty() && flag == null){
			for(BigDecimal id:ids){
				//删除传输t_def_transexc
				this.tDefTransexcMapper.deleteByPrimaryKey(id);
				count++;
			}
			return count;
		}else if(!sqlIds.isEmpty() && flag == null){
			throw new CoreException("该传输类型已配置SQL,确认删除？");
		}else{
			for(BigDecimal id:ids){
				//删除t_def_transexc_before
				TDefTransexcBeforeExample before=new TDefTransexcBeforeExample();
				before.createCriteria().andExcIdEqualTo(id);
				List<TDefTransexcBefore> list = tDefTransexcBeforeMapper.selectByExample(before);
				if(!list.isEmpty()){
					tDefTransexcBeforeMapper.deleteByExample(before);
				}
				
				//删除t_def_transexc_action
				TDefTransexcActionExample exa=new TDefTransexcActionExample();
				exa.createCriteria().andExcIdEqualTo(id);
				List<TDefTransexcAction> example = tDefTransexcActionMapper.selectByExample(exa);
				if(!example.isEmpty()){
					tDefTransexcActionMapper.deleteByExample(exa);
				}
				
				//删除t_def_transexc_after
				TDefTransexcAfterExample after=new TDefTransexcAfterExample();
				after.createCriteria().andExcIdEqualTo(id);
				List<TDefTransexcAfter> list2 = tDefTransexcAfterMapper.selectByExample(after);
				if(!list2.isEmpty()){
					tDefTransexcAfterMapper.deleteByExample(after);
				}
				
				//删除传输t_def_transexc
				this.tDefTransexcMapper.deleteByPrimaryKey(id);
				count++;
			}
			
			for(BigDecimal id:sqlIds){
				//删除配置参数
				TDefSqlParamsExample params=new TDefSqlParamsExample();
				params.createCriteria().andSqlIdEqualTo(id);
				List<TDefSqlParams> example = tDefSqlParamsMapper.selectByExample(params);
				if(!example.isEmpty()){
					tDefSqlParamsMapper.deleteByExample(params);
				}
				//删除SQL_info
				TDefSqlInfoExample info=new TDefSqlInfoExample();
				info.createCriteria().andSqlIdEqualTo(id);
				List<TDefSqlInfo> list = this.tDefSqlInfoMapper.selectByExample(info);
				if(!list.isEmpty()){
					this.tDefSqlInfoMapper.deleteByExample(info);
				}
				
				//删除SQL
				TDefSql key = tDefSqlMapper.selectByPrimaryKey(id);
				if(key != null){
					tDefSqlMapper.deleteByPrimaryKey(id);
				}
			}
			return count;
		}
	}


	@Override
	public List<TDefTransexc> queryTransType() {
		TDefTransexcExample example = new TDefTransexcExample();
		return this.tDefTransexcMapper.selectByExample(example);
	}


	@Override
	public String getTransDesc(BigDecimal excId) {
		TDefTransexc tDefTransexc = this.tDefTransexcMapper.selectByPrimaryKey(excId);
		return tDefTransexc.getExcDesc();
	}


	@Override
	public List<Map> queryListInfo(BigDecimal comId) {
		Map map=new HashMap();
		map.put("comId", comId);
		return tDefTransexcMapper.queryListInfo(map);
	}
	
	
}
