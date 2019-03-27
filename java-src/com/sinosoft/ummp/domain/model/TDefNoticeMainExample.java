package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefNoticeMainExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public TDefNoticeMainExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
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
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
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

        public Criteria andNoticeIdIsNull() {
            addCriterion("NOTICE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIsNotNull() {
            addCriterion("NOTICE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeIdEqualTo(BigDecimal value) {
            addCriterion("NOTICE_ID =", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotEqualTo(BigDecimal value) {
            addCriterion("NOTICE_ID <>", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThan(BigDecimal value) {
            addCriterion("NOTICE_ID >", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("NOTICE_ID >=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThan(BigDecimal value) {
            addCriterion("NOTICE_ID <", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("NOTICE_ID <=", value, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdIn(List<BigDecimal> values) {
            addCriterion("NOTICE_ID in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotIn(List<BigDecimal> values) {
            addCriterion("NOTICE_ID not in", values, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NOTICE_ID between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeIdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("NOTICE_ID not between", value1, value2, "noticeId");
            return (Criteria) this;
        }

        public Criteria andNoticeToIsNull() {
            addCriterion("NOTICE_TO is null");
            return (Criteria) this;
        }

        public Criteria andNoticeToIsNotNull() {
            addCriterion("NOTICE_TO is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeToEqualTo(String value) {
            addCriterion("NOTICE_TO =", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToNotEqualTo(String value) {
            addCriterion("NOTICE_TO <>", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToGreaterThan(String value) {
            addCriterion("NOTICE_TO >", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_TO >=", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToLessThan(String value) {
            addCriterion("NOTICE_TO <", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_TO <=", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToLike(String value) {
            addCriterion("NOTICE_TO like", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToNotLike(String value) {
            addCriterion("NOTICE_TO not like", value, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToIn(List<String> values) {
            addCriterion("NOTICE_TO in", values, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToNotIn(List<String> values) {
            addCriterion("NOTICE_TO not in", values, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToBetween(String value1, String value2) {
            addCriterion("NOTICE_TO between", value1, value2, "noticeTo");
            return (Criteria) this;
        }

        public Criteria andNoticeToNotBetween(String value1, String value2) {
            addCriterion("NOTICE_TO not between", value1, value2, "noticeTo");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated do_not_delete_during_merge Fri Jul 01 17:33:58 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_NOTICE_MAIN
     *
     * @mbggenerated Fri Jul 01 17:33:58 CST 2016
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