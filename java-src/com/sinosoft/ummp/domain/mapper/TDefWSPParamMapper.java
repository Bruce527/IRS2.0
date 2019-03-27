package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefWSPParam;
import com.sinosoft.ummp.domain.model.TDefWSPParamExample;

public interface TDefWSPParamMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int countByExample(TDefWSPParamExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int deleteByExample(TDefWSPParamExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int deleteByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int insert(TDefWSPParam record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int insertSelective(TDefWSPParam record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	List<TDefWSPParam> selectByExample(TDefWSPParamExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	TDefWSPParam selectByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int updateByExampleSelective(@Param("record") TDefWSPParam record,
			@Param("example") TDefWSPParamExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int updateByExample(@Param("record") TDefWSPParam record,
			@Param("example") TDefWSPParamExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int updateByPrimaryKeySelective(TDefWSPParam record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	int updateByPrimaryKey(TDefWSPParam record);

	/**
     * 根据请求ID获取到对应的参数信息（有序�?�?
     * @param requestId
     * @return
     */
    List<TDefWSPParam> selectByRequestId(BigDecimal requestId);
}