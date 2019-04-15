package com.xiaoma.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAdvertShowTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAdvertShowTypeExample() {
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

        public Criteria andShowCodeIsNull() {
            addCriterion("show_code is null");
            return (Criteria) this;
        }

        public Criteria andShowCodeIsNotNull() {
            addCriterion("show_code is not null");
            return (Criteria) this;
        }

        public Criteria andShowCodeEqualTo(String value) {
            addCriterion("show_code =", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeNotEqualTo(String value) {
            addCriterion("show_code <>", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeGreaterThan(String value) {
            addCriterion("show_code >", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeGreaterThanOrEqualTo(String value) {
            addCriterion("show_code >=", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeLessThan(String value) {
            addCriterion("show_code <", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeLessThanOrEqualTo(String value) {
            addCriterion("show_code <=", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeLike(String value) {
            addCriterion("show_code like", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeNotLike(String value) {
            addCriterion("show_code not like", value, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeIn(List<String> values) {
            addCriterion("show_code in", values, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeNotIn(List<String> values) {
            addCriterion("show_code not in", values, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeBetween(String value1, String value2) {
            addCriterion("show_code between", value1, value2, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowCodeNotBetween(String value1, String value2) {
            addCriterion("show_code not between", value1, value2, "showCode");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNull() {
            addCriterion("show_name is null");
            return (Criteria) this;
        }

        public Criteria andShowNameIsNotNull() {
            addCriterion("show_name is not null");
            return (Criteria) this;
        }

        public Criteria andShowNameEqualTo(String value) {
            addCriterion("show_name =", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotEqualTo(String value) {
            addCriterion("show_name <>", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThan(String value) {
            addCriterion("show_name >", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameGreaterThanOrEqualTo(String value) {
            addCriterion("show_name >=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThan(String value) {
            addCriterion("show_name <", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLessThanOrEqualTo(String value) {
            addCriterion("show_name <=", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameLike(String value) {
            addCriterion("show_name like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotLike(String value) {
            addCriterion("show_name not like", value, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameIn(List<String> values) {
            addCriterion("show_name in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotIn(List<String> values) {
            addCriterion("show_name not in", values, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameBetween(String value1, String value2) {
            addCriterion("show_name between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andShowNameNotBetween(String value1, String value2) {
            addCriterion("show_name not between", value1, value2, "showName");
            return (Criteria) this;
        }

        public Criteria andShowDescIsNull() {
            addCriterion("show_desc is null");
            return (Criteria) this;
        }

        public Criteria andShowDescIsNotNull() {
            addCriterion("show_desc is not null");
            return (Criteria) this;
        }

        public Criteria andShowDescEqualTo(String value) {
            addCriterion("show_desc =", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotEqualTo(String value) {
            addCriterion("show_desc <>", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescGreaterThan(String value) {
            addCriterion("show_desc >", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescGreaterThanOrEqualTo(String value) {
            addCriterion("show_desc >=", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescLessThan(String value) {
            addCriterion("show_desc <", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescLessThanOrEqualTo(String value) {
            addCriterion("show_desc <=", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescLike(String value) {
            addCriterion("show_desc like", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotLike(String value) {
            addCriterion("show_desc not like", value, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescIn(List<String> values) {
            addCriterion("show_desc in", values, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotIn(List<String> values) {
            addCriterion("show_desc not in", values, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescBetween(String value1, String value2) {
            addCriterion("show_desc between", value1, value2, "showDesc");
            return (Criteria) this;
        }

        public Criteria andShowDescNotBetween(String value1, String value2) {
            addCriterion("show_desc not between", value1, value2, "showDesc");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andAdvertDrIsNull() {
            addCriterion("advert_dr is null");
            return (Criteria) this;
        }

        public Criteria andAdvertDrIsNotNull() {
            addCriterion("advert_dr is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertDrEqualTo(Integer value) {
            addCriterion("advert_dr =", value, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrNotEqualTo(Integer value) {
            addCriterion("advert_dr <>", value, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrGreaterThan(Integer value) {
            addCriterion("advert_dr >", value, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrGreaterThanOrEqualTo(Integer value) {
            addCriterion("advert_dr >=", value, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrLessThan(Integer value) {
            addCriterion("advert_dr <", value, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrLessThanOrEqualTo(Integer value) {
            addCriterion("advert_dr <=", value, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrIn(List<Integer> values) {
            addCriterion("advert_dr in", values, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrNotIn(List<Integer> values) {
            addCriterion("advert_dr not in", values, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrBetween(Integer value1, Integer value2) {
            addCriterion("advert_dr between", value1, value2, "advertDr");
            return (Criteria) this;
        }

        public Criteria andAdvertDrNotBetween(Integer value1, Integer value2) {
            addCriterion("advert_dr not between", value1, value2, "advertDr");
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