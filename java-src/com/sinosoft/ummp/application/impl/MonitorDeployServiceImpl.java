package com.sinosoft.ummp.application.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.FileService;
import com.sinosoft.platform.core.application.SqlParamService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefJdbcMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefJdbcExample;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlExample;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlInfoExample;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.domain.model.TDefSqlParamsExample;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.ExcelUtil;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.PubFun;
import com.sinosoft.ummp.application.MonitorDeployService;
import com.sinosoft.ummp.domain.mapper.TDefBagEventMapper;
import com.sinosoft.ummp.domain.mapper.TDefMonitorMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeAddMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMainMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMapper;
import com.sinosoft.ummp.domain.model.TDefBagEvent;
import com.sinosoft.ummp.domain.model.TDefBagEventExample;
import com.sinosoft.ummp.domain.model.TDefMonitor;
import com.sinosoft.ummp.domain.model.TDefMonitorExample;
import com.sinosoft.ummp.domain.model.TDefNotice;
import com.sinosoft.ummp.domain.model.TDefNoticeAddExample;
import com.sinosoft.ummp.domain.model.TDefNoticeExample;
import com.sinosoft.ummp.domain.model.TDefNoticeMainExample;
/**
 * 发送邮件深层次处理，包括生成附件等
 * @author Darker.Wang
 * @date 2016-12-9 下午3:34:57
 * @company SINOSOFT
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class MonitorDeployServiceImpl implements MonitorDeployService{	
	@SuppressWarnings("rawtypes")
	private Map param = new HashMap();
	@Autowired
	private TDefSqlMapper tDefSqlMapper;
	@Autowired
	TDefNoticeMapper tDefNoticeMapper;
	@Autowired
	TDefNoticeMainMapper tDefNoticeMainMapper;
	@Autowired
	TDefNoticeAddMapper tDefNoticeaddMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	
	@Autowired
	TDefBagEventMapper  tDefBagEventMapper;
	
	@Autowired
	TDefMonitorMapper tDefMonitorMapper;
	
	@Autowired
	TDefJdbcMapper tDefJDBCMapper;
	
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	
	@Resource
	private TDefSqlInfoMapper tDefSqlInfoMapper;
	@Resource
	private TDefSqlParamsMapper tDefSqlParamsMapper;
	
	@Autowired
	FileService fileService;
	@Autowired
	SqlParamService sqlParamService;
	
	@Autowired
	TDefJdbcMapper tDefJdbcMapper;

	private static Logger log = Logger.getLogger(MonitorDeployServiceImpl.class);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm, TDefSql sql, TDefJdbc jdbc) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map paramMap=new HashMap();
		paramMap.put("esStatus", sql.getEsStatus());
		paramMap.put("sqlCode", sql.getSqlCode());
		paramMap.put("sqlDesc", sql.getSqlDesc());
		paramMap.put("jdbcCode", jdbc.getJdbcCode());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total=tDefSqlMapper.querySqlListInfoCounts(paramMap);
		List<Map> list=tDefSqlMapper.querySqlListInfoPages(paramMap);
		
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public void saveEventInfo(Map<String, Object> map, LoginInfo loginInfo) throws Exception {
		//获取请求参数
		String monitorCode= (String) map.get("monitorCode");
		String sqlCode=(String) map.get("sqlCode");
		String operator=(String) map.get("usercode");
		//根据monitorCode获取主键MonitorId
		TDefMonitorExample tDefMonitorExample=new TDefMonitorExample();
		tDefMonitorExample.createCriteria().andMonitorCodeEqualTo(monitorCode);
		List<TDefMonitor> list=this.tDefMonitorMapper.selectByExample(tDefMonitorExample);
		//根据sqlCode查询sqlId
		BigDecimal sqlId=tDefSqlMapper.getSqlIdBySqlCode(sqlCode);
		if(list.size()==0){
		
		//生成主键
		BigDecimal monitorId=commonServiceMapper.getSeqValByName("SEQ_T_DEF_MONITOR");
		BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_BAG_EVENT");
		
		TDefBagEvent tDefBagEvent=new TDefBagEvent();
		tDefBagEvent.setId(id);
		tDefBagEvent.setSqlId(sqlId);
		tDefBagEvent.setMonitorCode(monitorCode);
		tDefBagEvent.setEsStatus((short) 1);
		tDefBagEvent.setInsertTime(new Date());
		tDefBagEvent.setOperator(operator);
		this.tDefBagEventMapper.insert(tDefBagEvent);
		
		
		
		TDefMonitor record=new TDefMonitor();
		record.setMonitorId(monitorId);
		record.setMonitorCode(monitorCode);
		record.setMonitorName(monitorCode);
		record.setRcStatus((short) 1);
		record.setInsertTime(PubFun.getCurrentDate());
		record.setOperator(operator);
		this.tDefMonitorMapper.insert(record);
		
		}
		else{
			//根据monCode获取sqlId
			TDefBagEventExample example=new TDefBagEventExample();
			example.createCriteria().andMonitorCodeEqualTo(monitorCode);
			List<TDefBagEvent> result=this.tDefBagEventMapper.selectByExample(example);
			List sqlIds=new ArrayList();
			for(int i=0;i<result.size();i++){
				sqlIds.add(result.get(i).getSqlId());
				log.debug(result.get(i).getSqlId());
			}
			if(sqlIds.contains(sqlId)){
				throw new CoreException("该事件已经存在，请重新定义！");
			}
			
			BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_BAG_EVENT");
			TDefBagEvent tDefBagEvent=new TDefBagEvent();
			tDefBagEvent.setId(id);
			tDefBagEvent.setSqlId(sqlId);
			tDefBagEvent.setMonitorCode(monitorCode);
			tDefBagEvent.setEsStatus((short) 1);
			tDefBagEvent.setInsertTime(new Date());
			tDefBagEvent.setOperator(operator);
			this.tDefBagEventMapper.insert(tDefBagEvent);
			}
		}
		
		
	
	@Override
	@Transactional
	public void deleteGetDataSqlCode(BigDecimal id) {
		//先查询后删除
		TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(id);
		this.tDefSqlMapper.deleteByPrimaryKey(tDefSql.getSqlId());
		
		TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
		tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
		this.tDefSqlInfoMapper.deleteByExample(tDefSqlInfoExample);
		
		TDefSqlParamsExample tDefSqlParamsExample = new TDefSqlParamsExample();
		tDefSqlParamsExample.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
		this.tDefSqlParamsMapper.deleteByExample(tDefSqlParamsExample);
		
		TDefBagEventExample example=new TDefBagEventExample();
		example.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
		this.tDefBagEventMapper.deleteByExample(example);
		
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> getExistEvent(DataGridModel dgm, TDefSql sql,TDefBagEvent event) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map paramMap=new HashMap();
		paramMap.put("monitorCode", event.getMonitorCode());
		paramMap.put("sqlCode", sql.getSqlCode());
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total=tDefBagEventMapper.queryAllCounts(paramMap);
		List<Map<String,String>> list =tDefBagEventMapper.selectBagEventInfo(paramMap);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	@Override
	@Transactional
	public void deleteEvent(BigDecimal id) {
		//TDefBagEvent tDefBagEvent = this.tDefBagEventMapper.selectByPrimaryKey(id);
		
		
		this.tDefBagEventMapper.deleteByPrimaryKey(id);
		
	}
	@Override
	@Transactional
	public void deleteMatter(String monitorCode) {
		
		TDefNoticeExample example4 = new TDefNoticeExample();
		example4.createCriteria().andNoticeCodeEqualTo(monitorCode);
		List<TDefNotice> tDefNotices = tDefNoticeMapper.selectByExample(example4);
		if(tDefNotices.size()!=0){
			BigDecimal value = tDefNotices.get(0).getNoticeId();
			//删除事件包关联的抄送邮箱关联
			TDefNoticeAddExample example3 = new TDefNoticeAddExample();
			example3.createCriteria().andNoticeIdEqualTo(value);
			tDefNoticeaddMapper.deleteByExample(example3);
			//删除事件包关联的收件邮箱关联
			TDefNoticeMainExample example2 = new TDefNoticeMainExample();
			example2.createCriteria().andNoticeIdEqualTo(value);
			tDefNoticeMainMapper.deleteByExample(example2);
			//删除事件包构成的通知时间(t_def_notice)
			tDefNoticeMapper.deleteByExample(example4);
		}
		//删除事件包时间关联表
		TDefBagEventExample example1=new TDefBagEventExample();
		example1.createCriteria().andMonitorCodeEqualTo(monitorCode);
		this.tDefBagEventMapper.deleteByExample(example1);
		//删除事件包
		TDefMonitorExample example=new TDefMonitorExample();
		example.createCriteria().andMonitorCodeEqualTo(monitorCode);
		this.tDefMonitorMapper.deleteByExample(example);
	}
	@Override
	@Transactional
	public void saveDefinitionInfo(Map<String, Object> map, LoginInfo loginInfo) throws Exception {
		//获取请求参数
		TDefSql tDefSql = (TDefSql) map.get("tDefSql");
		TDefSqlInfo tDefSqlInfo = (TDefSqlInfo) map.get("tDefSqlInfo");
		String jdbcCode = (String) map.get("jdbcCode");
		
		//校验是否重复定义记录
		TDefSqlExample checkSqlCode = new TDefSqlExample();
		checkSqlCode.createCriteria().andSqlCodeEqualTo(tDefSql.getSqlCode());
		List<TDefSql> selectByExample = this.tDefSqlMapper.selectByExample(checkSqlCode);
		if(selectByExample.size() != 0){
			throw new  Exception("该算法编码已存在，请重新定义！");
		}
		TDefSqlExample checkSqlDesc = new TDefSqlExample();
		checkSqlDesc.createCriteria().andSqlDescEqualTo(tDefSql.getSqlDesc());
		List<TDefSql> selectByExample2 = this.tDefSqlMapper.selectByExample(checkSqlDesc);
		if(selectByExample2.size() != 0){
			throw new Exception("该算法描述已存在，请重新定义！");
		}
		
		TDefJdbcExample tDefJdbcExample=new TDefJdbcExample();
		tDefJdbcExample.createCriteria().andJdbcCodeEqualTo(jdbcCode);
		List<TDefJdbc> selectByExample3 = this.tDefJDBCMapper.selectByExample(tDefJdbcExample);
		BigDecimal sqlFromJdbcId = selectByExample3.get(0).getId();
		
		BigDecimal sqlInfoId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL_INFO");
		
		tDefSql.setInsertTime(DateUtils.getDateTime());
		tDefSql.setSqlType("Q");
		tDefSql.setSqlFromJdbcId(sqlFromJdbcId);
		tDefSql.setSubBussType("MONITOR_CONFIG");
		tDefSql.setLastModifyTime(DateUtils.getDateTime());
		tDefSql.setOperator(loginInfo.getUserCode());
		
		tDefSqlInfo.setId(sqlInfoId);
		tDefSqlInfo.setSqlType("Q");
		tDefSqlInfo.setSqlId(tDefSql.getSqlId());
		
		//所缺字段，以后添加
		this.tDefSqlMapper.insertSelective(tDefSql);
		this.tDefSqlInfoMapper.insertSelective(tDefSqlInfo);
		
	}
	@Override
	@Transactional
	public void saveUpdateSqlInfo(Map<String, Object> map, LoginInfo loginInfo) throws CoreException {
		//获取请求参数
		TDefSql tDefSql = (TDefSql) map.get("tDefSql");
		TDefSqlInfo tDefSqlInfo = (TDefSqlInfo) map.get("tDefSqlInfo");
		String jdbcCode = (String) map.get("jdbcCode");
		
		//校验算法编码、算法描述是否存在
		TDefSql sql = this.tDefSqlMapper.selectByPrimaryKey(tDefSql.getSqlId());
		
		TDefSqlExample checkSqlCode=new TDefSqlExample();
		checkSqlCode.createCriteria().andSqlCodeEqualTo(tDefSql.getSqlCode());
		List<TDefSql> selectByExample = this.tDefSqlMapper.selectByExample(checkSqlCode);
		if(selectByExample.size() > 0){
			if(!selectByExample.get(0).getSqlId().equals(tDefSql.getSqlId())){
				throw new CoreException("算法编码已存在，请重新修改！");
			}
		}
		
		TDefSqlExample checkSqlDesc = new TDefSqlExample();
		checkSqlDesc.createCriteria().andSqlDescEqualTo(tDefSql.getSqlDesc());
		List<TDefSql> selectByExample2 = this.tDefSqlMapper.selectByExample(checkSqlDesc);
		if(selectByExample2.size() > 0){
			BigDecimal id1 = selectByExample2.get(0).getSqlId();
			BigDecimal id2 = tDefSql.getSqlId();
			if(!id1.equals(id2)){
				throw new CoreException("算法描述已存在，请重新描述！");
			}
		}
		//根据jdbcCode获取该标的主键
		TDefJdbcExample tDefJdbcExample=new TDefJdbcExample();
		tDefJdbcExample.createCriteria().andJdbcCodeEqualTo(jdbcCode);
		List<TDefJdbc> selectByExample3 = this.tDefJDBCMapper.selectByExample(tDefJdbcExample);
		BigDecimal id=selectByExample3.get(0).getId();
		
		 sql.setSqlCode(tDefSql.getSqlCode());
		 sql.setSqlDesc(tDefSql.getSqlDesc());
		 sql.setEsStatus(tDefSql.getEsStatus());
		 sql.setSqlFromJdbcId(id);
		 sql.setLastModifyTime(new Date());
		this.tDefSqlMapper.updateByPrimaryKeySelective(sql);
		
		TDefSqlInfoExample record=new TDefSqlInfoExample();
		record.createCriteria().andSqlIdEqualTo(tDefSql.getSqlId());
		List<TDefSqlInfo> selectByExampleWithBLOBs = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(record);
		TDefSqlInfo uDefSqlInfo = selectByExampleWithBLOBs.get(0);
		uDefSqlInfo.setSqlInfo(tDefSqlInfo.getSqlInfo());
		this.tDefSqlInfoMapper.updateByPrimaryKeyWithBLOBs(uDefSqlInfo);
	}
	//生成含有查询数据的监控压缩包
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void createZip(String monitorCode, String zipName) throws CoreException {
		//1,获取包名下所有的事件
		TDefBagEventExample example=new TDefBagEventExample();
		example.createCriteria().andMonitorCodeEqualTo(monitorCode);
		List<TDefBagEvent> event = this.tDefBagEventMapper.selectByExample(example);
		Map<Integer,Object> map=new HashMap<Integer,Object>();
		if(event.size() !=0){
			for (int i=0; i < event.size(); i++) {
				BigDecimal id = event.get(i).getSqlId();
				if(id == null || id.equals("")){
					System.out.println("- 事件包："+monitorCode+" 无有效的关联事件。");
					continue;
				}
				TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(id);
				String sqlcode = tDefSql.getSqlCode();
				TDefSqlInfoExample example1 = new TDefSqlInfoExample();
				example1.createCriteria().andSqlIdEqualTo(id);
				
//				List<TDefSqlInfo> tDefSqlInfo = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(example1);
//				String sql = tDefSqlInfo.get(0).getSqlInfo();
				
				BigDecimal jdbcId = tDefSql.getSqlFromJdbcId();
				TDefJdbc jdbc = this.tDefJDBCMapper.selectByPrimaryKey(jdbcId);
				//替换参数
				ParamPOJO pojo=new ParamPOJO();
//				String afterDealSql = sqlParamService.getSqlBySqlId(id, pojo);
				String afterDealSql = sqlParamService.getSqlBySqlId(id, pojo, param);
				//设置数据源
				if(DBContextHolder.DATA_SOURCE_ODS.equals(jdbc.getJdbcCode())){
					DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ODS);
				}
				if(DBContextHolder.DATA_SOURCE_UMP.equals(jdbc.getJdbcCode())){
					DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_UMP);
				}
				String a=DBContextHolder.getDBType();
				log.debug(a);
				
				//2,执行事件获取结果
				SqlAdapter sqlAdapter=new SqlAdapter(afterDealSql);
				List<Map> list = sqlAdapterMapper.excuteQuery(sqlAdapter);
				DBContextHolder.recover();
				Map<String,Object> result=new HashMap<String,Object>();
				result.put(sqlcode, list);
				map.put(i, result);
			}
		}else{
			//以后确定是否需要抛异常
			throw new CoreException(monitorCode+"包下无监控事件");
		}
		//3,生成Excel
		try {
			File filedir = new File(zipName);
				if(!filedir.getParentFile().exists()){
					filedir.getParentFile().mkdirs();
				}
			 	OutputStream out=new FileOutputStream(zipName);
			 	Map<String,Object> data=new HashMap<String,Object>();
			 	ExcelUtil util=new ExcelUtil();
			 	 HSSFWorkbook workbook=new HSSFWorkbook();
			 	 for(int k=0;k<map.size();k++){
			 		 List<String> cols=new ArrayList<String>();
			 		 data = (Map<String, Object>) map.get(k); 
			 		 String sheetName="";
			 		 List<Map> context=new ArrayList<Map>();
			 		 for(String s:data.keySet()){
			 			sheetName=s;
			 			context=(List<Map>) data.get(s);
			 		 }
			 		 String[] headers=null;
			 		 if(!context.isEmpty()){
			 			 for(Map str:context){
			 				 Set set = str.keySet();
			 				 for(Object ss:set){
			 					 if(!cols.contains(ss)){
			 						 cols.add((String) ss);
			 					 }else{
			 						 continue;
			 					 }
			 				 }
			 			 }
			 			 headers=new String[cols.size()];
			 			 int a=0;
			 			 for(String s:cols){
			 				 headers[a] = s;
			 				 a++;
			 			 }
			 		 }else{
			 			headers=new String[]{"监控事件无对应记录"};
			 		 }
			 		 util.exportExcel(workbook, k, sheetName, headers, context, out);
			 	 }
			 	 workbook.write(out);
			 	 out.close();
			 	 log.debug("输出完毕");
		 } catch (Exception e) {
		 		 e.printStackTrace();
		 }
		//4,压缩文件
		List<File> files=new ArrayList<File>();
		String zipPath=zipName.substring(0, zipName.lastIndexOf("\\")+1);
		String namee=zipName.substring(zipName.lastIndexOf("\\")+1);
		String name=namee.substring(0, namee.indexOf("."));
		files.add(new File(zipName));
		try {
			fileService.fileToZip(files, zipPath, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void saveSqlParam(Integer flag, TDefSqlParams params) throws CoreException {
		if(flag==0){//新增
			TDefSqlParamsExample example=new TDefSqlParamsExample();
			TDefSqlParamsExample.Criteria criteria = example.createCriteria();
				 criteria.andSqlIdEqualTo(params.getSqlId()).andParamCodeEqualTo(params.getParamCode());
			List<TDefSqlParams> list = tDefSqlParamsMapper.selectByExample(example);
			if(list !=null && list.size()>0){
				throw new CoreException("参数："+params.getParamName()+"已经存在！");
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
	@Override 
	public Map<String,Object> findGetDataSqlCodeById(BigDecimal id) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		TDefSql tDefSql = this.tDefSqlMapper.selectByPrimaryKey(id);
		
		
		TDefSqlInfoExample tDefSqlInfoExample = new TDefSqlInfoExample();
		tDefSqlInfoExample.createCriteria().andSqlIdEqualTo(id);
		List<TDefSqlInfo> tDefSqlInfos = this.tDefSqlInfoMapper.selectByExampleWithBLOBs(tDefSqlInfoExample);
		TDefSqlInfo tDefSqlInfo = tDefSqlInfos.get(0);
		
		//获取数据源名称
		BigDecimal idd  =  tDefSql.getSqlFromJdbcId();
		TDefJdbc tDefJdbc= this.tDefJdbcMapper.selectByPrimaryKey(idd);
		
		map.put("tDefSql", tDefSql);
		map.put("tDefSqlInfo", tDefSqlInfo);
		map.put("tDefJdbc", tDefJdbc);
		
		
		return map;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MonitorDeployService#setParam(java.util.Map)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void setParam(Map map) {
		// TODO Auto-generated method stub
		param.putAll(map);
	}
	
}













