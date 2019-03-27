package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.PubFun;
import com.sinosoft.ummp.application.ExpinfoService;
import com.sinosoft.ummp.application.ExtractService;
import com.sinosoft.ummp.domain.mapper.TPrpLcquotadataMapper;
import com.sinosoft.ummp.domain.model.TPrpLcquotadata;
import com.sinosoft.ummp.domain.model.TPrpLcquotadataExample;
@Service("expinfoService")
public class ExpinfoServiceImpl implements ExpinfoService {

	@Autowired
	private TPrpLcquotadataMapper tPrpLcquotadataMapper;
	@Autowired
	private SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	private TDefCodeDictMapper tDefCodeDictMapper;
	/*
	@Autowired
	private TDefSqlMapper  tDefSqlMapper;
	@Autowired
	private TDefJdbcMapper  tDefJdbcMapper;
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
	@Autowired
	private DefUserMapper defUserMapper;
	@Autowired
	private CommonServiceMapper commonServiceMapper;
	@Autowired
	private SqlParamService sqlParamService;
	*/
	@Autowired
	ExtractService extractService;
	
	private SqlAdapter sqlAdapter = new SqlAdapter();
	private String years;

	//@Transactional 加上事务注解导致不能切换数据源
	@Override
	public boolean extract(ParamPOJO pojo, BigDecimal excId) throws Exception {
		String tBatchNo = "TN-"+DateUtils.getCurrentDateAndTime();
		extractService.setBatchNo(tBatchNo);
		return extractService.extract(pojo, excId);
		/*
		resultMap.clear();
		传输前操作
		boolean agoFlag = true;
		TDefTransexc tDefTransexc = this.tDefTransexcMapper.selectByPrimaryKey(ExcId);  	    //根据传输类型主键查询传输对象
		BigDecimal excId = tDefTransexc.getExcId();                                             //获取传输类型的主键                                         
		TDefTransexcBeforeExample tDefTransexcBeforeExample = new TDefTransexcBeforeExample();
		tDefTransexcBeforeExample.createCriteria().andExcIdEqualTo(excId);
		tDefTransexcBeforeExample.setOrderByClause("EXC_NUM");
	    List<TDefTransexcBefore> tDefTransexcBefores = this.tDefTransexcBeforeMapper.selectByExample(tDefTransexcBeforeExample);
		for (TDefTransexcBefore tDefTransexcBefore : tDefTransexcBefores) {
			try{
				BigDecimal sqlId = tDefTransexcBefore.getSqlId();
				TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
				tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(sqlId);
				List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(tDefSqlInfoExample);
				for (TDefSqlInfo tDefSqlInfo : tDefSqlInfos) {
					String transAgosql = tDefSqlInfo.getSqlInfo();     //传输前sql脚本  
					agoFlag = transAgo(transAgosql);                   //执行传输前操作【校验,清表操作】
				}
			}catch(Exception e){
				agoFlag = false;
				resultMap.put("msg", "fail");
				resultMap.put("errorCode", "extract");
				resultMap.put("errorMessage", "传输前执行失败");
				resultMap.put("errorFunc", "extract");
				resultMap.put("exceptionMessage", e.getMessage());
				DBContextHolder.recover();
				throw new CoreException("传输前执行失败");
			}
			
		}
		
		if(!agoFlag){
			return false;
		}
		
		传输中操作
		int exeFlag = 1;
		TDefTransexcActionExample tDefTransexcActionExample = new TDefTransexcActionExample();
		tDefTransexcActionExample.createCriteria().andExcIdEqualTo(excId);
		tDefTransexcActionExample.setOrderByClause("EXC_NUM");
		List<TDefTransexcAction> tDefTransexcActions = this.tDefTransexcActionMapper.selectByExample(tDefTransexcActionExample);
		Map<String,String> paramMap = null;
		int count = 0;
		int code = 0;
		for (TDefTransexcAction tDefTransexcAction : tDefTransexcActions) {
			paramMap = new HashMap<String,String>();        					//参数Map
			BigDecimal sqlId = tDefTransexcAction.getSqlId();                   //获取T_DEF_SQL表主键
			TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(sqlId);     //根据主键获取TDefSql对象
			BigDecimal sqlFromJdbcId = tDefSql.getSqlFromJdbcId();    		    //获取JDBC来源id
			BigDecimal sqlIntoJdbcId = tDefSql.getSqlIntoJdbcId();              //获取JDBC去向id
			String sqlFromJdbc = getDataSourceNameByJdbcId(sqlFromJdbcId);      //根据JDBC来源id-->获取数据源名称
			log.info("数据来源:"+sqlFromJdbc);
			paramMap.put("sqlFromJdbc",sqlFromJdbc);                            //参数放入map
			String sqlIntoJdbc = getDataSourceNameByJdbcId(sqlIntoJdbcId);		//根据JDBC去向id-->获取数据源名称 
			log.info("数据去向:"+sqlIntoJdbc);
			paramMap.put("sqlIntoJdbc",sqlIntoJdbc);                            //参数放入map
			paramMap.put("targetTable", tDefSql.getSqlIntoTargetTable());       //目标表名
			String sql = this.sqlParamService.getSqlBySqlId(sqlId, pojo);       //替换参数
			paramMap.put("sql", sql);
			//参数-->数据源名称 、目标表名、起始日期、结束日期、批次号
			exeFlag = transExecute(paramMap);                                   //调用传输中
			
			if(exeFlag == -1){        //-1 提数失败
				return false;
			}
			
			if(exeFlag == 0){	     //0 查询结果为空结束本次循环.
				DBContextHolder.recover();
				throw new CoreException("提数操作成功，提取数据为空");
			}
			boolean afterFlag = true;
			传输后操作
			TDefTransexcAfterExample tDefTransexcAfterExample = new TDefTransexcAfterExample();
			tDefTransexcAfterExample.createCriteria().andExcIdEqualTo(excId).andExcNumEqualTo(tDefTransexcAction.getExcNum());
			List<TDefTransexcAfter> tDefTransexcAfters = this.tDefTransexcAfterMapper.selectByExample(tDefTransexcAfterExample);
			if(tDefTransexcAfters.size()==1){
				TDefTransexcAfter tDefTransexcAfter = tDefTransexcAfters.get(0);
				BigDecimal afterSqlId = tDefTransexcAfter.getSqlId();
				TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
				tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(afterSqlId);
				List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(tDefSqlInfoExample);
				String transAfaterSql = tDefSqlInfos.get(0).getSqlInfo();         //传输后SQL脚本
				afterFlag = transAfter(transAfaterSql);                           //执行传输后操作【转码映射操作】 
				if(!afterFlag){
					log.info("转码失败");
				}
				code++;
			}
			paramMap = null;
			count ++;
		}
		log.info("提数成功:"+count);
		log.info("转码成功:"+code);
		return true;
		*/
	}
	/*
	//传输前【DML 备份、清表、插入日志】
	@Transactional
	private boolean transAgo(String sql) throws CoreException {
		
		try {
			sqlAdapter.setSql(sql);
			List<Map> lists = sqlAdapterMapper.excuteQuery(sqlAdapter);
			log.debug(lists);
			return true;
		} catch (Exception e) {
			throw new CoreException(e.getMessage());
		}
	}
	
	//传输中【查询不加事务注解】
	private int transExecute(Map<String, String> paramMap) throws CoreException {

		try {
				sqlAdapter.setSql(paramMap.get("sql"));     				// 传输中执行SQL
				String sqlFromJdbc = paramMap.get("sqlFromJdbc");           //数据来源名称
				DBContextHolder.setDBType(sqlFromJdbc); 					//切换数据源
				List<Map> lists = sqlAdapterMapper.excuteQuery(sqlAdapter); //执行查询SQL脚本
				String sqlIntoJdbc = paramMap.get("sqlIntoJdbc");
				if(lists!= null && lists.size()>0){
					 boolean saveTargetTable = saveTargetTable(lists,paramMap.get("targetTable"),sqlIntoJdbc);
					 if(saveTargetTable){
						 return 1;		//1  返回为true
					 }else{
						 return -1;		//-1 返回为false
					 }
				}else{
					log.info("查询结果为空");
					return 0;           //0  查询结果为空
					//throw new CISException("查询结果为空");
				} 
			}catch (Exception e) {
				log.debug("==="+e.getMessage()+"===");
				if(e.getMessage().contains("Software caused connection abort")){
					log.debug("网络异常");
				}
				log.debug("从源数据库提数失败!!!");
				DBContextHolder.recover();
				throw new CoreException("从源数据库提数失败!!!");
		}
	}
	
	//动态拼insert语句保存到目标表
	@SuppressWarnings("rawtypes")
	@Transactional
	private boolean saveTargetTable(List<Map> lists,String targetTable, String sqlInfoJdbc) throws CoreException{
		
		try{
				List<String> keys = new ArrayList<String>(); //所有的KEY
				List<Object> values = new ArrayList<Object>(); //所有的VALUE
				StringBuffer sbk = null;
				StringBuffer sbv = null;
				
				for (Map<String,Object> map : lists) {
					
					for(Map.Entry<String, Object> entry :map.entrySet()){
						String key = entry.getKey();
						keys.add(key);
					}
					
					sbk = new StringBuffer();
					
					String substring= "";
					for (String key : keys) {
						sbk.append(key);
						sbk.append(",");
						Object obj = map.get(key);
						if(obj instanceof BigDecimal){
							values.add(obj);
						}else if(obj instanceof String){
							values.add("\'"+obj+"\'");
						}else if(obj instanceof Date){
							Date date = (Date)obj;
							String  dateTime = DateUtils.getDateTimeString(date);
							String h = dateTime.substring(11, 13);
							String m = dateTime.substring(14, 16);
							String s = dateTime.substring(17, dateTime.length());
							if(h.equals("00")&&m.equals("00")&&s.equals("00")){
								String dateString = DateUtils.getDateString(date);  //转换成日期格式
								values.add("to_date("+"\'"+dateString+"\'"+","+"\'"+"YYYY-MM-DD" +"\'"+")");
							}else{
								values.add("to_date("+"\'"+dateTime+"\'"+","+"\'"+"YYYY-MM-DD HH24:MI:SS" +"\'"+")");
							}
						}
					}
					
					String insertSQL = "insert into "+targetTable+" "+"(";
					String key = sbk.toString();
					insertSQL += key;
					substring = insertSQL.substring(0,insertSQL.lastIndexOf(","));
					substring+=")";                                                
					log.debug(substring);
					
					
					String value = " values (";
					substring+=value;
					
					sbv = new StringBuffer();
					
					int i = 0;
					for (Object object : values) {
						sbv.append(object);
						i++;
						if(values.size()==i){
							break;
						}
						sbv.append(",");
					}
					
					String svalue = sbv.toString();
					svalue = svalue+")";
					substring+=svalue;
					sqlAdapter.setSql(substring);
					DBContextHolder.setDBType(sqlInfoJdbc);
					sqlAdapterMapper.excuteInsert(sqlAdapter);
					keys.clear();
					values.clear();
					sbk = null;
					sbv = null;
					substring = "";
				}	
			return true;
		} catch (Exception e) {
			throw new CoreException("保存到目标数据库失败");
		}
	}
	
	//传输后
	@Transactional
	private boolean transAfter(String transAfaterSqlInfo) {
		try {
			sqlAdapter.setSql(transAfaterSqlInfo);    //转码映射操作
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.debug("转码失败!");
			return false;
		}
	}
	*/
	/**
	 * 根据JDBC主键获取数据源名称
	 * @param jdbcId
	 * @return
	 */
	/*private String getDataSourceNameByJdbcId(BigDecimal jdbcId) {
		TDefJdbc tDefsqlIntoJdbc = this.tDefJdbcMapper.selectByPrimaryKey(jdbcId);
		return tDefsqlIntoJdbc.getJdbcCode();
	}
*/
	/*(non-Javadoc)
	 * @see com.sinosoft.ummp.application.ExtractService#getResultMap()
	 */
	@Override
	public Map<String, String> getResultMap() {
		return extractService.getResultMap();
	}

	@Override
	public List<String> selectYear() {
		List<String> list = tDefCodeDictMapper.selectExportDataYear();
		return list;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public boolean dealData(String years,
			LoginInfo loginInfo) throws CoreException {
		this.years = years;
		String sql = "select * from T_PRP_LDGetDataSql where status = '1' and standflag1 = 'calculationBase'";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> list = sqlAdapterMapper.excuteQuery(sqlAdapter);
		if (list.size() == 0 || list == null) {
			throw new CoreException("没有配置提取计算原数据SQL!");
		}
		
		//提取原数据指标
		if (!calculationData(list, loginInfo)) {
			throw new CoreException("获取计算原数据失败!");
		}
		
		//获取计算SQL
		sql = "select * from T_PRP_LDGetDataSql where status = '1' and standflag1 = 'calculation'";
		SqlAdapter sqlAdapter1 = new SqlAdapter();
		sqlAdapter1.setSql(sql);
		List<Map> list1 = sqlAdapterMapper.excuteQuery(sqlAdapter1);
		
		if (list1.size() == 0 || list1 == null) {
			throw new CoreException("没有配置指标计算SQL!");
		}
		
		//计算指标
		if (!calculationData(list1, loginInfo)) {
			throw new CoreException("计算指标失败!");
		}
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	private boolean calculationData(List<Map> list,
			LoginInfo loginInfo) throws CoreException {
		for(int i = 1 ; i<list.size();i++){
			String getDataSql = (String) list.get(i).get("CONTENT");
			if (getDataSql.contains("?Year?")) {
				getDataSql = getDataSql.replace("?Year?", years);
				System.out.println(getDataSql);
			}else if (getDataSql.contains("?year?")) {
				getDataSql = getDataSql.replace("?year?", years);
				System.out.println(getDataSql);
			}
			sqlAdapter.setSql(getDataSql);
			List<Map> excuteQuery = sqlAdapterMapper.excuteQuery(sqlAdapter);
			for(int j = 1 ; j<excuteQuery.size();j++){
				Map map = excuteQuery.get(j);
				String areacode = (String) map.get("AREACODE");
				BigDecimal data = (BigDecimal) map.get("DATA");
				TPrpLcquotadataExample example = new TPrpLcquotadataExample();
				example.createCriteria().andQuotacodeEqualTo((String)list.get(i).get("TABLENAME")).andAreacodeEqualTo(areacode);
				System.out.println((String)list.get(i).get("TABLENAME"));
				System.out.println(areacode);
				List<TPrpLcquotadata> list2 = tPrpLcquotadataMapper.selectByExample(example);
				if(list2.size()!=0){
				TPrpLcquotadata tPrpLcquotadata = new TPrpLcquotadata();
				tPrpLcquotadata.setQuotacode((String)list.get(i).get("TABLENAME"));
				tPrpLcquotadata.setQuotaname((String)list.get(i).get("STANDFLAG2"));
				tPrpLcquotadata.setQuotayear(years);
				tPrpLcquotadata.setQuotadate(data);
				System.out.println(data);
				tPrpLcquotadata.setAreacode(areacode);
				System.out.println(areacode);
				tPrpLcquotadata.setOperator((String)loginInfo.getUserCode());
				System.out.println((String)loginInfo.getUserCode());
				tPrpLcquotadata.setMakedate(new Date());
				tPrpLcquotadata.setMaketime(PubFun.getCurrentTime());
				tPrpLcquotadata.setModifydate(new Date());
				tPrpLcquotadata.setModifytime(PubFun.getCurrentTime());
				tPrpLcquotadataMapper.updateByExampleSelective(tPrpLcquotadata, example);
				}
				else{
					throw new CoreException("指标计算插入失败!");
				}
			}
		}
		
		return true;
	}

}
