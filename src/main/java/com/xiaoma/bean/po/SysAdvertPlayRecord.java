package com.xiaoma.bean.po;

import java.util.Date;

public class SysAdvertPlayRecord {
    private Long playRecordId;

    private String advertId;

    private String mediaOwnKey;

    private Integer num;

    private Integer playType;

    private Date createTime;

    private String planId;

    public Long getPlayRecordId() {
        return playRecordId;
    }

    public void setPlayRecordId(Long playRecordId) {
        this.playRecordId = playRecordId;
    }

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId == null ? null : advertId.trim();
    }

    public String getMediaOwnKey() {
        return mediaOwnKey;
    }

    public void setMediaOwnKey(String mediaOwnKey) {
        this.mediaOwnKey = mediaOwnKey == null ? null : mediaOwnKey.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getPlayType() {
        return playType;
    }

    public void setPlayType(Integer playType) {
        this.playType = playType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }
}