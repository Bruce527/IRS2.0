package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TDefNoticeAccountExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public TDefNoticeAccountExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
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
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andNoticeTypeIsNull() {
            addCriterion("NOTICE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNotNull() {
            addCriterion("NOTICE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeEqualTo(String value) {
            addCriterion("NOTICE_TYPE =", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotEqualTo(String value) {
            addCriterion("NOTICE_TYPE <>", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThan(String value) {
            addCriterion("NOTICE_TYPE >", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE >=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThan(String value) {
            addCriterion("NOTICE_TYPE <", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThanOrEqualTo(String value) {
            addCriterion("NOTICE_TYPE <=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLike(String value) {
            addCriterion("NOTICE_TYPE like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotLike(String value) {
            addCriterion("NOTICE_TYPE not like", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIn(List<String> values) {
            addCriterion("NOTICE_TYPE in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotIn(List<String> values) {
            addCriterion("NOTICE_TYPE not in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotBetween(String value1, String value2) {
            addCriterion("NOTICE_TYPE not between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andWebAddressIsNull() {
            addCriterion("WEB_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andWebAddressIsNotNull() {
            addCriterion("WEB_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andWebAddressEqualTo(String value) {
            addCriterion("WEB_ADDRESS =", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotEqualTo(String value) {
            addCriterion("WEB_ADDRESS <>", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressGreaterThan(String value) {
            addCriterion("WEB_ADDRESS >", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_ADDRESS >=", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressLessThan(String value) {
            addCriterion("WEB_ADDRESS <", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressLessThanOrEqualTo(String value) {
            addCriterion("WEB_ADDRESS <=", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressLike(String value) {
            addCriterion("WEB_ADDRESS like", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotLike(String value) {
            addCriterion("WEB_ADDRESS not like", value, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressIn(List<String> values) {
            addCriterion("WEB_ADDRESS in", values, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotIn(List<String> values) {
            addCriterion("WEB_ADDRESS not in", values, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressBetween(String value1, String value2) {
            addCriterion("WEB_ADDRESS between", value1, value2, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebAddressNotBetween(String value1, String value2) {
            addCriterion("WEB_ADDRESS not between", value1, value2, "webAddress");
            return (Criteria) this;
        }

        public Criteria andWebPortIsNull() {
            addCriterion("WEB_PORT is null");
            return (Criteria) this;
        }

        public Criteria andWebPortIsNotNull() {
            addCriterion("WEB_PORT is not null");
            return (Criteria) this;
        }

        public Criteria andWebPortEqualTo(String value) {
            addCriterion("WEB_PORT =", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortNotEqualTo(String value) {
            addCriterion("WEB_PORT <>", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortGreaterThan(String value) {
            addCriterion("WEB_PORT >", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortGreaterThanOrEqualTo(String value) {
            addCriterion("WEB_PORT >=", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortLessThan(String value) {
            addCriterion("WEB_PORT <", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortLessThanOrEqualTo(String value) {
            addCriterion("WEB_PORT <=", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortLike(String value) {
            addCriterion("WEB_PORT like", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortNotLike(String value) {
            addCriterion("WEB_PORT not like", value, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortIn(List<String> values) {
            addCriterion("WEB_PORT in", values, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortNotIn(List<String> values) {
            addCriterion("WEB_PORT not in", values, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortBetween(String value1, String value2) {
            addCriterion("WEB_PORT between", value1, value2, "webPort");
            return (Criteria) this;
        }

        public Criteria andWebPortNotBetween(String value1, String value2) {
            addCriterion("WEB_PORT not between", value1, value2, "webPort");
            return (Criteria) this;
        }

        public Criteria andAccountAddrIsNull() {
            addCriterion("ACCOUNT_ADDR is null");
            return (Criteria) this;
        }

        public Criteria andAccountAddrIsNotNull() {
            addCriterion("ACCOUNT_ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andAccountAddrEqualTo(String value) {
            addCriterion("ACCOUNT_ADDR =", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrNotEqualTo(String value) {
            addCriterion("ACCOUNT_ADDR <>", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrGreaterThan(String value) {
            addCriterion("ACCOUNT_ADDR >", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ADDR >=", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrLessThan(String value) {
            addCriterion("ACCOUNT_ADDR <", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_ADDR <=", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrLike(String value) {
            addCriterion("ACCOUNT_ADDR like", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrNotLike(String value) {
            addCriterion("ACCOUNT_ADDR not like", value, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrIn(List<String> values) {
            addCriterion("ACCOUNT_ADDR in", values, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrNotIn(List<String> values) {
            addCriterion("ACCOUNT_ADDR not in", values, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ADDR between", value1, value2, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountAddrNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_ADDR not between", value1, value2, "accountAddr");
            return (Criteria) this;
        }

        public Criteria andAccountUserIsNull() {
            addCriterion("ACCOUNT_USER is null");
            return (Criteria) this;
        }

        public Criteria andAccountUserIsNotNull() {
            addCriterion("ACCOUNT_USER is not null");
            return (Criteria) this;
        }

        public Criteria andAccountUserEqualTo(String value) {
            addCriterion("ACCOUNT_USER =", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserNotEqualTo(String value) {
            addCriterion("ACCOUNT_USER <>", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserGreaterThan(String value) {
            addCriterion("ACCOUNT_USER >", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_USER >=", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserLessThan(String value) {
            addCriterion("ACCOUNT_USER <", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_USER <=", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserLike(String value) {
            addCriterion("ACCOUNT_USER like", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserNotLike(String value) {
            addCriterion("ACCOUNT_USER not like", value, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserIn(List<String> values) {
            addCriterion("ACCOUNT_USER in", values, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserNotIn(List<String> values) {
            addCriterion("ACCOUNT_USER not in", values, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserBetween(String value1, String value2) {
            addCriterion("ACCOUNT_USER between", value1, value2, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountUserNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_USER not between", value1, value2, "accountUser");
            return (Criteria) this;
        }

        public Criteria andAccountPassIsNull() {
            addCriterion("ACCOUNT_PASS is null");
            return (Criteria) this;
        }

        public Criteria andAccountPassIsNotNull() {
            addCriterion("ACCOUNT_PASS is not null");
            return (Criteria) this;
        }

        public Criteria andAccountPassEqualTo(String value) {
            addCriterion("ACCOUNT_PASS =", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassNotEqualTo(String value) {
            addCriterion("ACCOUNT_PASS <>", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassGreaterThan(String value) {
            addCriterion("ACCOUNT_PASS >", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PASS >=", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassLessThan(String value) {
            addCriterion("ACCOUNT_PASS <", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT_PASS <=", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassLike(String value) {
            addCriterion("ACCOUNT_PASS like", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassNotLike(String value) {
            addCriterion("ACCOUNT_PASS not like", value, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassIn(List<String> values) {
            addCriterion("ACCOUNT_PASS in", values, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassNotIn(List<String> values) {
            addCriterion("ACCOUNT_PASS not in", values, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PASS between", value1, value2, "accountPass");
            return (Criteria) this;
        }

        public Criteria andAccountPassNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT_PASS not between", value1, value2, "accountPass");
            return (Criteria) this;
        }

        public Criteria andErStatusIsNull() {
            addCriterion("ER_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andErStatusIsNotNull() {
            addCriterion("ER_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andErStatusEqualTo(String value) {
            addCriterion("ER_STATUS =", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusNotEqualTo(String value) {
            addCriterion("ER_STATUS <>", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusGreaterThan(String value) {
            addCriterion("ER_STATUS >", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusGreaterThanOrEqualTo(String value) {
            addCriterion("ER_STATUS >=", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusLessThan(String value) {
            addCriterion("ER_STATUS <", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusLessThanOrEqualTo(String value) {
            addCriterion("ER_STATUS <=", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusLike(String value) {
            addCriterion("ER_STATUS like", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusNotLike(String value) {
            addCriterion("ER_STATUS not like", value, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusIn(List<String> values) {
            addCriterion("ER_STATUS in", values, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusNotIn(List<String> values) {
            addCriterion("ER_STATUS not in", values, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusBetween(String value1, String value2) {
            addCriterion("ER_STATUS between", value1, value2, "erStatus");
            return (Criteria) this;
        }

        public Criteria andErStatusNotBetween(String value1, String value2) {
            addCriterion("ER_STATUS not between", value1, value2, "erStatus");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNull() {
            addCriterion("INSERT_TIME is null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIsNotNull() {
            addCriterion("INSERT_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andInsertTimeEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME =", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME <>", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("INSERT_TIME >", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME >=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThan(Date value) {
            addCriterionForJDBCDate("INSERT_TIME <", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("INSERT_TIME <=", value, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeIn(List<Date> values) {
            addCriterionForJDBCDate("INSERT_TIME in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("INSERT_TIME not in", values, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSERT_TIME between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("INSERT_TIME not between", value1, value2, "insertTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNull() {
            addCriterion("LAST_MODIFY_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIsNotNull() {
            addCriterion("LAST_MODIFY_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME =", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME <>", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME >", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME >=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThan(Date value) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME <", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME <=", value, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME not in", values, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("LAST_MODIFY_TIME not between", value1, value2, "lastModifyTime");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNull() {
            addCriterion("OPERATOR is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIsNotNull() {
            addCriterion("OPERATOR is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorEqualTo(String value) {
            addCriterion("OPERATOR =", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotEqualTo(String value) {
            addCriterion("OPERATOR <>", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThan(String value) {
            addCriterion("OPERATOR >", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("OPERATOR >=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThan(String value) {
            addCriterion("OPERATOR <", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("OPERATOR <=", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorLike(String value) {
            addCriterion("OPERATOR like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotLike(String value) {
            addCriterion("OPERATOR not like", value, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorIn(List<String> values) {
            addCriterion("OPERATOR in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotIn(List<String> values) {
            addCriterion("OPERATOR not in", values, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorBetween(String value1, String value2) {
            addCriterion("OPERATOR between", value1, value2, "operator");
            return (Criteria) this;
        }

        public Criteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("OPERATOR not between", value1, value2, "operator");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated do_not_delete_during_merge Tue Jul 05 17:50:12 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_NOTICE_ACCOUNT
     *
     * @mbggenerated Tue Jul 05 17:50:12 CST 2016
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