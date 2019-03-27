package com.sinosoft.ummp.application.rdsi.shia;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import com.sinosoft.eos.model.BussModel;
import com.sinosoft.eos.model.SubmitReturn;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.ReturnDealService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;
/**
 * 从业人员信息接口，从业人员信息上传结果返回
 * 
 * @author Darker.Wang
 * @date 2016-9-20上午11:40:20
 * @company SINOSOFT
 */
@Service("sHIAS01RDeal")
public class SHIAS01RDeal implements ReturnDealService {
	@Autowired
	SequenceService sequenceService;
	@Autowired
	TDefActionReturnMapper actionReturnMapper;
	@Autowired
	TDefActionTraceMapper actionTraceMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper; 
	Logger logger = Logger.getLogger(SHIAS01RDeal.class);
	
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		BussModel bussModel = sr.getBussModel(); 
		Object obj = sr.getReturnObj();
		String rsXML = null;
		if(obj instanceof java.lang.String){
			rsXML = (String) obj;
		}
		Map<String,String> pXML = parseXML(rsXML);
		pXML.put("actionNo", sr.getSubmitSerialNo());
		pXML.put("subBussType", bussModel.getSubBussType());
		pXML.put("batchNo", bussModel.getBatchNo());
		pXML.put("bussNo", bussModel.getBussNo());
		
		dealReturnTable(pXML,pojo);
		return true;
	}
	//修改return表和trac表
	private void dealReturnTable(Map<String, String> pXML, ParamPOJO pojo) {
		//获取修改条件,修改return表
		String actionNo = pXML.get("actionNo");
		TDefActionReturnExample returnExample = new TDefActionReturnExample();
		returnExample.createCriteria().andActionNoEqualTo(actionNo);
		TDefActionReturn actionReturn = new TDefActionReturn();
		//返回报文中的字段
		actionReturn.setReturnMsg(pXML.get("ERROR_MESSAGE"));
		actionReturn.setStatus(pXML.get("RESPONSE_CODE"));
		actionReturn.setStandby1(pXML.get("TASK_NO"));
		List<TDefActionReturn> list2 = actionReturnMapper.selectByExample(returnExample);
		if(list2.isEmpty()){
				BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
				actionReturn.setActionNo(actionNo);
				actionReturn.setId(id);
				actionReturn.setReturnCode(pXML.get("RESPONSE_CODE"));
				actionReturn.setBussType(pXML.get("REQUEST_TYPE"));
				actionReturn.setPlatCom(pojo.getComId());
				actionReturn.setOperator(pojo.getUserCode());
				actionReturn.setInsertTime(new Date());
				actionReturn.setSubBussType(pXML.get("subBussType"));
				actionReturn.setEsStatus((short)1);
				actionReturnMapper.insertSelective(actionReturn);
		}else{
				actionReturn.setLastModifyTime(new Date());
				actionReturnMapper.updateByExampleSelective(actionReturn, returnExample);
		}
		//修改Trace表
		TDefActionTraceExample traceExample = new TDefActionTraceExample();
		TDefActionTrace actionTrace = new TDefActionTrace();
		traceExample.createCriteria().andActionNoEqualTo(actionNo);
		actionTrace.setDataStatus(pXML.get("RESPONSE_CODE"));
		actionTrace.setDataMsg(pXML.get("ERROR_MESSAGE"));
		actionTrace.setStandby1(pXML.get("TASK_NO"));
		List<TDefActionTrace> list = actionTraceMapper.selectByExample(traceExample);
		if(list.isEmpty()){
				BigDecimal id2 = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
				actionTrace.setActionNo(actionNo);
				actionTrace.setEsStatus((short)1);
				actionTrace.setOperator(pojo.getUserCode());
				actionTrace.setPlatCom(pojo.getComId());
				actionTrace.setInsertTime(new Date());
				actionTrace.setId(id2);
				actionTrace.setSubBussType(pXML.get("subBussType"));
				actionTrace.setBatchNo(pXML.get("batchNo"));
				System.out.println("batchNo:"+pXML.get("batchNo"));
				actionTrace.setBussNo(pXML.get("bussNo"));
				actionTrace.setBussType(pXML.get("REQUEST_TYPE"));
				actionTrace.setActionType(pXML.get("REQUEST_TYPE"));
				actionTraceMapper.insertSelective(actionTrace);
		}else{
				actionTrace.setLastModifyTime(new Date());
				actionTraceMapper.updateByExampleSelective(actionTrace, traceExample);
		}
	}
	//返回报文解析
	private Map<String, String> parseXML(String rsXML) {
		Map<String, String> map = new HashMap<String, String>();
		StringReader reader = new StringReader(rsXML);
		InputSource source = new InputSource(reader);
		SAXReader sReader = new SAXReader();
		try {
			Document doc = sReader.read(source);
			Element rootElement = doc.getRootElement();
			for(Iterator<?> i = rootElement.elementIterator();i.hasNext();){
				Element foo = (Element) i.next();
				for(Iterator<?> j=foo.elementIterator();j.hasNext();){
					Element fo = (Element) j.next();
					if(fo.getText() != null){
						map.put(fo.getName(),fo.getTextTrim());
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
		public static void main(String[] args) {
	
	}
}
