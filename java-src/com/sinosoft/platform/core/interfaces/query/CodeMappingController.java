package com.sinosoft.platform.core.interfaces.query;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.CodeMappingService;
import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.TDefCodeMapping;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.JsonUtil;
import com.sinosoft.platform.core.util.LoginInfo;

/**
 * TDefCodeMapping 控制器
 * @author gyas-itpingw
 *
 */
@Controller
@RequestMapping("/mapping")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class CodeMappingController {

	@Autowired
	CodeMappingService codeMappingService;
	@Autowired
	UserService userService;
	/**
	 * 日志书写类
	 */
	private static final Logger loger = Logger.getLogger(CodeMappingController.class);
	/**
	 * Json操作类
	 */
	public static final ObjectMapper objectMapper = new ObjectMapper();
	
	public CodeMappingController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 显示初始页面
	 * @return
	 */
	@RequestMapping(value="/listMappingUrl",method = RequestMethod.GET)
	public String listMappingUrl(){
		return "ummp/mapping/listCodeMapping";
	}
	/**
	 * 添加TDefCodeMapping
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addMappingUrl",method = RequestMethod.GET)
	public String addTDefCodeMapping(HttpServletRequest request){
		return "ummp/mapping/addCodeMapping";
	}
	
	/**
	 * 通过类型查询TDefCodeMapping
	 * @param codetype
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/queryMapping",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,Object> queryMapping (DataGridModel model ,TDefCodeMapping tDefCodeMapping){
		@SuppressWarnings("rawtypes")
		Map  mappings = codeMappingService.queryCodeMapping(model, tDefCodeMapping);
		return mappings;
	}
	/**
	 * 保存
	 * @param tDefCodeMapping
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/saveCodeMapping",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveCodeMapping(TDefCodeMapping  tDefCodeMapping,ModelMap model){
		Map<String,String> result = new HashMap<String,String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			this.codeMappingService.saveCodeMapping(tDefCodeMapping,loginInfo);
			result.put("msg", "保存成功!");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "保存失败!");
		}
		return result;
	}
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteById(@RequestParam(value="id") List<BigDecimal> ids){
		Map<String,String> result = new HashMap<String,String>();
		try {
			int i = this.codeMappingService.deleteMapping(ids);
			result.put("msg", "成功删除"+i+"条数据");
		} catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "删除失败");
		}
		return result;
	}
	/**
	 * 添加TDefCodeMapping
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/addCodeMappingUrl",method = RequestMethod.GET)
	public String addCodeMappingUrl(HttpServletRequest request){
		return "ummp/mapping/addCodeMapping";
	}
	
	/**
	 * 更新跳转页面TDefCodeMapping
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/updateCodeMappingUrl",method = RequestMethod.GET)
	public ModelAndView updateCodeMappingUrl(BigDecimal id){
		TDefCodeMapping tDefCodeMapping = this.codeMappingService.selectById(id);
		return  new ModelAndView("ummp/mapping/updateCodeMapping","tDefCodeMapping",tDefCodeMapping);
	}
	/**
	 * 更新保存
	 * @param tDefCodeMapping
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updateCodeMapping",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateSaveCodeMapping(TDefCodeMapping tDefCodeMapping,ModelMap model){
		Map<String,String> result = new HashMap<String,String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			this.codeMappingService.updateSave(tDefCodeMapping,loginInfo);
			result.put("msg", "更新成功");
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	/**
	 * 列出用户下的平台
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/listPlatUrl",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List listPlatUrl(HttpServletRequest request){
		LoginInfo loginInfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		return userService.getPlatComByLoginInfo(loginInfo);
	}
	/**
	 * 通过类型查询TDefCodeMapping
	 * @param codetype
	 * @return
	 */
	@RequestMapping(value="/queryByType",produces = "application/json; charset=utf-8",method=RequestMethod.GET)
	@ResponseBody
	public String queryByType(@RequestParam String codetype){
		List<TDefCodeMapping>  mappings = codeMappingService.queryCodeByType(codetype);
		String json = JsonUtil.conver2Json(mappings);
		loger.debug(json);
		return json;
	}
	
	/**
	 * 删除用户
	 */
	@RequestMapping(value = "/deleteMapping", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("id") List<BigDecimal> uid) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			codeMappingService.deleteMapping(uid) ;
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
		}
		return map;// 重定向
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/listCodeTypeUrl", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String listCodeType(HttpServletRequest request){
		LoginInfo loginfo =  (LoginInfo) request.getSession().getAttribute(Constants.USER_INFO_SESSION);
		if(loginfo == null){
			loger.info("用户超时：");
			return "index";
		}
		List<Map> codetypes = codeMappingService.queryCodeType();
		String json = JsonUtil.conver2Json(codetypes);
		loger.debug(json);
		return json;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
