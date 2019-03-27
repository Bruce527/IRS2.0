package com.sinosoft.ummp.application.impl;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.mapper.DefReportColMapper;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.mapper.TDefPlatComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefUserTraceMapper;
import com.sinosoft.platform.core.domain.mapper.UserServiceMapper;
import com.sinosoft.platform.core.domain.model.DefReportCol;
import com.sinosoft.platform.core.domain.model.DefUserExample;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.ResultInfo;
import com.sinosoft.ummp.application.ReportService;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.mapper.TDefTransexcMapper;




@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ReportServiceImpl implements ReportService{
	@Autowired//测试生成报表用
	UserService userService;
	@Autowired//测试生成报表用
	UserServiceMapper userServiceMapper;
	@Autowired
	TDefUserTraceMapper tDefUserTraceMapper;
	@Autowired
	TDefCodeDictMapper tDefCodeDictMapper;
	@Autowired
	DefReportColMapper defReportColMapper;
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	TDefTransexcMapper tDefTransexcMapper;
	@Autowired
	TDefPlatComMapper tDefPlatComMapper;
	@Autowired
	CodeQueryService codeQueryService;
	@Override
	public ResultInfo exportExcel(Map paramMap) {
		String reportCode=(String) paramMap.get("flag");
		ResultInfo resultInfo = new ResultInfo();
		// 1
		List<Map<String, Object>> reportList = new ArrayList<Map<String, Object>>();
		// 2.查询需要导出的数据							//测试生成报表用
		 List<Map> queryReportList=this.tDefUserTraceMapper.OperateLogInfo(paramMap);
		// 3.判断Mpper层返回的数据
		if (queryReportList != null) {
			// 生成Excel
			Map<String,Object> reportMap=new HashMap<String,Object>();
			TDefCodeDict defCode = codeQueryService.getQueryCode("reportCode", reportCode);
			reportMap.put("reportName", defCode.getCodeName());
			//4.获取报表的列编号，列编码，列名称
			DefUserExample defReportColExample = new DefUserExample();
			DefUserExample.Criteria criteria = defReportColExample.createCriteria();
			criteria.andReportCodeEqualTo(reportCode);
			List<DefReportCol> reportColInfoList = defReportColMapper.selectByExample(defReportColExample);
			//5.添加表头信息
			Map<String, String> colMap=new HashMap<String, String>();
			//只需要重写此方法即可																							///////
			colMap=this.getSheetParam(colMap,defCode,paramMap);
			reportMap.put("reportColNameMapping", colMap);
			//6.生成列编号与列名称的对应关系		
			Map<String, String> colNoToColNameMap = new HashMap<String, String>();
			for (DefReportCol defReportCol:reportColInfoList) {
				colNoToColNameMap.put(defReportCol.getColumnNo(), defReportCol.getColumnName());
			}
			reportMap.put("reportColNoToColNameMapping", colNoToColNameMap);
			//7.生成列编号与列编码的对应关系	
			Map<String, String> colNoToColCodeMap = new HashMap<String, String>();
			for (DefReportCol defReportCol:reportColInfoList) {
				colNoToColCodeMap.put(defReportCol.getColumnNo(), defReportCol.getColumnCode());
			}
			reportMap.put("reportColNoToColCodeMapping", colNoToColCodeMap);
			// sheet名称
			String reportName = reportMap.get("reportName").toString();
			reportMap.put("reportName", reportName);
			if (reportMap != null && reportMap.size() > 0 && queryReportList != null && queryReportList.size() > 0) {
				reportMap.put("reportData", queryReportList);
				reportList.add(reportMap);
			} else {
				Map<String, Object> emptyMap = new HashMap<String, Object>();
				// 查询结果为空时，放入Excel表头
				for(DefReportCol col:reportColInfoList){
					emptyMap.put(col.getColumnCode(), "");
				}
				queryReportList.add(emptyMap);
				reportMap.put("reportData", queryReportList);
				reportList.add(reportMap);
			}
			resultInfo.setObj(reportList);
			resultInfo.setSuccess(true);
		}
		return resultInfo;
	}
	//添加表头信息
	public Map<String, String> getSheetParam(Map<String, String> colMap,TDefCodeDict defCode,Map paramMap){
		colMap.put("col0", "报表名称:");
		colMap.put("col1",  defCode.getCodeName());
		colMap.put("col2","起始日期:" );
		colMap.put("col3",(String) paramMap.get("startDate") );
		colMap.put("col4","截止日期:" );
		colMap.put("col5",(String) paramMap.get("endDate"));
		colMap.put("col6", "统一认证编码:");
		colMap.put("col7", (String) paramMap.get("empowerCode"));
		colMap.put("col8", "用户编码:");
		colMap.put("col9",(String) paramMap.get("userCode"));
		colMap.put("col10", "用户名称:");
		colMap.put("col11",(String) paramMap.get("userName"));
		colMap.put("col12", defCode.getCodeName()+"如下:");
		return colMap;
	}
	
	//报表业务处理方法
	public ResultInfo dealData(Map paramMap,ResultInfo resultInfo,List<Map> queryReportList,Map<String,Object> reportMap){

		String reportCode=(String) paramMap.get("reportCode");
		List<Map<String, Object>> reportList = new ArrayList<Map<String, Object>>();
		if (queryReportList != null) {
			// 生成Excel
			//4.获取报表的列编号，列编码，列名称
			DefUserExample defReportColExample = new DefUserExample();
			DefUserExample.Criteria criteria = defReportColExample.createCriteria();
			criteria.andReportCodeEqualTo(reportCode);
			List<DefReportCol> reportColInfoList = defReportColMapper.selectByExample(defReportColExample);
			//6.生成列编号与列名称的对应关系		
			Map<String, String> colNoToColNameMap = new HashMap<String, String>();
			for (DefReportCol defReportCol:reportColInfoList) {
				colNoToColNameMap.put(defReportCol.getColumnNo(), defReportCol.getColumnName());
			}
			reportMap.put("reportColNoToColNameMapping", colNoToColNameMap);
			//7.生成列编号与列编码的对应关系	
			Map<String, String> colNoToColCodeMap = new HashMap<String, String>();
			for (DefReportCol defReportCol:reportColInfoList) {
				colNoToColCodeMap.put(defReportCol.getColumnNo(), defReportCol.getColumnCode());
			}
			reportMap.put("reportColNoToColCodeMapping", colNoToColCodeMap);
			// sheet名称
			String reportName = reportMap.get("reportName").toString();
			reportMap.put("reportName", reportName);
			if (reportMap != null && reportMap.size() > 0 && queryReportList != null && queryReportList.size() > 0) {
				reportMap.put("reportData", queryReportList);
				reportList.add(reportMap);
			} else {
				Map<String, Object> emptyMap = new HashMap<String, Object>();
				// 查询结果为空时，放入Excel表头
				for(DefReportCol col:reportColInfoList){
					emptyMap.put(col.getColumnCode(), "");
				}
				queryReportList.add(emptyMap);
				reportMap.put("reportData", queryReportList);
				reportList.add(reportMap);
			}
			resultInfo.setObj(reportList);
			resultInfo.setSuccess(true);
		}
		return resultInfo;
	}
	//需要写此方法
	//获取表头信息
	public Map<String,String> getSheetParam1(Map<String,Object> reportMap,TDefCodeDict defCode,Map paramMap){
		//只需要重写此方法即可
		Map<String, String> colMap=new HashMap<String, String>();///////
		colMap.put("col0", "报表名称:");
		colMap.put("col1",  defCode.getCodeName());
		colMap.put("col2","起始日期:" );
		colMap.put("col3",(String) paramMap.get("startDate") );
		colMap.put("col4","截止日期:" );
		colMap.put("col5",(String) paramMap.get("endDate"));
		colMap.put("col6", "报送平台:");
		colMap.put("col7", (String) paramMap.get("comName"));
		colMap.put("col8", "业务类型:");
		colMap.put("col9", (String) paramMap.get("bussType"));
		colMap.put("col10", defCode.getCodeName()+"如下:");
		return colMap;
	}
	public Map<String,String> getSheetParam2(Map<String,Object> reportMap,TDefCodeDict defCode,Map paramMap){
		//只需要重写此方法即可
		Map<String, String> colMap=new HashMap<String, String>();///////
		colMap.put("col0", "报表名称:");
		colMap.put("col1",  defCode.getCodeName());
		colMap.put("col2","起始日期:" );
		colMap.put("col3",(String) paramMap.get("startDate") );
		colMap.put("col4","截止日期:" );
		colMap.put("col5",(String) paramMap.get("endDate"));
		colMap.put("col6", "报送平台:");
		colMap.put("col7", (String) paramMap.get("comName"));
		colMap.put("col8", "传输类型:");
		colMap.put("col9", (String) paramMap.get("bussType"));
		colMap.put("col10", defCode.getCodeName()+"如下:");
		return colMap;
	}
	//获取报表名称
	public TDefCodeDict getSheetName(String reportCode){
		TDefCodeDict defCode = codeQueryService.getQueryCode("reportCode", reportCode);
		return defCode;
	}
	/**
	 * 根据id获取机构名称
	 * @param id
	 * @return
	 */
	private String getComName(BigDecimal id){
		TDefPlatCom platCom = tDefPlatComMapper.selectByPrimaryKey(id);
		return platCom.getComName();
	}
	//获取Excel名称
	public String getExcelName(String param){
		String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String reportCode=JSONObject.fromObject(param).getString("flag");
		String excelName = reportCode +"-"+format+ ".xls";
		return excelName;
	}
	@SuppressWarnings("unchecked")
	public ResultInfo dealWithReport(String param) {
		ResultInfo resultInfo=new ResultInfo();
		Map<String,Object> reportMap=new HashMap<String,Object>();
		//解析请求参数
		Map paramMap=new HashMap();
		try {
			 param = new String(param.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JSONObject object = JSONObject.fromObject(param);
		String reportCode=object.getString("flag");
		paramMap.put("startDate",object.getString("startDate"));
		paramMap.put("endDate",object.getString("endDate"));
		paramMap.put("bussType", object.getString("bussType"));
		paramMap.put("reportCode",reportCode);
		paramMap.put("platCom", object.getString("platCom"));
		paramMap.put("comName", getComName(new BigDecimal(object.getString("platCom"))));
		// 查询需要导出的数据							//测试生成报表用
		//此结果根据业务需求来定
		if(reportCode.equals("BussExtractResult")){
			List<Map> queryReportList = this.tDefActionTraceMapper.exportExtractExcel(paramMap);
			//获取报表名称
			TDefCodeDict defCode=this.getSheetName(reportCode);
			reportMap.put("reportName", defCode.getCodeName());
			//此处需要重写
			
			reportMap.put("reportColNameMapping",this.getSheetParam2(reportMap, defCode, paramMap) );
			resultInfo=this.dealData(paramMap, resultInfo, queryReportList, reportMap);
		}else{
			List<Map> queryReportList = this.tDefActionTraceMapper.exportExcell(paramMap);
			//获取报表名称
			TDefCodeDict defCode=this.getSheetName(reportCode);
			reportMap.put("reportName", defCode.getCodeName());
			//此处需要重写
			
			reportMap.put("reportColNameMapping",this.getSheetParam1(reportMap, defCode, paramMap) );
			resultInfo=this.dealData(paramMap, resultInfo, queryReportList, reportMap);
		}
		
		
		return resultInfo;
	}
	@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
	@Override
	public Map<String, Object> getPageList(DataGridModel dgm, ParamPOJO pojo) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map paramMap=new HashMap();
		paramMap.put("startDate", pojo.getStartDate());
		paramMap.put("endDsate", pojo.getEndDate());
		paramMap.put("platCom", pojo.getComId());
		paramMap.put("bussType", pojo.getBussType());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total=tDefActionTraceMapper.queryCount(paramMap);
		List<Map> list=tDefActionTraceMapper.exportExcel(paramMap);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	@Override
	public List<Map> getTransType(Map<String, BigDecimal> map) {
		List<Map> list=tDefTransexcMapper.selectTransType(map);
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getTsList(DataGridModel dgm, ParamPOJO pojo) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map paramMap=new HashMap();
		paramMap.put("startDate", pojo.getStartDate());
		paramMap.put("endDate", pojo.getEndDate());
		paramMap.put("platCom", pojo.getComId());
		paramMap.put("bussType", pojo.getBussType());
		
		paramMap.put("queryStartIndex", dgm.getStartIndex());
		paramMap.put("queryEndIndex", dgm.getEndIndex());
		int total=tDefActionTraceMapper.listCount(paramMap);
		List<Map> list=tDefActionTraceMapper.listExcel(paramMap);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
}
