package com.sinosoft.platform.core.interfaces.menu;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 * Description 菜单控制器
 *****************************************************/
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.MenuService;
import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;

@Controller
@RequestMapping("/menu")
public class MenuController {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private MenuService menuService;
	private static final Logger log = Logger.getLogger(MenuController.class);

	/**
	 * 获取页面url
	 */
	@RequestMapping(value = "/listMenuUrl", method = RequestMethod.GET)
	public String listMenuUrl() {
		return "platform/core/menu/listMenu";
	}

	/**
	 * 获取新增菜单url
	 */
	@RequestMapping(value = "/addMenuUrl", method = RequestMethod.GET)
	public String addMenuUrl() {
		return "platform/core/menu/addMenu";
	}

	/**
	 * 获取更新菜单url
	 */
	@RequestMapping(value = "/updateMenuUrl", method = RequestMethod.GET)
	public ModelAndView updateMenuUrl(BigDecimal id) {
		DefPrivilege defPrivilege=this.menuService.selectById(id);
		return new ModelAndView("platform/core/menu/updateMenu","defPrivilege",defPrivilege);
	}

	/**
	 * 获取菜单数据
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, DefPrivilege privilege){
		return menuService.getPageList(dgm, privilege);
	}

	/**
	 * 新增菜单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addMenu(@RequestParam("list") String s,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
				menuService.saveMenu(list,loginInfo);
			map.put("mes", "操作成功");
			log.info("菜单增加成功");
		} catch (Exception e) {
			map.put("mes", "操作失败");
			log.info("菜单增加失败");
			e.printStackTrace();
			
		}
		return map;
	}

	/**
	 * 删除菜单
	 */
	@RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteMenu(@RequestParam("pid") List<BigDecimal> pid,ModelMap model)
			throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			for (BigDecimal id : pid) {
				menuService.deleteMenu(id,loginInfo);
			}
			map.put("mes", "删除成功");
			log.info("菜单删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			log.info("菜单删除失败");
		}
		return map;// 重定向
	}

	/**
	 * 修改菜单
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateMenu(@RequestParam("list") String s,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			for (int i = 0; i < list.size(); i++) {
				DefPrivilege privilege = new DefPrivilege();
				privilege.setPrivilegename(list.get(i).get("name").toString());
				privilege.setPrivilegeDescribe(list.get(i).get("privilegeDescribe").toString());
				privilege.setPrivilegeSign(list.get(i).get("privilegeSign").toString());
				privilege.setId(new BigDecimal(list.get(i).get("id").toString()));
				privilege.setUrl(list.get(i).get("url").toString());
				privilege.setMethod((list.get(i).get("method") == null) ? "" : list.get(i).get("method").toString());
				privilege.setPre(list.get(i).get("pre").toString());
				privilege.setNext(list.get(i).get("next").toString());
				privilege.setPid(list.get(i).get("pid").toString());
				menuService.updatePrivilege(privilege,loginInfo);
			}
			map.put("mes", "操作成功");
			log.info("菜单更新成功");
		} catch (Exception e) {
			map.put("mes", "操作失败");
			log.info("菜单更新失败");
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 查询菜单
	 */
	@RequestMapping(value = "/listMenu", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> listMenu(ModelMap model){
		return menuService.queryMenu();
	}
}
