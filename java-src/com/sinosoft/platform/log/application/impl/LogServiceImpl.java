/**
 * 
 */
package com.sinosoft.platform.log.application.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.FileUploadServletUtil;
import com.sinosoft.platform.core.util.LogFile;
import com.sinosoft.platform.log.application.LogService;

/**
 * 日志服务实现类
 * @author Darker.Wang
 * @date 2016-6-2 下午9:10:47
 */
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	CodeQueryService codeQueryService;
	
	private static Logger logger  = Logger.getLogger(LogServiceImpl.class);
	
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	@Override
	public Map uploadFile(HttpServletRequest request,HttpServletResponse response) {
		FileUploadServletUtil util = new FileUploadServletUtil();
		Map map = new HashMap();
		String result = "OK";
		String logPaht = null;
		try {
			util.doPost(request, response);
			Map tmap = util.getParameters();
			InputStream is = (InputStream) tmap.get("file_upload");
			logPaht = (String) tmap.get("logPaht");
			map.putAll(tmap);
			logger.info("上载文件接口，目前未实现："+map);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			result = "UnsupportedEncodingException";
		} catch (ServletException e) {
			e.printStackTrace();
			result = "ServletException";
		} catch (IOException e) {
			e.printStackTrace();
			result = "IOException";
		}
		map.put("msg", result);
		return map;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	/** (non-Javadoc)
	 * @see com.sinosoft.core.application.LogService#initLogPath()
	 */
	@Override
	public String initLogPath() {
		// TODO Auto-generated method stub
		String initPath = "D://ummp/";
		List<TDefCodeDict> codes = codeQueryService.queryCode("SYS_PATH","LOG_PATH");
		if(codes != null && codes.size() > 0){
			return codes.get(0).getCodeAlias();
		}
		return initPath;
	}

	/** (non-Javadoc)
	 * @see com.sinosoft.core.application.LogService#listFile(java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map listFile(DataGridModel model,String path) {
		Map map = new HashMap();
		int startIndex = model.getStartIndex()-1;
		int endIndex = model.getEndIndex();
		List<LogFile> logFiles = new ArrayList<LogFile>();
		//等于查询数据库
		int total = 0;
		List<LogFile> allLogFiles = getLogFiles(path,false,null);
		if(allLogFiles != null){
			total = allLogFiles.size();
			if(endIndex > total){
				endIndex = total;
			}
			for( ; startIndex < endIndex; startIndex ++){
				logFiles.add(allLogFiles.get(startIndex));
			}
		}
		map.put("total", total);
		map.put("rows", logFiles);
		allLogFiles = null;
		return map;
	}

	/** (non-Javadoc)
	 * @see com.sinosoft.core.application.LogService#goBack(java.lang.String)
	 */
	@Override
	public String goBack(String path) {
		// TODO Auto-generated method stub
		path = path.substring(0, path.lastIndexOf("/"));
		return path;
	}

	/** (non-Javadoc)
	 * @see com.sinosoft.core.application.LogService#reSearch(com.sinosoft.core.interfaces.util.DataGridModel, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Map reSearch(DataGridModel model, String path, String reseach) {
		Map map = new HashMap();
		int startIndex = model.getStartIndex()-1;
		int endIndex = model.getEndIndex();
		List<LogFile> logFiles = new ArrayList<LogFile>();
		//等于查询数据库
		int total = 0;
		List<LogFile> allLogFiles = getLogFiles(path,true,reseach);
		if(allLogFiles != null){
			total = allLogFiles.size();
			if(endIndex > total){
				endIndex = total;
			}
			for( ; startIndex < endIndex; startIndex ++){
				logFiles.add(allLogFiles.get(startIndex));
			}
		}
		map.put("total", total);
		map.put("rows", logFiles);
		allLogFiles = null;
		return map;
	}
	/**
	 * 获取所有文件
	 * @param path 文件路径
	 * @param isSycl 是否递归获取
	 * @param search 比较字段
	 * @return
	 */
	public List<LogFile> getLogFiles(String path,boolean isCylc,String search){
		logger.debug("正在加载："+path);
		List<LogFile> logFiles = new ArrayList<LogFile>();
		// TODO Auto-generated method stub
		if(path == null || "".equals(path)){
			return null;
		}
		File tFile = new File(path);
		
		if(!tFile.exists()){
			tFile = null;
			return null;
		}
		File[] files = tFile.listFiles();
		if(files == null || files.length <=0){
			return logFiles;
		}
		for(int index = 0 ; index < files.length; index ++){
			File file = files[index];
			boolean isFile = file.isFile();
			String fileName = file.getName();
			if(!isFile && file.isDirectory()){
				if(isCylc && file.isDirectory() && file.exists() ){
					String tPath = path+fileName+"/";
					logFiles.addAll(getLogFiles(tPath,isCylc,search));
				}
			}
			//是文件若比较否
			LogFile logFile = new LogFile();
			if(search != null && !"".equals(search)){
				if(!fileName.contains(search)){
					continue;
				}
			}

			int d = 0;
			int f = 1;
			if(isFile){
				f = 1;
				d = 0;
			}else{
				d = 1;
				f = 0;
			}
			logFile.setFilePath(file.getPath());
			logFile.setFileName(file.getName());
			logFile.setMaker("");//创建者
//			logFile.setMakeTime(""+getFileMakeTime(file));//创建时间
			logFile.setModifyer("");//修改者
			logFile.setModifyTime(""+DateUtils.getTimestampString(file.lastModified()));//最后修改时间
//			logFile.setFile(file);
			logFile.setSize(getSize(file));
			logFile.setIsDect(d);
			logFile.setIsFile(f);
			
			logFiles.add(logFile);
		}
		return logFiles;
		
	}
	/**
	 * 获取文件大小
	 * @param file
	 * @return
	 */
	private String getSize(File file){
		String size = "0";
		if(file.isDirectory()){
			File[] files = file.listFiles();
			if(files != null && files.length > 0){
				size = files.length+"";
			}
			/*
			for(File f : files){
				if(f.isDirectory()){
					size = getSize(f);
				}else{
					size = ">0";
					break;
				}
			}*/
		}else{
			size = file.length()+" KB";
		}
		return size;
	}
	@SuppressWarnings("unused")
	private String getFileMakeTime(File file){
		String strTime = "";
		String root = "";
		if(file.isDirectory()){
			return DateUtils.getTimestampString(file.lastModified());
		}
		String filePath = file.getPath();
		String suffix = filePath.substring(filePath.lastIndexOf("."),filePath.length());
		if(filePath.contains(":")){
			root = filePath.split(":")[0];
		}else if(filePath.contains("/")){
			root = filePath.split("/")[0];
		}
		try{
			Process p = Runtime.getRuntime().exec("cmd /"+root+file+"/tc");
			InputStream is = p.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line;
			while((line = br.readLine()) != null){
				if(line.endsWith(suffix)){
					strTime = line.substring(0,17);
					break;
				}
			}
		}catch(IOException e){
			logger.info("获取创建时间失败："+e.getMessage());
			return DateUtils.getTimestampString(file.lastModified());
		}
		return strTime;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.core.application.LogService#listFiles(java.util.List, java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public File listFiles(List fileList, String logPath, String fileName) {
		// TODO Auto-generated method stub
		return null;
	}

}
