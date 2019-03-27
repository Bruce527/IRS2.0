/**
 * 
 */
package com.sinosoft.ummp.quartz;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.BamcUsabilityReportService;
import com.sinosoft.ummp.application.impl.BamcUsabilityReportServiceImpl;

/**
 * 应用心跳监控批处理JOB，quartz 调用 5分钟一次
 * @author Darker.Wang
 * @date 2016-10-8 上午9:34:37
 * @company SINOSOFT
 */
@Service("heartBeatService")	
public class HeartBeatService implements Serializable , ApplicationContextAware {

	private static final long serialVersionUID = 1L;
	private  static ApplicationContext context = null;
	private static final Logger logger = Logger.getLogger(HeartBeatService.class);
	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		context = arg0;
		logger.debug("- ApplicationContext: "+context);
	}

	/***********************************************************************
	 * 以下是心跳相关的批处理方法入口
	 ***********************************************************************/
	/**
	 * 心跳起搏器
	 * @return
	 */
	public boolean hearBeat(){
		logger.info("- HeatBeat Begin: "+serialVersionUID);
		//从容器中获取bean对象
		BamcUsabilityReportService bamcUsabilityReportService = context.getBean(BamcUsabilityReportService.class);
		logger.debug("- BamcUsabilityReportService: "+bamcUsabilityReportService);
		bamcUsabilityReportService.setLogRootPath(getHearBeatLogPath(context));
		//心跳监控：构建报文
		String xml = bamcUsabilityReportService.buildMsg(new ParamPOJO(), "LIVE");
		//心跳监控：发送报文
		logger.info("- HeatBeat Send xml : "+xml);
		int result = bamcUsabilityReportService.sendMsg(xml);
		logger.info("- HeartBeatService result [1-成功 0-失败 -1-异常] : "+result);
		return true;
	}
	/**
	 * 获取心跳监控路径
	 * @param context
	 * @return
	 */
	private String getHearBeatLogPath(ApplicationContext context){
		String rootPath = context.getBean(CodeQueryService.class).getSysPath("ROOT_PATH");
		if(rootPath.endsWith("/")){
			rootPath += "heart/";
		}else{
			rootPath +="/heart/";
		}
		return rootPath;
	}
	
	public static void main(String[] args){
		BamcUsabilityReportService impl = new BamcUsabilityReportServiceImpl();
//		String msg = impl.buildMsg(new ParamPOJO(), "ERROR");//应用故障
//		String msg = impl.buildMsg(new ParamPOJO(), "WARN");//应用警告
		String msg = impl.buildMsg(new ParamPOJO(), "LIVE");//应用警告
		impl.sendMsg(msg);
	}
}
