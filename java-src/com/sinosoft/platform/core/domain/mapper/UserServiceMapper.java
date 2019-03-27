package com.sinosoft.platform.core.domain.mapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.DefRole;
import com.sinosoft.platform.core.domain.model.DefUser;

public interface UserServiceMapper {
	
	/**
	 * 根据用户登陆账号查询
	 * @param defUser
	 * @return
	 */
	public ArrayList<DefUser> queryUserByUserCode(DefUser defUser);
	
	/**
	 * 根据用户名查询
	 * @param defUser
	 * @return
	 */
	public ArrayList<DefUser> queryUserByUserName(DefUser defUser);
	
	/**
	 * 根据用户ID查询权限
	 * @param defUser
	 * @return
	 */
	public String queryUserRolePrivilegeByUserId(DefUser defUser);
	
	
	/**
	 * 根据用户ID查询角色信息
	 * @param defUser
	 * @return
	 */
	public ArrayList<DefRole> queryRolesByUserId(DefUser defUser);
	/**
	 * 根据用户编码获取用户角色
	 * @param defUser
	 * @return
	 */
	public ArrayList<DefRole> queryRolesByUserCode(DefUser defUser);
	/**
	 * 用户信息列表查询（总记录数）
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Integer queryUserListInfoCounts(Map paramMap);
	
	
	/**
	 * 用户信息列表查询（分页查询）
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public List<Map> queryUserListInfoPages(Map paramMap);


	public BigDecimal queryIdByUserCode(DefUser defUser);

	//此方法为生成报表的测试方法
	@SuppressWarnings("rawtypes")
	public List<Map> exportExcel(Map paramMap);
	
}
