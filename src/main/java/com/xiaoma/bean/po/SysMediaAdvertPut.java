package com.xiaoma.bean.po;

import java.util.Date;

public class SysMediaAdvertPut {

    private Long mediaAdvertId;

    private String advertId;

    private String advertName;

    private String advertUrl;

    private String advertShowType;

    private Integer weightFactor;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    private String mediaPlanId;

    private String keyId;

    public Long getMediaAdvertId() {
        return mediaAdvertId;
    }

    public void setMediaAdvertId(Long mediaAdvertId) {
        this.mediaAdvertId = mediaAdvertId;
    }

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId == null ? null : advertId.trim();
    }

    public Integer getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(Integer weightFactor) {
        this.weightFactor = weightFactor;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMediaPlanId() {
        return mediaPlanId;
    }

    public void setMediaPlanId(String mediaPlanId) {
        this.mediaPlanId = mediaPlanId == null ? null : mediaPlanId.trim();
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    public String getAdvertShowType() {
        return advertShowType;
    }

    public void setAdvertShowType(String advertShowType) {
        this.advertShowType = advertShowType;
    }

    public String getKeyId() {
        return keyId;
    }

    public void setKeyId(String keyId) {
        this.keyId = keyId;
    }
}