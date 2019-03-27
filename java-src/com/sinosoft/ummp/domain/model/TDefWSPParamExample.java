package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefWSPParamExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public TDefWSPParamExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
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

		public Criteria andRequestIdIsNull() {
			addCriterion("REQUEST_ID is null");
			return (Criteria) this;
		}

		public Criteria andRequestIdIsNotNull() {
			addCriterion("REQUEST_ID is not null");
			return (Criteria) this;
		}

		public Criteria andRequestIdEqualTo(BigDecimal value) {
			addCriterion("REQUEST_ID =", value, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdNotEqualTo(BigDecimal value) {
			addCriterion("REQUEST_ID <>", value, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdGreaterThan(BigDecimal value) {
			addCriterion("REQUEST_ID >", value, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("REQUEST_ID >=", value, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdLessThan(BigDecimal value) {
			addCriterion("REQUEST_ID <", value, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("REQUEST_ID <=", value, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdIn(List<BigDecimal> values) {
			addCriterion("REQUEST_ID in", values, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdNotIn(List<BigDecimal> values) {
			addCriterion("REQUEST_ID not in", values, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("REQUEST_ID between", value1, value2, "requestId");
			return (Criteria) this;
		}

		public Criteria andRequestIdNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("REQUEST_ID not between", value1, value2, "requestId");
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

		public Criteria andParamClassIsNull() {
			addCriterion("PARAM_CLASS is null");
			return (Criteria) this;
		}

		public Criteria andParamClassIsNotNull() {
			addCriterion("PARAM_CLASS is not null");
			return (Criteria) this;
		}

		public Criteria andParamClassEqualTo(String value) {
			addCriterion("PARAM_CLASS =", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassNotEqualTo(String value) {
			addCriterion("PARAM_CLASS <>", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassGreaterThan(String value) {
			addCriterion("PARAM_CLASS >", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassGreaterThanOrEqualTo(String value) {
			addCriterion("PARAM_CLASS >=", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassLessThan(String value) {
			addCriterion("PARAM_CLASS <", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassLessThanOrEqualTo(String value) {
			addCriterion("PARAM_CLASS <=", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassLike(String value) {
			addCriterion("PARAM_CLASS like", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassNotLike(String value) {
			addCriterion("PARAM_CLASS not like", value, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassIn(List<String> values) {
			addCriterion("PARAM_CLASS in", values, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassNotIn(List<String> values) {
			addCriterion("PARAM_CLASS not in", values, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassBetween(String value1, String value2) {
			addCriterion("PARAM_CLASS between", value1, value2, "paramClass");
			return (Criteria) this;
		}

		public Criteria andParamClassNotBetween(String value1, String value2) {
			addCriterion("PARAM_CLASS not between", value1, value2,
					"paramClass");
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

		public Criteria andNumIsNull() {
			addCriterion("NUM is null");
			return (Criteria) this;
		}

		public Criteria andNumIsNotNull() {
			addCriterion("NUM is not null");
			return (Criteria) this;
		}

		public Criteria andNumEqualTo(Short value) {
			addCriterion("NUM =", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotEqualTo(Short value) {
			addCriterion("NUM <>", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThan(Short value) {
			addCriterion("NUM >", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumGreaterThanOrEqualTo(Short value) {
			addCriterion("NUM >=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThan(Short value) {
			addCriterion("NUM <", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumLessThanOrEqualTo(Short value) {
			addCriterion("NUM <=", value, "num");
			return (Criteria) this;
		}

		public Criteria andNumIn(List<Short> values) {
			addCriterion("NUM in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotIn(List<Short> values) {
			addCriterion("NUM not in", values, "num");
			return (Criteria) this;
		}

		public Criteria andNumBetween(Short value1, Short value2) {
			addCriterion("NUM between", value1, value2, "num");
			return (Criteria) this;
		}

		public Criteria andNumNotBetween(Short value1, Short value2) {
			addCriterion("NUM not between", value1, value2, "num");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyIsNull() {
			addCriterion("IS_ANALIZY is null");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyIsNotNull() {
			addCriterion("IS_ANALIZY is not null");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyEqualTo(Short value) {
			addCriterion("IS_ANALIZY =", value, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyNotEqualTo(Short value) {
			addCriterion("IS_ANALIZY <>", value, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyGreaterThan(Short value) {
			addCriterion("IS_ANALIZY >", value, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyGreaterThanOrEqualTo(Short value) {
			addCriterion("IS_ANALIZY >=", value, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyLessThan(Short value) {
			addCriterion("IS_ANALIZY <", value, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyLessThanOrEqualTo(Short value) {
			addCriterion("IS_ANALIZY <=", value, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyIn(List<Short> values) {
			addCriterion("IS_ANALIZY in", values, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyNotIn(List<Short> values) {
			addCriterion("IS_ANALIZY not in", values, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyBetween(Short value1, Short value2) {
			addCriterion("IS_ANALIZY between", value1, value2, "isAnalizy");
			return (Criteria) this;
		}

		public Criteria andIsAnalizyNotBetween(Short value1, Short value2) {
			addCriterion("IS_ANALIZY not between", value1, value2, "isAnalizy");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_WSP_PARAM
	 * @mbggenerated  Thu Jul 28 14:57:54 CST 2016
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
     * This class corresponds to the database table T_DEF_WSP_PARAM
     *
     * @mbggenerated do_not_delete_during_merge Thu Jul 28 14:10:50 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}