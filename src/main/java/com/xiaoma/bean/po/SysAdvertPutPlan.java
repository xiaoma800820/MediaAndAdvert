package com.xiaoma.bean.po;

import java.math.BigDecimal;
import java.util.Date;

public class SysAdvertPutPlan {

    private String advertPlanId;

    private String advertId;

    private String billingType;

    private BigDecimal price;

    private BigDecimal quota;

    private BigDecimal expansivity;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    private BigDecimal settleExpansivity;

    private BigDecimal balance;

    private String advertiserId;

    private String advertiserPhone;

    private String advertName;

    private String updateYMD;

    public String getAdvertPlanId() {
        return advertPlanId;
    }

    public void setAdvertPlanId(String advertPlanId) {
        this.advertPlanId = advertPlanId == null ? null : advertPlanId.trim();
    }

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId == null ? null : advertId.trim();
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

    public BigDecimal getSettleExpansivity() {
        return settleExpansivity;
    }

    public void setSettleExpansivity(BigDecimal settleExpansivity) {
        this.settleExpansivity = settleExpansivity;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
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

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }


    public String getUpdateYMD() {
        return updateYMD;
    }

    public void setUpdateYMD(String updateYMD) {
        this.updateYMD = updateYMD;
    }

    @Override
    public String toString() {
        return "SysAdvertPutPlan{" +
                "advertPlanId='" + advertPlanId + '\'' +
                ", advertId='" + advertId + '\'' +
                ", billingType='" + billingType + '\'' +
                ", price=" + price +
                ", quota=" + quota +
                ", expansivity=" + expansivity +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", settleExpansivity=" + settleExpansivity +
                ", balance=" + balance +
                ", advertiserId='" + advertiserId + '\'' +
                ", advertiserPhone='" + advertiserPhone + '\'' +
                ", advertName='" + advertName + '\'' +
                ", updateYMD='" + updateYMD + '\'' +
                '}';
    }

}