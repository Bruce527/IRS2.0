package com.sinosoft.ummp.application.rdsi.shia;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
 * 客户身份核对接口（异步）
 * @author Darker.Wang
 * @date 2016-9-12 上午9:55:20
 * @company SINOSOFT
 */
@Service("sHIAP02RDeal")
public class SHIAP02RDeal implements ReturnDealService {
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
		 Map<String, String> pXML = parseXML(rtXML);
			pXML.put("actionNo", sr.getSubmitSerialNo());
			pXML.put("subBussType", bussModel.getSubBussType());
			pXML.put("batchNo", bussModel.getBatchNo());
			pXML.put("bussNo", bussModel.getBussNo());
			pXML.put("batchType", pojo.getBatchType());
		 dealReturnTable(pXML, pojo);
		return true;
	}
	//解析XML文件
	public Map<String,String> parseXML(String rtXML){
		Map<String,String> map = new HashMap<String, String>();
		StringReader reader = new StringReader(rtXML);
		InputSource sc = new InputSource(reader);
		SAXReader saxReader = new SAXReader();
		try {
			Document doc = saxReader.read(sc);
			Element root = doc.getRootElement();
			for( Iterator<?> i=root.elementIterator();i.hasNext();){
				Element foo = (Element) i.next();
				for(Iterator<?> j=foo.elementIterator();j.hasNext();){
					Element fo = (Element) j.next();
					if(fo.getText() != null){
						map.put(fo.getName(),fo.getTextTrim());
					}
					for(Iterator<?> k = fo.elementIterator();k.hasNext();){
						Element f = (Element)k.next();
						if(f.getText() != null){
							map.put(f.getName(), f.getTextTrim());
						}
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return map;
	}
	//修改Return表中的数据
	@Transactional
	public void dealReturnTable(Map<String,String> pXML, ParamPOJO pojo){
		//更新LCPOLTRANSACTION
		SqlAdapter sqlAdapter = new SqlAdapter();
		String stateFlag="";
		String sql="";
		if(pXML.get("RESPONSE_CODE").equals("1")){
			 stateFlag = "W";//客户保送成功，待查询
			 sql = "update t_shia_lcpoltransaction set stateflag='1'"
						+",TASK_NO = '"+pXML.get("TASK_NO")+"',buss_msg = '"+pXML.get("ERROR_MESSAGE")+"'"
						+",batch_sequence_no = '"+pXML.get("BOOKING_SEQUENCE_NO")+"'"
						+",last_modify_time = sysdate "
						+",transtype='P03'"
						+" where bussType= '"+pXML.get("batchType")+"'"
						+" and TRANSTYPE = 'P02'"
						+" and batchno = '"+pXML.get("batchNo")+"'";;
		}else{
			stateFlag = "1";
			sql="update t_shia_lcpoltransaction set stateflag = '"+stateFlag+"'"
					+",TASK_NO = '"+pXML.get("TASK_NO")+"',buss_msg = '"+pXML.get("ERROR_MESSAGE")+"'"
					+",last_modify_time = sysdate " 
					+" where bussType = '"+pXML.get("batchType")+"'"
					+" and TRANSTYPE = 'P02'"
					+" and batchno = '"+pXML.get("batchNo")+"'";
		}
		//用于独单时走
		if(pXML.get("BUSINESS_SEQUENCE_NO") != null){
			sql = sql + " and buss_no = '"+pXML.get("BUSINESS_SEQUENCE_NO")+"'";
		}
				
		try {
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
		}
		//获取报文中的值
		TDefActionReturn tDefReturn = new TDefActionReturn();
		//根据map中放的数据，更新return表
		tDefReturn.setReturnMsg(pXML.get("ERROR_MESSAGE"));
		tDefReturn.setStatus(pXML.get("RESPONSE_CODE"));
		tDefReturn.setQueryNo(pXML.get("BOOKING_SEQUENCE_NO"));//异步上传预约码
		tDefReturn.setStandby1(pXML.get("TASK_NO"));
		tDefReturn.setStandby2(pXML.get("BOOKING_SEQUENCE_NO"));//为与ActionTrace统一，该字段也存值
		tDefReturn.setLastModifyTime(DateUtils.getDateTime());
		TDefActionReturnExample example=new TDefActionReturnExample();
		String actionNo = pXML.get("actionNo");
		example.createCriteria().andActionNoEqualTo(actionNo);
		List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
		if(list.isEmpty()){
			BigDecimal id = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			tDefReturn.setActionNo(actionNo);
			tDefReturn.setId(id);
			tDefReturn.setReturnCode(pXML.get("RESPONSE_CODE"));
			tDefReturn.setBussType(pXML.get("REQUEST_TYPE"));
			tDefReturn.setPlatCom(pojo.getComId());
			tDefReturn.setOperator(pojo.getUserCode());
			tDefReturn.setInsertTime(new Date());
			tDefReturn.setSubBussType(pXML.get("subBussType"));
			tDefReturn.setEsStatus((short)1);
			tDefActionReturnMapper.insertSelective(tDefReturn);
		}else{
			tDefActionReturnMapper.updateByExampleSelective(tDefReturn, example);
		}
		//根据map中的值，更新trace表中的值
		TDefActionTrace tDefTrac = new TDefActionTrace();
		tDefTrac.setActionMsg(pXML.get("ERROR_MESSAGE"));
		tDefTrac.setDataStatus(pXML.get("RESPONSE_CODE"));
		tDefTrac.setDataMsg(pXML.get("ERROR_MESSAGE"));
		tDefTrac.setStandby1(pXML.get("TASK_NO"));
		tDefTrac.setStandby2(pXML.get("BOOKING_SEQUENCE_NO"));
		tDefTrac.setBussType("KH");
		tDefTrac.setStateFlag(stateFlag);
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
			tDefTrac.setSubBussType(pXML.get("subBussType"));
			tDefTrac.setBatchNo(pXML.get("batchNo"));
			tDefTrac.setBussNo(pXML.get("bussNo"));
			tDefTrac.setBussType(pXML.get("REQUEST_TYPE"));
			tDefTrac.setActionType(pXML.get("REQUEST_TYPE"));
			tDefActionTraceMapper.insertSelective(tDefTrac);
		}else{
			tDefActionTraceMapper.updateByExampleSelective(tDefTrac, example2);
		}
	}
	public static void main(String[] args) {
	}
}
