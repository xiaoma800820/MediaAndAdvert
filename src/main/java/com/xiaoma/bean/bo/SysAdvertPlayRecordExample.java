package com.xiaoma.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAdvertPlayRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAdvertPlayRecordExample() {
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

        public Criteria andPlayRecordIdIsNull() {
            addCriterion("play_record_id is null");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdIsNotNull() {
            addCriterion("play_record_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdEqualTo(Long value) {
            addCriterion("play_record_id =", value, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdNotEqualTo(Long value) {
            addCriterion("play_record_id <>", value, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdGreaterThan(Long value) {
            addCriterion("play_record_id >", value, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdGreaterThanOrEqualTo(Long value) {
            addCriterion("play_record_id >=", value, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdLessThan(Long value) {
            addCriterion("play_record_id <", value, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdLessThanOrEqualTo(Long value) {
            addCriterion("play_record_id <=", value, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdIn(List<Long> values) {
            addCriterion("play_record_id in", values, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdNotIn(List<Long> values) {
            addCriterion("play_record_id not in", values, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdBetween(Long value1, Long value2) {
            addCriterion("play_record_id between", value1, value2, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andPlayRecordIdNotBetween(Long value1, Long value2) {
            addCriterion("play_record_id not between", value1, value2, "playRecordId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNull() {
            addCriterion("advert_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNotNull() {
            addCriterion("advert_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdEqualTo(String value) {
            addCriterion("advert_id =", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotEqualTo(String value) {
            addCriterion("advert_id <>", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThan(String value) {
            addCriterion("advert_id >", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThanOrEqualTo(String value) {
            addCriterion("advert_id >=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThan(String value) {
            addCriterion("advert_id <", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThanOrEqualTo(String value) {
            addCriterion("advert_id <=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLike(String value) {
            addCriterion("advert_id like", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotLike(String value) {
            addCriterion("advert_id not like", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIn(List<String> values) {
            addCriterion("advert_id in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotIn(List<String> values) {
            addCriterion("advert_id not in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdBetween(String value1, String value2) {
            addCriterion("advert_id between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotBetween(String value1, String value2) {
            addCriterion("advert_id not between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyIsNull() {
            addCriterion("media_own_key is null");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyIsNotNull() {
            addCriterion("media_own_key is not null");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyEqualTo(String value) {
            addCriterion("media_own_key =", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyNotEqualTo(String value) {
            addCriterion("media_own_key <>", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyGreaterThan(String value) {
            addCriterion("media_own_key >", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyGreaterThanOrEqualTo(String value) {
            addCriterion("media_own_key >=", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyLessThan(String value) {
            addCriterion("media_own_key <", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyLessThanOrEqualTo(String value) {
            addCriterion("media_own_key <=", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyLike(String value) {
            addCriterion("media_own_key like", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyNotLike(String value) {
            addCriterion("media_own_key not like", value, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyIn(List<String> values) {
            addCriterion("media_own_key in", values, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyNotIn(List<String> values) {
            addCriterion("media_own_key not in", values, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyBetween(String value1, String value2) {
            addCriterion("media_own_key between", value1, value2, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andMediaOwnKeyNotBetween(String value1, String value2) {
            addCriterion("media_own_key not between", value1, value2, "mediaOwnKey");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNull() {
            addCriterion("play_type is null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIsNotNull() {
            addCriterion("play_type is not null");
            return (Criteria) this;
        }

        public Criteria andPlayTypeEqualTo(Integer value) {
            addCriterion("play_type =", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotEqualTo(Integer value) {
            addCriterion("play_type <>", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThan(Integer value) {
            addCriterion("play_type >", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("play_type >=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThan(Integer value) {
            addCriterion("play_type <", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeLessThanOrEqualTo(Integer value) {
            addCriterion("play_type <=", value, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeIn(List<Integer> values) {
            addCriterion("play_type in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotIn(List<Integer> values) {
            addCriterion("play_type not in", values, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeBetween(Integer value1, Integer value2) {
            addCriterion("play_type between", value1, value2, "playType");
            return (Criteria) this;
        }

        public Criteria andPlayTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("play_type not between", value1, value2, "playType");
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

        public Criteria andPlanIdIsNull() {
            addCriterion("plan_id is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(String value) {
            addCriterion("plan_id =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(String value) {
            addCriterion("plan_id <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(String value) {
            addCriterion("plan_id >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("plan_id >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(String value) {
            addCriterion("plan_id <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(String value) {
            addCriterion("plan_id <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLike(String value) {
            addCriterion("plan_id like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotLike(String value) {
            addCriterion("plan_id not like", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<String> values) {
            addCriterion("plan_id in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<String> values) {
            addCriterion("plan_id not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(String value1, String value2) {
            addCriterion("plan_id between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(String value1, String value2) {
            addCriterion("plan_id not between", value1, value2, "planId");
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