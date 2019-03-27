/**
 * 
 */
package com.sinosoft.platform.core.util;

import java.lang.reflect.Field;

import org.apache.log4j.Logger;

/**
 * DTO 解析类，用于意外险和将康先导DTO解析
 * @author Darker.Wang
 * @date 2016-7-27 下午3:42:45
 * @company SINOSOFT
 */
public class DTOAnalyze {

	public CErrors cErrors = new CErrors();
	private Logger logger = Logger.getLogger(DTOAnalyze.class);
	/**
	 * 
	 */
	public DTOAnalyze() {
		// TODO Auto-generated constructor stub
	}

	public void analyzeByRootDTO(String rootDTOName){
		try{
			Class<?> clazz = rootDTOName.getClass();
			logger.debug("- analyzeByRootDTO : "+clazz);
			Field[] field = clazz.getFields();
			logger.debug(field);
		}catch(Exception e){
			
		}
		
	}
	@SuppressWarnings("unused")
	private boolean buildError(String funName,String msg){
		CError cError = new CError();
		cError.errorMessage = msg;
		cError.functionName = funName;
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
