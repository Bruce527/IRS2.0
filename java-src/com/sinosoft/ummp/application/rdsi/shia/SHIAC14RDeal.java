package com.sinosoft.ummp.application.rdsi.shia;

import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.ummp.application.ReturnDealService;
import com.sinosoft.ummp.domain.mapper.TDefActionReturnMapper;
import com.sinosoft.ummp.domain.mapper.TDefActionTraceMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;

/**
 * 团险理赔注销同步上传结果返回
 * @author sendylou
 * @date 2016/09/21
 * @company sinosoft
 *
 */

@Service
public class SHIAC14RDeal implements ReturnDealService {

	@Autowired
	SequenceService sequenceService;
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	
	public SHIAC14RDeal() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		Object obj = sr.getReturnObj();
		String rtXml = null;
		if(obj instanceof java.lang.String){
			rtXml = (String) obj;
		}
		Map<String, String> map = parseXml(rtXml);
		BussModel model = sr.getBussModel();
		map.put("actionNo", sr.getSubmitSerialNo());
		map.put("subBussType", model.getSubBussType());
		map.put("batchNo", model.getBatchNo());
		map.put("comId", model.getComId().toString());
		map.put("bussNo", model.getBussNo());
		map.put("bussType", model.getBussType());
		map.put("operator", pojo.getUserCode());
		map.put("batchType", pojo.getBatchType());
		dealReturnTable(map);
		return true;
	}

	/**
	 * 保证事务
	 */
	@Transactional
	public void dealReturnTable(Map<String, String> map){
		dealTrace(map);
		dealReturn(map);
		dealLcpoltransaction(map);
	}
	
	private void dealLcpoltransaction(Map<String, String> map) {
		SqlAdapter sqlAdapter = new SqlAdapter();
		String stateFlag="";
		if(map.get("RESPONSE_CODE").equals("1")){
			 stateFlag = "7";
		}else{
			stateFlag = "7E";
		}
		String 	sql="update t_shia_lcpoltransaction set stateflag='"+stateFlag+"'  where bussType= '"+map.get("batchType")+"'"+" and buss_no='"+map.get("bussNo")+"'";
		try {
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
		} catch (Exception e) {
			System.out.println("更新交易表状态时出错！！！");
			e.printStackTrace();
		}
		
		
	}

	/**
	 * 处理表T_DEF_ACTION_TRACE
	 */
	public void dealTrace(Map<String, String> map){
		//更新trace表
		TDefActionTrace tDefTrace = new TDefActionTrace();
		tDefTrace.setBussType(map.get("REQUEST_TYPE"));
		tDefTrace.setStandby1(map.get("TASK_NO"));
		tDefTrace.setDataStatus(map.get("RESPONSE_CODE"));
		tDefTrace.setDataMsg(map.get("ERROR_MESSAGE"));
		tDefTrace.setStandby2(map.get("CLAIM_CANCELLATION_SEQUENCE_NO"));
		tDefTrace.setBussType("LPDR01");
		String stateFlag="";
		if(map.get("RESPONSE_CODE").equals("1")){
			 stateFlag = "7";
		}else{
			stateFlag = "7E";
		}
		tDefTrace.setStateFlag(stateFlag);
		TDefActionTraceExample example = new TDefActionTraceExample();
		example.createCriteria().andActionNoEqualTo(map.get("actionNo"));
		//判断使用何种sql语句
		int result = tDefActionTraceMapper.countByExample(example);
		//System.out.println("tDefActionTrace记录:"+result);
		if(result > 0){
			tDefTrace.setLastModifyTime(new Date());//更新最后修改时间
			tDefActionTraceMapper.updateByExampleSelective(tDefTrace, example);//更新操作
		}else{
			tDefTrace.setActionNo(map.get("actionNo"));
			tDefTrace.setBussNo(map.get("bussNo"));
			tDefTrace.setBatchNo(map.get("batchNo"));
			tDefTrace.setBatchType(map.get("batchType"));
			tDefTrace.setInsertTime(new Date());//处理时间
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
		tDefReturn.setStandby1(map.get("TASK_NO"));
		tDefReturn.setStatus(map.get("RESPONSE_CODE"));
		tDefReturn.setReturnMsg(map.get("ERROR_MESSAGE"));
		tDefReturn.setQueryNo(map.get("CLAIM_CANCELLATION_SEQUENCE_NO"));
		TDefActionReturnExample example = new TDefActionReturnExample();
		example.createCriteria().andActionNoEqualTo(map.get("actionNo"));
		//判断使用何种sql语句
		int result = tDefActionReturnMapper.countByExample(example);
		//System.out.println("tDefActionTrace记录:"+result);
		if(result > 0){
			tDefReturn.setLastModifyTime(new Date());//更新最后修改时间
			tDefActionReturnMapper.updateByExampleSelective(tDefReturn, example);//更新操作
		}else{
			tDefReturn.setActionNo(map.get("actionNo"));
			tDefReturn.setBussType(map.get("bussType"));
			tDefReturn.setPlatCom(new BigDecimal(map.get("comId")));//机构编码即平台编码
			tDefReturn.setSubBussType(map.get("subBussType"));//交易父级业务类型
			tDefReturn.setInsertTime(new Date());//处理时间
			tDefReturn.setLastModifyTime(new Date());//最后修改时间
			tDefReturn.setEsStatus((short) 1);//添加有效状态
			tDefReturn.setOperator(map.get("operator"));//添加操作者
			String returnSeq = sequenceService.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
			tDefReturn.setId(new BigDecimal(returnSeq));
			tDefActionReturnMapper.insertSelective(tDefReturn);
		}
	}
	
	/**
	 * 解析报文
	 */
	public Map<String, String> parseXml(String rtXml){
		Map<String ,String> map = new HashMap<String ,String>();
		StringReader reader = new StringReader(rtXml);
		InputSource is = new InputSource(reader);
		SAXReader saxReader = new  SAXReader();
		try {
			Document doc = saxReader.read(is);
			Element root = doc.getRootElement();
			for( Iterator<?> a=root.elementIterator();a.hasNext();){
				Element itemEle = (Element) a.next();
				for(Iterator<?> b=itemEle.elementIterator();b.hasNext();){
					Element itemEle1 = (Element) b.next();
					if(itemEle1.getText() != null){
						map.put(itemEle1.getName(), itemEle1.getTextTrim());
					}
					for(Iterator<?> c = itemEle1.elementIterator();c.hasNext();){
						Element itemEle2 = (Element)c.next();
						if(itemEle2.getText() != null){
							map.put(itemEle2.getName(), itemEle2.getTextTrim());
						}
					}
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * main方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		reader.setEncoding("utf-8");
		File f = new File("D:\\团险理赔注销同步上传.xml");
		try {
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			for( Iterator<?> a=root.elementIterator();a.hasNext();){
				Element itemEle = (Element) a.next();
				for(Iterator<?> b=itemEle.elementIterator();b.hasNext();){
					Element itemEle1 = (Element) b.next();
					if(itemEle1.getText() != null){
						map.put(itemEle1.getName(), itemEle1.getTextTrim());
					}
					for(Iterator<?> c = itemEle1.elementIterator();c.hasNext();){
						Element itemEle2 = (Element)c.next();
						if(itemEle2.getText() != null){
							map.put(itemEle2.getName(), itemEle2.getTextTrim());
						}
					}
				}
			}
			System.out.println(map.get("REQUEST_TYPE"));
			System.out.println(map.get("TASK_NO"));
			System.out.println(map.get("RESPONSE_CODE"));
			System.out.println(map.get("ERROR_MESSAGE"));
			System.out.println(map.get("CLAIM_CANCELLATION_SEQUENCE_NO"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
