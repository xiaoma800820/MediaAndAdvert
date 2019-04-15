package com.xiaoma.bean.po;

import java.math.BigDecimal;
import java.util.Date;

public class SysMediaPutPlan {

    private String mediaPlanId;

    private String mediaId;

    private String mediaName;

    private String billingType;

    private BigDecimal price;

    private BigDecimal quota;

    private BigDecimal expansivity;

    private BigDecimal settleExpansivity;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private BigDecimal balance;

    private String mediaOwnerId;

    private String mediaPhone;

    private String updateYMD;

    public String getMediaPlanId() {
        return mediaPlanId;
    }

    public void setMediaPlanId(String mediaPlanId) {
        this.mediaPlanId = mediaPlanId == null ? null : mediaPlanId.trim();
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType == null ? null : billingType.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public BigDecimal getExpansivity() {
        return expansivity;
    }

    public void setExpansivity(BigDecimal expansivity) {
        this.expansivity = expansivity;
    }

    public BigDecimal getSettleExpansivity() {
        return settleExpansivity;
    }

    public void setSettleExpansivity(BigDecimal settleExpansivity) {
        this.settleExpansivity = settleExpansivity;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getMediaOwnerId() {
        return mediaOwnerId;
    }

    public void setMediaOwnerId(String mediaOwnerId) {
        this.mediaOwnerId = mediaOwnerId;
    }

    public String getMediaPhone() {
        return mediaPhone;
    }

    public void setMediaPhone(String mediaPhone) {
        this.mediaPhone = mediaPhone;
    }

    public String getUpdateYMD() {
        return updateYMD;
    }

    public void setUpdateYMD(String updateYMD) {
        this.updateYMD = updateYMD;
    }
}