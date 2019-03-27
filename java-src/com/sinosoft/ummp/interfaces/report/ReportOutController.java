package com.sinosoft.ummp.interfaces.report;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.ReportCreateExcel;
import com.sinosoft.platform.core.util.ResultInfo;
import com.sinosoft.ummp.application.ReportService;
import com.sinosoft.ummp.domain.model.TDefActionTrace;
import com.sinosoft.ummp.domain.model.TDefTransexc;

@Controller
@RequestMapping("/report")
public class ReportOutController {
	
	@Autowired
	ReportService reportService;

	@Autowired
	UserService userService;
	/**
	 * 获取报表配置页面Url
	 */
	@RequestMapping(value="/listReportUrl",method=RequestMethod.GET)
	public String queryList(ModelMap model){
		return "ummp/report/listReport";
	}
	/**
	 * 查询报送报表
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, ParamPOJO pojo){
		return reportService.getPageList(dgm, pojo);
	}
	/**
	 * 查询提数结果报表
	 * @param dgm
	 * @param user
	 * @param trace
	 * @return
	 */
	@RequestMapping(value="/queryTsList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryTsList(DataGridModel dgm, ParamPOJO pojo){
		return reportService.getTsList(dgm, pojo);
	}
	/**
	 * 导出操作日志报表
	 */
	@RequestMapping(value="/ReportDeriveToExcel.xls",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reportDeriveToExcel(String param,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
			ResultInfo resultInfo = new ResultInfo();
			ReportCreateExcel reportCreateExcel=null;
			Map<String, Object> model=null;
		try {
			// 1.获取请求参数
			param = new String(param.getBytes("ISO-8859-1"), "UTF-8");
			JSONObject fromObject = JSONObject.fromObject(param);
			String startDate=(String) fromObject.get("startDate");
			String endDate=(String) fromObject.get("endDate");
			String bussType=(String) fromObject.get("bussType");
			String flag=(String) fromObject.get("flag");
			String userName=(String) fromObject.get("userName");
			String userCode=(String) fromObject.get("userCode");
			String empowerCode=(String) fromObject.get("empowerCode");
			Map paramMap=new HashMap();
			paramMap.put("startDate", startDate);
			paramMap.put("endDate", endDate);
			paramMap.put("bussType", bussType);
			paramMap.put("flag", flag);
			paramMap.put("userName", userName);
			paramMap.put("userCode", userCode);
			paramMap.put("empowerCode", empowerCode);
			// 2.调用业务层处理导出
			resultInfo = this.reportService.exportExcel(paramMap);
			//生成Excel
			model = new HashMap<String, Object>();
			reportCreateExcel = new ReportCreateExcel();
			model.put("reportList", resultInfo.getObj());
			// 3.设置Excel文档名
			String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String fileName = flag +"-"+format+ ".xls";
			response.reset();
			response.setContentType("application/octet-stream");
			response.setHeader(
					"Content-Disposition",
					"attachment; filename="
							+ new String(fileName.getBytes("ISO8859-1"),
									"UTF-8"));
			return new ModelAndView(reportCreateExcel,model);
		} catch (Exception e) {
			e.printStackTrace();
			resultInfo.setSuccess(false);
			resultInfo.setMsg("导出异常！");
		}
		return new ModelAndView(reportCreateExcel,model);
	}
	/**
	 * 导出业务报送结果
	 */
	@RequestMapping(value="/ReportDeserveToExcel",method=RequestMethod.GET)
	@ResponseBody
	public ModelAndView reportToExcel(String param,HttpServletRequest request,HttpServletResponse response,ModelMap modelMap){
		ResultInfo resultInfo=new ResultInfo();
		resultInfo=this.reportService.dealWithReport(param);
		ReportCreateExcel reportCreateExcel=new ReportCreateExcel();
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("reportList", resultInfo.getObj());
		// 设置Excel文档名
					String excelName =reportService.getExcelName(param);
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
	/**
	 * 获取操作日志页面Url
	 */
	@RequestMapping(value="/listOperateReportUrl",method=RequestMethod.GET)
	public String listOperateReportUrl(ModelMap model){
		return "ummp/report/listOperateReport";
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
	 * 
	 * @param comId
	 * @return
	 */
	@RequestMapping(value="/getTransType",method=RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map> getTransType(BigDecimal comId){
		Map<String,BigDecimal> map=new HashMap<String,BigDecimal>();
		map.put("comId", comId);
		return reportService.getTransType(map);
		
	}

}
