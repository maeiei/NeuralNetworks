package com.maeiei.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ResultDataCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ResultDataCriteria() {
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

        public Criteria andStockIdEqualTo(double value) {
            addCriterion("STOCK_ID =", new Double(value), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotEqualTo(double value) {
            addCriterion("STOCK_ID <>", new Double(value), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThan(double value) {
            addCriterion("STOCK_ID >", new Double(value), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdGreaterThanOrEqualTo(double value) {
            addCriterion("STOCK_ID >=", new Double(value), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThan(double value) {
            addCriterion("STOCK_ID <", new Double(value), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdLessThanOrEqualTo(double value) {
            addCriterion("STOCK_ID <=", new Double(value), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdIn(List<Double> values) {
            addCriterion("STOCK_ID in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotIn(List<Double> values) {
            addCriterion("STOCK_ID not in", values, "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdBetween(double value1, double value2) {
            addCriterion("STOCK_ID between", new Double(value1), new Double(value2), "stockId");
            return (Criteria) this;
        }

        public Criteria andStockIdNotBetween(double value1, double value2) {
            addCriterion("STOCK_ID not between", new Double(value1), new Double(value2), "stockId");
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

        public Criteria andIdEqualTo(double value) {
            addCriterion("ID =", new Double(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(double value) {
            addCriterion("ID <>", new Double(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(double value) {
            addCriterion("ID >", new Double(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(double value) {
            addCriterion("ID >=", new Double(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(double value) {
            addCriterion("ID <", new Double(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(double value) {
            addCriterion("ID <=", new Double(value), "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Double> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Double> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(double value1, double value2) {
            addCriterion("ID between", new Double(value1), new Double(value2), "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(double value1, double value2) {
            addCriterion("ID not between", new Double(value1), new Double(value2), "id");
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

        public Criteria andOpenEqualTo(double value) {
            addCriterion("OPEN =", new Double(value), "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotEqualTo(double value) {
            addCriterion("OPEN <>", new Double(value), "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThan(double value) {
            addCriterion("OPEN >", new Double(value), "open");
            return (Criteria) this;
        }

        public Criteria andOpenGreaterThanOrEqualTo(double value) {
            addCriterion("OPEN >=", new Double(value), "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThan(double value) {
            addCriterion("OPEN <", new Double(value), "open");
            return (Criteria) this;
        }

        public Criteria andOpenLessThanOrEqualTo(double value) {
            addCriterion("OPEN <=", new Double(value), "open");
            return (Criteria) this;
        }

        public Criteria andOpenIn(List<Double> values) {
            addCriterion("OPEN in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotIn(List<Double> values) {
            addCriterion("OPEN not in", values, "open");
            return (Criteria) this;
        }

        public Criteria andOpenBetween(double value1, double value2) {
            addCriterion("OPEN between", new Double(value1), new Double(value2), "open");
            return (Criteria) this;
        }

        public Criteria andOpenNotBetween(double value1, double value2) {
            addCriterion("OPEN not between", new Double(value1), new Double(value2), "open");
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

        public Criteria andHighEqualTo(double value) {
            addCriterion("HIGH =", new Double(value), "high");
            return (Criteria) this;
        }

        public Criteria andHighNotEqualTo(double value) {
            addCriterion("HIGH <>", new Double(value), "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThan(double value) {
            addCriterion("HIGH >", new Double(value), "high");
            return (Criteria) this;
        }

        public Criteria andHighGreaterThanOrEqualTo(double value) {
            addCriterion("HIGH >=", new Double(value), "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThan(double value) {
            addCriterion("HIGH <", new Double(value), "high");
            return (Criteria) this;
        }

        public Criteria andHighLessThanOrEqualTo(double value) {
            addCriterion("HIGH <=", new Double(value), "high");
            return (Criteria) this;
        }

        public Criteria andHighIn(List<Double> values) {
            addCriterion("HIGH in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighNotIn(List<Double> values) {
            addCriterion("HIGH not in", values, "high");
            return (Criteria) this;
        }

        public Criteria andHighBetween(double value1, double value2) {
            addCriterion("HIGH between", new Double(value1), new Double(value2), "high");
            return (Criteria) this;
        }

        public Criteria andHighNotBetween(double value1, double value2) {
            addCriterion("HIGH not between", new Double(value1), new Double(value2), "high");
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

        public Criteria andLowEqualTo(double value) {
            addCriterion("LOW =", new Double(value), "low");
            return (Criteria) this;
        }

        public Criteria andLowNotEqualTo(double value) {
            addCriterion("LOW <>", new Double(value), "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThan(double value) {
            addCriterion("LOW >", new Double(value), "low");
            return (Criteria) this;
        }

        public Criteria andLowGreaterThanOrEqualTo(double value) {
            addCriterion("LOW >=", new Double(value), "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThan(double value) {
            addCriterion("LOW <", new Double(value), "low");
            return (Criteria) this;
        }

        public Criteria andLowLessThanOrEqualTo(double value) {
            addCriterion("LOW <=", new Double(value), "low");
            return (Criteria) this;
        }

        public Criteria andLowIn(List<Double> values) {
            addCriterion("LOW in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowNotIn(List<Double> values) {
            addCriterion("LOW not in", values, "low");
            return (Criteria) this;
        }

        public Criteria andLowBetween(double value1, double value2) {
            addCriterion("LOW between", new Double(value1), new Double(value2), "low");
            return (Criteria) this;
        }

        public Criteria andLowNotBetween(double value1, double value2) {
            addCriterion("LOW not between", new Double(value1), new Double(value2), "low");
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

        public Criteria andCloseEqualTo(double value) {
            addCriterion("CLOSE =", new Double(value), "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotEqualTo(double value) {
            addCriterion("CLOSE <>", new Double(value), "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThan(double value) {
            addCriterion("CLOSE >", new Double(value), "close");
            return (Criteria) this;
        }

        public Criteria andCloseGreaterThanOrEqualTo(double value) {
            addCriterion("CLOSE >=", new Double(value), "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThan(double value) {
            addCriterion("CLOSE <", new Double(value), "close");
            return (Criteria) this;
        }

        public Criteria andCloseLessThanOrEqualTo(double value) {
            addCriterion("CLOSE <=", new Double(value), "close");
            return (Criteria) this;
        }

        public Criteria andCloseIn(List<Double> values) {
            addCriterion("CLOSE in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotIn(List<Double> values) {
            addCriterion("CLOSE not in", values, "close");
            return (Criteria) this;
        }

        public Criteria andCloseBetween(double value1, double value2) {
            addCriterion("CLOSE between", new Double(value1), new Double(value2), "close");
            return (Criteria) this;
        }

        public Criteria andCloseNotBetween(double value1, double value2) {
            addCriterion("CLOSE not between", new Double(value1), new Double(value2), "close");
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

        public Criteria andMoneyEqualTo(double value) {
            addCriterion("MONEY =", new Double(value), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotEqualTo(double value) {
            addCriterion("MONEY <>", new Double(value), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThan(double value) {
            addCriterion("MONEY >", new Double(value), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyGreaterThanOrEqualTo(double value) {
            addCriterion("MONEY >=", new Double(value), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThan(double value) {
            addCriterion("MONEY <", new Double(value), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyLessThanOrEqualTo(double value) {
            addCriterion("MONEY <=", new Double(value), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyIn(List<Double> values) {
            addCriterion("MONEY in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotIn(List<Double> values) {
            addCriterion("MONEY not in", values, "money");
            return (Criteria) this;
        }

        public Criteria andMoneyBetween(double value1, double value2) {
            addCriterion("MONEY between", new Double(value1), new Double(value2), "money");
            return (Criteria) this;
        }

        public Criteria andMoneyNotBetween(double value1, double value2) {
            addCriterion("MONEY not between", new Double(value1), new Double(value2), "money");
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