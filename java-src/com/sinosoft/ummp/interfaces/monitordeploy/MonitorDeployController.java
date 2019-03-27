package com.sinosoft.ummp.interfaces.monitordeploy;

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
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.mapper.CommonServiceMapper;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.SqlAdapter;
import com.sinosoft.platform.core.domain.model.TDefJdbc;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.quartz.interfaces.SchedulerController;
import com.sinosoft.ummp.application.MonitorDeployService;
import com.sinosoft.ummp.application.ReportService;
import com.sinosoft.ummp.domain.model.TDefBagEvent;

@Controller
@RequestMapping("/monitordeploy")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class MonitorDeployController {
	private ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger log = Logger.getLogger(SchedulerController.class);
	@Autowired
	ReportService reportService;
	
	@Autowired
	MonitorDeployService monitorDeployService;

	@Autowired
	UserService userService;
	
	@Autowired
	TDefSqlMapper tDefSqlMapper;
	@Autowired
	CommonServiceMapper commonServiceMapper;
	@Autowired
	TDefSqlParamsMapper tDefSqlParamsMapper;
	@Autowired
	SqlAdapterMapper sqlAdapterMapper;
	/**
	 * 获取监控配置页面Url
	 */
	@RequestMapping(value="/listMonitorUrl",method=RequestMethod.GET)
	public String queryList(ModelMap model){
		return "ummp/monitordeploy/listMonitorDeploy";
	}
	/**
	 * 获取定义算法页面Url
	 */
	@RequestMapping(value="/addMonitorDeployUrl",method=RequestMethod.GET)
	public String addMonitorUrl(ModelMap model){
		return "ummp/monitordeploy/addMonitorDeploy";
	}
	/**
	 * 获取监控事项页面Url
	 */
	@RequestMapping(value="/listMonitorMatterUrl",method=RequestMethod.GET)
	public String queryMatterList(ModelMap model){
		return "ummp/monitordeploy/listMonitorMatter";
	}
	/**
	 * 查询算法编码列表
	 */
	@RequestMapping(value = "/queryList", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TDefSql sql,TDefJdbc jdbc){
		return monitorDeployService.getPageList(dgm, sql,jdbc);
	}
	/**
	 * 查询已配置事件列表
	 */
	@RequestMapping(value = "/queryListEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryListEvent(DataGridModel dgm, TDefSql sql,TDefBagEvent event){
		return monitorDeployService.getExistEvent(dgm, sql,event);
	}
	/**
	 * 获取修改页面url
	 */
	@RequestMapping(value = "/updateMonitorDeployUrl",produces = "application/json; charset=utf-8", method = RequestMethod.GET)
	public ModelAndView updateUserUrl(BigDecimal id,ModelMap model) {
		Map<String, Object> map = new HashMap<String, Object>();
		TDefSql tDefSql=null;
		TDefSqlInfo tDefSqlInfo=null;
		TDefJdbc tDefJdbc=null;
		try {
			map=monitorDeployService.findGetDataSqlCodeById(id);
			tDefSql=(TDefSql) map.get("tDefSql");
			tDefSqlInfo=(TDefSqlInfo) map.get("tDefSqlInfo");
			tDefJdbc=(TDefJdbc) map.get("tDefJdbc");
			model.addAttribute("sqlId",tDefSql.getSqlId());
			model.addAttribute("esStatus",tDefSql.getEsStatus());
			model.addAttribute("sqlCode",tDefSql.getSqlCode());
			model.addAttribute("sqlTyep", tDefSql.getSqlType());
			model.addAttribute("sqlInfo", tDefSqlInfo.getSqlInfo());
			model.addAttribute("sqlDesc",tDefSql.getSqlDesc());
			model.addAttribute("jdbcCode",tDefJdbc.getJdbcCode());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("出错了!!!"+e.getMessage());
		}
		return new ModelAndView("ummp/monitordeploy/updateMonitorDeploy", model);
	}
	/**
	 * 删除算法
	 */
	@RequestMapping(value = "/deleteSqlCode", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> delete(@RequestParam("id") List<BigDecimal> uid) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : uid) {
				monitorDeployService.deleteGetDataSqlCode(id);
			}
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
		}
		return map;// 重定向
	}
	/**
	 * 删除已配置事件
	 */
	@RequestMapping(value = "/deleteEvent", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteEvent(@RequestParam("id") List<BigDecimal> uid) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : uid) {
				monitorDeployService.deleteEvent(id);
			}
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
		}
		return map;// 重定向
	}
	/**
	 * 删除事件包
	 */
	@RequestMapping(value = "/deleteMatter", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteMatter(String monitorCode) {
		Map<String, String> map = new HashMap<String, String>();
		try {
				System.out.println(monitorCode);
				monitorDeployService.deleteMatter(monitorCode);
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
		}
		return map;// 重定向
	}
	/**
	 * 获取事件描述
	 */
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value="/listSqlDescUrl",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map> listSqlDescUrl(HttpServletRequest request){
		List<Map> list = tDefSqlMapper.querySqlListInfo();
		return list;
	}
	
	/**
	 * 获取事件包名
	 */
	@SuppressWarnings({ "unused", "rawtypes" })
	@RequestMapping(value="/listMonitorNameUrl",produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<Map> listMonitorNameUrl(HttpServletRequest request){
		Map paramMap=new HashMap();
		List<Map> list = tDefSqlMapper.queryMonitorName();
		return list;
	}
	/**
	 * 保存事件、包
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/saveEvent" ,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> saveEvent(HttpServletRequest request,String param,ModelMap model){
		log.info("============param=========== "+ param);
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		String usercode = loginInfo.getUserCode();
		Map<String,String> result = new HashMap<String,String>();
		Map<String, Object> map = new HashMap<String,Object>();
		try {
			List<LinkedHashMap<String,Object>> list  = objectMapper.readValue(param, List.class);
			 map = list.get(0);
			 map.put("usercode", usercode);
			 //调用业务层进行保存数据
			 monitorDeployService.saveEventInfo(map,loginInfo);
			result.put("msg", "保存成功");
		} catch (CoreException e) {
			result.put("msg", e.getMessage());
		}catch (Exception e) {
			result.put("msg", "保存失败");
		}
		return result;
	}
	/**
	 * 保存定义事件
	 */
	@RequestMapping(value="/saveDefinitionInfo" ,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> saveDefinitionInfo(HttpServletRequest request,TDefSql sql,TDefSqlInfo sqlInfo,@RequestParam String jdbcCode, ModelMap model){
		log.info("============param=========== "+ sql+" "+jdbcCode);
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		Map<String,String> result = new HashMap<String,String>();
		try {
			Map<String, Object> map = new HashMap<String,Object>();
			BigDecimal sqlId = commonServiceMapper.getSeqValByName("SEQ_T_DEF_SQL");
			sql.setSqlId(sqlId);
			
			map.put("tDefSql", sql);
			map.put("tDefSqlInfo", sqlInfo);
			map.put("jdbcCode", jdbcCode);
			
			monitorDeployService.saveDefinitionInfo(map,loginInfo);
			result.put("msg", "保存成功");
			result.put("sqlId", sqlId.toString());
		} catch (Exception e) {
			//e.printStackTrace();
			result.put("msg", "保存失败:"+e.getMessage());
		}
		return result;
	}
	/**
	 * 保存修改算法配置
	 */
	@RequestMapping(value="/saveUpdateSqlInfo" ,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> saveUpdateSqlInfo(HttpServletRequest request,TDefSql sql,TDefSqlInfo sqlInfo,@RequestParam String jdbcCode, ModelMap model){
		log.info("============param=========== "+ sql+" "+jdbcCode);
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		Map<String,String> result = new HashMap<String,String>();
		try {
			Map<String, Object> map = new HashMap<String,Object>();
			map.put("tDefSql", sql);
			map.put("tDefSqlInfo", sqlInfo);
			map.put("jdbcCode", jdbcCode);
			
			monitorDeployService.saveUpdateSqlInfo(map,loginInfo);
			result.put("msg", "保存成功");
		} catch (Exception e) {
			//e.printStackTrace();
			result.put("msg", "保存失败:"+e.getMessage());
		}
		return result;
	}
	//获取sql配置参数页面
	@RequestMapping(value="/addDefinitionSqlParamUrl",method=RequestMethod.GET)
	public String addSqlParamUrl(HttpServletRequest request,@RequestParam BigDecimal id){
		return "ummp/monitordeploy/addDefinitionSqlParam";
	}
	//参数页面初始化
	@RequestMapping(value="/initParamUrl",produces="application/json;charset=utf-8")
	@ResponseBody
	public List<TDefSqlParams> initParamUrl(BigDecimal id,HttpServletRequest request){
		List<TDefSqlParams> params=tDefSqlParamsMapper.selectBySqlId(id);
		return params;
	}
	//增加参数
	@RequestMapping(value="/paramSave",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> sqlParamSave(@RequestParam Integer flag,TDefSqlParams params){
		Map<String,String> map=new HashMap<String,String>();
		try {
			monitorDeployService.saveSqlParam(flag,params);
			map.put("msg", "保存成功！");
		}catch (CoreException ee) {
			ee.printStackTrace();
			map.put("msg", ee.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存异常，请重新操作");
		}
		return map;
	}
	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deleteSqlParam",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> deleteParam(@RequestParam BigDecimal id){
		Map<String,String> map=new HashMap<String,String>();
		try {
			this.tDefSqlParamsMapper.deleteByPrimaryKey(id);
			map.put("msg", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "删除异常，请重试");
		}
		return map;
	}
	/**
	 * 事件包复效
	 * pzz 2016年11月4日17:24:33
	 */
	@RequestMapping(value = "/MonitorEffective", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> MonitorEffective(String monitorCode) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			//TODO
			String sql = "  update t_def_monitor aa set aa.rc_status = 1 where aa.monitor_code = '"+monitorCode+"'";
			sqlAdapterMapper.excuteUpdate(new SqlAdapter(sql));
			map.put("mes", "复效成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "复效失败");
		}
		return map;// 重定向
	}
	/**
	 * 事件包失效
	 * pzz 2016年11月4日17:29:00
	 */
	@RequestMapping(value = "/MonitorInvalid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> MonitorInvalid(String monitorCode) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			//TODO
			String sql = "  update t_def_monitor aa set aa.rc_status = 0 where aa.monitor_code = '"+monitorCode+"'";
			sqlAdapterMapper.excuteUpdate(new SqlAdapter(sql));
			map.put("mes", "失效成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "失效失败");
		}
		return map;// 重定向
	}
	/**
	 * 事件关联失效
	 * pzz 2016年11月4日17:29:00
	 */
	@RequestMapping(value = "/RelaEffective", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> RelaEffective(BigDecimal id) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			//TODO
			String sql = " update T_DEF_BAG_EVENT tt set tt.es_status = 1 where tt.id = "+id+"";
			sqlAdapterMapper.excuteUpdate(new SqlAdapter(sql));
			map.put("mes", "复效成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "复效失败");
		}
		return map;// 重定向
	}/**
	 * 事件关联失效
	 * pzz 2016年11月4日17:29:00
	 */
	@RequestMapping(value = "/RelaInvalid", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> RelaInvalid(BigDecimal id) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			//TODO
			String sql = " update T_DEF_BAG_EVENT tt set tt.es_status = 0 where tt.id = "+id+"";
			sqlAdapterMapper.excuteUpdate(new SqlAdapter(sql));
			map.put("mes", "失效成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "失效失败");
		}
		return map;// 重定向
	}
}

 










