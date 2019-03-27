package com.sinosoft.platform.quartz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.quartz.domain.model.QrtzCronTriggers;
import com.sinosoft.platform.quartz.domain.model.QrtzCronTriggersExample;
import com.sinosoft.platform.quartz.domain.model.QrtzCronTriggersKey;

public interface QrtzCronTriggersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int countByExample(QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByExample(QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByPrimaryKey(QrtzCronTriggersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insert(QrtzCronTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insertSelective(QrtzCronTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    List<QrtzCronTriggers> selectByExample(QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    QrtzCronTriggers selectByPrimaryKey(QrtzCronTriggersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExampleSelective(@Param("record") QrtzCronTriggers record, @Param("example") QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExample(@Param("record") QrtzCronTriggers record, @Param("example") QrtzCronTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKeySelective(QrtzCronTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_CRON_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKey(QrtzCronTriggers record);
}