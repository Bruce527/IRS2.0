package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefTransexc;
import com.sinosoft.ummp.domain.model.TDefTransexcExample;

public interface TDefTransexcMapper {
    /**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int countByExample(TDefTransexcExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int deleteByExample(TDefTransexcExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int deleteByPrimaryKey(BigDecimal excId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int insert(TDefTransexc record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int insertSelective(TDefTransexc record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	List<TDefTransexc> selectByExample(TDefTransexcExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	TDefTransexc selectByPrimaryKey(BigDecimal excId);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int updateByExampleSelective(@Param("record") TDefTransexc record,
			@Param("example") TDefTransexcExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int updateByExample(@Param("record") TDefTransexc record,
			@Param("example") TDefTransexcExample example);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int updateByPrimaryKeySelective(TDefTransexc record);
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSEXC
	 * @mbggenerated  Thu Sep 01 11:09:07 CST 2016
	 */
	int updateByPrimaryKey(TDefTransexc record);
	/**
     * 
     * @param paramMap
     * @return
     */
	@SuppressWarnings("rawtypes")
	int countTransport(Map paramMap);
	/**
	 * 
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<TDefTransexc> getTransportInfoList(Map paramMap);
	/**
	 * 传输配置前列表查
	 * @param paramMap
	 * @return
	 */
	int dataTransportAgoTableCounts(Map<String, Object> paramMap);

	List<Map<String, Object>> dataTransportAgoTableList(Map<String, Object> paramMap);
	/**
	 * 总数
	 * @param paramMap
	 * @return
	 */
	int dataTransportConfigTableCounts(Map<String, Object> paramMap);

	/**
	 * 列表查询
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> dataTransportConfigTableList(Map<String, Object> paramMap);
	
	/**
	 * 统计传输后
	 * @param paramMap
	 * @return
	 */
	int dataTransportAfterTableCounts(Map<String, Object> paramMap);
	/**
	 * 获取传输后
	 * @param paramMap
	 * @return
	 */
	List<Map<String, Object>> dataTransportAfterTableList(Map<String, Object> paramMap);
	/**
	 * 查询传输类型
	 * @param map
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	List<Map> selectTransType(Map<String, BigDecimal> map);
	/**
	 * 根据平台获取传输:结果有效且有序
	 * @author Darker.Wang 
	 * @param comId
	 * @return
	 */
	public List<TDefTransexc> getTransByComId(BigDecimal comId);
	List<Map> queryListInfo(Map map);
}