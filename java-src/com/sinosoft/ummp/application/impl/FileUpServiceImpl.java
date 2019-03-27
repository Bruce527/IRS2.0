package com.sinosoft.ummp.application.impl;


import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jcraft.jsch.ChannelSftp;
import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.CErrors;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.PubFun;
import com.sinosoft.platform.core.util.TransferData;
import com.sinosoft.ummp.application.FilelUpService;
import com.sinosoft.ummp.domain.mapper.TDocUpdownMapper;
import com.sinosoft.ummp.domain.mapper.TPrpLduserfileMapper;
import com.sinosoft.ummp.domain.model.TPrpLduserfile;
import com.sinosoft.ummp.util.USFTPClient;

/**
 * 文件上载服务实现类
 * @author Darker.Wang
 * @date 2016-10-12 上午11:35:22
 * @company SINOSOFT
 */
@Service
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FileUpServiceImpl implements FilelUpService{
	
	@Autowired
	TPrpLduserfileMapper tPrpLduserfileMapper;
	
	public CErrors cErrors = new CErrors();
	ParamPOJO Pojo=null;
	String tRealPath = "";
	String tCurrentDate = PubFun.getCurrentDate();
	String tCurrentTime = PubFun.getCurrentTime();
	TransferData tTD = null;
	String tAppPath = "";//自己赋值
	String  HDFilePaths = "";
	String id="";
	
	private String relapaths = "";
	public	boolean Xmlresule = false;
	private	String xmlpath = "";
	private String paths = "";
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	
	@Autowired
	SequenceService sequenceService;
	
	@Autowired
	TDocUpdownMapper tDocUpdownMapper;
	@Autowired
	CodeQueryService codeQueryService;

	@Override
	public boolean creatFile(ParamPOJO pojo) {
		tAppPath=codeQueryService.getSysPath("ROOT_PATH");
		tAppPath=tAppPath.replace("\\", "/");
		tAppPath=tAppPath+"ses";
		boolean resule=CreatXml(tAppPath);
		if(!resule){
			return false;
		}
		return resule;
	}
	/**
	 * 构建Error信息
	 * @param funcName
	 * @param msg
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean buildError(String funcName,String msg){
		CError cError = new CError();
		cError.functionName = this.getClass().getName()+" "+funcName;
		cError.errorMessage = msg;
		cErrors.addOneError(cError);
		System.out.println(cError.errorMessage);
		return false;
	}
@Override
public boolean uploadFile(String id) {
	// TODO Auto-generated method stub
		HDFilePaths=tPrpLduserfileMapper.selectByPrimaryKey(id).getFilepath();
		
		return  AutoUpXml(HDFilePaths,id);//AutoUpXml(HDFilePaths,id);
		


}
	
	
		
	
		
			
	
	//获取表格
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> queryListInfoPages(DataGridModel dgm,TPrpLduserfile tPrpLduserfile) {
		Map<String, Object> result = new HashMap<String, Object>(2);
		Map paramMap = new HashMap();
		paramMap.put("filename", tPrpLduserfile.getFilename());
		paramMap.put("filepath", tPrpLduserfile.getFilepath());
		paramMap.put("filetype", tPrpLduserfile.getFiletype());
		paramMap.put("id", tPrpLduserfile.getId());
		List<Map> list = tPrpLduserfileMapper.queryListInfoPages(paramMap);
		int queryCount = tPrpLduserfileMapper.queryCount();
		if (queryCount>5){
			queryCount=5;
		}
		result.put("rows",list);
		result.put("total", queryCount);
		return result;
	}

	public boolean Xmldatype() {
		String datatype[] = { "T_PRP_LCPolicyDeliveryRate", "T_PRP_LCPhoneCompleteRate","T_PRP_LCReviewSuccessRate", "T_PRP_LCClaimGetRate", "T_PRP_LCPreservationPeriod" };
		for (int i = 0; i < datatype.length; i++) {
		
			String maxmakedateSql = "select to_char(max(makedate),'yyyy-mm-dd') as MAKERDATE from "+ datatype[i] + "";
			
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(maxmakedateSql);
			List<Map> makerdate1 = sqlAdapterMapper.excuteQuery(sqlAdapter);
			String makerdate= (String) makerdate1.get(0).get("MAKERDATE");
			
			String countSql = "Select Count(1) From " + datatype[i] + "";
			SqlAdapter sqlAdapter1 = new SqlAdapter();
			sqlAdapter1.setSql(countSql);
			int countnub =
					sqlAdapterMapper.excuteQueryCount(sqlAdapter1).intValue();
			System.out.println("countnub: " + countnub);

			int cishu = countnub / 1000000;
			String begin;
			String end;
			for (int j = 0; j <= cishu; j++) {
				begin = (1000000 * j + 1) + "";
				end = (1000000 * (j + 1)) + "";
				try {
					System.out.println("begin:" + begin + " end:" + end);
					if (i == 0) {
						Xmlresule = buildHead1(begin, end, makerdate);
					}
					if (i == 1) {
						Xmlresule = buildHead2(begin, end, makerdate);
					}
					if (i == 2) {
						Xmlresule = buildHead3(begin, end, makerdate);
					}
					if (i == 3) {
						Xmlresule = buildHead4(begin, end, makerdate);
					}
					if (i == 4) {
						Xmlresule = buildHead5(begin, end, makerdate);
					}
					
				} catch (Exception e) {
				return false;
				}
			}
			System.out.println("Xmlresule: " + Xmlresule);
		}
		return Xmlresule;
	}
	//工具类  
	public static boolean makeDir(String tPath){
		File zipPathFile = new File(tPath);
		if(zipPathFile.exists()){
			return true;
		}
		if(zipPathFile.isFile()){
			makeDir(zipPathFile.getParent());
			zipPathFile= null;
		}
		zipPathFile.mkdirs();
		zipPathFile = null;
		return true;
	}	
	public static ZipFile newZipFile(String zipPath,String zipName) throws ZipException{
		
		//Do ZIP INIT INFO
		if(!zipPath.endsWith("/")){
			zipPath = zipPath+"/";
		}
		if(!zipName.endsWith(".zip")){
			zipName = zipName+".zip";
		}
		makeDir(zipPath);
		System.out.println("NEW　ZIP FILE : "+zipPath+zipName);
		ZipFile zipFile = new ZipFile(zipPath+zipName);
		return zipFile;}
	
	
	public boolean buildHead1(String begin, String end, String makerdate) throws Exception {
		Document tDoc = DocumentHelper.createDocument();
		tDoc.clearContent();
		Element root = tDoc.addElement("root");
		Element CompanyCode = root.addElement("CompanyCode");
		Element dataType = root.addElement("dataType");
		Element data = root.addElement("data");
		Element table = data.addElement("table");
		Element rows = table.addElement("rows");
		Element row = null;
		String name;
		String path;
		tDoc.isReadOnly();// 受保护，防止修改
		CompanyCode.addText("000031");// 法人机构代码
		dataType.addText("SDSX");// 请求类型
		String LCDocIdSQL = "select * from (SELECT COMPANYCODE, ID, AREACODE,POLICYNO, APPDATE,UNDERDATE, CHANNEL, ISRECIEPTOK, POLRECIEPTDATE FROM T_PRP_LCPolicyDeliveryRate WHERE makedate =to_date('"
				+ makerdate
				+ "','yyyy-mm-dd')) where  to_number(substr(id, 11, 21)) between "
				+ begin + " and " + end + "";// TODO
		SqlAdapter sqlAdapter2 = new SqlAdapter();
		sqlAdapter2.setSql(LCDocIdSQL);
		List<Map> srs2 = sqlAdapterMapper.excuteQuery(sqlAdapter2);
		try {
			for (int i = 1; i <= srs2.size(); i++) {
				
				
				String ID = (String) srs2.get(i-1).get("ID");
				String AREACODE =(String) srs2.get(i-1).get("AREACODE").toString();
				String POLICYNO = (String) srs2.get(i-1).get("POLICYNO").toString();
				String APPDATE =  srs2.get(i-1).get("APPDATE").toString();
				String UNDERDATE =  srs2.get(i-1).get("UNDERDATE").toString();
				String CHANNEL = (String) srs2.get(i-1).get("CHANNEL").toString();
				String ISRECIEPTOK =(String) srs2.get(i-1).get("ISRECIEPTOK").toString();
				String POLRECIEPTDATE =(String) srs2.get(i-1).get("POLRECIEPTDATE");
				row = rows.addElement("row");
				row.addElement("id").addText(ID);// 流水号 10位长度
				row.addElement("areaCode").addText(AREACODE);// 时间戳（yyyymmddhhmmss）
				row.addElement("policyNo").addText(POLICYNO);// 上报数据类型
				row.addElement("appDate").addText(APPDATE);
				row.addElement("underDate").addText(UNDERDATE);
				row.addElement("channel").addText(CHANNEL);
				row.addElement("isRecieptOk").addText(ISRECIEPTOK);
				if (POLRECIEPTDATE!=null&POLRECIEPTDATE!=""){
				row.addElement("polRecieptDate").addText(POLRECIEPTDATE);}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
	}
		paths = relapaths + "/" + "SDSX" + end;
		makeDir(paths);
		end=end.substring(0, 1);
		path = paths + "/" +"SDSX"+"_"+end + ".xml";
		System.out.println("-------------------------------------------------------------");
		System.out.println(path);
		Writer out = new FileWriter(path);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setTrimText(false);
		XMLWriter writer = new XMLWriter(out,format);
        writer.write(tDoc);
        writer.close();
        
			name = "SDSX"+"_"+end;
			System.out.println(paths);
			
		return addFolder2Zip(path, name);
	}

public boolean buildHead2(String begin, String end, String makerdate) throws Exception {
	Document tDoc = DocumentHelper.createDocument();
	tDoc.clearContent();
	Element root = tDoc.addElement("root");
	Element CompanyCode = root.addElement("CompanyCode");
	Element dataType = root.addElement("dataType");
	Element data = root.addElement("data");
	Element table = data.addElement("table");
	Element rows = table.addElement("rows");
	Element row = null;
	String name;
	String path;
	String PCDocIdSQL = "select * from (select  COMPANYCODE,ID,AREACODE,to_char(callTime,'yyyy-mm-dd hh24:mi:ss') as callTime,callNumber,  to_char(connectionTime,'yyyy-mm-dd hh24:mi:ss') as connectionTime,  to_char(downTime,'yyyy-mm-dd hh24:mi:ss') as downTime,isConnected from T_PRP_LCPhoneCompleteRate  WHERE makedate=to_date('"
				+ makerdate
				+ "','yyyy-mm-dd'))  where to_number(substr(id, 11, 21))  between "
			+ begin
			+ "  and " + end + "";// TODO
	SqlAdapter sqlAdapter3 = new SqlAdapter();
	sqlAdapter3.setSql(PCDocIdSQL);
	List<Map> srs3 = sqlAdapterMapper.excuteQuery(sqlAdapter3);
	CompanyCode.addText("000031");// 法人机构代码
	dataType.addText("DHSX");// 请求类型
	for (int i = 1; i <= srs3.size(); i++) {
		String ID = (String)srs3.get(i-1).get("ID");
		String AREACODE = (String)srs3.get(i-1).get("AREACODE");
		String callTime = (String)srs3.get(i-1).get("CALLTIME").toString();
		String callNumber =(String)srs3.get(i-1).get("CALLNUMBER");
		String connectionTime = (String)srs3.get(i-1).get("CONNECTIONTIME");
		String downTime =(String)srs3.get(i-1).get("DOWNTIME");
		String isConnected =(String)srs3.get(i-1).get("ISCONNECTED");
		System.out.println(connectionTime);
		System.out.println(downTime);
		row = rows.addElement("row");
		row.addElement("id").addText(ID);// 流水号 10位长度
		row.addElement("areaCode").addText(AREACODE);// 时间戳（yyyymmddhhmmss）
		row.addElement("callTime").addText(callTime);// 上报数据类型
		row.addElement("callNumber").addText(callNumber);
		row.addElement("connectionTime").addText(connectionTime);
		row.addElement("downTime").addText(downTime);
		row.addElement("isConnected").addText(isConnected);
	}
	paths = relapaths + "/" + "DHSX" + end;
	makeDir(paths);
	end=end.substring(0, 1);
	path = paths + "/" + "DHSX"+"_"+end + ".xml";
	Writer out = new FileWriter(path);
	OutputFormat format = OutputFormat.createPrettyPrint();
	format.setTrimText(false);
	XMLWriter writer = new XMLWriter(out,format);
    writer.write(tDoc);
    writer.close();
   
		name = "DHSX"+"_"+end;
		System.out.println(paths);
		
	
	return addFolder2Zip(path, name);
}

public boolean buildHead3(String begin, String end, String makerdate) throws Exception {
	Document tDoc = DocumentHelper.createDocument();

	
	tDoc.clearContent();
	Element root = tDoc.addElement("root");
	Element CompanyCode = root.addElement("CompanyCode");
	Element dataType = root.addElement("dataType");
	Element data = root.addElement("data");
	Element table = data.addElement("table");
	Element rows = table.addElement("rows");
	Element row = null;
	String name;
	String path;
	String RSDocIdSQL = "select * from  (select companycode,ID,areaCode,policyNo,channel,underDate,polRecieptDate,hesitateEndDate,returnVisitDate,returnVisitType,isReturnVisit from T_PRP_LCReviewSuccessRate  WHERE makedate=to_date('"
				+ makerdate
				+ "','yyyy-mm-dd')) where to_number(substr(id,11,21)) between "
			+ begin + "  and " + end + "";// TODO
	SqlAdapter sqlAdapter4 = new SqlAdapter();
	sqlAdapter4.setSql(RSDocIdSQL);
	List<Map> srs4 = sqlAdapterMapper.excuteQuery(sqlAdapter4);
	CompanyCode.addText("000031");// 法人机构代码
	dataType.addText("HFSX");// 请求类型
	for (int i = 1; i <= srs4.size(); i++) {
		String ID = (String)srs4.get(i-1).get("ID");
		String AREACODE = (String)srs4.get(i-1).get("AREACODE");
		String policyNo =(String)srs4.get(i-1).get("POLICYNO");
		String channel =(String)srs4.get(i-1).get("CHANNEL");
		String underDate =(String)srs4.get(i-1).get("UNDERDATE").toString();
		String polRecieptDate = (String)srs4.get(i-1).get("POLRECIEPTDATE").toString();
		String hesitateEndDate =(String)srs4.get(i-1).get("HESITATEENDDATE").toString();
		String returnVisitDate = (String)srs4.get(i-1).get("RETURNVISITDATE").toString();
		String returnVisitType = (String)srs4.get(i-1).get("RETURNVISITTYPE");
		String isReturnVisit =(String)srs4.get(i-1).get("ISRETURNVISIT");
		row = rows.addElement("row");
		row.addElement("id").addText(ID);// 流水号 10位长度
		row.addElement("areaCode").addText(AREACODE);// 时间戳（yyyymmddhhmmss）
		row.addElement("policyNo").addText(policyNo);// 上报数据类型
		row.addElement("channel").addText(channel);
		row.addElement("underDate").addText(underDate);
		row.addElement("polRecieptDate").addText(polRecieptDate);
		row.addElement("hesitateEndDate").addText(hesitateEndDate);
		row.addElement("returnVisitDate").addText(returnVisitDate);
		row.addElement("returnVisitType").addText(returnVisitType);
		row.addElement("isReturnVisit").addText(isReturnVisit);
	}
	paths = relapaths + "/" + "HFSX" + end;
	makeDir(paths);
	end=end.substring(0, 1);
	path = paths + "/" + "HFSX"+"_"+end + ".xml";

	Writer out = new FileWriter(path);
	OutputFormat format = OutputFormat.createPrettyPrint();
	format.setTrimText(false);
	format.setEncoding("GB2312");
	XMLWriter writer = new XMLWriter(out,format);
    writer.write(tDoc);
    writer.close();
 
		name = "HFSX"+"_"+end;
		System.out.println(paths);
		
	
	return addFolder2Zip(path, name);
}

public boolean buildHead4(String begin, String end, String makerdate) throws Exception {
	Document tDoc = DocumentHelper.createDocument();
	tDoc.clearContent();
	Element root = tDoc.addElement("root");
	Element CompanyCode = root.addElement("CompanyCode");
	Element dataType = root.addElement("dataType");
	Element data = root.addElement("data");
	Element table = data.addElement("table");
	Element rows = table.addElement("rows");
	Element row = null;
	String name;
	String path;
	String CCDocIdSQL = "select * from (select companyCode,'LPSX' AS dataType,id,areaCode,claimNo,reportDate,appClaimDate,endCaseDate,endCaseType from T_PRP_LCClaimGetRate  WHERE makedate=to_date('"
				+ makerdate
				+ "','yyyy-mm-dd'))  where  to_number(substr(id, 11, 21)) between "
			+ begin
			+ "  and " + end + "";// TODO
	
	SqlAdapter sqlAdapter5 = new SqlAdapter();
	sqlAdapter5.setSql(CCDocIdSQL);
	List<Map> srs5 = sqlAdapterMapper.excuteQuery(sqlAdapter5);
	CompanyCode.addText("000031");// 法人机构代码
	dataType.addText("LPSX");// 请求类型
	for (int i = 1; i <= srs5.size(); i++) {
		String ID =(String)srs5.get(i-1).get("ID");
		String AREACODE =(String)srs5.get(i-1).get("AREACODE");
		String claimNo = (String)srs5.get(i-1).get("CLAIMNO");
		String reportDate =(String)srs5.get(i-1).get("REPORTDATE").toString();
		String appClaimDate = (String)srs5.get(i-1).get("APPCLAIMDATE").toString();
		String endCaseDate =(String)srs5.get(i-1).get("ENDCASEDATE").toString();
		String endCaseType =(String)srs5.get(i-1).get("ENDCASETYPE");
		row = rows.addElement("row");
		row.addElement("id").addText(ID);// 流水号 10位长度
		row.addElement("areaCode").addText(AREACODE);// 时间戳（yyyymmddhhmmss）
		row.addElement("claimNo").addText(claimNo);// 上报数据类型
		row.addElement("reportDate").addText(reportDate);
		row.addElement("appClaimDate").addText(appClaimDate);
		row.addElement("endCaseDate").addText(endCaseDate);
		row.addElement("endCaseType").addText(endCaseType);
		
	}
	paths = relapaths + "/" + "LPSX" + end;
	makeDir(paths);
	end=end.substring(0, 1);
	path = paths + "/" +"LPSX"+"_"+end + ".xml";

	Writer out = new FileWriter(path);
	OutputFormat format = OutputFormat.createPrettyPrint();
	format.setTrimText(false);
	format.setEncoding("GB2312");
	XMLWriter writer = new XMLWriter(out,format);
    writer.write(tDoc);
    writer.close();

		name = "LPSX"+"_"+end;
		System.out.println(paths);
	
	return addFolder2Zip(path, name);
}

public boolean buildHead5(String begin, String end, String makerdate) throws Exception {
	Document tDoc = DocumentHelper.createDocument();
	tDoc.clearContent();
	Element root = tDoc.addElement("root");
	Element CompanyCode = root.addElement("CompanyCode");
	Element dataType = root.addElement("dataType");
	Element data = root.addElement("data");
	Element table = data.addElement("table");
	Element rows = table.addElement("rows");
	Element row = null;
	String name;
	String path;
	String PSDocIdSQL = "select * from (select companyCode,'BQSX' as dataType,id,areaCode,appPolNo,appPolType,appPolDate,isUnder,underDate from T_PRP_LCPreservationPeriod WHERE makedate=to_date('"
				+ makerdate
				+ "','yyyy-mm-dd')) where  to_number(substr(id, 11, 21)) between "
			+ begin + "  and " + end + "";// TODO
	
	SqlAdapter sqlAdapter6 = new SqlAdapter();
	sqlAdapter6.setSql(PSDocIdSQL);
	List<Map> srs6 = sqlAdapterMapper.excuteQuery(sqlAdapter6);
	CompanyCode.addText("000031");// 法人机构代码
	dataType.addText("BQSX");// 请求类型
	for (int i = 1; i <= srs6.size(); i++) {
		String ID = (String)srs6.get(i-1).get("ID");
		String AREACODE = (String)srs6.get(i-1).get("AREACODE");
		String appPolNo = (String)srs6.get(i-1).get("APPPOLNO");
		String appPolType =(String)srs6.get(i-1).get("APPPOLTYPE");
		String appPolDate =(String)srs6.get(i-1).get("APPPOLDATE").toString();
		String isUnder = (String)srs6.get(i-1).get("ISUNDER").toString();
		String underDate = (String)srs6.get(i-1).get("UNDERDATE").toString();
		row = rows.addElement("row");
		row.addElement("id").addText(ID);// 流水号 10位长度
		row.addElement("areaCode").addText(AREACODE);// 时间戳（yyyymmddhhmmss）
		row.addElement("appPolNo").addText(appPolNo);// 上报数据类型
		row.addElement("appPolType").addText(appPolType);
		row.addElement("appClaimDate").addText(appPolDate);
		row.addElement("endCaseDate").addText(isUnder);
		row.addElement("endCaseType").addText(underDate);
	}
	paths = relapaths + "/" + "BQSX" + end;
	makeDir(paths);

	end=end.substring(0, 1);
	path = paths + "/" + "BQSX"+"_"+end + ".xml";

	Writer out = new FileWriter(path);
	OutputFormat format = OutputFormat.createPrettyPrint();
	format.setTrimText(false);
	XMLWriter writer = new XMLWriter(out,format);
    writer.write(tDoc);
    writer.close();
  
		name = "BQSX"+"_"+end;
		System.out.println(paths);
		
	
	return addFolder2Zip(path, name);
}

public boolean addFolder2Zip(String localPath, String name) {
	String zipPath = xmlpath;
	String zipName = name;
	;
	File file = null;
	try {
		zipName = zipName + ".zip";
		if (zipName.contains("/")) {
			System.out.println("ZIPNAME CONTENT '/' AND REPLACE IT ");
			zipName = zipName.replace("/", "");
		}
		/**
	 * 
	 */
		File zipfileroot = new File(zipPath);
		zipfileroot.setWritable(true, true);
		ZipFile zipfile =local2ZipFile(localPath + "/",
				zipPath, zipName);
		file = zipfile.getFile();
	} catch (Exception e) {
		System.out.println("addFolder2Zip压缩失败");
		return false;
	}
	return true;
}
public static ZipFile local2ZipFile(String localfile, String zipPath,String zipName) {
	ZipFile zipFile;
	try {
		zipFile = newZipFile(zipPath, zipName);
		ZipParameters parameters = new ZipParameters();
		parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
		parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
		zipFile.addFile(new File(localfile), parameters);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
	System.out.println("NEW　ZIP DONE : "+zipPath+zipName);
	return zipFile;
}

@SuppressWarnings({ "unchecked", "unused" })
public boolean CreatXml(String tAppPath) {
	if (!tAppPath.endsWith("/")) {
		tAppPath = tAppPath + "/";
	}
	String FILENO =sequenceService.getMaxNo("SEQ_T_PRP_LDUSERFILE", Integer.parseInt("5"));
	relapaths = tAppPath + "data/Temp/Xmlfile/"+ FILENO;;
	xmlpath = tAppPath + "/data/Temp/Zipfile/" + FILENO;
	System.out.println(relapaths);
	
		Xmlresule = Xmldatype();
	
	if (Xmlresule) {
		File file = new File(xmlpath);
		File[] f = file.listFiles();
		for (int i = 0; i < f.length; i++) {
			String filename = f[i].getName();
			String path = f[i].getPath();
			path = path.replace("\\", "/");
			System.out.println(FILENO + " " + filename + " " + path + " ");
			TPrpLduserfile LDUSERFILESchema = new TPrpLduserfile();
			String ID =sequenceService.getMaxNo("SEQ_T_PRP_LDUSERFILE2",5);
			LDUSERFILESchema.setId(ID);
			LDUSERFILESchema.setFilename(filename);
			LDUSERFILESchema.setFilepath(path);
			LDUSERFILESchema.setFiletype("已生成");
		    String date = DateUtils.getCurrentDate();
			LDUSERFILESchema.setMakedate(DateUtils.getDate(date));
			LDUSERFILESchema.setModifydate(DateUtils.getDate(date));
			LDUSERFILESchema.setMaketime(PubFun.getCurrentTime());
			
			LDUSERFILESchema.setModifytime(PubFun.getCurrentTime());
			LDUSERFILESchema.setOperator(FILENO);

			tPrpLduserfileMapper.insert(LDUSERFILESchema);
		}

	}
	

	return Xmlresule;
}


public boolean AutoUpXml(String path,String id) {
	
	boolean rs=UploadFileAction(path, "");	
	if(rs){
		String sq="update T_PRP_lduserfile set filetype='已上传'  where id='"+id+"'";
		SqlAdapter sqa = new SqlAdapter(); 
		sqa.setSql(sq);
		sqlAdapterMapper.excuteUpdate(sqa);
	}
	
	return rs;	
}
public boolean UploadFileAction(String path, String directory) {
	String uploadService = "UPLOADXml_FTPServer";
	USFTPClient client = new USFTPClient(uploadService, "U");
	
	ChannelSftp cSftp = null;
	try {
		if (client.login()) {
			cSftp = client.getSftpClient();
		}
		if (cSftp == null) {
			return false;
		}
		directory = client.getBasedir();
		System.out.println("BASE_DIR: " + directory);
		System.out.println("指定上载的文件：" + path);
		client.upload(directory, path, cSftp);
		client.disConnect();
	} catch (Exception e) {
		return false;
	}
	return true;
}
@SuppressWarnings("unchecked")
@Override
public Map<String, Object> queryDownloadFile(DataGridModel model,ParamPOJO pojo) {
	Map<String,Object> result=new HashMap<String,Object>();
	Map map=new HashMap();
	map.put("startDate", pojo.getStartDate());
	map.put("endDate", pojo.getEndDate());
	map.put("fileType", pojo.getFileType());
	
	map.put("queryStartIndex", model.getStartIndex());
	map.put("queryEndIndex", model.getEndIndex());
	
	int total=tDocUpdownMapper.countList(map);
	List<Map> list=tDocUpdownMapper.queryFileList(map);
	
	result.put("total", total);
	result.put("rows", list);
	return result;
}
}
