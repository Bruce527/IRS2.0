package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefWSPRequest;
import com.sinosoft.ummp.domain.model.TDefWSPRequestExample;

public interface TDefWSPRequestMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int countByExample(TDefWSPRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int deleteByExample(TDefWSPRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int insert(TDefWSPRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int insertSelective(TDefWSPRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    List<TDefWSPRequest> selectByExample(TDefWSPRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    TDefWSPRequest selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int updateByExampleSelective(@Param("record") TDefWSPRequest record, @Param("example") TDefWSPRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int updateByExample(@Param("record") TDefWSPRequest record, @Param("example") TDefWSPRequestExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int updateByPrimaryKeySelective(TDefWSPRequest record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_WSP_REQUEST
     *
     * @mbggenerated Thu Jul 28 14:10:50 CST 2016
     */
    int updateByPrimaryKey(TDefWSPRequest record);
    /**
     * 根据业务类型获取请求信息
     * @param bussType
     * @return
     */
    List<TDefWSPRequest> selectByBussType(String bussType);
}