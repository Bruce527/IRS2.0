package com.sinosoft.platform.core.interfaces.user;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.icbc.ssic.base.Credentials;
import com.icbc.ssic.base.SSICUser;
import com.icbc.ssic.base.SSICUserInfo;
import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.spring.BeanFactory;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;

import config.Config;
/**
 * Welcome 服务处理类
 * @author Darker.Wang
 * @date 2016-8-10 下午3:46:27
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/welcome")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class WelcomeController {

	@Autowired
	private UserService userService;
	@Autowired
	CodeQueryService codeQueryService;
	private static final Logger log = Logger.getLogger(WelcomeController.class);

	/**
	 * 获取页面url
	 */
	@RequestMapping(value = "/listStartUrl", method = RequestMethod.GET)
	public String listMenuUrl() {
		return "start";
	}
	@RequestMapping(value = "/checkUrl", method = RequestMethod.GET)
	public String testUrl(){
		return "checkApp";
	}
	
	@RequestMapping(value = "/checkAlive", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> test(){
		System.out.println("这里是校验输出信息:");
		Map<String,String> map = new HashMap<String,String>();
		map.put("msg", "success");
		map.put("date", DateUtils.getCurrentDateTime());
		try{
			String maxNo = ((SequenceService) BeanFactory.getApplicationContext()
					.getBean("sequenceService")).getMaxNo("SEQ_MAXNO", 10);
			if(maxNo == null || "".equals(maxNo)){
				map.put("msg", "fail");
				map.put("app", "alive");
				map.put("db", "stop");
			}else{
				map.put("app", "alive");
				map.put("db", "alive");
			}
		}catch(Exception e){
			map.put("exception", e.getMessage());
			map.put("db", "exception");
		}
		return map;
	}
	/**
	 * 本地入口
	 * @param user
	 * @param model
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/loginUrl", method = RequestMethod.POST)
	@ResponseBody
	public HashMap<String, String> findUserByName(DefUser user, ModelMap model) {
		HashMap<String, String> msgMap = new HashMap<String, String>();
		try {
			msgMap.put("msg", "fail");
			DefUser tUser = userService.findUserByUser(user);
			if(tUser == null){
				msgMap.put("message", "用户："+user.getUsercode()+" 不存在,请重试!");
				return msgMap;
			}
			if(tUser.getEmpowerType() == null){
				//统一认证用户无需验证密码
				msgMap.put("message", "用户认证方式未确定，请联系管理员!");
				return msgMap;
			}
			/*******CR1800450**********/
			//校验认证方式是否相同
//			if(!tUser.getEmpowerType().equals(user.getEmpowerType())){
//				msgMap.put("message", "认证错误，请选择正确的认证方式!");
//				return msgMap;
//			}
			/*******END**********/
			if(tUser.getUserState() == null || "".equals(tUser.getUserState())){
				msgMap.put("message", "未知或无效用户！");
				return msgMap;
			}
			if(tUser.getUserState().equals("0")){
				msgMap.put("message", "用户已失效,请联系管理员!");
				return msgMap;
			}
			if(tUser.getUserState().equals("2")){
				msgMap.put("message", "用户已失删除,请联系管理员!");
				return msgMap;
			}
			if(tUser.getIsLock().equals("1")){
				msgMap.put("message", "用户已锁定,请联系管理员!");
				return msgMap;
			}
			//统一认证用户无需校验密码
			if(tUser.getEmpowerType().equals("0")){
				msgMap.put("msg", "success");
				return msgMap;
			}
			/********CR1800450*********/
			//域认证方式校验
			if(tUser.getEmpowerType().equals("2")){
				String username=user.getUsercode().toLowerCase();
				String password=user.getPassword();
				System.out.println("域账号"+username+"===密码"+password);
				if(!userService.checkADLogin(username, password)) {
					msgMap.put("message", "域认证失败!");
					return msgMap;
				}
				msgMap.put("msg", "success");
				return msgMap;
			}
			 /**********END***************/
			//本地认证用户则需验证密码
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			if (!tUser.getPassword().equals(md5.encodePassword(user.getPassword(), null))){
				msgMap.put("message", "用户名或密码错误!");
				return msgMap;
			}
			msgMap.put("msg", "success");
			log.info("用户登录成功");
		} catch (CoreException e) {
			msgMap.put("msg", "fail");
			msgMap.put("errCode", e.getErrorCode());
			msgMap.put("errorCode", e.getErrorCode());
			msgMap.put("message", e.getMessage());
			msgMap.put("usercode", user.getUsercode());
			msgMap.put("password", user.getPassword());
			log.info("用户登录失败");
		}
		return msgMap;
	}
	
	/**
	 * 统一认证用户校验接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/queryTellerInfo", method = RequestMethod.POST)
	public void queryTellerInfo(DefUser tUser, HttpServletRequest request,
			HttpServletResponse response) {
		try {
			if (tUser.getUsercode() != null) {
				LoginInfo loginInfo = (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
				// 替换成客户端的专业系统标识
				String clientSiteno = Config.getProperties().getProperty("SSIC_SERVERIP");
				// 替换成查询返回页面实际的路径
				String tellerURL = Config.getProperties().getProperty("SITE_SERVERURL")+"/getTellerInfo";
				String tellerno = tUser.getUsercode();// 替换成被查询的通行证号
				log.info("正在校验用户是否存在，操作用户" + loginInfo.getUserCode() + "，校验用户："
						+ tellerno);
				SSICUser user = new SSICUser(loginInfo.getUserCode());// 替换成执行查询操作的通行证号
				Credentials cred = new Credentials(user, "60000");// 超时时间为60000毫秒
				// 身份认证公钥和专业系统私钥
				cred.generate(Config.getPublicKey(), Config.getPrivateKey());
				String serverIP = Config.getProperties().getProperty("SSIC_SERVERIP");
				String serverQTI = Config.getProperties().getProperty("SSIC_QUERYTELLERINFO");
				response.sendRedirect(serverIP+serverQTI+ "?"
						+ cred.getAuthStringURL() + "&SERVICENAME=" + clientSiteno
						+ "&serviceURL=" + tellerURL + "&TELLERNO=" + tellerno);
			}
			
		} catch (Exception e) {
			System.out.println("查询人员详细信息接口异常:" + e.toString());
			e.printStackTrace();
		} finally {
			
		}
	}
	/**
	 * 校验返回处理接口
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/getTellerInfo", method = RequestMethod.POST)
	@ResponseBody
	public DefUser getTellerInfo(HttpServletRequest request,
			HttpServletResponse response) {
		DefUser tUser = null;
		String retcode = request.getParameter("retcode");
		String ssiAuth = request.getParameter("SSIAuth");
		String ssiSign = request.getParameter("SSISign");
		try {
			if (retcode.equals("0")) {
				tUser = new DefUser();
				Credentials cred = new Credentials(ssiAuth, ssiSign);
				if (cred.isvalidate(Config.getPublicKey())) {
					SSICUserInfo userinfo = cred.getSSICUserInfo();
					String tellerNo = userinfo.getUsername();
					String name = userinfo.getName();
					String branchId = userinfo.getBranchId();
					tUser.setUsercode(tellerNo);
					tUser.setUsername(name);
					tUser.setEmpowerType("0");
					tUser.setEmpowerCode(tellerNo);
					tUser.setCreatorCode(ssiAuth);
					tUser.setCompanyId(new BigDecimal(branchId));
					return tUser;
				}
			}
		} catch (Exception e) {
			System.out.println("统一认证返回校验用户信息获取失败："+e.toString());
			e.printStackTrace();
		}
		return null;
	}
	/**
	 *  welcome
	 * @param request
	 * @param user
	 * @param model
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView welcomeUrl(DefUser user, ModelMap model,HttpServletRequest request,HttpServletResponse response) {
		String userIp = getRequestIp(request);
		DefUser returnUser;
		try {
			returnUser = userService.findUserByUser(user);
			LoginInfo loginInfo = new LoginInfo();
			loginInfo.setUserIp(userIp);
			loginInfo.setUserId(returnUser.getId());
			loginInfo.setUserCode(returnUser.getUsercode());
			loginInfo.setUserName(returnUser.getUsername());
			loginInfo.setCompanyId(returnUser.getCompanyId());
			loginInfo.setLoginCompanyId(user.getCompanyId());
			loginInfo.setEmpowerType(returnUser.getEmpowerType());
			
			model.addAttribute(Constants.USER_INFO_SESSION, loginInfo); // 名为Constants.USER_INFO_SESSION的属性放到Session属性列表中
			model.addAttribute("userip", userIp);
			HashMap<String, String> map = userService.queryLoginInfo(loginInfo);
			
			log.info(returnUser.getUsercode()+"\t"+userIp);
			userService.addUserTrace(loginInfo, "welcome/welcomeUrl",null, "登录系统");
			return new ModelAndView("welcome", map);
		} catch (CoreException e) {
			e.printStackTrace();
			HashMap<String, String> map = new HashMap<String,String>();
			map.put("msg", "登录失败");
			return new ModelAndView("/index.jsp", map);
		}
		
	}

	@RequestMapping(value = "/reloadUrl", method = RequestMethod.GET)
	public String addUserUrl(){
		return  "reloadurl";
	}
	
	@RequestMapping(value = "/sessionReloadUrl", method = RequestMethod.GET)
	public String sessionReloadUrl(){
		return  "sessionreloadurl";
	}
	
	@RequestMapping(value = "/queryMenu", method = RequestMethod.POST)
	@ResponseBody
	public List<Nodes> queryMenu(ModelMap model) {
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		return userService.queryMenu(loginInfo.getUserCode());
	}
	/**
	 * 初始化我的任务
	 * @return
	 */
	@RequestMapping(value = "/listTaskUrl", method = RequestMethod.GET)
	public String listTaskUrl(HttpServletRequest requst){
		LoginInfo loginInfo = (LoginInfo)requst.getSession().getAttribute(Constants.USER_INFO_SESSION);
		log.debug("我的任务初始化中："+loginInfo);
		return "platform/task/listTask";
	}
	
	/**
	 * 获取请求客户端访问的IP
	 * @param request
	 * @return
	 */
	private String getRequestIp(HttpServletRequest request){
		String ip = null;
		if(request == null){
			return ip;
		}
		//正常访问
		ip = request.getHeader("x-forwarded-for");
		//从代理中取
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("Proxy-Client-IP");
		}
		//从域名中取
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		//远程获取
		if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
			ip = request.getRemoteAddr();
		}
		log.info(ip);
		return ip.equals("0:0:0:0:0:0:0:1")?"127.0.0.1":ip;
	}
	
	@RequestMapping(value = "/listEmpowerType", method = RequestMethod.POST)
	@ResponseBody
	public List<TDefCodeDict> listEmpowerType() {
		List<TDefCodeDict> codes = codeQueryService.queryCode("EMPOWER_TYPE");
		log.debug("认证方式:  "+codes);
		return codes;
	}

}
