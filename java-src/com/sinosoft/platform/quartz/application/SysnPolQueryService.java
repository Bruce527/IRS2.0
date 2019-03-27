package com.sinosoft.platform.quartz.application;
import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIAN03Job;



/**
 * 简单任务实现类：实现简单批处理操作可在该类中写一个方法在quartz.xml 中配置即可
 * @author tangjie
 * @date 2016-10-10 下午3:30:12
 * @company SINOSOFT
 */
@Service("SysnPolQueryService")
public class SysnPolQueryService implements Serializable,ApplicationContextAware  {

	
	private  static ApplicationContext context = null;
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SysnPolQueryService.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
		logger.debug("- ApplicationContext: "+context);
	}

//	public boolean testSimpleServiceMethod(){
//		System.out.println("- testSimpleServiceMethod : 测试简单JOB开始了");
//		return true;
//	}
	
	public boolean PolSysnQuery(){
		boolean result =true;
		/**承保信息异步上传
		 * 
		 */
		SHIAN03Job N03 = new SHIAN03Job();
		try {
				result=N03.excute();
					if (!result){
				  System.out.println("----承保信息异步上传结果查询批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("承保信息异步上传结果查询批处理异常");	
			}
		return result;
			
	
	
} 
	


}
