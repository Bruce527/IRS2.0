package com.sinosoft.platform.core.util;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

/**
 * Excel 操作工具类
 * @author Darker.Wang
 * @date 2016-8-11 下午5:32:55
 * @company SINOSOFT
 */
public class ExcelUtil {
	int mapIndex=0;
		 /**
		  * @Title: exportExcel
		  * @Description: 导出Excel的方法
		  * @param workbook 
		  * @param sheetNum (sheet的位置，0表示第一个表格中的第一个sheet)
		  * @param sheetTitle  （sheet的名称）
		  * @param headers    （表格的标题）
		  * @param result   （表格的数据）
		  * @param out  （输出流）
		  * @throws Exception
		  */
	public void exportExcel(HSSFWorkbook workbook, int sheetNum,
		 		 		 String sheetTitle, String[] headers, List<Map> result,
		 		 		 OutputStream out) throws Exception {
		 		 // 生成一个表格
		 		 HSSFSheet sheet = workbook.createSheet();
		 		 workbook.setSheetName(sheetNum, sheetTitle);
		 		 // 设置表格默认列宽度为20个字节
		 		 sheet.setDefaultColumnWidth(20);
		 		 // 生成一个样式
		 		 HSSFCellStyle style = workbook.createCellStyle();
		 		 // 设置这些样式
		 		 style.setFillForegroundColor(HSSFColor.PALE_BLUE.index);
		 		 style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		 		 style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		 		 style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		 		 style.setBorderRight(HSSFCellStyle.BORDER_THIN);
//		 		 style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		 		 style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		 		 // 生成一个字体
		 		 HSSFFont font = workbook.createFont();
		 		 font.setColor(HSSFColor.BLACK.index);
//		 		 font.setFontHeightInPoints((short) 12);
		 		 font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		 		 // 把字体应用到当前的样式
//		 		 style.setFont(font);

		 		 // 指定当单元格内容显示不下时自动换行
		 		 style.setWrapText(true);

		 		 // 产生表格标题行
		 		 HSSFRow row = sheet.createRow(0);
		 		 for (int i = 0; i < headers.length; i++) {
						HSSFCell cell = row.createCell(i);
//		 		 		 cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		 		 		 cell.setCellStyle(style);
		 		 		 HSSFRichTextString text = new HSSFRichTextString(headers[i]);
		 		 		 cell.setCellValue(text.toString());
		 		 }
		 		 // 遍历集合数据，产生数据行
		 		 if(result !=null){
//		 			 int rowIndex=1;
//		 			 int cellIndex=0;
		 			 for(int i=0;i<result.size();i++){
		 				 row=sheet.createRow(i+1);
		 				 Map<String,Object> map = result.get(i);
		 				 for(int j=0;j<map.size();j++){
		 					 HSSFCell cell=row.createCell(j);
		 					 if(map.get(headers[j])==null){
		 						cell.setCellValue("");
		 					 }else{
		 						 cell.setCellValue(map.get(headers[j])+"");
		 					 }
		 				 }
//		 				cellIndex++;
//		 				rowIndex++;
		 				mapIndex++;
		 			 }
		 		 }
		 }






		//测试数据：（再D盘下生成test.xls文件，并有多个sheet）
		 public static void main(String[] args) {
		 		 try {
		 			 	String name="D:\\helloNimei.xls";
		 			 	OutputStream out=new FileOutputStream(name);
		 			 	Map<Integer,Object> map=new HashMap<Integer,Object>();
		 			 	Map<Integer,String> data=new HashMap<Integer,String>();
		 			 	for(int i=0;i<5;i++){
		 			 		Map<Integer,String> result=new HashMap<Integer,String>();
		 			 		result.put(i, "记录总数为："+i);
		 			 		map.put(i, result);
		 			 	}
		 			 	ExcelUtil util=new ExcelUtil();
		 			 	 String[] headers={"key","value"};
		 			 	 HSSFWorkbook workbook=new HSSFWorkbook();
		 			 	 for(int k=0;k<map.size();k++){
		 			 		 data = (Map<Integer, String>) map.get(k); 
//		 			 		 util.exportExcel(workbook, k, k+"shit", headers, data, out);
		 			 	 }
		 			 	 workbook.write(out);
		 			 	 out.close();
		 			 	 System.out.println("输出完毕");
		 		 } catch (Exception e) {
		 		 		 e.printStackTrace();
		 		 }
		 }
}

