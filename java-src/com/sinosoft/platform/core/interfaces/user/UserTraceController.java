/**
 * 
 */
package com.sinosoft.platform.core.interfaces.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 用户履历操作控制器
 * @author Darker.Wang
 * @date 2016-8-19 上午11:03:02
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/usertrace")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class UserTraceController {

	Logger logger = Logger.getLogger(UserTraceController.class);
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/insertTrace", method = RequestMethod.POST)
	@ResponseBody
	public String insertTrace(HttpServletRequest request){
		try{
			String url = request. getParameter("url");
			String title = request. getParameter("title");
			LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute(Constants.USER_INFO_SESSION);
			logger.info("USER : "+loginInfo.getUserCode()+" 访问 : "+title+"\tURL: "+url);
			userService.addUserTrace(loginInfo, url, "", title);
			return "USER LOG INSERT SUCCESS";
		}catch(Exception e){
			//e.printStackTrace();
			logger.error("用户日志插入异常："+e.getMessage());
			return "USER LOG INSERT EXCEPTION";
		}
	}

	/**
	 * 获取操作日志页面Url
	 */
	@RequestMapping(value="/listTraceUrl",method=RequestMethod.GET)
	public String listOperateReportUrl(ModelMap model){
		return "platform/core/user/listTrace";
	}
	/**
	 * 查询报表
	 */
	@RequestMapping(value = "/queryListLog", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryListLog(DataGridModel dgm, DefUser user){
		return userService.getPageListLog(dgm, user);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
