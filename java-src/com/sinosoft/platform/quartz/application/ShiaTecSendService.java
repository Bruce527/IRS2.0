package com.sinosoft.platform.quartz.application;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIASubmitC01Job;
import com.sinosoft.ummp.task.job.impl.SHIASubmitC04Job;
import com.sinosoft.ummp.task.job.impl.SHIASubmitC12Job;
import com.sinosoft.ummp.task.job.impl.SHIASubmitC14Job;
import com.sinosoft.ummp.task.job.impl.SHIASubmitE01Job;
import com.sinosoft.ummp.task.job.impl.SHIAT01Job;

@Service("ShiaTecSendService")
public class ShiaTecSendService implements Serializable,ApplicationContextAware {
	private  static ApplicationContext context = null;
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(SysnPolSendService.class);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		context = applicationContext;
		logger.debug("- ApplicationContext: "+context);
	}
	
	public boolean TecSysnSend(){
		boolean result =true;
		/**保费信息同步上传
		 * 
		 */
		SHIAT01Job T01 = new SHIAT01Job();
		try {
				result=T01.excute();
					if (!result){
				  System.out.println("----保费信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			e.printStackTrace();
			System.out.println("保费信息同步报送批处理异常");	
			}
		
		/**个险理赔信息同步上传
		 * 
		 */
		SHIASubmitC01Job C01 = new SHIASubmitC01Job();
		try {
				result=C01.excute();
					if (!result){
				  System.out.println("----个险理赔信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			
			System.out.println("个险理赔信息同步报送批处理异常");	
			}
		
		/**团险理赔信息同步上传
		 * 
		 */
		SHIASubmitC04Job C04 = new SHIASubmitC04Job();
		try {
				result=C04.excute();
					if (!result){
				  System.out.println("----团险理赔信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("团险理赔信息同步报送批处理异常");	
			}
		
		/**个险理赔注销同步上传
		 * 
		 */
		SHIASubmitC12Job C12 = new SHIASubmitC12Job();
		try {
				result=C12.excute();
					if (!result){
				  System.out.println("----个险理赔注销同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("个险理赔注销同步报送批处理异常");	
			}
		
		/**团险理赔注销同步上传
		 * 
		 */
		SHIASubmitC14Job C14 = new SHIASubmitC14Job();
		try {
				result=C14.excute();
					if (!result){
				  System.out.println("----团险理赔注销同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("团险理赔注销同步报送批处理异常");	
			}
		
		/**个团险保全信息同步上传
		 * 
		 */
		SHIASubmitE01Job E01 = new SHIASubmitE01Job();
		try {
				result=E01.excute();
					if (!result){
				  System.out.println("----个团险保全信息同步报送批处理失败----");
								}
			}
		catch(Exception e)
			{
			System.out.println("个团险保全信息同步报送批处理异常");	
			}
		return result;
}
}
