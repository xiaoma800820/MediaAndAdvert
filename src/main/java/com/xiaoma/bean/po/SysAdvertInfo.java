package com.xiaoma.bean.po;

import java.util.Date;

public class SysAdvertInfo {

    private String advertId;

    private String advertiserId;

    private String advertiserPhone;

    private String advertName;

    private String advertUrl;

    private String advertShowType;

    private Integer advertStatus;

    private Date createTime;

    private Date updateTime;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId == null ? null : advertId.trim();
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName == null ? null : advertName.trim();
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl == null ? null : advertUrl.trim();
    }

    public String getAdvertShowType() {
        return advertShowType;
    }

    public void setAdvertShowType(String advertShowType) {
        this.advertShowType = advertShowType == null ? null : advertShowType.trim();
    }

    public Integer getAdvertStatus() {
        return advertStatus;
    }

    public void setAdvertStatus(Integer advertStatus) {
        this.advertStatus = advertStatus;
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

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertiserPhone() {
        return advertiserPhone;
    }

    public void setAdvertiserPhone(String advertiserPhone) {
        this.advertiserPhone = advertiserPhone;
    }
}