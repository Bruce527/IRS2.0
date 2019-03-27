package com.sinosoft.ummp.application.impl;

import java.io.File;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcraft.jsch.ChannelSftp;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.PlatFileUtil;
import com.sinosoft.platform.core.util.PubFun;
import com.sinosoft.spoon.ktr.SpoonKtr;
import com.sinosoft.spoon.util.SpoonUtil;
import com.sinosoft.ummp.application.DealReturnFileService;
import com.sinosoft.ummp.domain.mapper.TDefSftpMapper;
import com.sinosoft.ummp.domain.model.TDefSftp;
import com.sinosoft.ummp.domain.model.TDefSftpExample;
import com.sinosoft.ummp.domain.model.TDefSftpExample.Criteria;
import com.sinosoft.ummp.util.USFTPClient;

/**
 * 数据处理实现类
 * @author sendylou
 * @date 2016/9/5
 * @company sinosoft
 * 
 */

@Service("dealReturnFile")
public class DealReturnFileServiceImpl implements DealReturnFileService {
	
	public static final String REALPATH="REALPATH"; 
	public boolean isLocal = true;//是否本地文件
	public CErrors cErrors = new CErrors();
	
	private ParamPOJO tPojo;//接收userCode参数
	private String tOper = "zip";//返回处理文件类型
	private String tUserCode = "";//用户编码userCode
	private String tFilePath = "";//filePath
	private String tRealPath = "";//路径/root/icp/
	private String path = CreateFileServiceImpl.MID_DOWNLOAD_PATH;//利用已写好的类的静态常量,类名.出来"/data/download/"
	private String fileName = "";//从页面选中获取压缩文件包名,前台页面传递
	private Logger logger = Logger.getLogger(DealReturnFileServiceImpl.class);
	
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	SequenceService sequenceService;
	@Autowired
	TDefSftpMapper tDefSftpMapper;
	
	SqlAdapter sqlAdapter = new SqlAdapter();
	// 是否本地数据： 默认本地 true ,false的话去服务器先下载再处理
	// 当非本地文件时需传递tRealPath
	/**
	 * 数据处理
	 * 
	 * @return
	 */
	public boolean submitData(ParamPOJO Pojo) {
		if (!getInputDate(Pojo)) {
			return false;
		}
		if (!dealData()) {
			return false;
		}
		return true;
	}
	/**
	 * 参数传递
	 * 
	 * @param Pojo
	 * @return
	 */
	private boolean getInputDate(ParamPOJO Pojo) {
		tPojo = Pojo;
		tUserCode=tPojo.getUserCode();//userCode
		if(tUserCode == null){
			return buildErrors("无数据传入", "getInputDate");
		}
		
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
		//判断该文件夹是否存在
		File file = new File(tRealPath);
		if(!file.exists()){
			System.out.println("创建文件夹："+file);
			file.mkdirs();
		}
		fileName = tPojo.getFileName();//fileName
		tFilePath = (tRealPath+path+fileName).replace("\\/", "/").replace("\\", "/");//拼接成tFilePath
		return true;
	}
	
	/**
	 * 添加错误容器
	 * 
	 * @param funName
	 *            处理方法
	 * @param msg
	 *            错误内容
	 * @return
	 */
	private boolean buildErrors(String funName, String msg) {
		CError cError = new CError();
		cError.errorMessage = msg;
		cError.functionName = funName;
		logger.debug(cError.errorMessage);
		cErrors.addOneError(cError);
		return false;
	}
	
	/***
	 * 处理逻辑
	 * 
	 * @return
	 */
	private boolean dealData() {
		try {
			String dealpath = tFilePath;
			if(!new File(dealpath).exists()){
				isLocal=false;
			}
			if ("txt".equals(tOper)) {
				return dealAsTxt("DealReturnError", dealpath);
			}
			if ("zip".equals(tOper)) {
				return dealAsZip(dealpath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 持久化处理返回错误文件
	 * 
	 * @param dealktr
	 * @param txtpath
	 * @return
	 * @throws SQLException
	 */
	@Transactional
	private boolean dealAsTxt(String dealktr, String txtpath)
			throws SQLException {
		String ktr = SpoonKtr.class.getResource("").getPath() + "deal/"
				+ dealktr + ".ktr";
		System.out.println("正在处理返回错误文件：" + ktr);
		Map<String, String> params = new HashMap<String, String>();
		String tBatchNo = txtpath.substring(txtpath.lastIndexOf("/") + 1,
				txtpath.lastIndexOf("."));
		if (tBatchNo.contains("_")) {
			tBatchNo = tBatchNo.substring(tBatchNo.lastIndexOf("_") + 1);
		}//获取文件批次号
		boolean result = false;
		try {
			System.out.println("文件批次号为：" + tBatchNo);
			System.out.println("——————————————————————————————");
			String sql_ump = "delete from t_prp_lcpoltransaction_error where batchno like '%"
					+ tBatchNo + "%' and stateflag is null";//匹配表中文件批次号为tBatchNo,stateflag字段为null的从表删除
			
			sqlAdapter.setSql(sql_ump);
			DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_UMP);
			int count = sqlAdapterMapper.excuteDelete(sqlAdapter);// 删除原来的未处理的记录
			params.put("txtpath", txtpath);
			params.put("batchNo", tBatchNo);
			if(count == 0){
				result=false;
			}
			System.out.println("正在调用KTR处理数据：");
			SpoonUtil util = new SpoonUtil();
			result = util.doKtrTransByJob(ktr, params);
			if(result){//如果执行了删除了错误表中的记录,开始处理更新
				System.out.println("正在处理数据更新：");
				dealErrorBefor(tBatchNo);//处理前操作
				dealError(tBatchNo);//处理操作
				result = true;
				System.out.println("处理数据更新完毕！");
			}
			System.out.println("====== 错误处理完毕！");
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	
	/**
	 * 插入统计错误批次轨迹
	 * 
	 * @param tBatchNo
	 * @return
	 */
	private boolean dealErrorBefor(String tBatchNo) {
		String errorPathType = "S";
		if (isLocal) {//判断是否本地文件
			errorPathType = "L";
		}
		String sql = "INSERT INTO T_PRP_DEALERRORTRACE "+
				"SELECT LPAD(DERROR_TRACE_SEQ.NEXTVAL, 12, 0) AS TRACEID,o.*  FROM dual LEFT JOIN ( " +
				"     SELECT DISTINCT " + 
				"         BATCHNO,'0' AS DEALSTATE, " + 
				"         TO_DATE(TO_CHAR(SYSDATE, 'yyyy-mm-dd'), 'yyyy-mm-dd') AS DEALDATE, " + 
				"         TO_CHAR(SYSDATE, 'hh:mm:ss') AS DEALTIME, " + 
				"         '"+ tUserCode +"' AS DEALOPER, " + 
				"         ERRINFOPATH, " + 
				"         '"+errorPathType+"' AS ERRORPATHTYPE " + 
				"     FROM T_PRP_LCPOLTRANSACTION_RETURN LCPR " + 
				"   WHERE ERRINFOPATH IS NOT NULL " + 
				"     AND ACTIONFLAG = '1' " + 
				"     AND STATEFLAG IN ('5', '7','5E') " + 
				"     AND DATASTATUS IN ('0001', '0002') " + 
				"     AND STATUS IN ('0000') " + 
				"     AND NOT EXISTS " + 
				"   (SELECT 'X' FROM T_PRP_DEALERRORTRACE DE WHERE DE.BATCHNO = LCPR.BATCHNO) " + 
				"     AND BATCHNO = '" + tBatchNo + "') o ON 1=1 ";
		
		try {
			sqlAdapter.setSql(sql);
			DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_UMP);
			sqlAdapterMapper.excuteInsert(sqlAdapter);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 错误处理：更新错误信息为状态%E
	 * 
	 * @param tBatchNo
	 * @return
	 * @throws SQLException
	 */
	private boolean dealError(String tBatchNo) throws SQLException {
		String date = PubFun.getCurrentDate();
		String time = PubFun.getCurrentTime();
		System.out.println("实时日期:"+date);
		String transnos = "select distinct transactionno from t_prp_lcpoltransaction_error where batchNo like '%"
				+ tBatchNo + "%' and stateflag is null";//获取交易号
		String sql2 = "update t_prp_lcpoltransaction set stateflag = '5E',modifyDate = to_date('"+ date+ "','yyyy-mm-dd')"
				+" ,modifyTime = '"
				+ time
				+ "' where batchno = '"
				+ tBatchNo + "' and transactionno in (" + transnos + ")";
		//更新(batchno=tBatchNo文件批次号)并且(transactionno匹配transnos交易号)的表stateflag状态为5E,date,time
		String sql3 = "update t_prp_lcpoltransaction_error set stateflag = '1'" 
				+",operator = '"+ tUserCode + "'" 
				+",makedate = to_date('"+ date+ "','yyyy-mm-dd')"
				+",maketime = '"+ time+ "'"
				+ " where batchNo like '%"
				+ tBatchNo + "%' and transactionno in (" + transnos + ")";
		String sql4 = "update t_prp_dealerrortrace set dealstate = '1',dealdate = to_date('"+ date+ "','yyyy-mm-dd')"
				+" ,dealtime = '" + time + "' where batchNo like '%"
				+ tBatchNo + "%' ";
		System.out.println("正在处理：" + sql2);
		sqlAdapter.setSql(sql2);
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_UMP);
		int  count = sqlAdapterMapper.excuteUpdate(sqlAdapter);
		boolean result = false; 
		if(count > 0){
			result = true;
		}
		if(result){
			System.out.println("正在处理：" + sql3);
			System.out.println("正在处理：" + sql4);
			sqlAdapter.setSql(sql3);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
			sqlAdapter.setSql(sql4);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
			result = true;
		}
		return result;
	}

	/**
	 * zip格式处理
	 * 
	 * @param dealpath
	 * @return
	 * @throws SQLException 
	 */
	private boolean dealAsZip(String dealpath) throws SQLException {
		if (!isLocal) {
			System.out.println("非本地文件，下载文件先");
			dealpath = downFile(dealpath);
		}
		String parentpath = PlatFileUtil.unZip(dealpath);
		return dealAsCirc(parentpath);//递归处理zip文件为txt文件
	}

	/**
	 * 下载文件先
	 * 
	 * @param downpath
	 * @return
	 */
	private String downFile(String downpath) {
		String rtvpath = null;
		USFTPClient client = null;
		ChannelSftp cSftp = null;
		try {
//			client = new USFTPClient("DOWNLOAD_FTPServer", "D");
			TDefSftpExample example = new TDefSftpExample();//从数据库T_DEF_SFTP表获取
			//1 代表的是保单等级平台
			Criteria criteria = example.createCriteria().andComIdEqualTo(1).andEsStatusEqualTo(Short.parseShort("1")).andSftpTypeEqualTo("D");
			List<TDefSftp> sftp = tDefSftpMapper.selectByExample(example);
			if(sftp == null || sftp.size() <= 0){
				logger.info("平台 没有配置对应的上传SFTP地址");
			}
			String host = null; int port = 0; String username = null;String password = null;
			String vsitUrl = null;
					host = sftp.get(0).getSftpIp();
					port = Integer.parseInt(sftp.get(0).getSftpPort());
					username = sftp.get(0).getVisitUser();
					password = sftp.get(0).getVisitPass();
					vsitUrl = sftp.get(0).getVisitUrl();
			//初始化登录信息
			client = new USFTPClient(host,port,username,password);
			if (client.login()) {
				cSftp = client.getSftpClient();
			}
			if (cSftp == null) {
				return null;
			}
			System.out.println("DOWN_DIR: " + downpath);
			String fileName = downpath.substring(downpath.lastIndexOf("/") + 1);
			String saveFile = tRealPath + path + fileName;
			System.out.println("====================>"+client.getBasedir());
			boolean result = client.download(vsitUrl, fileName,
					saveFile, client.getSftpClient());
			if (result) {
				rtvpath = saveFile;
			}
			client.disConnect();
		} catch (Exception e) {
			CError cError = new CError();
			cError.errorMessage = "文件下载失败:" + e.getMessage();
			cError.functionName = "downFile";
			cErrors.addOneError(cError);
			System.out.println(cError.errorMessage);
			return null;
		}
		return rtvpath;
	}
	
	/**
	 * 递归处理
	 * 
	 * @param file
	 * @return
	 * @throws SQLException 
	 */
	private boolean dealAsCirc(String file) throws SQLException {
		if (file.endsWith("txt")) {
			return dealAsTxt("DealReturnError", file);
		} else {
			File tf = new File(file);
			String filepath = tf.getPath();
			if (tf.isDirectory()) {
				String[] files = tf.list();
				for (String f : files) {
					f = filepath + "/" + f;
					dealAsCirc(f);
				}
			}
			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		USFTPClient client = null;
		String host = null; int port = 0; String username = null;String password = null;
//		String vsitUrl = null;
				host = "88.88.4.12";
				port = 22;
				username = "gyas000031";
				password = "EjTArpnQ";
				QueryFileServiceImpl impl=new QueryFileServiceImpl();
		//初始化登录信息
		client = new USFTPClient(host,port,username,password);
		boolean b = client.login();
		if(b){
			try {
						client.download("upload", "000031LINC0003404225.zip",
								"d:\\1234\\000031LINC000340422222.zip", client.getSftpClient());
						client.download("upload", "H_000031LHIS0000000896_016.zip",
								"d:\\1234\\H_000031LHIS0000000896_016.zip", client.getSftpClient());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	
	}
}
