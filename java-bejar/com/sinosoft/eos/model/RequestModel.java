/**
 * 
 */
package com.sinosoft.eos.model;

import java.math.BigDecimal;

/**
 * @author Darker.Wang
 * @date 2016-7-4 下午9:32:53
 * 报送请求模型
 */
public class RequestModel {
	
	private String reqUrl;//请求地址
	private String reqIP;//请求IP
	private String reqPort;//请求PORT
	private String reqUser;//请求用户
	private String reqPass;//请求密码
	private String reqKey;//请求密钥
	private BigDecimal comId;//平台ID
	
	public String getReqUrl() {
		return reqUrl;
	}

	public void setReqUrl(String reqUrl) {
		this.reqUrl = reqUrl;
	}

	public String getReqIP() {
		return reqIP;
	}

	public void setReqIP(String reqIP) {
		this.reqIP = reqIP;
	}

	public String getReqPort() {
		return reqPort;
	}

	public void setReqPort(String reqPort) {
		this.reqPort = reqPort;
	}

	public String getReqUser() {
		return reqUser;
	}

	public void setReqUser(String reqUser) {
		this.reqUser = reqUser;
	}

	public String getReqPass() {
		return reqPass;
	}

	public void setReqPass(String reqPass) {
		this.reqPass = reqPass;
	}

	public String getReqKey() {
		return reqKey;
	}

	public void setReqKey(String reqKey) {
		this.reqKey = reqKey;
	}

	public BigDecimal getComId() {
		return comId;
	}

	public void setComId(BigDecimal comId) {
		this.comId = comId;
	}

	/**
	 * 
	 */
	public RequestModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
