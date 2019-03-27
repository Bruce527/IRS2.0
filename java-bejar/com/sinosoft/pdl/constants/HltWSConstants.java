package com.sinosoft.pdl.constants;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * 远程访问网络接口信息配置类
 * @author Darker.Wang
 * @date 2016-7-6 下午5:59:18
 * @company SINOSOFT
 */
public class HltWSConstants {
	
	private static Logger logger = Logger.getLogger(HltWSConstants.class);
	
	private static Map<String, String> bizMethodMapping = new HashMap<String, String>();
	static {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		URL url = loader.getResource(
				"com/sinosoft/pdl/config/webservice.hlt.properties"
		);
		try {
			InputStream in = url.openStream();
			Properties p = new Properties();
			p.load(in);
			
			Enumeration<?> enums = p.propertyNames();
			while (enums.hasMoreElements()) {
				String propName = (String) enums.nextElement();
				if (!propName.contains("biztype.method.")) continue;
				String methodName = p.getProperty(propName);
				String bizType = propName.split("\\.")[2];
				bizMethodMapping.put(bizType, methodName);
			}
			
		} catch (IOException e) {
			logger.error("Read cache configurations failed, use default!");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param bizType
	 * @return
	 */
	public static String getWSMethodNameByBizType(String bizType) {
		return bizMethodMapping.get(bizType);
	}

}
