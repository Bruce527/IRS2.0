/**
 * 
 */
package com.sinosoft.ummp.application;

import java.util.Map;

import com.sinosoft.ummp.domain.pojo.SafeLockPOJO;

/**
 * 安全锁控服务接口
 * @author Darker.Wang
 * @date 2016-11-2 下午5:47:23
 * @company SINOSOFT
 */
public interface SafeLockService {
	/**
	 * 提数锁定
	 * @param pojo
	 * @return
	 */
	public Map<String,String> extractLock(SafeLockPOJO pojo);
	/**
	 * 提数解锁
	 * @param pojo
	 * @return
	 */
	public Map<String,String> extractUnLock(SafeLockPOJO pojo);
	/**
	 * 报送锁定
	 * @param pojo
	 * @return
	 */
	public Map<String,String> submitLock(SafeLockPOJO pojo);
	/**
	 * 报送解锁
	 * @param pojo
	 * @return
	 */
	public Map<String,String> submitUnLock(SafeLockPOJO pojo);
	/**
	 * 登录方式锁定
	 * @param pojo
	 * @return
	 */
	public Map<String,String> loginTypeLock(SafeLockPOJO pojo);
	/**
	 * 登录方式解锁
	 * @param pojo
	 * @return
	 */
	public Map<String,String> loginTypeUnLock(SafeLockPOJO pojo);
}
