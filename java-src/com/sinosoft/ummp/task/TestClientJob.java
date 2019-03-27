/**
 * 
 */
package com.sinosoft.ummp.task;


/**
 * JOB批处理测试端
 * @author Darker.Wang
 * @date 2016-8-11 下午8:30:35
 * @company SINOSOFT
 */
public class TestClientJob {
	//1、PRPCreateFileJob 2、PRPUploadFileJob 
	//3、PRPSubmitIUJob   4、PRPSubmitIRQJob 
	//5、PRPSubmitSCJob   6、PRPSubmitSCRQJob
	public static void main(String args[]){
		args = new String[]{"PRPSubmitIRQJob"}; 
		Job.doJob(args);
	}
}
