package com.sinosoft.platform.core.domain.model;

import java.math.BigDecimal;

public class DefRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_ROLE.ID
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    private BigDecimal id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_ROLE.ROLECODE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    private String rolecode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_DEF_ROLE.ROLENAME
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    private String rolename;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_ROLE.ID
     *
     * @return the value of T_DEF_ROLE.ID
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_ROLE.ID
     *
     * @param id the value for T_DEF_ROLE.ID
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_ROLE.ROLECODE
     *
     * @return the value of T_DEF_ROLE.ROLECODE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    public String getRolecode() {
        return rolecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_ROLE.ROLECODE
     *
     * @param rolecode the value for T_DEF_ROLE.ROLECODE
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    public void setRolecode(String rolecode) {
        this.rolecode = rolecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_DEF_ROLE.ROLENAME
     *
     * @return the value of T_DEF_ROLE.ROLENAME
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_DEF_ROLE.ROLENAME
     *
     * @param rolename the value for T_DEF_ROLE.ROLENAME
     *
     * @mbggenerated Thu May 12 09:48:03 CST 2016
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}