/**
 * 
 */
package com.sinosoft.ummp.interfaces.xengin;


import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.platform.core.application.SqlUtilService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.NodeAttri;
import com.sinosoft.platform.core.util.NodeParam;
import com.sinosoft.platform.core.util.NodeTree;
import com.sinosoft.ummp.application.MsgConfigService;
import com.sinosoft.ummp.domain.model.TTempNodeAttri;
import com.sinosoft.ummp.domain.model.TTempNodeParam;
import com.sinosoft.ummp.domain.pojo.MsgConfigPOJO;

/**
 * @author Darker.Wang
 * @date 2016-5-23 下午4:51:02
 * 报送配置控制器
 */
@Controller
@RequestMapping("/mconfig")
public class MsgConfigController {
	private static final Logger logger = Logger.getLogger(MsgConfigController.class);
	@Autowired
	UserService userService;
	@Autowired
	MsgConfigService msgConfigService;
	@Autowired
	SqlUtilService sqlUtilService;
	@RequestMapping(value="/msgConfigUrl", method = RequestMethod.GET)
	public String listMsgConfigUrl(HttpServletRequest request){
		return "ummp/xengin/msgConfigInput";
	}
	@RequestMapping(value="/addNodeAttriUrl", method = RequestMethod.GET)
	public String addNodeAttriUrl(HttpServletRequest request ,@RequestParam Integer id){
		return "ummp/xengin/addNodeAttri";
	}
	@RequestMapping(value="/addNodeSqlParamUrl", method = RequestMethod.GET)
	public String addNodeSqlParamUrl(HttpServletRequest request ,@RequestParam Integer id){
		return "ummp/xengin/addNodeSqlParam";
	}
	@RequestMapping(value="/scanMsgUrl", method = RequestMethod.GET,produces = "application/json; charset=utf-8")
	public String scanMsgUrl(HttpServletRequest request){
		try{
			String ids = request.getParameter("ids");
			String xformat = request.getParameter("xformat");
			String xdesc = request.getParameter("xdesc");
			if(xdesc != null){
				xdesc = new String(xdesc.getBytes("ISO8859-1"),"UTF-8");
			}
			String xtitle = request.getParameter("xtitle");
			String isTitle = request.getParameter("isTitle");
			logger.debug("ids: "+ids
					+"\nxformat: "+xformat
					+"\nxdesc: "+xdesc
					+"\nxtitle: "+xtitle
					+"\nisTitle: "+isTitle);
			String msg = msgConfigService.getScanMsg(ids, xformat, xtitle, isTitle);
			msg = formatXML(msg);
			logger.debug(msg);
			request.setAttribute("ids", ids);
			request.setAttribute("format", xformat);
			request.setAttribute("isTitle", isTitle);
			request.setAttribute("title", xtitle);
			request.setAttribute("xmsg", msg);
			request.setAttribute("xmsg_desc", xdesc);
		}catch(Exception e){
			e.printStackTrace();
			request.setAttribute("xmsg", "浏览异常："+e.getMessage()+"\n请重试！");
		}
		return "ummp/xengin/msgShowInput";
	}
	
	@RequestMapping(value="/downXmlScan", method = RequestMethod.POST,produces="application/octet-stream; charset=utf-8")
	@ResponseBody
	public String downXmlScan(String ids,String format,String isTitle,String title,HttpServletResponse response){
		try{
			String msg = msgConfigService.getScanMsg(ids, format, title, isTitle);
			msg = formatXML(msg);
			return msg;
		}catch(Exception e){
			e.printStackTrace();
		}
		return title;
	}
	/**
	 * 格式化XML
	 * @param xmlString
	 * @return
	 * @throws Exception
	 */
	private String formatXML(String xmlString) throws Exception{
		Document tDoc = DocumentHelper.parseText(xmlString);
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		StringWriter sw = new StringWriter();
		XMLWriter xmlWriter = new XMLWriter(sw,format);
		xmlWriter.write(tDoc);
		sw.close();
		return sw.toString();
	}
	/**
	 * 初始化节点属性
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/initNodeAttriUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<NodeAttri> initNodeAttriUrl(@RequestParam Integer id){
		logger.debug("节点属性：ID="+id);
		List<NodeAttri> attris = msgConfigService.getTempNodeAttriById(id);
		return attris;
	}
	
	@RequestMapping(value="/initNodeParamUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<NodeParam> initNodeParamUrl(@RequestParam Integer id){
		logger.debug("节点属性：ID="+id);
		List<NodeParam> params = msgConfigService.getTempNodeParamById(id);
		return params;
	}
	/**
	 * comboBox 提交方式默认为POST
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listPlatUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefPlatCom> listPlatUrl(HttpServletRequest request){
		LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		return msgConfigService.listPlatsByUserCode(loginfo.getUserCode());
	}
	@RequestMapping(value="/buildSonNode", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<NodeTree> buildSonNode(HttpServletRequest request){
		List<NodeTree> rtv = null;
		try {
			request.setCharacterEncoding("UTF-8");
			String nodeCode = request.getParameter("nodeCode");
//			nodeCode = URLEncoder.encode(nodeCode, "UTF-8");
			String content = request.getParameter("content");
			content = new String(content.getBytes("ISO8859-1"),"UTF-8");
//			content = URLEncoder.encode(content, "UTF-8");
			String type = request.getParameter("type");
//			type = URLEncoder.encode(type, "UTF-8");
			if(content != null){
				//将 ^^ 与 ^ 替换回来
				content = sqlUtilService.replaceBy("^", "}", sqlUtilService.replaceBy("^^", "#{", content));
			}
			logger.debug("content:"+content+"\ttype:"+type);
			
			rtv = msgConfigService.buildSonNode(nodeCode,content,type);
			
		} catch(SQLException e){
			//执行SQL异常
			//e.printStackTrace();
			return new ArrayList<NodeTree>();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ArrayList<NodeTree>();
		}
		return rtv;
	}
	/**
	 * 添加节点
	 * @return
	 */
	@RequestMapping(value="/addNodeUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> addNodeUrl(HttpServletRequest request,
			 @RequestParam Integer id
			,@RequestParam Integer fid
			,@RequestParam String nodeCode
			,@RequestParam("text") List<String> texts){
		Map<String,String> map = new HashMap<String,String>();
		logger.debug("添加节点开始：");
		try{
			System.out.println("nodeCode"+nodeCode);
			String content = request.getParameter("content");
			String type = request.getParameter("type");
			content = new String(content.getBytes("ISO8859-1"),"UTF-8");
			if(content != null){
				//将 ^^ 与 ^ 替换回来
				content = sqlUtilService.replaceBy("^", "}", sqlUtilService.replaceBy("^^", "#{", content));
			}
			System.out.println("CONTENT : "+content);
			List<NodeTree> children = new ArrayList<NodeTree>();
			NodeTree thisNode = new NodeTree();
			thisNode.setId(id);
			thisNode.setFid(fid);
			thisNode.setSonNodeContent(content);
			thisNode.setSonNodeType(type);
			thisNode.setText(nodeCode);
			for(String text : texts){
				NodeTree node = new NodeTree();
				node.setText(text);
				node.setFid(id);
				children.add(node);
			}
			thisNode.setChildren(children);
			int i = msgConfigService.saveNodeTree(thisNode);
			if(i>0){
				map.put("msg", "保存成功");
			}else{
				map.put("msg", "保存失败");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("exception", e.getMessage());
			map.put("msg", "保存异常，请重试");
		}
		return map;
	}
	
	@RequestMapping(value="/dtoRootUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<NodeTree> dtoRootUrl(@RequestParam String type,@RequestParam String formatType,@RequestParam String bussType){
		List<NodeTree> nodeTrees = new ArrayList<NodeTree>();
		logger.debug("nodeTreeList type:"+type);
		/**
		 * type = 0,从临时表获取
		 * type = 1,原始表获取
		 * **/
		if(type != null && "0".equals(type)){
			return msgConfigService.getDTORootFromTemp(type,formatType,bussType);
		}else if(type == null || "1".equals(type)){
			
		}else{
			
		}
		return nodeTrees;
	}
	@RequestMapping(value="/nodeRootUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<NodeTree> nodeRootUrl(@RequestParam String type){
		List<NodeTree> nodeTrees = new ArrayList<NodeTree>();
		logger.debug("nodeTreeList type:"+type);
		/**
		 * type = 0,从临时表获取
		 * type = 1,原始表获取
		 * **/
		if(type != null && "0".equals(type)){
			return msgConfigService.getNodeRootFromTemp();
		}else if(type == null || "1".equals(type)){
			
		}else{
			
		}
		return nodeTrees;
	}
	@RequestMapping(value="/nodeTreeList", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<NodeTree> nodeTreeList(@RequestParam String type,@RequestParam("id") List<Integer> ids){
		List<NodeTree> nodeTrees = new ArrayList<NodeTree>();
		logger.debug("nodeTreeList type:"+type);
		/**
		 * type = 0,从临时表获取
		 * type = 1,原始表获取
		 * **/
		if(type != null && "0".equals(type)){
			return msgConfigService.getTempNodeList(ids);
		}else if(type == null || "1".equals(type)){
			
		}else{
			
		}
		return nodeTrees;
	}
	@RequestMapping(value="/getTempNodeSql", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> getTempNodeSql(@RequestParam Integer id){
		Map<String,String> map = msgConfigService.getNodeSql(id);
		return map;
	}

	@RequestMapping(value = "/nodeAttriSaveUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> nodeAttriSave(@RequestParam Integer operater,
			TTempNodeAttri nodeAttri) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int i = msgConfigService.saveTempNodeAttri(operater,nodeAttri);
			if(i == -1){
				map.put("msg", "节点："+nodeAttri.getAttriCode()+" 已经存在");
				return map;
			}
			map.put("msg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存异常，请重试");
		}
		return map;
	}
	
	@RequestMapping(value="/nodeParamSave", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> nodeParamSave(@RequestParam Integer operater,
			TTempNodeParam nodeParam) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int i = msgConfigService.saveTempNodeParam(operater,nodeParam);
			if(i == -1){
				map.put("msg", "参数："+nodeParam.getParamName()+" 已经存在");
				return map;
			}
			map.put("msg", "保存成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存异常，请重试");
		}
		return map;
	}
	@RequestMapping(value="/deleteTempNodeAttri", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> deleteTempNodeAttri(@RequestParam Integer id) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int i = msgConfigService.deleteTempNodeAttri(id);
			if (i > 0) {
				map.put("msg", "删除成功");
			} else {
				map.put("msg", "删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "删除异常，请重试");
		}
		return map;
	}
	@RequestMapping(value="/deleteTempNodeParam", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> deleteTempNodeParam(@RequestParam Integer id) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map.put("result", "success");
			boolean isSysDefault = msgConfigService.isSysDefaultParam(id);
			if(isSysDefault){
				map.put("result", "false");
				map.put("msg", "系统默认参数，禁止删除。");
				return map;
			}
			int i = msgConfigService.deleteTempNodeParam(id);
			if (i > 0) {
				map.put("msg", "删除成功");
			} else {
				map.put("result", "false");
				map.put("msg", "删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "删除异常，请重试");
		}
		return map;
	}
	@RequestMapping(value="/deleteTempNode", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> deleteTempNode(@RequestParam Integer id) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			int i = msgConfigService.deleteTempNode(id);
			if (i > 0) {
				map.put("msg", "success");
			} else {
				map.put("msg", "删除失败");
			}
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "删除异常，请重试");
		}
		return map;
	}
	/**
	 * 保存报文规则引擎
	 * @param request
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/saveXEnginUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> saveXEngin(HttpServletRequest request,MsgConfigPOJO pojo){
		String xdesc = pojo.getMsgDesc();
		String nodeTreeIds = request.getParameter("nodeTreeIds");
		if(nodeTreeIds != null){
			List<Integer> nodeIds = new ArrayList<Integer>();
			if(nodeTreeIds.contains(";")){
				String[] ids = nodeTreeIds.split(";", -1);
				for(String tId : ids){
					Integer id = Integer.parseInt(tId);
					nodeIds.add(id);
				}
			}else{
				nodeIds.add(Integer.parseInt(nodeTreeIds));
			}
			pojo.setNodeIds(nodeIds);
		}
		logger.debug("保存报文规则引擎： "+xdesc);
		LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		pojo.setUserCode(loginfo.getUserCode());
		Map<String,String> map = new HashMap<String,String>();
		Map<String,String> result = msgConfigService.saveMsgEngin(loginfo,pojo);
		map.putAll(result);
		return map;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
