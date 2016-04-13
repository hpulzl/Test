package qb.entity;

import java.util.ArrayList;
import java.util.List;

public class WrongqusExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WrongqusExample() {
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

        public Criteria andWqidIsNull() {
            addCriterion("wqid is null");
            return (Criteria) this;
        }

        public Criteria andWqidIsNotNull() {
            addCriterion("wqid is not null");
            return (Criteria) this;
        }

        public Criteria andWqidEqualTo(String value) {
            addCriterion("wqid =", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidNotEqualTo(String value) {
            addCriterion("wqid <>", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidGreaterThan(String value) {
            addCriterion("wqid >", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidGreaterThanOrEqualTo(String value) {
            addCriterion("wqid >=", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidLessThan(String value) {
            addCriterion("wqid <", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidLessThanOrEqualTo(String value) {
            addCriterion("wqid <=", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidLike(String value) {
            addCriterion("wqid like", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidNotLike(String value) {
            addCriterion("wqid not like", value, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidIn(List<String> values) {
            addCriterion("wqid in", values, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidNotIn(List<String> values) {
            addCriterion("wqid not in", values, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidBetween(String value1, String value2) {
            addCriterion("wqid between", value1, value2, "wqid");
            return (Criteria) this;
        }

        public Criteria andWqidNotBetween(String value1, String value2) {
            addCriterion("wqid not between", value1, value2, "wqid");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andQusidIsNull() {
            addCriterion("qusid is null");
            return (Criteria) this;
        }

        public Criteria andQusidIsNotNull() {
            addCriterion("qusid is not null");
            return (Criteria) this;
        }

        public Criteria andQusidEqualTo(String value) {
            addCriterion("qusid =", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidNotEqualTo(String value) {
            addCriterion("qusid <>", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidGreaterThan(String value) {
            addCriterion("qusid >", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidGreaterThanOrEqualTo(String value) {
            addCriterion("qusid >=", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidLessThan(String value) {
            addCriterion("qusid <", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidLessThanOrEqualTo(String value) {
            addCriterion("qusid <=", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidLike(String value) {
            addCriterion("qusid like", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidNotLike(String value) {
            addCriterion("qusid not like", value, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidIn(List<String> values) {
            addCriterion("qusid in", values, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidNotIn(List<String> values) {
            addCriterion("qusid not in", values, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidBetween(String value1, String value2) {
            addCriterion("qusid between", value1, value2, "qusid");
            return (Criteria) this;
        }

        public Criteria andQusidNotBetween(String value1, String value2) {
            addCriterion("qusid not between", value1, value2, "qusid");
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