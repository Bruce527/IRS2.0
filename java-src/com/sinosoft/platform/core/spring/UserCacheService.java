package com.sinosoft.platform.core.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.UserService;
import com.sinosoft.platform.core.domain.model.DefUser;

@Service
public class UserCacheService {
	@Autowired
	UserService userService;
	@Cacheable(value = "userCache")
	// 使用了一个缓存名叫 accountCache
	public DefUser getUserByName(String userCode) {
		// 方法内部实现不考虑缓存逻辑，直接实现业务
		System.out.println("real query account." + userCode);
		DefUser rUser = null;
		try {
			rUser = userService.queryUserByCode(userCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("real querying db..." + userCode);
		return rUser;
	}

	@CacheEvict(value = "userCache", allEntries = true)
	// 清空 accountCache 缓存
	public void reload() {
	}

}
