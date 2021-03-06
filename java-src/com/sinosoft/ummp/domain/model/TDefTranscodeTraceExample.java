package com.sinosoft.ummp.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TDefTranscodeTraceExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public TDefTranscodeTraceExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
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

		protected void addCriterionForJDBCDate(String condition, Date value,
				String property) {
			if (value == null) {
				throw new RuntimeException("Value for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value.getTime()),
					property);
		}

		protected void addCriterionForJDBCDate(String condition,
				List<Date> values, String property) {
			if (values == null || values.size() == 0) {
				throw new RuntimeException("Value list for " + property
						+ " cannot be null or empty");
			}
			List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
			Iterator<Date> iter = values.iterator();
			while (iter.hasNext()) {
				dateList.add(new java.sql.Date(iter.next().getTime()));
			}
			addCriterion(condition, dateList, property);
		}

		protected void addCriterionForJDBCDate(String condition, Date value1,
				Date value2, String property) {
			if (value1 == null || value2 == null) {
				throw new RuntimeException("Between values for " + property
						+ " cannot be null");
			}
			addCriterion(condition, new java.sql.Date(value1.getTime()),
					new java.sql.Date(value2.getTime()), property);
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

		public Criteria andBatchNoIsNull() {
			addCriterion("BATCH_NO is null");
			return (Criteria) this;
		}

		public Criteria andBatchNoIsNotNull() {
			addCriterion("BATCH_NO is not null");
			return (Criteria) this;
		}

		public Criteria andBatchNoEqualTo(String value) {
			addCriterion("BATCH_NO =", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoNotEqualTo(String value) {
			addCriterion("BATCH_NO <>", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoGreaterThan(String value) {
			addCriterion("BATCH_NO >", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
			addCriterion("BATCH_NO >=", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoLessThan(String value) {
			addCriterion("BATCH_NO <", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoLessThanOrEqualTo(String value) {
			addCriterion("BATCH_NO <=", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoLike(String value) {
			addCriterion("BATCH_NO like", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoNotLike(String value) {
			addCriterion("BATCH_NO not like", value, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoIn(List<String> values) {
			addCriterion("BATCH_NO in", values, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoNotIn(List<String> values) {
			addCriterion("BATCH_NO not in", values, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoBetween(String value1, String value2) {
			addCriterion("BATCH_NO between", value1, value2, "batchNo");
			return (Criteria) this;
		}

		public Criteria andBatchNoNotBetween(String value1, String value2) {
			addCriterion("BATCH_NO not between", value1, value2, "batchNo");
			return (Criteria) this;
		}

		public Criteria andActionNoIsNull() {
			addCriterion("ACTION_NO is null");
			return (Criteria) this;
		}

		public Criteria andActionNoIsNotNull() {
			addCriterion("ACTION_NO is not null");
			return (Criteria) this;
		}

		public Criteria andActionNoEqualTo(String value) {
			addCriterion("ACTION_NO =", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoNotEqualTo(String value) {
			addCriterion("ACTION_NO <>", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoGreaterThan(String value) {
			addCriterion("ACTION_NO >", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoGreaterThanOrEqualTo(String value) {
			addCriterion("ACTION_NO >=", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoLessThan(String value) {
			addCriterion("ACTION_NO <", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoLessThanOrEqualTo(String value) {
			addCriterion("ACTION_NO <=", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoLike(String value) {
			addCriterion("ACTION_NO like", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoNotLike(String value) {
			addCriterion("ACTION_NO not like", value, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoIn(List<String> values) {
			addCriterion("ACTION_NO in", values, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoNotIn(List<String> values) {
			addCriterion("ACTION_NO not in", values, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoBetween(String value1, String value2) {
			addCriterion("ACTION_NO between", value1, value2, "actionNo");
			return (Criteria) this;
		}

		public Criteria andActionNoNotBetween(String value1, String value2) {
			addCriterion("ACTION_NO not between", value1, value2, "actionNo");
			return (Criteria) this;
		}

		public Criteria andTransexcIdIsNull() {
			addCriterion("TRANSEXC_ID is null");
			return (Criteria) this;
		}

		public Criteria andTransexcIdIsNotNull() {
			addCriterion("TRANSEXC_ID is not null");
			return (Criteria) this;
		}

		public Criteria andTransexcIdEqualTo(BigDecimal value) {
			addCriterion("TRANSEXC_ID =", value, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdNotEqualTo(BigDecimal value) {
			addCriterion("TRANSEXC_ID <>", value, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdGreaterThan(BigDecimal value) {
			addCriterion("TRANSEXC_ID >", value, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSEXC_ID >=", value, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdLessThan(BigDecimal value) {
			addCriterion("TRANSEXC_ID <", value, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("TRANSEXC_ID <=", value, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdIn(List<BigDecimal> values) {
			addCriterion("TRANSEXC_ID in", values, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdNotIn(List<BigDecimal> values) {
			addCriterion("TRANSEXC_ID not in", values, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("TRANSEXC_ID between", value1, value2, "transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcIdNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("TRANSEXC_ID not between", value1, value2,
					"transexcId");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeIsNull() {
			addCriterion("TRANSEXC_CODE is null");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeIsNotNull() {
			addCriterion("TRANSEXC_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeEqualTo(String value) {
			addCriterion("TRANSEXC_CODE =", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeNotEqualTo(String value) {
			addCriterion("TRANSEXC_CODE <>", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeGreaterThan(String value) {
			addCriterion("TRANSEXC_CODE >", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSEXC_CODE >=", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeLessThan(String value) {
			addCriterion("TRANSEXC_CODE <", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeLessThanOrEqualTo(String value) {
			addCriterion("TRANSEXC_CODE <=", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeLike(String value) {
			addCriterion("TRANSEXC_CODE like", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeNotLike(String value) {
			addCriterion("TRANSEXC_CODE not like", value, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeIn(List<String> values) {
			addCriterion("TRANSEXC_CODE in", values, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeNotIn(List<String> values) {
			addCriterion("TRANSEXC_CODE not in", values, "transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeBetween(String value1, String value2) {
			addCriterion("TRANSEXC_CODE between", value1, value2,
					"transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcCodeNotBetween(String value1, String value2) {
			addCriterion("TRANSEXC_CODE not between", value1, value2,
					"transexcCode");
			return (Criteria) this;
		}

		public Criteria andTransexcNameIsNull() {
			addCriterion("TRANSEXC_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTransexcNameIsNotNull() {
			addCriterion("TRANSEXC_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTransexcNameEqualTo(String value) {
			addCriterion("TRANSEXC_NAME =", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameNotEqualTo(String value) {
			addCriterion("TRANSEXC_NAME <>", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameGreaterThan(String value) {
			addCriterion("TRANSEXC_NAME >", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameGreaterThanOrEqualTo(String value) {
			addCriterion("TRANSEXC_NAME >=", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameLessThan(String value) {
			addCriterion("TRANSEXC_NAME <", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameLessThanOrEqualTo(String value) {
			addCriterion("TRANSEXC_NAME <=", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameLike(String value) {
			addCriterion("TRANSEXC_NAME like", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameNotLike(String value) {
			addCriterion("TRANSEXC_NAME not like", value, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameIn(List<String> values) {
			addCriterion("TRANSEXC_NAME in", values, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameNotIn(List<String> values) {
			addCriterion("TRANSEXC_NAME not in", values, "transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameBetween(String value1, String value2) {
			addCriterion("TRANSEXC_NAME between", value1, value2,
					"transexcName");
			return (Criteria) this;
		}

		public Criteria andTransexcNameNotBetween(String value1, String value2) {
			addCriterion("TRANSEXC_NAME not between", value1, value2,
					"transexcName");
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

		public Criteria andSqlDescIsNull() {
			addCriterion("SQL_DESC is null");
			return (Criteria) this;
		}

		public Criteria andSqlDescIsNotNull() {
			addCriterion("SQL_DESC is not null");
			return (Criteria) this;
		}

		public Criteria andSqlDescEqualTo(String value) {
			addCriterion("SQL_DESC =", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescNotEqualTo(String value) {
			addCriterion("SQL_DESC <>", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescGreaterThan(String value) {
			addCriterion("SQL_DESC >", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescGreaterThanOrEqualTo(String value) {
			addCriterion("SQL_DESC >=", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescLessThan(String value) {
			addCriterion("SQL_DESC <", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescLessThanOrEqualTo(String value) {
			addCriterion("SQL_DESC <=", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescLike(String value) {
			addCriterion("SQL_DESC like", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescNotLike(String value) {
			addCriterion("SQL_DESC not like", value, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescIn(List<String> values) {
			addCriterion("SQL_DESC in", values, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescNotIn(List<String> values) {
			addCriterion("SQL_DESC not in", values, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescBetween(String value1, String value2) {
			addCriterion("SQL_DESC between", value1, value2, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andSqlDescNotBetween(String value1, String value2) {
			addCriterion("SQL_DESC not between", value1, value2, "sqlDesc");
			return (Criteria) this;
		}

		public Criteria andMsgIsNull() {
			addCriterion("MSG is null");
			return (Criteria) this;
		}

		public Criteria andMsgIsNotNull() {
			addCriterion("MSG is not null");
			return (Criteria) this;
		}

		public Criteria andMsgEqualTo(String value) {
			addCriterion("MSG =", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotEqualTo(String value) {
			addCriterion("MSG <>", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgGreaterThan(String value) {
			addCriterion("MSG >", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgGreaterThanOrEqualTo(String value) {
			addCriterion("MSG >=", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgLessThan(String value) {
			addCriterion("MSG <", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgLessThanOrEqualTo(String value) {
			addCriterion("MSG <=", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgLike(String value) {
			addCriterion("MSG like", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotLike(String value) {
			addCriterion("MSG not like", value, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgIn(List<String> values) {
			addCriterion("MSG in", values, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotIn(List<String> values) {
			addCriterion("MSG not in", values, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgBetween(String value1, String value2) {
			addCriterion("MSG between", value1, value2, "msg");
			return (Criteria) this;
		}

		public Criteria andMsgNotBetween(String value1, String value2) {
			addCriterion("MSG not between", value1, value2, "msg");
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
			addCriterionForJDBCDate("INSERT_TIME between", value1, value2,
					"insertTime");
			return (Criteria) this;
		}

		public Criteria andInsertTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("INSERT_TIME not between", value1, value2,
					"insertTime");
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
			addCriterionForJDBCDate("LAST_MODIFY_TIME =", value,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeNotEqualTo(Date value) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME <>", value,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeGreaterThan(Date value) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME >", value,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeGreaterThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME >=", value,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeLessThan(Date value) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME <", value,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeLessThanOrEqualTo(Date value) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME <=", value,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeIn(List<Date> values) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME in", values,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeNotIn(List<Date> values) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME not in", values,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME between", value1, value2,
					"lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andLastModifyTimeNotBetween(Date value1, Date value2) {
			addCriterionForJDBCDate("LAST_MODIFY_TIME not between", value1,
					value2, "lastModifyTime");
			return (Criteria) this;
		}

		public Criteria andStateFlagIsNull() {
			addCriterion("STATE_FLAG is null");
			return (Criteria) this;
		}

		public Criteria andStateFlagIsNotNull() {
			addCriterion("STATE_FLAG is not null");
			return (Criteria) this;
		}

		public Criteria andStateFlagEqualTo(String value) {
			addCriterion("STATE_FLAG =", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagNotEqualTo(String value) {
			addCriterion("STATE_FLAG <>", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagGreaterThan(String value) {
			addCriterion("STATE_FLAG >", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagGreaterThanOrEqualTo(String value) {
			addCriterion("STATE_FLAG >=", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagLessThan(String value) {
			addCriterion("STATE_FLAG <", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagLessThanOrEqualTo(String value) {
			addCriterion("STATE_FLAG <=", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagLike(String value) {
			addCriterion("STATE_FLAG like", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagNotLike(String value) {
			addCriterion("STATE_FLAG not like", value, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagIn(List<String> values) {
			addCriterion("STATE_FLAG in", values, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagNotIn(List<String> values) {
			addCriterion("STATE_FLAG not in", values, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagBetween(String value1, String value2) {
			addCriterion("STATE_FLAG between", value1, value2, "stateFlag");
			return (Criteria) this;
		}

		public Criteria andStateFlagNotBetween(String value1, String value2) {
			addCriterion("STATE_FLAG not between", value1, value2, "stateFlag");
			return (Criteria) this;
		}
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_TRANSCODE_TRACE
	 * @mbggenerated  Sun Oct 09 13:28:37 CST 2016
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
     * This class corresponds to the database table T_DEF_TRANSCODE_TRACE
     *
     * @mbggenerated do_not_delete_during_merge Sun Oct 09 13:17:55 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}