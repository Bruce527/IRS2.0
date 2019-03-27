package com.sinosoft.ummp.interfaces.managecom;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.domain.mapper.DefPrivilegeMapper;
import com.sinosoft.platform.core.domain.mapper.TDefManageComMapper;
import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.domain.model.TDefCodeMapping;
import com.sinosoft.platform.core.domain.model.TDefManageCom;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.ManageComService;

/*****************************************************
 * HISTORY
 * 
 * 2016/07/04 lht 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 * Description 管理机构控制器
 *****************************************************/
@Controller
@RequestMapping("/managecom")
public class ManageComController {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private ManageComService manageComService;
	private static final Logger log = Logger.getLogger(ManageComController.class);
	/**
	 * 获取页面url
	 */
	@RequestMapping(value = "/listManageComUrl", method = RequestMethod.GET)
	public String listManageComUrl() {
		return "ummp/managecom/listManageCom";
	}
	/**
	 * 获取管理机构数据
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TDefManageCom tDefManageCom){
		return manageComService.getPageList(dgm, tDefManageCom);
	}
	/**
	 * 获取增加管理机构页面url
	 */
	@RequestMapping(value = "/addManageComUrl", method = RequestMethod.GET)
	public String addManageComUrl(ModelMap model){
		return "ummp/managecom/addManageCom";
//		return "user/listReport";
	}
	/**
	 * 获取更新机构页面url
	 */
	@RequestMapping(value = "/updateManageComUrl", method = RequestMethod.GET)
	public ModelAndView updateManageComUrl(BigDecimal id) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		TDefManageCom tDefManageCom = this.manageComService.selectById(id);
		return  new ModelAndView("ummp/managecom/updateManageCom","tDefManageCom",tDefManageCom);
	}
//		try {
//			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
//			map = list.get(0);
//			String manageName = (String) map.get("manageName");
//			 if(manageName != null){
//				 manageName = new String(manageName.getBytes("ISO8859-1"),"utf-8");
//			 		map.put("manageName", manageName);
//		     }
//			 String manageNameShort=(String) map.get("manageNameShort");
//			 if(manageNameShort != null ){
//				 manageNameShort=new String(manageNameShort.getBytes("ISO8859-1"),"utf-8");
//				 	map.put("manageNameShort", manageNameShort);
//			 }
//			 String address=(String) map.get("address");
//			 if(address != null ){
//				 address=new String(address.getBytes("ISO8859-1"),"utf-8");
//				 	map.put("address", address);
//			 }
//			 String remark=(String) map.get("remark");
//			 if(remark != null ){
//				 remark=new String(remark.getBytes("ISO8859-1"),"utf-8");
//				 	map.put("remark", remark);
//			 }
//			 String mmonitorType=(String) map.get("mmonitorType");
//			 if(mmonitorType != null ){
//				 mmonitorType=new String(mmonitorType.getBytes("ISO8859-1"),"utf-8");
//				 	map.put("mmonitorType", mmonitorType);
//			 }
//		} catch (JsonParseException e) {
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace(); 
//		}
	/**   
	 * 增加管理机构
	 */
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addManageCom(TDefManageCom tDefManageCom,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		
		try {
			manageComService.saveManageCom(tDefManageCom,loginInfo);
			map.put("mes", "操作成功");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("mes", "操作失败,原因是"+e.getMessage());
		}
		
		return map;
	}
	/**
	 * 更新管理机构
	 */
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveUpdate(TDefManageCom tDefManageCom,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		manageComService.updateManageCom(tDefManageCom,loginInfo);
		map.put("mes", "操作成功");
		return map;
	}
	/**
	 * 删除管理机构
	 */
	@RequestMapping(value = "/deleteManageCom", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteManageCom(@RequestParam("id") List<BigDecimal> mid,ModelMap model)
			throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : mid) {
				manageComService.deleteManageCom(id);
			}
			map.put("mes", "删除成功");
			log.info("机构删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			log.info("机构删除失败");
		}
		return map;// 重定向
	}
}

