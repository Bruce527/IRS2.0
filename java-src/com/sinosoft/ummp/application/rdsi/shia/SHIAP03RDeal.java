package com.sinosoft.ummp.application.rdsi.shia;

import java.io.StringReader;
import java.math.BigDecimal;
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
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;
/**
 * 获取客户身份核对异步上传结果（异步）
 * @author Darker.Wang
 * @date 2016-9-12 上午9:55:20
 * @company SINOSOFT
 */
@Service("sHIAP03RDeal")
public class SHIAP03RDeal implements ReturnDealService {
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
			Element BATCH_INFO = root.element("BATCH_INFO");
			if("1".equals(RESPONSE_CODE)){
				List<Map<String,String>> SINGLE_INFOS = getSingleInfos(BATCH_INFO);
				map.put("SINGLE_INFOS", SINGLE_INFOS);
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
	 * Element 为父节点 BATCH_INFO: 获取其下的子节点信息
	 * @param e
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private List<Map<String,String>> getSingleInfos(Element e){
		List<Map<String,String>> maps = new ArrayList<Map<String,String>>();
		List<Element> sinalInfos = e.elements("SINGLE_INFO");
		for(Element sinalInfo : sinalInfos){
			Map<String,String> map = new HashMap<String,String>();
			String BUSINESS_SEQUENCE_NO = sinalInfo.element("BUSINESS_SEQUENCE_NO").getTextTrim();
			map.put("BUSINESS_SEQUENCE_NO", BUSINESS_SEQUENCE_NO);
			String RESPONSE_CODE = sinalInfo.element("RESPONSE_CODE").getTextTrim();
			map.put("RESPONSE_CODE", RESPONSE_CODE);
			if("1".equals(RESPONSE_CODE)){
				String s_csn = sinalInfo.element("BODY").element("SUCCESS_INFO").element("CUSTOMER_SEQUENCE_NO").getTextTrim();
				map.put("SUCCESS_INFO.CUSTOMER_SEQUENCE_NO", s_csn);
			}else{
				String f_er = sinalInfo.element("BODY").element("FAIL_INFO").element("ERROR_REASON").getTextTrim();
				map.put("FAIL_INFO.ERROR_REASON", f_er);
			}
			maps.add(map);
		}
		return maps;
	}
	//修改Return表中的数据
	@SuppressWarnings("unchecked")
	@Transactional
	public void dealReturnTable(Map<String,Object> pXML, ParamPOJO pojo){
		//更新LCPOLTRANSACTION
		SqlAdapter sqlAdapter = new SqlAdapter();
		if ("1".equals((String)pXML.get("RESPONSE_CODE"))) {
			List<Map<String, String>> singleInfos = (List<Map<String, String>>) pXML
					.get("SINGLE_INFOS");
			for (Map<String, String> map : singleInfos) {
				String bussSequnceNo = map.get("BUSINESS_SEQUENCE_NO");
				String responseCode = map.get("RESPONSE_CODE");
				String succSequnceNo = map
						.get("SUCCESS_INFO.CUSTOMER_SEQUENCE_NO");
				String failErrorReson = map.get("FAIL_INFO.ERROR_REASON");

				// 更新表
				String stateFlag = "";
				if (responseCode.equals("1")) {
					stateFlag = "8";// 异步查询成功
				} else {
					stateFlag = "W";// 异步查询失败，仍然处于待查询
				}
				String sql = "update t_shia_lcpoltransaction set stateflag='"
						+ stateFlag + "'" + ",TASK_NO = '" + pXML.get("TASK_NO")
						+ "'" + ",SEQUENCE_NO='" + succSequnceNo + "'"
						+ ",buss_msg = '" + failErrorReson
						+ "',last_modify_time = sysdate "
						+ " where bussType = '" + pXML.get("batchType") + "'"
						+ " and batchno = '" + pXML.get("batchNo") + "'"
						+ " and buss_No = '" + bussSequnceNo + "'";
				try {
					sqlAdapter.setSql(sql);
					sqlAdapterMapper.excuteUpdate(sqlAdapter);
				} catch (Exception e) {
					System.out.println("更新交易表状态时出错！！！");
					e.printStackTrace();
				}
			}
		}else{
			String errorMsg=(String)pXML.get("ERROR_MESSAGE");
			String sql = "update t_shia_lcpoltransaction set buss_msg = '" + errorMsg
					+ "',last_modify_time = sysdate "
					+ " where bussType = '" + pXML.get("batchType") + "'"
					+ " and batchno = '" + pXML.get("batchNo") + "'";
			try {
				sqlAdapter.setSql(sql);
				sqlAdapterMapper.excuteUpdate(sqlAdapter);
			} catch (Exception e) {
				System.out.println("更新交易表状态时出错！！！");
				e.printStackTrace();
			}
		}
		String  bResponseCode = (String)pXML.get("RESPONSE_CODE");
		String bStateFlag = "1";
		if(bResponseCode.equals("1")){
			bStateFlag = "9";
		}
		//获取报文中的值
		TDefActionReturn tDefReturn = new TDefActionReturn();
		//根据map中放的数据，更新return表
		tDefReturn.setReturnMsg((String)pXML.get("ERROR_MESSAGE"));
		tDefReturn.setStatus((String)pXML.get("RESPONSE_CODE"));
//		tDefReturn.setQueryNo((String)pXML.get("BOOKING_SEQUENCE_NO"));//异步上传预约码
		tDefReturn.setStandby1((String)pXML.get("TASK_NO"));
//		tDefReturn.setStandby2((String)pXML.get("BOOKING_SEQUENCE_NO"));//为与ActionTrace统一，该字段也存值
		tDefReturn.setLastModifyTime(DateUtils.getDateTime());
		TDefActionReturnExample example = new TDefActionReturnExample();
		String actionNo = (String)pXML.get("actionNo");
		example.createCriteria().andActionNoEqualTo(actionNo);
		List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
		if(list.isEmpty()){
			BigDecimal id = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			tDefReturn.setActionNo(actionNo);
			tDefReturn.setId(id);
			tDefReturn.setReturnCode((String)pXML.get("RESPONSE_CODE"));
			tDefReturn.setBussType((String)pXML.get("REQUEST_TYPE"));
			tDefReturn.setPlatCom(pojo.getComId());
			tDefReturn.setOperator(pojo.getUserCode());
			tDefReturn.setInsertTime(new Date());
			tDefReturn.setSubBussType((String)pXML.get("subBussType"));
			tDefReturn.setEsStatus((short)1);
			tDefActionReturnMapper.insertSelective(tDefReturn);
		}else{
			tDefActionReturnMapper.updateByExampleSelective(tDefReturn, example);
		}
		//根据map中的值，更新trace表中的值
		TDefActionTrace tDefTrac = new TDefActionTrace();
		tDefTrac.setActionMsg((String)pXML.get("ERROR_MESSAGE"));
		tDefTrac.setDataStatus((String)pXML.get("RESPONSE_CODE"));
		tDefTrac.setDataMsg((String)pXML.get("ERROR_MESSAGE"));
		tDefTrac.setStandby1((String)pXML.get("TASK_NO"));
//		tDefTrac.setStandby2((String)pXML.get("CUSTOMER_SEQUENCE_NO"));
		tDefTrac.setBussType((String)pXML.get("batchType"));
		tDefTrac.setStateFlag(bStateFlag);
		tDefTrac.setLastModifyTime(new Date());
		TDefActionTraceExample example2 = new TDefActionTraceExample();
		example2.createCriteria().andActionNoEqualTo(actionNo);
		List<TDefActionTrace> list2 = tDefActionTraceMapper.selectByExample(example2);
		if(list2.isEmpty()){
			BigDecimal id2 = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
			tDefTrac.setActionNo(actionNo);
			tDefTrac.setEsStatus((short)1);
			tDefTrac.setOperator(pojo.getUserCode());
			tDefTrac.setPlatCom(pojo.getComId());
			tDefTrac.setInsertTime(new Date());
			tDefTrac.setId(id2);
			tDefTrac.setSubBussType((String)pXML.get("subBussType"));
			tDefTrac.setBatchNo((String)pXML.get("batchNo"));
//			tDefTrac.setBussNo((String)pXML.get("bussNo"));
			tDefTrac.setBussType((String)pXML.get("REQUEST_TYPE"));
			tDefTrac.setActionType((String)pXML.get("REQUEST_TYPE"));
			tDefActionTraceMapper.insertSelective(tDefTrac);
		}else{
			tDefActionTraceMapper.updateByExampleSelective(tDefTrac, example2);
		}
		//批量把客户编码写入到trace return表中
		if ("1".equals(bResponseCode)) {
			for (int i = 0; i < ((List<Map<String, String>>) pXML
					.get("SINGLE_INFOS")).size(); i++) {
				TDefActionTrace defTrace = new TDefActionTrace();
				BigDecimal id2 = commonServiceMapper
						.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
				defTrace.setId(id2);
				defTrace.setBatchNo((String) pXML.get("batchNo"));
				defTrace.setBatchType("SHIA");
				defTrace.setBussNo((String) ((List<Map<String, String>>) pXML
						.get("SINGLE_INFOS")).get(i).get(
								"BUSINESS_SEQUENCE_NO"));
				defTrace.setBussType("KH");
				defTrace.setSubBussType("SB");
				defTrace.setPlatCom(new BigDecimal(5));
				defTrace.setActionNo(actionNo + "-" + i);
				defTrace.setActionAllCount(new Long(1));
				defTrace.setActionSucCount(new Long(1));
				defTrace.setActionType("SHIAP03");
				defTrace.setActionMsg((String) pXML.get("ERROR_MESSAGE"));
				defTrace.setDataStatus((String) pXML.get("RESPONSE_CODE"));
				defTrace.setDataMsg((String) pXML.get("ERROR_MESSAGE"));
				defTrace.setEsStatus((short) 1);
				defTrace.setInsertTime(new Date());
				tDefActionTraceMapper.insertSelective(defTrace);
				TDefActionReturn defReturn = new TDefActionReturn();
				BigDecimal id = commonServiceMapper
						.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
				defReturn.setId(id);
				defReturn.setActionNo(actionNo + "-" + i);
				defReturn.setPlatCom(new BigDecimal(5));
				defReturn.setBussType("P03");
				defReturn.setSubBussType("P03");
				defReturn.setStatus((String) pXML.get("RESPONSE_CODE"));
				if ("1".equals((String) pXML.get("RESPONSE_CODE"))) {
					defReturn
							.setQueryNo((String) ((List<Map<String, String>>) pXML
									.get("SINGLE_INFOS")).get(i).get(
									"SUCCESS_INFO.CUSTOMER_SEQUENCE_NO"));
					defReturn.setReturnMsg((String) pXML.get("RESPONSE_CODE"));
				} else {
					defReturn.setReturnMsg((String) pXML.get("RESPONSE_CODE"));
				}
				defReturn.setStandby1((String) pXML.get("TASK_NO"));
				defReturn.setLastModifyTime(DateUtils.getDateTime());
				defReturn.setInsertTime(new Date());
				tDefActionReturnMapper.insertSelective(defReturn);
			}
		}
	}
	public static void main(String[] args) {
	}
}
