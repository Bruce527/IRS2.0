package com.sinosoft.pdl.constants;

public class AccConstants {
	/** 数据库配置 参考20120504
	 *  BJJK-C01	理赔信息同步上传
		BJJK-C02	理赔信息异步上传
		BJJK-C03	获取理赔信息异步上传结果
		BJJK-C04	理赔任务后台执行
		BJJK-C05	理赔案件撤销同步接口
		BJJK-C06	理赔案件撤销异步接口
		BJJK-C07	获取理赔案件撤销异步上传结果
		
		BJJK-C08	理赔二次核保同步上传接口
		BJJK-C09	理赔二次核保异步上传接口
		BJJK-C10	获取理赔二次核保异步上传结果
		
		BJJK-E01	保全信息同步上传
		BJJK-E02	保全信息异步上传
		BJJK-E03	获取保全信息异步上传结果
		BJJK-E04	保全任务后台执行
		
		BJJK-E05	个单全量同步上传
		BJJK-E06	个单全量异步上传
		BJJK-E07	获取个单全量异步上传结果
		
		BJJK-E08	保全批单同步撤销接口
		BJJK-E09	保全批单异步撤销接口
		BJJK-E10	获取保全批单撤销异步上传结果
		
		BJJK-E11	续期缴费同步上传接口
		BJJK-E12	续期缴费异步上传接口
		BJJK-E13	获取续期缴费异步上传结果
		
		BJJK-E14	保单状态修改同步上传
		BJJK-E15	保单状态修改异步上传
		BJJK-E16	获取保单状态修改异步上传结果
		
		BJJK-E17	团险续期缴费同步上传接口
		BJJK-E18	团险续期缴费异步上传接口
		BJJK-E19	团险续期缴费异步查询接口
		
		
		BJJK-N01	承保信息同步上传
		BJJK-N02	承保信息异步上传
		BJJK-N03	获取承保信息异步上传结果
		BJJK-N04	承保任务后台执行
	 */
	
	/** 承保同步*/
	public static final String DPC_SYN_POLICY= "BJJK-N01";
	/** 承保异步*/
	public static final String DPC_ASYN_POLICY = "BJJK-N02";
	/** 承保异步查询*/
	public static final String DPC_ASYN_POLICY_QUERY = "BJJK-N03";
	/** 承保保单变更*/
	public static final String DPC_UPDATE_POLICY_STATUS = "BJJK-N04";
	
	
	/** 保全同步*/
	public static final String DPP_SYN_ENDORSEMENT = "BJJK-E01";
	/** 保全异步*/
	public static final String DPP_ASYN_ENDORSEMENT = "BJJK-E02";
	/** 保全异步查询*/
	public static final String DPP_ASYN_ENDORSEMENT_QUERY = "BJJK-E03";
	
	/** 个单全量同步上传*/
	public static final String DPP_SYN_SP_ENDORSEMENT = "BJJK-E05";
	/** 个单全量异步上传*/
	public static final String DPP_ASYN_SP_ENDORSEMENT = "BJJK-E06";
	/** 获取个单全量异步上传结果*/
	public static final String DPP_ASYN_SP_ENDORSEMENT_QUERY = "BJJK-E07";
	
	/** 保全批单同步撤销*/
	public static final String DPP_SYN_CANEL_ENDORSEMENT = "BJJK-E08";
	/** 保全批单异步撤销*/
	public static final String DPP_ASYN_CANEL_ENDORSEMENT = "BJJK-E09";
	/** 获取保全批单撤销异步上传结果*/
	public static final String DPP_ASYN_CANEL_ENDORSEMENT_QUERY = "BJJK-E10";
	
	/**续期缴费同步上传接口*/
	public static final String DPP_SYN_PAY = "BJJK-E11";
	/**续期缴费异步上传接口*/
	public static final String DPP_ASYN_PAY = "BJJK-E12";
	/**获取续期缴费异步上传结果*/
	public static final String DPP_ASYN_PAY_QUERY = "BJJK-E13";
	
	/**保单状态修改同步上传*/
	public static final String DPP_SYN_MODIFYSTATUS = "BJJK-E14";
	/**保单状态修改异步上传*/
	public static final String DPP_ASYN_MODIFYSTATUS = "BJJK-E15";
	/**获取保单状态修改异步上传结果*/
	public static final String DPP_ASYN_MODIFYSTATUS_QUERY = "BJJK-E16";
	
	/**团险续期缴费同步上传*/
	public static final String DPP_SYN_GROUPPAY = "BJJK-E17";
	/**团险续期缴费异步上传*/
	public static final String DPP_ASYN_GROUPPAY  = "BJJK-E18";
	/**获取团险续期缴费异步上传结果*/
	public static final String DPP_ASYN_GROUPPAY_QUERY = "BJJK-E19";
	 
	/**理赔二次核保同步上传接口*/
	public static final String DPL_SYN_UNDER = "BJJK-C08";
	/**理赔二次核保异步上传接口*/
	public static final String DPL_ASYN_UNDER = "BJJK-C09";
	/**获取理赔二次核保异步上传结果*/
	public static final String DPL_ASYN_UNDER_QUERY = "BJJK-C10";
	
	/** 理赔同步*/ 
	public static final String DPL_SYN_CLAIM = "BJJK-C01";
	/** 理赔异步*/ 
	public static final String DPL_ASYN_CLAIM = "BJJK-C02";
	/** 理赔异步查询*/ 
	public static final String DPL_ASYN_CLAIM_QUERY = "BJJK-C03";
	/** 理赔案件撤销同步*/ 
	public static final String DPL_SYN_UPDATE_CLAIM_STATUS = "BJJK-C05";
	/** 理赔案件撤销异步*/ 
	public static final String DPL_ASYN_UPDATE_CLAIM_STATUS = "BJJK-C06";
	/** 理赔案件撤销异步查询*/ 
	public static final String DPL_ASYN_UPDATE_CLAIM_QUERY = "BJJK-C07";
	
	
	/** 报送状态-待报送*/
	public static final String SENDSTATE_TOSEND = "0";
	/** 报送状态-报送中*/
	public static final String SENDSTATE_ING = "1";
	
	/** 组装后未回写状态*/
	public static final String SEND_STATE = "0";
	/** 组装后已回写状态*/
	public static final String RETURN_STATE = "1";
	
	/** 同步上报*/
	public static final String NOT_ASYN = "0";
	/** 异步上报*/
	public static final String IS_ASYN = "1";
	
	/** 回写信息成功-部分成功-全部失败*/
	public static final String SUCCESS_DEALSTATE = "2";
	public static final String PART_DEALSTATE = "1";
	public static final String FAIL_DEALSTATE = "0";
	
	/** 成功上报状态*/
	public static final String SUCCESS_SENDSTATE = "9";
	/** 失败上报状态*/
	public static final String FAIL_SENDSTATE = "E";
	
	/** 补录表 待审核*/
	public static final String AUDIT_WAIT_STATE = "0";
	
	/** 补录表 审核通过*/
	public static final String AUDIT_PASS_STATE = "1";
	
	/** 预约码未处理*/
	public static final String NOTUSED_BOOKINGCODE = "0";
	/** 预约码处理中*/
	public static final String USED_BOOKINGCODE = "1";
	/** 预约码处理完成*/
	public static final String SUCCESS_BOOKINGCODE = "9";
	
	
	/** 用于判断是否运行后置业务挂起方法（用于HltUploadDaoImpl类）  1-运行 0-不运行 */
	public static final String YESORNO_LEADBUSINESS = "0";
	
/**	返回类型代码	返回类型 responsecode
	0	输入数据有误，无法返回正常值
	1	输入数据正确，返回正常值
	2	输入数据部分成功
	3	输入数据对象已存在
	4	任务接收正常，已经排入队列（用于获取承保信息异步上传结果）
	5	任务执行中（用于获取承保信息异步上传结果）
	E	系统未知错误
	**/
	
	/**输入数据有误，无法返回正常值*/
	public static final String RESCODE_0 = "0";
	/**输入数据正确，返回正常值*/
	public static final String RESCODE_1 = "1";
	/**输入数据部分成功*/
	public static final String RESCODE_2 = "2";
	/**输入数据对象已存在*/
	public static final String RESCODE_3 = "3";
	/**任务接收正常，已经排入队列（用于获取承保信息异步上传结果）*/
	public static final String RESCODE_4 = "4";
	/**任务执行中（用于获取承保信息异步上传结果）*/
	public static final String RESCODE_5 = "5";
	/**系统未知错误*/
	public static final String RESCODE_E = "E";
	/**个险续期缴费保全类型*/
	public static final String SINGLE_PAY = "-3";
	/**团险续期缴费保全类型*/
	public static final String GROUP_PAY = "-5";
	
	/**团单 被保险人 拆单**/
	public static final int INSURED_COUNT = 200;
	
	/**北京健康险，协会报送地址，在程序中赋值*/
	public static String  SERVLET_SITE ="http://85.49.3.7/circauto/webservice/InsuranceWebService?wsdl";
	
	/**协会报送 名称*/
	public static String  USER ="L18_user";
	
	/**协会报送 密码*/
	public static String  PASSWORD ="111111";
	
}
