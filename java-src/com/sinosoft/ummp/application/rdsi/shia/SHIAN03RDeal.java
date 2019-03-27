package com.sinosoft.ummp.application.rdsi.shia;

import java.io.FileNotFoundException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.InputSource;

import com.sinosoft.eos.model.BussModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.ummp.application.ReturnDealService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.mapper.TShiaSynchroRiskInfoMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;
import com.sinosoft.ummp.domain.model.TShiaSynchroRiskInfo;
/**
 * 获取客户身份核对异步上传结果（异步）
 * @author Darker.Wang
 * @date 2016-9-12 上午9:55:20
 * @company SINOSOFT
 */
@Service("sHIAN03RDeal")
public class SHIAN03RDeal implements ReturnDealService {
@Autowired
SequenceService sequenceService;
@Autowired 
TDefActionReturnMapper tDefActionReturnMapper;
@Autowired 
TDefActionTraceMapper tDefActionTraceMapper;
@Autowired
CommonServiceMapper commonServiceMapper; 
@Autowired
SqlAdapterMapper sqlAdapterMapper;
@Autowired
TShiaSynchroRiskInfoMapper tShiaSynchroRiskInfoMapper;
//int i = 0;
//BigDecimal riskId = sequenceService.getBigSeqValByName("SEQ_T_SHIA_SYNCHRO_RISK_INFO");

	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		Object obj = sr.getReturnObj();
		BussModel bussModel = sr.getBussModel();
		String rtXML = null;
		if(obj instanceof java.lang.String){
			rtXML = (String) obj;
		}
		Map<String, Object> pXML = parseXML(rtXML);
		pXML.put("actionNo", sr.getSubmitSerialNo());
		pXML.put("subBussType", bussModel.getSubBussType());
		pXML.put("batchNo", bussModel.getBatchNo());
		pXML.put("bussNo", bussModel.getBussNo());
		pXML.put("batchType", pojo.getBatchType());
		dealReturnTable(pXML, pojo);
		return true;
	}
	//解析XML文件
	private Map<String,Object> parseXML(String rtXML){
		Map<String,Object> map = new HashMap<String, Object>();
		StringReader reader = new StringReader(rtXML);
		InputSource sc = new InputSource(reader);
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read(sc);
			Element root = doc.getRootElement();
			String REQUEST_TYPE = root.element("HEAD").element("REQUEST_TYPE").getTextTrim();
			String TASK_NO = root.element("HEAD").element("TASK_NO").getTextTrim();
			String RESPONSE_CODE = root.element("HEAD").element("RESPONSE_CODE").getTextTrim();
			String ERROR_MESSAGE = root.element("HEAD").element("ERROR_MESSAGE").getTextTrim();
			Element BATCH_INFO_E = root.element("BATCH_INFO");
			if ("1".equals(RESPONSE_CODE)) {
				List<Map<String, Object>> singleInfos = getSingleInfos(BATCH_INFO_E);
				map.put("SINGLE_INFO", singleInfos);// 返回时一个LIST
			}
			map.put("REQUEST_TYPE", REQUEST_TYPE);
			map.put("TASK_NO", TASK_NO);
			map.put("RESPONSE_CODE", RESPONSE_CODE);
			map.put("ERROR_MESSAGE", ERROR_MESSAGE);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 传入父类节点：BATCH_INFO
	 * @param e
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String,Object>> getSingleInfos(Element e){
		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
		List<Element> singleInfos = e.elements("SINGLE_INFO");
		for(Element singleInfo : singleInfos){
			Map<String,Object> map = new HashMap<String,Object>();
			String BUSINESS_SEQUENCE_NO = singleInfo.element("BUSINESS_SEQUENCE_NO").getTextTrim();
			String RESPONSE_CODE = singleInfo.element("RESPONSE_CODE").getTextTrim();
			Element BODY_E = singleInfo.element("BODY");
			if(RESPONSE_CODE.equals("1")){
				//成功才获取成功信息
				Map<String, Object>  smap = getSuccesInfo(BODY_E);
				map.put("SUCCESS_INFO", smap);
			}else{
				Map<String, Object>  fmap = getFailInfo(BODY_E);
				map.put("FAIL_INFO", fmap);
			}
			map.put("BUSINESS_SEQUENCE_NO", BUSINESS_SEQUENCE_NO);
			map.put("RESPONSE_CODE", RESPONSE_CODE);
			maps.add(map);
		}
		return maps;
	}
	/**
	 * Element 为父节点 BODY: 获取其下的子节点信息
	 * @param e
	 * @return
	 */
	private Map<String,Object> getSuccesInfo(Element e){
		Element se = e.element("SUCCESS_INFO");//获取成功
		Map<String,Object> map = new HashMap<String,Object>();
		String POLICY_SEQUENCE_NO = se.element("POLICY_SEQUENCE_NO").getTextTrim();
		Element INSURED_LIST_E = se.element("INSURED_LIST");
		map.put("POLICY_SEQUENCE_NO", POLICY_SEQUENCE_NO);
		map.put("INSURED_LIST",getCustomerInfos(INSURED_LIST_E));
		return map;
	}
	/**
	 * Element 为父节点 BODY: 获取其下的子节点信息
	 * @param e
	 * @return
	 */
	private Map<String,Object> getFailInfo(Element e){
		Element ee = e.element("FAIL_INFO");//获取成功
		Map<String,Object> map = new HashMap<String,Object>();
		String ERROR_REASON = ee.element("ERROR_REASON").getTextTrim();
		map.put("ERROR_REASON", ERROR_REASON);
		return map;
	}
	/**
	 * 传递父类元素节点：INSURED_LIST
	 * @param e
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String,Object>> getCustomerInfos(Element e){
		List<Map<String,Object>> maps = new ArrayList<Map<String,Object>>();
		List<Element> customerInfos = e.elements("CUSTOMER_INFO");
		for(Element ci : customerInfos){
			Map<String,Object> map = new HashMap<String,Object>();
			String CUTOMER_SEQUENCE_NO = ci.element("CUTOMER_SEQUENCE_NO").getTextTrim();
			Element RISK_LIST_E = ci.element("RISK_LIST");
			map.put("CUTOMER_SEQUENCE_NO",CUTOMER_SEQUENCE_NO);
			map.put("RISK_LIST", getRiskInfos(RISK_LIST_E));
			maps.add(map);
		}
		return maps;
	}
	/**
	 * 传递父类元素节点：RISK_LIST
	 * @param e
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String,String>> getRiskInfos(Element e){
		List<Map<String,String>> maps = new ArrayList<Map<String,String>>();
		List<Element> riskInfos = e.elements("RISK_INFO");
		for(Element riskInfo : riskInfos){
			Map<String,String> map = new HashMap<String,String>();
			String START_TIME = riskInfo.element("START_TIME").getTextTrim();
			String END_TIME = riskInfo.element("END_TIME").getTextTrim();
			String ALL_LIFE_SUM_INSURED = riskInfo.element("ALL_LIFE_SUM_INSURED").getTextTrim();
			String ALL_ACCIDENT_SUM_INSURED = riskInfo.element("ALL_ACCIDENT_SUM_INSURED").getTextTrim();
			String ALL_HEALTH_SUM_INSURED = riskInfo.element("ALL_HEALTH_SUM_INSURED").getTextTrim();
			String ALL_OLD_SUM_INSURED = riskInfo.element("ALL_OLD_SUM_INSURED").getTextTrim();
			String ALL_OTHER_SUM_INSURED = riskInfo.element("ALL_OTHER_SUM_INSURED").getTextTrim();
			String ALL_HOSPITAL_ALLOWANCE = riskInfo.element("ALL_HOSPITAL_ALLOWANCE").getTextTrim();
			String ALL_CLAIM_AMOUNT = riskInfo.element("ALL_CLAIM_AMOUNT").getTextTrim();
			map.put("START_TIME", START_TIME);
			map.put("END_TIME", END_TIME);
			map.put("ALL_LIFE_SUM_INSURED", ALL_LIFE_SUM_INSURED);
			map.put("ALL_ACCIDENT_SUM_INSURED", ALL_ACCIDENT_SUM_INSURED);
			map.put("ALL_HEALTH_SUM_INSURED", ALL_HEALTH_SUM_INSURED);
			map.put("ALL_OLD_SUM_INSURED", ALL_OLD_SUM_INSURED);
			map.put("ALL_OTHER_SUM_INSURED", ALL_OTHER_SUM_INSURED);
			map.put("ALL_HOSPITAL_ALLOWANCE", ALL_HOSPITAL_ALLOWANCE);
			map.put("ALL_CLAIM_AMOUNT", ALL_CLAIM_AMOUNT);
			maps.add(map);
		}
		return maps;
	}
	//修改Return表中的数据
	@Transactional
	public void dealReturnTable(Map<String,Object> pXML, ParamPOJO pojo){
		
		dealLCPoltransaction(pXML);
		dealActionTrace(pXML,pojo);
		dealActionReturn(pXML,pojo);//处理ActionReturn
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> singleInfos = (List<Map<String, Object>>) pXML.get("SINGLE_INFO");
		if ("1".equals(pXML.get("RESPONSE_CODE")) && "1".equals((String)singleInfos.get(0).get("RESPONSE_CODE"))) {
			dealRiskInfos(pXML);// 处理返回风险险种             
		}														
	}
	@SuppressWarnings("unchecked")
	private void dealLCPoltransaction(Map<String,Object> map){
		List<Map<String,Object>> singleInfos = (List<Map<String, Object>>) map.get("SINGLE_INFO");
		//分单处理
		SqlAdapter sqlAdapter = new SqlAdapter();
		if ("1".equals(map.get("RESPONSE_CODE"))) {
			for (Map<String, Object> singleInfo : singleInfos) {
				String bsn = (String) singleInfo.get("BUSINESS_SEQUENCE_NO");
				String rc = (String) singleInfo.get("RESPONSE_CODE");
				String msg="";
				String psn = "";
				// 更新表
				String stateFlag = "";
				if (rc.equals("1")) {
					stateFlag = "9";
					psn = ((Map<String, String>) singleInfo.get("SUCCESS_INFO"))
							.get("POLICY_SEQUENCE_NO");
				} else {
					 msg = ((Map<String, String>) singleInfo.get("FAIL_INFO"))
					.get("ERROR_REASON");
					stateFlag = "E";// 意为查询失败
				}
				String sql = "update t_shia_lcpoltransaction set stateflag='"
						+ stateFlag + "'" + ",TASK_NO = '"
						+ (String) map.get("TASK_NO") + "',buss_msg = '" + msg
						+ "'" + ",sequence_no = '" + psn + "'"
						+ ",last_modify_time = sysdate " + " where bussType= '"
						+ map.get("batchType") + "'" + " and batchno = '"
						+ map.get("batchNo") + "'" + " and buss_no = '" + bsn
						+ "'";// 业务号保送
				try {
					System.out.println("- dealLCPoltransaction : " + sql);
					sqlAdapter.setSql(sql);
					sqlAdapterMapper.excuteUpdate(sqlAdapter);
				} catch (Exception e) {
					System.out.println("更新交易表状态时出错！！！");
					e.printStackTrace();
				}
			}
		}else{
			String msg = (String)map.get("ERROR_MESSAGE");
			String sql = "update t_shia_lcpoltransaction set TASK_NO = '"
					+ (String) map.get("TASK_NO") + "',buss_msg = '" + msg
					+ "',last_modify_time = sysdate " + " where bussType= '"
					+ map.get("batchType") + "'" + " and batchno = '"
					+ map.get("batchNo") + "'";
			try {
				System.out.println("- dealLCPoltransaction : " + sql);
				sqlAdapter.setSql(sql);
				sqlAdapterMapper.excuteUpdate(sqlAdapter);
			} catch (Exception e) {
				System.out.println("更新交易表状态时出错！！！");
				e.printStackTrace();
			}
		}
	}
	@SuppressWarnings("unchecked")
	private void dealActionReturn(Map<String,Object> pXML,ParamPOJO pojo){
		//获取报文中的值
		TDefActionReturn tDefReturn = new TDefActionReturn();
		//根据map中放的数据，更新return表
		List<Map<String,Object>> singleInfos = (List<Map<String, Object>>) pXML.get("SINGLE_INFO");
		tDefReturn.setReturnMsg((String)pXML.get("ERROR_MESSAGE"));
		tDefReturn.setStatus((String)pXML.get("RESPONSE_CODE"));
		if("1".equals(tDefReturn.getStatus())){
		tDefReturn.setDataStatus((String)singleInfos.get(0).get("RESPONSE_CODE"));
		}
		tDefReturn.setStandby1((String)pXML.get("TASK_NO"));
		tDefReturn.setLastModifyTime(DateUtils.getDateTime());
		if("1".equals(tDefReturn.getDataStatus())){
		tDefReturn.setQueryNo((String)((Map<String, Object>)((List<Map<String, Object>>)pXML.get("SINGLE_INFO")).get(0).get("SUCCESS_INFO")).get("POLICY_SEQUENCE_NO"));
		}
		TDefActionReturnExample example = new TDefActionReturnExample();
		String actionNo = (String)pXML.get("actionNo");
		example.createCriteria().andActionNoEqualTo(actionNo);
		List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
		if(list.isEmpty()){
			BigDecimal id = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			tDefReturn.setActionNo(actionNo);
			tDefReturn.setId(id);
			tDefReturn.setPlatCom(pojo.getComId());
			tDefReturn.setReturnCode((String)pXML.get("RESPONSE_CODE"));
			tDefReturn.setDataStatus((String)pXML.get("RESPONSE_CODE"));
			if("1".equals(tDefReturn.getDataStatus())){
			tDefReturn.setQueryNo((String)((Map<String, Object>)((List<Map<String, Object>>)pXML.get("SINGLE_INFO")).get(0).get("SUCCESS_INFO")).get("POLICY_SEQUENCE_NO"));
			}
			tDefReturn.setBussType((String)pXML.get("REQUEST_TYPE"));
			tDefReturn.setOperator(pojo.getUserCode());
			tDefReturn.setInsertTime(new Date());
			tDefReturn.setSubBussType((String)pXML.get("subBussType"));
			tDefReturn.setEsStatus((short)1);
			tDefActionReturnMapper.insertSelective(tDefReturn);
		}else{
			tDefActionReturnMapper.updateByExampleSelective(tDefReturn, example);
		}
	}
	
	private void dealActionTrace(Map<String,Object> map,ParamPOJO pojo){
		//根据map中的值，更新trace表中的值
		TDefActionTrace tDefTrac = new TDefActionTrace();
		tDefTrac.setActionMsg((String)map.get("ERROR_MESSAGE"));
		tDefTrac.setDataStatus((String)map.get("RESPONSE_CODE"));
		tDefTrac.setDataMsg((String)map.get("ERROR_MESSAGE"));
		tDefTrac.setStandby1((String)map.get("TASK_NO"));
		tDefTrac.setBussType("CB");
		tDefTrac.setLastModifyTime(new Date());
		tDefTrac.setDataStatus((String)map.get("RESPONSE_CODE"));
		String actionNo = (String)map.get("actionNo");
		TDefActionTraceExample example2 = new TDefActionTraceExample();
		example2.createCriteria().andActionNoEqualTo(actionNo);
		List<TDefActionTrace> list2 = tDefActionTraceMapper.selectByExample(example2);
		if(list2.isEmpty()){
			BigDecimal id2 = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
			tDefTrac.setId(id2);
			tDefTrac.setActionNo(actionNo);
			tDefTrac.setEsStatus((short)1);
			tDefTrac.setOperator(pojo.getUserCode());
			tDefTrac.setPlatCom(pojo.getComId());
			tDefTrac.setInsertTime(new Date());
			tDefTrac.setSubBussType((String)map.get("subBussType"));
			tDefTrac.setBatchNo((String)map.get("batchNo"));
			tDefTrac.setBussNo((String)map.get("bussNo"));
			tDefTrac.setBussType("CB");
			tDefTrac.setActionType((String)map.get("REQUEST_TYPE"));
			tDefTrac.setDataStatus((String)map.get("RESPONSE_CODE"));
			tDefActionTraceMapper.insertSelective(tDefTrac);
		}else{
			tDefActionTraceMapper.updateByExampleSelective(tDefTrac, example2);
		}
	}
	@SuppressWarnings("unchecked")
	private void dealRiskInfos(Map<String,Object> map){
		List<Map<String,Object>> singleInfos = (List<Map<String, Object>>)map.get("SINGLE_INFO");
		//分单处理
		for(Map<String,Object> singleInfo : singleInfos){
			String singleBusiness = (String)singleInfo.get("BUSINESS_SEQUENCE_NO");
			String singleFlag = (String)singleInfo.get("RESPONSE_CODE");
			if(!singleFlag.equals("1")){
				String msg = ((Map<String,String>)singleInfo.get("FAIL_INFO")).get("ERROR_REASON");
				System.out.println("- N03  "+singleBusiness+" resultMsg ： "+msg);
				continue;
			}
			Map<String,Object> sim = (Map<String, Object>)singleInfo.get("SUCCESS_INFO");
			//SUCCESS 下两个节点 POLICY_SEQUENCE_NO 、 INSURED_LIST
			String POLICY_SEQUENCE_NO = (String)sim.get("POLICY_SEQUENCE_NO");
			List<Map<String,Object>> sim_cms = (List<Map<String, Object>>) sim.get("INSURED_LIST");
			//遍历 INSURED_LIST
			for(Map<String,Object> sim_cm : sim_cms){
				//INSURED_LIST 下两个节点 CUTOMER_SEQUENCE_NO 、 RISK_LIST
				String CUTOMER_SEQUENCE_NO = (String)sim_cm.get("CUTOMER_SEQUENCE_NO");
				List<Map<String, String>> sim_cm_rms = (List<Map<String, String>>) sim_cm.get("RISK_LIST");
				//遍历 RISK_LIST
				for(Map<String,String> sim_cm_rm : sim_cm_rms){
					BigDecimal rid = sequenceService.getBigSeqValByName("SEQ_T_SHIA_SYNCHRO_RISK_INFO");
					Map<String,String> paramMap = new HashMap<String,String>();
					paramMap.putAll(sim_cm_rm);
					paramMap.put("ID", ""+rid);
					paramMap.put("operator",  (String) map.get("operator"));
					paramMap.put("REQUEST_TYPE",(String) map.get("REQUEST_TYPE"));
					paramMap.put("TASK_NO", (String) map.get("TASK_NO"));
					paramMap.put("RESPONSE_CODE", (String) map.get("RESPONSE_CODE"));
					paramMap.put("ERROR_MESSAGE", (String) map.get("ERROR_MESSAGE"));
					paramMap.put("POLICY_SEQUENCE_NO", POLICY_SEQUENCE_NO);
					paramMap.put("CUTOMER_SEQUENCE_NO", CUTOMER_SEQUENCE_NO);
					dealRiskInfo(paramMap);
				}
			}
		}
		
	}
	/**
	 * 处理表T_Shia_Synchro_Risk_Info
	 * @param map
	 */
	public void dealRiskInfo(Map<String,String> map){
		TShiaSynchroRiskInfo record = new TShiaSynchroRiskInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			record.setId(new BigDecimal(map.get("ID")));//添加ID
			record.setRequestType(map.get("REQUEST_TYPE"));//添加请求类型
			record.setTaskNo(map.get("TASK_NO"));//任务编号
			record.setResponseCode(map.get("RESPONSE_CODE"));//返回类型代码
			record.setErrorMessage(map.get("ERROR_MESSAGE"));//错误描述
			record.setPolicySequenceNo(map.get("POLICY_SEQUENCE_NO"));//保单编码
			record.setCutomerSequenceNo(map.get("CUTOMER_SEQUENCE_NO"));//客户编码
			record.setStartTime(sdf.parse(map.get("START_TIME")));//区间起期
			record.setEndTime(sdf.parse(map.get("END_TIME")));//区间止期
			record.setAllLifeSumInsured(new BigDecimal(map.get("ALL_LIFE_SUM_INSURED")));//累计寿险风险保额
			record.setAllAccidentSumInsured(new BigDecimal(map.get("ALL_ACCIDENT_SUM_INSURED")));//累计意外险风险保额
			record.setAllHealthSumInsured(new BigDecimal(map.get("ALL_HEALTH_SUM_INSURED")));//累计健康险风险保额
			record.setAllOldSumInsured(new BigDecimal(map.get("ALL_OLD_SUM_INSURED")));//累计养老险风险保额
			record.setAllOtherSumInsured(new BigDecimal(map.get("ALL_OTHER_SUM_INSURED")));//累计其他人身保险风险保额
			record.setAllHospitalAllowance(new BigDecimal(map.get("ALL_HOSPITAL_ALLOWANCE")));//累计住院日额
			record.setAllClaimAmount(new BigDecimal(map.get("ALL_CLAIM_AMOUNT")));//累计赔款
			record.setInsertTime(new Date());//插入时间
			record.setLastModifyTime(new Date());//最后修改时间
			record.setOperator(map.get("operator"));//操作员
			tShiaSynchroRiskInfoMapper.insertSelective(record);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		
	}
}
