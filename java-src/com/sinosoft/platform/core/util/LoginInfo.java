package com.sinosoft.platform.core.util;

import java.math.BigDecimal;

/**
 * 用户登陆信息
 * @author Darker.Wang
 * @date 2016-7-8 下午2:00:47
 * @company SINOSOFT
 */
public class LoginInfo {

	// 登陆用户ID
	private BigDecimal userId;
	// 登陆用户CODE
	private String userCode;
	//用户名称
	private String userName;
	// 登陆用户所属管理机构ID
	private BigDecimal companyId;
	// 用户登陆机构ID
	private BigDecimal LoginCompanyId;
	// 登录用户的IP
	private String userIp;
	// 认证方式
	private String empowerType;
	// 认证编码
	private String empowerCode;
	
	
	/**
	 * 获取认证编码
	 * @return
	 */
	public String getEmpowerCode() {
		return empowerCode;
	}
	/**
	 * 设置认证编码
	 * @param empowerCode
	 */
	public void setEmpowerCode(String empowerCode) {
		this.empowerCode = empowerCode;
	}
	/**
	 * 获取认证类型
	 * @return
	 */
	public String getEmpowerType() {
		return empowerType;
	}
	/**
	 * 设置认证方式
	 * @param empowerType
	 */
	public void setEmpowerType(String empowerType) {
		this.empowerType = empowerType;
	}
	/**
	 * 获取登录用户IP
	 * @return
	 */
	public String getUserIp() {
		return userIp;
	}
	/**
	 * 设置登录用户IP
	 * @param userIp
	 */
	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}
	/**
	 * 获取用户ID
	 * @return
	 */
	public BigDecimal getUserId() {
		return userId;
	}
	/**
	 * 设置用户ID
	 * @param userId
	 */
	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}
	/**
	 * 获取机构ID
	 * @return
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}
	/**
	 * 设置机构ID
	 * @param companyId
	 */
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}
	/**
	 * 获取登录机构ID
	 * @return
	 */
	public BigDecimal getLoginCompanyId() {
		return LoginCompanyId;
	}
	/**
	 * 设置登录机构ID
	 * @param loginCompanyId
	 */
	public void setLoginCompanyId(BigDecimal loginCompanyId) {
		LoginCompanyId = loginCompanyId;
	}
	/**
	 * 获取用户编码
	 * @return
	 */
	public String getUserCode() {
		return userCode;
	}
	/**
	 * 设置用户编码
	 * @param userCode
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 获取用户名称
	 * @return
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * 设置用户名称
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

}
