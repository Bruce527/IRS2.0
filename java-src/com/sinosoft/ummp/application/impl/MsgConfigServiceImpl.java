/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.application.SqlUtilService;
import com.sinosoft.platform.core.domain.mapper.TDefPlatComMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.domain.model.TDefSqlParamsExample;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.NodeAttri;
import com.sinosoft.platform.core.util.NodeParam;
import com.sinosoft.platform.core.util.NodeTree;
import com.sinosoft.ummp.application.DTOAnalizyService;
import com.sinosoft.ummp.application.MsgConfigService;
import com.sinosoft.ummp.application.MsgQueryService;
import com.sinosoft.ummp.domain.mapper.TDefBussImplMapper;
import com.sinosoft.ummp.domain.mapper.TDefBussModelMapper;
import com.sinosoft.ummp.domain.mapper.TDefBussXenginMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodeAttriMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodeMapper;
import com.sinosoft.ummp.domain.mapper.TDefMsgNodesqlRelaMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeAttriMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeParamMapper;
import com.sinosoft.ummp.domain.model.TDefBussImpl;
import com.sinosoft.ummp.domain.model.TDefBussImplExample;
import com.sinosoft.ummp.domain.model.TDefBussModel;
import com.sinosoft.ummp.domain.model.TDefBussXengin;
import com.sinosoft.ummp.domain.model.TDefBussXenginExample;
import com.sinosoft.ummp.domain.model.TDefMsgNode;
import com.sinosoft.ummp.domain.model.TDefMsgNodeAttri;
import com.sinosoft.ummp.domain.model.TDefMsgNodeAttriExample;
import com.sinosoft.ummp.domain.model.TDefMsgNodesqlRela;
import com.sinosoft.ummp.domain.model.TDefMsgNodesqlRelaExample;
import com.sinosoft.ummp.domain.model.TTempNode;
import com.sinosoft.ummp.domain.model.TTempNodeAttri;
import com.sinosoft.ummp.domain.model.TTempNodeAttriExample;
import com.sinosoft.ummp.domain.model.TTempNodeExample;
import com.sinosoft.ummp.domain.model.TTempNodeParam;
import com.sinosoft.ummp.domain.model.TTempNodeParamExample;
import com.sinosoft.ummp.domain.pojo.MsgConfigPOJO;
import com.sinosoft.ummp.domain.pojo.MsgQueryPOJO;

/**
 * 报文配置服务实现
 * @author Darker.Wang
 * @date 2016-5-24 下午12:15:27
 */
@Service
public class MsgConfigServiceImpl implements MsgConfigService {

	private static final Logger logger = Logger.getLogger(MsgConfigServiceImpl.class);
	
	@Autowired
	TDefPlatComMapper tDefPlatComMapper;
	@Autowired
	TDefMsgNodesqlRelaMapper tDefMsgNodesqlRelaMapper;
	//SQL模块Mapper
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	@Autowired
	TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired
	TDefSqlParamsMapper tDefSqlParamsMapper;
	//业务类型模块Mapper
	@Autowired
	TDefBussImplMapper tDefBussImplMapper;
	@Autowired
	TDefBussModelMapper tDefBussModelMapper;
	@Autowired
	TDefBussXenginMapper tDefBussXenginMapper;
	//临时节点模块Mapper
	@Autowired
	TTempNodeMapper tTempNodeMapper;
	@Autowired
	TTempNodeAttriMapper tTempNodeAttriMapper;
	@Autowired
	TTempNodeParamMapper tTempNodeParamMapper;
	@Autowired
	TDefMsgNodeMapper tDefMsgNodeMapper;
	@Autowired
	TDefMsgNodeAttriMapper tDefMsgNodeAttriMapper;
	//公共模块服务类
	@Autowired
	SequenceService sequenceService;
	@Autowired
	CodeQueryService codeQueryService;
	@Autowired
	DTOAnalizyService dTOAnalizyService;
	@Autowired
	MsgQueryService msgQueryService;
	@Autowired
	SqlUtilService sqlUtilService;
	//保存所有的集合
	List<TDefMsgNode> tMsgNodes = new ArrayList<TDefMsgNode>();
	List<TDefMsgNodeAttri> tMsgNodeAttris = new ArrayList<TDefMsgNodeAttri>();
	List<TDefMsgNodesqlRela> nodeSqlRelas = new ArrayList<TDefMsgNodesqlRela>();
	List<TDefSql> sqls = new ArrayList<TDefSql>();
	List<TDefSqlInfo> sqlInfos = new ArrayList<TDefSqlInfo>();
	List<TDefSqlParams> sqlParams = new ArrayList<TDefSqlParams>();
	List<TDefBussXengin> bussXEngins = new ArrayList<TDefBussXengin>();
	List<TDefBussModel> bms = new ArrayList<TDefBussModel>();
	List<TDefBussImpl> bis = new ArrayList<TDefBussImpl>();
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sinosoft.ummp.application.SubmitConfigService#listPlats()
	 */
	@Override
	public List<TDefPlatCom> listPlats() {
		return tDefPlatComMapper.selectByExample(null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sinosoft.ummp.application.SubmitConfigService#listPlatsByRole()
	 */
	@Override
	public List<TDefPlatCom> listPlatsByUserCode(String userCode) {
		// TODO Auto-generated method stub
		List<TDefPlatCom> coms = tDefPlatComMapper.selectByUserCode(userCode);
		return coms;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#buildSonNode(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public List<NodeTree> buildSonNode(String nodeCode, String content,
			String type) throws SQLException {
		// TODO Auto-generated method stub
		List<NodeTree> roots = new ArrayList<NodeTree>();
		if ("1".equals(type)) {
			// sql方式
			List<NodeTree> children = new ArrayList<NodeTree>();
			List<String> rootTexts;
			rootTexts = sqlUtilService.getSqlSrcInfo(content);
			// 构造子节点
			for (String text : rootTexts) {
				NodeTree nodeTree = new NodeTree();
				nodeTree.setText(text);
				children.add(nodeTree);
			}
			// 返回准备
			NodeTree root = new NodeTree();
			root.setText(nodeCode);
			root.setChildren(children);

			roots.add(root);
		} else if ("2".equals(type)) {
			// 自定义方式

		} else {
			logger.info("不支持SQL构造类型：" + type);
		}

		return roots;
	}

	/**
	 * 获取临时子节点
	 * 
	 * @return
	 */
	public List<NodeTree> getNodeRootFromTemp() {
		List<TTempNode> nodeRoots = null;
		nodeRoots = tTempNodeMapper.selectTempRootNode();
		List<NodeTree> nodeRootTrees = new ArrayList<NodeTree>();
		for (TTempNode node : nodeRoots) {
			NodeTree nodeTree = new NodeTree();
			nodeTree.setId(node.getId());
			nodeTree.setText(node.getNodeCode()+" "+node.getNodeName());
			nodeRootTrees.add(nodeTree);
		}
		return nodeRootTrees;
	}

	public List<NodeTree> getTempNodeTreeByRootId(Integer id) {
		List<NodeTree> nodeTrees = getTempNodeByFId(id);
		return nodeTrees;
	}

	/**
	 * 从临时表获取对应的节点信息
	 * 
	 * @param id
	 * @param fromTable
	 *            TEMP-临时表
	 * @return
	 */
	private List<NodeTree> getTempNodeByFId(Integer fid) {
		TTempNodeExample nodeExample = new TTempNodeExample();
		nodeExample.createCriteria().andFidEqualTo(fid);
		List<TTempNode> tTempNodes = tTempNodeMapper
				.selectByExample(nodeExample);
		List<NodeTree> nodeRootTrees = new ArrayList<NodeTree>();
		for (TTempNode node : tTempNodes) {
			Integer id = node.getId();
			NodeTree nodeTree = new NodeTree();
			nodeTree.setId(id);
			nodeTree.setText(node.getNodeCode());
			// nodeTree.setConNodeType(node.getSonNodeType());
			// nodeTree.setSonNodeContent(node.getSonNodeContent());
			nodeTree.setAttributes(getTempNodeAttriById(id));
			nodeTree.setParameters(getTempNodeParamById(id));
			nodeRootTrees.add(nodeTree);
		}
		return nodeRootTrees;
	}

	/**
	 * 从正常表获取对应的节点信息
	 * 
	 * @param id
	 * @param fromTable
	 *            TEMP-临时表
	 * @return
	 */
	public List<NodeTree> getMsgNodeByFId(Integer fid) {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#getTempNodeInfo(java.util.List)
	 */
	@Override
	public List<NodeTree> getTempNodeList(List<Integer> ids) {
		List<NodeTree> nodeTress = new ArrayList<NodeTree>();
		for (Integer id : ids) {
			nodeTress.add(getTempNodeById(id));
		}
		return nodeTress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sinosoft.ummp.application.SubmitConfigService#getTempNodeTreeById()
	 */
	@Override
	public NodeTree getTempNodeById(Integer id) {
		// TODO Auto-generated method stub
		List<TTempNode> tTempNodes = tTempNodeMapper.selecteByIdRecurs(id);
		for (TTempNode node : tTempNodes) {
			if(id.equals(node.getId())){
				NodeTree nodeTree = new NodeTree();
				nodeTree.setId(id);
				nodeTree.setText(node.getNodeCode());
				nodeTree.setFid(node.getFid());
//				nodeTree.setConNodeType(node.getSonNodeType());
//				nodeTree.setSonNodeContent(node.getSonNodeContent());
//				nodeTree.setAttributes(getTempNodeAttriById(id));
//				nodeTree.setParameters(getTempNodeParamById(id));
				nodeTree.setChildren(getNodeTreeChildren(id,tTempNodes));// 设置子类
				return nodeTree;
			}
		}
		return null;
	}

	private List<NodeTree> getNodeTreeChildren(Integer id,List<TTempNode> tTempNodes){
		List<NodeTree> nodeTrees = new ArrayList<NodeTree>();
		for (TTempNode node : tTempNodes) {
			if(id.equals(node.getFid())){
				NodeTree nodeTree = new NodeTree();
				nodeTree.setId(node.getId());
				nodeTree.setText(node.getNodeCode());
				nodeTree.setFid(node.getFid());
//				nodeTree.setConNodeType(node.getSonNodeType());
//				nodeTree.setSonNodeContent(node.getSonNodeContent());
//				nodeTree.setAttributes(getTempNodeAttriById(id));
//				nodeTree.setParameters(getTempNodeParamById(id));
				nodeTree.setChildren(getNodeTreeChildren(node.getId(),tTempNodes));
				nodeTrees.add(nodeTree);
			}
		}
		return nodeTrees;
	}
	/**
	 * 获取节点属性
	 * 
	 * @param id
	 * @return
	 */
	public List<NodeAttri> getTempNodeAttriById(Integer id) {
		List<NodeAttri> nodeAttris = new ArrayList<NodeAttri>();
		// 属性
		TTempNodeAttriExample attriExample = new TTempNodeAttriExample();
		com.sinosoft.ummp.domain.model.TTempNodeAttriExample.Criteria attriCriteria 
		= attriExample
				.createCriteria();
		attriCriteria.andNodeIdEqualTo(id);
		List<TTempNodeAttri> tTempNodeAttris = tTempNodeAttriMapper
				.selectByExample(attriExample);
		for (TTempNodeAttri attri : tTempNodeAttris) {
			NodeAttri nodeAttri = new NodeAttri();
			nodeAttri.setId(attri.getId());
			nodeAttri.setCode(attri.getAttriCode());
			nodeAttri.setName(attri.getAttriName());
			nodeAttri.setType(attri.getAttriType());
			nodeAttri.setValue(attri.getAttriValue());
			nodeAttris.add(nodeAttri);
		}
		return nodeAttris;
	}

	/**
	 * 获取节点参数
	 * 
	 * @param id
	 * @return
	 */
	public List<NodeParam> getTempNodeParamById(Integer id) {
		List<NodeParam> nodeParams = new ArrayList<NodeParam>();
//		// 参数
//		TTempNodeParamExample paramExample = new TTempNodeParamExample();
//		TTempNodeParamExample.Criteria paramCriteria = paramExample.createCriteria();
//		paramCriteria.andNodeIdEqualTo(id);
//		List<TTempNodeParam> tTempNodeParams = tTempNodeParamMapper
//				.selectByExample(paramExample);
		//系统默认
		List<TTempNodeParam> tTempNodeParams = tTempNodeParamMapper.selectAllByNodeId(id);
		for (TTempNodeParam param : tTempNodeParams) {
			NodeParam nodeParam = new NodeParam();
			nodeParam.setId(param.getId());
			nodeParam.setCode(param.getParamCode());
			nodeParam.setName(param.getParamName());
			nodeParam.setValue(param.getParamValue());
			nodeParam.setType(param.getParamType());
			nodeParam.setValueType(param.getParamValueType());
			nodeParam.setSubType(param.getParamSubType());
			nodeParams.add(nodeParam);
			
		}
		return nodeParams;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#getNodeSql(java.lang.Integer)
	 */
	@Override
	public Map<String, String> getNodeSql(Integer id) {
		Map<String, String> rtvMap = tTempNodeMapper.selectNodeSqlInfo(id);
		return rtvMap;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#saveTempNodeAttri(com.sinosoft.ummp.domain
	 * .model.TTempNodeAttri)
	 */
	@Override
	public int saveTempNodeAttri(int type, TTempNodeAttri nodeAttri) {
		// TODO Auto-generated method stub
		int i = 0;
		if (type == 0) {
			TTempNodeAttriExample example = new TTempNodeAttriExample();
			com.sinosoft.ummp.domain.model.TTempNodeAttriExample.Criteria criteria = example
					.createCriteria();
			// 节点存在方进行返回-1
			if (nodeAttri.getId() != null && !"".equals(nodeAttri.getId())) {
				criteria.andIdEqualTo(nodeAttri.getId());
				criteria.andAttriCodeEqualTo(nodeAttri.getAttriCode());
				List<TTempNodeAttri> exists = tTempNodeAttriMapper
						.selectByExample(example);
				if (exists != null && exists.size() > 0) {
					return -1;// 已存在
				}
			}
			Integer id = Integer.parseInt(sequenceService
					.getSeqValByName("SEQ_T_TEMP_NODE_ATTRI"));
			nodeAttri.setId(id);
			i = tTempNodeAttriMapper.insert(nodeAttri);
		}
		if (type == 1) {
			i = tTempNodeAttriMapper.updateByPrimaryKey(nodeAttri);
		}
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#saveTempNodeParam(com.sinosoft.ummp.domain
	 * .model.TTempNodeParam)
	 */
	@Override
	public int saveTempNodeParam(int type, TTempNodeParam nodeParam) {
		// TODO Auto-generated method stub
		int i = 0;
		if (type == 0) {//新增
			TTempNodeParamExample example = new TTempNodeParamExample();
			TTempNodeParamExample.Criteria criteria = example.createCriteria();
			
			if (nodeParam.getId() != null && !"".equals(nodeParam.getId())) {
				criteria.andIdEqualTo(nodeParam.getId());
			}
			if(nodeParam.getParamCode() != null && !"".equals(nodeParam.getParamCode())){
				criteria.andParamCodeEqualTo(nodeParam.getParamCode());
			}
			if(nodeParam.getParamSubType() != null && !"".equals(nodeParam.getParamSubType())){
				criteria.andParamSubTypeEqualTo(nodeParam.getParamSubType());
			}
			//criteria.andParamNameEqualTo(nodeParam.getParamName());
			List<TTempNodeParam> exists = tTempNodeParamMapper.selectByExample(example);
			if (exists != null && exists.size() > 0) {
				return -1;// 已存在
			}
			Integer id = Integer.parseInt(sequenceService.getSeqValByName("SEQ_T_TEMP_NODE_PARAM"));
			nodeParam.setId(id);
			return tTempNodeParamMapper.insert(nodeParam);
		}
		if (type == 1) {//修改
			TTempNodeParamExample example = new TTempNodeParamExample();
			example.createCriteria().andIdEqualTo(nodeParam.getId());
			int ei = tTempNodeParamMapper.countByExample(example);
			//指定节点对应的参数
			if(ei > 0){
				tTempNodeParamMapper.updateByExample(nodeParam, example);	
			}else{
				//系统默认对应的参数
				TDefSqlParams param = tDefSqlParamsMapper.selectByPrimaryKey(new BigDecimal(nodeParam.getId()));
				if(param != null){
					param.setParamCode(nodeParam.getParamCode());
					param.setParamName(nodeParam.getParamName());
					param.setParamType(nodeParam.getParamType());
					param.setParamValue(nodeParam.getParamValue());
					param.setParamValueType(nodeParam.getParamValueType());
					if(nodeParam.getParamSubType() != null){
						Short pst = Short.parseShort(nodeParam.getParamSubType());
						param.setParamSubType(pst);
					}
					tDefSqlParamsMapper.updateByPrimaryKey(param);
				}else{
					logger.info("无此节点对应的参数：ID="+nodeParam.getId()+" Name="+nodeParam.getParamName());
				}
			}
			
		}
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.sinosoft.ummp.application.SubmitConfigService#saveTempNode(int,
	 * com.sinosoft.ummp.domain.model.TTempNode)
	 */
	@Override
	public int saveTempNode(int type, TTempNode tempNode) {
		// TODO Auto-generated method stub
		int i = -1;
		if (type == 0) {
			// TODO 新增 DELETE & INSERT
			logger.debug("新增节点：id=" + tempNode.getId() + " nodeCode="+ tempNode.getNodeCode());
			tTempNodeMapper.deleteByPrimaryKey(tempNode.getId());
			i = tTempNodeMapper.insert(tempNode);
		} else {
			// TODO 修改
			logger.debug("更新节点：id=" + tempNode.getId() + " nodeCode="+ tempNode.getNodeCode());
			i = tTempNodeMapper.updateByPrimaryKey(tempNode);
		}
		return i;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#deleteTempNodeAttri(java.lang
	 * .Integer)
	 */
	@Override
	public int deleteTempNodeAttri(Integer id) {
		TTempNodeAttriExample example = new TTempNodeAttriExample();
		example.createCriteria().andIdEqualTo(id);
		return tTempNodeAttriMapper.deleteByExample(example);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#deleteTempNodeParam(java.lang
	 * .Integer)
	 */
	@Override
	public int deleteTempNodeParam(Integer id) {
		TTempNodeParamExample example = new TTempNodeParamExample();
		example.createCriteria().andIdEqualTo(id);
		return tTempNodeParamMapper.deleteByExample(example);
	}

	/**
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#saveNodeTree(com.sinosoft.util
	 * .NodeTree)
	 */
	@Override
	@Transactional
	public int saveNodeTree(NodeTree nodeTree) {
		// TODO Auto-generated method stub
		Integer id = nodeTree.getId();
		int type = 0;
		TTempNode tempNode = null;
		if (id == null || id == 0) {
			id = Integer.parseInt(sequenceService
					.getSeqValByName("SEQ_T_TEMP_NODE"));
			tempNode = new TTempNode();
			tempNode.setId(id);
			tempNode.setFid(nodeTree.getFid());
			logger.debug("NEW    ID: " + id);
		} else {
			// 修改标识
			type = 1;
			tempNode = tTempNodeMapper.selectByPrimaryKey(id);
			logger.debug("UPDATE ID: " + id);
		}
		tempNode.setSonNodeContent(nodeTree.getSonNodeContent());
		tempNode.setSonNodeType(nodeTree.getSonNodeType());
		tempNode.setNodeCode(nodeTree.getText());
		tempNode.setNodeName(nodeTree.getText());
		int result = this.saveTempNode(type, tempNode);
		List<NodeTree> children = nodeTree.getChildren();
		//插入【直接插入】
		if (type == 0) {
			for (NodeTree node : children) {
				int cid = Integer.parseInt(sequenceService
						.getSeqValByName("SEQ_T_TEMP_NODE"));
				TTempNode temp = new TTempNode();
				temp.setFid(id);
				temp.setId(cid);
				temp.setNodeCode(node.getText());
				temp.setNodeName(node.getText());
				result += this.saveTempNode(0, temp);
			}
		}else{//更新
			//存在的更新，不存在的插入，多余的删除
			// 修改的是否才进行删除子节点
			List<TTempNode> sons = this.selectTempNodeByFid(id);
			Map<String,TTempNode> sonsm = new HashMap<String,TTempNode>();
			for(TTempNode value : sons){
				String key = value.getNodeCode();
				sonsm.put(key, value);
			}
//			for (NodeTree node : children) {
//				String key = node.getText();
//				//存在则更新
//				if(sonsm.containsKey(key)){
//					TTempNode temp = sonsm.get(key);
//					temp.setNodeCode(node.getText());
//					temp.setNodeName(node.getText());
//					result += tTempNodeMapper.updateByPrimaryKey(temp);
//				}else if(node.getId() == null){
//					//不存在则，ID也没有，则插入
//					int cid = Integer.parseInt(sequenceService
//							.getSeqValByName("SEQ_T_TEMP_NODE"));
//					TTempNode temp = new TTempNode();
//					temp.setFid(id);
//					temp.setId(cid);
//					temp.setNodeCode(node.getText());
//					temp.setNodeName(node.getText());
//					result += this.saveTempNode(0, temp);
//					
//				}else{
//					//不存在，有ID，则删除
//					result += this.deleteTempNode(node.getId());
//				}
//			}
			//不存在子节点
			if(sons == null || sons.size() <= 0){
				for (NodeTree node : children) {
					//不存在则，ID也没有，则插入
					int cid = Integer.parseInt(sequenceService
							.getSeqValByName("SEQ_T_TEMP_NODE"));
					TTempNode temp = new TTempNode();
					temp.setFid(id);
					temp.setId(cid);
					temp.setNodeCode(node.getText());
					temp.setNodeName(node.getText());
					result += this.saveTempNode(0, temp);
				}
			}else{
				if(children == null || children.size() <= 0){
					for(int i= 0; i < sons.size(); i ++){
						this.deleteTempNode(sons.get(i).getId());
					}
				}
				Map<String,TTempNode> upNTMap = new HashMap<String,TTempNode>();
				for (NodeTree node : children) {
						String key = node.getText();
						TTempNode temp = sonsm.get(key);
						if(temp == null){
							//不存在则，ID也没有，则插入
							int cid = Integer.parseInt(sequenceService
									.getSeqValByName("SEQ_T_TEMP_NODE"));
							TTempNode tTemp = new TTempNode();
							tTemp.setFid(id);
							tTemp.setId(cid);
							tTemp.setNodeCode(key);
							tTemp.setNodeName(node.getText());
							result += this.saveTempNode(0, tTemp);
						}
						//存在则更新
						else if(sonsm.containsKey(key)){
							temp.setNodeCode(key);
							temp.setNodeName(node.getText());
							result += tTempNodeMapper.updateByPrimaryKey(temp);
							upNTMap.put(key, temp);
						}else{
							//不存在，有ID，则删除
							result += this.deleteTempNode(temp.getId());
						}
				}
				//所有节点中不存在存储节点中的，进行删除
				Iterator<Entry<String, TTempNode>> iter = sonsm.entrySet().iterator();
				while(iter.hasNext()){
					Entry<String, TTempNode> entry = iter.next();
					String key = entry.getKey();
					if(!upNTMap.containsKey(key)){
						TTempNode aNode = entry.getValue();
						result += this.deleteTempNode(aNode.getId());
					}
				}
			}
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#deleteTempNodeByFid(java.lang
	 * .Integer)
	 */
	@Override
	public int deleteTempNodeByFid(Integer fid) {
		// TODO Auto-generated method stub
		TTempNodeExample example = new TTempNodeExample();
		example.createCriteria().andFidEqualTo(fid);
		return tTempNodeMapper.deleteByExample(example);
	}

	public List<TTempNode> selectTempNodeByFid(Integer fid){
		return tTempNodeMapper.selectTempNodeByFid(fid);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sinosoft.ummp.application.SubmitConfigService#deleteTempNode(java.lang.Integer
	 * )
	 */
	@Override
	@Transactional
	public int deleteTempNode(Integer id) {
		// 1、 delete 当前节点对应的sql 及sql 关联 因为SQL 就在 节点表，所以删除节点表即可
		// 2 、delete 当前节点对应的属性：删除属性
		tTempNodeAttriMapper.deleteByNodeIdRecurs(new BigDecimal(id));
		// 3、delete 当前节点对应的参数
		tTempNodeParamMapper.deleteByNodeIdRecurs(new BigDecimal(id));
		// 4、delete 当前节点
		return tTempNodeMapper.deleteByIdRecurs(id);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitConfigService#getScanMsg(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	/**
	 * 传进来的已经是节点ID了
	 */
	public String getScanMsg(String ids, String xformat, String xtitle,
			String isTitle) {
		String msg = "";
		if("1".equals(isTitle)){
			msg += xtitle;
		}
		List<Integer> tids = new ArrayList<Integer>();
		if(ids.contains(";")){
			List<String> idss = Arrays.asList(ids.split(";", -1));
			for(String tId : idss){
				tids.add(Integer.parseInt(tId));
			}
		}else{
			tids.add(Integer.parseInt(ids));
		}
		TTempNodeExample example = new TTempNodeExample();
		example.createCriteria().andIdIn(tids);
		List<TTempNode> tTempNodes = tTempNodeMapper.selectByExample(example);
		List<NodeTree> nodeTrees = this.convert2NodeTree(tTempNodes);
		msg += getTempNodeTree(nodeTrees);
		return msg;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.SubmitConfigService#saveMsgEngin(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List)
	 */
	@Override
	public Map<String,String> saveMsgEngin(LoginInfo loginInfo ,MsgConfigPOJO pojo) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<String,String>();
		// 先查询存在否
		MsgQueryPOJO qPojo = new MsgQueryPOJO();
		qPojo.setComId(pojo.getPlatCom());
		qPojo.setBussType(pojo.getBussType());
		qPojo.setImplType(pojo.getImplType());
		qPojo.setFormatType(pojo.getFormatType());
		qPojo.setSendType(pojo.getSendType());
		qPojo.setStatus(pojo.getStatus());
		@SuppressWarnings("unchecked")
		List<Map<?,?>> exists = msgQueryService.queryBaseMsg(qPojo,null);
		if(exists != null && exists.size() > 0){
			for(int i = 0; i < exists.size(); i++){
				//取何止取决于 queryBaseMsg 对应的SQL
				BigDecimal e = (BigDecimal) exists.get(i).get("STATUS");
				if(1 == e.intValue()){
					map.put("msg", "已存在有效的报文规则，请选择无效方式进行添加");
					return map;
				}
			}
		}
		try{
			if(pojo.getBussId() != null ){
				//TODO 走更新流程
				map.putAll(updateMsgEngin(loginInfo, pojo));
			}else{
				//TODO 走插入流程
				map.putAll(insertMsgEngin(loginInfo, pojo));
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("msg", "保存失败，请重试！");
		}
		return map;
	}
	/**
	 * 插入报文规则引擎
	 * @param loginInfo
	 * @param pojo
	 * @return
	 */
	public Map<String,String> insertMsgEngin(LoginInfo loginInfo,MsgConfigPOJO pojo){
		//TODO INSERT
		Map<String,String> map = new HashMap<String,String>();
		logger.info("报文规则引擎新增开始："+pojo.getMsgDesc());
		doClear();
		Integer bussId = Integer.parseInt(sequenceService.getSeqValByName("SEQ_T_DEF_BUSS_MODEL"));
		Integer implId = Integer.parseInt(sequenceService.getSeqValByName("SEQ_T_DEF_BUSS_IMPL"));
		
		//TODO DEF BUSSCODE 自动生成 业务类型=【报文格式-报送类型-10位流水】
		String bussCode = pojo.getFormatType()
				+"-"+pojo.getSendType()
				+"-"+sequenceService.getSerialNo(10);
		
		logger.debug("规则编码："+bussCode);
		
		pojo.setBussId(bussId);
		pojo.setBussCode(bussCode);
		
		boolean result = false;
		
		map.put("msg", "保存报文节点成功");
		boolean build = buildMsgEnginRules(implId,loginInfo,pojo);
		if(!build){
			map.put("msg", "构造报文引擎节点相关信息失败!");
		}else{
			TDefBussModel bmRecord = bildTDefBussModel(pojo);
			bms.add(bmRecord);
			TDefBussImpl biRecord = buildTDefBussImpl(implId,pojo);
			bis.add(biRecord);
		}
		//插入节点相关信息，事务控制
		result = insertMsgEnginRules();
		if(!result){
			map.put("msg", "保存报文引擎节点相关信息失败!");
		}
		logger.info("报文规则引擎新增结束："+pojo.getMsgDesc()+"\t"+result);
		return map;
	}
	/**
	 * 清空
	 */
	private void doClear(){
		tMsgNodes.clear();
		tMsgNodeAttris.clear();
		nodeSqlRelas.clear();
		sqls.clear();
		sqlInfos.clear();
		sqlParams.clear();
		bussXEngins.clear();
		bms.clear();
		bis.clear();
		System.gc();
	}
	/**
	 * 插入报文引擎相关信息
	 * @return
	 */
	@Transactional
	public boolean insertMsgEnginRules(){
		try{
			logger.debug("正在保存信息 ====>");
			for(TDefMsgNode record : tMsgNodes){
				tDefMsgNodeMapper.insert(record);
			}
			for(TDefMsgNodeAttri record : tMsgNodeAttris){
				tDefMsgNodeAttriMapper.insert(record);
			}
			for(TDefSql record : sqls){
				tDefSqlMapper.insert(record);
			}
			for(TDefSqlInfo record : sqlInfos){
				tDefSqlInfoMapper.insert(record);
			}
			for(TDefSqlParams record : sqlParams){
				tDefSqlParamsMapper.insert(record);
			}
			for(TDefMsgNodesqlRela record : nodeSqlRelas){
				tDefMsgNodesqlRelaMapper.insert(record);
			}
			for(TDefBussXengin record : bussXEngins){
				tDefBussXenginMapper.insert(record);
			}
			for(TDefBussModel bm : bms){
				tDefBussModelMapper.insert(bm);
			}
			for(TDefBussImpl bi : bis){
				tDefBussImplMapper.insert(bi);
			}
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}finally{
			doClear();
		}
		return true;
	}
	/**
	 * 构建报文引擎相关信息
	 * @param loginInfo 用户信息
	 * @param pojo MsgConfigPOJO 类
	 * @return 集合，以类名获取对应的信息
	 */
	public boolean buildMsgEnginRules(Integer implId,LoginInfo loginInfo,MsgConfigPOJO pojo){
		
		List<Integer> tNodeIds = pojo.getNodeIds();
		for(Integer id : tNodeIds){
			List<TTempNode> tTempNodes = tTempNodeMapper.selecteByIdRecurs(id);
			//获取节点信息： MsgNode
			for (TTempNode node : tTempNodes) {
				//构建第一级节点
				//每次进来NodeId为新增
				//第一层父类新建ID null 标识 MSG 根节点 ; 0 表示 DTO 根节点
				if(node.getFid() == null || node.getFid().equals(0)){
					Integer tNodeId = node.getId();
					logger.info("当前临时节点：temp.nodeFid:"+node.getFid()+" temp.nodeId:"+tNodeId+" temp.nodeCode:"+node.getNodeCode());
					
					BigDecimal msgNodeId = getTDefMsgNodeId();
					
					logger.info("保存为 MsgNodeId : "+msgNodeId);
					
					TDefMsgNode msgNode = new TDefMsgNode();
					msgNode.setNodeId(msgNodeId);
					msgNode.setNodeCode(node.getNodeCode());
					if(node.getFid() != null && node.getFid().equals(0)){
						msgNode.setNodePid(new BigDecimal(node.getFid()));
					}
					msgNode.setNodeName(node.getNodeName());
					msgNode.setNodeNum(Long.parseLong(""+msgNodeId));
					msgNode.setNodeText(node.getNodeCode());
					msgNode.setRcStatus(Short.parseShort("1"));
					msgNode.setSonNodeType(Short.parseShort("0"));
					if(node.getSonNodeType() != null 
							&& (node.getSonNodeType().trim().equals("1") 
									|| node.getSonNodeType().trim().equals("2"))){
						
						msgNode.setSonNodeType(Short.parseShort("1"));
						
						//SQL 信息  
						BigDecimal sqlId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_SQL"));
						logger.info("======> msgNodeId: "+msgNodeId+" 对应sqlId : "+sqlId);
						TDefSql tDefSql = new TDefSql();
						tDefSql.setSqlId(sqlId);
						tDefSql.setComId(new BigDecimal(pojo.getPlatCom()));
						tDefSql.setEsStatus(Short.parseShort("1"));
						tDefSql.setOperator(loginInfo.getUserCode());
						tDefSql.setSqlCode(pojo.getBussCode());
						tDefSql.setSqlDesc(pojo.getBussCode());
						tDefSql.setSqlType("O");//节点对应SQL
						tDefSql.setBussType(pojo.getBussType());
						tDefSql.setSubBussType("XENGIN_CONFIG");
						tDefSql.setInsertTime(DateUtils.getCurrentTimestamp());
						tDefSql.setLastModifyTime(DateUtils.getCurrentTimestamp());
						sqls.add(tDefSql);
						
						//SQL 详细信息  
						BigDecimal sqlInfoId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_SQL_INFO"));
						logger.info("======> msgNodeId: "+msgNodeId+" 对应sqlInfoId : "+sqlInfoId);
						TDefSqlInfo sqlInfo = new TDefSqlInfo();
						sqlInfo.setId(sqlInfoId);
						sqlInfo.setSqlId(sqlId);
						sqlInfo.setSqlInfo(node.getSonNodeContent());
						sqlInfo.setSqlType("O");
						sqlInfos.add(sqlInfo);
						
						//SQL 参数
						List<TDefSqlParams> tSqlParams = this.getSqlParams(sqlId,tNodeId);
						sqlParams.addAll(tSqlParams);
						
						//NODESQL_RELA
						BigDecimal nodeSqlRelaId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_MSG_NODESQL_RELA"));
						logger.info("======> msgNodeId: "+msgNodeId+" 对应nodeSqlRelaId : "+nodeSqlRelaId);
						TDefMsgNodesqlRela nodeSqlRela = new TDefMsgNodesqlRela();
						nodeSqlRela.setId(nodeSqlRelaId);
						nodeSqlRela.setNodeId(msgNodeId);
						nodeSqlRela.setRcStatus(Short.parseShort("1"));
						nodeSqlRela.setSqlId(sqlId);
						nodeSqlRelas.add(nodeSqlRela);
						
						//继续添加子节点
						logger.info("装载节点信息  msgNodeId: "+msgNodeId+" tNodeId: "+tNodeId);
						biuldMsgNodeChildren(implId,msgNodeId,tNodeId,tTempNodes,pojo,loginInfo);
						
					}else{
						logger.info("======> "+node.getNodeId()+node.getNodeCode()+" 无子节点信息");
					}
					logger.info("======> ADD "+msgNode);
					if(!tMsgNodes.contains(msgNode)){
						tMsgNodes.add(msgNode);
					}
					//BussMsgEngin 父类节点为NULL 即根节点
					BigDecimal bussMsgEnginId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_BUSS_MSGENGIN"));
					TDefBussXengin bussXEngin = new TDefBussXengin();
					bussXEngin.setBussId(new BigDecimal(pojo.getBussId()));
					bussXEngin.setId(bussMsgEnginId);
					bussXEngin.setImplId(new BigDecimal(implId));
					bussXEngin.setNodeId(msgNodeId);
					bussXEngin.setRcStatus(Short.parseShort(pojo.getStatus()));
					bussXEngin.setInsertTime(DateUtils.getCurrentTimestamp());
					bussXEngin.setLastModifyTime(DateUtils.getCurrentTimestamp());
					bussXEngin.setOperator(loginInfo.getUserCode());
					bussXEngin.setLastModifyOperator(loginInfo.getUserCode());
					bussXEngins.add(bussXEngin);
					//获取节点属性
					List<TDefMsgNodeAttri> tMsgNodeAttri = getTDefMsgNodeAttri(msgNodeId,tNodeId);
					tMsgNodeAttris.addAll(tMsgNodeAttri);
				}
			}
		}
		return true;
	}
	/**
	 * 根据tNodeId查询出对应的属性，赋值ID与归属MsgNodeId
	 * @param nodeId 归属MsgNodeId
	 * @param tNodeId 查询条件健的临时节点ID
	 * @return
	 */
	private List<TDefMsgNodeAttri> getTDefMsgNodeAttri(BigDecimal nodeId,Integer tNodeId){
		List<TDefMsgNodeAttri> msgNodeAttris = new ArrayList<TDefMsgNodeAttri>();
		TTempNodeAttriExample example = new TTempNodeAttriExample();
		example.createCriteria().andNodeIdEqualTo(tNodeId);
		List<TTempNodeAttri> tNodeAttris = tTempNodeAttriMapper.selectByExample(example);
		for(TTempNodeAttri tNodeAttri : tNodeAttris){
			BigDecimal attriId = new BigDecimal(sequenceService
					.getSeqValByName("SEQ_T_DEF_MSG_NODE_ATTRI"));
			TDefMsgNodeAttri msgNodeAttri = new TDefMsgNodeAttri();
			msgNodeAttri.setId(attriId);
			msgNodeAttri.setAttriCode(tNodeAttri.getAttriCode());
			msgNodeAttri.setAttriName(tNodeAttri.getAttriName());
			msgNodeAttri.setAttriValue(tNodeAttri.getAttriValue());
			msgNodeAttri.setNodeId(nodeId);
			msgNodeAttri.setAttriNum(attriId.longValue());
			msgNodeAttri.setRcStatus(Short.parseShort("1"));
			msgNodeAttris.add(msgNodeAttri);
		}
		return msgNodeAttris;
	}
	/**
	 * 获取节点对应的提数SQL的参数
	 * @param sqlId
	 * @param id
	 * @return
	 */
	private List<TDefSqlParams> getSqlParams(BigDecimal sqlId,Integer id){
		List<TDefSqlParams> tSqlParams = new ArrayList<TDefSqlParams>();
		TTempNodeParamExample example = new TTempNodeParamExample();
		example.createCriteria().andNodeIdEqualTo(id);
		List<TTempNodeParam> tNodeParams = tTempNodeParamMapper.selectByExample(example);
		for(TTempNodeParam param : tNodeParams){
			BigDecimal paramId = new BigDecimal(sequenceService
					.getSeqValByName("SEQ_T_DEF_SQL_PARAMS"));
			TDefSqlParams sqlParam = new TDefSqlParams();
			String paramSubType = param.getParamSubType();
			sqlParam.setEsStatus(Short.parseShort("1"));
			sqlParam.setId(paramId);
			sqlParam.setParamCode(param.getParamCode());
			sqlParam.setParamType(param.getParamType());
			sqlParam.setParamValue(param.getParamValue());
			sqlParam.setParamName(param.getParamName());
			sqlParam.setParamSubType(Short.parseShort(paramSubType));
			sqlParam.setParamValueType(param.getParamValueType());
			sqlParam.setSqlId(sqlId);
			
			tSqlParams.add(sqlParam);
			
		}
		return tSqlParams;
	}
	public BigDecimal getTDefMsgNodeId(){
		BigDecimal nodeId = sequenceService.getBigSeqValByName("SEQ_T_DEF_MSG_NODE");
		logger.info("get MsgNodeId : "+nodeId);
		return nodeId;
	}
	/**
	 * 通过递归构造所有TDefMsgNode的信息
	 * @param implId 实现ID
	 * @param nodeFid 保存至MsgNode的ID
	 * @param fid 父类ID，需要构造器子类信息
	 * @param tTempNodes 临时节点集合
	 * @param pojo 参数POJO
	 * @param loginInfo 登录信息
	 * @return
	 */
	public boolean biuldMsgNodeChildren(Integer implId,BigDecimal nodeFid,Integer fid,List<TTempNode> tTempNodes,MsgConfigPOJO pojo,LoginInfo loginInfo){
		for (TTempNode node : tTempNodes) {
			logger.info("find temp.node fid = "+fid+" 的子节点");
			Integer tNodeId = node.getId();
			if(node.getFid() != null 
					&& node.getFid().equals(fid) 
					&& !tNodeId.equals(fid)){
				//每次进来NodeId为新增（保存入MsgNode）
				logger.info("当前临时节点：temp.nodeFid:"+node.getFid()+" temp.nodeId:"+tNodeId+" temp.nodeCode:"+node.getNodeCode());
				
				BigDecimal saveSonNodeId = getTDefMsgNodeId();
				
				logger.info("构造  MsgNode 节点： "+nodeFid+" 的子节点ID : "+saveSonNodeId);
				TDefMsgNode msgNode = new TDefMsgNode();
				msgNode.setNodeCode(node.getNodeCode());
				msgNode.setNodeId(saveSonNodeId);
				msgNode.setNodeName(node.getNodeName());
				msgNode.setNodeNum(Long.parseLong(""+saveSonNodeId));
				msgNode.setNodeText(node.getNodeCode());
				msgNode.setNodePid(nodeFid);
				msgNode.setRcStatus(Short.parseShort("1"));
				
				if(node.getSonNodeType() != null 
						&& (node.getSonNodeType().trim().equals("1") 
								|| node.getSonNodeType().trim().equals("2"))){
					
					msgNode.setSonNodeType(Short.parseShort(node.getSonNodeType()));
					//有 children 才有 SQL
					logger.info("======> saveSonNodeId: "+saveSonNodeId+node.getNodeCode()+" 子节点SQL信息：");
					//SQL 信息  
					BigDecimal sqlId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_SQL"));
					logger.info("======> saveSonNodeId: "+tNodeId+" 对应sqlId: "+sqlId);
					TDefSql tDefSql = new TDefSql();
					tDefSql.setSqlId(sqlId);
					tDefSql.setSqlType("O");//节点对应SQL
					tDefSql.setComId(new BigDecimal(pojo.getPlatCom()));
					tDefSql.setEsStatus(Short.parseShort("1"));
					tDefSql.setOperator(loginInfo.getUserCode());
					tDefSql.setSqlCode(pojo.getBussCode());
					tDefSql.setSqlDesc(pojo.getBussCode());
					tDefSql.setBussType(pojo.getBussType());
					tDefSql.setSubBussType("XENGIN_CONFIG");
					tDefSql.setInsertTime(DateUtils.getCurrentTimestamp());
					tDefSql.setLastModifyTime(DateUtils.getCurrentTimestamp());
					sqls.add(tDefSql);
					
					//SQL 详细信息  
					BigDecimal sqlInfoId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_SQL_INFO"));
					logger.info("======> saveSonNodeId: "+saveSonNodeId+" 对应 sqlInfoId : "+sqlInfoId);
					TDefSqlInfo sqlInfo = new TDefSqlInfo();
					sqlInfo.setId(sqlInfoId);
					sqlInfo.setSqlId(sqlId);
					sqlInfo.setSqlInfo(node.getSonNodeContent());
					sqlInfo.setSqlType("O");
					sqlInfos.add(sqlInfo);
					
					//SQL 参数
					List<TDefSqlParams> tSqlParams = this.getSqlParams(sqlId,tNodeId);
					sqlParams.addAll(tSqlParams);
					
					//NODESQL_RELA youSQL就加载
					BigDecimal nodeSqlRelaId = new BigDecimal(sequenceService.getSeqValByName("SEQ_T_DEF_MSG_NODESQL_RELA"));
					logger.info("======> saveSonNodeId: "+saveSonNodeId+" 对应 nodeSqlRelaId : "+nodeSqlRelaId);
					TDefMsgNodesqlRela nodeSqlRela = new TDefMsgNodesqlRela();
					nodeSqlRela.setId(nodeSqlRelaId);
					nodeSqlRela.setNodeId(saveSonNodeId);
					nodeSqlRela.setRcStatus(Short.parseShort("1"));
					nodeSqlRela.setSqlId(sqlId);
					nodeSqlRelas.add(nodeSqlRela);
					//添加子节点继续
					logger.info("转载节点信息 saveSonNodeId : "+saveSonNodeId+" tNodeId: "+tNodeId);
					biuldMsgNodeChildren(implId,saveSonNodeId,tNodeId,tTempNodes,pojo,loginInfo);
				}
				if(!tMsgNodes.contains(msgNode)){
					tMsgNodes.add(msgNode);
				}
				//加载节点属性
				List<TDefMsgNodeAttri> tMsgNodeAttri = 
						getTDefMsgNodeAttri(saveSonNodeId,tNodeId);
				tMsgNodeAttris.addAll(tMsgNodeAttri);
			}
		}
		return true;
	}
	/**
	 * 获取实现类型
	 * @param pojo
	 * @return
	 */
	private String getImplType(MsgConfigPOJO pojo){
		//根据报文用途判断使用的返回类型
		String implType = pojo.getImplType();
		return implType;
	}
	/**
	 * 构造BussImpl
	 * @param implId
	 * @param pojo
	 * @return
	 */
	private TDefBussImpl buildTDefBussImpl( Integer implId,MsgConfigPOJO pojo){
		TDefBussImpl record = new TDefBussImpl();
		String implType = getImplType(pojo);
		String code = implType+"-"+pojo.getBussCode();
		List<TDefCodeDict> defCode = codeQueryService.queryCode("IMPL_TYPE",implType);
		if(defCode != null && defCode.size() > 0){
			record.setImplName(defCode.get(0).getCodeName());
		}
		record.setImplType(implType);
		record.setImplCode(code);
		record.setImplId(new BigDecimal(implId));
		record.setBussId(new BigDecimal(pojo.getBussId()));
		record.setFormatType(pojo.getFormatType());
		record.setSendType(pojo.getSendType());
		record.setRcStatus(Short.parseShort(pojo.getStatus()));
		record.setOperator(pojo.getUserCode());
		record.setInsertTime(DateUtils.getCurrentTimestamp());
		record.setLastModifyTime(DateUtils.getCurrentTimestamp());
		return record;
	}
	/**
	 * 构造BussModel
	 * @param pojo
	 * @return
	 */
	private TDefBussModel bildTDefBussModel(MsgConfigPOJO pojo){
		TDefBussModel bussModel = new TDefBussModel();
		bussModel.setBussCode(pojo.getBussCode());
		bussModel.setBussId(new BigDecimal(pojo.getBussId()));
		bussModel.setBussType(pojo.getBussType());
		bussModel.setBussName(pojo.getMsgDesc());
		bussModel.setComId(new BigDecimal(pojo.getPlatCom()));
		bussModel.setIsTitle(Short.parseShort(pojo.getIsTitle()));
		bussModel.setTitleInfo(pojo.getHeadTitle());
		bussModel.setRcStatus(Short.parseShort(pojo.getStatus()));
		bussModel.setSubBussType(pojo.getImplType());//报文定义
		return bussModel;
	}
	
	/**
	 * 更新报文规则引擎
	 * @param loginInfo
	 * @param pojo
	 * @return
	 */
	private Map<String,String> updateMsgEngin(LoginInfo loginInfo,MsgConfigPOJO pojo){
		logger.info("报文规则引擎更新开始："+pojo.getMsgDesc());
		//TODO UPDATE
		
		logger.info("报文规则引擎更新结束："+pojo.getMsgDesc());
		return null;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgConfigService#deleteMsgEngen(java.lang.Integer)
	 */
	@Override
	@Transactional
	public boolean deleteMsgEngen(BigDecimal bussId) {
		// TODO Auto-generated method stub
		TDefBussModel bussModel = tDefBussModelMapper.selectByPrimaryKey(bussId);
		if(bussModel == null ){
			return true;
		}
		TDefBussImplExample example = new TDefBussImplExample();
		TDefBussImplExample.Criteria criteria = example.createCriteria();
		criteria.andBussIdEqualTo(bussId);
		List<TDefBussImpl> tDefBussImpls = tDefBussImplMapper.selectByExample(example);
		for(TDefBussImpl impl : tDefBussImpls){
			//关联查询MSG_ENGIN
			TDefBussXenginExample msgXExample = new TDefBussXenginExample();
			TDefBussXenginExample.Criteria msgXCriteria = msgXExample.createCriteria();
			msgXCriteria.andImplIdEqualTo(impl.getImplId());
			//根据实现类查到相关实现的报文规则信息
			List<TDefBussXengin> tDefBussXengins = tDefBussXenginMapper.selectByExample(msgXExample);
			for(TDefBussXengin bussXEngin : tDefBussXengins){
				List<TDefMsgNode> tDefMsgNodes = tDefMsgNodeMapper.selectByMsgNodeId(bussXEngin.getNodeId());
				for(TDefMsgNode node : tDefMsgNodes){
					//删除节点属性
					logger.debug("删除节点："+node.getNodeId()+" "+node.getNodeName());
					TDefMsgNodeAttriExample pExample = new TDefMsgNodeAttriExample();
					pExample.createCriteria().andNodeIdEqualTo(node.getNodeId());
					tDefMsgNodeAttriMapper.deleteByExample(pExample);
					
					//删除节点SQL
					deleteNodeSql(node.getNodeId());
				}
				//删除引擎表（引擎外键为Node的ID，故需要先删除之）
				tDefBussXenginMapper.deleteByPrimaryKey(bussXEngin.getId());
				//删除节点表
				tDefMsgNodeMapper.deleteByMsgNodeId(bussXEngin.getNodeId());
			}
			//删除
			tDefBussImplMapper.deleteByPrimaryKey(impl.getImplId());
		}
		tDefBussModelMapper.deleteByPrimaryKey(bussId);
		return true;
	}

	@Transactional
	public boolean deleteNodeSql(BigDecimal nodeId){
		TDefMsgNodesqlRelaExample example = new TDefMsgNodesqlRelaExample();
		example.createCriteria().andNodeIdEqualTo(nodeId);
		List<TDefMsgNodesqlRela> sqlRelas = tDefMsgNodesqlRelaMapper.selectByExample(example);
		for(TDefMsgNodesqlRela rela : sqlRelas){
			tDefSqlParamsMapper.deleteByPrimaryKey(rela.getSqlId());
			tDefSqlInfoMapper.deleteByPrimaryKey(rela.getSqlId());
			tDefSqlMapper.deleteByPrimaryKey(rela.getSqlId());
			tDefMsgNodesqlRelaMapper.deleteByPrimaryKey(rela.getId());
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgConfigService#getDTORootFromTemp(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public List<NodeTree> getDTORootFromTemp(String type, String formatType,String bussType) {
		// TODO Auto-generated method stub
		List<NodeTree> rtv = null;
		try {
			TTempNodeExample example = new TTempNodeExample();
			TTempNodeExample.Criteria criteria = example.createCriteria();
			if(bussType!= null){
				criteria.andNodeCodeEqualTo(bussType.toUpperCase());
			}
			criteria.andFidEqualTo(0);
			List<TTempNode> temp = tTempNodeMapper.selectByExample(example);
			if(temp == null || temp.size() <= 0){
				//没有则添加
				logger.debug("临时节点表中无DTO根节点信息：创建之 bussType = "+bussType);
				rtv = dTOAnalizyService.dtoAnalizy(bussType);
				//启动线程自动保存
				SaveTempNodeThread thread = new SaveTempNodeThread(rtv);
				thread.start();
				return rtv;
			}else{
				logger.debug("从临时节点中取DTO根节点信息：bussType = "+bussType);
				rtv = convert2NodeTree(temp);
				return rtv;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rtv;
	}

	/**
	 * 构造基本信息
	 * @param nodeTrees
	 * @return
	 */
	private String getTempNodeTree(List<NodeTree> nodeTrees){
		String rtv = "";
		for(NodeTree nodeTree : nodeTrees){
			logger.info(" ======> "+nodeTree.getCode()+" "+nodeTree.getName());
			Element element = DocumentHelper.createElement(nodeTree.getCode());
			if(nodeTree.getChildren() != null && nodeTree.getChildren().size() > 0 ){
				buildSonElement(element,nodeTree.getChildren());
			}else{
				//添加值得地方
				element.setText(nodeTree.getCode());
			}
			rtv += element.asXML();
			element = null;
		}
		return rtv;
	}
	/**
	 * 构造子节点
	 * @param root
	 * @param children
	 * @return
	 */
	private Element buildSonElement(Element root,List<NodeTree> children){
		for(NodeTree nodeTree : children){
			logger.info(" ======> "+nodeTree.getCode()+" "+nodeTree.getName());
			Element element = DocumentHelper.createElement(nodeTree.getCode());
			if(nodeTree.getChildren() != null && nodeTree.getChildren().size() > 0 ){
				buildSonElement(element,nodeTree.getChildren());
			}else{
				//添加值得地方
				element.setText(nodeTree.getCode());
			}
			root.add(element);
			element = null;
		}
		return root;
	}
	/**
	 * 构造节点信息（不负责ID的赋值）
	 * @param nodeTrees
	 * @return
	 */
	private List<TTempNode> convert2TempNode(List<NodeTree> nodeTrees){
		List<TTempNode> tNodeTrees = new ArrayList<TTempNode>();
		for(NodeTree temp : nodeTrees){
			TTempNode node = new TTempNode();
			node.setFid(temp.getFid());
			node.setId(temp.getId());
			node.setNodeCode(temp.getText());
			node.setNodeName(temp.getName());
			node.setSonNodeType("0");
			if(temp.getChildren() != null && temp.getChildren().size() > 0){
				node.setSonNodeType("1");
				node.setSonNodeContent(temp.getSonNodeContent());
				tNodeTrees.addAll(convert2TempNode(temp.getChildren()));
			}
			tNodeTrees.add(node);
		}
		return tNodeTrees;
	}
	/**
	 * 将父级TempNode 构造成树状，
	 * @param tempNodes 一层父类节点
	 * @return
	 */
	private List<NodeTree> convert2NodeTree(List<TTempNode> tempNodes) {
		List<NodeTree> rtv = new ArrayList<NodeTree>();
		for (TTempNode tempNode : tempNodes) {
			NodeTree nodeTree = new NodeTree();
			nodeTree.setId(tempNode.getId());
			nodeTree.setFid(tempNode.getFid());
			nodeTree.setNum(tempNode.getId());
			nodeTree.setText(tempNode.getNodeCode());
			nodeTree.setCode(tempNode.getNodeCode());
			nodeTree.setName(tempNode.getNodeName());
			if(tempNode.getSonNodeType() != null 
					&& "1".equals(tempNode.getSonNodeType())){
				nodeTree.setSonNodeType(tempNode.getSonNodeType());
				nodeTree.setSonNodeContent(tempNode.getSonNodeContent());
				nodeTree.setChildren(convert2NodeTree(
						tTempNodeMapper.selectTempNodeByFid(tempNode.getId())));
			}
			rtv.add(nodeTree);
		}
		return rtv;
	}
	/**
	 * 根据临时节点自动保存
	 * @param nodeTrees
	 */
	@Transactional
	private void saveDTORootTree(List<NodeTree> nodeTrees){
		if(nodeTrees != null){
			List<TTempNode> saves = convert2TempNode(nodeTrees);
			for(TTempNode record : saves){
				//DELETE & INSERT
				logger.debug(" 正在保存："+record.getNodeId()+"\t"+record.getNodeCode());
				TTempNodeExample example = new TTempNodeExample();
				example.createCriteria().andNodeCodeEqualTo(record.getNodeCode());
				tTempNodeMapper.deleteByPrimaryKey(record.getId());//根据ID删除
				tTempNodeMapper.deleteByExample(example);//根据Code删除
				tTempNodeMapper.insertSelective(record);//保存
			}
		}
	}
	/**
	 * 启动线程自动保存节点
	 * @author Darker.Wang
	 * @date 2016-7-28 下午8:18:31
	 * @company SINOSOFT
	 */
	private class SaveTempNodeThread extends Thread{
		List<NodeTree> nodeTrees;
		private SaveTempNodeThread(List<NodeTree> tNodeTrees){
			nodeTrees = tNodeTrees;
		}
		public void run(){
			logger.debug("启动线程自动保存节点至临时节点始："+nodeTrees);
			saveDTORootTree(nodeTrees);
			logger.debug("自动保存DTO根节点至临时节点完毕："+nodeTrees);
			nodeTrees = null;
		}
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.MsgConfigService#isSysDefaultParam(java.lang.Integer)
	 */
	@Override
	public boolean isSysDefaultParam(Integer id) {
		// TODO Auto-generated method stub
		TDefSqlParamsExample example = new TDefSqlParamsExample();
		TDefSqlParamsExample.Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(new BigDecimal(id));
		criteria.andSqlIdIsNull();
		criteria.andParamSubTypeEqualTo(Short.parseShort("0"));
		int i = tDefSqlParamsMapper.countByExample(example);
		if(i > 0){
			return true;
		}
		return false;
	}
}
