/**
 * 
 */
package com.sinosoft.ummp.interfaces.safelock;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.ummp.application.SafeLockService;
import com.sinosoft.ummp.domain.pojo.SafeLockPOJO;

/**
 * 安全锁控
 * @author Darker.Wang
 * @date 2016-11-2 下午5:33:45
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/safelock")
public class SafeLockController {

	@Autowired
	SafeLockService safeLockService;
	
	@RequestMapping(value="/safeLockUrl", method = RequestMethod.GET)
	public String safeLockUrl(HttpServletRequest request){
		return "ummp/safelock/listSafeLock";
	}
	/**
	 * 提数锁定
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/extractLock", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> extractLock(SafeLockPOJO pojo){
		return safeLockService.extractLock(pojo);
	}
	/**
	 * 提数解锁
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/extractUnLock", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> extractUnLock(SafeLockPOJO pojo){
		return safeLockService.extractUnLock(pojo);
	}
	/**
	 * 报送锁定
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/submitLock", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> submitLock(SafeLockPOJO pojo){
		return safeLockService.submitLock(pojo);
	}
	/**
	 * 报送解锁
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/submitUnLock", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> submitUnLock(SafeLockPOJO pojo){
		return safeLockService.submitUnLock(pojo);
	}
	/**
	 * 登录方式锁定
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/loginTypeLock", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> loginTypeLock(SafeLockPOJO pojo){
		return safeLockService.loginTypeLock(pojo);
	}
	/**
	 * 登录方式解锁
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/loginTypeUnLock", method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> loginTypeUnLock(SafeLockPOJO pojo){
		return safeLockService.loginTypeUnLock(pojo);
	}
}
