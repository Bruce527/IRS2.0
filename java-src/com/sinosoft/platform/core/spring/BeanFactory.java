/**
 * 
 */
package com.sinosoft.platform.core.spring;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * <p><b>Title: </b> 加载Spring容器上下文接听器<p>
 * <p><b>Description:</b> 配置在Web.xml中。用于启动Spring后任意类可获取容器内容<p>
 * @author Darker.Wang
 * @date 2016-8-18 下午4:53:35
 * @company SINOSOFT
 */
@Resource
public class BeanFactory implements ServletContextListener {

	/**
	 * WebApplicationContext spring 容器上下文
	 */
	public static WebApplicationContext webApplicationContext;
	public BeanFactory() {
		// TODO Auto-generated constructor stub
		super();
		System.out.println("信息: BeanFactory initing ...");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("信息: BeanFactory destroyed");
		webApplicationContext = null;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		webApplicationContext = WebApplicationContextUtils
				.getWebApplicationContext(arg0.getServletContext());
		System.out.println("信息: BeanFactory contextInitializing : "+webApplicationContext);
	}

	public static ApplicationContext getApplicationContext(){
		return webApplicationContext;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(BeanFactory.getApplicationContext());
		System.out.println(BeanFactory.getApplicationContext().getBean("sequenceService"));
	}


}
