package com.sinosoft.platform.core.domain.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sinosoft.platform.core.domain.model.DefPrivilege;
import com.sinosoft.platform.core.domain.model.DefPrivilegeExample;

public interface DefPrivilegeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int countByExample(DefPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int deleteByExample(DefPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int deleteByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int insert(DefPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int insertSelective(DefPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    List<DefPrivilege> selectByExample(DefPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    DefPrivilege selectByPrimaryKey(BigDecimal id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int updateByExampleSelective(@Param("record") DefPrivilege record, @Param("example") DefPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int updateByExample(@Param("record") DefPrivilege record, @Param("example") DefPrivilegeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int updateByPrimaryKeySelective(DefPrivilege record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PRIVILEGE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    int updateByPrimaryKey(DefPrivilege record);
}