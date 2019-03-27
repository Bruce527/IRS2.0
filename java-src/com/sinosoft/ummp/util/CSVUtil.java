package com.sinosoft.ummp.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.CError;
/**
 * CSV 工具类
 * @author MrWang  move by pzz
 * @date 2016-09-28
 */
public class CSVUtil {

	public static CErrors cErrors = new CErrors();
	public static boolean isCOSucess=false;
	public static final String ENCODE = "UTF-8";
	public CSVUtil() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 数字校验
	 * @param value
	 * @return
	 */
	public static boolean checkNumber(String value){
		String regex = "^(-?[1-9]\\d*\\.?\\d*)|(-?0\\.\\d*[1-9])|(-?[0])|(-?[0]\\.\\d*)$";
		return value.matches(regex);
	}
	/**
	 * 纯数字校验
	 * @param value
	 * @return
	 */
	public static boolean checkNumberPure(String value){
		String regex = "^([1-9]\\d*)||([0]\\d*)";
		return value.matches(regex);
	}
	/**
     * 导出
     * @param file csv文件(路径+文件名)
     * @param dataList 数据
     * @return
     */
    public static boolean exportCsv(File file, List<List<String>> dataList){
        boolean isSucess=false;
        
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        
        try {
            out = new FileOutputStream(file,true);//true 追加
            osw = new OutputStreamWriter(out,ENCODE);
            bw = new BufferedWriter(osw);
            int index = 0;
            if(dataList!=null && !dataList.isEmpty()){
                for(List<String> datas : dataList){
                	StringBuffer sb = new StringBuffer("");
                	Iterator<String> iter = datas.iterator();
                	while(iter.hasNext()){
                		String data = iter.next();
                		sb.append(data);
                		if(iter.hasNext()){
                			sb.append(",");
                		}
                	}
                	if(index < dataList.size()){
                		sb.append("\n");
                	}
                	System.out.println(sb.toString());
                	bw.write(sb.toString());
                	index ++;
                }
            }
            
            //流FLUSH
            bw.flush();
            osw.flush();
            out.flush();
            
            isSucess=true;
        } catch (Exception e) {
            CError cError = new CError();
            cError.errorMessage = "导出数据流异常："+e.getMessage();
            cErrors.addOneError(cError);
        	isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
        
        return isSucess;
    }
    /**
     * 导入
     * @param file csv文件(路径+文件)
     * @return
     */
    public static List<String[]> importCsv(File file){
        List<String[]> dataList=new ArrayList<String[]>();
        
        BufferedReader br=null;
        try { 
            br = new BufferedReader(new FileReader(file));
            String line = ""; 
            while ((line = br.readLine()) != null) {
            	String[] lines = line.split(",");
            	dataList.add(lines);
            	line = null;
            }
        }catch (Exception e) {
        	CError cError = new CError();
            cError.errorMessage = "导入数据异常："+e.getMessage();
            cErrors.addOneError(cError);
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return dataList;
    }

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		List<List<String>> dataList = new ArrayList<List<String>>();
//		List<String> datas = null;
//		for(int I = 1;I<=10000;I++){
//			datas = new ArrayList<String>();
//			for(int i = 1;i<=100;i++){
//				datas.add("第"+I+"-"+i+"列");
//			}
//			dataList.add(datas);
//		}
//		CSVUtil.exportCsv(new File("D:\\test\\myCSV.csv"), dataList);
//		List<String[]> results = CSVUtil.importCsv(new File("D:\\test\\myCSV.csv"));
//		for(String[] result : results){
//			for(String temp : result){
//				System.out.print(temp+" ");
//			}
//			System.out.println();
//		}
//		//RN,CODETYPE,CODE,CODENAME,CODEALIAS,COMCODE,OTHERSIGN
//		String[] head = new String[]{"RN","CODETYPE","CODE","CODENAME","CODEALIAS","COMCODE","OTHERSIGN"};
//		String sql = "select rownum as rn,t.* from ldcode t where 1=1 order by t.codetype";
//		String file = "D:/ciim/"+System.currentTimeMillis()+"_LDCODE.csv";
//		export2Csv(head,sql,file);
//		
//		System.out.println(checkNumber("00003120150000000639"));
//	}

}
