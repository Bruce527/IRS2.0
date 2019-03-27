package com.sinosoft.ummp.application;

import java.util.List;

import com.sinosoft.platform.core.util.ResultInfo;


/**
 * 评价数据导出接口
 * @author kong
 *
 */
public interface ExportDataService {
	
	
	/**
	 * export data interface
	 */
	public List<String> selectExportDataYear();
	
	
	/**
	 * query importtable
	 * @return List
	 */
	public List<String> selectExportDataTab();

	/**
	 *  query tabname
	 * @param exportDataTab
	 * @return 
	 */
	public String getExportDataTabName(String exportDataTab);


	public ResultInfo dealWithReport(String param);


	public String getExcelName(String param);
}
