package com.sinosoft.platform.quartz.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.quartz.domain.model.QrtzSimpleTriggers;
import com.sinosoft.platform.quartz.domain.model.QrtzSimpleTriggersExample;
import com.sinosoft.platform.quartz.domain.model.QrtzSimpleTriggersKey;

public interface QrtzSimpleTriggersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int countByExample(QrtzSimpleTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByExample(QrtzSimpleTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int deleteByPrimaryKey(QrtzSimpleTriggersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insert(QrtzSimpleTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int insertSelective(QrtzSimpleTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    List<QrtzSimpleTriggers> selectByExample(QrtzSimpleTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    QrtzSimpleTriggers selectByPrimaryKey(QrtzSimpleTriggersKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExampleSelective(@Param("record") QrtzSimpleTriggers record, @Param("example") QrtzSimpleTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByExample(@Param("record") QrtzSimpleTriggers record, @Param("example") QrtzSimpleTriggersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKeySelective(QrtzSimpleTriggers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table QRTZ_SIMPLE_TRIGGERS
     *
     * @mbggenerated Mon Jun 06 17:03:54 CST 2016
     */
    int updateByPrimaryKey(QrtzSimpleTriggers record);
}