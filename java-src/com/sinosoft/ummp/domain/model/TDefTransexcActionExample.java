package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefTransexcActionExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public TDefTransexcActionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
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
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(BigDecimal value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(BigDecimal value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(BigDecimal value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(BigDecimal value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<BigDecimal> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<BigDecimal> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andExcIdIsNull() {
            addCriterion("EXC_ID is null");
            return (Criteria) this;
        }

        public Criteria andExcIdIsNotNull() {
            addCriterion("EXC_ID is not null");
            return (Criteria) this;
        }

        public Criteria andExcIdEqualTo(BigDecimal value) {
            addCriterion("EXC_ID =", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotEqualTo(BigDecimal value) {
            addCriterion("EXC_ID <>", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdGreaterThan(BigDecimal value) {
            addCriterion("EXC_ID >", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("EXC_ID >=", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdLessThan(BigDecimal value) {
            addCriterion("EXC_ID <", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("EXC_ID <=", value, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdIn(List<BigDecimal> values) {
            addCriterion("EXC_ID in", values, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotIn(List<BigDecimal> values) {
            addCriterion("EXC_ID not in", values, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXC_ID between", value1, value2, "excId");
            return (Criteria) this;
        }

        public Criteria andExcIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("EXC_ID not between", value1, value2, "excId");
            return (Criteria) this;
        }

        public Criteria andSqlIdIsNull() {
            addCriterion("SQL_ID is null");
            return (Criteria) this;
        }

        public Criteria andSqlIdIsNotNull() {
            addCriterion("SQL_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSqlIdEqualTo(BigDecimal value) {
            addCriterion("SQL_ID =", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdNotEqualTo(BigDecimal value) {
            addCriterion("SQL_ID <>", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdGreaterThan(BigDecimal value) {
            addCriterion("SQL_ID >", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SQL_ID >=", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdLessThan(BigDecimal value) {
            addCriterion("SQL_ID <", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SQL_ID <=", value, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdIn(List<BigDecimal> values) {
            addCriterion("SQL_ID in", values, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdNotIn(List<BigDecimal> values) {
            addCriterion("SQL_ID not in", values, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SQL_ID between", value1, value2, "sqlId");
            return (Criteria) this;
        }

        public Criteria andSqlIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SQL_ID not between", value1, value2, "sqlId");
            return (Criteria) this;
        }

        public Criteria andExcNumIsNull() {
            addCriterion("EXC_NUM is null");
            return (Criteria) this;
        }

        public Criteria andExcNumIsNotNull() {
            addCriterion("EXC_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andExcNumEqualTo(Long value) {
            addCriterion("EXC_NUM =", value, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumNotEqualTo(Long value) {
            addCriterion("EXC_NUM <>", value, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumGreaterThan(Long value) {
            addCriterion("EXC_NUM >", value, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumGreaterThanOrEqualTo(Long value) {
            addCriterion("EXC_NUM >=", value, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumLessThan(Long value) {
            addCriterion("EXC_NUM <", value, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumLessThanOrEqualTo(Long value) {
            addCriterion("EXC_NUM <=", value, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumIn(List<Long> values) {
            addCriterion("EXC_NUM in", values, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumNotIn(List<Long> values) {
            addCriterion("EXC_NUM not in", values, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumBetween(Long value1, Long value2) {
            addCriterion("EXC_NUM between", value1, value2, "excNum");
            return (Criteria) this;
        }

        public Criteria andExcNumNotBetween(Long value1, Long value2) {
            addCriterion("EXC_NUM not between", value1, value2, "excNum");
            return (Criteria) this;
        }

        public Criteria andRcStatusIsNull() {
            addCriterion("RC_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andRcStatusIsNotNull() {
            addCriterion("RC_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andRcStatusEqualTo(Short value) {
            addCriterion("RC_STATUS =", value, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusNotEqualTo(Short value) {
            addCriterion("RC_STATUS <>", value, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusGreaterThan(Short value) {
            addCriterion("RC_STATUS >", value, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("RC_STATUS >=", value, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusLessThan(Short value) {
            addCriterion("RC_STATUS <", value, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusLessThanOrEqualTo(Short value) {
            addCriterion("RC_STATUS <=", value, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusIn(List<Short> values) {
            addCriterion("RC_STATUS in", values, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusNotIn(List<Short> values) {
            addCriterion("RC_STATUS not in", values, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusBetween(Short value1, Short value2) {
            addCriterion("RC_STATUS between", value1, value2, "rcStatus");
            return (Criteria) this;
        }

        public Criteria andRcStatusNotBetween(Short value1, Short value2) {
            addCriterion("RC_STATUS not between", value1, value2, "rcStatus");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 28 10:23:43 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_TRANSEXC_ACTION
     *
     * @mbggenerated Tue Jun 28 10:23:43 CST 2016
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