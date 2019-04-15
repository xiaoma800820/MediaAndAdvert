package com.xiaoma.bean.bo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAccountRechargeRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAccountRechargeRecordExample() {
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

        public Criteria andRechargeIdIsNull() {
            addCriterion("recharge_id is null");
            return (Criteria) this;
        }

        public Criteria andRechargeIdIsNotNull() {
            addCriterion("recharge_id is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeIdEqualTo(Long value) {
            addCriterion("recharge_id =", value, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdNotEqualTo(Long value) {
            addCriterion("recharge_id <>", value, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdGreaterThan(Long value) {
            addCriterion("recharge_id >", value, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("recharge_id >=", value, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdLessThan(Long value) {
            addCriterion("recharge_id <", value, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdLessThanOrEqualTo(Long value) {
            addCriterion("recharge_id <=", value, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdIn(List<Long> values) {
            addCriterion("recharge_id in", values, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdNotIn(List<Long> values) {
            addCriterion("recharge_id not in", values, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdBetween(Long value1, Long value2) {
            addCriterion("recharge_id between", value1, value2, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andRechargeIdNotBetween(Long value1, Long value2) {
            addCriterion("recharge_id not between", value1, value2, "rechargeId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNull() {
            addCriterion("advertiser_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIsNotNull() {
            addCriterion("advertiser_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdEqualTo(String value) {
            addCriterion("advertiser_id =", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotEqualTo(String value) {
            addCriterion("advertiser_id <>", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThan(String value) {
            addCriterion("advertiser_id >", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_id >=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThan(String value) {
            addCriterion("advertiser_id <", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdLessThanOrEqualTo(String value) {
            addCriterion("advertiser_id <=", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdIn(List<String> values) {
            addCriterion("advertiser_id in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotIn(List<String> values) {
            addCriterion("advertiser_id not in", values, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdBetween(String value1, String value2) {
            addCriterion("advertiser_id between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotBetween(String value1, String value2) {
            addCriterion("advertiser_id not between", value1, value2, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneIsNull() {
            addCriterion("advertiser_phone is null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneIsNotNull() {
            addCriterion("advertiser_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneEqualTo(String value) {
            addCriterion("advertiser_phone =", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotEqualTo(String value) {
            addCriterion("advertiser_phone <>", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneGreaterThan(String value) {
            addCriterion("advertiser_phone >", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("advertiser_phone >=", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneLessThan(String value) {
            addCriterion("advertiser_phone <", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneLessThanOrEqualTo(String value) {
            addCriterion("advertiser_phone <=", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneLike(String value) {
            addCriterion("advertiser_phone like", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotLike(String value) {
            addCriterion("advertiser_phone not like", value, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneIn(List<String> values) {
            addCriterion("advertiser_phone in", values, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotIn(List<String> values) {
            addCriterion("advertiser_phone not in", values, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneBetween(String value1, String value2) {
            addCriterion("advertiser_phone between", value1, value2, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andAdvertiserPhoneNotBetween(String value1, String value2) {
            addCriterion("advertiser_phone not between", value1, value2, "advertiserPhone");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeIsNull() {
            addCriterion("recharge_before is null");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeIsNotNull() {
            addCriterion("recharge_before is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeEqualTo(BigDecimal value) {
            addCriterion("recharge_before =", value, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeNotEqualTo(BigDecimal value) {
            addCriterion("recharge_before <>", value, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeGreaterThan(BigDecimal value) {
            addCriterion("recharge_before >", value, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_before >=", value, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeLessThan(BigDecimal value) {
            addCriterion("recharge_before <", value, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_before <=", value, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeIn(List<BigDecimal> values) {
            addCriterion("recharge_before in", values, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeNotIn(List<BigDecimal> values) {
            addCriterion("recharge_before not in", values, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_before between", value1, value2, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBeforeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_before not between", value1, value2, "rechargeBefore");
            return (Criteria) this;
        }

        public Criteria andRechargeBackIsNull() {
            addCriterion("recharge_back is null");
            return (Criteria) this;
        }

        public Criteria andRechargeBackIsNotNull() {
            addCriterion("recharge_back is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeBackEqualTo(BigDecimal value) {
            addCriterion("recharge_back =", value, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackNotEqualTo(BigDecimal value) {
            addCriterion("recharge_back <>", value, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackGreaterThan(BigDecimal value) {
            addCriterion("recharge_back >", value, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_back >=", value, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackLessThan(BigDecimal value) {
            addCriterion("recharge_back <", value, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_back <=", value, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackIn(List<BigDecimal> values) {
            addCriterion("recharge_back in", values, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackNotIn(List<BigDecimal> values) {
            addCriterion("recharge_back not in", values, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_back between", value1, value2, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeBackNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_back not between", value1, value2, "rechargeBack");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIsNull() {
            addCriterion("recharge_num is null");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIsNotNull() {
            addCriterion("recharge_num is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeNumEqualTo(BigDecimal value) {
            addCriterion("recharge_num =", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotEqualTo(BigDecimal value) {
            addCriterion("recharge_num <>", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumGreaterThan(BigDecimal value) {
            addCriterion("recharge_num >", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_num >=", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumLessThan(BigDecimal value) {
            addCriterion("recharge_num <", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("recharge_num <=", value, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumIn(List<BigDecimal> values) {
            addCriterion("recharge_num in", values, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotIn(List<BigDecimal> values) {
            addCriterion("recharge_num not in", values, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_num between", value1, value2, "rechargeNum");
            return (Criteria) this;
        }

        public Criteria andRechargeNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("recharge_num not between", value1, value2, "rechargeNum");
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

        public Criteria andTransactionSerialNumberIsNull() {
            addCriterion("transaction_serial_number is null");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberIsNotNull() {
            addCriterion("transaction_serial_number is not null");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberEqualTo(String value) {
            addCriterion("transaction_serial_number =", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotEqualTo(String value) {
            addCriterion("transaction_serial_number <>", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberGreaterThan(String value) {
            addCriterion("transaction_serial_number >", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberGreaterThanOrEqualTo(String value) {
            addCriterion("transaction_serial_number >=", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberLessThan(String value) {
            addCriterion("transaction_serial_number <", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberLessThanOrEqualTo(String value) {
            addCriterion("transaction_serial_number <=", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberLike(String value) {
            addCriterion("transaction_serial_number like", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotLike(String value) {
            addCriterion("transaction_serial_number not like", value, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberIn(List<String> values) {
            addCriterion("transaction_serial_number in", values, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotIn(List<String> values) {
            addCriterion("transaction_serial_number not in", values, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberBetween(String value1, String value2) {
            addCriterion("transaction_serial_number between", value1, value2, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andTransactionSerialNumberNotBetween(String value1, String value2) {
            addCriterion("transaction_serial_number not between", value1, value2, "transactionSerialNumber");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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