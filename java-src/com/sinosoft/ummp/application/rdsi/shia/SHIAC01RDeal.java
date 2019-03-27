package com.sinosoft.ummp.application.rdsi.shia;

import java.io.File;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.sinosoft.ummp.domain.mapper.TShiaSynchroRiskInfoMapper;
import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefActionTraceExample;
import com.sinosoft.ummp.domain.model.TShiaSynchroRiskInfo;

/**
 * 个险理赔信息同步上传结果返回
 * @author sendylou
 * @date 2016/09/21
 * @company sinosoft
 *
 */

@Service
public class SHIAC01RDeal implements ReturnDealService {

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
	
	@Override
	@Transactional
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		Object obj = sr.getReturnObj();
		String rtXml = null;
		if(obj instanceof java.lang.String){
			rtXml = (String) obj;
		}
		BussModel model = sr.getBussModel();
		map.put("actionNo", sr.getSubmitSerialNo());
		map.put("subBussType", model.getSubBussType());
		map.put("batchNo", model.getBatchNo());
		map.put("comId", model.getComId().toString());
		map.put("bussNo", model.getBussNo());
		map.put("bussType", model.getBussType());
		map.put("operator", pojo.getUserCode());
		map.put("batchType", pojo.getBatchType());
		StringReader reader = new StringReader(rtXml);
		InputSource is = new InputSource(reader);
		SAXReader saxReader = new  SAXReader();
		try {
			Document doc = saxReader.read(is);
			//获得根目录,从根目录遍历获得所有元素内容
			Element root = doc.getRootElement();
			for( Iterator<?> a = root.elementIterator();a.hasNext();){
				Element itemEle = (Element) a.next();
				if(itemEle.getText() != null){
					map.put(itemEle.getName(), itemEle.getTextTrim());
				}
				for(Iterator<?> b = itemEle.elementIterator();b.hasNext();){
					Element itemEle1 = (Element) b.next();
					if(itemEle1.getText() != null){
						map.put(itemEle1.getName(), itemEle1.getTextTrim());
					}
					for(Iterator<?> c = itemEle1.elementIterator();c.hasNext();){
						Element itemEle2 = (Element)c.next();
						if(itemEle2.getText() != null){
							map.put(itemEle2.getName(), itemEle2.getTextTrim());
						}
						for(Iterator<?> d = itemEle2.elementIterator();d.hasNext();){
							Element itemEle3 = (Element)d.next();
							if(itemEle3.getText() != null){
								map.put(itemEle3.getName(), itemEle3.getTextTrim());
							}
							for(Iterator<?> e = itemEle3.elementIterator();e.hasNext();){
								Element itemEle4 = (Element)e.next();
								if(itemEle4.getText() != null){
									map.put(itemEle4.getName(), itemEle4.getTextTrim());
								}
								for(Iterator<?> g = itemEle4.elementIterator();g.hasNext();){
									Element itemEle5 = (Element)g.next();
									if(itemEle5.getText() != null){
										map.put(itemEle5.getName(), itemEle5.getTextTrim());
									}
									for(Iterator<?> h = itemEle5.elementIterator();h.hasNext();){
										Element itemEle6 = (Element)h.next();
										if(itemEle6.getText() != null){
											map.put(itemEle6.getName(), itemEle6.getTextTrim());
											//通过序列自动产生ID
											map.put("ID", sequenceService.getSeqValByName("SEQ_T_SHIA_SYNCHRO_RISK_INFO"));
										}
									}
									if(map.get("RESPONSE_CODE").equals("1"))
									{
										dealRiskInfo(map);
									}
								}
							}
						}
					}
				}
			}
		dealReturnTable(map);
		} catch (DocumentException e) {
			e.printStackTrace();
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
		dealLcpoltransaction(map);
	}
	
	private void dealLcpoltransaction(Map<String, String> map) {
		SqlAdapter sqlAdapter = new SqlAdapter();
		String stateFlag="";
		if(map.get("RESPONSE_CODE").equals("1")){
			 stateFlag = "6";
		}else{
			stateFlag = "6E";
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
			record.setPolicySequenceNo(map.get("CLAIM_SEQUENCE_NO"));//个险理赔编码
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
			record.setRiskType("1");//1-标识个险 2-标识团险
			tShiaSynchroRiskInfoMapper.insertSelective(record);
		} catch (ParseException e) {
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
		tDefTrace.setStandby1(map.get("CLAIM_SEQUENCE_NO"));
		tDefTrace.setBussType("LP02");
		String stateFlag="";
		if(map.get("RESPONSE_CODE").equals("1")){
			 stateFlag = "6";
		}else{
			stateFlag = "6E";
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
		tDefReturn.setStandby1(map.get("TASK_NO"));
		tDefReturn.setStatus(map.get("RESPONSE_CODE"));
		tDefReturn.setReturnMsg(map.get("ERROR_MESSAGE"));
		tDefReturn.setQueryNo(map.get("CLAIM_SEQUENCE_NO"));
		TDefActionReturnExample example = new TDefActionReturnExample();
		example.createCriteria().andActionNoEqualTo(map.get("actionNo"));
		//判断使用何种sql语句
		int result = tDefActionReturnMapper.countByExample(example);
		//System.out.println("tDefActionTrace记录:"+result);
		if(result > 0){
			tDefReturn.setLastModifyTime(new Date());//更新最后修改时间
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
	 * main方法
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		SAXReader reader = new SAXReader();
		reader.setEncoding("utf-8");
		File f = new File("D:\\个险理赔信息同步上传结果返回.xml");
		try {
			Document doc = reader.read(f);
			Element root = doc.getRootElement();
			for( Iterator<?> a = root.elementIterator();a.hasNext();){
				Element itemEle = (Element) a.next();
				if(itemEle.getText() != null){
					map.put(itemEle.getName(), itemEle.getTextTrim());
				}
				for(Iterator<?> b = itemEle.elementIterator();b.hasNext();){
					Element itemEle1 = (Element) b.next();
					if(itemEle1.getText() != null){
						map.put(itemEle1.getName(), itemEle1.getTextTrim());
					}
					for(Iterator<?> c = itemEle1.elementIterator();c.hasNext();){
						Element itemEle2 = (Element)c.next();
						if(itemEle2.getText() != null){
							map.put(itemEle2.getName(), itemEle2.getTextTrim());
						}
						for(Iterator<?> d = itemEle2.elementIterator();d.hasNext();){
							Element itemEle3 = (Element)d.next();
							if(itemEle3.getText() != null){
								map.put(itemEle3.getName(), itemEle3.getTextTrim());
							}
							for(Iterator<?> e = itemEle3.elementIterator();e.hasNext();){
								Element itemEle4 = (Element)e.next();
								if(itemEle4.getText() != null){
									map.put(itemEle4.getName(), itemEle4.getTextTrim());
								}
								for(Iterator<?> g = itemEle4.elementIterator();g.hasNext();){
									Element itemEle5 = (Element)g.next();
									if(itemEle5.getText() != null){
										map.put(itemEle5.getName(), itemEle5.getTextTrim());
									}
									for(Iterator<?> h = itemEle5.elementIterator();h.hasNext();){
										Element itemEle6 = (Element)h.next();
										if(itemEle6.getText() != null){
											map.put(itemEle6.getName(), itemEle6.getTextTrim());
										}
									}
								}
							}
						}
					}
				}
			}
			System.out.println(map.get("REQUEST_TYPE"));
			System.out.println(map.get("TASK_NO"));
			System.out.println(map.get("RESPONSE_CODE"));
			System.out.println(map.get("ERROR_MESSAGE"));
			System.out.println(map.get("CLAIM_SEQUENCE_NO"));
			System.out.println(map.get("CUTOMER_SEQUENCE_NO"));
			System.out.println(map.get("START_TIME"));
			System.out.println(map.get("END_TIME"));
			System.out.println(map.get("ALL_LIFE_SUM_INSURED"));
			System.out.println(map.get("ALL_ACCIDENT_SUM_INSURED"));
			System.out.println(map.get("ALL_HEALTH_SUM_INSURED"));
			System.out.println(map.get("ALL_OLD_SUM_INSURED"));
			System.out.println(map.get("ALL_OTHER_SUM_INSURED"));
			System.out.println(map.get("ALL_HOSPITAL_ALLOWANCE"));
			System.out.println(map.get("ALL_CLAIM_AMOUNT"));
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
