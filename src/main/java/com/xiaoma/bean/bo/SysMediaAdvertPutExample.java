package com.xiaoma.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMediaAdvertPutExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMediaAdvertPutExample() {
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

        public Criteria andMediaAdvertIdIsNull() {
            addCriterion("media_advert_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdIsNotNull() {
            addCriterion("media_advert_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdEqualTo(Long value) {
            addCriterion("media_advert_id =", value, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdNotEqualTo(Long value) {
            addCriterion("media_advert_id <>", value, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdGreaterThan(Long value) {
            addCriterion("media_advert_id >", value, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdGreaterThanOrEqualTo(Long value) {
            addCriterion("media_advert_id >=", value, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdLessThan(Long value) {
            addCriterion("media_advert_id <", value, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdLessThanOrEqualTo(Long value) {
            addCriterion("media_advert_id <=", value, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdIn(List<Long> values) {
            addCriterion("media_advert_id in", values, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdNotIn(List<Long> values) {
            addCriterion("media_advert_id not in", values, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdBetween(Long value1, Long value2) {
            addCriterion("media_advert_id between", value1, value2, "mediaAdvertId");
            return (Criteria) this;
        }

        public Criteria andMediaAdvertIdNotBetween(Long value1, Long value2) {
            addCriterion("media_advert_id not between", value1, value2, "mediaAdvertId");
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

        public Criteria andWeightFactorIsNull() {
            addCriterion("weight_factor is null");
            return (Criteria) this;
        }

        public Criteria andWeightFactorIsNotNull() {
            addCriterion("weight_factor is not null");
            return (Criteria) this;
        }

        public Criteria andWeightFactorEqualTo(Integer value) {
            addCriterion("weight_factor =", value, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorNotEqualTo(Integer value) {
            addCriterion("weight_factor <>", value, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorGreaterThan(Integer value) {
            addCriterion("weight_factor >", value, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorGreaterThanOrEqualTo(Integer value) {
            addCriterion("weight_factor >=", value, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorLessThan(Integer value) {
            addCriterion("weight_factor <", value, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorLessThanOrEqualTo(Integer value) {
            addCriterion("weight_factor <=", value, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorIn(List<Integer> values) {
            addCriterion("weight_factor in", values, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorNotIn(List<Integer> values) {
            addCriterion("weight_factor not in", values, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorBetween(Integer value1, Integer value2) {
            addCriterion("weight_factor between", value1, value2, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andWeightFactorNotBetween(Integer value1, Integer value2) {
            addCriterion("weight_factor not between", value1, value2, "weightFactor");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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

        public Criteria andMediaPlanIdIsNull() {
            addCriterion("media_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdIsNotNull() {
            addCriterion("media_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdEqualTo(String value) {
            addCriterion("media_plan_id =", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdNotEqualTo(String value) {
            addCriterion("media_plan_id <>", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdGreaterThan(String value) {
            addCriterion("media_plan_id >", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("media_plan_id >=", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdLessThan(String value) {
            addCriterion("media_plan_id <", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdLessThanOrEqualTo(String value) {
            addCriterion("media_plan_id <=", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdLike(String value) {
            addCriterion("media_plan_id like", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdNotLike(String value) {
            addCriterion("media_plan_id not like", value, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdIn(List<String> values) {
            addCriterion("media_plan_id in", values, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdNotIn(List<String> values) {
            addCriterion("media_plan_id not in", values, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdBetween(String value1, String value2) {
            addCriterion("media_plan_id between", value1, value2, "mediaPlanId");
            return (Criteria) this;
        }

        public Criteria andMediaPlanIdNotBetween(String value1, String value2) {
            addCriterion("media_plan_id not between", value1, value2, "mediaPlanId");
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