package com.sinosoft.ummp.task;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.sinosoft.platform.core.application.JobLogService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.model.TDefJobLog;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.exception.CISException;
import com.sinosoft.ummp.exception.CISExceptionRunable;

/**
 * <p>Title：调用批处理类</p>
 * <p>Description：根据传入的类名调用不同的批处理类</p>
 * @author Darker.Wang
 * @date 2016-8-16 下午6:22:38
 * @company SINOSOFT
 * @version 1.0
 */
public class Job {

	/**
	 * 执行MAIN方法
	 * @param args
	 */
	public static void main(String[] args) {
		doJob(args);
	}
	/**
	 * 执行JOB，开放接口,此处返回不代表批处理成功还是失败，只代表执行完毕与否 1-是 0-否
	 * @param args
	 */
    public static int doJob(String[] args){
    	/**
		 * 遍历参数
		 */
		for (int i = 0; i < args.length; i++) {
			int result = 0;
			try {
				result = interfaces(args[i]);
			}catch (CISException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(args[i]+" 执行异常："+DateUtils.getCurrentDateAndTime());
				System.out.println("- CISException: "+e.getMessage());
				result = 0;//以失败告终
				return result;
			}catch (SQLException se){
				se.printStackTrace();
				System.out.println(args[i]+" SQL异常："+DateUtils.getCurrentDateAndTime());
				System.out.println("- SQLException: "+se.getMessage());
				result = 0;//以失败告终
				return result;
			}finally{
				showResult(args[i],result);
			}
		}
		return 1;
    }
    /**
     * 显示执行结果
     * @param jobName
     * @param result
     */
    private static void showResult(String jobName,int result){
    	switch(result){
    		case 1 :
    			System.out.println("批处理："+jobName+" 执行成功：\n"+result);
    		break;
    		case 0 :
    			System.out.println("批处理："+jobName+" 执行失败：\n"+result);
    		break;
    		case -1 :
    			System.out.println("批处理："+jobName+" 执行异常：\n"+result);
    		break;
    		default:
    			System.out.println("批处理："+jobName+" 返回越界：\n"+result);
    	}
    }
	/**
	 * job接口,1-成功  0-失败 [非0即true 原则]
	 * @param className
	 * @throws CISException
	 */
	protected static int interfaces(String className) throws CISException,SQLException{
		int result = 0;
        System.out.println("- JobClassName : "+className);
        TDefJobLog jobLog = null;
        JobLogService jobLogService = null ;
        SuperJob newInstance;
		try {
			newInstance = newInstance(className);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("初始化SupperJob异常，找不到类："+className);
			return -1;
		}catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("初始化SupperJob异常："+e.getMessage());
			return -1;
		}
        try {
        	
			//TODO 1、构造插入批处理日志：
			jobLogService = (JobLogService) newInstance.context.getBean("jobLogService");
			SequenceService sequenceService = (SequenceService) newInstance.context.getBean("sequenceService");
			BigDecimal id = sequenceService.getBigSeqValByName(JobLogService.JOB_LOG_SEQ);
			System.out.println("- Job Log ID : "+id);
			String jobGroup = newInstance.getJobGroup();
			jobLog = buildJobLog(jobGroup,className,DateUtils.getCurrentTime(),null,"2","正在执行...");
			jobLog.setId(id);
			jobLogService.insertJobLog(jobLog);
			//TODO 2、执行JOB
			if(newInstance.excute()){//成功返回0
				jobLog.setEndTime(DateUtils.getCurrentTime());
				jobLog.setJobStatus("9");
				jobLog.setRunMsg("执行成功");
				result = 1;
			}else{
				jobLog.setEndTime(DateUtils.getCurrentTime());
				jobLog.setJobStatus("4");
				jobLog.setRunMsg("执行失败");
				result = 0;
			}
		} catch (Exception e2) {
			e2.printStackTrace();
			result = -1;
			String msg = "执行JOB异常: IllegalAccessException";
			jobLog.setEndTime(DateUtils.getCurrentTime());
			jobLog.setJobStatus("3");
			jobLog.setRunMsg(msg);
			CISException cis = new CISException(msg);
			cis.setLevel(CISExceptionRunable.EXCEPTION_ERROR_L3);
			cis.setException(e2);
			throw cis;
		}
        finally{
			if(jobLogService != null){
				jobLog.setLastModifyTime(DateUtils.getCurrentTimestamp());
				jobLogService.updateJobLog(jobLog);
			}else{
				System.out.println(className+"失败原因: SPRING 中获取容器 JobLogService 失败！");
				result = -1;
			}
			if(newInstance != null){
				newInstance.destroy();
			}
		}
        return result;
	}

	private static SuperJob newInstance(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException{
		String tClassName = "com.sinosoft.ummp.task.job.impl."+className;
    	System.out.println("- JobClassNameDetail : "+tClassName);
		Class<?> c = Class.forName(tClassName);
		SuperJob newInstance = (SuperJob) c.newInstance();
		System.out.println("- LoginInfo: "+newInstance.loginInfo.getUserCode());
		System.out.println("- GenericXmlApplicationContext: "+newInstance.context);
		return newInstance;
	}
	/**
	 * 获取JOB壳子，不包含ID
	 * @param className
	 * @param startDate
	 * @param endDate
	 * @param status
	 * @return
	 */
	private static TDefJobLog buildJobLog(String jobGroup,String className,String startTime,String endTime,String status,String runMsg){
		TDefJobLog jobLog = new TDefJobLog();
		jobLog.setJobName(className.toUpperCase());
		jobLog.setJobCode(className);
		jobLog.setJobGroup(jobGroup);
		jobLog.setJobStatus(status);
		jobLog.setRunMsg(runMsg);
		jobLog.setStartTime(startTime);
		jobLog.setEndTime(endTime);
		jobLog.setJobType("SHELL");
		jobLog.setOperator(Constants.JOB_USER);
		jobLog.setInsertTime(DateUtils.getCurrentTimestamp());
		jobLog.setLastModifyTime(DateUtils.getCurrentTimestamp());
		return jobLog;
	}
}
