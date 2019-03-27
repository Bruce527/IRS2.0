package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;

public class TDefBussModel {
	/**
	 * 请求发送报文
	 */
	public static final String SUB_BUSS_TYPE_REQUEST = "MSG_REQUEST";
	/**
	 * 返回处理报文
	 */
	public static final String SUB_BUSS_TYPE_RESPONSE = "MSG_RESPONSE";
	/**
	 * 特殊类处理
	 */
	public static final String SUB_BUSS_TYPE_SPECLASS = "MSG_SPECLASS";
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.BUSS_ID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private BigDecimal bussId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.BUSS_PID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private BigDecimal bussPid;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.BUSS_TYPE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private String bussType;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.BUSS_CODE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private String bussCode;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.BUSS_NAME
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private String bussName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.COM_ID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private BigDecimal comId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.RC_STATUS
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private Short rcStatus;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.IS_TITLE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private Short isTitle;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.TITLE_INFO
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private String titleInfo;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_DEF_BUSS_MODEL.SUB_BUSS_TYPE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	private String subBussType;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.BUSS_ID
	 * @return  the value of T_DEF_BUSS_MODEL.BUSS_ID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public BigDecimal getBussId() {
		return bussId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.BUSS_ID
	 * @param bussId  the value for T_DEF_BUSS_MODEL.BUSS_ID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setBussId(BigDecimal bussId) {
		this.bussId = bussId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.BUSS_PID
	 * @return  the value of T_DEF_BUSS_MODEL.BUSS_PID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public BigDecimal getBussPid() {
		return bussPid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.BUSS_PID
	 * @param bussPid  the value for T_DEF_BUSS_MODEL.BUSS_PID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setBussPid(BigDecimal bussPid) {
		this.bussPid = bussPid;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.BUSS_TYPE
	 * @return  the value of T_DEF_BUSS_MODEL.BUSS_TYPE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public String getBussType() {
		return bussType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.BUSS_TYPE
	 * @param bussType  the value for T_DEF_BUSS_MODEL.BUSS_TYPE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.BUSS_CODE
	 * @return  the value of T_DEF_BUSS_MODEL.BUSS_CODE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public String getBussCode() {
		return bussCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.BUSS_CODE
	 * @param bussCode  the value for T_DEF_BUSS_MODEL.BUSS_CODE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setBussCode(String bussCode) {
		this.bussCode = bussCode;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.BUSS_NAME
	 * @return  the value of T_DEF_BUSS_MODEL.BUSS_NAME
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public String getBussName() {
		return bussName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.BUSS_NAME
	 * @param bussName  the value for T_DEF_BUSS_MODEL.BUSS_NAME
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setBussName(String bussName) {
		this.bussName = bussName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.COM_ID
	 * @return  the value of T_DEF_BUSS_MODEL.COM_ID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public BigDecimal getComId() {
		return comId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.COM_ID
	 * @param comId  the value for T_DEF_BUSS_MODEL.COM_ID
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setComId(BigDecimal comId) {
		this.comId = comId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.RC_STATUS
	 * @return  the value of T_DEF_BUSS_MODEL.RC_STATUS
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public Short getRcStatus() {
		return rcStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.RC_STATUS
	 * @param rcStatus  the value for T_DEF_BUSS_MODEL.RC_STATUS
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setRcStatus(Short rcStatus) {
		this.rcStatus = rcStatus;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.IS_TITLE
	 * @return  the value of T_DEF_BUSS_MODEL.IS_TITLE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public Short getIsTitle() {
		return isTitle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.IS_TITLE
	 * @param isTitle  the value for T_DEF_BUSS_MODEL.IS_TITLE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setIsTitle(Short isTitle) {
		this.isTitle = isTitle;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.TITLE_INFO
	 * @return  the value of T_DEF_BUSS_MODEL.TITLE_INFO
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public String getTitleInfo() {
		return titleInfo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.TITLE_INFO
	 * @param titleInfo  the value for T_DEF_BUSS_MODEL.TITLE_INFO
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setTitleInfo(String titleInfo) {
		this.titleInfo = titleInfo;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_DEF_BUSS_MODEL.SUB_BUSS_TYPE
	 * @return  the value of T_DEF_BUSS_MODEL.SUB_BUSS_TYPE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public String getSubBussType() {
		return subBussType;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_DEF_BUSS_MODEL.SUB_BUSS_TYPE
	 * @param subBussType  the value for T_DEF_BUSS_MODEL.SUB_BUSS_TYPE
	 * @mbggenerated  Tue Aug 09 18:07:17 CST 2016
	 */
	public void setSubBussType(String subBussType) {
		this.subBussType = subBussType;
	}
}