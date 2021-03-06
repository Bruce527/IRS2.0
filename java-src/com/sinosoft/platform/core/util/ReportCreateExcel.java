package com.sinosoft.platform.core.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;
/**
 * 报表导出Excel
 * @author Darker.Wang
 * @date 2016-8-11 下午5:42:50
 * @company SINOSOFT
 */
public class ReportCreateExcel extends AbstractExcelView {

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workBook, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List<Map<String, Object>> reportList = (List<Map<String, Object>>)model.get("reportList");
		if (reportList==null||reportList.size()==0) {
			return;
		}
		//list中包含多个sheet信息，即每个map就是一个sheet，每个map中包含如下信息：reportName(报表名称，即sheet名称,类型String)
		//reportColNameMapping(生成表头的相关信息，类型map)
		//reportColNoToColNameMapping(生成列编号与列名称的对应关系，类型map)
		//reportColNoToColCodeMapping(生成列编号与列编码的对应关系，类型map)
		//reportData(报表数据，类型List<map>)
		for (Map<String, Object> reportMap:reportList) {
			//获取报表相关信息
			String reportName = (String)reportMap.get("reportName");
			Map<String, String> reportColNameMapping = (Map<String, String>)reportMap.get("reportColNameMapping");
			Map<String, String> reportColNoToColCodeMapping = (Map<String, String>)reportMap.get("reportColNoToColCodeMapping");
	        Map<String, String> reportColNoToColNameMapping = (Map<String, String>)reportMap.get("reportColNoToColNameMapping");
	        List<Map> reportData = (List<Map>)reportMap.get("reportData");
			//创建Excel sheet
	        HSSFSheet sheet = workBook.createSheet(reportName);
			
			//表格宽度
	        sheet.setDefaultColumnWidth(20);
			//生成表头
	        int n=0,m=0/*,o=1*/;
	        for (int i = 0 ; i <= reportColNameMapping.size(); i++,m++) {
	        	if(m==2){
	        		m=0;
	        		n++;
	        	}
	        	String colNo = "col"+i;
                HSSFCell cell = getCell(sheet, n, m);
                setText(cell, reportColNameMapping.get(colNo));
			}
	        n++;
	        //字段名称
	        for (int i = 0; i <= reportColNoToColNameMapping.size(); i++) {
	        	String colNo = "col"+i;
                HSSFCell cell = getCell(sheet, n, i);
                setText(cell, reportColNoToColNameMapping.get(colNo));
			}
	        n++;
	        //写入查询数据
	        if (reportData!=null) {
	            for (Map rowDataMap:reportData) {
		            HSSFRow sheetRow = sheet.createRow(n);
		            
//		            sheetRow.createCell(0).setCellValue(o);
//		            for (int i = 1; i <= reportColNoToColCodeMapping.size()-1; i++) {
		            if(n<=60000){
			            	for (int i = 0; i <= reportColNoToColCodeMapping.size(); i++) {
			            	String colNo = "col"+i;
			            	String colCode = reportColNoToColCodeMapping.get(colNo);
			            	if (rowDataMap.containsKey(colCode)&&rowDataMap.get(colCode)!=null) {
			            		String cellVal = rowDataMap.get(colCode).toString();
				                sheetRow.createCell(i).setCellValue(cellVal);
							}
			            }
			            n++;//o++;
		            }else{
		            	int x=0,y=0/*,o=1*/;
		            	if(n==60001){
			            	//创建Excel sheet
		            		HSSFSheet sheet1 = workBook.createSheet("sheet2");
			    			//表格宽度
			    	        sheet.setDefaultColumnWidth(10);
			    	      //生成表头
			    	        for (int i = 0 ; i <= reportColNameMapping.size(); i++,x++) {
			    	        	if(x==2){
			    	        		x=0;
			    	        		x++;
			    	        	}
			    	        	String colNo = "col"+i;
			                    HSSFCell cell = getCell(sheet, y, x);
			                    setText(cell, reportColNameMapping.get(colNo));
			    			}
			    	        y++;
			    	        //字段名称
			    	        for (int i = 0; i <= reportColNoToColNameMapping.size(); i++) {
			    	        	String colNo = "col"+i;
			                    HSSFCell cell = getCell(sheet, y, i);
			                    setText(cell, reportColNoToColNameMapping.get(colNo));
			    			}
			    	        y++;
		            	}
		            	
		    	        for (int i = 0; i <= reportColNoToColCodeMapping.size(); i++) {
			            	String colNo = "col"+i;
			            	String colCode = reportColNoToColCodeMapping.get(colNo);
			            	if (rowDataMap.containsKey(colCode)&&rowDataMap.get(colCode)!=null) {
			            		String cellVal = rowDataMap.get(colCode).toString();
				                sheetRow.createCell(i).setCellValue(cellVal);
							}
			            }
		    	        y++;
		            }
				}
			}
		}
	}

	
	public void test(Map<String, Object> model,
			HSSFWorkbook workBook, HttpServletRequest request, HttpServletResponse response){
		//创建Excel sheet
		HSSFSheet sheet = workBook.createSheet("财富产品结算");
		//表格宽度
        sheet.setDefaultColumnWidth(12);
        
        String[] columnName = {"交易号","产品名称","交易日期","费用类型","费用金额"};
        for (int i = 0; i <= columnName.length; i++) {
        	if (i != 0) {
                HSSFCell cell = getCell(sheet, 0, i);
                setText(cell, columnName[i-1]);
            } else {
                HSSFCell cell = getCell(sheet, 0, 0);
                setText(cell, "序号");
            }
		}
        List<Map<String, String>> result = new ArrayList<Map<String,String>>();
        Map<String, String> row1 = new HashMap<String, String>();
        Map<String, String> row2 = new HashMap<String, String>();
        row1.put("col1", "201504010001");
        row1.put("col2", "产品1");
        row1.put("col3", "2015-05-01");
        row1.put("col4", "固定管理费");
        row1.put("col5", "100.00");
        
        row2.put("col1", "201504010002");
        row2.put("col2", "产品2");
        row2.put("col3", "2015-05-02");
        row2.put("col4", "固定管理费");
        row2.put("col5", "128.98");
        
        result.add(row1);
        result.add(row2);
        
        int row = 1;
        for (Map<String, String> rowMap:result) {
        	HSSFRow sheetRow = sheet.createRow(row);
            sheetRow.createCell(0).setCellValue(row);
            for (int i = 1; i <= columnName.length; i++) {
            	String key = "col"+i;
            	String cellVal = rowMap.get(key);
                sheetRow.createCell(i).setCellValue(cellVal);
            }
            row++;
		}
	}
}
