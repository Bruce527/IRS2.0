package com.sinosoft.platform.core.interfaces.user;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 * Description 用户控制器
 *****************************************************/
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.CodeMappingService;
import com.sinosoft.platform.core.application.RoleService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.model.DefUserRoleRela;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;
//将Model中属性名为Constants.USER_INFO_SESSION的属性放到Session属性列表中，以便这个属性可以跨请求访问
@SessionAttributes(Constants.USER_INFO_SESSION)
@Controller
@RequestMapping("/user")
public class UserController {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	CodeMappingService codeMappingService;

	private static final Logger log = Logger.getLogger(UserController.class);
	/**
	 * 获取用户页面url
	 */
	@RequestMapping(value = "/listUserUrl", method = RequestMethod.GET)
	public String list(Model model) {
		return "platform/core/user/listUser";
	}
	/**
	 * 查询用户列表
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, DefUser user,TDefCodeDict dict){
		return userService.getPageList(dgm, user, dict);
	}
	/**
	 * 根据usercode查询id
	 */
	@RequestMapping(value = "/queryIdByusercode", method = RequestMethod.POST)
	@ResponseBody
	public BigDecimal queryIdByusercode( DefUser defUser){
		return userService.getIdByUsercode(defUser);
	}
	/**
	 * 获取增加用户页面url
	 */
	@RequestMapping(value = "/addUserUrl", method = RequestMethod.GET)
	public String addUserUrl(HttpServletRequest request,ModelMap model){
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		String userCode = loginInfo.getUserCode();
		model.addAttribute("userCode", userCode);
		return "platform/core/user/addUser";
	}
	/**
	 * 获取更新用户页面url
	 */
	@RequestMapping(value = "/updateUserUrl", method = RequestMethod.GET)
	public ModelAndView updateUserUrl(BigDecimal id,ModelMap model) {
		
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		String userCode = loginInfo.getUserCode();
		model.addAttribute("userCode", userCode);
		DefUser defUser = userService.selectById(id);
		return new ModelAndView("platform/core/user/updateUser","defUser",defUser);
	}
	/**   
	 * 增加用户
	 */
	@RequestMapping(value = "/checkUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> checkUser(ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			//校验是否是统一认证用户 是 true 否 false
			boolean result = userService.checkUser(loginInfo);
			if(!result){
				map.put("result", ""+result);
				return map;
			}
			map.put("result", ""+result);
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败,原因是"+e.getMessage());
		}
		return map;
	}
	/**   
	 * 增加用户
	 */
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveAdd(DefUser user,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			user.setCreatorCode(loginInfo.getUserCode());
			userService.addUser(user,loginInfo);
			map.put("mes", "操作成功");
		} catch (Exception e) {
			//e.printStackTrace();
			map.put("mes", "操作失败,原因是"+e.getMessage());
		}
		return map;
	}
	/**
	 * 更新用户
	 */
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveUpdate(DefUser user,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			userService.updateUser(user,loginInfo);
			map.put("mes", "操作成功");
		} catch (CoreException e) {
			e.printStackTrace();
			map.put("mes", "操作失败,原因是"+e.getMessage());
		}
		return map;
	}
	/**
	 * 获取分配角色页面url
	 */
	@RequestMapping(value = "/setUserUrl", method = RequestMethod.GET)
	public ModelAndView setRoleUrl(BigDecimal id) {
		DefUser defUser = userService.selectById(id);
		return new ModelAndView("platform/core/user/setUser","defUser",defUser);
	}
	/**
	 * 手动输入用户编码来获取分配角色新页面url
	 */
	@RequestMapping(value = "/setUserNUrl", method = RequestMethod.GET)
	public String setUserNUrl(ModelMap model){
		return "platform/core/user/setUserN";
	}
	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("id") List<String> uid,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			for (String id : uid) {
				userService.deleteUser(id,loginInfo);
			}
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
		}
		return map;// 重定向
	}
	
	/**
	 * 查询用户已有角色
	 */
	@RequestMapping(value = "/queryRole", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> queryRole(@RequestParam("userId") String uid) throws Exception {
		return userService.queryRole(new BigDecimal(uid));
	}
	/**
	 * 分配角色
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/saveSet", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public Map<String, String> saveSet(@RequestParam("list") String s,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			LinkedHashMap<String, Object> m = list.get(0);
			String userId = (String) m.get("userId");
			String userCode = (String) m.get("userCode");
			userService.deleteU2RByUserCode(userId, userCode);
			ArrayList roleId = (ArrayList)m.get("roleId");
			for(int i=0;i<roleId.size();i++){
				DefUserRoleRela defUserRoleRela = new DefUserRoleRela();
				String id = roleId.get(i).toString();
				defUserRoleRela.setRoleId(new BigDecimal(id));
				defUserRoleRela.setUserCode(userCode);
				if(userId != null && !"".equals(userId)){
					defUserRoleRela.setUserId(new BigDecimal(userId));
				}
				userService.saveSet(defUserRoleRela,loginInfo);
			}
			map.put("mes", "操作成功");
			log.info("角色分配成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "操作失败");
			log.info("角色分配失败");
		}
		return map;
	}
	/**
	 *modifyUserUrl
	 * */
	/**
	 * 获取修改用户名页面url
	 */
	@RequestMapping(value = "/modifyUserUrl", method = RequestMethod.GET)
	public String modifyUserUrl(){
		return "platform/core/user/modifyUser";
	}
	/**
	 * 保存修改过的用户名和密码
	 */
	@RequestMapping(value = "/modifySave", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> modifySave(@RequestParam("password") String password,@RequestParam("password1") String password1,ModelMap model) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		try{
	
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		 userService.modifySave(password,password1,loginInfo.getUserId());
		 map.put("mes", "操作成功");
			log.info("密码修改成功");
		}catch(CoreException e){
			map.put("mes", "用户原始密码输入错误!");
			log.info("密码修改失败，用户原始密码输入错误!");
		}catch(Exception e){
			map.put("mes", "操作失败");
			log.info("密码修改失败");
		}
		 return map;
	}
	
}
