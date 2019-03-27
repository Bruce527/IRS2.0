/**
 * 
 */
package com.sinosoft.ummp.interfaces.sconfig;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.platform.core.util.JsonUtil;
import com.sinosoft.ummp.application.SendConfigService;
import com.sinosoft.ummp.domain.model.TDefSend;
import com.sinosoft.ummp.domain.pojo.SFTPConfigPOJO;

/**
 * @author Darker.Wang
 * @date 2016-6-30 上午10:47:17
 * 报送配置控制器
 */
@Controller
@RequestMapping("/sconfig")
public class SendConfigController {
	@Autowired
	SendConfigService sendConfigService;
	/**
	 * 
	 */
	public SendConfigController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/configUrl",method = RequestMethod.GET)
	public String configUrl(){
		return "ummp/sconfig/sendConfigInput";
	}
	@RequestMapping(value="/configSFTPUrl",method = RequestMethod.GET)
	public String configSFTPUrl(){
		return "ummp/sconfig/sftpConfigInput";
	}
	/**
	 * 
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="showComInfoUrl",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String showComInfo(@RequestParam Integer comId){
		TDefSend tDefSend = sendConfigService.selectByComId(comId);
		Map map = new HashMap();
		if(tDefSend != null){
			map.put("msg", "success");
			map.put("info", tDefSend);
		}else{
			map.put("msg", "无报送地址信息，请配置");
		}
		return JsonUtil.conver2Json(map);
	}
	@RequestMapping(value="saveSendInfoUrl",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> saveSendInfo(TDefSend tDefSend){
		Map<String,String> map = new HashMap<String,String>();
		TDefSend result = sendConfigService.saveTDefSend(tDefSend);
		if(result == null){
			map.put("msg", "保存失败，请重试！");
			return map;
		}
		map.put("msg", "success");
		return map;
	}
	@RequestMapping(value="saveSFTPInfoUrl",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> saveSFTPInfo(SFTPConfigPOJO pojo){
		Map<String,String> map = new HashMap<String,String>();
		boolean result = sendConfigService.saveSFTPInfo(pojo);
		if(!result){
			map.put("msg", "保存失败，请重试！");
			return map;
		}
		map.put("msg", "success");
		return map;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value="qeurySFTPInfoUrl",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
	@ResponseBody
	public Map qeurySFTPInfo(SFTPConfigPOJO pojo){
		Map map = new HashMap();
		SFTPConfigPOJO result = sendConfigService.querySFTPInfo(pojo);
		if(result == null){
			map.put("msg", "查询失败，请重试！");
			return map;
		}
		map.put("msg", "success");
		map.put("pojo", result);
		return map;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
