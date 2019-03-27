package com.sinosoft.ummp.application.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jxl.common.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.application.SqlParamService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.DefUserMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefJdbcMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlExample;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlInfoExample;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.ActionService;
import com.sinosoft.ummp.application.ExtractService;
import com.sinosoft.ummp.domain.mapper.TDefTranscodeTraceMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcActionMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcAfterMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcBeforeMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcMapper;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefTranscodeTrace;
import com.sinosoft.ummp.domain.model.TDefTransexc;
import com.sinosoft.ummp.domain.model.TDefTransexcAction;
import com.sinosoft.ummp.domain.model.TDefTransexcActionExample;
import com.sinosoft.ummp.domain.model.TDefTransexcAfter;
import com.sinosoft.ummp.domain.model.TDefTransexcAfterExample;
import com.sinosoft.ummp.domain.model.TDefTransexcBefore;
import com.sinosoft.ummp.domain.model.TDefTransexcBeforeExample;
import com.sinosoft.ummp.domain.pojo.TransExcPOJO;
import com.sinosoft.ummp.exception.CISException;



/**
 * 提数批处理实现类
 * @author Darker.Wang
 * @date 2016-9-1 上午10:44:24
 * @company SINOSOFT
 */
@Service("extractService")
public class ExtractServiceImpl implements ExtractService {
	//执行异常集合
	private List<Exception> exceptions = new ArrayList<Exception>();
	private static final Logger log = Logger.getLogger(ExtractServiceImpl.class);
	private ParamPOJO pojo;
	@Autowired
	private SqlAdapterMapper sqlAdapterMapper;
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
	
	@Autowired
	SequenceService sequenceService;
	@Autowired
	ActionService actionService;
	@Autowired
	TDefTranscodeTraceMapper tDefTranscodeTraceMapper;
	@Autowired
	CodeQueryService codeQueryService;
	
	private Map<String,String> resultMap = new HashMap<String,String>();
	private SqlAdapter sqlAdapter = new SqlAdapter();
	private String mMsg = null;
	private String tBatchNo = null;
	
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ExtractService#extractBefore(java.util.List)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Map<String,String>> extractBefore(List<BigDecimal> sqlIds) throws SQLException {
		// TODO 传输前校验
		// 无指定SQL 则不进行校验
		if(sqlIds == null || sqlIds.size() <= 0){
			return null;
		}
		// 继续校验流程
		SqlAdapter sqlAdapter = new SqlAdapter();
		List<Map<String,String>> rlist = new ArrayList<Map<String,String>>();
		String key  = null;
		for(BigDecimal sqlid: sqlIds){
			try{
				if(sqlid==null){
					continue;
				}
				List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectBySqlIdWithBLOBs(sqlid);
				if(tDefSqlInfos == null||tDefSqlInfos.size()==0){
					break;
				}
				String sqlInfo = tDefSqlInfos.get(0).getSqlInfo();
				sqlAdapter.setSql(sqlInfo);
				List<Map> lists = this.sqlAdapterMapper.excuteQuery(sqlAdapter);
				Map<String,String> map2 = lists.get(0);
				for(Entry<String, String> entry: map2.entrySet()){
					key = entry.getKey();
				}
				Map<String,String> rmap = new HashMap<String,String>(); 
				String vmap = map2.get(key);
				rmap.put(tDefSqlInfos.get(0).getSqlId()+"",vmap);
				rlist.add(rmap);	
			}catch(Exception e){
				resultMap.put("msg", "fail");
				resultMap.put("errorCode", "extractBefore");
				resultMap.put("errorMessage", "传输前手选校验失败");
				resultMap.put("errorFunc", "extractBefore");
				resultMap.put("exceptionMessage", e.getMessage());
				DBContextHolder.recover();
				throw new SQLException();
			}
		}
		return rlist;
	}
	/**
	 * 保单登记校验
	 * @param pojo
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map<String,String> checkExtract(ParamPOJO pojo){
		Map<String,String> map = new HashMap<String,String>();
		TDefSqlExample example = new TDefSqlExample();
		example.createCriteria().andSubBussTypeEqualTo("CHECK_CONFIG")
		.andComIdEqualTo(pojo.getComId())
		.andEsStatusEqualTo(Short.parseShort("1"));
		List<TDefSql> sqls = tDefSqlMapper.selectByExample(example);
		if(sqls == null || sqls.size() <= 0){
			map.put("result", "0");
			return map;
		}
		String sql = sqlParamService.getSqlBySqlId(sqls.get(0).getSqlId(), pojo);
		log.info("- 获取校验SQL："+sql);
		SqlAdapter sa = new SqlAdapter();
		sa.setSql(sql);
		List<Map> list = sqlAdapterMapper.excuteQuery(sa);
		if(list != null && list.size() > 0){
			map.put("result", "1");
			String batchNo = (String)list.get(0).get("BATCHNO");
			String stateFlag = (String)list.get(0).get("STATEFLAG");
			String stateFlagName = (String)list.get(0).get("STATEFLAGNAME");
			map.put("batchNo", batchNo);
			map.put("stateFlag", stateFlag);
			map.put("stateFlagName", stateFlagName);
		}
		return map;
	}
	//@Transactional 若此 加上事务注解导致不能切换数据源
	@Override
	public boolean extract(ParamPOJO pojo, BigDecimal ExcId) throws CISException,SQLException,Exception {
		this.pojo = pojo;
		resultMap.clear();
		exceptions.clear();
		
		TDefCodeDict codeDict = codeQueryService.getQueryCode("SYS_VAR", "EXTRACT_FLAG", pojo.getComId());
		if(codeDict.getCodeAlias() != null && codeDict.getCodeAlias().equals("1")){
			throw new CISException("该平台后台正在提数，请稍候再试！");
		}
		//锁定提数
		codeDict.setCodeAlias("1");
		codeQueryService.updateQueryCode(codeDict);
		//开始提数
		try{
			TDefTransexc tDefTransexc = this.tDefTransexcMapper.selectByPrimaryKey(ExcId); 
			if(tDefTransexc == null){
				resultMap.put("msg", "无对应传输");
				resultMap.put("errorMessage", "无对应传输");
				return false;
			}
			
			log.info("=== 正在执行提数传输："+tDefTransexc.getExcCode()+" \t "+tDefTransexc.getExcDesc());
			
			//若不指定提数批次号，则系统自定义提数批次号，按照日期戳而定
			if(tBatchNo == null || tBatchNo.equals("")){
				tBatchNo = "TN-"+DateUtils.getCurrentDateAndTime();
			}
			//actionNo 每个传输自定义一个，参考系统时间戳
			long sysTM = System.currentTimeMillis();
			
			TDefTransexcActionExample tDefTransexcActionExample = new TDefTransexcActionExample();
			tDefTransexcActionExample.createCriteria()
			.andExcIdEqualTo(tDefTransexc.getExcId())
			.andRcStatusEqualTo(Short.parseShort("1"));
			tDefTransexcActionExample.setOrderByClause("EXC_NUM");
			List<TDefTransexcAction> tDefTransexcActions = this.tDefTransexcActionMapper.selectByExample(tDefTransexcActionExample);
			int allCount = tDefTransexcActions.size();
			
			String actionNo = "SN-"+sysTM;
			BigDecimal id = this.sequenceService.getBigSeqValByName("SEQ_T_DEF_ACTION_TRACE");
			
			TDefActionTrace actionTrace = getActionTrace(pojo,id,actionNo,"操作成功");
			actionTrace.setBatchNo(tBatchNo);//临时编号
			actionTrace.setActionMsg("准备提数");
			actionTrace.setBatchType(tDefTransexc.getExcCode());
			actionTrace.setActionType(tDefTransexc.getExcCode());
			actionTrace.setBussType(tDefTransexc.getExcCode());
			actionTrace.setActionAllCount((long)allCount);
			actionTrace.setActionSucCount((long)0);
			dealActionTrace(actionTrace, "INSERT");
			
			log.info("=== 获取传输类型的主键");
			//根据传输类型主键查询传输对象
			BigDecimal excId = tDefTransexc.getExcId();                                            
			TDefTransexcBeforeExample tDefTransexcBeforeExample = new TDefTransexcBeforeExample();
			tDefTransexcBeforeExample.createCriteria()
			.andExcIdEqualTo(excId)
			.andRcStatusEqualTo(Short.parseShort("1"));;
			tDefTransexcBeforeExample.setOrderByClause("EXC_NUM");
		    List<TDefTransexcBefore> tDefTransexcBefores = this.tDefTransexcBeforeMapper.selectByExample(tDefTransexcBeforeExample);
		    
		    boolean beforeResult = transBefore(tDefTransexcBefores, actionTrace);
		    if(!beforeResult){
		    	return beforeResult;
		    }
		    log.info("=== 传输前执行: "+beforeResult);
		    
		    //执行完毕数据源恢复
		    DBContextHolder.recover();
		    boolean actionResult = transAction(tDefTransexcActions, actionTrace);
		    
		    if(!actionResult){
		    	return actionResult;
		    }
		    
		    log.info("=== 传输中执行: "+actionResult+" "+mMsg);
		    
		    //执行完毕数据源恢复
		    DBContextHolder.recover();
		    
			TDefTransexcAfterExample tDefTransexcAfterExample = new TDefTransexcAfterExample();
			tDefTransexcAfterExample.createCriteria()
			.andExcIdEqualTo(excId)
			.andRcStatusEqualTo(Short.parseShort("1"));;
			tDefTransexcAfterExample.setOrderByClause("EXC_NUM");
			List<TDefTransexcAfter> tDefTransexcAfters = this.tDefTransexcAfterMapper.selectByExample(tDefTransexcAfterExample);
			boolean afterResult = transAfter(tDefTransexc,tDefTransexcAfters,actionTrace );
			
			log.info("=== 传输后操作: "+afterResult);
			log.info("=== 传输执行完毕 ===");
		}catch(Exception e){
			exceptions.add(e);
			resultMap.put("msg", "fail");
			resultMap.put("errorCode", "extract");
			resultMap.put("errorMessage", e.getMessage());
			resultMap.put("errorFunc", "extract");
			resultMap.put("exceptionMessage", e.getMessage());
			throw new CISException(e.getMessage());
		}finally{
			//执行完毕数据源恢复
			DBContextHolder.recover();
			//解锁提数
			codeDict.setCodeAlias("0");
			codeQueryService.updateQueryCode(codeDict);
		}
		
		return true;
    }
	/**
	 * 传输前：
	 * @param tDefTransexcBefores
	 * @param actionTrace
	 * @return
	 * @throws SQLException
	 */
	private boolean transBefore(List<TDefTransexcBefore> tDefTransexcBefores,TDefActionTrace actionTrace){
		boolean beforeFlag = true;
		for (TDefTransexcBefore tDefTransexcBefore : tDefTransexcBefores) {
			BigDecimal sqlId = null;
			try{
				sqlId = tDefTransexcBefore.getSqlId();
				TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
				tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(sqlId);
				List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(tDefSqlInfoExample);
				for (TDefSqlInfo tDefSqlInfo : tDefSqlInfos) {
					 String transAgosql = this.sqlParamService.getSqlBySqlId(sqlId, pojo);       //替换参数
					beforeFlag = _transBefore(tDefSqlInfo.getId().toString(),transAgosql,tDefSqlInfo.getSqlType());                  //执行传输前操作【校验,清表操作】
					if(!beforeFlag){
						log.info("前置SQL失败: id="+tDefSqlInfo.getId()+" "+transAgosql);
						return beforeFlag;
					}
				}
			}catch(Exception e){
				beforeFlag = false;
				resultMap.put("msg", "fail");
				resultMap.put("errorCode", "extract");
				resultMap.put("errorMessage", e.getMessage());
				resultMap.put("errorFunc", "extract");
				resultMap.put("exceptionMessage", e.getMessage());
				DBContextHolder.recover();
				actionTrace.setDataStatus("-1");//0-失败 1-成功 -1-异常
				actionTrace.setStateFlag("-1");//0-失败 1-成功 -1-异常
				actionTrace.setDataMsg("操作异常");
				actionTrace.setActionMsg("传输前执行失败,SQL_ID="+sqlId);
				actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
				dealActionTrace(actionTrace, "UPDATE");
				return false;
			}
		}
		return beforeFlag;
	}
	
	/**
	 * 传输前实际执行：事务再次控制
	 * @param sql
	 * @param sqlType
	 * @return
	 * @throws CoreException
	 * @throws SQLException
	 */
	@SuppressWarnings("rawtypes")
	@Transactional
	private boolean _transBefore(String sqlId,String sql,String sqlType) throws CoreException, SQLException{
		try {
			if(sqlType == null || "".equals(sqlType)){
				CoreException coreException = new CoreException();
				coreException.setMessage("SQL类型为空，sql_id="+sqlId);
				throw coreException;
			}
			
			log.info("正在传输前处理，SQL_DS： "+DBContextHolder.getDBType());
			log.info("正在传输前处理，SQL_TP： "+sqlType);
			log.info("正在传输前处理，SQL_ID： "+sqlId);
			log.info("正在传输前处理，SQL_IS：\n"+sql);
			
			sqlAdapter.setSql(sql);
			//查询才走该流程，否则走其他
			if(sqlType.equals("Q")){
				
				List<Map> lists = sqlAdapterMapper.excuteQuery(sqlAdapter);
				for(Map map : lists){
					if(map.keySet().contains("0")){//1- 通过 0-不通过
						System.out.println("- 传输前校验不通过："+sql);
						return false;
					}
					if(map.keySet().contains(0)){
						System.out.println("- 传输前校验不通过："+sql);
						return false;
					}
					if(map.keySet().contains("false")){//true 通过 false 不通过
						System.out.println("- 传输前校验不通过："+sql);
						return false;
					}
					if(map.keySet().contains(false)){//true 通过 false 不通过
						System.out.println("- 传输前校验不通过："+sql);
						return false;
					}
				}
			}
			if(sqlType.equals("U")){
				sqlAdapterMapper.excuteUpdate(sqlAdapter);
			}
			if(sqlType.equals("D")){
				sqlAdapterMapper.excuteDelete(sqlAdapter);
			}
			if(sqlType.equals("I")){
				sqlAdapterMapper.excuteInsert(sqlAdapter);
			}
			return true;
		} catch (Exception e) {
			String message = "执行SQL异常：SQL_ID="+sqlId+" SQL: "+sql;
			System.out.println(message);
			e.printStackTrace();
			CoreException ce = new CoreException();
			ce.setMessage("执行SQL异常：SQL_ID="+sqlId);
			throw ce;
		}
	}
	/**
	 * 支持两个数据源传输：每个传输独立存在，事务在传输中控制，支持一个传输一个事务
	 * @param tDefTransexcActions
	 * @param actionTrace
	 * @return
	 * @throws SQLException
	 */
	private boolean transAction(List<TDefTransexcAction> tDefTransexcActions,TDefActionTrace actionTrace ) throws CoreException{
		// 1、根据数据源获取查询SQL
		Map<String,List<TransExcPOJO>> sqlQueryMaps = getQuerySqlMaps(tDefTransexcActions);
		// 2、执行提数操作
		Map<String,List<String>> sqlInsertMaps = null;
		try{
			sqlInsertMaps = transAction(sqlQueryMaps);
		}catch(CoreException e){
			DBContextHolder.recover();
			actionTrace.setDataStatus("-1");
			actionTrace.setStateFlag("-1");//0-失败 1-成功 -1-异常
			actionTrace.setActionMsg("执行提数操作失败");
			actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
			dealActionTrace(actionTrace, "UPDATE");
			throw e;
		}
		//3、判断提取数据是否为空
		if(sqlInsertMaps == null || sqlInsertMaps.isEmpty()){
			//此处不应该抛出异常，因为其他的代码可能需要执行，比如转码等
			mMsg = "提数操作成功，但提取数据为空";
			log.info(mMsg);
			DBContextHolder.recover();
			actionTrace.setDataStatus("1");//0-失败 1-成功 -1-异常
			actionTrace.setStateFlag("-1");//0-失败 1-成功 -1-异常
			actionTrace.setDataMsg("操作成功");
			actionTrace.setActionMsg(mMsg);
			actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
			dealActionTrace(actionTrace, "UPDATE");
			return true;
		}
		
		//4、执行插入操作
		String interval = null;
		Iterator<String> iter = sqlInsertMaps.keySet().iterator();
		try{
			//作用： 1、获取自定义分批插入数。2、测试连接是否有效，无效捕获，再次进行。
			DBContextHolder.recover();
			interval = codeQueryService.getCodeAlails("SYS_VAR", "COMMIT_INTERVAL");
		}catch(Exception e){
			//再走取一遍：was会出现连接超时重置
			log.info("- 正在捕获异常：");
			log.info("- 从CODE_DICT获取自定义提交记录数发生异常："+e.getMessage());
			log.info("- 异常信息："+e.getMessage());
			DBContextHolder.recover();
			interval = codeQueryService.getCodeAlails("SYS_VAR", "COMMIT_INTERVAL");
		}
		
		int inv = 100;//不设置则默认100条提交一次
		if(interval != null && !"".equals(interval)){
			inv = Integer.parseInt(interval);
		}
		//遍历数据源进行插入
		while(iter.hasNext()){
			try {
				String key = iter.next();
				List<String> allSql = sqlInsertMaps.get(key);
				DBContextHolder.setDBType(key);
				insertByTransactional(inv,allSql);
			}catch (CoreException e) {
				DBContextHolder.recover();
				actionTrace.setDataStatus("-1");//0-失败 1-成功 -1-异常
				actionTrace.setStateFlag("-1");//0-失败 1-成功 -1-异常
				actionTrace.setDataMsg("操作异常");
				actionTrace.setActionMsg(e.getMessage());
				actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
				dealActionTrace(actionTrace, "UPDATE");
				throw e;
			}finally{
				DBContextHolder.recover();
			}
		}
		DBContextHolder.recover();
		actionTrace.setDataStatus("1");//0-失败 1-成功 -1-异常
		actionTrace.setStateFlag("1");//0-失败 1-成功 -1-异常
		actionTrace.setDataMsg("操作成功");
		actionTrace.setActionMsg("提数成功,待转码");
		actionTrace.setActionSucCount(actionTrace.getActionAllCount());
		actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
		dealActionTrace(actionTrace, "UPDATE");
		return true;
	}
	/***
	 * 提数操作，返回各个数据源对应的插入语句
	 * @param sqlQueryMaps
	 * @return
	 * @throws CoreException
	 */
	private Map<String,List<String>> transAction(Map<String,List<TransExcPOJO>> sqlQueryMaps) throws CoreException{
		Map<String,List<String>> sqlInsertMaps = new HashMap<String,List<String>>();
		Iterator<String> iter = sqlQueryMaps.keySet().iterator();
		while(iter.hasNext()){
			String fromJdbcName = iter.next();
			List<TransExcPOJO> transExcPOJOs = sqlQueryMaps.get(fromJdbcName);
			if(transExcPOJOs == null || transExcPOJOs.size() <= 0){
				CoreException ce = new CoreException();
				ce.setMessage("当前无对应传输SQL");
				throw ce;
			}
			try{
				Map<String,List<String>>  temp = _transAction(transExcPOJOs);
				if(temp != null && !temp.isEmpty()){
					Iterator<String> tempIter = temp.keySet().iterator();
					while(tempIter.hasNext()){
						String key = tempIter.next();
						if(sqlInsertMaps.containsKey(key)){
							sqlInsertMaps.get(key).addAll(temp.get(key));
							continue;
						}
						sqlInsertMaps.put(key, temp.get(key));
					}
				}
			}catch(CoreException e){
				throw e;
			} catch (Exception e) {
				CoreException ce = new CoreException();
				ce.setMessage("传输执行提数异常："+e.getMessage());
				throw ce;
			}
		}
		return sqlInsertMaps;
	}
	/**
	 * 根据数据源执行提数，返回提数后构造的INSERT的SQL，按数据源分类
	 * @param transExcPojos
	 * @return
	 * @throws CoreException
	 */
	@SuppressWarnings("rawtypes")
	private Map<String,List<String>> _transAction(List<TransExcPOJO> transExcPojos) throws CoreException{
		Map<String,List<String>> sqlInsertMaps = new HashMap<String,List<String>>();
		BigDecimal sqlId = null;
		String sql = null;
		try{
			for(TransExcPOJO pojo : transExcPojos){
				//锁定数据源
				DBContextHolder.setDBType(pojo.getFromDataSource());
				
				String sqlType = pojo.getSqlType();
				String targetTable = pojo.getTargetTable();
				String intoJdbcName = pojo.getIntoDataSource();
				
				sqlId = pojo.getSqlId();
				sql = pojo.getSql();
				
				log.info("正在传输中提数，TARGET： "+targetTable);
				log.info("正在传输中提数，SQL_DS： "+DBContextHolder.getDBType());
				log.info("正在传输中提数，SQL_TP： "+sqlType);
				log.info("正在传输中提数，SQL_ID： "+sqlId);
				log.debug("正在传输中提数，SQL_IS：\n"+sql);
				SqlAdapter sa = new SqlAdapter();
				sa.setSql(sql);
				if(sqlType.equals("Q")){
					List<Map> lists = sqlAdapterMapper.excuteQuery(sa); //执行查询SQL脚本
					if(lists == null || lists.size() <= 0){
						log.info("传输中提数为空，SQL_ID： "+sqlId+" ===> SQL: "+sql);
						continue;
					}
					List<String> insertSqls = getInsert(lists, targetTable);
					if(insertSqls == null || insertSqls.size() <= 0){
						log.info("传输中插获取入SQL为空，SQL_ID： "+sqlId);
						continue;
					}
					if(sqlInsertMaps.containsKey(intoJdbcName)){
						sqlInsertMaps.get(intoJdbcName).addAll(insertSqls);
						continue;
					}
					sqlInsertMaps.put(intoJdbcName, insertSqls);
				}
				if(sqlType.equals("I")){
					sqlAdapterMapper.excuteInsert(sa);
				}
				if(sqlType.equals("U")){
					sqlAdapterMapper.excuteUpdate(sa);
				}
				if(sqlType.equals("D")){
					sqlAdapterMapper.excuteDelete(sa);
				}
				
				//垃圾回收
				intoJdbcName = null;
				targetTable = null;
				sqlId = null;
				sql = null;
				//System.gc();
			}
		}catch(Exception e){
			e.printStackTrace();
			CoreException ce = new CoreException();
			log.error("执行提数SQL异常：SQL_ID="+sqlId+" SQL: "+sql);
			ce.setMessage("执行提数SQL异常：SQL_ID = "+sqlId);
			sqlId = null;
			sql = null;
			//System.gc();
			throw ce;
		}finally{
			DBContextHolder.recover();
		}
		return sqlInsertMaps;
	}
	/**
	 * 获取提数逻辑，根据数据源分组<br>
	 * 查询SQL MAP： key 为数据源，value为对应数据源之下的SQL集合<br>
	 * SQL集合中为封装的传输POJO类
	 * @param tDefTransexcActions
	 * @return
	 */
	private Map<String,List<TransExcPOJO>> getQuerySqlMaps(List<TDefTransexcAction> tDefTransexcActions){
		Map<String,List<TransExcPOJO>> sqlQueryMaps = new HashMap<String,List<TransExcPOJO>>();
		for (TDefTransexcAction tDefTransexcAction : tDefTransexcActions) {
			BigDecimal sqlId = tDefTransexcAction.getSqlId();                   //获取T_DEF_SQL表主键
			TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(sqlId);     //根据主键获取TDefSql对象
			BigDecimal sqlFromJdbcId = tDefSql.getSqlFromJdbcId();    		    //获取JDBC来源id
			BigDecimal sqlIntoJdbcId = tDefSql.getSqlIntoJdbcId();              //获取JDBC去向id
			String sqlType = tDefSql.getSqlType();
			String targetTable = tDefSql.getSqlIntoTargetTable();
			String sqlFromName = getDataSourceNameByJdbcId(sqlFromJdbcId);      //根据JDBC来源id-->获取数据源名称
			String sqlIntoName = getDataSourceNameByJdbcId(sqlIntoJdbcId);		//根据JDBC去向id-->获取数据源名称
			log.info("=== 数据来源:"+sqlFromName+" SQL_ID: "+tDefSql.getSqlId());
			log.info("=== 数据去向:"+sqlIntoName+" 目标表："+targetTable);
			String sql = this.sqlParamService.getSqlBySqlId(sqlId, pojo);       //替换参数
			if(sql == null || sql.equals("")){
				log.info("SQL_ID: "+tDefSql.getSqlId()+" 无对应提数SQL");
				continue;
			}
			
			//存在则从在原来的基础之上添加
			if(sqlQueryMaps.containsKey(sqlFromName)){
				TransExcPOJO transPojo = new TransExcPOJO();
				transPojo.setFromDataSource(sqlFromName);
				transPojo.setIntoDataSource(sqlIntoName);
				transPojo.setSql(sql);
				transPojo.setSqlId(sqlId);
				transPojo.setSqlType(sqlType);
				transPojo.setTargetTable(targetTable);
				sqlQueryMaps.get(sqlFromName).add(transPojo);
				continue;
			}
			//不存在则新建List
			List<TransExcPOJO> sqlQuerys = new ArrayList<TransExcPOJO>();
			TransExcPOJO transPojo = new TransExcPOJO();
			transPojo.setFromDataSource(sqlFromName);
			transPojo.setIntoDataSource(sqlIntoName);
			transPojo.setSql(sql);
			transPojo.setSqlId(sqlId);
			transPojo.setSqlType(sqlType);
			transPojo.setTargetTable(targetTable);
			sqlQuerys.add(transPojo);
			sqlQueryMaps.put(sqlFromName, sqlQuerys);
		}
		return sqlQueryMaps;
	}
	/**
	 * 目前支持本地数据源
	 * @param tDefTransexc
	 * @param tDefTransexcAfters
	 * @param actionTrace
	 * @return
	 * @throws CoreException 
	 */
	private boolean transAfter(TDefTransexc tDefTransexc,List<TDefTransexcAfter> tDefTransexcAfters,TDefActionTrace actionTrace ) throws SQLException, CoreException{
		boolean afterFlag = true;
		for(TDefTransexcAfter tDefTransexcAfter : tDefTransexcAfters){
			try{
				BigDecimal afterSqlId = tDefTransexcAfter.getSqlId();
				TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
				tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(afterSqlId);
				TDefSql tDefSql = tDefSqlMapper.selectByPrimaryKey(afterSqlId);
				String sqlJdbc = getDataSourceNameByJdbcId(tDefSql.getSqlFromJdbcId());      //根据JDBC来源作为数据源名称
				if(sqlJdbc == null || "".equals(sqlJdbc)){
					sqlJdbc = getDataSourceNameByJdbcId(tDefSql.getSqlIntoJdbcId());      //无JDBC来源，则以去向作为数据源名称
				}
				DBContextHolder.setDBType(sqlJdbc);
				if(sqlJdbc == null || "".equals(sqlJdbc)){
					DBContextHolder.recover();//都无数据源取默认
				}
				List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(tDefSqlInfoExample);
				if(tDefSqlInfos == null || tDefSqlInfos.size() <= 0){
					log.info("传输后处理 T_DEF_SQL_INFO 无对应 SQL，SQL_ID = "+afterSqlId);
					continue;
				}
				String transAfaterSql = this.sqlParamService.getSqlBySqlId(afterSqlId, pojo);       //替换参数
				String sqlType = tDefSqlInfos.get(0).getSqlType();
				afterFlag = _transAfter(tDefTransexc,afterSqlId,transAfaterSql,sqlType,actionTrace.getBatchNo(),actionTrace.getActionNo());       //执行传输后操作【转码映射操作】
				if(!afterFlag){
					System.out.println("执行传输后失败：id="+afterSqlId+" SQL: "+transAfaterSql);
					resultMap.put("msg", "fail");
					resultMap.put("errorCode", "extract");
					resultMap.put("errorMessage", "执行传输后失败：id="+afterSqlId);
					resultMap.put("errorFunc", "extract");
					resultMap.put("exceptionMessage", "执行传输后失败：id="+afterSqlId);
					continue;
				}
			}catch(Exception e){
				DBContextHolder.recover();
				actionTrace.setDataStatus("-1");//0-失败 1-成功 -1-异常
				actionTrace.setStateFlag("-1");//0-失败 1-成功 -1-异常
				actionTrace.setDataMsg("操作异常");
				actionTrace.setActionMsg(e.getMessage());
				actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
				dealActionTrace(actionTrace, "UPDATE");
			}
		}
		DBContextHolder.recover();
		actionTrace.setDataStatus("1");//0-失败 1-成功 -1-异常
		actionTrace.setStateFlag("1");//0-失败 1-成功 -1-异常
		actionTrace.setDataMsg("操作成功");
		actionTrace.setActionMsg("提数完毕，转码成功");
		actionTrace.setLastModifyTime(DateUtils.getCurrentTimestamp());
		dealActionTrace(actionTrace, "UPDATE");
		return true;
	}
	/**
	 * 传输后实际执行：事务再次控制
	 * @param sqlId
	 * @param sql
	 * @param sqlType
	 * @return
	 * @throws CoreException
	 */
	@Transactional
	private boolean _transAfter(TDefTransexc tDefTransexc ,BigDecimal sqlId,String sql,String sqlType,String batchNo,String actionNo) throws CoreException{
		if(sqlType == null || "".equals(sqlType)){
			CoreException coreException = new CoreException();
			coreException.setMessage("SQL类型为空，SQL_ID="+sqlId);
			throw coreException;
		}
		sqlAdapter.setSql(sql);
		log.info("正在传输后处理，SQL_DS： "+DBContextHolder.getDBType());
		log.info("正在传输后处理，SQL_TP： "+sqlType);
		log.info("正在传输后处理，SQL_ID： "+sqlId);
		log.info("正在传输后处理，SQL_IS：\n"+sql);
		if(sqlType.equals("Q")){
			sqlAdapterMapper.excuteQuery(sqlAdapter); //执行查询SQL脚本
		}
		if(sqlType.equals("I")){
			 sqlAdapterMapper.excuteInsert(sqlAdapter);
		}
		if(sqlType.equals("U")){
			String stateFlag = "0";
			String msg = "";
			try{
				int i = sqlAdapterMapper.excuteUpdate(sqlAdapter);
				 if(i >=0 ){
					 stateFlag = "1";
					 msg = "转码成功";
				 }
			}catch(Exception e){
				stateFlag = "-1";
			}
			 
			//记录转码信息
			dealTranscodeTrace(tDefTransexc,batchNo,actionNo,sqlId,tDefTransexc.getExcCode()+" 转码SQL",stateFlag,msg); 
		}
		if(sqlType.equals("D")){
			 sqlAdapterMapper.excuteDelete(sqlAdapter);
		}
		return true;
	}
	
	/**
	 * 根据JDBC主键获取数据源名称
	 * @param jdbcId
	 * @return
	 */
	private String getDataSourceNameByJdbcId(BigDecimal jdbcId) {
		TDefJdbc tDefsqlIntoJdbc = this.tDefJdbcMapper.selectByPrimaryKey(jdbcId);
		return tDefsqlIntoJdbc.getJdbcCode();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ExtractService#getResultMap()
	 */
	@Override
	public Map<String, String> getResultMap() {
		return resultMap;
	}
	
	/**
	 * 处理报送履历
	 * @param actionTrace
	 * @param action
	 * @return
	 */
	private boolean dealActionTrace(TDefActionTrace actionTrace,String action){
		List<TDefActionTrace> actionTraces = new ArrayList<TDefActionTrace>();
		actionTraces.add(actionTrace);
		int insertR = 0;
		if(action.equals("UPDATE")){
			insertR = actionService.updateActionTrace(actionTraces);
		}
		if(action.equals("DELETE")){
			insertR = actionService.deleteActionTreace(actionTraces);
		}
		if(action.equals("INSERT")){
			insertR = actionService.insertActionTrace(actionTraces);
		}
		
		if(insertR < 0 ){
			return false;
		}
		return true;
	}
	/**
	 * 处理Action 履历
	 * @param transexc
	 * @param batchNo
	 * @param actionNo
	 * @param sqlId
	 * @param sqlDesc
	 * @param stateFlag
	 * @param msg
	 * @return
	 */
	private int dealTranscodeTrace(TDefTransexc transexc
			,String batchNo,String actionNo
			,BigDecimal sqlId,String sqlDesc
			,String stateFlag,String msg){
		TDefTranscodeTrace record = new TDefTranscodeTrace();
		record.setId(this.sequenceService.getBigSeqValByName("SEQ_T_DEF_TRANSCCODE_TRACE"));
		record.setActionNo(actionNo);
		record.setBatchNo(batchNo);
		record.setMsg(msg);
		record.setStateFlag(stateFlag);
		record.setOperator(pojo.getUserCode());
		record.setTransexcId(transexc.getExcId());
		record.setTransexcCode(transexc.getExcCode());
		record.setTransexcName(transexc.getExcDesc());
		record.setSqlId(sqlId);
		record.setInsertTime(new Date());
		record.setLastModifyTime(DateUtils.getDateTime());
		return tDefTranscodeTraceMapper.insert(record);
	}
	/**
	 * 获取日志插入对象
	 * @param pojo 前台参数
	 * @param id 记录ID
	 * @param actionNo 记录编号
	 * @param msg 信息提示
	 * @return
	 */
	private TDefActionTrace getActionTrace(ParamPOJO pojo,BigDecimal id,String actionNo,String msg){
		
		TDefActionTrace tDefActionTrace = new TDefActionTrace(); 
		tDefActionTrace.setId(id);                             //not null Pk        
		tDefActionTrace.setBatchNo(pojo.getBatchNo());         //not null 交易批次号   
		tDefActionTrace.setBatchType(pojo.getBatchType());     //交易批次类型     
		tDefActionTrace.setBussNo(pojo.getBussNo());           //交易业务号
		tDefActionTrace.setBussType(pojo.getBussType());       //交易业务类型
		tDefActionTrace.setActionDate(DateUtils.getDateTime());//提数时操做日期为当前
		tDefActionTrace.setActionTime(DateUtils.getCurrentTime());//提数操作时间
		tDefActionTrace.setStartDate(DateUtils.getDate(pojo.getStartDate()));
		tDefActionTrace.setEndDate(DateUtils.getDate(pojo.getEndDate()));
		tDefActionTrace.setSubBussType("EB");            	   //交易父级业务类型 EB=ExtractBissness SB=SubmitBissness
		tDefActionTrace.setPlatCom(pojo.getComId());  		   //平台编码
		tDefActionTrace.setActionNo(actionNo);	               //交易流水号 not null
//	    tDefActionTrace.setActionAllCount(null);               //交易记录
//	    tDefActionTrace.setActionSucCount(null);               //成功记录
	    tDefActionTrace.setActionType(pojo.getBussType());     //交易类型
		tDefActionTrace.setActionMsg(msg);                     //交易信息
		tDefActionTrace.setDataMsg(msg);                       //数据信息
		tDefActionTrace.setDataStatus("1");                    //数据状态：0-失败 1-成功 -1-异常
		tDefActionTrace.setEsStatus((short)1);                 //状态标志
		tDefActionTrace.setInsertTime(DateUtils.getDateTime());//入库时间
		tDefActionTrace.setLastModifyTime(DateUtils.getDateTime());//最后一次修改时间 			
		tDefActionTrace.setOperator(pojo.getUserCode());       //操作者
		
		return tDefActionTrace;
	}
	/**
	 * 获取插入SQL invalid
	 * @param lists
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<String> getInsert(List<Map> lists,String targetTable){
		List<String> sqls = new ArrayList<String>(); //所有的SQL
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
			substring += svalue;
			sqls.add(substring);
			//垃圾回收
			keys.clear();
			values.clear();
			sbk = null;
			sbv = null;
			substring = "";
		}
		log.info("- get insert sql over : "+sqls.size());
		return sqls;
	}
	
	/**
	 * 插入数据表，由父类/方法统一控制事务
	 * @param sqls
	 * @return
	 * @throws SQLException
	 */
	private boolean insertTable(List<String> sqls) throws CoreException{
		for(String sql : sqls){
			//执行插入SQL
			try{
				sqlAdapter.setSql(sql);
				sqlAdapterMapper.excuteInsert(sqlAdapter);
			}catch(Exception e){
				e.printStackTrace();
				log.error("执行插入SQL异常，SQL："+sqlAdapter.getSql());
				
				DBContextHolder.recover();
				CoreException sqlException = new CoreException("执行插入SQL异常");
				throw sqlException;
				
			}
		}
		System.gc();
		return true;
	}
	/**
	 * 根据数据源保存数据: 保存数据之前请先锁定数据源
	 * @param allSqls
	 * @param intoJdbc
	 * @return
	 */
	@Transactional
	private boolean insertByTransactional(int inv,List<String> sqls) throws CoreException{
		log.info("datasource : "+DBContextHolder.getDBType());
		log.info("saving data and every ["+inv+"] commit once ");
		for(int i = 0;i < sqls.size(); i+=inv){
			int end = i+inv;
			if(end > sqls.size()){
				end = sqls.size();
			}
			List<String> tsqls = sqls.subList(i, end);
			insertTable(tsqls);
			System.out.println("commit @Transactional ："+(i+1)+" - "+end);
		}
		return true;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ExtractService#getExceptions()
	 */
	@Override
	public List<Exception> getExceptions() {
		// TODO Auto-generated method stub
		return exceptions;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ExtractService#setBatchNo(java.lang.String)
	 */
	@Override
	public void setBatchNo(String tBatchNo) {
		// TODO Auto-generated method stub
		this.tBatchNo = tBatchNo;
	}
	@Override
	public String getBatchNo(){
		return this.tBatchNo;
	}
	
	@Override
	public Map<String, Object> getVerifyList(DataGridModel dgm)
			throws SQLException, IOException {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total = tDefSqlMapper.selectCountBatchConfigSQL();
		List<Map<String, Object>> lists = tDefSqlMapper.selectBatchConfigSQL(paramMap);
		for (Map<String, Object> map : lists) {
			String sql = tDefSqlMapper.getSqlById((BigDecimal)map.get("sqlId"));
			map.put("sqlInfo", sql);
		}
		result.put("total", total);
		result.put("rows", lists);
		return result;
	}
}