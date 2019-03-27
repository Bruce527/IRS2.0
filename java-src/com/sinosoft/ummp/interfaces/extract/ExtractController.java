/**
 * 
 */
package com.sinosoft.ummp.interfaces.extract;


import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.SqlAdapterMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlInfoMapper;
import com.sinosoft.platform.core.domain.mapper.TDefSqlParamsMapper;
import com.sinosoft.platform.core.domain.model.TDefSql;
import com.sinosoft.platform.core.domain.model.TDefSqlInfo;
import com.sinosoft.platform.core.domain.model.TDefSqlParams;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.ActionService;
import com.sinosoft.ummp.application.ExtractConfigService;
import com.sinosoft.ummp.application.ExtractService;
import com.sinosoft.ummp.domain.mapper.TDefTransexcMapper;
import com.sinosoft.ummp.domain.model.TDefTransexc;
import com.sinosoft.ummp.domain.model.TDefTransexcAction;
import com.sinosoft.ummp.domain.model.TDefTransexcAfter;
import com.sinosoft.ummp.domain.model.TDefTransexcBefore;
import com.sinosoft.ummp.exception.CISException;

/**
 * 提数配置控制器
 * @author Zhangjie
 * @date 2016-9-1 上午11:00:17
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/extract")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class ExtractController {
	
	private static ObjectMapper objectMapper = new ObjectMapper();
	private static final Logger logger = Logger.getLogger(ExtractController.class);
	
	@Autowired
	private ExtractConfigService extractConfigService; 
	@Autowired
	private TDefSqlParamsMapper tDefSqlParamsMapper;
	@Autowired
	private ExtractService extractService;
	@Autowired
	private TDefSqlInfoMapper tDefSqlInfoMapper;
	@Autowired
	private SqlAdapterMapper sqlAdapterMapper;
	@Autowired
	private ActionService actionService;
	//公共模块服务类
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private TDefTransexcMapper tDefTransexcMapper;

	@RequestMapping(value="/configUrl", method = RequestMethod.GET)
	public String listMsgConfigUrl(HttpServletRequest request){
		
		return "ummp/extract/listGetData";
	}
	
	@RequestMapping(value="/addUpdateUrl",method=RequestMethod.GET)
	public String addUpdateUrl(){
		return "ummp/extract/addUpdate";
	}
	
	/**
	 * 保存传输类型
	 * @param tDefTransexc
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/saveUpdate" ,method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveUpdate(TDefTransexc tDefTransexc,ModelMap model){
		Map<String,String> result = new HashMap<String,String>();
		LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
		try {
			this.extractConfigService.saveUpdate(tDefTransexc,loginInfo);
			result.put("msg", "操作成功");
		}catch(CISException e){
			result.put("msg", e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "操作成功");
		}
		return result;
	}
	
	/**
	 * 页面回显数据
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/updateUrl",method=RequestMethod.GET)
	public ModelAndView updateUrl(BigDecimal id){
		TDefTransexc tDefTransexc = this.extractConfigService.getById(id);
		return new ModelAndView("ummp/extract/update","tDefTransexc",tDefTransexc);
	}
	
	/**
	 * 更新传输类型
	 * @param tDefTransexc
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updateSave",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateSave(TDefTransexc tDefTransexc ,ModelMap model){
		Map<String,String> result = new HashMap<String,String>();
		LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
		try {
			this.extractConfigService.updateSave(tDefTransexc,loginInfo);
			result.put("msg", "更新成功");	
		}catch(CISException e){
			result.put("msg", e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "更新失败");
		}
		return result;
	}
	
	/**
	 * 根据主键删除
	 * 支持批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="/deleteById",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> deleteById(@RequestParam(value="id") List<BigDecimal> ids,HttpServletRequest request){
		Map<String,String> result = new HashMap<String,String>();
		String flag=request.getParameter("delete");
		try {
			this.extractConfigService.deleById(ids,flag);
			result.put("msg", "删除成功");
		} catch(CoreException e){
			result.put("msg", e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	/**
	 * 页面跳转： 跳转添加传输前中后配置信息页面
	 * @return
	 */
	@RequestMapping(value="/addConfigUrl",method=RequestMethod.GET)
	public ModelAndView addConfigUrl(String flag,String pID,ModelMap model){

		model.put("flag", flag);
		model.put("pID", pID);
		
		return new ModelAndView("ummp/extract/addConfig",model);
	}
	
	/**
	 * 保存提数脚本配置信息
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/saveGetDataSqlConfigInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveGetDataSqlConfigInfo(String param,ModelMap model){
		Map<String,String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		try {
			Log.info("============param============= "+param);
			BigDecimal sqlId = extractConfigService.saveGetDataSqlConfigInfo(param,loginInfo);
			map.put("msg", "操作成功");
			map.put("sqlId", sqlId.toString());
		}catch(CISException e){
			map.put("msg", e.getMessage());
		} 
		catch (Exception e) {
			map.put("msg", "操作失败");
		}
		return map;
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
		List<TDefSqlParams> params= tDefSqlParamsMapper.selectBySqlId(id);
		return params;
	}
	
	//增加参数
	@RequestMapping(value="/paramSave",method=RequestMethod.POST,produces="application/json;charset=utf-8")
	@ResponseBody
	public Map<String,String> sqlParamSave(@RequestParam Integer flag,TDefSqlParams params){
		Map<String,String> map=new HashMap<String,String>();
		try {
			extractConfigService.saveSqlParam(flag,params);
			map.put("msg", "保存成功！");
		}catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存异常，请重新操作");
		}
		return map;
	}
	/**
	 * 更新配置信息页面跳转
	 * @return
	 */
	@RequestMapping(value="/updateConfigUrl",method=RequestMethod.GET)
	public ModelAndView updateConfigUrl(BigDecimal id ,String flag , Integer num ,ModelMap model){
		
		
		Map<String,Object> map = new HashMap<String,Object>();
		TDefSql  tDefSql= null;
		TDefSqlInfo tDefSqlInfo = null;
		
		TDefTransexcBefore tDefTransexcBefore = null;
		TDefTransexcAction tDefTransexcAction = null;
		TDefTransexcAfter tDefTransexcAfter = null;
		
		try {
			
			map = this.extractConfigService.getSqlCodeInfoById(id,flag);
			
			tDefSql = (TDefSql) map.get("tDefSql");
			tDefSqlInfo = (TDefSqlInfo) map.get("tDefSqlInfo");
			
			if(flag.equals("DATA_TRANSPORT_AGO_CONFIG")){
				
				tDefTransexcBefore = (TDefTransexcBefore) map.get("tDefTransexcBefore");
				model.addAttribute("transportType", tDefTransexcBefore.getExcId()); //传输类型
				model.addAttribute("order", tDefTransexcBefore.getExcNum()); //传输类型
				model.addAttribute("PID", tDefTransexcBefore.getId()); //传输类型
				
			}else if(flag.equals("DATA_TRANSPORT_CONFIG")){
				
				tDefTransexcAction = (TDefTransexcAction) map.get("tDefTransexcAction");
				model.addAttribute("transportType", tDefTransexcAction.getExcId()); //传输类型
				model.addAttribute("order", tDefTransexcAction.getExcNum()); //传输类型
				model.addAttribute("PID", tDefTransexcAction.getId()); //传输类型
			}else{
				
				tDefTransexcAfter = (TDefTransexcAfter) map.get("tDefTransexcAfter");
				model.addAttribute("transportType", tDefTransexcAfter.getExcId()); //传输类型
				model.addAttribute("order", tDefTransexcAfter.getExcNum()); //传输类型
				model.addAttribute("PID", tDefTransexcAfter.getId()); //传输类型
			}
			
			
			
			model.put("flag", flag);
			model.addAttribute("sqlId",tDefSql.getSqlId());  //P
			
			model.addAttribute("targetTableName", tDefSql.getSqlIntoTargetTable());//目标表名
			model.addAttribute("sqlCode",tDefSql.getSqlCode());//算法编码
			model.addAttribute("dataSourceName", tDefSql.getSqlFrom()); //数据源名称
			model.addAttribute("targetDatabase",tDefSql.getSqlInto());//目标数据库 x
			model.addAttribute("sqlType", tDefSql.getSqlType());//提取类型  x
			model.addAttribute("validity",tDefSql.getEsStatus());//有效性 
			model.addAttribute("desc", tDefSql.getSqlDesc());//算法描述
			model.addAttribute("sql",tDefSqlInfo.getSqlInfo()); //sql
			
			
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("出错了!!!"+e.getMessage());
		}
		
		return new ModelAndView("ummp/extract/updateConfig",model);
	}
	
	/**
	 * 更新
	 * @param param
	 * @param model
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/saveUpdateGetDataSqlConfigInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> saveUpdateGetDataSqlConfigInfo(String s,ModelMap model){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		HashMap<String, String> result = new HashMap<String, String>();
		
		LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			map = list.get(0);
			extractConfigService.saveUpdateGetDataSqlConfigInfo(map,loginInfo);
			result.put("msg", "操作成功");
		}catch(CISException e){
			e.printStackTrace();
			result.put("msg", e.getMessage());
		} 
		catch (Exception e) {
			e.printStackTrace();
			result.put("msg", "操作失败");
		}
		return result;
	}
	
	/**
	 * 添加数据传输配置信息
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addConfigInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> addConfigInfo(String param,ModelMap model){
		Map<String,String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
		try {
			Log.info("============param============= "+param);
			extractConfigService.addConfigInfo(param,loginInfo);
			map.put("msg", "操作成功");
		} catch (Exception e) {
			map.put("msg", "操作失败");
		}
		return map;
	}
	
	/**
	 * 传输前配置列表查询
	 * @param dgm
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value="/dataTransportAgoTable",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dataTransportAgoTable(DataGridModel dgm,String queryParam){
		
		try {
			return this.extractConfigService.dataTransportAgoTable(dgm,queryParam);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 传输配置列表查询
	 * @param dgm
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value="/dataTransportConfigTable",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dataTransportConfigTable(DataGridModel dgm,String queryParam){
		
		try {
			return this.extractConfigService.dataTransportConfigTable(dgm,queryParam);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 传输后配置列表查询
	 * @param dgm
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value="/dataTransportAfterTable",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> dataTransportAfterTable(DataGridModel dgm,String queryParam){
		
		try {
			return this.extractConfigService.dataTransportAfterTable(dgm,queryParam);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/deleteDataTransportConfigById", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> deleteDataTransportConfigById(@RequestParam("id") List<BigDecimal> ids,Integer num) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			for (BigDecimal id : ids) {
				this.extractConfigService.deleteDataTransportConfigById(id,num);
			}
			map.put("mes", "删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("mes", "删除失败");
		}
		return map;
	}
	
	/**
	 * 查询传输列表
	 * @param dgm
	 * @param queryParam
	 * @return
	 */
	@RequestMapping(value="/queryTransportList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryTransportList(DataGridModel dgm, String queryParam){
		
		return   this.extractConfigService.queryTransportList(dgm,queryParam);
	}
	/**
	 * 查询传输列表用于下拉选
	 * @param dgm
	 * @param queryParam
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/queryListInfo",method=RequestMethod.POST)
	@ResponseBody
	public List<Map> queryListInfo(BigDecimal comId){
		
		return   this.extractConfigService.queryListInfo(comId);
	}
	/**
	 * 根据传输类型加载对应的-->传输列表配置
	 * 传输前列表配置信息
	 * 传输中列表配置信息
	 * 传输后列表配置信息
	 * @param s
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/updateTransportInfoUrl",method=RequestMethod.GET)
	public ModelAndView updateTransportInfoUrl(String s){
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			map = list.get(0);
			 String transportDesc = (String) map.get("excDesc");
			 if(StringUtils.isNotBlank(transportDesc)){
				 transportDesc = new String(transportDesc.getBytes("ISO8859-1"),"utf-8");
			 		map.put("excDesc", transportDesc);
		     }

		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
		return new ModelAndView("ummp/extract/updateTransportInfo", map);
	}
	
	
	/**
	 * 更新保存传输信息
	 * @param param
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updateTransportInfo",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> updateTransportInfo(String param,ModelMap model){
		Map<String,String> map = new HashMap<String, String>();
		LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
		try {
			Log.info("============param============= "+param);
			extractConfigService.updateTransportInfo(param,loginInfo);
			map.put("msg", "操作成功");
		} catch (Exception e) {
			map.put("msg", "操作失败");
		}
		return map;
	}
	
	//////////////////////////////传输中配置/////////////////////////////////
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/getTransportTypeUrl",method=RequestMethod.POST)
	@ResponseBody
	public List getTransportType(){
		return this.extractConfigService.getTransportType();
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
	 * 跳转至
	 * 手动执行提数页面
	 * @return
	 */
	@RequestMapping(value="/handExtract",method=RequestMethod.GET)
	public String handExtract(){
		return "ummp/extract/handExtract";
	}
	
	/**
	 * 下拉框获取所有传输类型
	 * @return
	 */
	@RequestMapping(value="/queryTransType",method=RequestMethod.POST)
	@ResponseBody
	public List<TDefTransexc> queryTransType(){
		return this.extractConfigService.queryTransType();
	}
	
	/**
	 * 根据id获取传输类型的描述
	 * @param excId
	 * @return
	 */
	@RequestMapping(value="/getTransDesc",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> getTransDesc(BigDecimal excId ){
		Map<String,String> map = new HashMap<String,String>();
		String transDesc = this.extractConfigService.getTransDesc(excId);
		map.put("transDesc", transDesc);
		return map;
	}
	/**
	 * 提数前进行校验确认
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/checkExtract",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> checkExtract(ParamPOJO pojo){
		return extractService.checkExtract(pojo);
	}
	/**
	 * 根据传输类型ID
	 * 手动执行提数
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/handExecuteExtract",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> handExecuteExtract(ParamPOJO pojo,BigDecimal excId,@RequestParam("id") List<BigDecimal> sqlIds,ModelMap model) throws SQLException{
		Map<String,String> map = new HashMap<String,String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		pojo.setUserCode(loginInfo.getUserCode());
		map.put("result", "0");
		if(excId == null){
			List<TDefTransexc> list = tDefTransexcMapper.getTransByComId(pojo.getComId());
			if(list == null || list.size() <= 0){
				System.out.println("=================无对应的传输");
				map.put("msg", "无对应传输，请至先配置。");
				return map;
			}
			try {
				StringBuffer str = new StringBuffer("");
				String tBatchNo = "TN-"+DateUtils.getCurrentDateAndTime();
				extractService.setBatchNo(tBatchNo);
				for(TDefTransexc trans : list){
					BigDecimal id = trans.getExcId();
				 	boolean b = extractService.extract(pojo, id);
				 	if(b){
				 		str.append(trans.getExcCode()+" :提数成功");
				 	}else{
				 		str.append(trans.getExcCode()+" :提数失败");
				 	}
				}
				map.put("result", "1");
				map.put("msg", str.toString());
				return map;
			} catch (Exception e) {
				String msg = e.getMessage();
				map.put("msg",msg);
				return map;
			}
		}else{
			try {
				//前置校验
				List<Map<String,String>> rlist = extractService.extractBefore(sqlIds);
				if(rlist != null && rlist.size() > 0){
					for(Map<String,String> tmap : rlist){
						Iterator<String> iter = tmap.values().iterator();
						while(iter.hasNext()){
							String value = iter.next();
							//不通过返回提示信息结束
							if(value.contains("false")){ 							//判断集合中是否包含false
								throw new CoreException("不通过该校验算法描述");
							}
							if(value.contains("0")){ 							//判断集合中是否包含false
								throw new CoreException("不通过该校验算法描述");
							}
						}
					}
				}
				//提数开始
				boolean result = this.extractService.extract(pojo, excId);
				if(!result){
					map.putAll(extractService.getResultMap());
					return map;
				}
				map.put("result", "1");
				map.put("msg","提数成功");
			}catch(Exception e){
				String msg = e.getMessage();
				map.put("msg",msg);
			}
		}
		
		return map;
	}
	/**
	 * 根据传输类型ID
	 * 手动执行提数
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/handExecuteExtracts",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> handExecuteExtracts(ParamPOJO pojo,@RequestParam("excId") List<BigDecimal> excIds,@RequestParam("id") List<BigDecimal> sqlIds,ModelMap model) throws SQLException{
		if(excIds == null || excIds.size() <= 0){
			return this.handExecuteExtract(pojo, null, sqlIds, model);
		}
		Map<String,String> map = new HashMap<String,String>();
		String msg = "提数完毕";
		int suci = 0 ;
		for(int i = 0 ; i < excIds.size(); i ++ ){
			try{
				Map<String,String> tMap = this.handExecuteExtract(pojo, excIds.get(i), sqlIds, model);
				if(tMap.get("result").equals("0")){
					logger.info("传输ID："+excIds.get(i)+" 执行失败！");
					map.put("msg",tMap.get("msg"));
					return map;
				}else{
					suci ++;
				}
			}catch(Exception e){
				map.put("msg", "执行异常: 传输ID："+excIds.get(i));
				return map;
			}
		}
		msg += ",成功传输："+suci;
		map.put("msg", msg);
		return map;
	}
	@RequestMapping(value="/verifyList",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> verifyList(DataGridModel dgm){
		
		try {
			return extractService.getVerifyList(dgm);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
