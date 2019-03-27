package com.test;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.platform.core.application.CodeMappingService;
import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.DataSourceService;
import com.sinosoft.platform.core.application.FileService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefCodeMappingMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefCodeMapping;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefRole;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.spring.BeanFactory;
import com.sinosoft.platform.core.spring.DBContextHolder;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.EmailSender;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.CreateFileService;
import com.sinosoft.ummp.application.DealReturnFileService;
import com.sinosoft.ummp.application.ExtractService;
import com.sinosoft.ummp.application.MonitorDeployService;
import com.sinosoft.ummp.application.MsgConfigService;
import com.sinosoft.ummp.application.QueryFileService;
import com.sinosoft.ummp.application.TDefBatchService;
import com.sinosoft.ummp.domain.mapper.BussModelImplMapper;
import com.sinosoft.ummp.application.EmailSinoService;

public class MyTest extends BaseTest {
	
	@Autowired
	CodeQueryService codeQueryService;
	@Autowired
	SequenceService sequenceService;
	@Autowired
	UserService userService;
	@Autowired
	CodeMappingService codeMappingService;
	@Autowired
	TDefCodeMappingMapper tDefCodeMappingMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	BussModelImplMapper bussModelImplMapper;
	
	@Autowired
	TDefBatchService tDefBatchService;
	@Autowired
	MonitorDeployService monitorDeployServiece;
	@Autowired
	FileService fileService;
	
	@Autowired
	MsgConfigService msgConfigService;
	
	@Autowired
	ExtractService extractService;
	
	@Autowired
	CreateFileService createFileService;
	
	@Autowired
	DataSourceService dataSourceService;
	
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	
	@Autowired
	DealReturnFileService dealReturnFileService;
	
	@Autowired
	QueryFileService queryFileService;
	
	@Autowired
	EmailSinoService emailSinoService;
	
	/**
	 * 文件查询同步下载测试
	 */
	@Test
	public void testQueryFileService(){
		LoginInfo loginInfo = new LoginInfo();
		ParamPOJO pojo = new ParamPOJO();
		loginInfo.setUserCode("1");
		pojo.setStartDate("2015-10-01");
		pojo.setEndDate("2016-10-01");
		pojo.setFileType("D");
		queryFileService.fileDownload(loginInfo, pojo);
	}
	
	/**
	 * 创建压缩文件功能测试
	 * @throws Exception
	 */
	@Test
	public void testCreatFileService(){
		LoginInfo login = new LoginInfo();
		ParamPOJO pojo= new ParamPOJO();
		pojo.setInsureType("L");//L 寿险  P 财险
		pojo.setStartDate("2016-09-14");
		pojo.setEndDate("2016-09-14");
		pojo.setDataType("H");//数据类型 I=增量 H = 存量
		pojo.setBatchType("HIS");//批次类型 HIS=存量数据；INC=增量数据；FAI=重新上报的错误数据；DET=对账明细数据
		pojo.setBussType("02");//业务类型
		pojo.setBussFlag("1");//业务状态
		pojo.setComId(new BigDecimal(1));
		
		login.setUserName("003");
		login.setCompanyId(new BigDecimal(86));
		try {
			createFileService.submitData(login, pojo);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 数据处理
	 */
	@Test
	public void testDealFileService(){
		ParamPOJO Pojo= new ParamPOJO();
		Pojo.setUserCode("0001");//测试随便给的
		dealReturnFileService.submitData(Pojo);
	}
	
	
	/**
	 * 提数批处理测试
	 * @throws Exception
	 */
	@Test
	public void testExtractBatch() throws Exception{
		extractService.extract(new ParamPOJO(),new BigDecimal("1"));
	}
	
	@Test
	public void codeTypeQuery() {
		String codetype = "EMPOWER_TYPE";
		List<TDefCodeDict> ldcodes = codeQueryService.queryCode(codetype);
		for (TDefCodeDict code : ldcodes) {
			System.out.println(code.getCodeType() + " " + code.getCode() + " "
					+ code.getCodeName());
		}
	}

	@Test
	public void platComQuery() {
		String userCode = "001";
		LoginInfo login = new LoginInfo();
		login.setUserCode(userCode);
		List<TDefPlatCom> coms = userService.getPlatComByLoginInfo(login);
		for (TDefPlatCom com : coms) {
			System.out.println(com.getComCode() + " " + com.getComName() + " "
					+ com.getComNameShort());
		}
	}

	@Test
	public void sequenceTest() {
		String seq = sequenceService.getSeqValByName("SEQ_T_DEF_USER");
		System.out.println(seq);
	}

	@Test
	public void codeMappintTest() {
		String codeType = "sex";
		DataGridModel model = new DataGridModel();
		model.setOrder("code_type");
		model.setPage(1);
		model.setRows(10);
		model.setSort("desc");
		TDefCodeMapping codeMapping = new TDefCodeMapping();
		codeMapping.setCodeType(codeType);
		codeMapping.setComId(new BigDecimal(1));
		codeMappingService.queryCodeMapping(model, codeMapping);
	}

	@Test
	public void codeMappingTest1() {
		int total = tDefCodeMappingMapper.countByExample(null);
		System.out.println(total);
	}

	@SuppressWarnings("rawtypes")
	@Test
	public void testSqlAdatpter0() {
		String sql_ump = "SELECT * FROM t_def_code_dict WHERE code_type = 'SEND_TYPE'";
		String sql_ods = "SELECT * FROM ODS_STG.OFE_T_POLICY P WHERE policy_no = 'GD000042233'";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql_ods);
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ODS);
		List<Map> result = sqlAdapterMapper.excuteQuery(sqlAdapter);
		System.out.println(result);
		
		sqlAdapter.setSql(sql_ods);
		List<Map> result1 = sqlAdapterMapper.excuteQuery(sqlAdapter);
		System.out.println(result1);
		//涓嶈 + DBContextHolder.clearDBType() 鎭㈠涓洪粯璁ゅ彲浠ュ惁
		DBContextHolder.clearDBType();
		sqlAdapter.setSql(sql_ump);
		List<Map> result2 = sqlAdapterMapper.excuteQuery(sqlAdapter);
		System.out.println(result2);
		
		sqlAdapter.setSql(sql_ump);
		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_UMP);
		List<Map> result3 = sqlAdapterMapper.excuteQuery(sqlAdapter);
		System.out.println(result3);
		
		//鎹㈠簱鍚庝笉澹版槑鐩存帴鎵ц鍏朵粬搴�
		sqlAdapter.setSql(sql_ods);
//		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ODS);
		List<Map> result4 = sqlAdapterMapper.excuteQuery(sqlAdapter);
		System.out.println(result4);
		
		//涓嶅０鏄庣洿鎺ユ墽琛岋紝鏄惁娌跨敤涓婁竴娆＄殑
		sqlAdapter.setSql(sql_ump);
//		DBContextHolder.setDBType(DBContextHolder.DATA_SOURCE_ODS);
		List<Map> result5 = sqlAdapterMapper.excuteQuery(sqlAdapter);
		System.out.println(result5);
	}
	@Test
	public void testSequenceSerialNo(){
		String serialNo = sequenceService.getSerialNo(10);
		System.out.println("SerialNo: "+serialNo);
	}
	@Test
	public void testRoles(){
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserCode("001");
		List<TDefRole> roles = codeQueryService.listRoles(loginInfo);
		System.out.println(roles);
	}
	
	@Test
	public void testBussModelImpl(){
		System.out.println(bussModelImplMapper.selectBybussId(new BigDecimal(10013)));
	}
	@Test
	public void testZip() throws CoreException{
		String name="D:\\PIZ\\hello\\World.xls";
		monitorDeployServiece.createZip("is", name);
	}
	@Test
	public void testFileZip(){
		List<File> files=new ArrayList<File>();
		files.add(new File("TestWill.xls"));
		fileService.fileToZip(files, "D:\\PIZ\\hello\\", "haha");
	}
	@Test
	public void testBatchNo(){
		for(int i = 0; i<100;i++){
			String batchNo = tDefBatchService.getBatchNo("BATCHNO");
			System.out.println("BATCHNO : "+batchNo);
		}
		for(int i = 0; i<100;i++){
			String batchNo = tDefBatchService.getBatchNo("BATCHNO","2016-07-08");
			System.out.println("BATCHNO : "+batchNo);
		}
		for(int i = 0; i<100;i++){
			String batchNo = tDefBatchService.getTransNo("2016-07-08","000031");
			System.out.println("BATCHNO : "+batchNo);
		}
		for(int i = 0; i<100;i++){
			String batchNo = tDefBatchService.getBatchNo("L","INC","000031");
			System.out.println("BATCHNO : "+batchNo);
		}
	}
	@Test
	public void testQueryResult(){
		SqlAdapter adapter=new SqlAdapter();
		String sql="select count(*) a from t_def_user_trace";
		adapter.setSql(sql);
		BigDecimal a=sqlAdapterMapper.excuteQueryCount(adapter);
		System.out.println("用户访问记录总数为："+a);
	}
	@Test
	public void testMsgConfig(){
		try{
			String ids = "10375";
			String xformat = "XML";
			String xdesc = "这里是报文描述";
			String xtitle = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			String isTitle = "1";
			System.out.println("ids: "+ids
					+"\nxformat: "+xformat
					+"\nxdesc: "+xdesc
					+"\nxtitle: "+xtitle
					+"\nisTitle: "+isTitle);
			String msg = msgConfigService.getScanMsg(ids, xformat, xtitle, isTitle);
			System.out.println(msg);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void testBeanFactory(){
		System.out.println(BeanFactory.getApplicationContext());
		System.out.println(BeanFactory.getApplicationContext().getBean("sequenceService"));
	}
	@Test
	public void testSequence(){
		for(int i= 0; i<5;i++){
			String no = sequenceService.getSeqValByName("SEQ_BATCHNO1");
			System.out.println("1:"+no);
			showSequence(no,i);
		}
	}
	private void showSequence(String no,int i){
		if( i%2 == 0){
			String not = sequenceService.getSeqValByName("SEQ_BATCHNO2",10);
			System.out.println("2:"+not);
		}else{
			String not = sequenceService.getSeqValByName("SEQ_BATCHNO");
			showSequence(not,i+1);
		}
	}
	@Test
	public void testDataSource(){
		Connection conn = dataSourceService.getConnection("dataSourceODS");
		System.out.println(conn);
		if(conn != null){
			dataSourceService.close(conn);
		}
		Connection conn1 = dataSourceService.getConnection();
		System.out.println(conn1);
		if(conn1 != null){
			dataSourceService.close(conn1);
		}
	}
	@Test
	public void testSqlMapper(){
		BigDecimal sqlId = new BigDecimal("10054");
		String sql = tDefSqlMapper.getSqlById(sqlId);
		System.out.println(sql);
		TDefSql t = tDefSqlMapper.selectByPrimaryKey(new BigDecimal("10056"));
		System.out.println(t);
	}
	@Test
	public void testSysPath(){
		
		String path = codeQueryService.getSysPath("DATA_PATH");
		System.out.println(path);
	}
	@Test
	public void testEmail(){
		try {
			String[] sendTo = { "wangpingsh@sinosoft.com.cn","PSP_WANGPING@icbc-axa.com" };
			String[] sendCc = { "872694792@qq.com", "54wping@gmail.com" };
//			String[] sendCc = { "872694792@qq.com"};
			String[] sendBcc = { "744582821@qq.com"};
//			EmailSender sender = EmailSender.getInstance();
//			EmailSender sender = EmailSender.getInstance("service.sina.properties");
			EmailSender sender = EmailSender.getInstance("service.163.properties");
			File[] attachments = new File[2];
			attachments[0] = new File("D:\\sx-ciim\\myemail.zip");
			sender.setSendTo(sendTo);
			sender.setSendCc(sendCc);
			sender.setSendBcc(sendBcc);
			sender.setAttachments(attachments);
			sender.setTitle("【WPING 自动提醒】");
			sender.setContent("这里是自动提醒邮件,附件是自动发送邮件相关代码.\n请勿查收勿回复！");
			sender.send();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	@Test
	public void testMAP(){
		String sql = "SELECT chgid,"
       +"'000031' || to_char(SYSDATE, 'yyyymmdd') ||"
       +"lpad(('0' + rownum), '10', '0') AS transno,"
       +"BUSSNO,"
       +"busstype,"
       +"to_char(SYSDATE, 'yyyymmdd') AS dateserial,"
      +" '000000' AS companycode"   
  +"FROM ("
        +"SELECT TO_CHAR(PC.POLICY_CHG_ID) AS CHGID,"
                +"TO_CHAR(P.POLICY_NO) AS BUSSNO,"
                +"'OFE' AS BUSSTYPE,"
                +"Effective_Date AS transdate"
          +"FROM ODS_STG.OFE_T_POLICY_CHANGE PC,"
                +"ODS_STG.OFE_T_POLICY        P,"
                +"ODS_STG.OFE_T_POL_PLAN      PP,"
               +" ODS_STG.OFE_T_PD_PRODUCT    PD"
        +" WHERE PC.RC_STATE = 'E'"
           +"AND PP.RC_STATE = 'E'"
           +"AND PD.RC_STATE = 'E'"
           +"AND PP.POLICY_ID = P.POLICY_ID"
           +"AND PP.POLICY_ID = PC.POLICY_ID"
           +"AND PC.POLICY_ID = P.POLICY_ID"
           +"AND PD.PD_PRODUCT_ID = PP.PD_PRODUCT_ID"
           +"AND PD.BASIC_PRODUCT_FLAG = 'B'"
           +"AND PD.COVERAGE_TERM_TYPE <> 'M'"
           +"AND P.POLICY_ID > 0"
           +"AND PC.POLICY_ID > 0"
           +"AND NOT EXISTS (SELECT 1"
                  +"FROM ODS_STG.OFE_T_RLS_POLICY A"
                +" WHERE TO_CHAR(A.PNO) = TO_CHAR(P.POLICY_NO)"
                   +"AND A.FLAG = '1')"
           +"AND PC.Effective_Date between"
               +"to_date('2016-09-01', 'yyyy-mm-dd') and"
               +"to_date('2016-09-01', 'yyyy-mm-dd')"
        +"UNION"
        +"SELECT TO_CHAR(SYSDATE, 'yyyymmdd') || TO_CHAR(PC.CREF) AS chgid,"
               +"TO_CHAR(PC.PNO) AS bussno,"
               +"'RLS' AS busstype,"
               +"TO_DATE(PC.CDOT, 'yyyy-mm-dd') AS transdate"
          +"FROM ODS_STG.RLS_LFPCHG PC"
         +"WHERE PC.CTSTU = '09'"
           +"AND PC.CTC <> 'A'       "
           +"AND TO_DATE(PC.CDOT, 'yyyy-mm-dd') BETWEEN"
               +"TO_DATE('2016-09-01', 'yyyy-mm-dd') AND"
               +"TO_DATE('2016-09-01', 'yyyy-mm-dd')) mp"
 +"where 1 = 1"
   +"AND mp.transdate between to_date('2016-09-01', 'yyyy-mm-dd') and"
       +"to_date('2016-09-01', 'yyyy-mm-dd')";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> list = sqlAdapterMapper.excuteQuery(sqlAdapter);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
