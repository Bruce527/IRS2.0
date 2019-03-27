package com.sinosoft.platform.core.interfaces.query;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefManageCom;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefRole;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * 枚举查询组件控制器
 * @author Darker.Wang
 * @date 2016-6-13 下午6:11:32
 * 
 */
@Controller
@RequestMapping("/query")
public class CodeQueryController {

	@Autowired
	CodeQueryService codeQueryService;
	@Autowired
	UserService userService;
	
	private static final Logger loger = Logger.getLogger(CodeQueryController.class);
	
	public CodeQueryController() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 枚举查询，直接查询获取类型对应的Code，不在乎用户
	 * @param request codeQueryUrl?codetype=XXX&code=XX
	 * @return
	 */
	@RequestMapping(value="/codeQueryUrl",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefCodeDict> codeQueryUrl(HttpServletRequest request){
		String codetype = request.getParameter("codetype");
		String code = request.getParameter("code");
		List<TDefCodeDict> codes = (List<TDefCodeDict>) codeQueryService.queryCode(codetype,code);
		loger.debug(codes);
		return codes;
	}
	@RequestMapping(value="/listManageNameUrl",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefManageCom> listManageNameUrl(HttpServletRequest request){
		List<TDefManageCom> list = userService.getAllManage();
		return list;
	}
	/**
	 * 枚举查询，根据类型，编码查询，关联用户
	 * @param request codetype=XX&code=XX
	 * @return
	 */
	@RequestMapping(value="/codeQuery",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefCodeDict> codeQuery(HttpServletRequest request){
		List<TDefCodeDict> codes = null;
		try {
			// TODO Auto-generated catch block
			request.setCharacterEncoding("UTF-8");
			String codetype = (String)request.getParameter("codetype");
			String code = (String)request.getParameter("code");
			LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
			codes = codeQueryService.queryCode(codetype,code,loginfo);
			loger.debug(" ======> QUERY CODE : "+codes);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codes;
	}
	/**
	 * 枚举查询，根据对象查询，关联用户
	 * @param request
	 * @param tCode
	 * @return
	 */
	@RequestMapping(value="/codeQueryBy",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefCodeDict> codeQueryBy(HttpServletRequest request,TDefCodeDict tCode){
		List<TDefCodeDict> codes = null;
		try {
			// TODO Auto-generated catch block
			String codetype = tCode.getCodeType();
			String code = tCode.getCode();
			LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
			codes = codeQueryService.queryCode(codetype,code,loginfo);
			loger.debug(codes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return codes;
	}
	/**
	 * 枚举查询，根据类型查询，关联用户
	 * @param request codeQueryUrl?codetype=XXX
	 * @return
	 */
	@RequestMapping(value="/codeQueryByType",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefCodeDict> codeQueryByType(@RequestParam String codetype,HttpServletRequest request){
		LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		if(codetype == null){
			codetype =  request.getParameter("codetype");
		}
		List<TDefCodeDict> codes = codeQueryService.queryCode(codetype, loginfo);
		return codes;
	}
	/**
	 * 枚举查询，根据类型查询，关联用户
	 * @param request codeQueryUrl?codetype=XXX
	 * @return
	 */
	@RequestMapping(value="/codeQueryByCom",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefCodeDict> codeQueryByCom(@RequestParam String codetype,@RequestParam BigDecimal comid){
		List<TDefCodeDict> codes = codeQueryService.queryCode(codetype, comid);
		return codes;
	}
	/**
	 * 根据用编码获取用户所在平台信息，受用户权限限制
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listPlatUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefPlatCom> listPlatUrl(HttpServletRequest request){
		LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		return codeQueryService.listPlatsByUserCode(loginfo.getUserCode());
	}
	/**
	 * 根据用编码获取用户所在平台信息，受ID限制
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listPlatById", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public TDefPlatCom listPlatById(HttpServletRequest request,Integer id){
		return codeQueryService.listPlatsById(id);
	}
	/**
	 * 受用户限制
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/listRoleUrl", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefRole> listRoleUrl(HttpServletRequest request,Integer id){
		LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		return codeQueryService.listRoles(loginfo);
	}
	/**
	 * 不受用户限制
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/listRole", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefRole> listRoles(HttpServletRequest request){
		return codeQueryService.listRoles();
	}
	/**
	 * 不受用户限制
	 * @param request
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/listRoleById", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefRole> listRole(Integer id){
		return codeQueryService.listRoleById(id);
	}
	
	
	/**
	 * 传递jdbcType 则返回指定类型数据源，否则返回所有数据源
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listJdbc", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<TDefJdbc> listJdbc(HttpServletRequest request){
		String jdbcType = request.getParameter("jdbcType");
		return codeQueryService.listJdbc(jdbcType);
	}
	/**
	 * 根据路径名称获取路径
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/listSysPath", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> listSysPath(String sysPath){
		Map<String,String> map = new HashMap<String, String>();
		map.put("path", codeQueryService.getSysPath(sysPath));
		return map;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
