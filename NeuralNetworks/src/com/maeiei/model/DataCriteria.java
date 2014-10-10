package com.maeiei.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DataCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andStockIdIsNull() {
            addCriterion("STOCK_ID is null");
            return (Criteria) this;
        }

        public Criteria andStockIdIsNotNull() {
            addCriterion("STOCK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andStockIdEqualTo(Long value) {
            addCriterion("STOCK_ID =", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(Long value) {
            addCriterion("STOCK_ID <>", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(Long value) {
            addCriterion("STOCK_ID >", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(Long value) {
            addCriterion("STOCK_ID >=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(Long value) {
            addCriterion("STOCK_ID <", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(Long value) {
            addCriterion("STOCK_ID <=", value, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<Long> values) {
            addCriterion("STOCK_ID in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<Long> values) {
            addCriterion("STOCK_ID not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(Long value1, Long value2) {
            addCriterion("STOCK_ID between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(Long value1, Long value2) {
            addCriterion("STOCK_ID not between", value1, value2, "stockId");
            return (Criteria) this;
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andOpenIsNull() {
            addCriterion("OPEN is null");
            return (Criteria) this;
        }

        public Criteria andOpenIsNotNull() {
            addCriterion("OPEN is not null");
            return (Criteria) this;
        }

        public Criteria andOpenEqualTo(BigDecimal value) {
            addCriterion("OPEN =", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(BigDecimal value) {
            addCriterion("OPEN <>", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(BigDecimal value) {
            addCriterion("OPEN >", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OPEN >=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(BigDecimal value) {
            addCriterion("OPEN <", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OPEN <=", value, "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<BigDecimal> values) {
            addCriterion("OPEN in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<BigDecimal> values) {
            addCriterion("OPEN not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPEN between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OPEN not between", value1, value2, "open");
            return (Criteria) this;
        }

        public Criteria andHighIsNull() {
            addCriterion("HIGH is null");
            return (Criteria) this;
        }

        public Criteria andHighIsNotNull() {
            addCriterion("HIGH is not null");
            return (Criteria) this;
        }

        public Criteria andHighEqualTo(BigDecimal value) {
            addCriterion("HIGH =", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(BigDecimal value) {
            addCriterion("HIGH <>", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(BigDecimal value) {
            addCriterion("HIGH >", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("HIGH >=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(BigDecimal value) {
            addCriterion("HIGH <", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(BigDecimal value) {
            addCriterion("HIGH <=", value, "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<BigDecimal> values) {
            addCriterion("HIGH in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<BigDecimal> values) {
            addCriterion("HIGH not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HIGH between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("HIGH not between", value1, value2, "high");
            return (Criteria) this;
        }

        public Criteria andLowIsNull() {
            addCriterion("LOW is null");
            return (Criteria) this;
        }

        public Criteria andLowIsNotNull() {
            addCriterion("LOW is not null");
            return (Criteria) this;
        }

        public Criteria andLowEqualTo(BigDecimal value) {
            addCriterion("LOW =", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotEqualTo(BigDecimal value) {
            addCriterion("LOW <>", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThan(BigDecimal value) {
            addCriterion("LOW >", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW >=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThan(BigDecimal value) {
            addCriterion("LOW <", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LOW <=", value, "low");
            return (Criteria) this;
        }

        public Criteria andLowIn(List<BigDecimal> values) {
            addCriterion("LOW in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotIn(List<BigDecimal> values) {
            addCriterion("LOW not in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LOW not between", value1, value2, "low");
            return (Criteria) this;
        }

        public Criteria andCloseIsNull() {
            addCriterion("CLOSE is null");
            return (Criteria) this;
        }

        public Criteria andCloseIsNotNull() {
            addCriterion("CLOSE is not null");
            return (Criteria) this;
        }

        public Criteria andCloseEqualTo(BigDecimal value) {
            addCriterion("CLOSE =", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotEqualTo(BigDecimal value) {
            addCriterion("CLOSE <>", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThan(BigDecimal value) {
            addCriterion("CLOSE >", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CLOSE >=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThan(BigDecimal value) {
            addCriterion("CLOSE <", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CLOSE <=", value, "close");
            return (Criteria) this;
        }

        public Criteria andCloseIn(List<BigDecimal> values) {
            addCriterion("CLOSE in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotIn(List<BigDecimal> values) {
            addCriterion("CLOSE not in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLOSE between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CLOSE not between", value1, value2, "close");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNull() {
            addCriterion("MONEY is null");
            return (Criteria) this;
        }

        public Criteria andMoneyIsNotNull() {
            addCriterion("MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyEqualTo(BigDecimal value) {
            addCriterion("MONEY =", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(BigDecimal value) {
            addCriterion("MONEY <>", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(BigDecimal value) {
            addCriterion("MONEY >", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY >=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(BigDecimal value) {
            addCriterion("MONEY <", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("MONEY <=", value, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<BigDecimal> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<BigDecimal> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("MONEY not between", value1, value2, "money");
            return (Criteria) this;
        }

        public Criteria andStockDateIsNull() {
            addCriterion("STOCK_DATE is null");
            return (Criteria) this;
        }

        public Criteria andStockDateIsNotNull() {
            addCriterion("STOCK_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andStockDateEqualTo(Date value) {
            addCriterionForJDBCDate("STOCK_DATE =", value, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("STOCK_DATE <>", value, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateGreaterThan(Date value) {
            addCriterionForJDBCDate("STOCK_DATE >", value, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STOCK_DATE >=", value, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateLessThan(Date value) {
            addCriterionForJDBCDate("STOCK_DATE <", value, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("STOCK_DATE <=", value, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateIn(List<Date> values) {
            addCriterionForJDBCDate("STOCK_DATE in", values, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("STOCK_DATE not in", values, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STOCK_DATE between", value1, value2, "stockDate");
            return (Criteria) this;
        }

        public Criteria andStockDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("STOCK_DATE not between", value1, value2, "stockDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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