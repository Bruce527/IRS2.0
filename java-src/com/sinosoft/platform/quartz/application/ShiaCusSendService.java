package com.sinosoft.platform.quartz.application;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIAP01Job;
import com.sinosoft.ummp.task.job.impl.SHIAP02Job;
/**
 * 简单任务实现类：实现简单批处理操作可在该类中写一个方法在quartz.xml 中配置即可
 * @author lihongtao
 * @date 2017-09-20 下午2:21:12
 * @company SINOSOFT
 */
@Service("ShiaCusSendService")
public class ShiaCusSendService implements Serializable,ApplicationContextAware  {

	
	private  static ApplicationContext context = null;
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ShiaCusSendService.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
		logger.debug("- ApplicationContext: "+context);
	}
	
	public boolean cusSend(){
		boolean result =true;
		//客户接口
		SHIAP01Job p01 = new SHIAP01Job();
		try{ 	
				result=p01.excute();
		 			if (!result){
		 				System.out.println("----客户身份上传批处理失败----");
		 						}
		 	}
		 catch(Exception e)
		 	{
		 		System.out.println("客户身份上传批处理异常");		
		 	}
		//客户异步上载
		SHIAP02Job P02 = new SHIAP02Job();
		try {
				result=P02.excute();
					if (!result){
				  System.out.println("----客户信息异步上传批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("客户信息异步上传批处理异常");	
			}
		return result;
} 
	


}
