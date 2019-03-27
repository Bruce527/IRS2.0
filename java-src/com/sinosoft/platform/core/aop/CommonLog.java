package com.sinosoft.platform.core.aop;

import org.aspectj.lang.JoinPoint;

import com.sinosoft.platform.core.exception.CoreException;

/**
 * 服务端类日志处理接口
 * @author Darker.Wang
 * @date 2016-8-3 下午7:52:11
 * @company SINOSOFT
 */
public interface CommonLog {

	/**
	 * 处理前：TODO SOMETHING IF YOU WANT
	 * @param call
	 */
	public void before(JoinPoint call);
	/**
	 * 处理后：TODO SOMETHING IF YOU WANT
	 * @param call
	 */
	public void afterReturn(JoinPoint call);
	/**
	 * 处理异常：TODO SOMETHING IF YOU WANT
	 * @param call 
	 */
	public void afterThrowing(CoreException e);
	
	
}
