package com.sinosoft.platform.quartz.application;
import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIAN0101Job;
import com.sinosoft.ummp.task.job.impl.SHIAN0102Job;
import com.sinosoft.ummp.task.job.impl.SHIAU0101Job;
import com.sinosoft.ummp.task.job.impl.SHIAU0102Job;


/**
 * 简单任务实现类：实现简单批处理操作可在该类中写一个方法在quartz.xml 中配置即可
 * @author lihongtao
 * @date 2017-09-20 下午2:50:12
 * @company SINOSOFT
 */
@Service("SysnPolSendChService")
public class SysnPolSendChService implements Serializable,ApplicationContextAware  {

	
	private  static ApplicationContext context = null;
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SysnPolSendChService.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
		logger.debug("- ApplicationContext: "+context);
	}
	
	public boolean PolSysnSendC(){
		boolean result =true;
		/**个单核保信息同步
		 * 
		 */
		SHIAU0102Job U0102 = new SHIAU0102Job();
		try {
				result=U0102.excute();
					if (!result){
				  System.out.println("----个单核保信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("个单核保信息同步报送批处理异常");	
			}
		
		/**团单核保信息同步
		 * 
		 */
		SHIAU0101Job U0101 = new SHIAU0101Job();
		try {
				result=U0101.excute();
					if (!result){
				  System.out.println("----团单核保信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("团单核保信息同步报送批处理异常");	
			}
		
		/**个单承保信息同步
		 * 
		 */
		SHIAN0102Job N0102 = new SHIAN0102Job();
		try {
				result=N0102.excute();
					if (!result){
				  System.out.println("----个单承保信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("个单承保信息同步报送批处理异常");	
			}
		
		/**团单承保信息同步
		 * 
		 */
		SHIAN0101Job N0101 = new SHIAN0101Job();
		try {
				result=N0101.excute();
					if (!result){
				  System.out.println("----团单承保信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("团单承保信息同步报送批处理异常");	
			}
		return result;	
     } 
}
