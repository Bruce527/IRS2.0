package com.sinosoft.ummp.application.rdsi.prp;

import java.io.IOException;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
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
 * 
 * @author gyas-itpingw

 */
@Service
public class DetailUploadRDeal implements ReturnDealService{
	
	@Autowired 
	SequenceService sequenceService;
	@Autowired
	TDefActionReturnMapper tDefActionReturnMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	TDefActionTraceMapper tDefActionTraceMapper;
	@Autowired
	TPrpLcpoltransactionReturnMapper tPrpLcpoltransactionReturnMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	
	Logger logger = Logger.getLogger(DetailUploadRDeal.class);
	
	public DetailUploadRDeal() {
		// TODO Auto-generated constructor stub
	}
	@Transactional
	@Override
	public boolean dealReturn(SubmitReturn sr, ParamPOJO pojo) {
		BussModel bussM=sr.getBussModel();//获得业务模型
		String subBussType=bussM.getSubBussType();//父级业务类型
		String operator=pojo.getUserCode();//用户
		Object obj=sr.getReturnObj();//获取xml文件
		String strXml="";
		if(strXml instanceof java.lang.String){
			strXml = (String) obj;//将报文转成字符串类型
			Map<String,String> faiMap=this.parseXML(strXml);
			String SerialNo=faiMap.get("SerialNo");//得到流水号，作为条件
			TDefActionReturn tDefActionReturn=new TDefActionReturn();
			tDefActionReturn.setStatus(faiMap.get("Status"));//添加状态
			tDefActionReturn.setBussType(faiMap.get("RequestType"));//添加请求类型
			tDefActionReturn.setQueryNo(faiMap.get("QueryNo"));//添加查询码
			String msg=faiMap.get("Msg");
			tDefActionReturn.setReturnMsg(msg);//添加返回信息
			System.out.println(faiMap.get("Msg"));
			tDefActionReturn.setPlatCom(pojo.getComId());//添加机构代码
			tDefActionReturn.setDataType(faiMap.get("DataType"));//添加数据类型
			tDefActionReturn.setOperator(operator);//添加用户
			
			if(subBussType!=null && !"".equals(subBussType)){
				tDefActionReturn.setSubBussType(subBussType);//添加父级业务类型
			}
			
			TDefActionReturnExample tDefActionReturnExample=new TDefActionReturnExample();
			tDefActionReturnExample.createCriteria().andActionNoEqualTo(SerialNo);//添加条件
			
			//update poltransaction
			String batchno=sr.getBussModel().getBatchNo();//得到批次号
			SqlAdapter sqlAdapter = new SqlAdapter();
			String sql="";
			if(faiMap.get("Status").equals("07080100")){
				sql="update t_prp_lcpoltransaction set stateflag='4' where batchno= '"+batchno+"'";
				System.out.println("sql-->"+sql);				
			}else if(faiMap.get("Status").equals("07080106")){
				sql="update t_prp_lcpoltransaction set stateflag='3' where batchno= '"+batchno+"'";
				System.out.println("sql-->"+sql);	
			}else{
				sql="update t_prp_lcpoltransaction set stateflag='3E' where batchno= '"+batchno+"'";
				System.out.println("sql-->"+sql);
			}
			System.out.println("- dealReturn : "+sql);
			sqlAdapter.setSql(sql);
			sqlAdapterMapper.excuteUpdate(sqlAdapter);
			
			//判断使用何种sql语句
			int result=tDefActionReturnMapper.countByExample(tDefActionReturnExample);
			System.out.println("tDefActionReturn记录:"+result);
			if(result > 0){
				tDefActionReturn.setLastModifyTime(new Date());//更新时一起更新最后修改时间
				System.out.println("****正在更新t_Def_Action_Return表数据***");
				int count=tDefActionReturnMapper.updateByExampleSelective(tDefActionReturn, tDefActionReturnExample);
				
				if(count>0){
					String flag=this.insertDataToTRACE(faiMap,sr,pojo);
					if(flag.equalsIgnoreCase("true")){
						return true;
					}
				}
			}else{
				tDefActionReturn.setActionNo(SerialNo);//添加流水号
				tDefActionReturn.setInsertTime(new Date());//添加插入时间
				tDefActionReturn.setLastModifyTime(new Date());//添加最后修改时间
				tDefActionReturn.setEsStatus((short) 1);//添加有效状态
				BigDecimal userSeq = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_RETURN");
				tDefActionReturn.setId(userSeq);
				System.out.println("****正在向t_Def_Action_Return表插入数据******");
				int count=tDefActionReturnMapper.insertSelective(tDefActionReturn);
				if(count>0){
					String flag=this.insertDataToTRACE(faiMap,sr,pojo);
					this.insertLCPOLTRANSACTION_RETURN(faiMap, sr, pojo);
					if(flag.equalsIgnoreCase("true")){
						return true;
					}
				}
			}
		}	
		return false;
	}
	
	/**
	 * insert or update table T_DEF_ACTION_TRACE
	 */
	@Transactional
	public String insertDataToTRACE(Map<String,String> map,SubmitReturn sr,ParamPOJO pojo){
		String flag="false";//标记
		
		TDefActionTrace tDefActionTrace=new TDefActionTrace();
		String SerialNo=map.get("SerialNo");//得到流水号，作为条件
		String msg=map.get("Msg");
		if(!"".equals(msg) && msg.equals("报文体标签:PDL-Body下的报文标签:BatchNo不存在或无值")){
			msg="BatchNo不存在或无值";
		}
		tDefActionTrace.setDataMsg(msg);//添加返回信息
		tDefActionTrace.setBussType(map.get("RequestType"));//添加请求类型
		tDefActionTrace.setPlatCom(pojo.getComId());//添加机构编码
		
		tDefActionTrace.setBatchNo(sr.getBussModel().getBatchNo());//添加批次号
		if(sr.getBussModel().getSubBussType()!=null && !"".equals(sr.getBussModel().getSubBussType())){
			tDefActionTrace.setSubBussType(sr.getBussModel().getSubBussType());//添加父级业务类型
		}
		tDefActionTrace.setBussNo(sr.getBussModel().getBussNo());//添加业务号
		tDefActionTrace.setBatchType(pojo.getBatchType());//添加批次类型
		tDefActionTrace.setOperator(pojo.getUserCode());//添加用户
		
		
		TDefActionTraceExample tDefActionTraceExample =new TDefActionTraceExample();
		tDefActionTraceExample.createCriteria().andActionNoEqualTo(SerialNo);//添加条件(流水号)
		
		//判断使用何种sql语句
		int result=tDefActionTraceMapper.countByExample(tDefActionTraceExample);
		System.out.println("tDefActionTrace记录:"+result);
		if(result > 0){
			tDefActionTrace.setLastModifyTime(new Date());//更新最后修改时间
			System.out.println("****正在更新t_Def_Action_Trace表数据*****");
			int count=tDefActionTraceMapper.updateByExampleSelective(tDefActionTrace, tDefActionTraceExample);//更新操作
			if(count > 0){
				return flag="true";
			}
		}else{
			tDefActionTrace.setActionNo(SerialNo);//添加流水号
			tDefActionTrace.setInsertTime(new Date());//插入时间
			tDefActionTrace.setLastModifyTime(new Date());//最后修改时间
			tDefActionTrace.setEsStatus((short) 1);//添加有效状态
			BigDecimal traceSeq = commonServiceMapper.getSeqValByName("SEQ_T_DEF_ACTION_TRACE");
			tDefActionTrace.setId(traceSeq);
			System.out.println("****正在向表t_Def_Action_Trace插入数据******");
			int count=tDefActionTraceMapper.insertSelective(tDefActionTrace);
			if(count > 0){
				return flag="true";
			}
		}
		
		return flag;
		
	}
	
	
	/**
	 * 解析报文
	 * @param strXml
	 * @return map
	 */
	public Map<String, String> parseXML(String rtXML) {
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

		return map;}
		/**
		 * insert into  T_PRP_LCPOLTRANSACTION_RETURN
		 */
		@Transactional
		public boolean insertLCPOLTRANSACTION_RETURN(Map<String,String> map,SubmitReturn sr,ParamPOJO pojo){
			TPrpLcpoltransactionReturn tPrpLcpoltransactionReturn=new TPrpLcpoltransactionReturn();
			
			tPrpLcpoltransactionReturn.setTransactionid(sr.getSubmitSerialNo());
			tPrpLcpoltransactionReturn.setBatchno(pojo.getBatchNo());
			//tPrpLcpoltransactionReturn.setBatchno(pojo.getCompanyCode());
			tPrpLcpoltransactionReturn.setBusstype(map.get("RequestType"));
			tPrpLcpoltransactionReturn.setQueryno(map.get("QueryNo"));
			//tPrpLcpoltransactionReturn.setBusstype(sr.getBussModel().);
			tPrpLcpoltransactionReturn.setErrinfopath(map.get("ErrInfoPath"));
			String msg=map.get("Msg");
			if(!"".equals(msg) && msg.equals("报文体标签:PDL-Body下的报文标签:BatchNo不存在或无值")){
				msg="BatchNo不存在或无值";
			}
			tPrpLcpoltransactionReturn.setMsg(msg);//添加返回信息
			tPrpLcpoltransactionReturn.setOperator(pojo.getUserCode());
			tPrpLcpoltransactionReturn.setSubbusstype(sr.getBussModel().getSubBussType());
			
			
			tPrpLcpoltransactionReturn.setMaketime(DateUtils.getCurrentTime());
			tPrpLcpoltransactionReturn.setModifydate(new Date());
			tPrpLcpoltransactionReturn.setModifytime(DateUtils.getCurrentTime());
			tPrpLcpoltransactionReturn.setMakedate(new Date());
			
			tPrpLcpoltransactionReturn.setStatus(map.get("Status"));
			if(map.get("Status").equals("07080100")){
				tPrpLcpoltransactionReturn.setStateflag("4");
			}else if(map.get("Status").equals("07080106")){
				tPrpLcpoltransactionReturn.setStateflag("3");
				System.out.println("DetailUpload:明细对账高峰延迟，10min后重新请求！");
				
			}else{
				tPrpLcpoltransactionReturn.setStateflag("3E");
			}
			
			 tPrpLcpoltransactionReturnMapper.insertSelective(tPrpLcpoltransactionReturn);
			return true;
		}
	}
	
	
