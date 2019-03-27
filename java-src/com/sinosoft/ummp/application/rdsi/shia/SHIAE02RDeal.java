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
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
 * 保全接口 ，保全被保险人信息修改同步上传
 * 
 * @author Darker.Wang
 * @date 2016-9-12 上午9:55:20
 * @company SINOSOFT
 */
@Service("sHIAE02RDeal")
@Scope
public class SHIAE02RDeal implements ReturnDealService {
	@Autowired
	SequenceService sequenceService;
	@Autowired 
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired 
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper; 
	Logger logger = Logger.getLogger(SHIAE01RDeal.class);
	public SHIAE02RDeal(){
		
	}

	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		BussModel bussModel = sr.getBussModel();
		Object object = sr.getReturnObj();
		String rtXML = null;
		if(object instanceof java.lang.String){
			rtXML = (String)object;
		}
		Map<String,String> pXML = parseXML(rtXML);
		pXML.put("actionNo", sr.getSubmitSerialNo());
		pXML.put("subBussType", bussModel.getSubBussType());
		pXML.put("batchNo", bussModel.getBatchNo());
		pXML.put("bussNo", bussModel.getBussNo());
		
		dealReturnTable(pXML,pojo);
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
			//获取报文中的值
			String actionNo = pXML.get("actionNo");
			TDefActionReturnExample example=new TDefActionReturnExample();
			example.createCriteria().andActionNoEqualTo(actionNo);
			TDefActionReturn tDefReturn = new TDefActionReturn();
			//根据map中放的数据，更新return表
			tDefReturn.setReturnMsg(pXML.get("ERROR_MESSAGE"));
			tDefReturn.setStatus(pXML.get("RESPONSE_CODE"));
			tDefReturn.setQueryNo(pXML.get("ENDORSEMENT_SEQUENCE_NO"));
			tDefReturn.setStandby1(pXML.get("TASK_NO"));
			List<TDefActionReturn> list = tDefActionReturnMapper.selectByExample(example);
			if(list.isEmpty()){
				tDefReturn.setSubBussType(pXML.get("subBussType"));
				BigDecimal id = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
				tDefReturn.setId(id);  
				tDefReturn.setActionNo(actionNo);
				tDefReturn.setBussType(pXML.get("REQUEST_TYPE"));
				tDefReturn.setPlatCom(pojo.getComId());
				tDefReturn.setOperator(pojo.getUserCode());
				tDefReturn.setInsertTime(new Date());
				tDefReturn.setSubBussType(pXML.get("subBussType"));
				tDefReturn.setReturnCode(pXML.get("RESPONSE_CODE"));
				tDefReturn.setEsStatus((short)1);
				
				tDefActionReturnMapper.insertSelective(tDefReturn);
			}else{
					tDefReturn.setLastModifyTime(new Date());
					tDefActionReturnMapper.updateByExampleSelective(tDefReturn, example);
			}
			//根据map中的值，更新trace表中的值
			TDefActionTraceExample example2 = new TDefActionTraceExample();
			example2.createCriteria().andActionNoEqualTo(actionNo);
			List<TDefActionTrace> list2 = tDefActionTraceMapper.selectByExample(example2);
			TDefActionTrace tDefTrac = new TDefActionTrace();
			tDefTrac.setStandby2(pXML.get("ENDORSEMENT_SEQUENCE_NO"));
			tDefTrac.setDataStatus(pXML.get("RESPONSE_CODE"));
			tDefTrac.setDataMsg(pXML.get("ERROR_MESSAGE"));
			tDefTrac.setStandby1(pXML.get("TASK_NO"));
			if(list2.isEmpty()){
				BigDecimal id2 = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
				tDefTrac.setId(id2);
				tDefTrac.setActionNo(actionNo);
				tDefTrac.setEsStatus((short)1);
				tDefTrac.setOperator(pojo.getUserCode());
				tDefTrac.setPlatCom(pojo.getComId());
				tDefTrac.setInsertTime(new Date());
				tDefTrac.setSubBussType(pXML.get("subBussType"));
				tDefTrac.setBatchNo(pXML.get("batchNo"));
				tDefTrac.setBussNo(pXML.get("bussNo"));
				tDefTrac.setBussType(pXML.get("REQUEST_TYPE"));
				tDefTrac.setActionType(pXML.get("REQUEST_TYPE"));
				
				tDefActionTraceMapper.insertSelective(tDefTrac);
			}else{
				tDefTrac.setLastModifyTime(new Date());
			    tDefActionTraceMapper.updateByExampleSelective(tDefTrac, example2);
			}
		}
	public static void main(String[] args) {
		
	}
}
