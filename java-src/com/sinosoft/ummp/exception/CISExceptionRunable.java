/**
 * 
 */
package com.sinosoft.ummp.exception;

/**
 * 异常信息可实现定义接口
 * @author Darker.Wang
 * @date 2016-8-10 下午2:25:49
 * @company SINOSOFT
 */
public interface CISExceptionRunable {

	//错误异常级别定义
	/** 错误级别1 特别严重的异常：会调取监控中心 **/
	public static final int EXCEPTION_ERROR_L1 = 1;
	/** 错误级别2 比较严重的错误：会调取监控中心 **/
	public static final int EXCEPTION_ERROR_L2 = 2;
	/** 错误级别3 一般错误 ，暂忽略**/
	public static final int EXCEPTION_ERROR_L3 = 3;
	/** 错误级别4 错误可忽略 **/
	public static final int EXCEPTION_ERROR_L4 = 4;
	/** 错误级别5 自定义错误警告，暂不处理 **/
	public static final int EXCEPTION_ERROR_L5 = 5;
	
	public static final String EXCEPTION_ROOT_PATH = "/root/icp/";
	/**
	 * 异常处理接口
	 * @param exceptionLevel 异常级别
	 * @return
	 */
	public boolean dealException(int exceptionLevel);
}
