package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefTransexcAfter;
import com.sinosoft.ummp.domain.model.TDefTransexcAfterExample;

public interface TDefTransexcAfterMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int countByExample(TDefTransexcAfterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int deleteByExample(TDefTransexcAfterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int deleteByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int insert(TDefTransexcAfter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int insertSelective(TDefTransexcAfter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	List<TDefTransexcAfter> selectByExample(TDefTransexcAfterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	TDefTransexcAfter selectByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int updateByExampleSelective(@Param("record") TDefTransexcAfter record,
			@Param("example") TDefTransexcAfterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int updateByExample(@Param("record") TDefTransexcAfter record,
			@Param("example") TDefTransexcAfterExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int updateByPrimaryKeySelective(TDefTransexcAfter record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC_AFTER
	 * @mbggenerated  Wed Oct 26 22:19:33 CST 2016
	 */
	int updateByPrimaryKey(TDefTransexcAfter record);
}