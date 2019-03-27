/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.sinosoft.eos.exception.EOSException;
import com.sinosoft.eos.handle.Handler;
import com.sinosoft.eos.handle.SubmitHandler;
import com.sinosoft.eos.model.BussModel;
import com.sinosoft.eos.model.RequestModel;
import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.application.SqlParamService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefPlatComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlExample;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.XMLLogUtil;
import com.sinosoft.ummp.application.ActionService;
import com.sinosoft.ummp.application.MsgClassInterfaces;
import com.sinosoft.ummp.application.MsgDTOService;
import com.sinosoft.ummp.application.MsgNodeService;
import com.sinosoft.ummp.application.SubmitReturnService;
import com.sinosoft.ummp.application.SubmitService;
import com.sinosoft.ummp.domain.mapper.BussModelImplMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.mapper.TDefBussModelMapper;
import com.sinosoft.ummp.domain.mapper.TDefSendMapper;
import com.sinosoft.ummp.domain.mapper.TDocMainMapper;
import com.sinosoft.ummp.domain.model.BussModelImpl;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefBussModel;
import com.sinosoft.ummp.domain.model.TDefBussModelExample;
import com.sinosoft.ummp.domain.model.TDefSend;
import com.sinosoft.ummp.exception.CISException;
import com.sinosoft.ummp.util.BeanUtil;
import com.sinosoft.ummp.util.UMMPContext;

/**
 * 报送服务接口实现<br>
 * 1、List<TDefBussModel> 调用 getBussModeByCom(BigDecimal comId) 获取到需要报送的业务信息<br>
 * 2、submitBussModel(List<TDefBussModel> bms,ParamPOJO pojo) 进行报送<br>
 * 3、开放保送接口：submit
 * @author Darker.Wang
 * @date 2016-9-7 下午12:01:47
 * @company SINOSOFT
 */
@Service(value="submitService")
public class SubmitServiceImpl implements SubmitService{

	private ApplicationContext context;
	private static Logger logger = Logger.getLogger(SubmitServiceImpl.class);
	@Autowired
	TDefBussModelMapper tDefBussModelMapper;//业务信息
	@Autowired
	BussModelImplMapper bussModelImplMapper;
	@Autowired
	TDefSendMapper tDefSendMapper;
	@Autowired
	MsgNodeService msgNodeService;//XML规则
	@Autowired
	MsgDTOService msgDTOService;//DTO规则
	@Autowired
	TDefPlatComMapper tDefPlatComMapper;
	@Autowired
	SequenceService sequenceService;
	@Autowired
	SubmitReturnService submitReturnService;
	@Autowired
	ActionService actionService;
	@Autowired
	CodeQueryService codeQueryService;
	@Autowired
	TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	
	@Autowired
	SqlParamService sqlParamService;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	TDocMainMapper tDocMainMapper;
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	MsgClassInterfaces msgClassInterfaces;//Class特殊处理规则
	
	/**
	 * 请求模型:内有保送地址，保送最大最小值等
	 */
	public RequestModel reqModel;
	
	public SubmitServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	public List<BussModelImpl> getBussModelImpl(BigDecimal bussId){
		return bussModelImplMapper.selectBybussId(bussId);
	}
	/**
	 * 一个平台支持一个报送模型
	 * @param comId
	 * @return
	 */
	public RequestModel getRequestModel(BigDecimal comId){
		List<TDefSend> sends = tDefSendMapper.selectByComId(comId);
		if(sends == null || sends.size() < 1){
			return null;
		}
		reqModel = new RequestModel();
		reqModel.setReqIP(sends.get(0).getSendIp());
		reqModel.setReqPort(sends.get(0).getSendPort());
		reqModel.setReqKey(sends.get(0).getSendEncode());
		reqModel.setReqUrl(sends.get(0).getSendApi());
		reqModel.setReqUser(sends.get(0).getSendUser());
		reqModel.setReqPass(sends.get(0).getSendPass());
		//最大值最小值后期加入
		
		return reqModel;
	}
	/**
	 * 获取平台下的报送业务模型
	 * @param comId 平台
	 * @param pojo 当POJO的业务类型不为空，则指定业务类型，否则所有
	 * @return
	 */
	public List<TDefBussModel> getBussModeByCom(BigDecimal comId,ParamPOJO pojo) throws CoreException{
		// TODO Auto-generated method stub
		try{
			List<String> msgs = new ArrayList<String>();
			msgs.add(TDefBussModel.SUB_BUSS_TYPE_REQUEST);//请求报文
			msgs.add(TDefBussModel.SUB_BUSS_TYPE_SPECLASS);//特殊类处理
			TDefBussModelExample example = new  TDefBussModelExample();
			TDefBussModelExample.Criteria criteria = example.createCriteria();
			criteria.andComIdEqualTo(comId);
			criteria.andSubBussTypeIn(msgs);
			if(pojo.getBussType() != null && !"".equals(pojo.getBussType())){
				criteria.andBussTypeEqualTo(pojo.getBussType());
			}
			criteria.andRcStatusEqualTo(Short.parseShort("1"));//只锁定有效的
			this.getRequestModel(comId);
			return tDefBussModelMapper.selectByExample(example);
		}catch(Exception e){
			CoreException coreException = new CoreException();
			coreException.setMessage("批次："+pojo.getBatchNo()+" 获取报文规则异常。原因："+e.getMessage());
			throw coreException;
		}
	}

	/**
	 * 根据业务模型实现类获取到获取报送业务数据
	 * @param bmi
	 * @param pojo
	 * @return
	 * @throws CoreException 
	 */
	public SubmitModel getSubmitData(BussModelImpl bmi,ParamPOJO pojo) throws CoreException {
		// TODO 构造报送信息
		logger.debug("报送模型："+bmi.getBussName());
		String implType = bmi.getImplType();
		SubmitModel sm = new SubmitModel();
		//TODO 特殊类处理，调用处理类接口报送模型
		if(implType!= null && implType.equals("MSG_SPECLASS")){
			Object reqData = msgClassInterfaces.getSubmitData(bmi,pojo);
			sm.setEncoding(msgClassInterfaces.XMLEncoding);//报送字符集设置
			sm.setSubmitClass(msgClassInterfaces.getDataClass());//发送数据类型
			sm.setSubmitData(reqData);//报送数据
			sm.setSubmitTime(DateUtils.getCurrentTimestamp().toString());//报送日期
			sm.setReturnClass(msgClassInterfaces.getDataClass());//返回数据类型
			return sm;
		}
		Object reqData = msgNodeService.getSubmitData(bmi,pojo);
		sm.setEncoding(msgNodeService.XMLEncoding);//报送字符集设置
		sm.setSubmitClass(msgNodeService.getDataClass());//发送数据类型
		sm.setSubmitData(reqData);//报送数据
		sm.setSubmitTime(DateUtils.getCurrentTimestamp().toString());//报送日期
		sm.setReturnClass(msgNodeService.getDataClass());//返回数据类型
		return sm;
	}
	
	/**
	 * 根据业务模型，获取到提交方式
	 * @param bm 业务模型 
	 * @return
	 */
	private String getSubmitType(BussModel bm){
		if(bm == null){
			return null;
		}
		//提交方式
		logger.debug("BussModel.SUB_BUSS_TYPE_X : "+bm.getSubBussType());
		//北京以外险 DTO 提交
		if(bm.getSubBussType().equals(BussModel.SUB_PLAT_BJAI)){
			return SubmitModel.SUBMIT_TYPE_DTO;
		}
		//北京健康险 DTO 提交
		else if(bm.getSubBussType().equals(BussModel.SUB_PLAT_BJHI)){
			return SubmitModel.SUBMIT_TYPE_DTO;
		}
		//保单登记平台 指定Client 进行提交
		else if(bm.getSubBussType().equals(BussModel.SUB_PLAT_PRP)){
			return SubmitModel.SUBMIT_TYPE_WSDL;
		}
		else{
			//其他则为字符串
			return SubmitModel.SUBMIT_TYPE_STRING;
		}
	}
	
	/**
	 * 平台业务报送，传入报送业务模型和报送所需参数，同时负责封装BussModel
	 * 调此方法之前，可getBussModeByCom 方法获取到报送业务模型，传入即可
	 * @param bms 报送模型
	 * @param pojo 报送参数
	 * @return
	 * @throws CISException 
	 */
	@SuppressWarnings("unchecked")
	public Map<String,String> submitBussModel(List<TDefBussModel> bms,ParamPOJO pojo){
		
		Map<String,String> map = new HashMap<String,String>();
		StringBuffer sb = new StringBuffer();
		List<SubmitReturn> submitReturns = null;
		if(bms == null || bms.size() == 0){
			map.put("msg", "当前批次："+pojo.getBatchNo()+" 无待报送业务信息");
			return map;
		}
		try {
			List<SubmitModel> sms = new ArrayList<SubmitModel>();
			String batchNo = pojo.getBatchNo();
			String bussNo = pojo.getBussNo();
			BussModel sbm = new BussModel();
			sbm.setBatchNo(batchNo);
			sbm.setBussNo(bussNo);
			sbm.setBussDate(pojo.getStartDate());//起始日期作为业务日期
			//TODO 此处是否需要加入报送履历等信息？
			for(TDefBussModel bm : bms){
				sbm.setBussCode(bm.getBussCode());
				sbm.setBussName(bm.getBussName());
				sbm.setComId(bm.getComId());
				sbm.setBussType(bm.getBussType());
				sbm.setSubBussType(getSubBussModel(bm.getComId()));//定义为报送平台
				List<BussModelImpl> bmis = getBussModelImpl(bm.getBussId());
				for(BussModelImpl impl : bmis){
					SubmitModel sm = getSubmitData(impl,pojo);
					if(sm.getSubmitData() == null || "".equals(sm)){
						map.put("msg", bm.getBussType()+" 报送报文为空，请确定是否有配置报文规则。");
						return map;
					}
					String actionNo = "SN-"+System.currentTimeMillis();
					sb.append(actionNo);//以逗号隔开，注意最后一个为空
					sm.setSubmitSerialNo(actionNo);
					sm.setSubmitType(getSubmitType(sbm));
					sm.setBussModel(sbm);
					sm.setReqModel(reqModel);
					sms.add(sm);
					//发送报文落地
					dealXMLLocal(sm);
				}
			}
			//TODO 报送履历
			dealActionTrace(sms,pojo);
			
			//TODO 报送调度器进行报送
			logger.debug("报送记录数： "+sms.size());
			Handler shandler = new SubmitHandler(sms);
			Handler.cErrors.clearErrors();
			boolean  result = shandler.handle();
			if(!result){
				String msg = Handler.cErrors.getFirstError();
				logger.info("批次："+pojo.getBatchNo()+" 报送失败："+msg);
				logger.debug(msg);
				map.put("msg", msg);
				return map;
			}
			map.put("msg","批次："+pojo.getBatchNo()+" 报送成功");
			submitReturns = (List<SubmitReturn>) shandler.getResult();
			//TODO 无返回处理
			if(submitReturns == null){
				logger.info("批次："+pojo.getBatchNo()+" 无返回信息");
			}
			//返回报文落地
			for(int i = 0; i < submitReturns.size();i ++){
				dealXMLLocal(submitReturns.get(i));
			}
			submitReturnService.setApplicationContext(getApplicationContext());
			Map<String,String> tmap = submitReturnService.dealSubmitReturn(sms, submitReturns,pojo);
			map.putAll(tmap);
		} catch (EOSException e) {
			String msg = "批次："+pojo.getBatchNo()+" 报送异常。<br>原因是："+e.getMessage();
			logger.error(msg);
			map.put("msg",msg);
			e.printStackTrace();
			return map;
		} catch (CoreException e) {
			String msg = "批次："+pojo.getBatchNo()+" 生成报文异常。<br>原因是："+e.getMessage();
			logger.error(msg);
			map.put("msg",msg);
			e.printStackTrace();
			return map;
		}finally{
			map.put("actionNos",sb.toString());
		}
		//无提示信息，则添加提示信息
		if(!map.containsKey("msg")){
			map.put("msg","批次："+pojo.getBatchNo()+" 报送成功");
		}
		return map;
	}
	/**
	 * 获取（构造）文件名
	 * @param sm 请求MODEL
	 * @param xmlType 1-request 2-response
	 * @return
	 */
	private String getXMLFileName(String submitSerialNo,BussModel bm,int xmlType){
		String xmlLogPath = codeQueryService.getCodeAlails("SYS_PATH", "XMLLOG_PATH");
		if(!xmlLogPath.endsWith("/")){
			xmlLogPath = xmlLogPath + "/";
		}
		String datePath  = xmlLogPath + DateUtils.getCurrentYear()+"/"+DateUtils.getCurrentMonth()+"/"+DateUtils.getCurrentDay()+"/";
		String fileName = datePath + bm.getComId()+"_"+bm.getBussType()+"_"+submitSerialNo;
		if(bm.getBatchNo() != null && !"".equals(bm.getBatchNo())){
			fileName = fileName+"_"+bm.getBatchNo();
		}
		if(bm.getBussNo() != null && !"".equals(bm.getBussNo())){
			fileName = fileName+"_"+bm.getBussNo();
		}
		if(xmlType != 1 && xmlType == 2){
			fileName = fileName+"_response";
		}
		fileName += ".xml";
		logger.debug("XMLFileName : "+fileName);
		return fileName;
	}
	/**
	 * 发送报文落地
	 * @param sm
	 * @param xmlType 1-request 2-response
	 * @return
	 */
	private boolean dealXMLLocal(SubmitModel sm){
		
		String fileName = getXMLFileName(sm.getSubmitSerialNo(),sm.getBussModel(),1);
		String xml = (String) sm.getSubmitData();
		Document xmlDoc;
		try {
			xmlDoc = DocumentHelper.parseText(xml);
			XMLLogUtil.save(fileName, xmlDoc);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 返回报文落地
	 * @param sr
	 * @return
	 */
	private boolean dealXMLLocal(SubmitReturn sr){
		String fileName = getXMLFileName(sr.getSubmitSerialNo(),sr.getBussModel(),2);
		String xml = (String) sr.getReturnObj();
		Document xmlDoc;
		try {
			xmlDoc = DocumentHelper.parseText(xml);
			XMLLogUtil.save(fileName, xmlDoc);
		} catch (DocumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * 处理报送履历
	 * @param sms
	 * @param pojo
	 * @return
	 */
	private boolean dealActionTrace(List<SubmitModel> sms,ParamPOJO pojo){
		boolean isgoon = false;
		List<TDefActionTrace> actionTraces = new ArrayList<TDefActionTrace>();
		int size = sms.size();
		if(size > 0){
			isgoon = true;
		}
		if(!isgoon){
			return true;
		}
		for(SubmitModel sm : sms){
			BussModel bm = sm.getBussModel();
			TDefActionTrace action = new TDefActionTrace();
			String actionNo = sm.getSubmitSerialNo();
			action.setId(sequenceService.getBigSeqValByName("SEQ_T_DEF_ACTION_TRACE"));
			action.setBatchNo(sm.getBussModel().getBatchNo());
			if(bm.getBussType().substring(0,4).equals("SHIA")){
				action.setBussNo(sm.getBussModel().getBussNo());
			}
			action.setStartDate(DateUtils.getDate(pojo.getStartDate()));
			action.setEndDate(DateUtils.getDate(pojo.getEndDate()));
			action.setActionDate(DateUtils.getDateTime());
			action.setActionTime(DateUtils.getCurrentTime());
			action.setActionMsg(bm.getBussName());
			action.setActionAllCount(Long.parseLong(""+size));
			action.setActionNo(actionNo);
			action.setActionType(bm.getBussType());
			action.setBatchType(bm.getSubBussType());
			action.setDataMsg(bm.getBussName());
			action.setEsStatus(Short.parseShort("1"));
			action.setInsertTime(DateUtils.getCurrentTimestamp());
			action.setLastModifyTime(DateUtils.getCurrentTimestamp());
			action.setOperator(pojo.getUserCode());
			action.setSubBussType("SB");//提数EB
			action.setPlatCom(bm.getComId());
			actionTraces.add(action);
		}
		int insertR = actionService.insertActionTrace(actionTraces);
		if(insertR < 0 ){
			return false;
		}
		return true;
	}
	/**
	 * COM_CODE 赋值给 SUB_BUSS_TYPE
	 * @param comId
	 * @return
	 */
	private String getSubBussModel(BigDecimal comId){
		TDefPlatCom com = tDefPlatComMapper.selectByPrimaryKey(comId);
		if(com != null){
			return com.getComCode();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitService#submit(java.math.BigDecimal, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public Map<String, String> submit(BigDecimal comId, ParamPOJO pojo) {
		// TODO 报送前校验
		Map<String,String> map = new HashMap<String,String>();
		System.out.println(pojo.getBussNo());
		if(comId == null){
			map.put("msg", "报送平台机构不能为空");
			return map;
		}
		if(pojo.getBussType() == null){
			map.put("msg", "报送业务类型不能为空");
			return map;
		}
		//确定业务平台ID在参数中是否存在
		if(pojo.getComId() == null ){
			pojo.setComId(comId);
		}
		List<ParamPOJO> pojos = null;
		try{
			pojos = buildSubmitParamPOJO(comId,pojo);
			if(pojos == null || pojos.size() <= 0){
				map.put("msg", "当前报送："+pojo.getBussType()+" 无待报送批次信息。");
				return map;
			}
		}catch(Exception e){
			map.put("msg", "<font style='font-weight:bold;'>该平台报送功能 "+pojo.getBussType()+" 开发中,敬请期待...</font>");
			return map;
		}
		StringBuffer sb = new StringBuffer("<lu><font style='font-weight:bold;'>当前报送</font>");
		if(pojos == null || pojos.size() <= 0){
			sb.append("业务 "+pojo.getBussType()+" 无待报送批次信息。");
		}
		int i=0;
		long s = System.currentTimeMillis();
		//上海人身险承保异步拆单特殊报送处理
		if (pojos.get(0).getTransType().startsWith("N0202")) {
			for (ParamPOJO tPojo : pojos) {

				// 拆单开始，执行对应报文生成规则
				if ("N020201".equals(tPojo.getTransType())) {
					try {
						map = submit4Common(map, tPojo, comId);
						SqlAdapter sqlAdapter = getQuerySql(tPojo);
						List<Map> traces = sqlAdapterMapper
								.excuteQuery(sqlAdapter);
						if ("1".equals(traces.get(0).get("DATA_STATUS"))) {
							tPojo.setTransType("N020202");
							tPojo.setBussType("SHIAN020202");
						} else {
							sb.append("业务 " + pojo.getBussType()
									+ " 报送拆单开始时失败。");
							map.put("msg", sb.toString());
							return map;
						}
					} catch (CoreException e) {
						e.printStackTrace();
					}
				}
				if ("N020202".equals(tPojo.getTransType())) {
					for (int t = 0; t < (Integer.valueOf(tPojo.getBagsCount())); t++) {

						try {
							int minRowCount = 1 + t
									* Integer.parseInt(tPojo.getCutCount());
							int maxRowCount = (t + 1)
									* Integer.parseInt(tPojo.getCutCount());
							maxRowCount = maxRowCount <= Integer.valueOf(tPojo
									.getInsuredCount()) ? maxRowCount : Integer
									.valueOf(tPojo.getInsuredCount());
							int currentBagCount = (t + 1);
							tPojo.setMinRowNum(Integer.toString(minRowCount));
							tPojo.setMaxRowNum(Integer.toString(maxRowCount));
							tPojo.setCurrentBagCount(Integer
									.toString(currentBagCount));
							map = submit4Common(map, tPojo, comId);
							SqlAdapter sqlAdapter = getQuerySql(tPojo);
							List<Map> traces = sqlAdapterMapper
									.excuteQuery(sqlAdapter);
							if ("1".equals(traces.get(0).get("DATA_STATUS"))) {
							} else {
								sb.append("业务 " + pojo.getBussType()
										+ " 报送拆单上传返回错误信息，报送停止， 当前业务号："
										+ tPojo.getBussNo() + "，当前包数："
										+ tPojo.getCurrentBagCount());
								map.put("msg", sb.toString());
								return map;
							}
						} catch (CoreException e) {
							e.printStackTrace();
						}
						if (t == ((Integer.valueOf(tPojo.getBagsCount())) - 1)) {
							tPojo.setTransType("N020203");
							tPojo.setBussType("SHIAN020203");
						}
					}
					if ("N020203".equals(tPojo.getTransType())) {
						try {
							map = submit4Common(map, tPojo, comId);
						} catch (CoreException e) {
							e.printStackTrace();
						}

					}
				}
				i++;
			}
		}
		//其他处理
		else{
			for(ParamPOJO tPojo : pojos){
				try {
					map=submit4Common(map, tPojo, comId);
				} catch (CoreException e) {
					e.printStackTrace();
					continue;
				}
				i++;
			}
		}
		sb.append("<li> 报送成功，共报送批次："+i+",耗时"+((System.currentTimeMillis()-s)/1000)+" S </li>");
		sb.append("</lu>");
		map.put("msg", sb.toString());
		System.out.println("- SubmitServiceImpl.submit >> 报送成功，共报送批次："+i+", 耗时"+((System.currentTimeMillis()-s)/1000)+" S");
		
		return map;
	}
	/**
	 * 
	 */
	private SqlAdapter getQuerySql(ParamPOJO tPojo){
		String sql = "SELECT * from t_def_action_trace "
				+ "WHERE buss_no='" + tPojo.getBussNo()
				+ "' AND " + "batch_no='" + tPojo.getBatchNo()
				+ "' and "
				+ "action_no=(SELECT max(action_no) "
				+ "FROM t_def_action_trace  WHERE "
				+ "buss_no='" + tPojo.getBussNo() + "') AND "
				+ "data_status IS NOT NULL";
		System.out.println(sql);
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		return sqlAdapter;
	}
	/**
	 * 通用报送处理
	 * @param map 编写页面返回信息
	 * @param pojos 报送输出参数
	 * @return
	 * @throws CoreException 
	 */
	private Map<String, String> submit4Common(Map<String, String> map,
			ParamPOJO tPojo, BigDecimal comId) throws CoreException {
			// TODO 报送业务开始
			System.out.println(tPojo);
			// 把控制sql执行出来的系统参数放到默认参数里
			Map<String, String> defaultParam = new HashMap<String, String>();
			defaultParam = BeanUtil.bean2Map(tPojo);
			sqlParamService.setDefaultParam(defaultParam);
			System.out.println(sqlParamService.getDefaultParam());
			List<TDefBussModel> bms = getBussModeByCom(comId, tPojo);
			if (bms == null || bms.size() <= 0) {
				map.put("msg", "当前报送：" + tPojo.getBussType()
						+ "<br>无可用的报文规则，请先配置。");
				return map;
			}
			Map<String, String> tMap = submitBussModel(bms, tPojo);
			String actionNo = map.get("actionNos");
			if (actionNo == null) {
				map.put("actionNos", tMap.get("actionNos"));
			} else {
				map.put("actionNos", actionNo + "@_@" + tMap.get("actionNos"));
			}
			return map;
	}
	
	
	
	/**
	 * 构建参数
	 * @param comId
	 * @param pojo
	 * @return
	 */
	private List<ParamPOJO> buildSubmitParamPOJO(BigDecimal comId, ParamPOJO pojo) throws Exception{
		System.out.println(pojo.getBussNo());
		List<ParamPOJO> rPojos = new ArrayList<ParamPOJO>();
		//放开则过滤指定批次号报送
		List<ParamPOJO> tPojos = buildParamPOJO(comId,pojo);
		if(tPojos == null || tPojos.size() <= 0){
			return null;
		}
		for(int i = 0; i< tPojos.size(); i++){
			ParamPOJO rPojo = tPojos.get(i);
			rPojo.setComId(pojo.getComId());
			rPojo.setUserCode(pojo.getUserCode());
			rPojo.setInsureType(pojo.getInsureType());
			rPojo.setRealPath(pojo.getRealPath());
			rPojo.setDataType(pojo.getDataType());
			//add for icp.prp2 2016-12-20
			rPojo.setSendType(pojo.getSendType());
			rPojo.setPthCode(pojo.getPthCode());
			rPojo.setRemark(pojo.getRemark());
			speDealPOJO(rPojo,pojo.getComId());
			rPojos.add(rPojo);
		}
		return rPojos;
	}
	/**
	 * 根据业务类型制定特殊处理POJO<br>
	 * EG: 1、用于重定向处理业务类型
	 * @param rPojo
	 * @param comId
	 * @return
	 */
	private ParamPOJO speDealPOJO(ParamPOJO rPojo, BigDecimal comId) {
		// 上海人身险特殊处理
		if (UMMPContext.SUBMIT_PLAT_SHIA == comId.intValue()) {
			int cutCount = 0;// 单次报送的被保险人数量
			int bagsCount = 0;// 拆单的包数
			List<TDefSend> tSends = tDefSendMapper.selectByComId(comId);
			if (tSends != null && tSends.size() > 0) {
				// 获取单次报送的被保险人数量
				if (tSends.get(0).getBatchCount() != null
						&& tSends.get(0).getBatchCount() > 0) {
					cutCount = tSends.get(0).getBatchCount();
				}
				//当前保单被保险人数
				int currentCount = getPolInsuredNums(rPojo.getBussNo());
				
				rPojo.setCutCount(Integer.toString(cutCount));
				bagsCount = (currentCount % cutCount == 0 ? currentCount / cutCount : currentCount / cutCount + 1);
				rPojo.setBagsCount(Integer.toString(bagsCount));
				rPojo.setInsuredCount(Integer.toString(currentCount));
			}	
		}
		return rPojo;
	}
	/**
	 * 更新制定表数据
	 * @param targetTable
	 * @param setString
	 * @param whereString
	 * @return
	 */
	/*private int updatePoltransaction(String targetTable,String setString,String whereString){
		String sql = "update table "+targetTable+setString+whereString;
		System.out.println("- 修改该语句："+sql);
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		int i = sqlAdapterMapper.excuteUpdate(sqlAdapter);
		return i;
	}*/
	/**
	 * 获取总客户表条件客户：上海人身险用
	 * @param batchNo
	 * @return
	 */
	/*private int getCustmors(String batchNo){
		String sql = " SELECT COUNT(buss_no) FROM t_shia_lcpoltransaction WHERE batchno = '"+batchNo+"' AND busstype = 'KH' AND stateflag = '1'";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		BigDecimal i = sqlAdapterMapper.excuteQueryCount(sqlAdapter);
		System.out.println("- 可客户保送批次 "+batchNo+" 下客户为："+i);
		return i.intValue();
	}*/
	/**
	 * 获取团单之下被保人数
	 * @param policyNo
	 * @return
	 */
	private int getPolInsuredNums(String policyNo){
		String sql = "SELECT COUNT(insured_no) AS INSUREDNUMS FROM t_shia_pol_insured WHERE policy_no = '"+policyNo+"' AND BUSS_TYPE='CB'";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		BigDecimal i = sqlAdapterMapper.excuteQueryCount(sqlAdapter);
		System.out.println("- 团体保单 "+policyNo+" 下被保人为："+i);
		return i.intValue();
	}
	/**
	 * 构建个平台参数
	 * @param comId
	 * @param pojo
	 * @return
	 */
	private List<ParamPOJO> buildParamPOJO(BigDecimal comId,ParamPOJO pojo) throws Exception{
		System.out.println(pojo.getBussNo());
		List<ParamPOJO> pojos = null;
		TDefSqlExample example = new TDefSqlExample();
		TDefSqlExample.Criteria criteria = example.createCriteria();
		criteria.andSubBussTypeEqualTo("POJO_CONFIG");
		criteria.andEsStatusEqualTo(Short.parseShort("1"));
		criteria.andComIdEqualTo(comId);
		List<TDefSql> tSqls = tDefSqlMapper.selectByExample(example);
		if(tSqls == null || tSqls.size() <= 0){
			return null;
		}
		try{
			// TODO 自定义参数
			/****
			 * 自定义参数，若后期其他平台构建报送POJO时，需要自定义参数，则可在此添加
			 * ****/
			//状态关联,在T_DEF_CODE_DICT中配置业务与状态关联，有则取之
			String statusRela = codeQueryService.getStatusRela("BUSS_TYPE", pojo.getBussType(), comId);
			//群组关联,在T_DEF_CODE_DICT中配置业务与状态关联，有则取之
			String groupRela = codeQueryService.getGroupRela("BUSS_TYPE", pojo.getBussType(), comId);
			Map<String,String> param = new HashMap<String,String>();
			if(statusRela != null){
				param.put("statusRela", statusRela);
			}
			if(groupRela != null){
				param.put("groupRela", groupRela);
			}
			BigDecimal sqlId = tSqls.get(0).getSqlId();
//			String sql = sqlParamService.getSqlBySqlId(sqlId,pojo);
			String sql = sqlParamService.getSqlBySqlId(sqlId,pojo,param);
			System.out.println("- ParamPOJO 控制SQL:\n "+sql);
			SqlAdapter sqlAdapter = new SqlAdapter();
			sqlAdapter.setSql(sql);
			pojos = sqlAdapterMapper.excuteParamPOJO(sqlAdapter);	
		}catch(Exception e){
			logger.debug("- 构建平台报送POJO异常："+e.getMessage());
			logger.info("- 构建平台报送POJO无对应SQL，该平台开发中 ... ");
			//e.printStackTrace();
			throw e;
		}
		return pojos;
	}
	
	/****************** 以下是测试部分用，仅作参考********************************/
	
	public static String reqTestXML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+"<PDL>"
			+"<PDL-Head>"
			+"<RequestType>SummaryCheckResultQuery</RequestType>"
			+"<CompanyCode>000031</CompanyCode>"
			+"<SerialNo>00000003397295</SerialNo>"
			+"<TimeStamp>20160303150923</TimeStamp>"
			+"<DataType>L</DataType>"
			+"</PDL-Head>"
			+"<PDL-Body>"
			+"<QueryNo>Q6a76fe52-e8a2-43b9-ba76-e62e3251be7f</QueryNo>"
			+"</PDL-Body>"
			+"</PDL>";

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> listFile(DataGridModel model,String transType,String batchNo,String stateFlag) {
		Map<String,Object> result=new HashMap<String,Object>();
		Map map=new HashMap();
		map.put("queryStartIndex", model.getStartIndex());
		map.put("queryEndIndex", model.getEndIndex());
		map.put("transType", transType);
		map.put("batchNo", batchNo);
		map.put("stateFlag", stateFlag);
		int total=tDocMainMapper.listCount();
		List<Map> list=tDocMainMapper.listFile(map);
		
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map<String, Object> listHand(DataGridModel model,String actionNosStr,TDefActionTrace tDefActionTrace){
		Map paramMap = new HashMap();
		StringBuffer sbActionNos = new StringBuffer();
		if(actionNosStr.contains("@_@")){
			sbActionNos.append("(");
			String[] ans = actionNosStr.split("@_@");
			for(int i = 0; i < ans.length; i++){
				String actionNo = ans[i];
				if(actionNo == null || "".equals(actionNo)){
					continue;
				}
				if(i < ans.length-1)
					sbActionNos.append("'"+actionNo+"',");
				else 
					sbActionNos.append("'"+actionNo+"'");
			}
			if(sbActionNos.toString().equals("(")){
				sbActionNos.append("'')");
			}else{
				sbActionNos.append(")");
			}
		}else{
			sbActionNos.append("('"+actionNosStr+"')");
		}
		String actionNos = sbActionNos.toString();
		paramMap.put("actionNos", actionNos);
		paramMap.put("queryStartIndex", model.getStartIndex());
		paramMap.put("queryEndIndex", model.getEndIndex());
		int total = tDefActionTraceMapper.querySubmitReturnInfoCounts(paramMap);
		List<Map> list = tDefActionTraceMapper.querySubmitReturnInfoPages(paramMap);
		Map<String, Object> result = new HashMap<String, Object>(2);
		result.put("total", total);
		result.put("rows",list);
		return result;
	
	}


	@Override
	public void setApplicationContext(ApplicationContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}


	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitService#getApplicationContext()
	 */
	@Override
	public ApplicationContext getApplicationContext() {
		// TODO Auto-generated method stub
		return context;
	}
}