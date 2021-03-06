package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefTransexcAction;
import com.sinosoft.ummp.domain.model.TDefTransexcActionExample;

public interface TDefTransexcActionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int countByExample(TDefTransexcActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int deleteByExample(TDefTransexcActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int insert(TDefTransexcAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int insertSelective(TDefTransexcAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    List<TDefTransexcAction> selectByExample(TDefTransexcActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    TDefTransexcAction selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int updateByExampleSelective(@Param("record") TDefTransexcAction record, @Param("example") TDefTransexcActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int updateByExample(@Param("record") TDefTransexcAction record, @Param("example") TDefTransexcActionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int updateByPrimaryKeySelective(TDefTransexcAction record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    int updateByPrimaryKey(TDefTransexcAction record);
}