package com.sinosoft.platform.core.aop;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/05 chenj 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 *****************************************************/
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;

import com.sinosoft.platform.core.application.impl.UserServiceImpl;
import com.sinosoft.platform.core.exception.CoreException;
/**
 * 服务端类日志处理实现类
 * @author Darker.Wang
 * @date 2016-8-3 下午7:51:32
 * @company SINOSOFT
 */
public class CommonLogImpl implements CommonLog{
	private static final Logger log = Logger.getLogger(UserServiceImpl.class);
	public void before(JoinPoint call) {     
        //获取目标对象对应的类名     
        String className = call.getTarget().getClass().getName();     
        //获取目标对象上正在执行的方法名     
        String methodName = call.getSignature().getName();     
             
        log.info(" ======> Class: "+ className +  " Method: " + methodName + " begin");     
    }      
    public void afterReturn(JoinPoint call) { 
    	//获取目标对象对应的类名     
        String className = call.getTarget().getClass().getName();     
        //获取目标对象上正在执行的方法名     
        String methodName = call.getSignature().getName(); 
    	log.info(" ======> Class: "+ className +  " Method: " + methodName + " end");     
    }     
    public void afterThrowing(CoreException e) { 
    	log.info("Exception Occurred when Method for Performing: "+e);     
    }
      
}
