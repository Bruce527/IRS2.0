package com.sinosoft.platform.core.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefPlatComExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public TDefPlatComExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andComIdIsNull() {
            addCriterion("COM_ID is null");
            return (Criteria) this;
        }

        public Criteria andComIdIsNotNull() {
            addCriterion("COM_ID is not null");
            return (Criteria) this;
        }

        public Criteria andComIdEqualTo(BigDecimal value) {
            addCriterion("COM_ID =", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotEqualTo(BigDecimal value) {
            addCriterion("COM_ID <>", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThan(BigDecimal value) {
            addCriterion("COM_ID >", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_ID >=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThan(BigDecimal value) {
            addCriterion("COM_ID <", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_ID <=", value, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdIn(List<BigDecimal> values) {
            addCriterion("COM_ID in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotIn(List<BigDecimal> values) {
            addCriterion("COM_ID not in", values, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_ID between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_ID not between", value1, value2, "comId");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNull() {
            addCriterion("COM_CODE is null");
            return (Criteria) this;
        }

        public Criteria andComCodeIsNotNull() {
            addCriterion("COM_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andComCodeEqualTo(String value) {
            addCriterion("COM_CODE =", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotEqualTo(String value) {
            addCriterion("COM_CODE <>", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThan(String value) {
            addCriterion("COM_CODE >", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeGreaterThanOrEqualTo(String value) {
            addCriterion("COM_CODE >=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThan(String value) {
            addCriterion("COM_CODE <", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLessThanOrEqualTo(String value) {
            addCriterion("COM_CODE <=", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeLike(String value) {
            addCriterion("COM_CODE like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotLike(String value) {
            addCriterion("COM_CODE not like", value, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeIn(List<String> values) {
            addCriterion("COM_CODE in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotIn(List<String> values) {
            addCriterion("COM_CODE not in", values, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeBetween(String value1, String value2) {
            addCriterion("COM_CODE between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andComCodeNotBetween(String value1, String value2) {
            addCriterion("COM_CODE not between", value1, value2, "comCode");
            return (Criteria) this;
        }

        public Criteria andComNameIsNull() {
            addCriterion("COM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andComNameIsNotNull() {
            addCriterion("COM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEqualTo(String value) {
            addCriterion("COM_NAME =", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotEqualTo(String value) {
            addCriterion("COM_NAME <>", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThan(String value) {
            addCriterion("COM_NAME >", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameGreaterThanOrEqualTo(String value) {
            addCriterion("COM_NAME >=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThan(String value) {
            addCriterion("COM_NAME <", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLessThanOrEqualTo(String value) {
            addCriterion("COM_NAME <=", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameLike(String value) {
            addCriterion("COM_NAME like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotLike(String value) {
            addCriterion("COM_NAME not like", value, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameIn(List<String> values) {
            addCriterion("COM_NAME in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotIn(List<String> values) {
            addCriterion("COM_NAME not in", values, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameBetween(String value1, String value2) {
            addCriterion("COM_NAME between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComNameNotBetween(String value1, String value2) {
            addCriterion("COM_NAME not between", value1, value2, "comName");
            return (Criteria) this;
        }

        public Criteria andComPidIsNull() {
            addCriterion("COM_PID is null");
            return (Criteria) this;
        }

        public Criteria andComPidIsNotNull() {
            addCriterion("COM_PID is not null");
            return (Criteria) this;
        }

        public Criteria andComPidEqualTo(BigDecimal value) {
            addCriterion("COM_PID =", value, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidNotEqualTo(BigDecimal value) {
            addCriterion("COM_PID <>", value, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidGreaterThan(BigDecimal value) {
            addCriterion("COM_PID >", value, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_PID >=", value, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidLessThan(BigDecimal value) {
            addCriterion("COM_PID <", value, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("COM_PID <=", value, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidIn(List<BigDecimal> values) {
            addCriterion("COM_PID in", values, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidNotIn(List<BigDecimal> values) {
            addCriterion("COM_PID not in", values, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_PID between", value1, value2, "comPid");
            return (Criteria) this;
        }

        public Criteria andComPidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("COM_PID not between", value1, value2, "comPid");
            return (Criteria) this;
        }

        public Criteria andComNameShortIsNull() {
            addCriterion("COM_NAME_SHORT is null");
            return (Criteria) this;
        }

        public Criteria andComNameShortIsNotNull() {
            addCriterion("COM_NAME_SHORT is not null");
            return (Criteria) this;
        }

        public Criteria andComNameShortEqualTo(String value) {
            addCriterion("COM_NAME_SHORT =", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotEqualTo(String value) {
            addCriterion("COM_NAME_SHORT <>", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortGreaterThan(String value) {
            addCriterion("COM_NAME_SHORT >", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortGreaterThanOrEqualTo(String value) {
            addCriterion("COM_NAME_SHORT >=", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortLessThan(String value) {
            addCriterion("COM_NAME_SHORT <", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortLessThanOrEqualTo(String value) {
            addCriterion("COM_NAME_SHORT <=", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortLike(String value) {
            addCriterion("COM_NAME_SHORT like", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotLike(String value) {
            addCriterion("COM_NAME_SHORT not like", value, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortIn(List<String> values) {
            addCriterion("COM_NAME_SHORT in", values, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotIn(List<String> values) {
            addCriterion("COM_NAME_SHORT not in", values, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortBetween(String value1, String value2) {
            addCriterion("COM_NAME_SHORT between", value1, value2, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameShortNotBetween(String value1, String value2) {
            addCriterion("COM_NAME_SHORT not between", value1, value2, "comNameShort");
            return (Criteria) this;
        }

        public Criteria andComNameEnIsNull() {
            addCriterion("COM_NAME_EN is null");
            return (Criteria) this;
        }

        public Criteria andComNameEnIsNotNull() {
            addCriterion("COM_NAME_EN is not null");
            return (Criteria) this;
        }

        public Criteria andComNameEnEqualTo(String value) {
            addCriterion("COM_NAME_EN =", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotEqualTo(String value) {
            addCriterion("COM_NAME_EN <>", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnGreaterThan(String value) {
            addCriterion("COM_NAME_EN >", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnGreaterThanOrEqualTo(String value) {
            addCriterion("COM_NAME_EN >=", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnLessThan(String value) {
            addCriterion("COM_NAME_EN <", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnLessThanOrEqualTo(String value) {
            addCriterion("COM_NAME_EN <=", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnLike(String value) {
            addCriterion("COM_NAME_EN like", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotLike(String value) {
            addCriterion("COM_NAME_EN not like", value, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnIn(List<String> values) {
            addCriterion("COM_NAME_EN in", values, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotIn(List<String> values) {
            addCriterion("COM_NAME_EN not in", values, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnBetween(String value1, String value2) {
            addCriterion("COM_NAME_EN between", value1, value2, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComNameEnNotBetween(String value1, String value2) {
            addCriterion("COM_NAME_EN not between", value1, value2, "comNameEn");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNull() {
            addCriterion("COM_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andComAddressIsNotNull() {
            addCriterion("COM_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andComAddressEqualTo(String value) {
            addCriterion("COM_ADDRESS =", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotEqualTo(String value) {
            addCriterion("COM_ADDRESS <>", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThan(String value) {
            addCriterion("COM_ADDRESS >", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressGreaterThanOrEqualTo(String value) {
            addCriterion("COM_ADDRESS >=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThan(String value) {
            addCriterion("COM_ADDRESS <", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLessThanOrEqualTo(String value) {
            addCriterion("COM_ADDRESS <=", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressLike(String value) {
            addCriterion("COM_ADDRESS like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotLike(String value) {
            addCriterion("COM_ADDRESS not like", value, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressIn(List<String> values) {
            addCriterion("COM_ADDRESS in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotIn(List<String> values) {
            addCriterion("COM_ADDRESS not in", values, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressBetween(String value1, String value2) {
            addCriterion("COM_ADDRESS between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComAddressNotBetween(String value1, String value2) {
            addCriterion("COM_ADDRESS not between", value1, value2, "comAddress");
            return (Criteria) this;
        }

        public Criteria andComEmailIsNull() {
            addCriterion("COM_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andComEmailIsNotNull() {
            addCriterion("COM_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andComEmailEqualTo(String value) {
            addCriterion("COM_EMAIL =", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotEqualTo(String value) {
            addCriterion("COM_EMAIL <>", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailGreaterThan(String value) {
            addCriterion("COM_EMAIL >", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailGreaterThanOrEqualTo(String value) {
            addCriterion("COM_EMAIL >=", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLessThan(String value) {
            addCriterion("COM_EMAIL <", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLessThanOrEqualTo(String value) {
            addCriterion("COM_EMAIL <=", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailLike(String value) {
            addCriterion("COM_EMAIL like", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotLike(String value) {
            addCriterion("COM_EMAIL not like", value, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailIn(List<String> values) {
            addCriterion("COM_EMAIL in", values, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotIn(List<String> values) {
            addCriterion("COM_EMAIL not in", values, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailBetween(String value1, String value2) {
            addCriterion("COM_EMAIL between", value1, value2, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComEmailNotBetween(String value1, String value2) {
            addCriterion("COM_EMAIL not between", value1, value2, "comEmail");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNull() {
            addCriterion("COM_PHONE is null");
            return (Criteria) this;
        }

        public Criteria andComPhoneIsNotNull() {
            addCriterion("COM_PHONE is not null");
            return (Criteria) this;
        }

        public Criteria andComPhoneEqualTo(String value) {
            addCriterion("COM_PHONE =", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotEqualTo(String value) {
            addCriterion("COM_PHONE <>", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThan(String value) {
            addCriterion("COM_PHONE >", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("COM_PHONE >=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThan(String value) {
            addCriterion("COM_PHONE <", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLessThanOrEqualTo(String value) {
            addCriterion("COM_PHONE <=", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneLike(String value) {
            addCriterion("COM_PHONE like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotLike(String value) {
            addCriterion("COM_PHONE not like", value, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneIn(List<String> values) {
            addCriterion("COM_PHONE in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotIn(List<String> values) {
            addCriterion("COM_PHONE not in", values, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneBetween(String value1, String value2) {
            addCriterion("COM_PHONE between", value1, value2, "comPhone");
            return (Criteria) this;
        }

        public Criteria andComPhoneNotBetween(String value1, String value2) {
            addCriterion("COM_PHONE not between", value1, value2, "comPhone");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated do_not_delete_during_merge Wed May 25 16:59:03 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_PLAT_COM
     *
     * @mbggenerated Wed May 25 16:59:03 CST 2016
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}