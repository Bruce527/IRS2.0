/**
 * 
 */
package com.sinosoft.ummp.domain.pojo;

import java.io.Serializable;

/**
 * @author Darker.Wang
 * @date 2016-6-30 下午8:29:20
 * SFTP 服务器配置POJO类
 */
public class SFTPConfigPOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer comId;
	private Integer roleId;
	private String upUser;
	private String upPass;
	private String upIP;
	private String upPort;
	private String upURL;
	private String downUser;
	private String downPass;
	private String downIP;
	private String downPort;
	private String downURL;
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getComId() {
		return comId;
	}


	public void setComId(Integer comId) {
		this.comId = comId;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public String getUpUser() {
		return upUser;
	}


	public void setUpUser(String upUser) {
		this.upUser = upUser;
	}


	public String getUpPass() {
		return upPass;
	}


	public void setUpPass(String upPass) {
		this.upPass = upPass;
	}


	public String getUpURL() {
		return upURL;
	}


	public void setUpURL(String upURL) {
		this.upURL = upURL;
	}


	public String getDownUser() {
		return downUser;
	}


	public void setDownUser(String downUser) {
		this.downUser = downUser;
	}


	public String getDownPass() {
		return downPass;
	}


	public void setDownPass(String downPass) {
		this.downPass = downPass;
	}


	public String getDownURL() {
		return downURL;
	}


	public void setDownURL(String downURL) {
		this.downURL = downURL;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public String getUpIP() {
		return upIP;
	}


	public void setUpIP(String upIP) {
		this.upIP = upIP;
	}


	public String getUpPort() {
		return upPort;
	}


	public void setUpPort(String upPort) {
		this.upPort = upPort;
	}


	public String getDownIP() {
		return downIP;
	}


	public void setDownIP(String downIP) {
		this.downIP = downIP;
	}


	public String getDownPort() {
		return downPort;
	}


	public void setDownPort(String downPort) {
		this.downPort = downPort;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
