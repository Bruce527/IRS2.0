/**
 * 
 */
package com.sinosoft.ummp.exception;

import org.apache.log4j.Logger;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.BamcUsabilityReportService;
import com.sinosoft.ummp.application.impl.BamcUsabilityReportServiceImpl;

/**
 * 统一监管平台异常处理机制：根据不同的级别报送不同的信息到监控平台
 * @author Darker.Wang
 * @date 2016-8-11 上午11:30:14
 * @company SINOSOFT
 */
public class ExceptionService implements CISExceptionRunable{
	//此处考虑是否需要使用自动入住
	
	BamcUsabilityReportService bamcUsabilityReportService = new BamcUsabilityReportServiceImpl();
	private static Logger logger = Logger.getLogger(ExceptionService.class);
	/**
	 * 空构造器
	 */
	public ExceptionService(){}


	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.exception.CISExceptionRunable#dealException()
	 */
	@Override
	public boolean dealException(int level) {
		// TODO 监控中心可用性监控
		logger.info("- 警告监控： "+bamcUsabilityReportService);
		switch(level){
		case EXCEPTION_ERROR_L1:
			dealError();
			break;
		case EXCEPTION_ERROR_L2:
			dealWarn();
			break;
		case EXCEPTION_ERROR_L3:
			logger.info("- 该级别为一般错误，可忽略： "+level);
			break;
		case EXCEPTION_ERROR_L4:
			logger.info("- 该级别为错误，可忽略： "+level);
			break;
		case EXCEPTION_ERROR_L5:
			logger.info("- 该级别可忽略： "+level);
			break;
		default:
			logger.info("- 异常处理机制无法处理的级别： "+level);
		}
		return true;
	}

	private void dealWarn(){
		//构造警告报文
		String msg = bamcUsabilityReportService.buildMsg(new ParamPOJO(),"WARN");
		//发送报文
		bamcUsabilityReportService.sendMsg(msg);
	}
	private void dealError(){
		//构造故障报文
		String msg = bamcUsabilityReportService.buildMsg(new ParamPOJO(),"ERROR");
		//发送报文
		bamcUsabilityReportService.sendMsg(msg);
	}
}
