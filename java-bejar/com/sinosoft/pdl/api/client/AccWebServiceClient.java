package com.sinosoft.pdl.api.client;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ebao.accident.insurance.AccidentWebServicePort;
import com.ebao.accident.insurance.AccidentWebServicePortService;
import com.ebao.accident.insurance.AccidentWebServicePortServiceLocator;
import com.sinosoft.pdl.constants.AccWSConstants;


/**
 * 北京健康险远程类Service接口调用通用客户端
 * @author Darker.Wang
 * @date 2016-7-6 下午5:42:38
 * @company SINOSOFT
 */
public class AccWebServiceClient {
	
	/** Web service 接口
	 */
	private AccidentWebServicePortService service 
			= new AccidentWebServicePortServiceLocator();
	
	/** 服务端口
	 */
	private AccidentWebServicePort servicePort;
	
	/** 日志
	 */
	private Log logger = LogFactory.getLog(this.getClass());
	
	/**
	 * 依平台而存在，传递comId到此以备用
	 * @param comId
	 */
	public AccWebServiceClient(BigDecimal comId) {
		try {
			// 获取服务端口
			servicePort = service.getAccidentWebService();
		} catch (ServiceException e) {
			logger.error("Initial accident client failed!");
			e.printStackTrace();
		}
	}
	/**
	 * 单一执行方法
	 * @param serviceId
	 * @param data
	 * @return
	 */
	public Object execute(String serviceId, Object data) {	
		Object result = null;
		try {
			// 按业务类型获取对应的web service报送方法
			Method wsMethod = getWSMethodByBizType(serviceId);
			if (null == wsMethod) {
				return null;
			}
			result = wsMethod.invoke(servicePort, data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 按业务类型获取对应的 web service报送方法
	 * @param serviceId
	 * @return
	 */
	private Method getWSMethodByBizType(String serviceId) {
		try {
			// 按业务类型获取对应的web service方法名
			String webServiceMethodName = AccWSConstants
					.getWSMethodNameByBizType(serviceId);
			// 获取该方法
			Class<?> clazz = servicePort.getClass();//TODO
			Method[] methods = clazz.getDeclaredMethods();
			Method method = null;
			for (Method m: methods) {
				if (m.getName().equals(webServiceMethodName)) {
					method = m;
					break;
				} else {
					continue;
				}
			}
			return method;
		} catch (Exception e) {
			logger.info("Get ws method failed, whose serviceId is:" + serviceId);
			return null;
		}
	}
	
}
