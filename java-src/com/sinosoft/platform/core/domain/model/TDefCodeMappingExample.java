package com.sinosoft.platform.core.domain.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TDefCodeMappingExample {
    /**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	protected String orderByClause;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	protected boolean distinct;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	protected List<Criteria> oredCriteria;

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public TDefCodeMappingExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public String getOrderByClause() {
		return orderByClause;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public boolean isDistinct() {
		return distinct;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public List<Criteria> getOredCriteria() {
		return oredCriteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public void or(Criteria criteria) {
		oredCriteria.add(criteria);
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public Criteria or() {
		Criteria criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public Criteria createCriteria() {
		Criteria criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	protected Criteria createCriteriaInternal() {
		Criteria criteria = new Criteria();
		return criteria;
	}

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
	 */
	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
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

		public Criteria andBasicCodeIsNull() {
			addCriterion("BASIC_CODE is null");
			return (Criteria) this;
		}

		public Criteria andBasicCodeIsNotNull() {
			addCriterion("BASIC_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andBasicCodeEqualTo(String value) {
			addCriterion("BASIC_CODE =", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNotEqualTo(String value) {
			addCriterion("BASIC_CODE <>", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeGreaterThan(String value) {
			addCriterion("BASIC_CODE >", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeGreaterThanOrEqualTo(String value) {
			addCriterion("BASIC_CODE >=", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeLessThan(String value) {
			addCriterion("BASIC_CODE <", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeLessThanOrEqualTo(String value) {
			addCriterion("BASIC_CODE <=", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeLike(String value) {
			addCriterion("BASIC_CODE like", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNotLike(String value) {
			addCriterion("BASIC_CODE not like", value, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeIn(List<String> values) {
			addCriterion("BASIC_CODE in", values, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNotIn(List<String> values) {
			addCriterion("BASIC_CODE not in", values, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeBetween(String value1, String value2) {
			addCriterion("BASIC_CODE between", value1, value2, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNotBetween(String value1, String value2) {
			addCriterion("BASIC_CODE not between", value1, value2, "basicCode");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameIsNull() {
			addCriterion("BASIC_CODE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameIsNotNull() {
			addCriterion("BASIC_CODE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameEqualTo(String value) {
			addCriterion("BASIC_CODE_NAME =", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameNotEqualTo(String value) {
			addCriterion("BASIC_CODE_NAME <>", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameGreaterThan(String value) {
			addCriterion("BASIC_CODE_NAME >", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameGreaterThanOrEqualTo(String value) {
			addCriterion("BASIC_CODE_NAME >=", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameLessThan(String value) {
			addCriterion("BASIC_CODE_NAME <", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameLessThanOrEqualTo(String value) {
			addCriterion("BASIC_CODE_NAME <=", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameLike(String value) {
			addCriterion("BASIC_CODE_NAME like", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameNotLike(String value) {
			addCriterion("BASIC_CODE_NAME not like", value, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameIn(List<String> values) {
			addCriterion("BASIC_CODE_NAME in", values, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameNotIn(List<String> values) {
			addCriterion("BASIC_CODE_NAME not in", values, "basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameBetween(String value1, String value2) {
			addCriterion("BASIC_CODE_NAME between", value1, value2,
					"basicCodeName");
			return (Criteria) this;
		}

		public Criteria andBasicCodeNameNotBetween(String value1, String value2) {
			addCriterion("BASIC_CODE_NAME not between", value1, value2,
					"basicCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeIsNull() {
			addCriterion("TARGET_CODE is null");
			return (Criteria) this;
		}

		public Criteria andTargetCodeIsNotNull() {
			addCriterion("TARGET_CODE is not null");
			return (Criteria) this;
		}

		public Criteria andTargetCodeEqualTo(String value) {
			addCriterion("TARGET_CODE =", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNotEqualTo(String value) {
			addCriterion("TARGET_CODE <>", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeGreaterThan(String value) {
			addCriterion("TARGET_CODE >", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeGreaterThanOrEqualTo(String value) {
			addCriterion("TARGET_CODE >=", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeLessThan(String value) {
			addCriterion("TARGET_CODE <", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeLessThanOrEqualTo(String value) {
			addCriterion("TARGET_CODE <=", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeLike(String value) {
			addCriterion("TARGET_CODE like", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNotLike(String value) {
			addCriterion("TARGET_CODE not like", value, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeIn(List<String> values) {
			addCriterion("TARGET_CODE in", values, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNotIn(List<String> values) {
			addCriterion("TARGET_CODE not in", values, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeBetween(String value1, String value2) {
			addCriterion("TARGET_CODE between", value1, value2, "targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNotBetween(String value1, String value2) {
			addCriterion("TARGET_CODE not between", value1, value2,
					"targetCode");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameIsNull() {
			addCriterion("TARGET_CODE_NAME is null");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameIsNotNull() {
			addCriterion("TARGET_CODE_NAME is not null");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameEqualTo(String value) {
			addCriterion("TARGET_CODE_NAME =", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameNotEqualTo(String value) {
			addCriterion("TARGET_CODE_NAME <>", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameGreaterThan(String value) {
			addCriterion("TARGET_CODE_NAME >", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameGreaterThanOrEqualTo(String value) {
			addCriterion("TARGET_CODE_NAME >=", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameLessThan(String value) {
			addCriterion("TARGET_CODE_NAME <", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameLessThanOrEqualTo(String value) {
			addCriterion("TARGET_CODE_NAME <=", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameLike(String value) {
			addCriterion("TARGET_CODE_NAME like", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameNotLike(String value) {
			addCriterion("TARGET_CODE_NAME not like", value, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameIn(List<String> values) {
			addCriterion("TARGET_CODE_NAME in", values, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameNotIn(List<String> values) {
			addCriterion("TARGET_CODE_NAME not in", values, "targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameBetween(String value1, String value2) {
			addCriterion("TARGET_CODE_NAME between", value1, value2,
					"targetCodeName");
			return (Criteria) this;
		}

		public Criteria andTargetCodeNameNotBetween(String value1, String value2) {
			addCriterion("TARGET_CODE_NAME not between", value1, value2,
					"targetCodeName");
			return (Criteria) this;
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

		public Criteria andManageIdIsNull() {
			addCriterion("MANAGE_ID is null");
			return (Criteria) this;
		}

		public Criteria andManageIdIsNotNull() {
			addCriterion("MANAGE_ID is not null");
			return (Criteria) this;
		}

		public Criteria andManageIdEqualTo(BigDecimal value) {
			addCriterion("MANAGE_ID =", value, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdNotEqualTo(BigDecimal value) {
			addCriterion("MANAGE_ID <>", value, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdGreaterThan(BigDecimal value) {
			addCriterion("MANAGE_ID >", value, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdGreaterThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_ID >=", value, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdLessThan(BigDecimal value) {
			addCriterion("MANAGE_ID <", value, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdLessThanOrEqualTo(BigDecimal value) {
			addCriterion("MANAGE_ID <=", value, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdIn(List<BigDecimal> values) {
			addCriterion("MANAGE_ID in", values, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdNotIn(List<BigDecimal> values) {
			addCriterion("MANAGE_ID not in", values, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdBetween(BigDecimal value1, BigDecimal value2) {
			addCriterion("MANAGE_ID between", value1, value2, "manageId");
			return (Criteria) this;
		}

		public Criteria andManageIdNotBetween(BigDecimal value1,
				BigDecimal value2) {
			addCriterion("MANAGE_ID not between", value1, value2, "manageId");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNull() {
			addCriterion("REMARK is null");
			return (Criteria) this;
		}

		public Criteria andRemarkIsNotNull() {
			addCriterion("REMARK is not null");
			return (Criteria) this;
		}

		public Criteria andRemarkEqualTo(String value) {
			addCriterion("REMARK =", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotEqualTo(String value) {
			addCriterion("REMARK <>", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThan(String value) {
			addCriterion("REMARK >", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkGreaterThanOrEqualTo(String value) {
			addCriterion("REMARK >=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThan(String value) {
			addCriterion("REMARK <", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLessThanOrEqualTo(String value) {
			addCriterion("REMARK <=", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkLike(String value) {
			addCriterion("REMARK like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotLike(String value) {
			addCriterion("REMARK not like", value, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkIn(List<String> values) {
			addCriterion("REMARK in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotIn(List<String> values) {
			addCriterion("REMARK not in", values, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkBetween(String value1, String value2) {
			addCriterion("REMARK between", value1, value2, "remark");
			return (Criteria) this;
		}

		public Criteria andRemarkNotBetween(String value1, String value2) {
			addCriterion("REMARK not between", value1, value2, "remark");
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
	}

	/**
	 * This class was generated by MyBatis Generator. This class corresponds to the database table T_DEF_CODE_MAPPING
	 * @mbggenerated  Wed Aug 31 15:26:12 CST 2016
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
     * This class corresponds to the database table T_DEF_CODE_MAPPING
     *
     * @mbggenerated do_not_delete_during_merge Wed May 25 13:19:59 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}