package com.sinosoft.ummp.application;

import java.util.Map;

import org.apache.log4j.Logger;

import com.sinosoft.platform.core.exception.CoreException;

/**
 * 指定文件导入接口
 * @author pzz
 * @date 2016-9-27 16:45:19
 * @company sinosoft
 */
public interface AppointFileImportService {

	/**
	 * @param map
	 * @param log
	 * @return
	 * @throws CoreException 
	 */
	void ImportFile(Map<String, Object> map, Logger log) throws CoreException;
	
}
