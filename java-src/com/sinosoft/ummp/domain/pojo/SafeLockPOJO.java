/**
 * 
 */
package com.sinosoft.ummp.domain.pojo;

import java.math.BigDecimal;

/**
 * 安全锁控POJO
 * @author Darker.Wang
 * @date 2016-11-2 下午5:35:31
 * @company SINOSOFT
 */
public class SafeLockPOJO {

	private BigDecimal comId;
	private String loginType;
	//后期根据所需的解锁目标进行添加
	
	

	public String getLoginType() {
		return loginType;
	}


	public BigDecimal getComId() {
		return comId;
	}


	public void setComId(BigDecimal comId) {
		this.comId = comId;
	}


	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	/**
	 * 
	 */
	public SafeLockPOJO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
