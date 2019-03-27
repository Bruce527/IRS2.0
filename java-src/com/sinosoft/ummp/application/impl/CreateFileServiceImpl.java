package com.sinosoft.ummp.application.impl;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import net.lingala.zip4j.core.ZipFile;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.FileService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Md5;
import com.sinosoft.platform.core.util.NumberUtils;
import com.sinosoft.spoon.ktr.SpoonKtr;
import com.sinosoft.spoon.util.SpoonUtil;
import com.sinosoft.ummp.application.CreateFileService;
import com.sinosoft.ummp.application.TDefBatchService;
import com.sinosoft.ummp.config.ProFile;
import com.sinosoft.ummp.domain.mapper.TDocMainMapper;
import com.sinosoft.ummp.domain.mapper.TDocPagesMapper;
import com.sinosoft.ummp.domain.model.TDocMain;
import com.sinosoft.ummp.domain.model.TDocPages;

import config.Config;
/**
 * 文件生成服务实现类
 * @author Darker.Wang
 * @date 2016-9-4 下午12:01:00
 * @company SINOSOFT
 */
@Service("createFileService")
public class CreateFileServiceImpl implements CreateFileService {
    /** 全局数据 */

	public static final String DOWNLOAD_FTPServer = "DOWNLOAD_FTPServer";
	public static final String UPLOAD_FTPServer = "UPLOAD_FTPServer";
	public static final String MID_UPLOAD_PATH = "/data/upload/";
	public static final String MID_DOWNLOAD_PATH = "/data/download/";
	public static final String MID_LOCAL_PATH = "/data/local/";
	public static final String REALPATH=""; 
	/** 私有数据 */
    private LoginInfo tLoginInfo; //用户登录信息
    private ParamPOJO tPojo; 
    private String mTransactionNo;
    private String mBussType; //业务类型
	private String tDataType;//数据类型 I=增量 H = 存量
	private String mBaseDir = null;
	private String tInsureType;//L 寿险  P 财险
	private String tTransType;//INC、HIS...
	public String mOperate;
	private String mStartDate;
	private String mEndDate;
	private String tStateFlag;//传递过来的初始状态
	private String rStateFlag;//返回处理的结果状态
	private String mBatchNo;
	private String tBatchType;
	private String tComId; //平台机构
	private Properties prop;
	private String tCompanyCode;
	private String tCurrentDate=DateUtils.getCurrentDate();
	private List<File> files = new ArrayList<File>();
	private Map<String,TDocPages> mDocPages = new HashMap<String, TDocPages>();
	private Map<String,TDocMain> mDocMain =new HashMap<String, TDocMain>();
	private String tRealPath;
	private Logger logger = Logger.getLogger(CreateFileServiceImpl.class);
	//新增serialNo 用作文件的序列号，
	//当非DET数据时，serialNo=batchNo DET数据时，serialNo=serialNo，batchNo=batchNo
	//目的是使文件名与批次解耦
	private String serialNo;
	//自动注入
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	TDefBatchService tDefBatchService;
	@Autowired
	SequenceService sequenceService;
	@Autowired
	FileService fileService;
	@Autowired
	TDocMainMapper tDocMainMapper;
	@Autowired
	TDocPagesMapper tDocPagesMapper;
	@Autowired
	CodeQueryService codeQueryService;
	/**
	 * 创建文件提交
	 * @param cInputData 用户基本信息
	 * @param pojo 统一参数类
	 * @return
	 * @throws Exception 
	 */
    public boolean submitData(LoginInfo cInputData, ParamPOJO pojo) throws Exception {
        /** 得到从外部传来的数据，并备份到本类中 */
		if (!getInputData(cInputData,pojo)){
			throw new CoreException("获取初始化数据失败！");
		}
		if (!dealData()){
			return false;
		}
		return true;
	}
	/**
	 * 获取创建后的文件
	 * @return  file
	 */
    public List<File> getCreateFile(){
		return files;
    }
   
	private boolean getInputData(LoginInfo loginInfo,ParamPOJO pojo) {
		System.out.println("--------开始检查传入数据--------");
		tPojo = pojo;
		tLoginInfo = loginInfo;
		if (tLoginInfo == null){
			CError tError = new CError();
			tError.moduleName = "CreateFileServiceImpl";
			tError.functionName = "getInputData";
			tError.errorMessage = "服务器接收TransferData数据为空!";
			cErrors.addOneError(tError);
			return false;
		}
		if (tPojo == null){
			CError tError = new CError();
			tError.moduleName = "CreateFileServiceImpl";
			tError.functionName = "getInputData";
			tError.errorMessage = "服务器接收TransferData数据为空!";
			cErrors.addOneError(tError);
			return false;
		}
		try{
			mStartDate = pojo.getStartDate();//起始日期
			mEndDate = pojo.getEndDate(); // 截止日期
			tDataType = pojo.getDataType();//数据类型 I=增量 H=历史
			tInsureType = pojo.getInsureType();//险类 L=寿险 P=财险  
			tBatchType = pojo.getBatchType();// 批次数据类型（HIS 存量数据；INC 增量数据；FAI 重新上报的错误数据；DET 对账明细数据）
			tComId = pojo.getComId().toString();//平台机构id
			
			mTransactionNo = pojo.getTransNo();
			tTransType = pojo.getTransType();
			mBussType = pojo.getBussType();
			tStateFlag =  pojo.getBussFlag();
			
			mOperate = tLoginInfo.getUserCode();
			
			prop = ProFile.getInstance().getProFile("service");
			
			tCompanyCode = Config.getProperties().getProperty("COMPANY_CODE");
			
			if(tDataType == null || "".equals(tDataType)){
				logger.debug("从配置文件获取数据类型");
				tDataType = prop.getProperty("DATA_TYPE");
			}
			if(tInsureType == null || "".equals(tInsureType)){
				logger.debug("从配置文件获取数险种类型");
				tInsureType = prop.getProperty("INSURE_TYPE");
			}
			if(tBatchType == null || "".equals(tBatchType)){
				logger.debug("从配置文件获取批次类型");
				tBatchType = prop.getProperty("BATCH_TYPE");
			}
			
			//此路径还需设置: 数据库配置的临时路径负值给RealPath
			mBaseDir = codeQueryService.getSysPath("TEMP_PATH");
			tRealPath = codeQueryService.getSysPath("ROOT_PATH");
			
//			mBaseDir = tRealPath;
			
			System.out.println("-create file at : "+tRealPath);
			//StateFlag 特殊化
			if((tStateFlag == null || "".equals(tStateFlag))
					&& "3".equals(tStateFlag)){
				tStateFlag = "1";
			}
			logger.debug("批次类型："+tBatchType+" 数据类型(I=增量 H=历史)："+tDataType
					+" 险种类型(L=寿险 P=财险)： "+tInsureType);
			System.out.println("批次类型："+tBatchType+" 数据类型(I=增量 H=历史)："+tDataType
					+" 险种类型(L=寿险 P=财险)： "+tInsureType);
			System.out.println("准备数据后的状态标示："+tStateFlag);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 创建文件之前备份文件
	 * @return
	 */
	private boolean bakDate2B(){
		String sqlwhere = " and stateflag = '"+ tStateFlag+ "'"+ " and transdate between date  '"+ mStartDate+ "' and  date '"+ mEndDate+ "'";
		if (tTransType != null && !"".equals(tTransType)) {
			sqlwhere += " and transtype = '" + tTransType + "'";
		}
		String sql = "insert into t_prp_lcpoltransaction_b select * from t_prp_lcpoltransaction b WHERE NOT EXISTS (SELECT 1 FROM t_prp_lcpoltransaction_b t WHERE t.batchno = b.batchno) "+sqlwhere;
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		int i = sqlAdapterMapper.excuteInsert(sqlAdapter);
		logger.info("创建文件前备份到B表：between "+ mStartDate+ " and "+ mEndDate+ "记录数："+i);
		return true;
	}
	@SuppressWarnings({ "rawtypes", "null" })
	@Transactional
	//设置生成文件的条件
	private boolean createFile(String temp) throws CoreException {
        System.out.println("--------开始创建文件--------");
        System.out.println("创建文件时的状态标识："+tStateFlag);
		// 0获取数据
		String sqlwhere = " where stateflag = '"+ tStateFlag+ "' "+ " and transdate between date  '"+ mStartDate+ "' and  date '"+ mEndDate+ "'";
		if (tTransType != null && !"".equals(tTransType)) {
			sqlwhere += " and transtype = '" + tTransType + "'";
		}
		DBContextHolder.recover();
		String sql = "select count(1) as counts from t_prp_lcpoltransaction "+sqlwhere;
		String bsql = "select distinct batchNo from t_prp_lcpoltransaction"+sqlwhere;
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		System.out.println("执行计数sql："+sql);
		BigDecimal countResults = sqlAdapterMapper.excuteQueryCount(sqlAdapter);
		BigDecimal zero = new BigDecimal(0);
		if (countResults.compareTo(zero) == 0) {
			CoreException e = new CoreException("无指定条件对应的记录");
			e.setErrorCode("NODATA");
			throw e;
		}
		try {
			//0、生成文件之前备份文件
			bakDate2B();
			
			// 1、生成本地临时文件 txt文件，用来压缩成zip 
			// 先更新，因为数据中需要用到批次号
			System.out.println("开始生成本地临时文件。。。。。");
			serialNo = tDefBatchService.getBatchNo(tInsureType, tBatchType,tCompanyCode);
			// TODO 这一步更新要txtMaker.ktr 同步更新
			if(tBatchType.equals("DET")){//DET 数据
				//新生成的号，与批次号一样格式，但不更新批次号
				sqlAdapter.setSql(bsql);
				System.out.println("DET 获取批次号，sql："+bsql);
				List<Map> tBatchNos = sqlAdapterMapper.excuteQuery(sqlAdapter);
				//批次号复原
				if(tBatchNos != null || tBatchNos.size() > 0){
					mBatchNo = (String) tBatchNos.get(0).get("BATCHNO");
					System.out.println("============>生成文件的批次号："+mBatchNo);
				}
				if(mBatchNo == null || "".equals(mBatchNo)){
					CoreException e = new CoreException("明细对账批次信息为空");
					e.setErrorCode("NODATA");
					throw e;
				}
			}else{
				//非明细对账则更新批次号
				mBatchNo = serialNo;
				String sqlo = "update t_prp_lcpoltransaction set batchno = '"+mBatchNo+"' " +sqlwhere;
				System.out.println(sqlo);
				SqlAdapter updateSql = new SqlAdapter();
				updateSql.setSql(sqlo);
				System.out.println("执行更新sql为："+sqlo);
				int updateResult=sqlAdapterMapper.excuteUpdate(updateSql);
				System.out.println("执行更新sql结果为："+updateResult);
				if(updateResult == 0){
					throw new CoreException("批次号更新失败!");
				}
			}
			
			files.clear();
			cErrors.clearErrors();
			System.out.println("SpoonUtil生成TXT");
			createTextFileByKTR(temp, tDataType, mBatchNo);//SpoonUtil生成TXT
			System.out.println("TXT文件生成结束！");
			// 2、生成压缩文件
			File zip = addFolder2Zip(temp);//解压无损
			System.out.println("ZIP AbsolutePath : "+zip.getAbsolutePath());
			logger.debug("ZIP AbsolutePath : "+zip.getAbsolutePath());
			files.add(zip);
		} catch (Exception e) {
			e.printStackTrace();
			buildError("createFile", "创建文件失败");
			return false;
		}
		return true;
	}
	private boolean dealData() throws CoreException, NoSuchAlgorithmException, IOException {
		System.out.println("开始处理数据。。。");
		boolean result = true;
		//1、生成文件
		rStateFlag = "2E";
		//年月日十分秒作为临时文件
		String temp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		logger.debug("生成文件临时文件夹："+temp);
		if(!createFile(temp)){
			File file = new File(mBaseDir+temp);
			//删除临时文件
			if(file.exists())
			fileService.deleteFile(file);
			System.out.println("===================>删除临时文件夹："+temp);
			return false;
		}
		//2、上传文件
		logger.debug("ZIP 个数："+files.size());
		for(File file : files){
			result = buildDataForSumbit(file);
		}
		//3、完毕
		if(result){
			rStateFlag = "2";
			logger.debug("上传成功:");
		}
		File file = new File(mBaseDir+temp);
		//删除临时文件
		if(file.exists())
		fileService.deleteFile(file);
		System.out.println("===================>删除临时文件夹："+temp);
		//生成对应文件数据，保存在数据库
		System.out.println("开始生成对应的文件数据，保存在数据库。。");
		result = prepareOutputData(rStateFlag);
		return result;
	}
	
	/**
	 * 构建提交数据
	 * @param zip
	 * @return
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws Exception 
	 */
	private boolean buildDataForSumbit(File zip) throws CoreException, NoSuchAlgorithmException, IOException{
		
		String zipName = zip.getName();
		logger.debug("====== "+DateUtils.getCurrentDate()+"\tSAVE FILE ："+zipName+" TO DB FOR UP OR DOWN ");
		String dateFileName = new SimpleDateFormat("yyyyMM").format(new Date())+"/";
		String zipPath = tRealPath+MID_LOCAL_PATH+dateFileName+zipName;
		logger.debug("A-PATH: "+zip.getAbsolutePath());
		logger.debug("B-PATH: "+zipPath);
		
		String md5 = Md5.getMD5(zipPath);
		if(!Md5.md5CheckSum(zipPath, md5)){
			logger.debug("MD5码校验失败");
			throw new CoreException("MD5码校验失败");
		}
		String aDocCode = sequenceService.getMaxNo("SEQ_DOCCODE", 10);
		Double val=Double.valueOf(aDocCode);
		BigDecimal aDocCode1= BigDecimal.valueOf(val);
		String actionId = sequenceService.getMaxNo("SEQ_ESACTIONID", 10);
		String aPageCode = sequenceService.getMaxNo("SEQ_PAGECODE", 10);
		Double val1=Double.valueOf(aPageCode);
		BigDecimal aPageCode1= BigDecimal.valueOf(val1);
		
		//构建 t_DOC_MAIN
		TDocMain tDocMain=new TDocMain();
		System.out.println("t_DOC_MAIN ActionId : "+actionId);

		tDocMain.setDocId(aDocCode1);         //唯一标示一份文件的编号，系统生成
		tDocMain.setBatchNo(mBatchNo);        //不能为空，无时默认为0
		tDocMain.setTransNo(mTransactionNo);  //交易编号
		tDocMain.setDocCode(aDocCode);        //一份文件的号码，如投保单印刷号等
		tDocMain.setDocUnic("UTF-8");         //文件编码：UTF-8 GBK 等
		tDocMain.setBussType(mBussType);      //承保理赔保全未清分
		tDocMain.setSubBussType(tBatchType);   //投保单体检资料生调资料
		//tDocMain.setDocPages();		      //该单据页数
		//tDocMain.setActionTimes();          //操作的次数统计
		tDocMain.setDocFlag("1");             //是否有效 0--无效1--有效
		tDocMain.setDocRemark("");            //备注
		tDocMain.setComId(tComId);             //平台机构
		tDocMain.setEsStatus((short) 1);      //1-有效 0-无效 2-删除
		tDocMain.setScanOperator(mOperate);   //扫描者
		tDocMain.setInsertTime(DateUtils.getDate(tCurrentDate));    //入库日期
		tDocMain.setLastModifyTime(DateUtils.getDate(tCurrentDate));//最后一次修改时间
		tDocMain.setOperator(mOperate);       //操作者
		tDocMain.setVersion("1.0");           //版本
		tDocMain.setPrintCode(actionId);      //打印编号,可能有问题
		//tDocMain.setActionFlag(rStateFlag);	  //数据状态
		
		mDocMain.put("docMain", tDocMain);

		//构建 t_DOC_PAGES
		TDocPages tDocPages=new TDocPages();
		BigDecimal aPageCount =new BigDecimal(zipName.substring(zipName.lastIndexOf(".")-2, zipName.lastIndexOf("."))) ;
		String aPicPathFTP = prop.getProperty(UPLOAD_FTPServer+"_filepath");
		tDocPages.setPageId(aPageCode1);      //索引
		tDocPages.setPageCode("UTF-8");       //页码编码
		tDocPages.setPageName(zipName);       //页码名称
		tDocPages.setPageCount(aPageCount);   //页码统计
		tDocPages.setPageSuffix("zip");       //后缀
		tDocPages.setPageType("L");           //L 本地中心 S-上载了
		tDocPages.setPageFlag("1");           //0--本地1--上载中心
		tDocPages.setDocId(aDocCode1);	      //单据ID MAIN表外键
		tDocPages.setPicPath(MID_LOCAL_PATH+dateFileName); //相对路径，相对于HTTP服务器
		tDocPages.setPicPathFtp(aPicPathFTP); //相对路径，相对于FTP服务器
		tDocPages.setMd5Code(md5);            //MD5码
		tDocPages.setOperator(mOperate);      //操作者
		tDocPages.setInsertTime(DateUtils.getDate(tCurrentDate));        //入库时间
		tDocPages.setLastModifyTime(DateUtils.getDate(tCurrentDate));    //最后一次修改日期
		tDocPages.setScanNo(mOperate);        //扫描者
		tDocPages.setDocKey("");              //文件密钥，如果有
	
		mDocPages.put("docPages",tDocPages);
		return true;
	}
	
	/**
	 * 增加一条数据到T_DOC_MAIN表
	 * @throws CoreException 
	 */
	@Transactional
	public void addDocMain(TDocMain tDocMain){
		tDocMainMapper.insert(tDocMain);
	}
	
	/**
	 * 增加一条数据到T_DOC_PAGES表
	 * @throws CoreException 
	 */
	
	@Transactional
	public void addDocPages(TDocPages tDocPges){
		tDocPagesMapper.insert(tDocPges);
	}
	
	@Transactional
	 /**
     * 准备数据往后传，数据持久化
     * @param zip
     */
	private boolean prepareOutputData(String tStateflag) {
		try {
			String up_transaction = "";
			up_transaction = "update t_prp_lcpoltransaction set transtype = '"+tBatchType+"',stateflag = '"+tStateflag+"',modifydate = date '"+tCurrentDate+"', modifytime = '"+DateUtils.getCurrentTime()+"' where BatchNo='"+mBatchNo +"'";
			logger.debug(up_transaction);
			SqlAdapter adapter=new SqlAdapter(); 
			adapter.setSql(up_transaction);
			int excuteUpdate = sqlAdapterMapper.excuteUpdate(adapter);
			System.out.println("执行更新t_prp_lcpoltransaction表的结果："+excuteUpdate);
			
			System.out.println("执行更新doc表。。。");
			//新增一条记录到T_DOC_MAIN
			mDocMain.get("docMain").setActionFlag(tStateflag);
			addDocMain(mDocMain.get("docMain"));
			
			//新增一条记录到T_DOC_PAGES
			addDocPages(mDocPages.get("docPages"));
			System.out.println("往T_DOC_PAGES中插入一条数据");
			
		}  catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("生成文件结束。。。");
		return true;
	}

	private String createTextFileByKTR(String baseDir,String batchSuffix,String batchNo){
		baseDir = mBaseDir+baseDir;
		System.out.println("基础地址："+baseDir);
		File dirfile = new File(baseDir);
		System.out.println("IS EXITST : "+baseDir+"  "+dirfile.exists());
		logger.debug("IS EXITST : "+baseDir+"  "+dirfile.exists());
		if(!dirfile.exists()){
			logger.debug("创建临时文件夹");
			dirfile.mkdir();
		}
		dirfile.setWritable(true,false);
		logger.debug("======开始 "+DateUtils.getCurrentTime());
		System.out.println("======开始 "+DateUtils.getCurrentTime());
		long s = System.currentTimeMillis();
		logger.debug("生成TXT参数：baseDir:"+baseDir+"\tbatchSuffix:"+batchSuffix+"\tbatchNo:"+batchNo);
		boolean result = createTxtFile(baseDir, batchSuffix, batchNo, serialNo);
		if(result){
			logger.debug("生成TXT文件成功："+baseDir);
		}
		logger.debug("======结束 "+DateUtils.getCurrentTime());
		logger.debug("======耗时  "+(System.currentTimeMillis()-s)+" s");
		return baseDir;
	}

	/**
	 * 通过KTR按批次生成指定的Txt文件
	 * @param baseDir
	 * @param batchSuffix
	 * @param batchNo
	 * @return
	 */
	private boolean createTxtFile(String baseDir,String batchSuffix,String batchNo,String serialNo){
		SpoonUtil util = new SpoonUtil();
		System.out.println("开始通过KTR按批次生成指定的Txt文件，参数为----》"+"基础地址："+baseDir+"   批次。。"+batchSuffix+"   批次号："+batchNo);
		String ktr =  SpoonKtr.class.getResource("").getPath()+"txtMaker.ktr" ;
		Map<String,String> params = new HashMap<String,String>();
		params.put("baseDir", baseDir);
		params.put("batchSuffix", batchSuffix);
		params.put("batchNo", batchNo);
		params.put("serialNo",serialNo);
		if(!util.doKtrTransByJob(ktr, params)){
			cErrors.addOneError(util.cErrors.getFirstError());
		};
		return true;
	}
	/**
	 * 添加指定路径，压缩为ZIP
	 * @param localPath
	 * @return
	 */
	private File addFolder2Zip(String localPath){
		String dateFileName = new SimpleDateFormat("yyyyMM").format(new Date())+"/";
		String zipPath  = tRealPath+MID_LOCAL_PATH+dateFileName;
//		String zipName = tDataType+"_"+mBatchNo+"_";
		String zipName = tDataType+"_"+serialNo+"_";
		localPath = mBaseDir + localPath;
		File file = null;
		try {
			int number = fileService.getFileNum(localPath,"txt");
			zipName = zipName + NumberUtils.getNumber(number, 3) + ".zip";
			if(zipName.contains("/")){
				logger.debug("ZIPNAME CONTENT '/' AND REPLACE IT ");
				zipName = zipName.replace("/", "");
			}
			/**
			 * 
			 */
			File zipfileroot = new File(zipPath);
			zipfileroot.setWritable(true, true);
			ZipFile zipfile = fileService.local2ZipFile(localPath+"/"+tCompanyCode,zipPath,zipName);
			file = zipfile.getFile();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		logger.debug(file);
		System.out.println(file);
		return file;
	}
	/**
	 * 构建错误信息
	 * @param szFunc
	 * @param szErrMsg
	 */
	private void buildError(String funName, String aMsg){
		CError cError = new CError();
		cError.moduleName = "CreateFileServiceImpl";
		cError.functionName = funName;
		cError.errorMessage = aMsg;
		logger.info(cError.errorMessage);
		System.out.println(cError.errorMessage);
		cErrors.addOneError(cError);
	}
	
	public static void main(String[] args) {
		
	}
}
