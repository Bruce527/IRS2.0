/**
 * 
 */
package com.sinosoft.ummp.application.rdsi.prp;

import java.io.IOException;
import java.io.StringReader;
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
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sinosoft.eos.model.BussModel;
import com.sinosoft.eos.model.SubmitReturn;
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
 * 补报数据上载通知
 * 
 * @date 2016-9-12 下午9:55:20
 * @company SINOSOFT
 */
@Service
public class PthUploadRDeal implements ReturnDealService {
	private TDefActionReturn tDefActionReturn = new TDefActionReturn();
	private TDefActionTrace tDefActionTrace = new TDefActionTrace();

	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;

	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;

	@Autowired
	TPrpLcpoltransactionReturnMapper tPrpLcpoltransactionReturnMapper;
	Logger log = Logger.getLogger(PthUploadRDeal.class);

	public PthUploadRDeal() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.ReturnDealService#dealReturn(com.sinosoft
	 * .eos.model.SubmitReturn)
	 */
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		Object obj = sr.getReturnObj();
		String rtXML = (String) obj;
		Map<String, String> map = parseXML(rtXML);
		map.put("ACTION_NO", sr.getSubmitSerialNo());
		map.put("batchno", sr.getBussModel().getBatchNo());
		map.put("user", pojo.getUserCode());
		BussModel model = sr.getBussModel();
		dealTable(map,model);
		return true;

	}

	@Transactional
	public void dealTable(Map<String, String> map, BussModel model) {
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
		try {
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
		}
		updateReturn(map,model,stateFlag);
		TDefActionTraceExample tDefActionTraceExample = new TDefActionTraceExample();
		tDefActionTraceExample.createCriteria().andActionNoEqualTo(
				map.get("ACTION_NO"));
		tDefActionTrace.setBatchNo(model.getBatchNo());
		tDefActionTrace.setPlatCom(model.getComId());
		tDefActionTrace.setSubBussType(model.getSubBussType());
		tDefActionTrace.setActionNo(map.get("ACTION_NO"));
		tDefActionTrace.setBussType(map.get("RequestType"));
		tDefActionTrace.setActionType(map.get("RequestType"));
		tDefActionTrace.setEsStatus((short) 1);
		tDefActionTrace.setDataMsg(map.get("Msg"));
		tDefActionTrace.setDataStatus(map.get("Status"));
		tDefActionTrace.setBussNo(map.get("QueryNo"));
		tDefActionTrace.setBatchType("PTH");
		tDefActionTrace.setStateFlag(stateFlag);
		tDefActionTraceMapper.updateByExampleSelective(tDefActionTrace,
				tDefActionTraceExample);
		dealPolTransReturn(map, model);
	}

	/**
	 * UPDATE T_DEF_ACTION_RETURN表
	 * 
	 * @param map
	 */
	public void updateReturn(Map<String, String> map, BussModel model,String stateFlag) {
			TDefActionReturnExample tDefActionReturnExample = new TDefActionReturnExample();
			tDefActionReturnExample.createCriteria().andActionNoEqualTo(map.get("ACTION_NO"));
			tDefActionReturn.setReturnMsg(map.get("Msg"));
			tDefActionReturn.setDataStatus(map.get("Status"));
			tDefActionReturn.setQueryNo(map.get("QueryNo"));
			tDefActionReturn.setBussType(map.get("RequestType"));
			tDefActionReturn.setPlatCom(model.getComId());
			tDefActionReturn.setSubBussType(model.getSubBussType());
			tDefActionReturn.setEsStatus((short)1);
			tDefActionReturn.setStandby1(stateFlag);
			tDefActionReturnMapper.updateByExampleSelective(tDefActionReturn,
					tDefActionReturnExample);
	}

	public Map<String, String> parseXML(String rtXML) {
		Map<String, String> map = new HashMap<String, String>();
		StringReader sb = new StringReader(rtXML);
		InputSource is = new InputSource(sb);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(is);
			// 获取根节点
			Element root = document.getDocumentElement();
			// 读取data节点NodeList接口
			NodeList nodeList = root.getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				// 遍历每个子节点内的子节点并获取节点名和值，压入map集合
				NodeList nodeList1 = nodeList.item(i).getChildNodes();
				for (int j = 0; j < nodeList1.getLength(); j++) {
//					if(!nodeList1.item(j).getFirstChild().hasChildNodes()){
					if(nodeList1.item(j).getFirstChild()!=null && !"".equals(nodeList1.item(j).getFirstChild())){
					String key = nodeList1.item(j).getNodeName();
					String value = nodeList1.item(j).getFirstChild().getNodeValue();
					log.info("key:"+key+"\n"+"value:"+value);
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
		String stateFlag="3";
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
