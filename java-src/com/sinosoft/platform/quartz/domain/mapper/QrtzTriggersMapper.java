package com.sinosoft.platform.quartz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.quartz.domain.model.QrtzTriggers;
import com.sinosoft.platform.quartz.domain.model.QrtzTriggersExample;
import com.sinosoft.platform.quartz.domain.model.QrtzTriggersKey;

public interface QrtzTriggersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int countByExample(QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByExample(QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByPrimaryKey(QrtzTriggersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insert(QrtzTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insertSelective(QrtzTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    List<QrtzTriggers> selectByExampleWithBLOBs(QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    List<QrtzTriggers> selectByExample(QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    QrtzTriggers selectByPrimaryKey(QrtzTriggersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExampleSelective(@Param("record") QrtzTriggers record, @Param("example") QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") QrtzTriggers record, @Param("example") QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExample(@Param("record") QrtzTriggers record, @Param("example") QrtzTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKeySelective(QrtzTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(QrtzTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKey(QrtzTriggers record);
}