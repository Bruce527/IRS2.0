package com.sinosoft.ummp.domain.mapper;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.ummp.domain.model.TDefNoticeAccount;
import com.sinosoft.ummp.domain.model.TDefNoticeAccountExample;

public interface TDefNoticeAccountMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int countByExample(TDefNoticeAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int deleteByExample(TDefNoticeAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int insert(TDefNoticeAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int insertSelective(TDefNoticeAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    List<TDefNoticeAccount> selectByExample(TDefNoticeAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    TDefNoticeAccount selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int updateByExampleSelective(@Param("record") TDefNoticeAccount record, @Param("example") TDefNoticeAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int updateByExample(@Param("record") TDefNoticeAccount record, @Param("example") TDefNoticeAccountExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int updateByPrimaryKeySelective(TDefNoticeAccount record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    int updateByPrimaryKey(TDefNoticeAccount record);
    /**
	 * 用户信息列表查询（总记录数）
	 * @param paramMap
	 * @return
	 */
	public Integer queryNoticeListInfoCounts(Map paramMap);
	
	
	/**
	 * 用户信息列表查询（分页查询）
	 * @param paramMap
	 * @return
	 */
	public List<Map> queryNoticeListInfoPages(Map paramMap);
}