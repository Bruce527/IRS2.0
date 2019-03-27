/**
 * 
 */
package com.sinosoft.ummp.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Darker.Wang
 * @date 2016-7-5 下午6:37:25
 * @company SINOSOFT
 */
public class BussModelImpl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigDecimal bussId;
	private BigDecimal implId;
	private BigDecimal comId;
	private String implType;//equals bussmode.sub_buss_type
	private String formatType;
	private String sendType;
	private Integer isTitle;
	private String titleInfo;
	private String bussName;
	public BigDecimal getBussId() {
		return bussId;
	}
	public void setBussId(BigDecimal bussId) {
		this.bussId = bussId;
	}
	public BigDecimal getImplId() {
		return implId;
	}
	public void setImplId(BigDecimal implId) {
		this.implId = implId;
	}
	
	public BigDecimal getComId() {
		return comId;
	}
	public void setComId(BigDecimal comId) {
		this.comId = comId;
	}
	public String getImplType() {
		return implType;
	}
	public void setImplType(String implType) {
		this.implType = implType;
	}
	public String getFormatType() {
		return formatType;
	}
	public void setFormatType(String formatType) {
		this.formatType = formatType;
	}
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public Integer getIsTitle() {
		return isTitle;
	}
	public void setIsTitle(Integer isTitle) {
		this.isTitle = isTitle;
	}
	public String getTitleInfo() {
		return titleInfo;
	}
	public void setTitleInfo(String titleInfo) {
		this.titleInfo = titleInfo;
	}
	
	public String getBussName() {
		return bussName;
	}
	public void setBussName(String bussName) {
		this.bussName = bussName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "BussModelImpl [bussId=" + bussId + ", implId=" + implId
				+ ", implType=" + implType + ", formatType=" + formatType
				+ ", sendType=" + sendType + ", isTitle=" + isTitle
				+ ", titleInfo=" + titleInfo + ", bussName=" + bussName+"]";
	}

	

}
