package com.sinosoft.ummp.application.rdsi.shia;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
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
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.ReturnDealService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.mapper.TShiaSynchroRiskInfoMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;

/**
 * 承保信息异步上传结果返回
 * @author Darker.Wang
 * @date 2017-1-4 下午8:13:30
 * @company SINOSOFT
 */
@Service("sHIAN020202RDeal")
public class SHIAN020202RDeal implements ReturnDealService {
	
	@Autowired 
	SequenceService sequenceService;
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	TShiaSynchroRiskInfoMapper tShiaSynchroRiskInfoMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	Logger logger = Logger.getLogger(SHIAN01RDeal.class);
	
	/**
	 * 边解析边处理
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		
		Object obj = sr.getReturnObj();
		String rtXml = null;
		if(obj instanceof java.lang.String){
			rtXml = (String)obj;
		}
		Map<String,String> map = parseXML(rtXml);
		BussModel model = sr.getBussModel();
		map.put("actionNo", sr.getSubmitSerialNo());
		map.put("subBussType", model.getSubBussType());
		map.put("batchNo", pojo.getBatchNo());
		map.put("comId", pojo.getComId().toString());
		map.put("bussNo", model.getBussNo());
		map.put("bussType", pojo.getBussType());
		map.put("operator", pojo.getUserCode());
		map.put("batchType", pojo.getBatchType());
		try {
			dealReturnTable(map);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * 保证事务
	 */
	@Transactional
	public void dealReturnTable(Map<String, String> map){
		dealTrace(map);
		dealReturn(map);
		dealLCPoltransaction(map);
	}
	
	/**
	 * 处理表T_SHIA_LCPOLTRANSACTION
	 * @param map
	 */
	
	private void dealLCPoltransaction(Map<String, String> map) {
		//更新表
		SqlAdapter sqlAdapter = new SqlAdapter();
		String responseCode = map.get("RESPONSE_CODE");
		String stateFlag = "1" ;
		if(responseCode.equals("1")){
			 stateFlag = "W";
		}else{
			stateFlag = "1";
		}
		String 	sql = "update t_shia_lcpoltransaction set stateflag='"+stateFlag+"'" 
				+",TASK_NO = '"+map.get("TASK_NO")+"',buss_msg = '"+map.get("ERROR_MESSAGE")+"'"
				+",last_modify_time = sysdate "
				+" where bussType= '"+map.get("batchType")+"'"
				+" and buss_no = '"+map.get("bussNo")+"'";
		try {
			System.out.println("- dealLCPoltransaction : "+sql);
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
		}
	}

	//解析XML文件
	private Map<String,String> parseXML(String rtXML){
		Map<String,String> map = new HashMap<String, String>();
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
			map.put("REQUEST_TYPE", REQUEST_TYPE);
			map.put("TASK_NO", TASK_NO);
			map.put("RESPONSE_CODE", RESPONSE_CODE);
			map.put("ERROR_MESSAGE", ERROR_MESSAGE);
			if("1".equals(RESPONSE_CODE)){
				String BOOKING_SEQUENCE_NO = root.element("BODY").element("SUCCESS_INFO").element("BOOKING_SEQUENCE_NO").getTextTrim();
				map.put("BOOKING_SEQUENCE_NO", BOOKING_SEQUENCE_NO);	
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
	/**
	 * 处理表T_DEF_ACTION_TRACE
	 */
	public void dealTrace(Map<String, String> map){
		//更新trace表
		TDefActionTrace tDefTrace = new TDefActionTrace();
		tDefTrace.setPlatCom(new BigDecimal(map.get("comId")));
		tDefTrace.setBussType(map.get("REQUEST_TYPE"));
		tDefTrace.setDataStatus(map.get("RESPONSE_CODE"));
		tDefTrace.setDataMsg(map.get("ERROR_MESSAGE"));
		tDefTrace.setStandby1(map.get("TASK_NO"));
		tDefTrace.setStandby2(map.get("BOOKING_SEQUENCE_NO"));
		tDefTrace.setBussType(map.get("bussType"));
		String stateFlag="";
		if(map.get("RESPONSE_CODE").equals("1")){
			 stateFlag = "W";
		}else{
			stateFlag = "1";
		}
		tDefTrace.setStateFlag(stateFlag);//异步保送成功与否
		tDefTrace.setLastModifyTime(new Date());//更新最后修改时间
		TDefActionTraceExample example = new TDefActionTraceExample();
		example.createCriteria().andActionNoEqualTo(map.get("actionNo"));
		//判断使用何种sql语句
		int result = tDefActionTraceMapper.countByExample(example);
		if(result > 0){
			tDefActionTraceMapper.updateByExampleSelective(tDefTrace, example);//更新操作
		}else{
			tDefTrace.setActionNo(map.get("actionNo"));//交易流水号
			tDefTrace.setBussNo(map.get("bussNo"));//交易业务号
			tDefTrace.setBatchNo(map.get("batchNo"));//交易批次号
			tDefTrace.setBatchType(map.get("batchType"));//交易批次类型
			tDefTrace.setInsertTime(new Date());//插入时间
			tDefTrace.setLastModifyTime(new Date());//最后修改时间
			tDefTrace.setEsStatus((short) 1);//添加有效状态
			tDefTrace.setOperator(map.get("operator"));//添加操作者
			String traceSeq = sequenceService.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
			tDefTrace.setId(new BigDecimal(traceSeq));
			tDefActionTraceMapper.insertSelective(tDefTrace);
		}
	}

	/**
	 * 处理表T_DEF_ACTION_RETURN
	 */
	public void dealReturn(Map<String, String> map){
		//更新return表
		TDefActionReturn tDefReturn = new TDefActionReturn();
		tDefReturn.setBussType(map.get("REQUEST_TYPE"));
		tDefReturn.setStatus(map.get("RESPONSE_CODE"));
		tDefReturn.setReturnMsg(map.get("ERROR_MESSAGE"));
		tDefReturn.setQueryNo(map.get("BOOKING_SEQUENCE_NO"));
		tDefReturn.setStandby1(map.get("TASK_NO"));
		tDefReturn.setStandby2(map.get("BOOKING_SEQUENCE_NO"));//与Action统一
		tDefReturn.setLastModifyTime(new Date());//更新最后修改时间
		TDefActionReturnExample example = new TDefActionReturnExample();
		example.createCriteria().andActionNoEqualTo(map.get("actionNo"));
		//判断使用何种sql语句
		int result = tDefActionReturnMapper.countByExample(example);
		if(result > 0){
			tDefActionReturnMapper.updateByExampleSelective(tDefReturn, example);//更新操作
		}else{
			tDefReturn.setActionNo(map.get("actionNo"));//业务流水号
			tDefReturn.setBussType(map.get("bussType"));//业务类型 
			tDefReturn.setPlatCom(new BigDecimal(map.get("comId")));//机构编码即平台编码
			tDefReturn.setSubBussType(map.get("subBussType"));//交易父级业务类型
			tDefReturn.setInsertTime(new Date());//插入时间
			tDefReturn.setLastModifyTime(new Date());//最后修改时间
			tDefReturn.setEsStatus((short) 1);//添加有效状态
			tDefReturn.setOperator(map.get("operator"));//添加操作者
			String returnSeq = sequenceService.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			tDefReturn.setId(new BigDecimal(returnSeq));
			tDefActionReturnMapper.insertSelective(tDefReturn);
		}
	}
	
	/**
	 * main方法本地解析报文测试
	 */
	public static void main(String[] args) {
	}
	
}













