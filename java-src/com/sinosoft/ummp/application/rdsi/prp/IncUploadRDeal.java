/**
 * 
 */
package com.sinosoft.ummp.application.rdsi.prp;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

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
import com.sinosoft.ummp.domain.mapper.TPrpLcpoltransactionReturnMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;
import com.sinosoft.ummp.domain.model.TPrpLcpoltransactionReturn;

/**
 * @author Darker.Wang
 * @date 2016-9-7 上午11:08:50
 * @company SINOSOFT
 */
@Service
public class IncUploadRDeal implements ReturnDealService{
	private TDefActionReturn areturn=new TDefActionReturn();
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired 
	SequenceService sequenceService;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	TPrpLcpoltransactionReturnMapper tPrpLcpoltransactionReturnMapper;
	Logger logger = Logger.getLogger(IncUploadRDeal.class);
	public IncUploadRDeal() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.ReturnDealService#dealReturn(com.sinosoft.eos.model.SubmitReturn, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		System.out.println("IncUploadRDeal : "+sr.getMessage()+" 正在处理...");
		Object obj = sr.getReturnObj();
		String rt=(String)obj;
		Map<String,String> map=parseXML(rt);
		map.put("ACTION_NO", sr.getSubmitSerialNo());
		map.put("batchno", sr.getBussModel().getBatchNo());
		map.put("user", pojo.getUserCode());
		BussModel model = sr.getBussModel();
		dealTables(map, model);
		return true;
	}
	@Transactional
	private void dealTables(Map<String, String> map, BussModel model) {
		String batchno=map.get("batchno");
		SqlAdapter sqlAdapter = new SqlAdapter();
		String stateFlag="";
		if(map.get("Status").equals("05080100")){
			 stateFlag = "4";
		}else if(map.get("Status").equals("05080308")){
			 stateFlag = "3";
		}else{
			stateFlag = "3E";
		}
		
		String 	sql="update t_prp_lcpoltransaction set stateflag='"+stateFlag+"' where batchno= '"+batchno+"'";
		sqlAdapter.setSql(sql);
		sqlAdapterMapper.excuteUpdate(sqlAdapter);
		
		dealTableTrace(map, model,stateFlag);
		areturn.setReturnMsg(map.get("Msg"));
		areturn.setStatus(map.get("Status"));
		areturn.setQueryNo(map.get("QueryNo"));
		areturn.setBussType(map.get("RequestType"));
		areturn.setPlatCom(model.getComId());
		areturn.setSubBussType(model.getSubBussType());
		areturn.setEsStatus((short)1);
		areturn.setStandby1(stateFlag);
		TDefActionReturnExample example=new TDefActionReturnExample();
		example.createCriteria().andActionNoEqualTo(map.get("ACTION_NO"));
		List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
		if(list.isEmpty()){
			BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			areturn.setId(id);
			areturn.setActionNo(map.get("ACTION_NO"));
			areturn.setBussType(map.get("RequestType"));
			areturn.setPlatCom(model.getComId());
			areturn.setSubBussType(model.getSubBussType());
			areturn.setEsStatus((short)1);
			areturn.setInsertTime(new Date());
			tDefActionReturnMapper.insertSelective(areturn);
			dealPolTransReturn(map,model);
		}else{
			areturn.setLastModifyTime(new Date());
			tDefActionReturnMapper.updateByExampleSelective(areturn, example);
			dealPolTransReturn(map,model);
		}
		
	
	}
	/**
	 * update or insert trace表
	 * @param map
	 * @param model
	 */
	public void dealTableTrace(Map<String, String> map, BussModel model,String stateflag) {
		TDefActionTrace trace = new TDefActionTrace();
		trace.setBatchNo(model.getBatchNo());
		trace.setPlatCom(model.getComId());
		trace.setSubBussType(model.getSubBussType());
		trace.setActionNo(map.get("ACTION_NO"));
		trace.setBussType(map.get("RequestType"));
		trace.setActionType(map.get("RequestType"));
		trace.setEsStatus((short) 1);
		trace.setDataMsg(map.get("Msg"));
		trace.setDataStatus(map.get("Status"));
		trace.setBussNo(map.get("QueryNo"));
		trace.setBatchType("INC");
		trace.setStateFlag(stateflag);
		TDefActionTraceExample example = new TDefActionTraceExample();
		example.createCriteria().andActionNoEqualTo(map.get("ACTION_NO"));
		List<TDefActionTrace> list=tDefActionTraceMapper.selectByExample(example);
		if(list.isEmpty()){
			BigDecimal id=commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
			trace.setId(id);
			trace.setBatchNo(model.getBatchNo());
			trace.setPlatCom(model.getComId());
			trace.setSubBussType(model.getSubBussType());
			trace.setActionNo(map.get("ACTION_NO"));
			trace.setBussType(map.get("RequestType"));
			trace.setActionType(map.get("RequestType"));
			trace.setEsStatus((short) 1);
			trace.setInsertTime(new Date());
			tDefActionTraceMapper.insertSelective(trace);
		}else{
			trace.setLastModifyTime(new Date());
			tDefActionTraceMapper.updateByExampleSelective(trace, example);
		}
	}
	
	/**
	 * 解析报文
	 * @param strXml
	 * @return map
	 */
	public Map<String,String> parseXML(String strXml){
		Map<String,String> map=new HashMap<String,String>();
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		StringReader sReader = new StringReader(strXml);
		InputSource is=new InputSource(sReader);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			org.w3c.dom.Element root =doc.getDocumentElement();
			NodeList nodes = root.getChildNodes();
			for(int j=0;j<nodes.getLength();j++){
				String name = nodes.item(j).getNodeName();
				NodeList list = root.getElementsByTagName(name);
				NodeList childNodes = list.item(0).getChildNodes();
				for(int i=0;i<childNodes.getLength();i++){
					if(childNodes.item(i).getFirstChild()!=null && !"".equals(childNodes.item(i).getFirstChild())){
					String key = childNodes.item(i).getNodeName();
					String value = childNodes.item(i).getFirstChild().getNodeValue();
					map.put(key, value);
				}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 向return表插入数据
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public void dealPolTransReturn(Map<String, String> map, BussModel model) {
		TPrpLcpoltransactionReturn tPrpLcpoltransactionReturn = new TPrpLcpoltransactionReturn();
		tPrpLcpoltransactionReturn.setTransactionid(map.get("ACTION_NO"));
		String sql = "select t.doc_id from t_doc_main t where t.batch_no = '"+model.getBatchNo()+"'";
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> lists = sqlAdapterMapper.excuteQuery(sqlAdapter);
		if(lists.size() != 0){ 
		String DocId = lists.get(0).get("DOC_ID").toString();
		tPrpLcpoltransactionReturn.setReturndocid(DocId);}
		tPrpLcpoltransactionReturn.setBatchno(model.getBatchNo());
		tPrpLcpoltransactionReturn.setSubbusstype(model.getSubBussType());
		tPrpLcpoltransactionReturn.setBusstype(map.get("RequestType"));
		tPrpLcpoltransactionReturn.setOperator(map.get("user"));
		tPrpLcpoltransactionReturn.setMsg(map.get("Msg"));
		tPrpLcpoltransactionReturn.setStatus(map.get("Status"));
		tPrpLcpoltransactionReturn.setQueryno(map.get("QueryNo"));
		tPrpLcpoltransactionReturn.setMakedate(new Date());
		tPrpLcpoltransactionReturn.setMaketime(DateUtils.getCurrentTime());
		tPrpLcpoltransactionReturn.setModifydate(new Date());
		tPrpLcpoltransactionReturn.setModifytime(DateUtils.getCurrentTime());
		String stateFlag="4E";
		if(map.get("Status").equals("05080100")){
			 stateFlag = "4";
		}else if(map.get("Status").equals("05080308")){
			 stateFlag = "3";
		}else{
			stateFlag = "3E";
		}
		
		tPrpLcpoltransactionReturn.setStateflag(stateFlag);
		tPrpLcpoltransactionReturnMapper.insertSelective(tPrpLcpoltransactionReturn);
	}

}
