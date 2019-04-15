package com.xiaoma.bean.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAccountSettleRecordExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAccountSettleRecordExample() {
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

        public Criteria andAccountSettleIdIsNull() {
            addCriterion("account_settle_id is null");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdIsNotNull() {
            addCriterion("account_settle_id is not null");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdEqualTo(Long value) {
            addCriterion("account_settle_id =", value, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdNotEqualTo(Long value) {
            addCriterion("account_settle_id <>", value, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdGreaterThan(Long value) {
            addCriterion("account_settle_id >", value, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdGreaterThanOrEqualTo(Long value) {
            addCriterion("account_settle_id >=", value, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdLessThan(Long value) {
            addCriterion("account_settle_id <", value, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdLessThanOrEqualTo(Long value) {
            addCriterion("account_settle_id <=", value, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdIn(List<Long> values) {
            addCriterion("account_settle_id in", values, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdNotIn(List<Long> values) {
            addCriterion("account_settle_id not in", values, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdBetween(Long value1, Long value2) {
            addCriterion("account_settle_id between", value1, value2, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andAccountSettleIdNotBetween(Long value1, Long value2) {
            addCriterion("account_settle_id not between", value1, value2, "accountSettleId");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNull() {
            addCriterion("bill_no is null");
            return (Criteria) this;
        }

        public Criteria andBillNoIsNotNull() {
            addCriterion("bill_no is not null");
            return (Criteria) this;
        }

        public Criteria andBillNoEqualTo(String value) {
            addCriterion("bill_no =", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotEqualTo(String value) {
            addCriterion("bill_no <>", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThan(String value) {
            addCriterion("bill_no >", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoGreaterThanOrEqualTo(String value) {
            addCriterion("bill_no >=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThan(String value) {
            addCriterion("bill_no <", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLessThanOrEqualTo(String value) {
            addCriterion("bill_no <=", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoLike(String value) {
            addCriterion("bill_no like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotLike(String value) {
            addCriterion("bill_no not like", value, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoIn(List<String> values) {
            addCriterion("bill_no in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotIn(List<String> values) {
            addCriterion("bill_no not in", values, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoBetween(String value1, String value2) {
            addCriterion("bill_no between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andBillNoNotBetween(String value1, String value2) {
            addCriterion("bill_no not between", value1, value2, "billNo");
            return (Criteria) this;
        }

        public Criteria andAdvertNameIsNull() {
            addCriterion("advert_name is null");
            return (Criteria) this;
        }

        public Criteria andAdvertNameIsNotNull() {
            addCriterion("advert_name is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertNameEqualTo(String value) {
            addCriterion("advert_name =", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotEqualTo(String value) {
            addCriterion("advert_name <>", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameGreaterThan(String value) {
            addCriterion("advert_name >", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameGreaterThanOrEqualTo(String value) {
            addCriterion("advert_name >=", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameLessThan(String value) {
            addCriterion("advert_name <", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameLessThanOrEqualTo(String value) {
            addCriterion("advert_name <=", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameLike(String value) {
            addCriterion("advert_name like", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotLike(String value) {
            addCriterion("advert_name not like", value, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameIn(List<String> values) {
            addCriterion("advert_name in", values, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotIn(List<String> values) {
            addCriterion("advert_name not in", values, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameBetween(String value1, String value2) {
            addCriterion("advert_name between", value1, value2, "advertName");
            return (Criteria) this;
        }

        public Criteria andAdvertNameNotBetween(String value1, String value2) {
            addCriterion("advert_name not between", value1, value2, "advertName");
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


        public Criteria andConsumptionNumIsNull() {
            addCriterion("consumption_num is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumIsNotNull() {
            addCriterion("consumption_num is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumEqualTo(Long value) {
            addCriterion("consumption_num =", value, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumNotEqualTo(Long value) {
            addCriterion("consumption_num <>", value, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumGreaterThan(Long value) {
            addCriterion("consumption_num >", value, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumGreaterThanOrEqualTo(Long value) {
            addCriterion("consumption_num >=", value, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumLessThan(Long value) {
            addCriterion("consumption_num <", value, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumLessThanOrEqualTo(Long value) {
            addCriterion("consumption_num <=", value, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumIn(List<Long> values) {
            addCriterion("consumption_num in", values, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumNotIn(List<Long> values) {
            addCriterion("consumption_num not in", values, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumBetween(Long value1, Long value2) {
            addCriterion("consumption_num between", value1, value2, "consumptionNum");
            return (Criteria) this;
        }

        public Criteria andConsumptionNumNotBetween(Long value1, Long value2) {
            addCriterion("consumption_num not between", value1, value2, "consumptionNum");
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

        public Criteria andExpansivityConsumptionIsNull() {
            addCriterion("expansivity_consumption is null");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionIsNotNull() {
            addCriterion("expansivity_consumption is not null");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionEqualTo(BigDecimal value) {
            addCriterion("expansivity_consumption =", value, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionNotEqualTo(BigDecimal value) {
            addCriterion("expansivity_consumption <>", value, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionGreaterThan(BigDecimal value) {
            addCriterion("expansivity_consumption >", value, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("expansivity_consumption >=", value, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionLessThan(BigDecimal value) {
            addCriterion("expansivity_consumption <", value, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionLessThanOrEqualTo(BigDecimal value) {
            addCriterion("expansivity_consumption <=", value, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionIn(List<BigDecimal> values) {
            addCriterion("expansivity_consumption in", values, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionNotIn(List<BigDecimal> values) {
            addCriterion("expansivity_consumption not in", values, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expansivity_consumption between", value1, value2, "expansivityConsumption");
            return (Criteria) this;
        }

        public Criteria andExpansivityConsumptionNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("expansivity_consumption not between", value1, value2, "expansivityConsumption");
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

        public Criteria andSettleAmountIsNull() {
            addCriterion("settle_amount is null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIsNotNull() {
            addCriterion("settle_amount is not null");
            return (Criteria) this;
        }

        public Criteria andSettleAmountEqualTo(BigDecimal value) {
            addCriterion("settle_amount =", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotEqualTo(BigDecimal value) {
            addCriterion("settle_amount <>", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThan(BigDecimal value) {
            addCriterion("settle_amount >", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amount >=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThan(BigDecimal value) {
            addCriterion("settle_amount <", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("settle_amount <=", value, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountIn(List<BigDecimal> values) {
            addCriterion("settle_amount in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotIn(List<BigDecimal> values) {
            addCriterion("settle_amount not in", values, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amount between", value1, value2, "settleAmount");
            return (Criteria) this;
        }

        public Criteria andSettleAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("settle_amount not between", value1, value2, "settleAmount");
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

        public Criteria andCreateYmdIsNull() {
            addCriterion("create_ymd is null");
            return (Criteria) this;
        }

        public Criteria andCreateYmdIsNotNull() {
            addCriterion("create_ymd is not null");
            return (Criteria) this;
        }

        public Criteria andCreateYmdEqualTo(String value) {
            addCriterion("create_ymd =", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdNotEqualTo(String value) {
            addCriterion("create_ymd <>", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdGreaterThan(String value) {
            addCriterion("create_ymd >", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdGreaterThanOrEqualTo(String value) {
            addCriterion("create_ymd >=", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdLessThan(String value) {
            addCriterion("create_ymd <", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdLessThanOrEqualTo(String value) {
            addCriterion("create_ymd <=", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdLike(String value) {
            addCriterion("create_ymd like", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdNotLike(String value) {
            addCriterion("create_ymd not like", value, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdIn(List<String> values) {
            addCriterion("create_ymd in", values, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdNotIn(List<String> values) {
            addCriterion("create_ymd not in", values, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdBetween(String value1, String value2) {
            addCriterion("create_ymd between", value1, value2, "createYmd");
            return (Criteria) this;
        }

        public Criteria andCreateYmdNotBetween(String value1, String value2) {
            addCriterion("create_ymd not between", value1, value2, "createYmd");
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






        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }





        public Criteria andUserNameIsNull() {
            addCriterion("user_name is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("user_name =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("user_name <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("user_name >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("user_name >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("user_name <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("user_name <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("user_name like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("user_name not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("user_name in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("user_name not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("user_name between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("user_name not between", value1, value2, "userName");
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