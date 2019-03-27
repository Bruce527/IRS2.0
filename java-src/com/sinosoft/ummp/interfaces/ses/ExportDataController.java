package com.sinosoft.ummp.interfaces.ses;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 * Description 用户控制器
 *****************************************************/


import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.asm.commons.Method;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.ReportCreateExcel;
import com.sinosoft.platform.core.util.ResultInfo;
import com.sinosoft.ummp.application.ExportDataService;


@Controller
@RequestMapping("/sess")
// 将Model中属性名为Constants.USER_INFO_SESSION的属性放到Session属性列表中，以便这个属性可以跨请求访问
@SessionAttributes(Constants.USER_INFO_SESSION)
public class ExportDataController {
	
	@Autowired
	ExportDataService exportDataService;
	
	//private ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 日志书写类
	 */
	//private static final Logger log = Logger.getLogger(ExportDataController.class);
	
	public ExportDataController() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 获取数据导出页面url
	 */
	@RequestMapping(value = "/listExportDataUrl", method = RequestMethod.GET)
	public String list(Model model) {
		return "/ummp/ses/listExportData";
	}

	/**
	 * 获取年份url
	 */
	@RequestMapping(value="/listExportDataYearUrl",produces = "application/json; charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public List<Map<String,String>> listExportDataYear(HttpServletRequest request){
		List<String> exportDataYears = exportDataService.selectExportDataYear();
		List<Map<String,String>> exportDataYearMaps = new ArrayList<Map<String,String>>();
		for(String ExportDataYear : exportDataYears){
			Map<String,String> map = new HashMap<String,String>();
			map.put("ExportDataYear", ExportDataYear);
			exportDataYearMaps.add(map);
		}
		return exportDataYearMaps;
	}
	
	
	/**
	 * 获取目标数据表url
	 */
	@RequestMapping(value="/listExportDataTabUrl",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map<String,String>> listExportDataTab(HttpServletRequest request){
		List<String> exportDataTabs = exportDataService.selectExportDataTab();
		List<Map<String,String>> exportDataTabMaps = new ArrayList<Map<String,String>>();
		for(String ExportDataTab : exportDataTabs){
			Map<String,String> map = new HashMap<String,String>();
			map.put("tabCode", ExportDataTab);
			exportDataTabMaps.add(map);
		}
		return exportDataTabMaps;
	}
	
	
	/**
	 * 根据id获取目标表的名字
	 * @param ExportDataTab
	 * @return
	 */
	@RequestMapping(value="/getExportDataTabName",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> getExportDataTabName(String tabCode){
		Map<String,String> map = new HashMap<String,String>();
		String tabName = this.exportDataService.getExportDataTabName(tabCode);
		map.put("tabName", tabName);
		return map;
	}
	
	/**
	 * 导出表结果
	 */
	@RequestMapping(value="/ReportDataToExcel",method=RequestMethod.GET,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public ModelAndView reportToExcel(String param,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		System.out.println("param:"+param);
		ResultInfo resultInfo=new ResultInfo();
		resultInfo=this.exportDataService.dealWithReport(param);
		ReportCreateExcel reportCreateExcel=new ReportCreateExcel();
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("reportList", resultInfo.getObj());
		// 3.设置Excel文档名
					String excelName =exportDataService.getExcelName(param);
					try {
						response.reset();
						response.setContentType("application/octet-stream");
						response.setHeader(
								"Content-Disposition",
								"attachment; filename="
										+ new String(excelName.getBytes("ISO8859-1"),
												"UTF-8"));
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
		return new ModelAndView(reportCreateExcel,model);
	}

}
