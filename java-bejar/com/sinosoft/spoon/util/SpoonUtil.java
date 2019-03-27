package com.sinosoft.spoon.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.pentaho.di.core.KettleEnvironment;
import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.util.EnvUtil;
import org.pentaho.di.job.Job;
import org.pentaho.di.job.JobMeta;
import org.pentaho.di.trans.Trans;
import org.pentaho.di.trans.TransMeta;

import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.spoon.config.SpoonConfig;
import com.sinosoft.spoon.ktr.SpoonKtr;

/**
 * SPOON 执行工具类
 * @author DARKER
 * @date 2015-11-18
 */
public class SpoonUtil {

	public CErrors cErrors = new CErrors();
	public String cErrorCode = "";
	public String cErrorMessage = "";
	
	/**
	 * 标准化执行带参数KTR，
	 * @param ktr
	 * @param params 顺序与KTR中保持一致
	 * @return
	 */
	public boolean doKtrTrans(String ktr,Map<String,String> params){
		try {
        	System.out.println(" SPOON GET DATA KTR: " +ktr);
            KettleEnvironment.init();
            EnvUtil.environmentInit();
            TransMeta transMeta = new TransMeta(ktr);
            Trans trans = new Trans(transMeta);
            
            Iterator<String> iter = params.keySet().iterator();
			while(iter.hasNext()){
				String key = iter.next();
				String value = params.get(key);
				trans.setParameterValue(key, value);
			}
			trans.execute(new String[]{""});
            trans.waitUntilFinished();
            if ( trans.getErrors() > 0 ){
                throw new RuntimeException( " There were errors during transformation execution."  );
            }
            
            transMeta.clear();
            trans.clearParameters();
            
            transMeta = null;
            trans = null;
            
            return true;
        }catch (Exception e) {
			//e.printStackTrace();
			cErrorMessage = e.getMessage();
			CError cError = new CError();
			cError.errorMessage = cErrorMessage;
			cError.functionName=".doKtrTrans";
			cError.moduleName="com.sinosoft.spoon.util.SpoonUtil";
			cErrors.addOneError(cError);
			return false;
		}
	}
	/**
	 * 执行指定的Job
	 * @param job
	 * @param params
	 * @return
	 */
	public boolean doAJob(String job,Map<String,String> params){
		try {
			//1、第一步调取JOB
			EnvUtil.environmentInit();
			KettleEnvironment.init();
			
			JobMeta jobMeta = new JobMeta(job, null);
			Job j = new Job(null, jobMeta);
			
			// 向Job 脚本传递参数，脚本中获取参数值：${参数名}
			//些许参数配在validation.properties、ESAPI.properties
			Iterator<String> iter = params.keySet().iterator();
			while(iter.hasNext()){
				String key = iter.next();
				String value = params.get(key);
				j.setVariable(key, value);
				System.out.println("PARAM:"+key+" "+value);
			}
			j.start();
			j.waitUntilFinished();
			
			if (j.getErrors() > 0) {
				System.out.println(job+" DECOMPRESS FAIL !" );
			}
			System.out.println("====== JOB RESULT "+j.getResult().getLogText());
			
			jobMeta.clear();
			j.clearParameters();
			
			jobMeta = null;
			j = null;
			
			return true;
		} catch (Exception e) {
            System.out.println(" WHEN KTR EXISTS WEHERE THE NAME IS CONFIRM：" +e);
            e.printStackTrace();
            return false;
		}
	}
	/**
	 * 标准化执行带参数KTR，
	 * @param ktr
	 * @param params 顺序与KTR中保持一致
	 * @return
	 */
	public boolean doKtrTransByJob(String ktr,Map<String,String> params){
		cErrors.clearErrors();
		String jobname = SpoonKtr.class.getResource("").getPath()+"controljob.kjb" ;
		System.out.println(" KTR-JOB: " +jobname);
		try {
			//1、第一步调取JOB
			EnvUtil.environmentInit();
			KettleEnvironment.init();
			
			TransMeta transMeta = new TransMeta(ktr);
			Trans t = new Trans();
			t.setTransMeta(transMeta);
			JobMeta jobMeta = new JobMeta(jobname, null);
			Job job = new Job(null, jobMeta);
			
			// 向Job 脚本传递参数，脚本中获取参数值：${参数名}
			job.setParentTrans(t);
			job.setInternalKettleVariables(jobMeta);
			job.setVariable("path" , ktr);
			Iterator<String> iter = params.keySet().iterator();
			while(iter.hasNext()){
				String key = iter.next();
				String value = params.get(key);
				job.setVariable(key, value);
				System.out.println("PARAM: "+key+" "+value);
			}
			job.start();
			job.waitUntilFinished();
			
			if (job.getErrors() > 0) {
				System.out.println(jobname+" DECOMPRESS FAIL !" );
			}
			
			System.out.println("====== JOB RESULT "+job.getResult().getLogText());
			
			job.clearParameters();
			t.clearParameters();
			jobMeta.clear();
			
			job = null;
			t = null;
			jobMeta = null;
			
			return true;
		} catch (Exception e) {
			System.out.println(" WEHERE THE KTR FILE IS EXISTS ：" +ktr);
            System.out.println(" WHEN KTR EXISTS WEHERE THE NAME IS CONFIRM：" +e);
            //e.printStackTrace();
            throw new RuntimeException( " There were errors during transformation execution."  );
		}  
	}
	
	/**
	 * 初始化参数
	 * @return
	 */
	public Job initJobVariable(Job job) {
		Properties prop;
		try {
			prop = SpoonConfig.getInstance().getProFile("spoon.variable.properties");
			Set<Entry<Object, Object>> keyset = prop.entrySet();
			Iterator<Entry<Object, Object>> iter = keyset.iterator();
			while(iter.hasNext()){
				Entry<Object, Object> keyen = iter.next();
				String key = (String) keyen.getKey();
				String value = prop.getProperty(key);
				System.out.println("初始化环境参数：\t key: "+key+"\tvalue: "+value);
				job.setVariable(key, value);
			}
		} catch (FileNotFoundException e) {
			System.out.println(" INIT VARIABLCAUSE CONFIG FILE CAN NOT FOND");
			e.printStackTrace();
			return job;
		} catch (IOException e) {
			System.out.println(" INIT VARIABLCAUSE CONFIG FILE IOEXCEPTION");
			e.printStackTrace();
			return job;
		}
		return job;
	}

	/**
	 * 获取公共参数：环境变量
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public Map<String,String> getPubVariable() throws FileNotFoundException, IOException{
		Map<String,String> params = new HashMap<String,String>();
		Properties prop = SpoonConfig.getInstance().getProFile("spoon.variable.properties");
		Set<Entry<Object, Object>> keyset = prop.entrySet();
		Iterator<Entry<Object, Object>> iter = keyset.iterator();
		while(iter.hasNext()){
			Entry<Object, Object> keyen = iter.next();
			String key = (String) keyen.getKey();
			String value = prop.getProperty(key);
			params.put(key, value);
		}
		return params;
	}
	
	/**
	 * 从目标库提数到B表,原生态
	 * @param tableName
	 * @param SQL
	 * @param startDate
	 * @param endDate
	 * @param busstype
	 * @param busstypebatch
	 * @param bussno
	 * @param bussnobatch
	 * @return
	 */
	public boolean doGetJobBySql(String tableName, String SQL){
		String jobname = SpoonKtr.class.getResource("").getPath()+"controljob.kjb" ;
		System.out.println(" KTR-JOB: " +jobname);
		String ktr1 = SpoonKtr.class.getResource("").getPath()+"o2b/"+tableName+".ktr";
		System.out.println(" KTR1-PATH: "+ktr1);
		try {
			//1、第一步调取JOB
			KettleEnvironment.init();
			// jobname 是Job脚本的路径及名称
			JobMeta jobMeta = new JobMeta(jobname, null);
			Job job = new Job(null, jobMeta);
			// 向Job 脚本传递参数，脚本中获取参数值：${参数名}
			job.setVariable("path" , ktr1);
			job.setVariable("sql" , SQL);
			job.start();
			job.waitUntilFinished();
			if (job.getErrors() > 0) {
				System.out.println(jobname+" decompress fail!" );
			}
			System.out.println("====== JOB RESULT "+job.getResult().getLogText());
			
			job.clearParameters();
			jobMeta.clear();
			
			job = null;
			jobMeta = null;
			SQL = null;
			
			return true;
		} catch (KettleException e) {
			System.out.println(e);
			return false;
		}
	}
	/**
	 * 初始化 变更表与交易流水号的
	 * @param hasmap
	 */
	public boolean initCHG_TRANS_ID_MAP(Map<String,String> params) throws Exception{
		String ktr = SpoonKtr.class.getResource("").getPath()+"CHG_TRANS_ID_MAP.ktr";
		System.out.println("初始化CHG_TRANS_ID_MAP:"+ktr);
		boolean result = doKtrTransByJob(ktr,params);
		System.out.println("初始化CHG_TRANS_ID_MAP："+result);
		if(!result){
			cErrorMessage = "初始化数据失败：请检查数据库连接是否正常！";
		}
		return result;
	}
	/**
	 * 错误信息封装
	 * @param funcName
	 * @param msg
	 * @return
	 */
	public boolean buildError(String funcName,String msg){
		CError cError = new CError();
		cError.errorMessage = msg;
		cError.functionName = funcName;
		cErrors.addOneError(cError);
		System.out.println(cError.errorMessage);
		return true;
	}
	public static void main(String[] args) throws Exception {
		//TODO SOMETHING
		
	}
}
