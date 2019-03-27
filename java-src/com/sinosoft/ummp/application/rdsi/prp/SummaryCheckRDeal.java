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
import org.w3c.dom.Element;
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
 * 汇总对账返回处理
 * @author lht modify by darker 2016-12-05
 * @date 2016-9-15
 * @company SINOSOFT
 */
@Service
public class SummaryCheckRDeal implements ReturnDealService {
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
	Logger logger = Logger.getLogger(SummaryCheckRDeal.class);

	public SummaryCheckRDeal() {
	}

	public static void main(String[] args) {
		String rtXML = "<?xml version="
				+ "\"1.0\""
				+ " encoding="
				+ "\"UTF-8\""
				+ "?><PDL><PDL-Head><RequestType>SummaryCheck</RequestType><CompanyCode>000000</CompanyCode><SerialNo>201508251502120123</SerialNo><TimeStamp>20150825150212</TimeStamp><DataType>L</DataType></PDL-Head><PDL-Body><Status>0000</Status><Msg>成功</Msg><QueryNo>0000000000000000000000000000000000003</QueryNo></PDL-Body></PDL>";
		SubmitReturn sr = new SubmitReturn();
		sr.setReturnObj(rtXML);
		ParamPOJO pojo = new ParamPOJO();
		SummaryCheckRDeal summaryCheckRDeal = new SummaryCheckRDeal();
		summaryCheckRDeal.dealReturn(sr,pojo);
	}
	
	@Transactional
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		System.out.println("IncResultQueryRDeal : "+sr.getMessage()+" 正在处理。startDate: "+pojo.getStartDate()+" endDate: "+pojo.getEndDate());
		Object obj = sr.getReturnObj();
		String rt=(String)obj;
		Map<String,String> map = parse(rt);
		map.put("ACTION_NO", sr.getSubmitSerialNo());
		BussModel model = sr.getBussModel();
		map.put("user", pojo.getUserCode());
		String batchNo = sr.getBussModel().getBatchNo();
		System.out.println("- 返回处理批次号： "+batchNo);
		String msg = map.get("Msg");
		System.out.println(msg);
		SqlAdapter sqlAdapter = new SqlAdapter();
		String sql="";
		String stateFlag = "4";
		if(map.get("Status").equals("02100314")){
			stateFlag = "5E";
			System.out.println("- 返回处理批次号： "+batchNo+" 汇总对账失败");
		}
		if(map.get("Status").equals("02100306")||map.get("Status").equals("02100100")){
			stateFlag = "5W";
			System.out.println("- 返回处理批次号： "+batchNo+" 汇总对账中");
		}
		sql="update t_prp_lcpoltransaction o set o.stateflag = '"+stateFlag+"' WHERE EXISTS (SELECT 'E' FROM t_prp_lcpoltransaction t WHERE t.batchno = '"+batchNo+"' AND t.transdate = o.transdate) and o.batchno is not null";
		System.out.println("sql-->"+sql);
		try {
			sqlAdapter.setSql(sql);
			int t = sqlAdapterMapper.excuteUpdate(sqlAdapter);
			System.out.println("- 汇总对账通知发出更新交易记录："+t);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
			return false;
		}
		dealTables(map, model,stateFlag);
		return true;
	}
	
	private void dealTables(Map<String, String> map, BussModel model,String stateFlag) {
		//1、ActionTrace
		dealTableTrace(map, model,stateFlag);
		//2、ActionReturn 
		areturn.setReturnMsg(map.get("Msg"));
		areturn.setStatus(map.get("Status"));
		areturn.setQueryNo(map.get("QueryNo"));
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
		}else{
			areturn.setLastModifyTime(new Date());
			tDefActionReturnMapper.updateByExampleSelective(areturn, example);
		}
		//3、LCPoltransaction_return
		dealPolTransReturn(map, model,stateFlag);
	}
	/**
	 * update or insert trace表
	 * @param map
	 * @param model
	 */
	public void dealTableTrace(Map<String, String> map, BussModel model,String stateFlag) {
		//处理ActionTrace
		TDefActionTrace trace = new TDefActionTrace();
		trace.setDataMsg(map.get("Msg"));
		trace.setDataStatus(map.get("Status"));
		trace.setBussNo(map.get("QueryNo"));//查询码
		trace.setStateFlag(stateFlag);//业务状态
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
			trace.setLastModifyTime(new Date());
			trace.setOperator(map.get("user"));
			tDefActionTraceMapper.insertSelective(trace);
		}else{
			trace.setLastModifyTime(new Date());
			tDefActionTraceMapper.updateByExampleSelective(trace, example);
		}
	}

	/**
	 * XML 格式化
	 * @param rtXML
	 * @return
	 */
	public Map<String, String> parse(String rtXML) {
		Map<String, String> map = new HashMap<String, String>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		StringReader sr = new StringReader(rtXML);
		InputSource is = new InputSource(sr);
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(is);
			Element element = doc.getDocumentElement();
			NodeList childNodes = element.getChildNodes();
			for (int i = 0; i < childNodes.getLength(); i++) {
				String nodeName = childNodes.item(i).getNodeName();
				System.out.println(nodeName);
				NodeList list = element.getElementsByTagName(nodeName);
				NodeList childNode = list.item(0).getChildNodes();
				for (int j = 0; j < childNode.getLength(); j++) {
					String name = childNode.item(j).getNodeName();
					if(childNode.item(j).getFirstChild()!=null && !"".equals(childNode.item(j).getFirstChild())){
					String value = childNode.item(j).getFirstChild()
							.getNodeValue();
					System.out.println(name + "  " + value);
					map.put(name, value);
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
	 * LCPoltransactionReturn 处理
	 * @param map
	 * @param model
	 * @param stateFlag
	 */
	public void dealPolTransReturn(Map<String, String> map, BussModel model,String stateFlag) {
		TPrpLcpoltransactionReturn tPrpLcpoltransactionReturn = new TPrpLcpoltransactionReturn();
		tPrpLcpoltransactionReturn.setTransactionid(map.get("ACTION_NO"));
		
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
		
		tPrpLcpoltransactionReturn.setStateflag(stateFlag);
		tPrpLcpoltransactionReturn.setStatus(map.get("Status"));
		tPrpLcpoltransactionReturn.setDatastatus(map.get("DataStatus"));
		tPrpLcpoltransactionReturnMapper.insertSelective(tPrpLcpoltransactionReturn);
	}
}
