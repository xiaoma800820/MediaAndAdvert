package com.xiaoma.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysAdvertInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysAdvertInfoExample() {
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

        public Criteria andAdvertiserIdLike(String value) {
            addCriterion("advertiser_id like", value, "advertiserId");
            return (Criteria) this;
        }

        public Criteria andAdvertiserIdNotLike(String value) {
            addCriterion("advertiser_id not like", value, "advertiserId");
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

        public Criteria andAdvertUrlIsNull() {
            addCriterion("advert_url is null");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIsNotNull() {
            addCriterion("advert_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlEqualTo(String value) {
            addCriterion("advert_url =", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotEqualTo(String value) {
            addCriterion("advert_url <>", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlGreaterThan(String value) {
            addCriterion("advert_url >", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlGreaterThanOrEqualTo(String value) {
            addCriterion("advert_url >=", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLessThan(String value) {
            addCriterion("advert_url <", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLessThanOrEqualTo(String value) {
            addCriterion("advert_url <=", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLike(String value) {
            addCriterion("advert_url like", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotLike(String value) {
            addCriterion("advert_url not like", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIn(List<String> values) {
            addCriterion("advert_url in", values, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotIn(List<String> values) {
            addCriterion("advert_url not in", values, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlBetween(String value1, String value2) {
            addCriterion("advert_url between", value1, value2, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotBetween(String value1, String value2) {
            addCriterion("advert_url not between", value1, value2, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeIsNull() {
            addCriterion("advert_show_type is null");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeIsNotNull() {
            addCriterion("advert_show_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeEqualTo(String value) {
            addCriterion("advert_show_type =", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeNotEqualTo(String value) {
            addCriterion("advert_show_type <>", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeGreaterThan(String value) {
            addCriterion("advert_show_type >", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeGreaterThanOrEqualTo(String value) {
            addCriterion("advert_show_type >=", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeLessThan(String value) {
            addCriterion("advert_show_type <", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeLessThanOrEqualTo(String value) {
            addCriterion("advert_show_type <=", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeLike(String value) {
            addCriterion("advert_show_type like", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeNotLike(String value) {
            addCriterion("advert_show_type not like", value, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeIn(List<String> values) {
            addCriterion("advert_show_type in", values, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeNotIn(List<String> values) {
            addCriterion("advert_show_type not in", values, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeBetween(String value1, String value2) {
            addCriterion("advert_show_type between", value1, value2, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertShowTypeNotBetween(String value1, String value2) {
            addCriterion("advert_show_type not between", value1, value2, "advertShowType");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusIsNull() {
            addCriterion("advert_status is null");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusIsNotNull() {
            addCriterion("advert_status is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusEqualTo(Integer value) {
            addCriterion("advert_status =", value, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusNotEqualTo(Integer value) {
            addCriterion("advert_status <>", value, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusGreaterThan(Integer value) {
            addCriterion("advert_status >", value, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("advert_status >=", value, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusLessThan(Integer value) {
            addCriterion("advert_status <", value, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusLessThanOrEqualTo(Integer value) {
            addCriterion("advert_status <=", value, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusIn(List<Integer> values) {
            addCriterion("advert_status in", values, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusNotIn(List<Integer> values) {
            addCriterion("advert_status not in", values, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusBetween(Integer value1, Integer value2) {
            addCriterion("advert_status between", value1, value2, "advertStatus");
            return (Criteria) this;
        }

        public Criteria andAdvertStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("advert_status not between", value1, value2, "advertStatus");
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