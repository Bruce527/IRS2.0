package com.sinosoft.platform.core.application;

/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 *****************************************************/
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.model.DefUserRoleRela;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.domain.model.TDefManageCom;
import com.sinosoft.platform.core.domain.model.TDefPlatCom;
import com.sinosoft.platform.core.domain.model.TDefUserTrace;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.platform.core.util.Nodes;

public interface UserService
{

	/**
	 * 通过用户ID删除橘色
	 * @param userId
	 * @param loginInfo
	 */
	void deleteU2R(String userId,LoginInfo loginInfo);
	/**
	 * 通过UserId和UserCode删除用户角色信息
	 * @param userId
	 * @param userCode
	 */
	void deleteU2RByUserCode(String userId,String userCode);
	void addUser(DefUser defUser,LoginInfo loginInfo) throws CoreException;
	/**
	 * 添加用户履历
	 * @param trace
	 */
	public void addUserTrace(TDefUserTrace trace);
	/**
	 * 添加用户履历:细致到函数
	 * @param request 请求
	 * @param url 请求URL
	 * @param funName 访问方法
	 * @param msg 信息
	 */
	void addUserTrace(LoginInfo loginInfo,String url,String funName,String msg);
	/**
	 * 添加指定URL用户履历
	 * @param loginInfo
	 * @param url
	 */
	void addUserTrace(LoginInfo loginInfo,String url);
	void updateUser(DefUser defUser,LoginInfo loginInfo) throws CoreException;
	
	void deleteUser(String uid,LoginInfo loginInfo);

	void saveSet(DefUserRoleRela defUserRoleRela,LoginInfo loginInfo);

	Map<String, Object> getPageList(DataGridModel dgm, DefUser defUser,TDefCodeDict dict);

	List<Nodes> queryMenu(BigDecimal uid);

	List<Nodes> queryRole(BigDecimal uid);

	DefUser get(BigDecimal key);
	
	public String getUserRolePrivilege(DefUser defUser);
	
	void modifySave(String password, String password1, BigDecimal id) throws CoreException;

	DefUser findUserByUser(DefUser defUser) throws CoreException;

	HashMap<String, String> queryLoginInfo(LoginInfo loginInfo);
	
	Map<String, Object> getUpdateListInfo(BigDecimal userId);
	/**
	 * 通过USERCODE获取对应平台机构
	 * @param loginInfo 主要利用LoginInfo里面的userCode
	 * @return
	 */
	List<TDefPlatCom> getPlatComByLoginInfo(LoginInfo loginInfo);
	
	/**
	 * 获取所有机构信息
	 * @return
	 */
	List<TDefManageCom> getAllManage();

	BigDecimal getIdByUsercode(DefUser defUser);
	
	/**
	 * 测试生成Excel
	 * @param string
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Map<String, Object> getReportInfo(Map paramMap,String string);

	Map<String, Object> getPageListt(DataGridModel dgm, DefUser user,
			TDefCodeDict dict);

	Map<String, Object> getPageListLog(DataGridModel dgm, DefUser user);

	DefUser selectById(BigDecimal id);
	/**
	 * 根据用户编码查询用户
	 * @param userCode
	 * @return
	 */
	DefUser queryUserByCode(String userCode);
	/**
	 * 用户有效期校验
	 * @return
	 */
	boolean userValidityCheck();

	/**
	 * @param userCode
	 * @return 
	 */
	List<Nodes> queryMenu(String userCode);
	/**
	 * 校验是否是统一认证用户，是-true 否或不存在-false
	 * @param loginInfo
	 * @return boolean
	 */
	boolean checkUser(LoginInfo loginInfo);
	/***************************CR1800450****************************************/
	/**
	 * 域登录验证
	 * @param userName AD域认证，用户的登录UserName
	 * @param password  AD域认证，用户的登录PassWord
	 * @return
	 */
	boolean  checkADLogin(String userName,String password );
	
}
