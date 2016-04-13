package qb.entity;

import java.util.ArrayList;
import java.util.List;

import qb.util.MyRowBounds;

public class TestpaperExample {
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

	public TestpaperExample() {
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

        public Criteria andTestidIsNull() {
            addCriterion("testid is null");
            return (Criteria) this;
        }

        public Criteria andTestidIsNotNull() {
            addCriterion("testid is not null");
            return (Criteria) this;
        }

        public Criteria andTestidEqualTo(String value) {
            addCriterion("testid =", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotEqualTo(String value) {
            addCriterion("testid <>", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThan(String value) {
            addCriterion("testid >", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidGreaterThanOrEqualTo(String value) {
            addCriterion("testid >=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThan(String value) {
            addCriterion("testid <", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLessThanOrEqualTo(String value) {
            addCriterion("testid <=", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidLike(String value) {
            addCriterion("testid like", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotLike(String value) {
            addCriterion("testid not like", value, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidIn(List<String> values) {
            addCriterion("testid in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotIn(List<String> values) {
            addCriterion("testid not in", values, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidBetween(String value1, String value2) {
            addCriterion("testid between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andTestidNotBetween(String value1, String value2) {
            addCriterion("testid not between", value1, value2, "testid");
            return (Criteria) this;
        }

        public Criteria andTestnameIsNull() {
            addCriterion("testname is null");
            return (Criteria) this;
        }

        public Criteria andTestnameIsNotNull() {
            addCriterion("testname is not null");
            return (Criteria) this;
        }

        public Criteria andTestnameEqualTo(String value) {
            addCriterion("testname =", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotEqualTo(String value) {
            addCriterion("testname <>", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameGreaterThan(String value) {
            addCriterion("testname >", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameGreaterThanOrEqualTo(String value) {
            addCriterion("testname >=", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLessThan(String value) {
            addCriterion("testname <", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLessThanOrEqualTo(String value) {
            addCriterion("testname <=", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameLike(String value) {
            addCriterion("testname like", "%"+value+"%", "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotLike(String value) {
            addCriterion("testname not like", value, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameIn(List<String> values) {
            addCriterion("testname in", values, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotIn(List<String> values) {
            addCriterion("testname not in", values, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameBetween(String value1, String value2) {
            addCriterion("testname between", value1, value2, "testname");
            return (Criteria) this;
        }

        public Criteria andTestnameNotBetween(String value1, String value2) {
            addCriterion("testname not between", value1, value2, "testname");
            return (Criteria) this;
        }

        public Criteria andTestdifficultIsNull() {
            addCriterion("testdifficult is null");
            return (Criteria) this;
        }

        public Criteria andTestdifficultIsNotNull() {
            addCriterion("testdifficult is not null");
            return (Criteria) this;
        }

        public Criteria andTestdifficultEqualTo(String value) {
            addCriterion("testdifficult =", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultNotEqualTo(String value) {
            addCriterion("testdifficult <>", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultGreaterThan(String value) {
            addCriterion("testdifficult >", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultGreaterThanOrEqualTo(String value) {
            addCriterion("testdifficult >=", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultLessThan(String value) {
            addCriterion("testdifficult <", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultLessThanOrEqualTo(String value) {
            addCriterion("testdifficult <=", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultLike(String value) {
            addCriterion("testdifficult like", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultNotLike(String value) {
            addCriterion("testdifficult not like", value, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultIn(List<String> values) {
            addCriterion("testdifficult in", values, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultNotIn(List<String> values) {
            addCriterion("testdifficult not in", values, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultBetween(String value1, String value2) {
            addCriterion("testdifficult between", value1, value2, "testdifficult");
            return (Criteria) this;
        }

        public Criteria andTestdifficultNotBetween(String value1, String value2) {
            addCriterion("testdifficult not between", value1, value2, "testdifficult");
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