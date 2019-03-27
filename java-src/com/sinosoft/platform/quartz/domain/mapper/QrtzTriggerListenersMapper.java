package com.sinosoft.platform.quartz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.quartz.domain.model.QrtzTriggerListenersExample;
import com.sinosoft.platform.quartz.domain.model.QrtzTriggerListenersKey;

public interface QrtzTriggerListenersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int countByExample(QrtzTriggerListenersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByExample(QrtzTriggerListenersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByPrimaryKey(QrtzTriggerListenersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insert(QrtzTriggerListenersKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insertSelective(QrtzTriggerListenersKey record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    List<QrtzTriggerListenersKey> selectByExample(QrtzTriggerListenersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExampleSelective(@Param("record") QrtzTriggerListenersKey record, @Param("example") QrtzTriggerListenersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGER_LISTENERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExample(@Param("record") QrtzTriggerListenersKey record, @Param("example") QrtzTriggerListenersExample example);
}