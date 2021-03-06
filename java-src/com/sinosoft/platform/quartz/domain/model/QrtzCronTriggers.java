package com.sinosoft.platform.quartz.domain.model;

public class QrtzCronTriggers extends QrtzCronTriggersKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    private String cronExpression;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    private String timeZoneId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
     *
     * @return the value of QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
     *
     * @param cronExpression the value for QRTZ_CRON_TRIGGERS.CRON_EXPRESSION
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
     *
     * @return the value of QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    public String getTimeZoneId() {
        return timeZoneId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
     *
     * @param timeZoneId the value for QRTZ_CRON_TRIGGERS.TIME_ZONE_ID
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }
}