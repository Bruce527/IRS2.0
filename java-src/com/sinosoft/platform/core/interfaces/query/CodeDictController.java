package com.sinosoft.platform.core.interfaces.query;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 * Description 菜单控制器
 *****************************************************/
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.sinosoft.platform.core.application.CodeDictService;
import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;

import config.Config;

/**
 * 枚举字典控制层
 * @author Darker.Wang
 * @date 2016-8-5 下午4:59:34
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/codedict")
public class CodeDictController {
	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = Logger.getLogger(CodeDictController.class);

	
	@Autowired
	CodeDictService codeDictService;
	@Autowired
	CodeQueryService codeQueryService;
	
	/**
	 * 获取初始枚举页面url
	 */
	@RequestMapping(value = "/listCodeDictUrl", method = RequestMethod.GET)
	public String listCodedictUrl() {
		return "platform/codedict/listCodedict";
	}

	/**
	 * 获取新增枚举页面url
	 */
	@RequestMapping(value = "/addCodedictUrl", method = RequestMethod.GET)
	public String addCodedictUrl() {
		
		return "platform/codedict/addCodedict";
	}


	/**
	 * 枚举查询，类型去重查询***********************
	 * @author pzz
	 * @return
	 */
	@RequestMapping(value = "/codeQueryCodeTypeUrl", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map<String,String>> codeQueryCodeTypeUrl() {
		List<String> codeTypes = (List<String>) codeQueryService.queryCodeType();
		List<Map<String,String>> codeTypeMaps = new ArrayList<Map<String,String>>();
		for(String codeType : codeTypes){
			Map<String,String> map = new HashMap<String,String>();
			map.put("codeType", codeType);
			codeTypeMaps.add(map);
		}
		return codeTypeMaps;
	}
	/**
	 * 机构编码查询，机构编码去重查询******************************
	 * @author pzz
	 * @param request 
	 * @return
	 */
	@RequestMapping(value = "/listComIdUrl", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map<String,String>> listComIdUrl() {
		return  codeQueryService.queryCodeCom();
	}


	/**
	 * 获取更新枚举页面url
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateCodedictUrl", method = RequestMethod.GET)
	public ModelAndView updateMenuUrl(@RequestParam("list") String s) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		TDefCodeDict tDefCodeDict=new TDefCodeDict();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			map = list.get(0);
			String code = (String) map.get("code");
			String codeType = (String) map.get("codeType");
			String comId =  map.get("comId")+"";
			if(!comId.equalsIgnoreCase("undefined")&&!comId.equalsIgnoreCase("null")){
				tDefCodeDict.setComId(new BigDecimal(comId));
			}else{
				tDefCodeDict.setComId(null);
			}
			tDefCodeDict.setCode(code);
			tDefCodeDict.setCodeType(codeType);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ModelAndView("platform/codedict/updateCodedict","tDefCodeDict", codeDictService.selectbyKey(tDefCodeDict));
	}

	/**
	 * 获取枚举数据
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TDefCodeDict tdefcodedict){
		return codeDictService.getPageList(dgm, tdefcodedict);
	}

	/**
	 * 新增枚举
	 */
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> addcodedict(TDefCodeDict tDefCodeDict,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try{	
			codeDictService.saveCodedict(tDefCodeDict, loginInfo);
			map.put("mes", "操作成功");
			log.info("枚举增加成功");
		} catch (CoreException e) {
			e.printStackTrace();
			map.put("mes", "操作失败，原因是" + e.getMessage());
			log.info("枚举新增失败，原因是" + e.getMessage());
		} catch (Exception e) {
			map.put("mes", "操作失败");
			log.info("枚举增加失败");
			e.printStackTrace();
			
		}
		return map;
	}

	/**
	 * 删除枚举信息
	 */
	@RequestMapping(value = "/deleteCodedict", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteMenu(@RequestParam("list") List<String> s, ModelMap model)
			throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		TDefCodeDict tDefCodeDict = new TDefCodeDict();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			for (String key : s) {
				key = new String(key.getBytes("ISO8859-1"),Config.getEncoding());
				log.debug(key);
				String[] ss=key.split("@ @");
				log.debug(Arrays.toString(ss));
				tDefCodeDict.setCodeType(ss[0]);
				tDefCodeDict.setCode(ss[1]);
				if(!ss[2].equalsIgnoreCase("undefined")&&!ss[2].equalsIgnoreCase("null")){
					tDefCodeDict.setComId(new BigDecimal(ss[2]));
				}else{
					tDefCodeDict.setComId(null);
				}
				codeDictService.deleteCodedict(tDefCodeDict, loginInfo);
			}
			map.put("mes", "删除成功");
			log.info("枚举删除成功");
		} 
		catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
			log.info("枚举删除失败");
		}
		return map;// 重定向
	}

	/**
	 * 修改枚举信息
	 */
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateMenu(TDefCodeDict tdefdCodeDict,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			
			codeDictService.updateCodedict(tdefdCodeDict, loginInfo);
			map.put("mes", "操作成功");
			log.info("枚举信息更新成功");
		} catch (CoreException e) {
			e.printStackTrace();
			map.put("mes", "操作失败，原因是" + e.getMessage());
			log.info("枚举新增失败，原因是" + e.getMessage());
		} catch (Exception e) {
			map.put("mes", "操作失败");
			log.info("枚举信息更新失败");
			e.printStackTrace();
		}
		return map;
	}


}
