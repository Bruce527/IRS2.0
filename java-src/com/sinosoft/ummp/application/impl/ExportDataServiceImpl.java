package com.sinosoft.ummp.application.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.mapper.DefReportColMapper;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.mapper.TDefUserMapper;
import com.sinosoft.platform.core.domain.model.DefReportCol;
import com.sinosoft.platform.core.domain.model.DefUserExample;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.util.ResultInfo;
import com.sinosoft.ummp.application.ExportDataService;
import com.sinosoft.ummp.domain.mapper.TPrpLcclaimgetrateMapper;
import com.sinosoft.ummp.domain.mapper.TPrpLcphonecompleterateMapper;
import com.sinosoft.ummp.domain.mapper.TPrpLcpolicydeliveryrateMapper;
import com.sinosoft.ummp.domain.mapper.TPrpLcpreservationperiodMapper;
import com.sinosoft.ummp.domain.mapper.TPrpLcreviewsuccessrateMapper;
@Service
public class ExportDataServiceImpl implements ExportDataService {

	@Autowired
	TDefUserMapper tDefUserMapper;
	@Autowired
	TDefCodeDictMapper tDefCodeDictMapper;
	@Autowired
	TPrpLcclaimgetrateMapper tPRPLCClaimGetRateMapper;
	@Autowired
	TPrpLcphonecompleterateMapper tPRPLCPhoneCompleteRateMapper;
	@Autowired
	TPrpLcpolicydeliveryrateMapper tPRPLCPolicyDeliveryRateMapper;
	@Autowired
	TPrpLcpreservationperiodMapper tPRPLCPreservationPeriodMapper;
	@Autowired
	TPrpLcreviewsuccessrateMapper tPRPLCReviewSuccessRateMapper;
	@Autowired
	DefReportColMapper defReportColMapper;
	@Autowired
	CodeQueryService codeQueryService;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 获取年份
	 */
	@Override
	public List<String> selectExportDataYear() {
		// TODO Auto-generated method stub
		
		return tDefUserMapper.selectExportDataYear();//借用user表去查询年份
	}
	
	/**
	 * 获取目标表
	 */
	@Override
	public List<String> selectExportDataTab() {
		// TODO Auto-generated method stub
		
		return tDefCodeDictMapper.selectExportTab();
	}
	
	/**
	 * query tabname by tabcode(exportDataTab)
	 */
	@Override
	public String getExportDataTabName(String exportDataTab) {
		// TODO Auto-generated method stub
		TDefCodeDict tDefCodeDict = tDefCodeDictMapper.selectExportTabName(exportDataTab);
		return tDefCodeDict.getCodeName();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public ResultInfo dealWithReport(String param) {
		ResultInfo resultInfo=new ResultInfo();
		Map<String,Object> reportMap=new HashMap<String,Object>();
		//解析请求参数
		Map paramMap=new HashMap();
		JSONObject object = JSONObject.fromObject(param);
		String tabCode=object.getString("tabCode");
		String year = object.getString("dataYear").trim();
		paramMap.put("dataYear",year);
		System.out.println("#########"+object.getString("dataYear")+"#######");
		paramMap.put("tabCode",object.getString("tabCode"));
		// 查询需要导出的数据
		//此结果根据业务需求来定
		/**
		 * 判断该导出哪个表的数据
		 */
		List<Map> queryReportList = null;
		if(tabCode.equalsIgnoreCase("T_PRP_LCClaimGetRate")){
			queryReportList = this.tPRPLCClaimGetRateMapper.exportExcel(paramMap);
		}else if(tabCode.equalsIgnoreCase("T_PRP_LCPhoneCompleteRate")){
			queryReportList = this.tPRPLCPhoneCompleteRateMapper.exportExcel(paramMap);
		}else if(tabCode.equalsIgnoreCase("T_PRP_LCPolicyDeliveryRate")){
			queryReportList = this.tPRPLCPolicyDeliveryRateMapper.exportExcel(paramMap);
		}else if(tabCode.equalsIgnoreCase("T_PRP_LCPreservationPeriod")){
			queryReportList = this.tPRPLCPreservationPeriodMapper.exportExcel(paramMap);
		}else if(tabCode.equalsIgnoreCase("T_PRP_LCReviewSuccessRate")){
			queryReportList = this.tPRPLCReviewSuccessRateMapper.exportExcel(paramMap);
		}
		
		//获取导出表的名称
		TDefCodeDict defCode=this.getSheetName(tabCode);
		reportMap.put("tabName", defCode.getCodeName());
		//此处需要重写
		
		reportMap.put("reportColNameMapping",this.getSheetParam1(reportMap, defCode, paramMap) );
		resultInfo=this.dealData(paramMap, resultInfo, queryReportList, reportMap);
		
		return resultInfo;
	}
		
		//获取报表名称
		public TDefCodeDict getSheetName(String reportCode){
			TDefCodeDict defCode = codeQueryService.getQueryCode("IMPORT_TABLE", reportCode);
			return defCode;
		}
		
		//获取Excel名称
		public String getExcelName(String param){
			String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String reportCode=JSONObject.fromObject(param).getString("tabCode");
			String excelName = reportCode +"-"+format+ ".csv";
			return excelName;
		}
	
		//需要写此方法
		//获取表头信息
		@SuppressWarnings("rawtypes")
		public Map<String,String> getSheetParam1(Map<String,Object> reportMap,TDefCodeDict defCode,Map paramMap){
				//只需要重写此方法即可
				Map<String, String> colMap=new HashMap<String, String>();
				colMap.put("col0", "导出表名:");
				colMap.put("col1",  defCode.getCodeName());
				colMap.put("col2", "导出年份:");
				String dataYear=((String)paramMap.get("dataYear")).trim();//拼接前将所有空格去掉
				colMap.put("col3",dataYear+"年" );
				colMap.put("col4", defCode.getCodeName()+"如下:");
				return colMap;
		}
		
		//报表业务处理方法
		@SuppressWarnings("rawtypes")
		public ResultInfo dealData(Map paramMap,ResultInfo resultInfo,List<Map> queryReportList,Map<String,Object> reportMap){

			String tabCode=(String) paramMap.get("tabCode");
			List<Map<String, Object>> reportList = new ArrayList<Map<String, Object>>();
//			 3.判断Mapper层返回的数据
			if (queryReportList != null) {
				//4.获取报表的列编号，列编码，列名称
				DefUserExample defReportColExample = new DefUserExample();
				DefUserExample.Criteria criteria = defReportColExample.createCriteria();
				criteria.andReportCodeEqualTo(tabCode);
				List<DefReportCol> reportColInfoList = defReportColMapper.selectByExample(defReportColExample);
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
				String reportName = reportMap.get("tabName").toString();
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
		
}
