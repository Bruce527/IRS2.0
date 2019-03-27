package com.sinosoft.ummp.interfaces.codeconfig;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.application.CodeConfigService;
import com.sinosoft.ummp.domain.model.TDefTransCode;

/*****************************************************
 * HISTORY
 * 
 * 2016/07/13 lht 
 * 
 * YYYY/MM/DD 
 * 
 * Description 
 *****************************************************/
@Controller
@RequestMapping("/codeconfig")
@SessionAttributes(Constants.USER_INFO_SESSION)

public class CodeConfigController {
	@Autowired
	CodeConfigService codeConfigService;
	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger loger = Logger.getLogger(CodeConfigController.class);
	@RequestMapping(value = "/listCodeConfigUrl", method = RequestMethod.GET)
	public String listCodeConfigUrl() {
		return "ummp/codeconfig/listCodeConfig";
	}
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm,TDefTransCode transCode ){
		return codeConfigService.getPageList(dgm,transCode);
	}
	@RequestMapping(value="/deleteCode",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteCode(@RequestParam("id") List<String> ids,ModelMap model){
		Map<String,String> map=new HashMap<String,String>();
		try {
			for(String id:ids){
				codeConfigService.deleteByPremaryKey(new BigDecimal(id));
			}
			loger.debug("删除成功: "+ids);
			map.put("mes","删除成功");
		} catch (Exception e) {
			map.put("mes", "删除失败");
			e.printStackTrace();
		}
		return map;
	}
	@RequestMapping(value = "/updateTransCodeUrl", produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,Object> updateUserUrl(String param,ModelMap model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(param, List.class);
			map = list.get(0);
			model.addAttribute("dataType",map.get("dataType"));
			model.addAttribute("targetTableName", map.get("targetTableName"));
			model.addAttribute("targetColName", map.get("targetColName"));
			model.addAttribute("id", map.get("id"));
			model.addAttribute("codeType", map.get("codeType"));
		}catch (IOException e) {
			e.printStackTrace(); 
		}
		return model;
	}
	@RequestMapping(value="/listCodeTypeUrl", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List listCodeType(HttpServletRequest request){
		List<TDefTransCode> list = codeConfigService.queryCodeType();
		return list;
	}
}
