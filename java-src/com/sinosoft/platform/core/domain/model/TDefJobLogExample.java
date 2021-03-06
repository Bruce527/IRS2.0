package com.sinosoft.platform.core.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TDefJobLogExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public TDefJobLogExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
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

		public Criteria andJobCodeIsNull() {
			addCriterion("JOB_CODE is null");
			return (Criteria) this;
		}

		public Criteria andJobCodeIsNotNull() {
			addCriterion("JOB_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andJobCodeEqualTo(String value) {
			addCriterion("JOB_CODE =", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeNotEqualTo(String value) {
			addCriterion("JOB_CODE <>", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeGreaterThan(String value) {
			addCriterion("JOB_CODE >", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_CODE >=", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeLessThan(String value) {
			addCriterion("JOB_CODE <", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeLessThanOrEqualTo(String value) {
			addCriterion("JOB_CODE <=", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeLike(String value) {
			addCriterion("JOB_CODE like", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeNotLike(String value) {
			addCriterion("JOB_CODE not like", value, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeIn(List<String> values) {
			addCriterion("JOB_CODE in", values, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeNotIn(List<String> values) {
			addCriterion("JOB_CODE not in", values, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeBetween(String value1, String value2) {
			addCriterion("JOB_CODE between", value1, value2, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobCodeNotBetween(String value1, String value2) {
			addCriterion("JOB_CODE not between", value1, value2, "jobCode");
			return (Criteria) this;
		}

		public Criteria andJobNameIsNull() {
			addCriterion("JOB_NAME is null");
			return (Criteria) this;
		}

		public Criteria andJobNameIsNotNull() {
			addCriterion("JOB_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andJobNameEqualTo(String value) {
			addCriterion("JOB_NAME =", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameNotEqualTo(String value) {
			addCriterion("JOB_NAME <>", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameGreaterThan(String value) {
			addCriterion("JOB_NAME >", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_NAME >=", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameLessThan(String value) {
			addCriterion("JOB_NAME <", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameLessThanOrEqualTo(String value) {
			addCriterion("JOB_NAME <=", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameLike(String value) {
			addCriterion("JOB_NAME like", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameNotLike(String value) {
			addCriterion("JOB_NAME not like", value, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameIn(List<String> values) {
			addCriterion("JOB_NAME in", values, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameNotIn(List<String> values) {
			addCriterion("JOB_NAME not in", values, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameBetween(String value1, String value2) {
			addCriterion("JOB_NAME between", value1, value2, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobNameNotBetween(String value1, String value2) {
			addCriterion("JOB_NAME not between", value1, value2, "jobName");
			return (Criteria) this;
		}

		public Criteria andJobGroupIsNull() {
			addCriterion("JOB_GROUP is null");
			return (Criteria) this;
		}

		public Criteria andJobGroupIsNotNull() {
			addCriterion("JOB_GROUP is not null");
			return (Criteria) this;
		}

		public Criteria andJobGroupEqualTo(String value) {
			addCriterion("JOB_GROUP =", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotEqualTo(String value) {
			addCriterion("JOB_GROUP <>", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupGreaterThan(String value) {
			addCriterion("JOB_GROUP >", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_GROUP >=", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupLessThan(String value) {
			addCriterion("JOB_GROUP <", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupLessThanOrEqualTo(String value) {
			addCriterion("JOB_GROUP <=", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupLike(String value) {
			addCriterion("JOB_GROUP like", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotLike(String value) {
			addCriterion("JOB_GROUP not like", value, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupIn(List<String> values) {
			addCriterion("JOB_GROUP in", values, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotIn(List<String> values) {
			addCriterion("JOB_GROUP not in", values, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupBetween(String value1, String value2) {
			addCriterion("JOB_GROUP between", value1, value2, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobGroupNotBetween(String value1, String value2) {
			addCriterion("JOB_GROUP not between", value1, value2, "jobGroup");
			return (Criteria) this;
		}

		public Criteria andJobTypeIsNull() {
			addCriterion("JOB_TYPE is null");
			return (Criteria) this;
		}

		public Criteria andJobTypeIsNotNull() {
			addCriterion("JOB_TYPE is not null");
			return (Criteria) this;
		}

		public Criteria andJobTypeEqualTo(String value) {
			addCriterion("JOB_TYPE =", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeNotEqualTo(String value) {
			addCriterion("JOB_TYPE <>", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeGreaterThan(String value) {
			addCriterion("JOB_TYPE >", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_TYPE >=", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeLessThan(String value) {
			addCriterion("JOB_TYPE <", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeLessThanOrEqualTo(String value) {
			addCriterion("JOB_TYPE <=", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeLike(String value) {
			addCriterion("JOB_TYPE like", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeNotLike(String value) {
			addCriterion("JOB_TYPE not like", value, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeIn(List<String> values) {
			addCriterion("JOB_TYPE in", values, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeNotIn(List<String> values) {
			addCriterion("JOB_TYPE not in", values, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeBetween(String value1, String value2) {
			addCriterion("JOB_TYPE between", value1, value2, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobTypeNotBetween(String value1, String value2) {
			addCriterion("JOB_TYPE not between", value1, value2, "jobType");
			return (Criteria) this;
		}

		public Criteria andJobStatusIsNull() {
			addCriterion("JOB_STATUS is null");
			return (Criteria) this;
		}

		public Criteria andJobStatusIsNotNull() {
			addCriterion("JOB_STATUS is not null");
			return (Criteria) this;
		}

		public Criteria andJobStatusEqualTo(String value) {
			addCriterion("JOB_STATUS =", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusNotEqualTo(String value) {
			addCriterion("JOB_STATUS <>", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusGreaterThan(String value) {
			addCriterion("JOB_STATUS >", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusGreaterThanOrEqualTo(String value) {
			addCriterion("JOB_STATUS >=", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusLessThan(String value) {
			addCriterion("JOB_STATUS <", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusLessThanOrEqualTo(String value) {
			addCriterion("JOB_STATUS <=", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusLike(String value) {
			addCriterion("JOB_STATUS like", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusNotLike(String value) {
			addCriterion("JOB_STATUS not like", value, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusIn(List<String> values) {
			addCriterion("JOB_STATUS in", values, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusNotIn(List<String> values) {
			addCriterion("JOB_STATUS not in", values, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusBetween(String value1, String value2) {
			addCriterion("JOB_STATUS between", value1, value2, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andJobStatusNotBetween(String value1, String value2) {
			addCriterion("JOB_STATUS not between", value1, value2, "jobStatus");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNull() {
			addCriterion("START_TIME is null");
			return (Criteria) this;
		}

		public Criteria andStartTimeIsNotNull() {
			addCriterion("START_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andStartTimeEqualTo(String value) {
			addCriterion("START_TIME =", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotEqualTo(String value) {
			addCriterion("START_TIME <>", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThan(String value) {
			addCriterion("START_TIME >", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeGreaterThanOrEqualTo(String value) {
			addCriterion("START_TIME >=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThan(String value) {
			addCriterion("START_TIME <", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLessThanOrEqualTo(String value) {
			addCriterion("START_TIME <=", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeLike(String value) {
			addCriterion("START_TIME like", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotLike(String value) {
			addCriterion("START_TIME not like", value, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeIn(List<String> values) {
			addCriterion("START_TIME in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotIn(List<String> values) {
			addCriterion("START_TIME not in", values, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeBetween(String value1, String value2) {
			addCriterion("START_TIME between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andStartTimeNotBetween(String value1, String value2) {
			addCriterion("START_TIME not between", value1, value2, "startTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNull() {
			addCriterion("END_TIME is null");
			return (Criteria) this;
		}

		public Criteria andEndTimeIsNotNull() {
			addCriterion("END_TIME is not null");
			return (Criteria) this;
		}

		public Criteria andEndTimeEqualTo(String value) {
			addCriterion("END_TIME =", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotEqualTo(String value) {
			addCriterion("END_TIME <>", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThan(String value) {
			addCriterion("END_TIME >", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeGreaterThanOrEqualTo(String value) {
			addCriterion("END_TIME >=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThan(String value) {
			addCriterion("END_TIME <", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLessThanOrEqualTo(String value) {
			addCriterion("END_TIME <=", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeLike(String value) {
			addCriterion("END_TIME like", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotLike(String value) {
			addCriterion("END_TIME not like", value, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeIn(List<String> values) {
			addCriterion("END_TIME in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotIn(List<String> values) {
			addCriterion("END_TIME not in", values, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeBetween(String value1, String value2) {
			addCriterion("END_TIME between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andEndTimeNotBetween(String value1, String value2) {
			addCriterion("END_TIME not between", value1, value2, "endTime");
			return (Criteria) this;
		}

		public Criteria andRunMsgIsNull() {
			addCriterion("RUN_MSG is null");
			return (Criteria) this;
		}

		public Criteria andRunMsgIsNotNull() {
			addCriterion("RUN_MSG is not null");
			return (Criteria) this;
		}

		public Criteria andRunMsgEqualTo(String value) {
			addCriterion("RUN_MSG =", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgNotEqualTo(String value) {
			addCriterion("RUN_MSG <>", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgGreaterThan(String value) {
			addCriterion("RUN_MSG >", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgGreaterThanOrEqualTo(String value) {
			addCriterion("RUN_MSG >=", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgLessThan(String value) {
			addCriterion("RUN_MSG <", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgLessThanOrEqualTo(String value) {
			addCriterion("RUN_MSG <=", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgLike(String value) {
			addCriterion("RUN_MSG like", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgNotLike(String value) {
			addCriterion("RUN_MSG not like", value, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgIn(List<String> values) {
			addCriterion("RUN_MSG in", values, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgNotIn(List<String> values) {
			addCriterion("RUN_MSG not in", values, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgBetween(String value1, String value2) {
			addCriterion("RUN_MSG between", value1, value2, "runMsg");
			return (Criteria) this;
		}

		public Criteria andRunMsgNotBetween(String value1, String value2) {
			addCriterion("RUN_MSG not between", value1, value2, "runMsg");
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
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_JOB_LOG
	 * @mbggenerated  Thu Sep 01 17:41:19 CST 2016
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
     * This class corresponds to the database table T_DEF_JOB_LOG
     *
     * @mbggenerated do_not_delete_during_merge Thu Sep 01 14:53:34 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}