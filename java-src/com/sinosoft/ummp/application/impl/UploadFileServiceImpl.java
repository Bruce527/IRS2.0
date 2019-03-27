package com.sinosoft.ummp.application.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcraft.jsch.ChannelSftp;
import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.UploadFileService;
import com.sinosoft.ummp.config.ProFile;
import com.sinosoft.ummp.domain.mapper.TDefSftpMapper;
import com.sinosoft.ummp.domain.mapper.TDocMainMapper;
import com.sinosoft.ummp.domain.model.TDefSftp;
import com.sinosoft.ummp.domain.model.TDefSftpExample;
import com.sinosoft.ummp.util.USFTPClient;

/**
 * 文件上载服务类
 * @author Darker.Wang
 * @date 2016-7-27 下午12:16:04
 * @company SINOSOFT
 */
@Service("uploadFileService")
public class UploadFileServiceImpl implements UploadFileService{
	public static final String REALPATH="REALPATH"; 
	
	@Autowired
	CodeQueryService codeQueryService;
	
	Properties prop;
	String mBatchNo = "";
	List<String> updateSql =null;
	LoginInfo loginInfo;
	ParamPOJO pojo;
	String UPLOAD_FTPServer = "UPLOAD_FTPServer";
	String DOWNLOAD_FTPServer = "DOWNLOAD_FTPServer";
	String tCurrentDate = DateUtils.getCurrentDate();
	String tCurrentTime = DateUtils.getCurrentTime();
	String tRealPath;
	String tBatchType = "";
	String tDataType = "";
	String tInsureType = "";
	private Logger logger = Logger.getLogger(UploadFileServiceImpl.class);
	
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	SequenceService sequenceService;
	@Autowired
	TDefSftpMapper tDefSftpMapper;
	@Autowired
	TDocMainMapper tDocMainMapper;
	
	private boolean buildErrors(String funName,String msg){
		CError cError = new CError();
		cError.errorMessage = msg;
		cError.functionName = funName;
		logger.debug(cError.errorMessage);
		cErrors.addOneError(cError);
		return true;
	}
	private boolean getInputDate(LoginInfo loginInfo, ParamPOJO pojo){
		this.loginInfo = loginInfo;
		this.pojo = pojo;
		if(pojo == null){
			buildErrors("getInputDate","无数据");
			return false;
		}
		try {
			prop = ProFile.getInstance().getProFile("service");
			mBatchNo = pojo.getBatchNo();
			tRealPath =  pojo.getRealPath();
			tBatchType = pojo.getBatchType();
			if(mBatchNo == null || mBatchNo.equals("")){
				buildErrors("getInputDate", "无需要上传的批次号");
				return false;
			}
			if(tRealPath == null || tRealPath.equals("")){
				buildErrors("getInputDate", "文件真实路径不存在");
				return false;
			}
			
			tRealPath = tRealPath.replace("\\", "/");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean uploadFile(LoginInfo loginInfo, ParamPOJO pojo) throws CoreException{
		if(!getInputDate(loginInfo,pojo)){
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
	@Transactional
	private boolean preparedData(){
		//TODO 准备数据
		DBContextHolder.recover();
		for(int i = 0; i < updateSql.size(); i ++){
			//执行update
			SqlAdapter sqlAdapter = new SqlAdapter();
			String sql = updateSql.get(i);
			System.out.println("- SQL: "+sql);
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		}
		updateSql.clear();
		return true;
	}
	/**
	 * 文件上载
	 * @param files
	 * @param batchnos
	 * @param directory
	 * @return
	 * @throws CoreException 
	 */
	public boolean UploadFileAction(String[] files,String[] batchnos,String directory) throws CoreException{
		logger.debug("正在上载文件："+tDataType+"\t"+tBatchType+"\t"+tInsureType);
//		USFTPClient client = new USFTPClient(UPLOAD_FTPServer,"U");//从配置文件取
		TDefSftpExample example = new TDefSftpExample();//从数据库T_DEF_SFTP表获取
		//1 代表的是保单等级平台
		example.createCriteria().andComIdEqualTo(1).andEsStatusEqualTo(Short.parseShort("1"));
		
		List<TDefSftp> sftps = tDefSftpMapper.selectByExample(example);
		if(sftps == null || sftps.size() <= 0){
			logger.info("平台 没有配置对应的上传SFTP地址");
			return false;
		}
		String host = null; int port = 0; String username = null;String password = null;
		String vsitUrl = null;
		for(TDefSftp sftp : sftps){
			//上载地址，有且只有一个
			if(sftp.getSftpType().equals("U")){
				host = sftp.getSftpIp();
				port = Integer.parseInt(sftp.getSftpPort());
				username = sftp.getVisitUser();
				password = sftp.getVisitPass();
				vsitUrl = sftp.getVisitUrl();
			}
		}
		//初始化登录信息
		USFTPClient client = new USFTPClient(host,port,username,password);
		ChannelSftp cSftp = null;
		if(client.login()){
			cSftp = client.getSftpClient();
		}
		if(cSftp == null){
			return false;
		}
		if(directory == null || "".equals(directory)){
			directory = vsitUrl;
		}
		for(int i = 0; i < files.length; i++){
			String uploadFile = files[i];
			File file = new File(uploadFile);
			if(!file.exists()){
				throw new CoreException("找不到对应的文件："+file.getName());
			}
			boolean result = client.upload(directory, uploadFile, cSftp);
			if(!result){
				client.disConnect();
				client = null;
				throw new CoreException("文件路径找不到："+uploadFile);
			}
			logger.debug("上传至服务器： "+uploadFile);
		}
		client.disConnect();
		client = null;
		return true;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean dealData() throws CoreException{
		String stateFlag = "3";
		if("DET".equals(tBatchType)){//明细对账数据
			stateFlag = "6";
		}
		String sql = "select m.batch_no,p.pic_path,p.page_name from t_doc_pages p,t_doc_main m where p.doc_id = m.doc_id and m.batch_no = '"+mBatchNo+"'";
		String updatesql = "update t_prp_lcpoltransaction set stateflag = '"+stateFlag+"',modifydate = to_date('"+tCurrentDate+"','yyyy-mm-dd'),modifytime = '"+DateUtils.getCurrentTime()+"',operator = '"+loginInfo.getUserCode()+"' where batchno = '"+mBatchNo+"'";
		String upedp = "update t_doc_pages set page_type = 'S',last_modify_time = to_date('"+DateUtils.getCurrentDateTime()+"','yyyy-mm-dd hh24:mi:ss'),operator = '"+loginInfo.getUserCode()+"' where doc_id in (select doc_id from t_doc_main where batch_no = '"+mBatchNo+"')";
		String upedm = "update t_doc_main set action_flag = '"+stateFlag+"',operator = '"+loginInfo.getUserCode()+"',last_modify_time = to_date('"+DateUtils.getCurrentDateTime()+"','yyyy-mm-dd hh24:mi:ss') where batch_no = '"+mBatchNo+"'";
		//加载
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> list = sqlAdapterMapper.excuteQuery(sqlAdapter);
		if(list != null && list.size() > 0){
			String[] files = new String[list.size()];
			String[] batchnos = new String[list.size()];
			for(int R = 0; R < list.size() ; R++){
				Map map = list.get(R);
				String batchNo = (String) map.get("BATCH_NO");
				String picPath = (String) map.get("PIC_PATH");
				String pageName = (String) map.get("PAGE_NAME");
				batchnos[R] = batchNo;
				String filename = tRealPath +picPath+pageName;
				filename=filename.replace("//", "/");
				System.out.println("加载文件，批次号："+batchNo+" 文件："+filename);
				files[R] = filename;
			}
			try{
				//上载
				boolean result = UploadFileAction(files,batchnos,"");
				if(result){
					new File(tRealPath).deleteOnExit();//删除临时文件夹
					updateSql = new ArrayList<String>();
					updateSql.add(upedm);
					updateSql.add(upedp);
					updateSql.add(updatesql);
				}else{
					logger.info("文件上载失败："+files);
				}
			}catch(CoreException e){
				CError cError = new CError();
				cError.errorMessage = e.getMessage();
				cError.errorType = "0";//找不到文件标识
				cErrors.addOneError(cError);
				return false;
			}
		}
		return true;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.UploadFileService#uploadFile()
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean uploadFile(LoginInfo loginInfo) throws CoreException {
		DBContextHolder.recover();
		//从数据库中获取路径
		String path=codeQueryService.getSysPath("ROOT_PATH");
		
		//从库中查询符合上传条件；
		List<Map> infos = tDocMainMapper.queryInfo();
		if(infos.isEmpty()){
			throw new CoreException("没有需要上传的文件！");
		}
		//infos中可能存在多个对象:批次号、批次类型，所以循环上载
		boolean result = false;
		for(Map<String, String> map:infos){
			ParamPOJO pojo=new ParamPOJO();
			pojo.setBatchNo((String) map.get("BATCH_NO"));
			pojo.setBatchType((String) map.get("TRANSTYPE"));
			pojo.setRealPath(path);
			result = this.uploadFile(loginInfo, pojo);
			if(!result){
				return false;
			}
		}
		return result;
	}
}
