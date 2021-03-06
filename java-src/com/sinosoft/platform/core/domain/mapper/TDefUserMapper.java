package com.sinosoft.platform.core.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.core.domain.model.TDefUser;
import com.sinosoft.platform.core.domain.model.TDefUserExample;

public interface TDefUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int countByExample(TDefUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int deleteByExample(TDefUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int insert(TDefUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int insertSelective(TDefUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    List<TDefUser> selectByExample(TDefUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    TDefUser selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int updateByExampleSelective(@Param("record") TDefUser record, @Param("example") TDefUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int updateByExample(@Param("record") TDefUser record, @Param("example") TDefUserExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int updateByPrimaryKeySelective(TDefUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_USER
     *
     * @mbggenerated Sun Sep 18 15:21:27 CST 2016
     */
    int updateByPrimaryKey(TDefUser record);
    
    /**
	 * 服务评价菜单下数据导出查询年份方法
	 * @author kong
	 */
	public List<String> selectExportDataYear();
}