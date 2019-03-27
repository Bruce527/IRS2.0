/**
 * 
 */
package com.sinosoft.ummp.application.sxei.shia;

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

import com.sinosoft.eos.model.SubmitModel;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.application.SqlParamService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.ummp.application.MsgClassService;
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

/**
 * 团单承保信息同步上传:特殊类处理
 * @author Darker.Wang
 * @date 2017-1-10 下午5:52:48
 * @company SINOSOFT
 */
@Service
public class SpeDeal_SHIAN020101 extends MsgClassService{
	private static Logger logger = Logger.getLogger(SpeDeal_SHIAN020101.class);
	@Autowired
	SequenceService sequenceService;
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
	/**
	 * 
	 */
	public SpeDeal_SHIAN020101() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#getSubmitData(com.sinosoft.ummp.domain.model.BussModelImpl, com.sinosoft.platform.core.domain.pojo.ParamPOJO)
	 */
	@Override
	public Object getSubmitData(BussModelImpl bmi, ParamPOJO pojo) {
		// TODO Auto-generated method stub
		System.out.println("我正在特殊处理：getBatchNo:"
		+pojo.getBatchNo()
		+" getBatchType:"+pojo.getBatchType()
		+" getBussType:"+pojo.getBussType());
		System.out.println(sequenceService.getMaxNo("MAXNO", 10));
		//TODO 承保异步拆单特殊处理业务
		String submitString = null;
		if(bmi.getFormatType().equals(SubmitModel.FORMAT_TYPE_XML)){
			bmi.setComId(pojo.getComId());
			try {
				submitString = getXml(bmi);
			} catch (CoreException e) {
				e.printStackTrace();
			}
			logger.debug("getSubmitData XML : \n"+submitString);
			return submitString;
		}else{
			return null;
		}
	}

	private String getXml(BussModelImpl bmi) throws CoreException {
		// TODO 生成报文
				System.out.println("===> XML Node Build ： "+bmi.getBussName()+" format ："+bmi.getFormatType());
				TDefBussXenginExample example = new TDefBussXenginExample();
				TDefBussXenginExample.Criteria criteria = example.createCriteria();
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

	private Element buildElement(String thisElementString,BigDecimal rootNodeId,Map<String,String> pValues) throws CoreException{
		// TODO 递归构造节点
		Element rootElement = DocumentHelper.createElement(thisElementString);
		System.out.println("======> "+rootElement.getName()+" is building ...");
		TDefMsgNodeExample example = new TDefMsgNodeExample();
		TDefMsgNodeExample.Criteria criteria = example.createCriteria();
		criteria.andNodePidEqualTo(rootNodeId);
		criteria.andRcStatusEqualTo(Short.parseShort("1"));
		example.setOrderByClause("NODE_NUM");
		List<TDefMsgNode> msgNodes = tDefMsgNodeMapper.selectByExample(example);
		String sql = getSqlWithParent(rootNodeId,pValues);
		if(sql == null || "".equals(sql.trim())){
			CoreException coreException = new CoreException();
			coreException.setMessage("build element exception cause node "+thisElementString+" is no match SQL ");
			throw coreException;
		}
		List<Map> maps = excuteNodeSql(sql);
		for(int i = 0; i < maps.size();i++){
			Map map = maps.get(i);//每一行的记录
			for(TDefMsgNode msgNode : msgNodes){
				
				BigDecimal nodeId = msgNode.getNodeId();
				String nodeCode = msgNode.getNodeCode();
				Short sonNodeType = msgNode.getSonNodeType();
				Element nodeE = DocumentHelper.createElement(nodeCode);
				String text = nodeCode;
				//如果查询的值不为空
				if(map != null){
					//TODO 如果获取到底文本为空，则默认赋值该节点为空
					text = ""+ map.get(nodeCode);
					if(text == null || "".equals(text) || "null".equals(text)){
						text = ""+ map.get(nodeCode.toUpperCase());
					}
					
					
					if(text != null && !"".equals(text)){
						//添加入参数传递下去，以便后续SQL可以从中获取值 
						pValues.put(nodeCode, text);
					}else{
						//重新赋值
						text = "";
					}
				}
				
				//过滤属性节点，减少与数据库的交互
				if(isAttribute(nodeCode)){
					//添加节点属性
					List<TDefMsgNodeAttri> rootNodeAttris = tDefMsgNodeAttriMapper.selectByNodeId(msgNode.getNodeId());
					if(rootNodeAttris != null && rootNodeAttris.size() > 0 ){
						for(TDefMsgNodeAttri nodeAttri : rootNodeAttris){
							String name = nodeAttri.getAttriName();
							String code = nodeAttri.getAttriCode();
							String value = nodeAttri.getAttriValue();
							nodeE.addAttribute(code, value);
						}
					}
				}
				// 客户异步上传添加BATCH_INFO下的SINGLE_INFO TJ
				if (thisElementString.equals("BATCH_INFO")) {
					if (nodeCode.equals("BUSINESS_SEQUENCE_NO")) {
						Element childElement = DocumentHelper
								.createElement("SINGLE_INFO");
						rootElement.add(childElement);
					}
					Element sonElement = (Element) rootElement.selectNodes(
							"SINGLE_INFO").get(i);
					if (sonNodeType != null && !"".equals(sonNodeType)
							&& Integer.parseInt(sonNodeType.toString()) == 1) {
						sonElement.add(buildElement(nodeCode, nodeId, pValues));
						continue;
					} else {
						nodeE.setText(text);
						sonElement.add(nodeE);
						continue;
					}
				}
				// 客户异步上传添加body下的customer_info TJ
				if (thisElementString.equals("BODY")) {
					if (nodeCode.equals("NAME")) {
						Element childElement = DocumentHelper
								.createElement("CUSTOMER_INFO");
						rootElement.add(childElement);
					}
					Element sonElement = (Element) rootElement.selectNodes(
							"CUSTOMER_INFO").get(i);
					if (sonNodeType != null && !"".equals(sonNodeType)
							&& Integer.parseInt(sonNodeType.toString()) == 1) {
						sonElement.add(buildElement(nodeCode, nodeId, pValues));
						continue;
					} else {
						nodeE.setText(text);
						sonElement.add(nodeE);
						continue;
					}
				}
				//递归构造子节点
				if(sonNodeType != null && !"".equals(sonNodeType) 
						&& Integer.parseInt(sonNodeType.toString()) == 1){
					rootElement.add(buildElement(nodeCode,nodeId,pValues));
				}else{
					nodeE.setText(text);
					rootElement.add(nodeE);
				}
			}
		}
		return rootElement;
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
	@SuppressWarnings("rawtypes")
	private List<Map> excuteNodeSql(String sql){
		SqlAdapter sqlAdapter = new SqlAdapter();
		sqlAdapter.setSql(sql);
		List<Map> maps = sqlAdapterMapper.excuteQuery(sqlAdapter);
		return maps;
	}
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

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#getDataClass()
	 */
	@Override
	public Class<?> getDataClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#getReturnData()
	 */
	@Override
	public Object getReturnData() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgClassService#returnDeal()
	 */
	@Override
	public boolean returnDeal() {
		// TODO Auto-generated method stub
		return false;
	}

}
