package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefTransCodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public TDefTransCodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
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
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
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

        public Criteria andTargetTableNameIsNull() {
            addCriterion("TARGET_TABLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameIsNotNull() {
            addCriterion("TARGET_TABLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameEqualTo(String value) {
            addCriterion("TARGET_TABLE_NAME =", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameNotEqualTo(String value) {
            addCriterion("TARGET_TABLE_NAME <>", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameGreaterThan(String value) {
            addCriterion("TARGET_TABLE_NAME >", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_TABLE_NAME >=", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameLessThan(String value) {
            addCriterion("TARGET_TABLE_NAME <", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameLessThanOrEqualTo(String value) {
            addCriterion("TARGET_TABLE_NAME <=", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameLike(String value) {
            addCriterion("TARGET_TABLE_NAME like", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameNotLike(String value) {
            addCriterion("TARGET_TABLE_NAME not like", value, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameIn(List<String> values) {
            addCriterion("TARGET_TABLE_NAME in", values, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameNotIn(List<String> values) {
            addCriterion("TARGET_TABLE_NAME not in", values, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameBetween(String value1, String value2) {
            addCriterion("TARGET_TABLE_NAME between", value1, value2, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetTableNameNotBetween(String value1, String value2) {
            addCriterion("TARGET_TABLE_NAME not between", value1, value2, "targetTableName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameIsNull() {
            addCriterion("TARGET_COL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andTargetColNameIsNotNull() {
            addCriterion("TARGET_COL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andTargetColNameEqualTo(String value) {
            addCriterion("TARGET_COL_NAME =", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameNotEqualTo(String value) {
            addCriterion("TARGET_COL_NAME <>", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameGreaterThan(String value) {
            addCriterion("TARGET_COL_NAME >", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameGreaterThanOrEqualTo(String value) {
            addCriterion("TARGET_COL_NAME >=", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameLessThan(String value) {
            addCriterion("TARGET_COL_NAME <", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameLessThanOrEqualTo(String value) {
            addCriterion("TARGET_COL_NAME <=", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameLike(String value) {
            addCriterion("TARGET_COL_NAME like", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameNotLike(String value) {
            addCriterion("TARGET_COL_NAME not like", value, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameIn(List<String> values) {
            addCriterion("TARGET_COL_NAME in", values, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameNotIn(List<String> values) {
            addCriterion("TARGET_COL_NAME not in", values, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameBetween(String value1, String value2) {
            addCriterion("TARGET_COL_NAME between", value1, value2, "targetColName");
            return (Criteria) this;
        }

        public Criteria andTargetColNameNotBetween(String value1, String value2) {
            addCriterion("TARGET_COL_NAME not between", value1, value2, "targetColName");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIsNull() {
            addCriterion("CODE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIsNotNull() {
            addCriterion("CODE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeTypeEqualTo(String value) {
            addCriterion("CODE_TYPE =", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotEqualTo(String value) {
            addCriterion("CODE_TYPE <>", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeGreaterThan(String value) {
            addCriterion("CODE_TYPE >", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE_TYPE >=", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLessThan(String value) {
            addCriterion("CODE_TYPE <", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLessThanOrEqualTo(String value) {
            addCriterion("CODE_TYPE <=", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeLike(String value) {
            addCriterion("CODE_TYPE like", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotLike(String value) {
            addCriterion("CODE_TYPE not like", value, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeIn(List<String> values) {
            addCriterion("CODE_TYPE in", values, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotIn(List<String> values) {
            addCriterion("CODE_TYPE not in", values, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeBetween(String value1, String value2) {
            addCriterion("CODE_TYPE between", value1, value2, "codeType");
            return (Criteria) this;
        }

        public Criteria andCodeTypeNotBetween(String value1, String value2) {
            addCriterion("CODE_TYPE not between", value1, value2, "codeType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("DATA_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("DATA_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("DATA_TYPE =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("DATA_TYPE <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("DATA_TYPE >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("DATA_TYPE <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("DATA_TYPE <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("DATA_TYPE like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("DATA_TYPE not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("DATA_TYPE in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("DATA_TYPE not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("DATA_TYPE between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("DATA_TYPE not between", value1, value2, "dataType");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated do_not_delete_during_merge Mon Jul 18 17:49:35 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_TRANS_CODE
     *
     * @mbggenerated Mon Jul 18 17:49:35 CST 2016
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