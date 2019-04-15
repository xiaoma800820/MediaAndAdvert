package com.xiaoma.bean.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPlanRechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysPlanRechargeExample() {
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

        public Criteria andPlanRechargeNoIsNull() {
            addCriterion("plan_recharge_no is null");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoIsNotNull() {
            addCriterion("plan_recharge_no is not null");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoEqualTo(String value) {
            addCriterion("plan_recharge_no =", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoNotEqualTo(String value) {
            addCriterion("plan_recharge_no <>", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoGreaterThan(String value) {
            addCriterion("plan_recharge_no >", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoGreaterThanOrEqualTo(String value) {
            addCriterion("plan_recharge_no >=", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoLessThan(String value) {
            addCriterion("plan_recharge_no <", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoLessThanOrEqualTo(String value) {
            addCriterion("plan_recharge_no <=", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoLike(String value) {
            addCriterion("plan_recharge_no like", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoNotLike(String value) {
            addCriterion("plan_recharge_no not like", value, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoIn(List<String> values) {
            addCriterion("plan_recharge_no in", values, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoNotIn(List<String> values) {
            addCriterion("plan_recharge_no not in", values, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoBetween(String value1, String value2) {
            addCriterion("plan_recharge_no between", value1, value2, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andPlanRechargeNoNotBetween(String value1, String value2) {
            addCriterion("plan_recharge_no not between", value1, value2, "planRechargeNo");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdIsNull() {
            addCriterion("advert_plan_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdIsNotNull() {
            addCriterion("advert_plan_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdEqualTo(String value) {
            addCriterion("advert_plan_id =", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdNotEqualTo(String value) {
            addCriterion("advert_plan_id <>", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdGreaterThan(String value) {
            addCriterion("advert_plan_id >", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdGreaterThanOrEqualTo(String value) {
            addCriterion("advert_plan_id >=", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdLessThan(String value) {
            addCriterion("advert_plan_id <", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdLessThanOrEqualTo(String value) {
            addCriterion("advert_plan_id <=", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdLike(String value) {
            addCriterion("advert_plan_id like", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdNotLike(String value) {
            addCriterion("advert_plan_id not like", value, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdIn(List<String> values) {
            addCriterion("advert_plan_id in", values, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdNotIn(List<String> values) {
            addCriterion("advert_plan_id not in", values, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdBetween(String value1, String value2) {
            addCriterion("advert_plan_id between", value1, value2, "advertPlanId");
            return (Criteria) this;
        }

        public Criteria andAdvertPlanIdNotBetween(String value1, String value2) {
            addCriterion("advert_plan_id not between", value1, value2, "advertPlanId");
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

        public Criteria andQuotaIsNull() {
            addCriterion("quota is null");
            return (Criteria) this;
        }

        public Criteria andQuotaIsNotNull() {
            addCriterion("quota is not null");
            return (Criteria) this;
        }

        public Criteria andQuotaEqualTo(BigDecimal value) {
            addCriterion("quota =", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotEqualTo(BigDecimal value) {
            addCriterion("quota <>", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThan(BigDecimal value) {
            addCriterion("quota >", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("quota >=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThan(BigDecimal value) {
            addCriterion("quota <", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("quota <=", value, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaIn(List<BigDecimal> values) {
            addCriterion("quota in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotIn(List<BigDecimal> values) {
            addCriterion("quota not in", values, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quota between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andQuotaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("quota not between", value1, value2, "quota");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
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

        public Criteria andBeforeBalanceIsNull() {
            addCriterion("before_balance is null");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceIsNotNull() {
            addCriterion("before_balance is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceEqualTo(BigDecimal value) {
            addCriterion("before_balance =", value, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceNotEqualTo(BigDecimal value) {
            addCriterion("before_balance <>", value, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceGreaterThan(BigDecimal value) {
            addCriterion("before_balance >", value, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("before_balance >=", value, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceLessThan(BigDecimal value) {
            addCriterion("before_balance <", value, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("before_balance <=", value, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceIn(List<BigDecimal> values) {
            addCriterion("before_balance in", values, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceNotIn(List<BigDecimal> values) {
            addCriterion("before_balance not in", values, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("before_balance between", value1, value2, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andBeforeBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("before_balance not between", value1, value2, "beforeBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceIsNull() {
            addCriterion("after_balance is null");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceIsNotNull() {
            addCriterion("after_balance is not null");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceEqualTo(BigDecimal value) {
            addCriterion("after_balance =", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceNotEqualTo(BigDecimal value) {
            addCriterion("after_balance <>", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceGreaterThan(BigDecimal value) {
            addCriterion("after_balance >", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("after_balance >=", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceLessThan(BigDecimal value) {
            addCriterion("after_balance <", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("after_balance <=", value, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceIn(List<BigDecimal> values) {
            addCriterion("after_balance in", values, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceNotIn(List<BigDecimal> values) {
            addCriterion("after_balance not in", values, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("after_balance between", value1, value2, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andAfterBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("after_balance not between", value1, value2, "afterBalance");
            return (Criteria) this;
        }

        public Criteria andTimesIsNull() {
            addCriterion("times is null");
            return (Criteria) this;
        }

        public Criteria andTimesIsNotNull() {
            addCriterion("times is not null");
            return (Criteria) this;
        }

        public Criteria andTimesEqualTo(Integer value) {
            addCriterion("times =", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotEqualTo(Integer value) {
            addCriterion("times <>", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThan(Integer value) {
            addCriterion("times >", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("times >=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThan(Integer value) {
            addCriterion("times <", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesLessThanOrEqualTo(Integer value) {
            addCriterion("times <=", value, "times");
            return (Criteria) this;
        }

        public Criteria andTimesIn(List<Integer> values) {
            addCriterion("times in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotIn(List<Integer> values) {
            addCriterion("times not in", values, "times");
            return (Criteria) this;
        }

        public Criteria andTimesBetween(Integer value1, Integer value2) {
            addCriterion("times between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("times not between", value1, value2, "times");
            return (Criteria) this;
        }

        public Criteria andBelongTypeIsNull() {
            addCriterion("belong_type is null");
            return (Criteria) this;
        }

        public Criteria andBelongTypeIsNotNull() {
            addCriterion("belong_type is not null");
            return (Criteria) this;
        }

        public Criteria andBelongTypeEqualTo(Integer value) {
            addCriterion("belong_type =", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotEqualTo(Integer value) {
            addCriterion("belong_type <>", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeGreaterThan(Integer value) {
            addCriterion("belong_type >", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("belong_type >=", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeLessThan(Integer value) {
            addCriterion("belong_type <", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeLessThanOrEqualTo(Integer value) {
            addCriterion("belong_type <=", value, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeIn(List<Integer> values) {
            addCriterion("belong_type in", values, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotIn(List<Integer> values) {
            addCriterion("belong_type not in", values, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeBetween(Integer value1, Integer value2) {
            addCriterion("belong_type between", value1, value2, "belongType");
            return (Criteria) this;
        }

        public Criteria andBelongTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("belong_type not between", value1, value2, "belongType");
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