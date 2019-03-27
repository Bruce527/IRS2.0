package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.WebFile;
import com.sinosoft.ummp.application.ReadyDownloadService;
import com.sinosoft.ummp.domain.mapper.TDocUpdownMapper;
import com.sinosoft.ummp.domain.model.TDocUpdown;
import com.sinosoft.ummp.domain.model.TDocUpdownExample;
import com.sinosoft.ummp.util.USFTPClient;



/**
 * 文件下载类
 * @author Darker.Wang
 * @date 2016-7-27 下午12:16:04
 * @company SINOSOFT
 */
@Service
public class ReadyDownloadServiceImpl implements ReadyDownloadService{

	private List<TDocUpdown> list=new ArrayList<TDocUpdown>();
	private LoginInfo loginInfo;
	private ParamPOJO pojo;
	private String UPLOAD_FTPServer = "UPLOAD_FTPServer";
	private String DOWNLOAD_FTPServer = "DOWNLOAD_FTPServer";
	private String tRealPath;
	private String tStartDate="";
	private String tEndDate="";
	private String tFileType = "";
	
	
	private Logger logger = Logger.getLogger(ReadyDownloadServiceImpl.class);
	
	@Autowired
	TDocUpdownMapper tDocUpdownMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
//	@Autowired
//	SequenceService sequenceService;
	
	@Override
	public boolean readyForDownload(LoginInfo tloginInfo, ParamPOJO tpojo) {
		this.loginInfo=tloginInfo;
		this.pojo=tpojo;

		tStartDate = pojo.getStartDate();
		tEndDate = pojo.getEndDate();
		tFileType = pojo.getFileType();
		tRealPath = pojo.getRealPath();
		
		//1、Login on web service and download the web data
		USFTPClient client = null;
		if(tFileType.equals("U")){
			System.out.println("准备下载成功数据");
			client = new USFTPClient(UPLOAD_FTPServer,"U");
		}else{
			System.out.println("准备下载失败数据");
			client = new USFTPClient(DOWNLOAD_FTPServer,"D");
		}
		try{
			boolean loginResult = client.login();
			if(!loginResult){
				buildError("fileDataDownLoad", "登录服务器失败，检查密码是否正确");
				client = null;
				return false;
			}
		}catch(Exception e){
			buildError("fileDataDownLoad", "登录服务器异常：检查专线是否联通");
			client = null;
			return false;
		}
		try{
			List<WebFile> beans = client.listWebBeanByDate(client.getBasedir(), client.getSftpClient(),tStartDate,tEndDate);
			if(beans == null){
				cErrors.clearErrors();
				buildError("listWebBean","服务器无对应文件");
				return true;
			}
			
			//2、Build Save Date
			if(!buildUpDownData(beans)){
				buildError("buildUpDownData","下载数据失败");
				return false;
			}
			
			//2、Save on local
			if(!saveAtLocal(beans,client)){
				buildError("saveAtLocal","存储在本地失败");
				return false;
			}
			return true;
		}catch(Exception e){
			buildError("fileDataDownLoad", "下载数据异常");
			client = null;
			e.printStackTrace();
			return false;
		}
	
	}
	private boolean buildError(String funName,String msg){
			CError cError = new CError();
			cError.errorMessage = msg;
			cError.functionName = funName;
			logger.debug(cError.errorMessage);
			cErrors.addOneError(cError);
			return true;
		}
	@Transactional
	private boolean buildUpDownData(List<WebFile> beans) throws ParseException{
		if(beans == null){
			buildError("buildUpDownData", "服务器无对应文件");
			return false;
		}
		for(int i = 0;i<beans.size();i++){
			WebFile bean = beans.get(i);
			if(bean.isDir()){
				buildUpDownData(bean.getFiles());
			}else{
//				String mTime = bean.getMakeTime();
//				String aTime = bean.getModifyTime();
				String filename = bean.getFileName();
				System.out.println("同步文件： "+filename);
//				System.out.println("mTime: "+mTime+"\taTime: "+aTime);
				String path = "/data/download/";
				if(tFileType.equals("U")){
					path = "/data/upload/";
				}
				long size = bean.getSize();
				TDocUpdown updown=new TDocUpdown();
				updown.setDocName(filename);
				updown.setDocPath(path);
				updown.setDocType(tFileType);
				updown.setDocSuffix("zip");
				updown.setDownTimes(new BigDecimal(1));
				updown.setHostName(DOWNLOAD_FTPServer);
				updown.setOperator(loginInfo.getUserCode());
				updown.setDocMaker(loginInfo.getUserCode());
				updown.setDocPath(path);
				updown.setDocMakeTime(new Date());
				updown.setInsertTime(new Date());
				updown.setStandFlag1(""+size);
				updown.setStandFlag2("/download/");
				updown.setDocModifyTime(new Date());
				list.add(updown);
			}
		}
		return true;
	}
	/**
	 * 将文件存储在本地
	 * @param beans
	 * @param client
	 * @return
	 * @throws ParseException 
	 */
	private boolean saveAtLocal(List<WebFile> beans,USFTPClient client) throws ParseException{
		for(int i = 0;i<beans.size();i++){
			WebFile bean = beans.get(i);
			if(bean.isDir()){
				buildUpDownData(bean.getFiles());
			}else{
				String baseDir = client.getBasedir();
				System.out.println("CLIENT.FTP_TYPE: "+client.FTP_TYPE);
				if("U".equals(client.FTP_TYPE)){
					baseDir = "/data/upload/";
				}
				if("D".equals(client.FTP_TYPE)){
					baseDir = "/data/download/";
				}
				//如果BaseDIR不存在，则默认为/data/download/
				if(baseDir == null || "".equals(baseDir)){
					baseDir = "/data/download/";
				}
				baseDir = tRealPath+baseDir;
				System.out.println("BASE DIR  ： "+baseDir);
				System.out.println("DOWN FILE ："+bean.getFileName());
				String filename = bean.getFileName();
				filename = filename.replace("/", "").replace("\\", "");//防止LINUX系统有时会有斜杠在文件名中
				String saveFile = baseDir+filename;
				System.out.println("SAVE FILE ："+saveFile);
				client.download(client.getBasedir(), bean.getFileName(), saveFile, client.getSftpClient());
			}
		}
		for(TDocUpdown t:list){
			TDocUpdownExample example=new TDocUpdownExample();
			example.createCriteria().andDocNameEqualTo(t.getDocName());
			List<TDocUpdown> count = tDocUpdownMapper.selectByExample(example);
			if(count.isEmpty()){
				tDocUpdownMapper.insertSelective(t);
			}else{//需调整，要下载文件保持最新状态
				int times=count.get(0).getDownTimes().add(new BigDecimal(1)).intValue();
				t.setDownTimes(new BigDecimal(times));
				t.setLastModifyTime(new Date());
				tDocUpdownMapper.updateByExample(t, example);
			}
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		BigDecimal a=new BigDecimal(1);
		BigDecimal b=new BigDecimal(2);
		int i = a.add(b).intValue();
		System.out.println(i);
	}
}
