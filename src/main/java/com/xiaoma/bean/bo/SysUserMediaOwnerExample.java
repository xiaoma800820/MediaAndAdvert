package com.xiaoma.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserMediaOwnerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserMediaOwnerExample() {
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

        public Criteria andMediaOwnerIdIsNull() {
            addCriterion("media_owner_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdIsNotNull() {
            addCriterion("media_owner_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdEqualTo(String value) {
            addCriterion("media_owner_id =", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdNotEqualTo(String value) {
            addCriterion("media_owner_id <>", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdGreaterThan(String value) {
            addCriterion("media_owner_id >", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdGreaterThanOrEqualTo(String value) {
            addCriterion("media_owner_id >=", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdLessThan(String value) {
            addCriterion("media_owner_id <", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdLessThanOrEqualTo(String value) {
            addCriterion("media_owner_id <=", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdLike(String value) {
            addCriterion("media_owner_id like", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdNotLike(String value) {
            addCriterion("media_owner_id not like", value, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdIn(List<String> values) {
            addCriterion("media_owner_id in", values, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdNotIn(List<String> values) {
            addCriterion("media_owner_id not in", values, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdBetween(String value1, String value2) {
            addCriterion("media_owner_id between", value1, value2, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andMediaOwnerIdNotBetween(String value1, String value2) {
            addCriterion("media_owner_id not between", value1, value2, "mediaOwnerId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIsNull() {
            addCriterion("payee_id is null");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIsNotNull() {
            addCriterion("payee_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayeeIdEqualTo(Long value) {
            addCriterion("payee_id =", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotEqualTo(Long value) {
            addCriterion("payee_id <>", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdGreaterThan(Long value) {
            addCriterion("payee_id >", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payee_id >=", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLessThan(Long value) {
            addCriterion("payee_id <", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdLessThanOrEqualTo(Long value) {
            addCriterion("payee_id <=", value, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdIn(List<Long> values) {
            addCriterion("payee_id in", values, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotIn(List<Long> values) {
            addCriterion("payee_id not in", values, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdBetween(Long value1, Long value2) {
            addCriterion("payee_id between", value1, value2, "payeeId");
            return (Criteria) this;
        }

        public Criteria andPayeeIdNotBetween(Long value1, Long value2) {
            addCriterion("payee_id not between", value1, value2, "payeeId");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneIsNull() {
            addCriterion("media_phone is null");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneIsNotNull() {
            addCriterion("media_phone is not null");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneEqualTo(String value) {
            addCriterion("media_phone =", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneNotEqualTo(String value) {
            addCriterion("media_phone <>", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneGreaterThan(String value) {
            addCriterion("media_phone >", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("media_phone >=", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneLessThan(String value) {
            addCriterion("media_phone <", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneLessThanOrEqualTo(String value) {
            addCriterion("media_phone <=", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneLike(String value) {
            addCriterion("media_phone like", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneNotLike(String value) {
            addCriterion("media_phone not like", value, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneIn(List<String> values) {
            addCriterion("media_phone in", values, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneNotIn(List<String> values) {
            addCriterion("media_phone not in", values, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneBetween(String value1, String value2) {
            addCriterion("media_phone between", value1, value2, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andMediaPhoneNotBetween(String value1, String value2) {
            addCriterion("media_phone not between", value1, value2, "mediaPhone");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNull() {
            addCriterion("contacts_name is null");
            return (Criteria) this;
        }

        public Criteria andContactsNameIsNotNull() {
            addCriterion("contacts_name is not null");
            return (Criteria) this;
        }

        public Criteria andContactsNameEqualTo(String value) {
            addCriterion("contacts_name =", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotEqualTo(String value) {
            addCriterion("contacts_name <>", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThan(String value) {
            addCriterion("contacts_name >", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameGreaterThanOrEqualTo(String value) {
            addCriterion("contacts_name >=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThan(String value) {
            addCriterion("contacts_name <", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLessThanOrEqualTo(String value) {
            addCriterion("contacts_name <=", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameLike(String value) {
            addCriterion("contacts_name like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotLike(String value) {
            addCriterion("contacts_name not like", value, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameIn(List<String> values) {
            addCriterion("contacts_name in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotIn(List<String> values) {
            addCriterion("contacts_name not in", values, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameBetween(String value1, String value2) {
            addCriterion("contacts_name between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andContactsNameNotBetween(String value1, String value2) {
            addCriterion("contacts_name not between", value1, value2, "contactsName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIsNull() {
            addCriterion("current_balance is null");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIsNotNull() {
            addCriterion("current_balance is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceEqualTo(Long value) {
            addCriterion("current_balance =", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotEqualTo(Long value) {
            addCriterion("current_balance <>", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceGreaterThan(Long value) {
            addCriterion("current_balance >", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceGreaterThanOrEqualTo(Long value) {
            addCriterion("current_balance >=", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceLessThan(Long value) {
            addCriterion("current_balance <", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceLessThanOrEqualTo(Long value) {
            addCriterion("current_balance <=", value, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceIn(List<Long> values) {
            addCriterion("current_balance in", values, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotIn(List<Long> values) {
            addCriterion("current_balance not in", values, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceBetween(Long value1, Long value2) {
            addCriterion("current_balance between", value1, value2, "currentBalance");
            return (Criteria) this;
        }

        public Criteria andCurrentBalanceNotBetween(Long value1, Long value2) {
            addCriterion("current_balance not between", value1, value2, "currentBalance");
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