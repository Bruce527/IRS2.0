/**
 * 
 */
package com.sinosoft.ummp.domain.pojo;

import java.io.Serializable;

/**
 * @author Darker.Wang
 * @date 2016-7-1 上午10:51:28
 * 报文查询POJO类
 */
public class MsgQueryPOJO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer ID;
	private Integer comId;
	private String comName;
	private String bussType;
	private String bussCode;
	private String formatType;
	private String pormatTypeName;
	private String sendType;
	private String sendTypeName;
	private String status;
	private String statusName;
	private Integer bussId;
	private String implType;//实现方式
	private Integer queryStartIndex;//分页组件
	private Integer queryEndIndex;//分页组件
	private String order;//排序
	private String sort;//排序列
	public String getImplType() {
		return implType;
	}

	public void setImplType(String implType) {
		this.implType = implType;
	}

	@Override
	public String toString() {
		return "MsgQueryPOJO [ID=" + ID + ", comId=" + comId + ", comName="
				+ comName + ", bussType=" + bussType + ", bussCode=" + bussCode
				+ ", formatType=" + formatType + ", pormatTypeName="
				+ pormatTypeName + ", sendType=" + sendType + ", sendTypeName="
				+ sendTypeName + ", status=" + status + ", bussId=" + bussId
				+ ", implType=" + implType + "]";
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer id) {
		ID = id;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getComName() {
		return comName;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getBussType() {
		return bussType;
	}

	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	public String getBussCode() {
		return bussCode;
	}

	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}

	public String getFormatType() {
		return formatType;
	}

	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}

	public String getPormatTypeName() {
		return pormatTypeName;
	}

	public void setPormatTypeName(String pormatTypeName) {
		this.pormatTypeName = pormatTypeName;
	}

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getSendTypeName() {
		return sendTypeName;
	}

	public void setSendTypeName(String sendTypeName) {
		this.sendTypeName = sendTypeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getBussId() {
		return bussId;
	}

	public void setBussId(Integer bussId) {
		this.bussId = bussId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Integer getQueryStartIndex() {
		return queryStartIndex;
	}

	public void setQueryStartIndex(Integer queryStartIndex) {
		this.queryStartIndex = queryStartIndex;
	}

	public Integer getQueryEndIndex() {
		return queryEndIndex;
	}

	public void setQueryEndIndex(Integer queryEndIndex) {
		this.queryEndIndex = queryEndIndex;
	}


	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
