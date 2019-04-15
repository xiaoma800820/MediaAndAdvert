package com.xiaoma.bean.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAdvertPutPlanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAdvertPutPlanExample() {
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

        public Criteria andBillingTypeIsNull() {
            addCriterion("billing_type is null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIsNotNull() {
            addCriterion("billing_type is not null");
            return (Criteria) this;
        }

        public Criteria andBillingTypeEqualTo(String value) {
            addCriterion("billing_type =", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotEqualTo(String value) {
            addCriterion("billing_type <>", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeGreaterThan(String value) {
            addCriterion("billing_type >", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeGreaterThanOrEqualTo(String value) {
            addCriterion("billing_type >=", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLessThan(String value) {
            addCriterion("billing_type <", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLessThanOrEqualTo(String value) {
            addCriterion("billing_type <=", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeLike(String value) {
            addCriterion("billing_type like", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotLike(String value) {
            addCriterion("billing_type not like", value, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeIn(List<String> values) {
            addCriterion("billing_type in", values, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotIn(List<String> values) {
            addCriterion("billing_type not in", values, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeBetween(String value1, String value2) {
            addCriterion("billing_type between", value1, value2, "billingType");
            return (Criteria) this;
        }

        public Criteria andBillingTypeNotBetween(String value1, String value2) {
            addCriterion("billing_type not between", value1, value2, "billingType");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andExpansivityIsNull() {
            addCriterion("expansivity is null");
            return (Criteria) this;
        }

        public Criteria andExpansivityIsNotNull() {
            addCriterion("expansivity is not null");
            return (Criteria) this;
        }

        public Criteria andExpansivityEqualTo(BigDecimal value) {
            addCriterion("expansivity =", value, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityNotEqualTo(BigDecimal value) {
            addCriterion("expansivity <>", value, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityGreaterThan(BigDecimal value) {
            addCriterion("expansivity >", value, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expansivity >=", value, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityLessThan(BigDecimal value) {
            addCriterion("expansivity <", value, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expansivity <=", value, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityIn(List<BigDecimal> values) {
            addCriterion("expansivity in", values, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityNotIn(List<BigDecimal> values) {
            addCriterion("expansivity not in", values, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expansivity between", value1, value2, "expansivity");
            return (Criteria) this;
        }

        public Criteria andExpansivityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expansivity not between", value1, value2, "expansivity");
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

        public Criteria andSettleExpansivityIsNull() {
            addCriterion("settle_expansivity is null");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityIsNotNull() {
            addCriterion("settle_expansivity is not null");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityEqualTo(BigDecimal value) {
            addCriterion("settle_expansivity =", value, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityNotEqualTo(BigDecimal value) {
            addCriterion("settle_expansivity <>", value, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityGreaterThan(BigDecimal value) {
            addCriterion("settle_expansivity >", value, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_expansivity >=", value, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityLessThan(BigDecimal value) {
            addCriterion("settle_expansivity <", value, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_expansivity <=", value, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityIn(List<BigDecimal> values) {
            addCriterion("settle_expansivity in", values, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityNotIn(List<BigDecimal> values) {
            addCriterion("settle_expansivity not in", values, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_expansivity between", value1, value2, "settleExpansivity");
            return (Criteria) this;
        }

        public Criteria andSettleExpansivityNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_expansivity not between", value1, value2, "settleExpansivity");
            return (Criteria) this;
        }
        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(BigDecimal value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(BigDecimal value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(BigDecimal value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(BigDecimal value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<BigDecimal> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<BigDecimal> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance not between", value1, value2, "balance");
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