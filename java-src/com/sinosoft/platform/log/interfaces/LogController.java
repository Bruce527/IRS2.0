/**
 * 
 */
package com.sinosoft.platform.log.interfaces;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.JsonUtil;
import com.sinosoft.platform.log.application.LogService;

import config.Config;

/**
 * @author Darker.Wang
 * @date 2016-6-2 下午9:09:26
 * 系统日志控制器
 */
@Controller
@RequestMapping(value="/log")
public class LogController {
	Logger logger = Logger.getLogger(LogController.class);
	@SuppressWarnings("rawtypes")
	public Map parameters = null;//表单参数
	@SuppressWarnings("rawtypes")
	public List fileInfoList = null;//文件列表
	
	@Autowired
	LogService logService;
	
	@SuppressWarnings("rawtypes")
	public LogController(){
		parameters = new HashMap();
		fileInfoList = new ArrayList();
	}
	/**
	 * 添加文件或者是文件夹的跳转，type = 1 添加文件, 否则添加文件夹
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addFileUrl",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
	public String addFileUrl(HttpServletRequest request,HttpServletResponse response){
		try {
			request.setCharacterEncoding("UTF-8");
			String type = request.getParameter("type");
			String path = request.getParameter("logPath");
			if(path != null){
				path = new String(path.getBytes("ISO8859-1"),"UTF-8");
				request.setAttribute("path",path);
			}
			
			if("1".equals(type)){
				return "platform/log/addFileInput";
			}
			return "platform/log/addDirInput";
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value="/listLogUrl",method = RequestMethod.GET)
	public String listLogUrl(){
		return "platform/log/listLogInput";
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/initLogPath",produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map initLogPath(){
		Map map = new HashMap();
		String initPath =logService.initLogPath(); 
		map.put("logPath", initPath);
		return map;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/listFiles",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listFiles(DataGridModel model, String logPath, String research){
		Map map = logService.listFile(model,logPath);
		String json = JsonUtil.conver2Json(map);
		return json;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/listSearch",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String listSearch(DataGridModel model, String logPath, String research){
		Map map = logService.reSearch(model,logPath,research);
		String json = JsonUtil.conver2Json(map);
		return json;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/uploadFile",method=RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public String uploadFile(HttpServletRequest request,HttpServletResponse response,@RequestParam String folder){
		logger.debug(folder);
		Map map = logService.uploadFile(request,response);
		String json = JsonUtil.conver2Json(map);
		return json;
	}
	
	@RequestMapping(value = "/downLoadFiles",method=RequestMethod.GET,produces = "application/html;charset=utf-8")
	public ModelAndView downLoadFiles(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("fileList") List<String> fileList){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String filePath = null;
		String logPath = null;
		try {
			request.setCharacterEncoding("UTF-8");
			logPath = request.getParameter("logPath");
			logPath = new String(logPath.getBytes("ISO8859-1"),"UTF-8");
			String fileName = DateUtils.getDateTimeString();
			System.out.println("正在下载：" + filePath);
			File inFile = logService.listFiles(fileList,logPath,fileName);
			long fileLenght = inFile.length();
			response.reset();
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition","attachment; filename=" + fileName);
			response.addHeader("Content-Length",String.valueOf(fileLenght));
			
			bis = new BufferedInputStream(new FileInputStream(inFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while( -1 != (bytesRead = bis.read(buff, 0, buff.length))){
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("下载文件："+filePath+" 失败！");
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bis = null;
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bos = null;
			}
		}
		return null;
	}
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @param fileName
	 */
	@RequestMapping(value = "/downLoadFile",method=RequestMethod.GET,produces = "application/html;charset=utf-8")
	public ModelAndView downLoadFile(HttpServletRequest request,HttpServletResponse response,
			@RequestParam String fileName){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String filePath = null;
		String logPath = null;
		try {
			logPath = request.getParameter("logPath");
			filePath = request.getParameter("filePath");
			fileName = java.net.URLDecoder.decode(fileName, "UTF-8");
			logPath = java.net.URLDecoder.decode(logPath, "UTF-8");
			filePath = java.net.URLDecoder.decode(filePath, "UTF-8");
			if(filePath == null || "".equals(filePath)){
				filePath = logPath+fileName;
			}
			filePath = filePath.replace("\\/", "/").replace("\\", "/");
			System.out.println("正在下载：" + filePath);
			File inFile = new File(filePath);
			long fileLenght = inFile.length();
			response.reset();
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition","attachment; filename=" + new String(fileName.getBytes(),Config.ENCODING_ISO));
			response.addHeader("Content-Length",String.valueOf(fileLenght));
			
			bis = new BufferedInputStream(new FileInputStream(inFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while( -1 != (bytesRead = bis.read(buff, 0, buff.length))){
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("下载文件："+filePath+" 失败！");
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bis = null;
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bos = null;
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/addFile",produces = "application/json;charset=utf-8")
	@ResponseBody
	public String addFile(){
		return null;
	}
	
	@RequestMapping(value = "/deleteFiles", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> deleteFiles(HttpServletRequest request ,@RequestParam("files") List<String> files,ModelMap model){
		logger.debug(files);
		
		Map<String, String>  map = new HashMap<String,String>();
		try {
			request.setCharacterEncoding("UTF-8");
			String logPath = request.getParameter("logPath");
			logPath = java.net.URLDecoder.decode(logPath, "UTF-8");
			for (String f : files) {
				f = java.net.URLDecoder.decode(f, "UTF-8");
				File file = new File(logPath+f);
				logger.info(f);
				boolean result = deleteFile(file);
				if(!result){
					continue;
				}
				file.delete();
			}
			map.put("mes", "删除成功");
			logger.info("文件删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			logger.info("文件删除失败");
		}
		return map;// 重定向
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/addFileDir", method = RequestMethod.POST,produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map addFileDir(@RequestParam String logPath,@RequestParam("dirName") String dirName){
		
		String fileName = logPath+dirName;
		Map<String, String>  map = new HashMap<String,String>();
		String result = "-1";
		try {
			if(dirName == null || "".equals(dirName)){
				map.put("mes", "创建失败，文件夹名为空");
			}else{
				fileName = new String(fileName.getBytes("ISO8859-1"),"GBK");
				logger.info("创建文件夹："+fileName);
				File f = new File(fileName);
				boolean r = (f.exists() && f.isDirectory()) ? true : f.mkdirs();
				if(r){
					result = "1";
					map.put("mes", "创建成功");
				}else{
					map.put("mes", "创建失败");
				}
			}
			map.put("result", result);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败，原因是" + e.getMessage());
			logger.info("文件夹创建失败，原因是" + e.getMessage());
		} 
		return map;// 重定向
	}
	/**
	 * 删除文件，包括文件夹都可以
	 * @param file
	 * @return
	 */
	private boolean deleteFile(File file){
		if(file.isDirectory()){
			File[] files = file.listFiles();
			for(File t : files){
				if(t.isDirectory()){
					deleteFile(t);
				}else{
					boolean result = t.delete();
					logger.info("DELETE FILE : "+t.getAbsolutePath()+" "+result);
				}
			}
		}else{
			 boolean result = file.delete();
			 logger.info("DELETE FILE : "+file.getAbsolutePath()+" "+result);
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
