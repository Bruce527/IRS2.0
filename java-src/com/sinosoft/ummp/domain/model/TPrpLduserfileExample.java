package com.sinosoft.ummp.domain.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TPrpLduserfileExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public TPrpLduserfileExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
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
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
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

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNull() {
            addCriterion("FILENAME is null");
            return (Criteria) this;
        }

        public Criteria andFilenameIsNotNull() {
            addCriterion("FILENAME is not null");
            return (Criteria) this;
        }

        public Criteria andFilenameEqualTo(String value) {
            addCriterion("FILENAME =", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotEqualTo(String value) {
            addCriterion("FILENAME <>", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThan(String value) {
            addCriterion("FILENAME >", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameGreaterThanOrEqualTo(String value) {
            addCriterion("FILENAME >=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThan(String value) {
            addCriterion("FILENAME <", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLessThanOrEqualTo(String value) {
            addCriterion("FILENAME <=", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameLike(String value) {
            addCriterion("FILENAME like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotLike(String value) {
            addCriterion("FILENAME not like", value, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameIn(List<String> values) {
            addCriterion("FILENAME in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotIn(List<String> values) {
            addCriterion("FILENAME not in", values, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameBetween(String value1, String value2) {
            addCriterion("FILENAME between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFilenameNotBetween(String value1, String value2) {
            addCriterion("FILENAME not between", value1, value2, "filename");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNull() {
            addCriterion("FILETYPE is null");
            return (Criteria) this;
        }

        public Criteria andFiletypeIsNotNull() {
            addCriterion("FILETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andFiletypeEqualTo(String value) {
            addCriterion("FILETYPE =", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotEqualTo(String value) {
            addCriterion("FILETYPE <>", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThan(String value) {
            addCriterion("FILETYPE >", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeGreaterThanOrEqualTo(String value) {
            addCriterion("FILETYPE >=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThan(String value) {
            addCriterion("FILETYPE <", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLessThanOrEqualTo(String value) {
            addCriterion("FILETYPE <=", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeLike(String value) {
            addCriterion("FILETYPE like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotLike(String value) {
            addCriterion("FILETYPE not like", value, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeIn(List<String> values) {
            addCriterion("FILETYPE in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotIn(List<String> values) {
            addCriterion("FILETYPE not in", values, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeBetween(String value1, String value2) {
            addCriterion("FILETYPE between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFiletypeNotBetween(String value1, String value2) {
            addCriterion("FILETYPE not between", value1, value2, "filetype");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNull() {
            addCriterion("FILEPATH is null");
            return (Criteria) this;
        }

        public Criteria andFilepathIsNotNull() {
            addCriterion("FILEPATH is not null");
            return (Criteria) this;
        }

        public Criteria andFilepathEqualTo(String value) {
            addCriterion("FILEPATH =", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotEqualTo(String value) {
            addCriterion("FILEPATH <>", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThan(String value) {
            addCriterion("FILEPATH >", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathGreaterThanOrEqualTo(String value) {
            addCriterion("FILEPATH >=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThan(String value) {
            addCriterion("FILEPATH <", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLessThanOrEqualTo(String value) {
            addCriterion("FILEPATH <=", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathLike(String value) {
            addCriterion("FILEPATH like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotLike(String value) {
            addCriterion("FILEPATH not like", value, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathIn(List<String> values) {
            addCriterion("FILEPATH in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotIn(List<String> values) {
            addCriterion("FILEPATH not in", values, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathBetween(String value1, String value2) {
            addCriterion("FILEPATH between", value1, value2, "filepath");
            return (Criteria) this;
        }

        public Criteria andFilepathNotBetween(String value1, String value2) {
            addCriterion("FILEPATH not between", value1, value2, "filepath");
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

        public Criteria andMakedateIsNull() {
            addCriterion("MAKEDATE is null");
            return (Criteria) this;
        }

        public Criteria andMakedateIsNotNull() {
            addCriterion("MAKEDATE is not null");
            return (Criteria) this;
        }

        public Criteria andMakedateEqualTo(Date value) {
            addCriterionForJDBCDate("MAKEDATE =", value, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateNotEqualTo(Date value) {
            addCriterionForJDBCDate("MAKEDATE <>", value, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateGreaterThan(Date value) {
            addCriterionForJDBCDate("MAKEDATE >", value, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MAKEDATE >=", value, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateLessThan(Date value) {
            addCriterionForJDBCDate("MAKEDATE <", value, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MAKEDATE <=", value, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateIn(List<Date> values) {
            addCriterionForJDBCDate("MAKEDATE in", values, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateNotIn(List<Date> values) {
            addCriterionForJDBCDate("MAKEDATE not in", values, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MAKEDATE between", value1, value2, "makedate");
            return (Criteria) this;
        }

        public Criteria andMakedateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MAKEDATE not between", value1, value2, "makedate");
            return (Criteria) this;
        }

        public Criteria andMaketimeIsNull() {
            addCriterion("MAKETIME is null");
            return (Criteria) this;
        }

        public Criteria andMaketimeIsNotNull() {
            addCriterion("MAKETIME is not null");
            return (Criteria) this;
        }

        public Criteria andMaketimeEqualTo(String value) {
            addCriterion("MAKETIME =", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotEqualTo(String value) {
            addCriterion("MAKETIME <>", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeGreaterThan(String value) {
            addCriterion("MAKETIME >", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeGreaterThanOrEqualTo(String value) {
            addCriterion("MAKETIME >=", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLessThan(String value) {
            addCriterion("MAKETIME <", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLessThanOrEqualTo(String value) {
            addCriterion("MAKETIME <=", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeLike(String value) {
            addCriterion("MAKETIME like", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotLike(String value) {
            addCriterion("MAKETIME not like", value, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeIn(List<String> values) {
            addCriterion("MAKETIME in", values, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotIn(List<String> values) {
            addCriterion("MAKETIME not in", values, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeBetween(String value1, String value2) {
            addCriterion("MAKETIME between", value1, value2, "maketime");
            return (Criteria) this;
        }

        public Criteria andMaketimeNotBetween(String value1, String value2) {
            addCriterion("MAKETIME not between", value1, value2, "maketime");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNull() {
            addCriterion("MODIFYDATE is null");
            return (Criteria) this;
        }

        public Criteria andModifydateIsNotNull() {
            addCriterion("MODIFYDATE is not null");
            return (Criteria) this;
        }

        public Criteria andModifydateEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATE =", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATE <>", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThan(Date value) {
            addCriterionForJDBCDate("MODIFYDATE >", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATE >=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThan(Date value) {
            addCriterionForJDBCDate("MODIFYDATE <", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("MODIFYDATE <=", value, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFYDATE in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotIn(List<Date> values) {
            addCriterionForJDBCDate("MODIFYDATE not in", values, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFYDATE between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifydateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("MODIFYDATE not between", value1, value2, "modifydate");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("MODIFYTIME is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("MODIFYTIME is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(String value) {
            addCriterion("MODIFYTIME =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(String value) {
            addCriterion("MODIFYTIME <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(String value) {
            addCriterion("MODIFYTIME >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(String value) {
            addCriterion("MODIFYTIME >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(String value) {
            addCriterion("MODIFYTIME <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(String value) {
            addCriterion("MODIFYTIME <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLike(String value) {
            addCriterion("MODIFYTIME like", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotLike(String value) {
            addCriterion("MODIFYTIME not like", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<String> values) {
            addCriterion("MODIFYTIME in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<String> values) {
            addCriterion("MODIFYTIME not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(String value1, String value2) {
            addCriterion("MODIFYTIME between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(String value1, String value2) {
            addCriterion("MODIFYTIME not between", value1, value2, "modifytime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated do_not_delete_during_merge Mon Sep 26 15:19:33 CST 2016
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_PRP_LDUSERFILE
     *
     * @mbggenerated Mon Sep 26 15:19:33 CST 2016
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