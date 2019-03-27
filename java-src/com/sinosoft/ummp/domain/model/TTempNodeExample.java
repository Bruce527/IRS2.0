package com.sinosoft.ummp.domain.model;

import java.util.ArrayList;
import java.util.List;

public class TTempNodeExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public TTempNodeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
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
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
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

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Integer value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Integer value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Integer value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Integer value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Integer value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Integer value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Integer> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Integer> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Integer value1, Integer value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Integer value1, Integer value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNull() {
            addCriterion("NODE_ID is null");
            return (Criteria) this;
        }

        public Criteria andNodeIdIsNotNull() {
            addCriterion("NODE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andNodeIdEqualTo(String value) {
            addCriterion("NODE_ID =", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotEqualTo(String value) {
            addCriterion("NODE_ID <>", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThan(String value) {
            addCriterion("NODE_ID >", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_ID >=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThan(String value) {
            addCriterion("NODE_ID <", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLessThanOrEqualTo(String value) {
            addCriterion("NODE_ID <=", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdLike(String value) {
            addCriterion("NODE_ID like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotLike(String value) {
            addCriterion("NODE_ID not like", value, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdIn(List<String> values) {
            addCriterion("NODE_ID in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotIn(List<String> values) {
            addCriterion("NODE_ID not in", values, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdBetween(String value1, String value2) {
            addCriterion("NODE_ID between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeIdNotBetween(String value1, String value2) {
            addCriterion("NODE_ID not between", value1, value2, "nodeId");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNull() {
            addCriterion("NODE_CODE is null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIsNotNull() {
            addCriterion("NODE_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andNodeCodeEqualTo(String value) {
            addCriterion("NODE_CODE =", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotEqualTo(String value) {
            addCriterion("NODE_CODE <>", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThan(String value) {
            addCriterion("NODE_CODE >", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_CODE >=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThan(String value) {
            addCriterion("NODE_CODE <", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLessThanOrEqualTo(String value) {
            addCriterion("NODE_CODE <=", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeLike(String value) {
            addCriterion("NODE_CODE like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotLike(String value) {
            addCriterion("NODE_CODE not like", value, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeIn(List<String> values) {
            addCriterion("NODE_CODE in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotIn(List<String> values) {
            addCriterion("NODE_CODE not in", values, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeBetween(String value1, String value2) {
            addCriterion("NODE_CODE between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeCodeNotBetween(String value1, String value2) {
            addCriterion("NODE_CODE not between", value1, value2, "nodeCode");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNull() {
            addCriterion("NODE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andNodeNameIsNotNull() {
            addCriterion("NODE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNodeNameEqualTo(String value) {
            addCriterion("NODE_NAME =", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotEqualTo(String value) {
            addCriterion("NODE_NAME <>", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThan(String value) {
            addCriterion("NODE_NAME >", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameGreaterThanOrEqualTo(String value) {
            addCriterion("NODE_NAME >=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThan(String value) {
            addCriterion("NODE_NAME <", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLessThanOrEqualTo(String value) {
            addCriterion("NODE_NAME <=", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameLike(String value) {
            addCriterion("NODE_NAME like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotLike(String value) {
            addCriterion("NODE_NAME not like", value, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameIn(List<String> values) {
            addCriterion("NODE_NAME in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotIn(List<String> values) {
            addCriterion("NODE_NAME not in", values, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameBetween(String value1, String value2) {
            addCriterion("NODE_NAME between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andNodeNameNotBetween(String value1, String value2) {
            addCriterion("NODE_NAME not between", value1, value2, "nodeName");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeIsNull() {
            addCriterion("SON_NODE_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeIsNotNull() {
            addCriterion("SON_NODE_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeEqualTo(String value) {
            addCriterion("SON_NODE_TYPE =", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeNotEqualTo(String value) {
            addCriterion("SON_NODE_TYPE <>", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeGreaterThan(String value) {
            addCriterion("SON_NODE_TYPE >", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeGreaterThanOrEqualTo(String value) {
            addCriterion("SON_NODE_TYPE >=", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeLessThan(String value) {
            addCriterion("SON_NODE_TYPE <", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeLessThanOrEqualTo(String value) {
            addCriterion("SON_NODE_TYPE <=", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeLike(String value) {
            addCriterion("SON_NODE_TYPE like", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeNotLike(String value) {
            addCriterion("SON_NODE_TYPE not like", value, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeIn(List<String> values) {
            addCriterion("SON_NODE_TYPE in", values, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeNotIn(List<String> values) {
            addCriterion("SON_NODE_TYPE not in", values, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeBetween(String value1, String value2) {
            addCriterion("SON_NODE_TYPE between", value1, value2, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeTypeNotBetween(String value1, String value2) {
            addCriterion("SON_NODE_TYPE not between", value1, value2, "sonNodeType");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentIsNull() {
            addCriterion("SON_NODE_CONTENET is null");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentIsNotNull() {
            addCriterion("SON_NODE_CONTENET is not null");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentEqualTo(String value) {
            addCriterion("SON_NODE_CONTENET =", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentNotEqualTo(String value) {
            addCriterion("SON_NODE_CONTENET <>", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentGreaterThan(String value) {
            addCriterion("SON_NODE_CONTENET >", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentGreaterThanOrEqualTo(String value) {
            addCriterion("SON_NODE_CONTENET >=", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentLessThan(String value) {
            addCriterion("SON_NODE_CONTENET <", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentLessThanOrEqualTo(String value) {
            addCriterion("SON_NODE_CONTENET <=", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentLike(String value) {
            addCriterion("SON_NODE_CONTENET like", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentNotLike(String value) {
            addCriterion("SON_NODE_CONTENET not like", value, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentIn(List<String> values) {
            addCriterion("SON_NODE_CONTENET in", values, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentNotIn(List<String> values) {
            addCriterion("SON_NODE_CONTENET not in", values, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentBetween(String value1, String value2) {
            addCriterion("SON_NODE_CONTENET between", value1, value2, "sonNodeContent");
            return (Criteria) this;
        }

        public Criteria andSonNodeContentNotBetween(String value1, String value2) {
            addCriterion("SON_NODE_CONTENET not between", value1, value2, "sonNodeContent");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated do_not_delete_during_merge Tue Jun 21 11:07:32 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_TEMP_NODE
     *
     * @mbggenerated Tue Jun 21 11:07:32 CST 2016
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