package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefActionReturn;
import com.sinosoft.ummp.domain.model.TDefActionReturnExample;

public interface TDefActionReturnMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int countByExample(TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int deleteByExample(TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int insert(TDefActionReturn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int insertSelective(TDefActionReturn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    List<TDefActionReturn> selectByExampleWithBLOBs(TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    List<TDefActionReturn> selectByExample(TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    TDefActionReturn selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int updateByExampleSelective(@Param("record") TDefActionReturn record, @Param("example") TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") TDefActionReturn record, @Param("example") TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int updateByExample(@Param("record") TDefActionReturn record, @Param("example") TDefActionReturnExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int updateByPrimaryKeySelective(TDefActionReturn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(TDefActionReturn record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_ACTION_RETURN
     *
     * @mbggenerated Mon Aug 29 14:40:55 CST 2016
     */
    int updateByPrimaryKey(TDefActionReturn record);
    
    List selectDealReturnClass(Map map);
}