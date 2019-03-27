package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefMsgNodesqlRela;
import com.sinosoft.ummp.domain.model.TDefMsgNodesqlRelaExample;

public interface TDefMsgNodesqlRelaMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int countByExample(TDefMsgNodesqlRelaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int deleteByExample(TDefMsgNodesqlRelaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int deleteByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int insert(TDefMsgNodesqlRela record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int insertSelective(TDefMsgNodesqlRela record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	List<TDefMsgNodesqlRela> selectByExample(TDefMsgNodesqlRelaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	TDefMsgNodesqlRela selectByPrimaryKey(BigDecimal id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int updateByExampleSelective(@Param("record") TDefMsgNodesqlRela record,
			@Param("example") TDefMsgNodesqlRelaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int updateByExample(@Param("record") TDefMsgNodesqlRela record,
			@Param("example") TDefMsgNodesqlRelaExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int updateByPrimaryKeySelective(TDefMsgNodesqlRela record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_MSG_NODESQL_RELA
	 * @mbggenerated  Wed Jun 15 16:31:06 CST 2016
	 */
	int updateByPrimaryKey(TDefMsgNodesqlRela record);
}