package com.xiaoma.bean.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysMediaInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysMediaInfoExample() {
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

        public Criteria andMediaIdIsNull() {
            addCriterion("media_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaIdIsNotNull() {
            addCriterion("media_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaIdEqualTo(String value) {
            addCriterion("media_id =", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotEqualTo(String value) {
            addCriterion("media_id <>", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThan(String value) {
            addCriterion("media_id >", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdGreaterThanOrEqualTo(String value) {
            addCriterion("media_id >=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThan(String value) {
            addCriterion("media_id <", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLessThanOrEqualTo(String value) {
            addCriterion("media_id <=", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdLike(String value) {
            addCriterion("media_id like", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotLike(String value) {
            addCriterion("media_id not like", value, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdIn(List<String> values) {
            addCriterion("media_id in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotIn(List<String> values) {
            addCriterion("media_id not in", values, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdBetween(String value1, String value2) {
            addCriterion("media_id between", value1, value2, "mediaId");
            return (Criteria) this;
        }

        public Criteria andMediaIdNotBetween(String value1, String value2) {
            addCriterion("media_id not between", value1, value2, "mediaId");
            return (Criteria) this;
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

        public Criteria andMediaNameIsNull() {
            addCriterion("media_name is null");
            return (Criteria) this;
        }

        public Criteria andMediaNameIsNotNull() {
            addCriterion("media_name is not null");
            return (Criteria) this;
        }

        public Criteria andMediaNameEqualTo(String value) {
            addCriterion("media_name =", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameNotEqualTo(String value) {
            addCriterion("media_name <>", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameGreaterThan(String value) {
            addCriterion("media_name >", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameGreaterThanOrEqualTo(String value) {
            addCriterion("media_name >=", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameLessThan(String value) {
            addCriterion("media_name <", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameLessThanOrEqualTo(String value) {
            addCriterion("media_name <=", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameLike(String value) {
            addCriterion("media_name like", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameNotLike(String value) {
            addCriterion("media_name not like", value, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameIn(List<String> values) {
            addCriterion("media_name in", values, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameNotIn(List<String> values) {
            addCriterion("media_name not in", values, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameBetween(String value1, String value2) {
            addCriterion("media_name between", value1, value2, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaNameNotBetween(String value1, String value2) {
            addCriterion("media_name not between", value1, value2, "mediaName");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdIsNull() {
            addCriterion("media_type_id is null");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdIsNotNull() {
            addCriterion("media_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdEqualTo(Long value) {
            addCriterion("media_type_id =", value, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdNotEqualTo(Long value) {
            addCriterion("media_type_id <>", value, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdGreaterThan(Long value) {
            addCriterion("media_type_id >", value, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("media_type_id >=", value, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdLessThan(Long value) {
            addCriterion("media_type_id <", value, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("media_type_id <=", value, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdIn(List<Long> values) {
            addCriterion("media_type_id in", values, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdNotIn(List<Long> values) {
            addCriterion("media_type_id not in", values, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdBetween(Long value1, Long value2) {
            addCriterion("media_type_id between", value1, value2, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andMediaTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("media_type_id not between", value1, value2, "mediaTypeId");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionIsNull() {
            addCriterion("advert_position is null");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionIsNotNull() {
            addCriterion("advert_position is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionEqualTo(String value) {
            addCriterion("advert_position =", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionNotEqualTo(String value) {
            addCriterion("advert_position <>", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionGreaterThan(String value) {
            addCriterion("advert_position >", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionGreaterThanOrEqualTo(String value) {
            addCriterion("advert_position >=", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionLessThan(String value) {
            addCriterion("advert_position <", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionLessThanOrEqualTo(String value) {
            addCriterion("advert_position <=", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionLike(String value) {
            addCriterion("advert_position like", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionNotLike(String value) {
            addCriterion("advert_position not like", value, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionIn(List<String> values) {
            addCriterion("advert_position in", values, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionNotIn(List<String> values) {
            addCriterion("advert_position not in", values, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionBetween(String value1, String value2) {
            addCriterion("advert_position between", value1, value2, "advertPosition");
            return (Criteria) this;
        }

        public Criteria andAdvertPositionNotBetween(String value1, String value2) {
            addCriterion("advert_position not between", value1, value2, "advertPosition");
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









        public Criteria andMediaKeyIsNull() {
            addCriterion("media_key is null");
            return (Criteria) this;
        }

        public Criteria andMediaKeyIsNotNull() {
            addCriterion("media_key is not null");
            return (Criteria) this;
        }

        public Criteria andMediaKeyEqualTo(String value) {
            addCriterion("media_key =", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyNotEqualTo(String value) {
            addCriterion("media_key <>", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyGreaterThan(String value) {
            addCriterion("media_key >", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyGreaterThanOrEqualTo(String value) {
            addCriterion("media_key >=", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyLessThan(String value) {
            addCriterion("media_key <", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyLessThanOrEqualTo(String value) {
            addCriterion("media_key <=", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyLike(String value) {
            addCriterion("media_key like", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyNotLike(String value) {
            addCriterion("media_key not like", value, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyIn(List<String> values) {
            addCriterion("media_key in", values, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyNotIn(List<String> values) {
            addCriterion("media_key not in", values, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyBetween(String value1, String value2) {
            addCriterion("media_key between", value1, value2, "mediaKey");
            return (Criteria) this;
        }

        public Criteria andMediaKeyNotBetween(String value1, String value2) {
            addCriterion("media_key not between", value1, value2, "mediaKey");
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