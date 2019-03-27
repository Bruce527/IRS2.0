package com.sinosoft.ummp.application;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.ResultInfo;



public interface ReportService{

	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	ResultInfo exportExcel(Map paramMap);

	ResultInfo dealWithReport(String param);

	String getExcelName(String param);

	Map<String, Object> getPageList(DataGridModel dgm,  ParamPOJO pojo);

	List<Map> getTransType(Map<String, BigDecimal> map);

	Map<String, Object> getTsList(DataGridModel dgm, ParamPOJO pojo);
	
}
