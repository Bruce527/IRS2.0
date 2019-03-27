package com.sinosoft.platform.core.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefSqlParamsExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public TDefSqlParamsExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
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

		protected void addCriterion(String condition, Object value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			criteria.add(new Criterion(condition, value));
		}

		protected void addCriterion(String condition, Object value1,
				Object value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
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

		public Criteria andParamTypeIsNull() {
			addCriterion("PARAM_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andParamTypeIsNotNull() {
			addCriterion("PARAM_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andParamTypeEqualTo(String value) {
			addCriterion("PARAM_TYPE =", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotEqualTo(String value) {
			addCriterion("PARAM_TYPE <>", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeGreaterThan(String value) {
			addCriterion("PARAM_TYPE >", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_TYPE >=", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeLessThan(String value) {
			addCriterion("PARAM_TYPE <", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeLessThanOrEqualTo(String value) {
			addCriterion("PARAM_TYPE <=", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeLike(String value) {
			addCriterion("PARAM_TYPE like", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotLike(String value) {
			addCriterion("PARAM_TYPE not like", value, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeIn(List<String> values) {
			addCriterion("PARAM_TYPE in", values, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotIn(List<String> values) {
			addCriterion("PARAM_TYPE not in", values, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeBetween(String value1, String value2) {
			addCriterion("PARAM_TYPE between", value1, value2, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamTypeNotBetween(String value1, String value2) {
			addCriterion("PARAM_TYPE not between", value1, value2, "paramType");
			return (Criteria) this;
		}

		public Criteria andParamCodeIsNull() {
			addCriterion("PARAM_CODE is null");
			return (Criteria) this;
		}

		public Criteria andParamCodeIsNotNull() {
			addCriterion("PARAM_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andParamCodeEqualTo(String value) {
			addCriterion("PARAM_CODE =", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeNotEqualTo(String value) {
			addCriterion("PARAM_CODE <>", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeGreaterThan(String value) {
			addCriterion("PARAM_CODE >", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_CODE >=", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeLessThan(String value) {
			addCriterion("PARAM_CODE <", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeLessThanOrEqualTo(String value) {
			addCriterion("PARAM_CODE <=", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeLike(String value) {
			addCriterion("PARAM_CODE like", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeNotLike(String value) {
			addCriterion("PARAM_CODE not like", value, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeIn(List<String> values) {
			addCriterion("PARAM_CODE in", values, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeNotIn(List<String> values) {
			addCriterion("PARAM_CODE not in", values, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeBetween(String value1, String value2) {
			addCriterion("PARAM_CODE between", value1, value2, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamCodeNotBetween(String value1, String value2) {
			addCriterion("PARAM_CODE not between", value1, value2, "paramCode");
			return (Criteria) this;
		}

		public Criteria andParamNameIsNull() {
			addCriterion("PARAM_NAME is null");
			return (Criteria) this;
		}

		public Criteria andParamNameIsNotNull() {
			addCriterion("PARAM_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andParamNameEqualTo(String value) {
			addCriterion("PARAM_NAME =", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameNotEqualTo(String value) {
			addCriterion("PARAM_NAME <>", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameGreaterThan(String value) {
			addCriterion("PARAM_NAME >", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_NAME >=", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameLessThan(String value) {
			addCriterion("PARAM_NAME <", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameLessThanOrEqualTo(String value) {
			addCriterion("PARAM_NAME <=", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameLike(String value) {
			addCriterion("PARAM_NAME like", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameNotLike(String value) {
			addCriterion("PARAM_NAME not like", value, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameIn(List<String> values) {
			addCriterion("PARAM_NAME in", values, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameNotIn(List<String> values) {
			addCriterion("PARAM_NAME not in", values, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameBetween(String value1, String value2) {
			addCriterion("PARAM_NAME between", value1, value2, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamNameNotBetween(String value1, String value2) {
			addCriterion("PARAM_NAME not between", value1, value2, "paramName");
			return (Criteria) this;
		}

		public Criteria andParamValueIsNull() {
			addCriterion("PARAM_VALUE is null");
			return (Criteria) this;
		}

		public Criteria andParamValueIsNotNull() {
			addCriterion("PARAM_VALUE is not null");
			return (Criteria) this;
		}

		public Criteria andParamValueEqualTo(String value) {
			addCriterion("PARAM_VALUE =", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotEqualTo(String value) {
			addCriterion("PARAM_VALUE <>", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueGreaterThan(String value) {
			addCriterion("PARAM_VALUE >", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE >=", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLessThan(String value) {
			addCriterion("PARAM_VALUE <", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLessThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE <=", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueLike(String value) {
			addCriterion("PARAM_VALUE like", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotLike(String value) {
			addCriterion("PARAM_VALUE not like", value, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueIn(List<String> values) {
			addCriterion("PARAM_VALUE in", values, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotIn(List<String> values) {
			addCriterion("PARAM_VALUE not in", values, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE between", value1, value2, "paramValue");
			return (Criteria) this;
		}

		public Criteria andParamValueNotBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE not between", value1, value2,
					"paramValue");
			return (Criteria) this;
		}

		public Criteria andEsStatusIsNull() {
			addCriterion("ES_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andEsStatusIsNotNull() {
			addCriterion("ES_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andEsStatusEqualTo(Short value) {
			addCriterion("ES_STATUS =", value, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusNotEqualTo(Short value) {
			addCriterion("ES_STATUS <>", value, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusGreaterThan(Short value) {
			addCriterion("ES_STATUS >", value, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusGreaterThanOrEqualTo(Short value) {
			addCriterion("ES_STATUS >=", value, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusLessThan(Short value) {
			addCriterion("ES_STATUS <", value, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusLessThanOrEqualTo(Short value) {
			addCriterion("ES_STATUS <=", value, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusIn(List<Short> values) {
			addCriterion("ES_STATUS in", values, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusNotIn(List<Short> values) {
			addCriterion("ES_STATUS not in", values, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusBetween(Short value1, Short value2) {
			addCriterion("ES_STATUS between", value1, value2, "esStatus");
			return (Criteria) this;
		}

		public Criteria andEsStatusNotBetween(Short value1, Short value2) {
			addCriterion("ES_STATUS not between", value1, value2, "esStatus");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeIsNull() {
			addCriterion("PARAM_VALUE_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeIsNotNull() {
			addCriterion("PARAM_VALUE_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeEqualTo(String value) {
			addCriterion("PARAM_VALUE_TYPE =", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeNotEqualTo(String value) {
			addCriterion("PARAM_VALUE_TYPE <>", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeGreaterThan(String value) {
			addCriterion("PARAM_VALUE_TYPE >", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE_TYPE >=", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeLessThan(String value) {
			addCriterion("PARAM_VALUE_TYPE <", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeLessThanOrEqualTo(String value) {
			addCriterion("PARAM_VALUE_TYPE <=", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeLike(String value) {
			addCriterion("PARAM_VALUE_TYPE like", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeNotLike(String value) {
			addCriterion("PARAM_VALUE_TYPE not like", value, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeIn(List<String> values) {
			addCriterion("PARAM_VALUE_TYPE in", values, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeNotIn(List<String> values) {
			addCriterion("PARAM_VALUE_TYPE not in", values, "paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE_TYPE between", value1, value2,
					"paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamValueTypeNotBetween(String value1, String value2) {
			addCriterion("PARAM_VALUE_TYPE not between", value1, value2,
					"paramValueType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeIsNull() {
			addCriterion("PARAM_SUB_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeIsNotNull() {
			addCriterion("PARAM_SUB_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeEqualTo(Short value) {
			addCriterion("PARAM_SUB_TYPE =", value, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeNotEqualTo(Short value) {
			addCriterion("PARAM_SUB_TYPE <>", value, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeGreaterThan(Short value) {
			addCriterion("PARAM_SUB_TYPE >", value, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeGreaterThanOrEqualTo(Short value) {
			addCriterion("PARAM_SUB_TYPE >=", value, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeLessThan(Short value) {
			addCriterion("PARAM_SUB_TYPE <", value, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeLessThanOrEqualTo(Short value) {
			addCriterion("PARAM_SUB_TYPE <=", value, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeIn(List<Short> values) {
			addCriterion("PARAM_SUB_TYPE in", values, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeNotIn(List<Short> values) {
			addCriterion("PARAM_SUB_TYPE not in", values, "paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeBetween(Short value1, Short value2) {
			addCriterion("PARAM_SUB_TYPE between", value1, value2,
					"paramSubType");
			return (Criteria) this;
		}

		public Criteria andParamSubTypeNotBetween(Short value1, Short value2) {
			addCriterion("PARAM_SUB_TYPE not between", value1, value2,
					"paramSubType");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_SQL_PARAMS
	 * @mbggenerated  Fri Jul 08 11:30:12 CST 2016
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

		protected Criterion(String condition, Object value, Object secondValue,
				String typeHandler) {
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

	/**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_DEF_SQL_PARAMS
     *
     * @mbggenerated do_not_delete_during_merge Wed Jun 15 16:31:06 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}