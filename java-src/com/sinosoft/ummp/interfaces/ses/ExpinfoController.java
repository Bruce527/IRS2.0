package com.sinosoft.ummp.interfaces.ses;

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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.AppointFileImportService;
import com.sinosoft.ummp.application.ExpinfoService;
import com.sinosoft.ummp.application.ExtractConfigService;
import com.sinosoft.ummp.domain.model.TDefTransexc;

/**
 * 服务评价提数控制器
 * 
 * @author lht
 * @date 2016-9-1 上午11:00:17
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/ses")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class ExpinfoController {
	@Autowired
	private ExtractConfigService extractConfigService;
	@Autowired
	private ExpinfoService expinfoService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired	
	CodeQueryService codeQueryService;
	
	@Autowired	
	AppointFileImportService appointFileImportService;
	
	private static final Logger log = Logger.getLogger(ExpinfoController.class);
	/**
	 * 跳转至 提数页面
	 * 
	 * @return
	 */
	@RequestMapping(value = "/ExpinfoImportUrl", method = RequestMethod.GET)
	public String handExtract() {
		return "ummp/ses/ExpinfoImport";
	}

	/**
	 * 下拉框获取所有传输类型
	 * 
	 * @return
	 */
	@RequestMapping(value = "/queryTransType", method = RequestMethod.POST)
	@ResponseBody
	public List<TDefTransexc> queryTransType() {
		return this.extractConfigService.queryTransType();
	}

	/**
	 * 根据id获取传输类型的描述
	 * 
	 * @param excId
	 * @return
	 */
	@RequestMapping(value = "/getTransDesc", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> getTransDesc(BigDecimal excId) {
		Map<String, String> map = new HashMap<String, String>();
		String transDesc = this.extractConfigService.getTransDesc(excId);
		map.put("transDesc", transDesc);
		return map;
	}

	/**
	 * 根据传输类型ID 手动执行提数
	 * 
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value = "/handExecuteExtract", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> handExecuteExtract(ParamPOJO pojo,
			BigDecimal excId, ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		try {

			List<String> value = new ArrayList<String>();
			// 不通过返回提示信息结束
			if (value.contains("false")) { // 判断集合中是否包含false
				throw new CoreException("不通过该校验算法描述");
			}
			boolean result = this.expinfoService.extract(pojo, excId);
			if (!result) {
				map.putAll(expinfoService.getResultMap());
				return map;
			}
			map.put("msg", "提数成功");
		} catch (CoreException e) {
			map.put("msg", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "提数失败");
		}
		return map;
	}
	/**
	 * 计算指标
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/calcul", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> calcul(String years,ModelMap model){
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		Map<String, String> map = new HashMap<String, String>();
		try {
			expinfoService.dealData(years, loginInfo);
			map.put("msg", "计算成功");
		} catch (CoreException e) {
			e.printStackTrace();
			map.put("msg",e.getMessage());
		}
		return map;
	}
	@RequestMapping(value="/listExportDataYearUrl",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map<String,String>> listExportDataYear(HttpServletRequest request){
		List<String> exportDataYears = expinfoService.selectYear();
		List<Map<String,String>> exportDataYearMaps = new ArrayList<Map<String,String>>();
		for(String ExportDataYear : exportDataYears){
			Map<String,String> map = new HashMap<String,String>();
			map.put("ExportDataYear", ExportDataYear);
			boolean result = exportDataYearMaps.add(map);
			if (!result){
				
			}
		}
		return exportDataYearMaps;
	}

	
	@RequestMapping(value = "/AppointFileImportUrl", method = RequestMethod.GET)
	public String AppointFileInputUrl(){
		return "ummp/ses/AppointFileImport";
	}
	
	@RequestMapping(value = "/codeQueryCodeTypeUrl", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map<String,String>> codeQueryCodeTypeUrl() {
		List<String> years = (List<String>) codeQueryService.queryYear();
		List<Map<String,String>> yearMaps = new ArrayList<Map<String,String>>();
		for(String year : years){
			Map<String,String> map = new HashMap<String,String>();
			map.put("year", year);
			yearMaps.add(map);
		}
		return yearMaps;
	}
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/AppointFileImport", method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String, String> AppointFileImport(@RequestParam("param") String s ) {
		Map<String, String> remap = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();
		List<LinkedHashMap<String, Object>> list;
		try {
			list = objectMapper.readValue(s, List.class);
			map = list.get(0);
			appointFileImportService.ImportFile(map, log);
				remap.put("mes","导入成功");
				log.info("导入成功");
				return remap;
		}
		 catch (Exception e) {
			remap.put("mes","导入失败");
			log.info("导入失败");
			e.printStackTrace();
			return remap;
		}
		
	}

}
