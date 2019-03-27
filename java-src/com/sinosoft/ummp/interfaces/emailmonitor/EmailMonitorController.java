package com.sinosoft.ummp.interfaces.emailmonitor;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.EmailMonitorService;
import com.sinosoft.ummp.application.MonitorDeployService;
import com.sinosoft.ummp.domain.model.TDefNoticeAccount;
import com.sinosoft.ummp.domain.model.TDefNoticeAdd;
import com.sinosoft.ummp.domain.model.TDefNoticeMain;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;

import config.Config;

/*****************************************************
 * HISTORY
 * 
 * 2016/07/04 lht 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功
 * 
 * Description 监控邮件控制
 *****************************************************/
@Controller
@RequestMapping("/emailmonitor")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class EmailMonitorController {
	private ObjectMapper objectMapper = new ObjectMapper();
	@Autowired
	private EmailMonitorService emailMonitorService;
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	@Autowired
	private CodeQueryService codeQueryService;
	@Autowired
	private MonitorDeployService monitorDeployService;

	
	private static final Logger log = Logger
			.getLogger(EmailMonitorController.class);
	

	/**
	 * 获取页面url
	 */
	@RequestMapping(value = "/listEmailMonitorUrl", method = RequestMethod.GET)
	public String listEmailMonitorUrl() {
		
		return "ummp/emailmonitor/listEmailMonitor";
	}
	/**
	 * 获取页面url
	 */
	@RequestMapping(value = "/listMonitorNoticeUrl", method = RequestMethod.GET)
	public String monitorEventNotice() {
		return "ummp/emailmonitor/listMonitorNotice";
//		return new ModelAndView("ummp/emailmonitor/listMonitorNotice", new HashMap());
	}
	/**
	 * 获取新增页面url
	 */
	@RequestMapping(value = "/addEmailMonitorUrl", method = RequestMethod.GET)
	public String addEmailMonitorUrl(ModelMap model){
		return "ummp/emailmonitor/addEmailMonitor";
	}
	/**
	 * 获取更新页面url
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/updateEmailMonitorUrl", method = RequestMethod.GET)
	public ModelAndView updateEmailMonitorUrl(@RequestParam("list") String s,ModelMap model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			map = list.get(0);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return new ModelAndView("ummp/emailmonitor/updateEmailMonitor", map);
	}
	/**
	 * 获取监控邮箱数据
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, DefUser defUser,
			TDefNoticeAccount tDefNoticeAccount) {
		return emailMonitorService.getPageList(dgm, defUser, tDefNoticeAccount);
	}
	
	/**
	 * 初始化页面时获取发件人信息
	 */
	@RequestMapping(value = "/queryFAccount", method = RequestMethod.POST)
	@ResponseBody
	public TDefNoticeAccount queryFAccount(TDefNoticeAccount tDefNoticeAccount) {
		if(emailMonitorService.getAcctionF().size()!=0)
		return emailMonitorService.getAcctionF().get(0);
		else
			return null;
	}
	/**
	 * 获取抄邮箱数据
	 */
	@RequestMapping(value = "/NoticeAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> NoticeAdd( DataGridModel dgm,
			TDefNoticeAdd tDefNoticeAdd) {
		return emailMonitorService.getPageList(dgm, null, tDefNoticeAdd);
	}

	/**
	 * 获取发邮箱数据
	 */
	@RequestMapping(value = "/NoticeMain", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> NoticeMain( DataGridModel dgm,
			TDefNoticeMain tDefNoticeMain) {
		return emailMonitorService
				.getPageList(dgm, null, tDefNoticeMain);
	}

	/**
	 * 新增邮箱服务
	 */
	@RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveAdd(TDefNoticeAccount tDefNoticeAccount,
			ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo) model
				.get(Constants.USER_INFO_SESSION);
		try {
			emailMonitorService.saveEmail(tDefNoticeAccount, loginInfo);
			map.put("mes", "操作成功");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			map.put("mes", e.getMessage());
		}
		
		return map;
	}

	/**
	 * 新增邮箱服务
	 */
	@RequestMapping(value = "/saveEmail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveEmail(TDefNoticeAccount tDefNoticeAccount,
			ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo) model
				.get(Constants.USER_INFO_SESSION);
		try {
			emailMonitorService.saveEmail1(tDefNoticeAccount, loginInfo);
			map.put("mes", "操作成功");
		} catch (CoreException e) {
//			e.printStackTrace();
			map.put("mes", e.getMessage());
		}

		return map;
	}

	
	/**
	 * 更新邮箱
	 */
	@RequestMapping(value = "/saveUpdate", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveUpdate(TDefNoticeAccount tDefNoticeAccount,ModelMap model) {
		Map<String, String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		emailMonitorService.updateEmailMonitor(tDefNoticeAccount,loginInfo);
		map.put("mes", "操作成功");
		return map;
	}
	/**
	 * 删除邮箱
	 */
	@RequestMapping(value = "/deleteEmailMonitor", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteEmailMonitor(
			@RequestParam("id") List<BigDecimal> mid, ModelMap model)
			throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : mid) {
				emailMonitorService.deleteEmailMonitor(id);
			}
			map.put("mes", "删除成功");
			log.info("邮箱删除成功");
		} catch (Exception e) {
			//e.printStackTrace();
			map.put("mes", e.getMessage());
			log.info("邮箱删除失败");
		}
		return map;// 重定
	}

	/**
	 * 删除抄邮箱
	 */
	@RequestMapping(value = "/deleteNoticeAdd", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteNoticeAdd(
			@RequestParam("id") List<BigDecimal> mid, ModelMap model)
			throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : mid) {
				emailMonitorService.deleteNoticeAdd(id);
			}
			map.put("mes", "移出成功");
			log.info("接收邮箱移出成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "移出失败");
			log.info("接收邮箱移出失败");
		}
		return map;// 重定
	}
	
	/**
	 * 删除发邮箱
	 */
	@RequestMapping(value = "/deleteNoticeMain", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteNoticeMain(
			@RequestParam("id") List<BigDecimal> mid, ModelMap model)
			throws Exception {
		// spring mvc 还可以将参数绑定为list类型
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : mid) {
				emailMonitorService.deleteNoticeMain(id);
			}
			map.put("mes", "移出成功");
			log.info("发送邮箱移出成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "移出失败");
			log.info("发送邮箱移出失败");
		}
		return map;// 重定
	}
	/**
	 * 添加发邮箱
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/SaveNoticeMain", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> NoticeMain(HttpServletRequest request,
			String param, ModelMap model) {
		log.info("============param=========== " + param);
		LoginInfo loginInfo = (LoginInfo) model
				.get(Constants.USER_INFO_SESSION);
		Map<String, String> result = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(
					param, List.class);
			map = list.get(0);
			emailMonitorService.NoticeMain(map, loginInfo);
			result.put("msg", "添加成功");
		}catch (CoreException e) {
			result.put("msg", e.getMessage());
		} catch (Exception e) {
			result.put("msg", "添加失败");
		}
		return result;
	}

	/**
	 * 添加抄邮箱
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/SaveNoticeAdd", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, String> NoticeAdd(HttpServletRequest request,
			String param, ModelMap model) {
		log.info("============param=========== " + param);
		LoginInfo loginInfo = (LoginInfo) model
				.get(Constants.USER_INFO_SESSION);
		Map<String, String> result = new HashMap<String, String>();
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(
					param, List.class);
			map = list.get(0);
			emailMonitorService.NoticeAdd(map, loginInfo);
			result.put("msg", "添加成功");
		} catch (CoreException e) {
			result.put("msg", e.getMessage());
		} catch (Exception e) {
			result.put("msg", "添加失败");
		}
		return result;
	}
	
	/**
	 * 事件
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/listMonitorNameUrl",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map> listMonitorNameUrl(HttpServletRequest request){
		return tDefSqlMapper.queryMonitorName();
	}
	
	@RequestMapping(value="/sendMonitorEmail",produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map sendEmail(String monitorCode){
		Map<String, String> map = new HashMap<String, String>();
		try {
			emailMonitorService.sendEmail(monitorCode);
			map.put("msg","事件包"+monitorCode+"发送成功");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			map.put("msg",e.getMessage());
		}
		return map;
	}
	@RequestMapping(value = "/downloadMonitor",method=RequestMethod.GET,produces = "application/html;charset=utf-8")
	public ModelAndView downLoadFile(HttpServletRequest request,HttpServletResponse response,@RequestParam String monitorCode){
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		String filePath = null;
		String logPath = null;
		try {
			monitorCode = java.net.URLDecoder.decode(monitorCode, "UTF-8");
			String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			String path = codeQueryService.getSysPath("TEMP_PATH");
			String name = path + monitorCode + "-" + str + ".xls";
			String zipName =  monitorCode + "-" + str + ".zip";
			monitorDeployService.createZip(monitorCode, name);
			logPath = path;
			if(filePath == null || "".equals(filePath)){
				filePath = logPath+zipName;
			}
			filePath = filePath.replace("\\/", "/").replace("\\", "/");
			System.out.println("正在下载：" + filePath);
			File inFile = new File(filePath);
			long fileLenght = inFile.length();
			response.reset();
			response.setContentType("text/html;charset=utf-8");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("application/x-msdownload");
			response.addHeader("Content-Disposition","attachment; filename=" + new String(zipName.getBytes(),Config.ENCODING_ISO));
			response.addHeader("Content-Length",String.valueOf(fileLenght));
			
			bis = new BufferedInputStream(new FileInputStream(inFile));
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buff = new byte[2048];
			int bytesRead;
			while( -1 != (bytesRead = bis.read(buff, 0, buff.length))){
				bos.write(buff, 0, bytesRead);
			}
			bos.flush();
		} catch (Exception e) {
			e.printStackTrace();
			log.info("下载文件："+filePath+" 失败！");
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bis = null;
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				bos = null;
			}
		}
		return null;
	}
}
