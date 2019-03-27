/**
 * 
 */
package com.sinosoft.platform.log.application;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sinosoft.platform.core.util.DataGridModel;

/**
 * @author Darker.Wang
 * @date 2016-6-2 下午9:09:55
 * 系统日志服务接口
 */
public interface LogService {

	/**
	 * 获取初始化日志路径
	 * @return
	 */
	public String initLogPath();
	/**
	 * 列出文件夹信息
	 * @param path
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map listFile(DataGridModel model,String path);
	/**
	 * 返回
	 * @param path
	 * @return
	 */
	public String goBack(String path);
	/**
	 * @param model
	 * @param logPath
	 * @param reseach
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map reSearch(DataGridModel model, String logPath, String reseach);
	/**
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Map uploadFile(HttpServletRequest request,HttpServletResponse response);
	/**
	 * @param fileList
	 * @param logPath
	 * @param fileName
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public File listFiles(List fileList, String logPath, String fileName);
}
