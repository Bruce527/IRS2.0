package com.sinosoft.platform.core.domain.model;

import java.math.BigDecimal;
import java.util.Date;

public class TDefUser {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.ID
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private BigDecimal id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.USERCODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String usercode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.USERNAME
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.PASSWORD
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.COMPANY_ID
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private BigDecimal companyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.EMPOWER_TYPE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String empowerType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.EMPOWER_CODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String empowerCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.START_DATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private Date startDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.END_DATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private Date endDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.USER_DESCRIBE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String userDescribe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.CREATOR_CODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String creatorCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.EMAIL
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String email;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.IS_LOCK
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String isLock;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.USER_STATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String userState;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.SSIAUTH
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String ssiauth;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_USER.SSISIGN
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    private String ssisign;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.ID
     *
     * @return the value of T_DEF_USER.ID
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.ID
     *
     * @param id the value for T_DEF_USER.ID
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.USERCODE
     *
     * @return the value of T_DEF_USER.USERCODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getUsercode() {
        return usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.USERCODE
     *
     * @param usercode the value for T_DEF_USER.USERCODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.USERNAME
     *
     * @return the value of T_DEF_USER.USERNAME
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.USERNAME
     *
     * @param username the value for T_DEF_USER.USERNAME
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.PASSWORD
     *
     * @return the value of T_DEF_USER.PASSWORD
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.PASSWORD
     *
     * @param password the value for T_DEF_USER.PASSWORD
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.COMPANY_ID
     *
     * @return the value of T_DEF_USER.COMPANY_ID
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public BigDecimal getCompanyId() {
        return companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.COMPANY_ID
     *
     * @param companyId the value for T_DEF_USER.COMPANY_ID
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setCompanyId(BigDecimal companyId) {
        this.companyId = companyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.EMPOWER_TYPE
     *
     * @return the value of T_DEF_USER.EMPOWER_TYPE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getEmpowerType() {
        return empowerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.EMPOWER_TYPE
     *
     * @param empowerType the value for T_DEF_USER.EMPOWER_TYPE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setEmpowerType(String empowerType) {
        this.empowerType = empowerType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.EMPOWER_CODE
     *
     * @return the value of T_DEF_USER.EMPOWER_CODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getEmpowerCode() {
        return empowerCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.EMPOWER_CODE
     *
     * @param empowerCode the value for T_DEF_USER.EMPOWER_CODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setEmpowerCode(String empowerCode) {
        this.empowerCode = empowerCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.START_DATE
     *
     * @return the value of T_DEF_USER.START_DATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.START_DATE
     *
     * @param startDate the value for T_DEF_USER.START_DATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.END_DATE
     *
     * @return the value of T_DEF_USER.END_DATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.END_DATE
     *
     * @param endDate the value for T_DEF_USER.END_DATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.USER_DESCRIBE
     *
     * @return the value of T_DEF_USER.USER_DESCRIBE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getUserDescribe() {
        return userDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.USER_DESCRIBE
     *
     * @param userDescribe the value for T_DEF_USER.USER_DESCRIBE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setUserDescribe(String userDescribe) {
        this.userDescribe = userDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.CREATOR_CODE
     *
     * @return the value of T_DEF_USER.CREATOR_CODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.CREATOR_CODE
     *
     * @param creatorCode the value for T_DEF_USER.CREATOR_CODE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.EMAIL
     *
     * @return the value of T_DEF_USER.EMAIL
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.EMAIL
     *
     * @param email the value for T_DEF_USER.EMAIL
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.IS_LOCK
     *
     * @return the value of T_DEF_USER.IS_LOCK
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getIsLock() {
        return isLock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.IS_LOCK
     *
     * @param isLock the value for T_DEF_USER.IS_LOCK
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setIsLock(String isLock) {
        this.isLock = isLock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.USER_STATE
     *
     * @return the value of T_DEF_USER.USER_STATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getUserState() {
        return userState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.USER_STATE
     *
     * @param userState the value for T_DEF_USER.USER_STATE
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setUserState(String userState) {
        this.userState = userState;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.SSIAUTH
     *
     * @return the value of T_DEF_USER.SSIAUTH
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getSsiauth() {
        return ssiauth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.SSIAUTH
     *
     * @param ssiauth the value for T_DEF_USER.SSIAUTH
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setSsiauth(String ssiauth) {
        this.ssiauth = ssiauth;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_USER.SSISIGN
     *
     * @return the value of T_DEF_USER.SSISIGN
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public String getSsisign() {
        return ssisign;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_USER.SSISIGN
     *
     * @param ssisign the value for T_DEF_USER.SSISIGN
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    public void setSsisign(String ssisign) {
        this.ssisign = ssisign;
    }
}