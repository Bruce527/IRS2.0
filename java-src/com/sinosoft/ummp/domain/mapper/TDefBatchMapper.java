package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefBatch;
import com.sinosoft.ummp.domain.model.TDefBatchExample;

public interface TDefBatchMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int countByExample(TDefBatchExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int deleteByExample(TDefBatchExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int deleteByPrimaryKey(BigDecimal id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int insert(TDefBatch record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int insertSelective(TDefBatch record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	List<TDefBatch> selectByExample(TDefBatchExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	TDefBatch selectByPrimaryKey(BigDecimal id);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int updateByExampleSelective(@Param("record") TDefBatch record,
			@Param("example") TDefBatchExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int updateByExample(@Param("record") TDefBatch record,
			@Param("example") TDefBatchExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int updateByPrimaryKeySelective(TDefBatch record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_BATCH
	 * @mbggenerated  Fri Jul 08 19:16:46 CST 2016
	 */
	int updateByPrimaryKey(TDefBatch record);
	/**
     * 获取当前批次�?     * @param map
     * @return
     */
    int selectMaxBatchNoByExample(TDefBatchExample example);
    /**
     * 获取当前交易�?     * @param map
     * @return
     */
    int selectMaxTransNoByExample(TDefBatchExample example);
}