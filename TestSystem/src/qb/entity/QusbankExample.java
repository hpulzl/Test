package qb.entity;

import java.util.ArrayList;
import java.util.List;

import qb.util.MyRowBounds;

public class QusbankExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;
    protected MyRowBounds rowBounds;

    public MyRowBounds getRowBounds() {
		return rowBounds;
	}

	public void setRowBounds(MyRowBounds rowBounds) {
		this.rowBounds = rowBounds;
	}

	public void setOredCriteria(List<Criteria> oredCriteria) {
		this.oredCriteria = oredCriteria;
	}

	public QusbankExample() {
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

        public Criteria andQustypeIsNull() {
            addCriterion("qustype is null");
            return (Criteria) this;
        }

        public Criteria andQustypeIsNotNull() {
            addCriterion("qustype is not null");
            return (Criteria) this;
        }

        public Criteria andQustypeEqualTo(String value) {
            addCriterion("qustype =", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeNotEqualTo(String value) {
            addCriterion("qustype <>", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeGreaterThan(String value) {
            addCriterion("qustype >", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeGreaterThanOrEqualTo(String value) {
            addCriterion("qustype >=", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeLessThan(String value) {
            addCriterion("qustype <", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeLessThanOrEqualTo(String value) {
            addCriterion("qustype <=", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeLike(String value) {
            addCriterion("qustype like", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeNotLike(String value) {
            addCriterion("qustype not like", value, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeIn(List<String> values) {
            addCriterion("qustype in", values, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeNotIn(List<String> values) {
            addCriterion("qustype not in", values, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeBetween(String value1, String value2) {
            addCriterion("qustype between", value1, value2, "qustype");
            return (Criteria) this;
        }

        public Criteria andQustypeNotBetween(String value1, String value2) {
            addCriterion("qustype not between", value1, value2, "qustype");
            return (Criteria) this;
        }

        public Criteria andQusanswerIsNull() {
            addCriterion("qusanswer is null");
            return (Criteria) this;
        }

        public Criteria andQusanswerIsNotNull() {
            addCriterion("qusanswer is not null");
            return (Criteria) this;
        }

        public Criteria andQusanswerEqualTo(String value) {
            addCriterion("qusanswer =", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerNotEqualTo(String value) {
            addCriterion("qusanswer <>", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerGreaterThan(String value) {
            addCriterion("qusanswer >", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerGreaterThanOrEqualTo(String value) {
            addCriterion("qusanswer >=", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerLessThan(String value) {
            addCriterion("qusanswer <", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerLessThanOrEqualTo(String value) {
            addCriterion("qusanswer <=", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerLike(String value) {
            addCriterion("qusanswer like", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerNotLike(String value) {
            addCriterion("qusanswer not like", value, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerIn(List<String> values) {
            addCriterion("qusanswer in", values, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerNotIn(List<String> values) {
            addCriterion("qusanswer not in", values, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerBetween(String value1, String value2) {
            addCriterion("qusanswer between", value1, value2, "qusanswer");
            return (Criteria) this;
        }

        public Criteria andQusanswerNotBetween(String value1, String value2) {
            addCriterion("qusanswer not between", value1, value2, "qusanswer");
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