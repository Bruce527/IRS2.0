/**
 *   
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SqlParamService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.ummp.application.MsgNodeService;
import com.sinosoft.ummp.domain.mapper.TDefBussXenginMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodeAttriMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodeMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodesqlRelaMapper;
import com.sinosoft.ummp.domain.model.BussModelImpl;
import com.sinosoft.ummp.domain.model.TDefBussXengin;
import com.sinosoft.ummp.domain.model.TDefBussXenginExample;
import com.sinosoft.ummp.domain.model.TDefMsgNode;
import com.sinosoft.ummp.domain.model.TDefMsgNodeAttri;
import com.sinosoft.ummp.domain.model.TDefMsgNodeExample;
import com.sinosoft.ummp.domain.model.TDefMsgNodesqlRela;
import com.sinosoft.ummp.domain.model.TDefMsgNodesqlRelaExample;
import com.sinosoft.ummp.util.UMMPContext;

/**
 * 节点构造解析实现类
 * @author Darker.Wang
 * @date 2016-7-8 下午3:31:18
 * @company SINOSOFT
 */
@Service
public class MsgNodeServiceImpl extends MsgNodeService{

	@Autowired
	TDefMsgNodesqlRelaMapper tDefMsgNodesqlRelaMapper;
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	@Autowired
	TDefSqlParamsMapper tDefSqlParamsMapper;
	@Autowired
	TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired 
	TDefMsgNodeMapper tDefMsgNodeMapper;
	@Autowired
	TDefMsgNodeAttriMapper tDefMsgNodeAttriMapper;
	@Autowired
	TDefBussXenginMapper tDefBussXenginMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	SqlParamService sqlParamService;
	private BigDecimal comId;
	
	private static Logger logger = Logger.getLogger(MsgNodeServiceImpl.class);
	
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgNodeService#getXml(com.sinosoft.ummp.domain.model.BussModelImpl)
	 */
	public String getXml(BussModelImpl bmi) throws CoreException{
		
		// TODO Auto-generated method stub
		System.out.println("===> XML Node Build ： "+bmi.getBussName()+" format ："+bmi.getFormatType());
		TDefBussXenginExample example = new TDefBussXenginExample();
		TDefBussXenginExample.Criteria criteria = example.createCriteria();
		comId = bmi.getComId();
		criteria.andImplIdEqualTo(bmi.getImplId());
		criteria.andBussIdEqualTo(bmi.getBussId());
		//该业务对应的所有一节节点
		Document xmlDoc = DocumentHelper.createDocument();
		//获取标题头
		if(bmi.getIsTitle() != null && bmi.getTitleInfo()!= null){
			try {
				Document tDoc = DocumentHelper.parseText(bmi.getTitleInfo()+"<Root></Root>");
				XMLEncoding = tDoc.getXMLEncoding();
			} catch (DocumentException e) {
				//e.printStackTrace();
				return null;
			}
		}
		xmlDoc.setXMLEncoding(XMLEncoding);
		List<TDefBussXengin> bussXEngins = tDefBussXenginMapper.selectByExample(example);
		sqlParamService.getSysParams(pojo);//初始化系统参数
//		System.out.println("System Params ： "+SqlParamService.defaultParams);
		long s = System.currentTimeMillis();
		System.out.println("- buildElement start : "+s);
		for(TDefBussXengin bx : bussXEngins){
			BigDecimal rootNodeId = bx.getNodeId();
			logger.info("===> bilding element ："+rootNodeId +" and son's elements ");
			//1、获取一级节点信息
			TDefMsgNode rootNode = tDefMsgNodeMapper.selectByPrimaryKey(rootNodeId);
			String rootNodeCode = rootNode.getNodeCode();
			//上下文参数
			Map<String,String> contentParam = new HashMap<String,String>();
			
			//2、根据子节点递归构造节点
			contentParam.put(rootNodeCode, rootNodeCode);
			
			long ss = System.currentTimeMillis();
			System.out.println("- build Son's Element start : "+ss);
			Element rootElement = buildElement(rootNodeCode,rootNodeId,contentParam);
			System.out.println("- build Son's Element end and coust : "+(System.currentTimeMillis()-ss)+" HS");
			//3、构造节点属性
			List<TDefMsgNodeAttri> rootNodeAttris = tDefMsgNodeAttriMapper.selectByNodeId(rootNodeId);
			if(rootNodeAttris != null && rootNodeAttris.size() > 0 ){
				for(TDefMsgNodeAttri nodeAttri : rootNodeAttris){
					String code = nodeAttri.getAttriCode();
					String name = nodeAttri.getAttriName();
					String value = nodeAttri.getAttriValue();
					logger.debug("===> building element："+rootNodeCode+" 's attribute "+name+" [code:"+code+",value:"+value+"]");
					rootElement.addAttribute(code, value);
				}
			}
			xmlDoc.setRootElement(rootElement);
			rootElement = null;
		}
		System.out.println("- buildElement end and all    coust : "+(System.currentTimeMillis()-s)+" HS ");
		System.gc();
		return xmlDoc.asXML();
	}

	
	public String getJson(BussModelImpl bmi){
		logger.debug("JSON节点构造： "+bmi.getBussName()+" 格式："+bmi.getFormatType());
		return null;
	}

	/**
	 * @param bmi
	 * @return
	 */
	public String getTxt(BussModelImpl bmi) {
		// TODO Auto-generated method stub
		logger.debug("TXT节点构造： "+bmi.getBussName()+" 格式："+bmi.getFormatType());
		return null;
	}

	/**
	 * 根据平台处理空值问题
	 * @param input
	 * @param comId
	 * @return
	 */
	private String dealNull(String input,int comId){
		switch(comId){
			case UMMPContext.SUBMIT_PLAT_PRP :
				return input;
			case UMMPContext.SUBMIT_PLAT_SHIA :
				if(input == null || "NULL".equals(input) || "null".equals(input) || "".equals(input)){
					return "";
				}
				break;
			case UMMPContext.SUBMIT_PLAT_BJAI :
				return input;
			case UMMPContext.SUBMIT_PLAT_BJHI :
				return input;
			case UMMPContext.SUBMIT_PLAT_JSAP :
				return input;
			case UMMPContext.SUBMIT_PLAT_SDPT :
				return input;
			default :
				return input;
		}
		return input;
	}
	/**
	 * 构造子节点信息
	 * @param thisElementString
	 * @param rootNodeId
	 * @param pValues
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	private Element buildElement(String thisElementString,BigDecimal rootNodeId,Map<String,String> pValues) throws CoreException{
		Element rootElement = DocumentHelper.createElement(thisElementString);
		System.out.println("======> "+rootElement.getName()+" is building ...");
		TDefMsgNodeExample example = new TDefMsgNodeExample();
		TDefMsgNodeExample.Criteria criteria = example.createCriteria();
		criteria.andNodePidEqualTo(rootNodeId);
		criteria.andRcStatusEqualTo(Short.parseShort("1"));
		example.setOrderByClause("NODE_NUM");
//		long o = System.currentTimeMillis();
//		System.out.println("get nodes start : "+o);
		List<TDefMsgNode> msgNodes = tDefMsgNodeMapper.selectByExample(example);
//		System.out.println("get nodes end   : "+(System.currentTimeMillis()-o)+" HS");
//		long s = System.currentTimeMillis();
//		System.out.println("get node sql start : "+s);
		String sql = getSqlWithParent(rootNodeId,pValues);
//		System.out.println("get node sql end : "+(System.currentTimeMillis()-s)+" HS");
		if(sql == null || "".equals(sql.trim())){
			CoreException coreException = new CoreException();
			coreException.setMessage("build element exception cause node "+thisElementString+" is no match SQL ");
			throw coreException;
		}
//		long ss = System.currentTimeMillis();
//		System.out.println("excute node sql start : "+ss);
		List<Map> maps = excuteNodeSql(sql);
//		System.out.println("excute node sql end : "+(System.currentTimeMillis()-ss)+" HS");
//		long sss = System.currentTimeMillis();
//		System.out.println("to build node start : "+sss);
		for(int i = 0; i < maps.size();i++){
			Map map = maps.get(i);//每一行的记录
//			long ssss = System.currentTimeMillis();
//			System.out.println("the map row : "+i+" start "+ssss);
			for(TDefMsgNode msgNode : msgNodes){
//				long sssss = System.currentTimeMillis();
				
				BigDecimal nodeId = msgNode.getNodeId();
				String nodeCode = msgNode.getNodeCode();
				Short sonNodeType = msgNode.getSonNodeType();
				Element nodeE = DocumentHelper.createElement(nodeCode);
				String text = nodeCode;
//				System.out.println("bild node : "+nodeCode+" start "+sssss);
				//如果查询的值不为空
				if(map != null){
					//TODO 如果获取到底文本为空，则默认赋值该节点为空
					text = ""+ map.get(nodeCode);
					if(text == null || "".equals(text) || "null".equals(text)){
						text = ""+ map.get(nodeCode.toUpperCase());
					}
					
//					不用如下方法，配置SQL必须有AS
//					若用，XML值不能为空，此部分放开请慎重
//					if(text == null || "".equals(text) || "null".equals(text)){
//						text = ""+ map.values().toArray()[0];
//					}
					
					if(text != null && !"".equals(text)){
						//添加入参数传递下去，以便后续SQL可以从中获取值 
						pValues.put(nodeCode, text);
					}else{
						//重新赋值
						text = "null";
					}
				}
				text = dealNull(text,comId.intValue());
//				logger.debug("======> nodeId:"+nodeId+" nodeCode:"+nodeCode+" sonNodeType:"+sonNodeType+" text:"+text);
				
				//过滤属性节点，减少与数据库的交互
				if(isAttribute(nodeCode)){
					//添加节点属性
//					long l = System.currentTimeMillis();
//					System.out.println("add node attribute start "+l);
					List<TDefMsgNodeAttri> rootNodeAttris = tDefMsgNodeAttriMapper.selectByNodeId(msgNode.getNodeId());
					if(rootNodeAttris != null && rootNodeAttris.size() > 0 ){
						for(TDefMsgNodeAttri nodeAttri : rootNodeAttris){
							String name = nodeAttri.getAttriName();
							String code = nodeAttri.getAttriCode();
							String value = nodeAttri.getAttriValue();
							nodeE.addAttribute(code, value);
						}
					}
//					System.out.println("add node attribute end  "+(System.currentTimeMillis()-l)+" HS");
				}
				
				if(comId.intValue() ==UMMPContext.SUBMIT_PLAT_SHIA){
					//核保、承保、保全添加INSURED_LIST下的子节点INSURED
					if(thisElementString.equals("INSURED_LIST") && !nodeCode.equals("INSURED_INFO")){
						if(nodeCode.equals("CUTOMER_SEQUENCE_NO")){
							Element childElement = DocumentHelper.createElement("INSURED");
							rootElement.add(childElement);
						}
						Element sonElement = (Element)rootElement.selectNodes("INSURED").get(i);
						 if(sonNodeType != null && !"".equals(sonNodeType) 
									&& Integer.parseInt(sonNodeType.toString()) == 1){
							
							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
							 continue;
							}else{
								nodeE.setText(text);
								sonElement.add(nodeE);
								continue;
							}
					}
					//个险核保、承保、保全添加BENEFICIARY_LIST下的子节点BENEFICIARY
					if(thisElementString.equals("BENEFICIARY_LIST")){
						if(nodeCode.equals("CUTOMER_SEQUENCE_NO")){
							Element childElement = DocumentHelper.createElement("BENEFICIARY");
							rootElement.add(childElement);
						}
						Element sonElement = (Element)rootElement.selectNodes("BENEFICIARY").get(i);
						 if(sonNodeType != null && !"".equals(sonNodeType) 
									&& Integer.parseInt(sonNodeType.toString()) == 1){
							
							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
							 continue;
							}else{
								nodeE.setText(text);
								sonElement.add(nodeE);
								continue;
							}
					}
					//添加COVERAGE_LIST下的子节点COVERAGE_INFO
					if(thisElementString.equals("COVERAGE_LIST")){
						if(nodeCode.equals("COM_COVERAGE_CODE")){
							Element childElement = DocumentHelper.createElement("COVERAGE_INFO");
							rootElement.add(childElement);
						}
						Element sonElement = (Element)rootElement.selectNodes("COVERAGE_INFO").get(i);
						 if(sonNodeType != null && !"".equals(sonNodeType) 
									&& Integer.parseInt(sonNodeType.toString()) == 1){
							
							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
							 continue;
							}else{
								nodeE.setText(text);
								sonElement.add(nodeE);
								continue;
							}
					}
					//保全添加POLICY_COVERAGE_LIST的子节点POLICY_COVERAGE_INFO
					if(thisElementString.equals("POLICY_COVERAGE_LIST")){
						if(nodeCode.equals("COM_COVERAGE_CODE")){
							Element childElement = DocumentHelper.createElement("POLICY_COVERAGE_INFO");
							rootElement.add(childElement);
						}
						Element sonElement = (Element)rootElement.selectNodes("POLICY_COVERAGE_INFO").get(i);
						 if(sonNodeType != null && !"".equals(sonNodeType) 
									&& Integer.parseInt(sonNodeType.toString()) == 1){
							
							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
							 continue;
							}else{
								nodeE.setText(text);
								sonElement.add(nodeE);
								continue;
							}
					}
					//赔案信息添加DISEASE_LIST的子节点DISEASE_CODE
					if(thisElementString.equals("DISEASE_LIST")){
						if(nodeCode.equals("DISEASE_CODE")){
							Element childElement = DocumentHelper.createElement("DISEASE_INFO");
							rootElement.add(childElement);
						}
						Element sonElement = (Element)rootElement.selectNodes("DISEASE_INFO").get(i);
						 if(sonNodeType != null && !"".equals(sonNodeType) 
									&& Integer.parseInt(sonNodeType.toString()) == 1){
							
							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
							 continue;
							}else{
								nodeE.setText(text);
								sonElement.add(nodeE);
								continue;
							}
					}
					//个险理赔添加POLICY_LIST的子节点POLICY_INFO
					if(thisElementString.equals("POLICY_LIST")){
						if(nodeCode.equals("POLICY_SEQUENCE_NO")){
							Element childElement = DocumentHelper.createElement("POLICY_INFO");
							rootElement.add(childElement);
						}
						Element sonElement = (Element)rootElement.selectNodes("POLICY_INFO").get(i);
						 if(sonNodeType != null && !"".equals(sonNodeType) 
									&& Integer.parseInt(sonNodeType.toString()) == 1){
							
							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
							 continue;
							}else{
								nodeE.setText(text);
								sonElement.add(nodeE);
								continue;
							}
					}
//					if(thisElementString.equals("BATCH_INFO")){
//						if(nodeCode.equals("BUSINESS_SEQUENCE_NO")){
//							Element childElement = DocumentHelper.createElement("SINGLE_INFO");
//							rootElement.add(childElement);
//						}
//						Element sonElement = (Element)rootElement.selectNodes("SINGLE_INFO").get(i);
//						 if(sonNodeType != null && !"".equals(sonNodeType) 
//									&& Integer.parseInt(sonNodeType.toString()) == 1){
//							
//							 sonElement.add(buildElement(nodeCode,nodeId,pValues));
//							 continue;
//							}else{
//								nodeE.setText(text);
//								sonElement.add(nodeE);
//								continue;
//							}
//					}
					
				}
				//递归构造子节点
				if(sonNodeType != null && !"".equals(sonNodeType) 
						&& Integer.parseInt(sonNodeType.toString()) == 1){
					rootElement.add(buildElement(nodeCode,nodeId,pValues));
				}else{
					nodeE.setText(text);
					rootElement.add(nodeE);
				}
//				System.out.println("bild node : "+nodeCode+" end "+(System.currentTimeMillis()-sssss));
			}
//			System.out.println("the map row : "+i+" end "+(System.currentTimeMillis()-ssss));
//			System.gc();
		}
//		System.out.println("to build node end : "+(System.currentTimeMillis()-sss)+" HS");
		return rootElement;
	}
	/**
	 * 需要添加属性的单独拿出来，减少与数据库的交互，后期如果新增平台，需要修改该方法
	 * @param nodeCode
	 * @return
	 */
	private boolean isAttribute(String nodeCode){
		//保单登记节点无属性
		if(nodeCode.equals("PACKET")){//上海人身险根节点有属性
			return true;
		}
		if(nodeCode.equals("Packet")){//江苏中介平台、山东预警根节点有属性
			return true;
		}
		return false;
	}
	/**
	 * 执行SQL
	 * @param sql
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private List<Map> excuteNodeSql(String sql){
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> maps = sqlAdapterMapper.excuteQuery(sqlAdapter);
		return maps;
	}
	
	/**
	 * 根据SQLID获取对应的SQL(已对SQL参数进行赋值，可以直接使用)
	 * @param rootNodeId
	 * @param pParam
	 * @return
	 */
	private String getSqlWithParent(BigDecimal rootNodeId,Map<String,String> pParam){
		TDefMsgNodesqlRelaExample example = new TDefMsgNodesqlRelaExample();
		TDefMsgNodesqlRelaExample.Criteria criterria = example.createCriteria();
		criterria.andNodeIdEqualTo(rootNodeId);
		criterria.andRcStatusEqualTo(Short.parseShort("1"));
		List<TDefMsgNodesqlRela> tDefMsgNodesqlRelas = tDefMsgNodesqlRelaMapper.selectByExample(example);
		if(tDefMsgNodesqlRelas == null || tDefMsgNodesqlRelas.size() < 1){
			return null;
		}
		//TODO 获取参数的例子
		BigDecimal sqlId = tDefMsgNodesqlRelas.get(0).getSqlId();
		//获取SQL对应的参数
		Map<String,String> sqlParams = new HashMap<String,String>();
		sqlParams.putAll(getDefaultParams());
		sqlParams.putAll(pParam);
		String sql = sqlParamService.getSql(sqlId,pojo,sqlParams);
		return sql;
	}
}
