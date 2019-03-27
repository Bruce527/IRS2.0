package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;

public class TDefNotice {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_NOTICE.NOTICE_ID
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    private BigDecimal noticeId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_NOTICE.NOTICE_TYPE
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    private String noticeType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_NOTICE.NOTICE_CODE
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    private String noticeCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_NOTICE.NOTICE_NAME
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    private String noticeName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_NOTICE.NOTICE_ID
     *
     * @return the value of T_DEF_NOTICE.NOTICE_ID
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public BigDecimal getNoticeId() {
        return noticeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_NOTICE.NOTICE_ID
     *
     * @param noticeId the value for T_DEF_NOTICE.NOTICE_ID
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void setNoticeId(BigDecimal noticeId) {
        this.noticeId = noticeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_NOTICE.NOTICE_TYPE
     *
     * @return the value of T_DEF_NOTICE.NOTICE_TYPE
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public String getNoticeType() {
        return noticeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_NOTICE.NOTICE_TYPE
     *
     * @param noticeType the value for T_DEF_NOTICE.NOTICE_TYPE
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_NOTICE.NOTICE_CODE
     *
     * @return the value of T_DEF_NOTICE.NOTICE_CODE
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public String getNoticeCode() {
        return noticeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_NOTICE.NOTICE_CODE
     *
     * @param noticeCode the value for T_DEF_NOTICE.NOTICE_CODE
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void setNoticeCode(String noticeCode) {
        this.noticeCode = noticeCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_NOTICE.NOTICE_NAME
     *
     * @return the value of T_DEF_NOTICE.NOTICE_NAME
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public String getNoticeName() {
        return noticeName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_NOTICE.NOTICE_NAME
     *
     * @param noticeName the value for T_DEF_NOTICE.NOTICE_NAME
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void setNoticeName(String noticeName) {
        this.noticeName = noticeName;
    }
}