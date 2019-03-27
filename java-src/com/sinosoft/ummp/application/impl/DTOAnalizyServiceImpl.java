/**
 * 
 */
package com.sinosoft.ummp.application.impl;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.util.NodeTree;
import com.sinosoft.ummp.application.DTOAnalizyService;
import com.sinosoft.ummp.domain.mapper.TDefWSPParamMapper;
import com.sinosoft.ummp.domain.mapper.TDefWSPRequestMapper;
import com.sinosoft.ummp.domain.mapper.TDefWSPReturnMapper;
import com.sinosoft.ummp.domain.mapper.TTempNodeMapper;
import com.sinosoft.ummp.domain.model.TDefWSPParam;
import com.sinosoft.ummp.domain.model.TDefWSPRequest;
import com.sinosoft.ummp.domain.model.TDefWSPRequestExample;

/**
 * DTO解析实现类
 * @author Darker.Wang
 * @date 2016-7-28 下午2:05:19
 * @company SINOSOFT
 */
@Service
public class DTOAnalizyServiceImpl implements DTOAnalizyService{

	private static Logger logger = Logger.getLogger(DTOAnalizyServiceImpl.class);
	@Autowired
	TDefWSPRequestMapper tDefWSPRequestMapper;
	@Autowired
	TDefWSPReturnMapper tDefWSPReturnMapper;
	@Autowired
	TDefWSPParamMapper tDefWSPParamMapper;
	@Autowired
	TTempNodeMapper tTempNodeMapper;
	@Autowired
	SequenceService sequenceService;
	/** 
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	public List<NodeTree> dtoAnalizy(String bussType) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO 转换成大写，获取对应的DTO节点信息
		if(bussType != null){
			bussType = bussType.toUpperCase();	
		}
		TDefWSPRequestExample example = new TDefWSPRequestExample();
		example.createCriteria().andBussTypeEqualTo(bussType);
		List<TDefWSPRequest> requsts = tDefWSPRequestMapper.selectByExample(example);
		List<NodeTree> rtv = new ArrayList<NodeTree>();
		for(TDefWSPRequest request : requsts){
			BigDecimal requestId = request.getId();
			String method = request.getRequestMethod();
			String requestClassName = request.getRequestClass();
			logger.debug("WSP METHOD : "+method+" NAME :　" + requestClassName);
			Integer nodeId = Integer.parseInt(sequenceService.getSeqValByName("SEQ_T_TEMP_NODE"));
			//第一级父类的初始
			NodeTree nodeTree = new NodeTree();
			nodeTree.setId(nodeId);
			nodeTree.setChecked(1);
			nodeTree.setText(request.getBussType());//第一层以BUSS_TYPE作为根节点
			nodeTree.setFid(0);//默认DTO的第一级父类设置成0，NULL的标识MSG节点的
			nodeTree.setSonNodeType("1");//根节点一定有子节点，故设置成 1
			List<TDefWSPParam> params = tDefWSPParamMapper.selectByRequestId(requestId);
			List<NodeTree> children = new ArrayList<NodeTree>();
			for(int i = 0; i < params.size(); i ++){
				NodeTree tNodeTree = new NodeTree();
				String className = params.get(i).getParamClass();
				String paramName = params.get(i).getParamName();
				Integer tNodeId = Integer.parseInt(sequenceService.getSeqValByName("SEQ_T_TEMP_NODE"));
				tNodeTree.setId(tNodeId);
				tNodeTree.setFid(nodeId);
				tNodeTree.setNum(Integer.parseInt(""+params.get(i).getNum()));
				tNodeTree.setText(paramName);
				tNodeTree.setSonNodeType("0");
				if(params.get(i).getIsAnalizy() != null 
						&& params.get(i).getIsAnalizy().equals(Short.parseShort("1"))){
					logger.debug("TO DO DTOAnalizy ："+className);
					tNodeTree.setSonNodeType("1");
					tNodeTree.setChildren(buildChildren(tNodeId,className));
				}
				children.add(tNodeTree);
			}
			nodeTree.setChildren(children);
			rtv.add(nodeTree);
		}
		return rtv;
	}
	/**
	 * 递归构建子节点
	 * @param fid
	 * @param className
	 * @return
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	private List<NodeTree> buildChildren(Integer fid,String className) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class<?> clazz = Class.forName(className);
		logger.debug("Class Name :　"+className);
		List<NodeTree> rtv = new ArrayList<NodeTree>();
		//获取包括私有共有属性
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields){
			Integer id = Integer.parseInt(sequenceService.getSeqValByName("SEQ_T_TEMP_NODE"));
			field.setAccessible(true);
			String name = field.getName();
			Class<?> type = field.getType();
			NodeTree tNode = new NodeTree();
			tNode.setId(id);
			tNode.setFid(fid);
			tNode.setText(name);
			logger.debug("field type : "+type.toString());
			logger.debug("field name : "+name);
			String classNameChild = type.toString();
			tNode.setSonNodeType("0");
			if(classNameChild.startsWith("class [L")){
				tNode.setSonNodeType("1");//重新设置成 1 标识有子节点
				logger.info("field is array and analizy it... ");
				logger.debug(name+" className : "+classNameChild);
				classNameChild = classNameChild.replace("class [L", "").replace(";", "");
				tNode.setChildren(buildChildren(id,classNameChild));
			}
			rtv.add(tNode);
		}
		return rtv;
	}
	String line_x = "|";
	String line_y = "...";
	String line_ = " ";
	public String showNodeTree(String x,String y,NodeTree nodeTree){
		StringBuilder sb = new StringBuilder();
		sb.append(x+y+nodeTree.getText());
		sb.append("\n");
		List<NodeTree> nodeTrees = nodeTree.getChildren();
		if(nodeTrees != null){
			for(NodeTree tree : nodeTrees){
				if(tree == null){
					continue;
				}
				sb.append(line_x+line_y+tree.getText());
				sb.append("\n");
				if(nodeTree.getSonNodeType().equals("1")){
					String _x = line_+line_x;
					String _y = line_y;
					sb.append(showNodeTree(_x,_y,tree));
				}
			}
		}
		return sb.toString();
	}
	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		String className = "com.ebao.accident.insurance.dto.AccidentPolicyDTO";
		DTOAnalizyServiceImpl test = new DTOAnalizyServiceImpl();
		List<NodeTree> nodeTrees = test.buildChildren(1,className);
		logger.debug(nodeTrees);
		String show = "";
		for(NodeTree nodeTree : nodeTrees){
			show += test.showNodeTree("","",nodeTree);
		}
		logger.debug(show);
	}

}
