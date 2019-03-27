package com.sinosoft.platform.core.interfaces.role;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.MenuService;
import com.sinosoft.platform.core.application.RoleService;
import com.sinosoft.platform.core.domain.model.DefRole;
import com.sinosoft.platform.core.domain.model.DefRolePrivilegeRela;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;
/**
 * 角色控制器
 * @author Darker.Wang
 * @date 2016-10-17 上午11:21:38
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/role")
public class RoleController {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuService menuService;
	private static final Logger log = Logger.getLogger(RoleController.class);

	/**
	 * 获取角色页面url
	 */
	@RequestMapping(value = "/listRoleUrl", method = RequestMethod.GET)
	public String rolelist() {
		return "platform/core/role/listRole";
	}

	/**
	 * 查询角色列表
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, DefRole role) {
		// spring可以自动装配两个对象 会自动的装返回的Map转换成JSON对象
		return roleService.getPageList(dgm, role);
	}

	/**
	 * 获取角色增加页面url
	 */
	@RequestMapping(value = "/addRoleUrl", method = RequestMethod.GET)
	public String menuadd() {
		return "platform/core/role/addRole";
	}

	/**
	 * 获取角色更新页面url
	 */
	@RequestMapping(value = "/updateRoleUrl", method = RequestMethod.GET)
	public ModelAndView updateRoleUrl(BigDecimal id) {
		DefRole defRole = this.roleService.selectById(id);
		return  new ModelAndView("platform/core/role/updateRole","defRole",defRole);
	}

	/**
	 * 获取分配菜单页面url
	 */
	@RequestMapping(value = "/setRoleUrl", method = RequestMethod.GET)
	public ModelAndView setRoleUrl(BigDecimal id) {
		DefRole defRole = this.roleService.selectById(id);
		return  new ModelAndView("platform/core/role/setRole","defRole",defRole);
	}
	/**
	 * 获取分配菜单页面url
	 */
	@RequestMapping(value = "/setPlatformUrl", method = RequestMethod.GET)
	public ModelAndView setPlatformUrl(BigDecimal id) {
		DefRole defRole = this.roleService.selectById(id);
		return  new ModelAndView("platform/core/role/setPlatform","defRole",defRole);
	}

	/**
	 * 获取分配系统页面url
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/setSystemUrl", method = RequestMethod.GET)
	public ModelAndView setSystemUrl(@RequestParam("list") String s) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			map = list.get(0);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("platform/core/role/setSystem", map);
	}

	/**
	 * 增加菜单
	 */
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveAdd(DefRole role,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			roleService.save(role,loginInfo);
			map.put("mes", "操作成功");
			log.info("角色增加成功");
		} catch (CoreException e) {
			e.printStackTrace();
			map.put("mes", "操作失败，原因是" + e.getMessage());
			log.info("角色增加失败，原因是" + e.getMessage());
		}
		return map;
	}

	/**
	 * 更新菜单
	 */
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveUpdate(DefRole role,ModelMap model) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			roleService.updateRole(role,loginInfo);
			map.put("mes", "操作成功");
			log.info("角色更新成功");
		} catch (CoreException e) {
			e.printStackTrace();
			map.put("mes", "操作失败，原因是" + e.getMessage());
			log.info("角色更新失败，原因是" + e.getMessage());
		}
		return map;
	}

	/**
	 * 分配菜单
	 */
	@SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	@RequestMapping(value = "/saveSet", method = RequestMethod.POST)
	@Transactional
	@ResponseBody
	public Map<String, String> saveSet(@RequestParam("list") String s,ModelMap model) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			LinkedHashMap<String, Object> m = list.get(0);
			BigDecimal roleId = new BigDecimal(m.get("roleId").toString());
			roleService.deleteR2P(roleId, "localmenu",loginInfo);
			roleService.deleteR2P(roleId, "remotemenu",loginInfo);
			DefRole role = roleService.get(roleId);
			ArrayList menuId = (ArrayList)m.get("menuId");
			ArrayList distinctMenuId1 = distinctMenuId(menuId);
			ArrayList distinctMenuId = roleService.menuIdaddPid(distinctMenuId1);
			
			for(int i=0;i<distinctMenuId.size();i++){
				DefRolePrivilegeRela defRolePrivilegeRela = new DefRolePrivilegeRela();
				//菜单项
				String id = distinctMenuId.get(i).toString();
				defRolePrivilegeRela.setPrivilegeId(new BigDecimal(id));
				//角色项
				defRolePrivilegeRela.setRoleId(roleId);
				roleService.saveSet(defRolePrivilegeRela,loginInfo);
			}
			
			//roleService.save(role);
			map.put("mes", "操作成功");
			log.info("分配菜单成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			log.info("分配菜单失败");
		}
		return map;
	}
	/**
	 * 分配平台
	 * @param s
	 * @param model
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="/savePlatSet",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> savePlatSet(@RequestParam("list") String s,ModelMap model) throws CoreException{
		Map<String,String> map=new HashMap<String,String>();
		try {
			List<LinkedHashMap<String,Object>> list = objectMapper.readValue(s, List.class);
			LinkedHashMap<String, Object> m = list.get(0);
			BigDecimal roleId= new BigDecimal(m.get("roleId").toString());
			ArrayList platIds = (ArrayList) m.get("platId");
			roleService.dealWithPlatId(roleId,platIds);
			map.put("mes", "操作成功！");
			log.info("分配平台成功！");
		}catch (Exception e) {
			map.put("mes", "分配平台失败");
			log.info("分配平台失败");
			e.printStackTrace();
		}
		
		return map;
	}
	/**去除重复的菜单
	 * @param menuIds
	 * @return 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ArrayList distinctMenuId(ArrayList menuIds) {
		ArrayList list = new ArrayList();
		for (Object menuId : menuIds) {
			if(!list.contains(menuId)){
				list.add(menuId);
			}
		}
		return list;
	}

	/**
	 * 分配应用
	 */
	@SuppressWarnings({ "unused", "rawtypes", "unchecked" })
	@RequestMapping(value = "/saveSetSystem", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveSetSystem(@RequestParam("list") String s,ModelMap model) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			LinkedHashMap<String, Object> m = list.get(0);
			BigDecimal roleId = new BigDecimal(m.get("roleId").toString());
			roleService.deleteR2P(roleId, "system",loginInfo);
			DefRole defRole = roleService.get(roleId);
			ArrayList menuId = (ArrayList) m.get("menuId");
			map.put("mes", "操作成功");
			map.put("succ", "true");
			log.info("分配应用成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("false", "true");
			map.put("mes", "操作失败");
			log.info("分配应用失败");
		}
		return map;
	}

	/**
	 * 删除菜单
	 */
	@RequestMapping(value = "/deleteRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("rid") List<BigDecimal> rid,ModelMap model) throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			for(BigDecimal id : rid){
				roleService.deleteRole(id,loginInfo);
			}
			map.put("mes", "删除成功");
			log.info("角色删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			log.info("角色删除失败");
		}
		return map;// 重定向
	}

	/**
	 * 查询角色已有菜单
	 */
	@RequestMapping(value = "/queryMenu", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> queryMenu(@RequestParam("roleId") String rid) {
		return roleService.queryMenu(new BigDecimal(rid));
	}

	/**
	 * 查询角色已有菜单
	 */
	@RequestMapping(value = "/queryMenuWithRemote", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> queryMenuWithRemote(@RequestParam("roleId") String rid) {
		return roleService.queryMenu(new BigDecimal(rid), true);
	}
	/**
	 * 查询角色已有平台
	 */
	@RequestMapping(value="queryRole2Plat",method=RequestMethod.POST)
	@ResponseBody
	public List<Nodes> queryRole2Plat( String roleId){
		
		return roleService.queryPlat(new BigDecimal(roleId));
	}

	/**
	 * 查询已有角色
	 */
	@RequestMapping(value = "/listRole", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> listRole(BigDecimal userId) {
		return roleService.queryRole(userId);
	}

	/**
	 * 查询角色已有系统
	 */
	@RequestMapping(value = "/querySystem", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> querySystem(@RequestParam("roleId") String rid) {
		return roleService.querySystem(new BigDecimal(rid));
	}

	/**
	 * 查询所有系统
	 */
	@RequestMapping(value = "/listSystem", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> listSystem() {
		return roleService.querySystem();
	}
	/**
	 * 查询平台
	 */
	@RequestMapping(value="/listPlat",method=RequestMethod.POST)
	@ResponseBody
	public List<Nodes> listPlat(ModelMap model){
		return roleService.queryPlat();
	}

}
