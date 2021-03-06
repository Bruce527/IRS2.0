package com.sinosoft.platform.core.domain.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.core.domain.model.TDefUserTrace;
import com.sinosoft.platform.core.domain.model.TDefUserTraceExample;

public interface TDefUserTraceMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int countByExample(TDefUserTraceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int deleteByExample(TDefUserTraceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int deleteByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int insert(TDefUserTrace record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int insertSelective(TDefUserTrace record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	List<TDefUserTrace> selectByExample(TDefUserTraceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	TDefUserTrace selectByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int updateByExampleSelective(@Param("record") TDefUserTrace record,
			@Param("example") TDefUserTraceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int updateByExample(@Param("record") TDefUserTrace record,
			@Param("example") TDefUserTraceExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int updateByPrimaryKeySelective(TDefUserTrace record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_USER_TRACE
	 * @mbggenerated  Wed May 25 13:53:35 CST 2016
	 */
	int updateByPrimaryKey(TDefUserTrace record);
	@SuppressWarnings("rawtypes")
	int queryCount(Map paramMap);
	@SuppressWarnings("rawtypes")
	List<Map> queryOperateLog(Map paramMap);
	@SuppressWarnings("rawtypes")
	List<Map> OperateLogInfo(Map paramMap);
}