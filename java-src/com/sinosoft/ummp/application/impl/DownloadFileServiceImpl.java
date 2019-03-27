package com.sinosoft.ummp.application.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.ummp.application.DownloadFileService;
import com.sinosoft.ummp.domain.model.TDocUpdown;

/**
 * 文件上载服务类
 * @author Darker.Wang
 * @date 2016-7-27 下午12:16:04
 * @company SINOSOFT
 */
@Service
public class DownloadFileServiceImpl implements DownloadFileService{
	
	private HttpServletResponse response;
	private String tRealPath;
	private String Content="";
	private String name="";//需要下载的文件名（zip）
	private String path="";
	private Logger logger = Logger.getLogger(DownloadFileServiceImpl.class);
	
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	SequenceService sequenceService;
	
	@SuppressWarnings("unused")
	private boolean buildErrors(String funName,String msg){
		CError cError = new CError();
		cError.errorMessage = msg;
		cError.functionName = funName;
		logger.debug(cError.errorMessage);
		cErrors.addOneError(cError);
		return true;
	}
	private boolean getInputDate(HttpServletResponse response,TDocUpdown updown){
		this.response=response;
		this.name=updown.getDocName();//可以从前台页面获取
		this.path=updown.getDocPath();//可以从前台页面获取
		
		
		DBContextHolder.recover();
		//从数据库中获取路径
		SqlAdapter sqlAdapter=new SqlAdapter();
		String rootPathSql="SELECT CODE_ALIAS FROM T_DEF_CODE_DICT WHERE CODE_TYPE = 'SYS_PATH' AND CODE = 'ROOT_PATH'";
		String centerPathSql="SELECT code_alias from t_def_code_dict where code_type='SYS_PATH' AND CODE='TEMP_PATH'";
		sqlAdapter.setSql(rootPathSql);
		List<Map> query = sqlAdapterMapper.excuteQuery(sqlAdapter);
		String rootPath=(String) query.get(0).get("CODE_ALIAS");
		
		SqlAdapter sqlAdapter1=new SqlAdapter();
		sqlAdapter1.setSql(centerPathSql);
		List<Map> list = sqlAdapterMapper.excuteQuery(sqlAdapter1);
		String centerPath=(String) list.get(0).get("CODE_ALIAS");
		//拼成ParamPOJO.realPath
		tRealPath=rootPath+centerPath.substring(centerPath.indexOf("}")+1, centerPath.length());
		return true;
	}
	public boolean downloadFile(HttpServletResponse response,TDocUpdown updown){
		if(!getInputDate(response,updown)){
			return false;
		}
		if(!dealData()){
			return false;
		}
		if(!preparedData()){
			return false;
		}
		return true;
	}
	private boolean preparedData(){
		//TODO 准备数据
		
		return true;
	}
	@SuppressWarnings("resource")
	private boolean dealData(){//服务器失败数据下载
		System.out.println("================== 下载开始 ===============");
		String updateSql = "";
		String filename = "";
		OutputStream out = null;
		FileInputStream in = null;
		try {
			String fileName = tRealPath + path + name;
			fileName = fileName.replace("\\/", "/").replace("\\", "/");
			System.out.println("正在下载：" + fileName);
			response.reset();
			response.setHeader("Cache-Control", "no-cache");
			response.setHeader("Cache-Control", "max-age=0");
			response.setDateHeader("Expires", 0);
			response.setContentType("application/x-download");
			filename = URLEncoder.encode(name, "utf-8");
			response.addHeader("Content-Disposition","attachment; filename=" + filename);
			out = response.getOutputStream();
			in = new FileInputStream(fileName);
			byte[] b = new byte[1024];
			int I = in.read(b);
			while (I != -1) {
				out.write(b, 0, I);
				I = in.read(b);
			}
			out.flush();
			out.close();
			updateSql = "update t_doc_updown set down_times = down_times+1 where doc_name = '"
					+ name + "'";
		} catch (Exception e) {
			System.out.println("导出失败！");
			Content = "导出失败！";
			e.printStackTrace();
			return false;
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				in = null;
			}
			if (!"".equals(updateSql)) {
				SqlAdapter sqlAdapter=new SqlAdapter();
				sqlAdapter.setSql(updateSql);
				sqlAdapterMapper.excuteUpdate(sqlAdapter);
			}
		}
		Content = "导出成功";
		if (cErrors.getFirstError() != null
				&& !"".equals(cErrors.getFirstError())) {
			Content += cErrors.getFirstError();
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
