package com.xiaoma.bean.po;

import java.math.BigDecimal;
import java.util.Date;

public class SysAccountSettleRecord {

    private Long accountSettleId;

    private String billNo;

    private String advertName;

    private String billingType;

    private BigDecimal consumptionNum;

    private BigDecimal expansivity;

    private BigDecimal expansivityConsumption;

    private BigDecimal price;

    private BigDecimal settleAmount;

    private String settleType;

    private Date createTime;

    private String createYmd;

    private Date updateTime;

    private Integer status;

    private String userId;

    private String userName;

    public Long getAccountSettleId() {
        return accountSettleId;
    }

    public void setAccountSettleId(Long accountSettleId) {
        this.accountSettleId = accountSettleId;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName == null ? null : advertName.trim();
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType == null ? null : billingType.trim();
    }

    public BigDecimal getConsumptionNum() {
        return consumptionNum;
    }

    public void setConsumptionNum(BigDecimal consumptionNum) {
        this.consumptionNum = consumptionNum;
    }

    public BigDecimal getExpansivity() {
        return expansivity;
    }

    public void setExpansivity(BigDecimal expansivity) {
        this.expansivity = expansivity;
    }

    public BigDecimal getExpansivityConsumption() {
        return expansivityConsumption;
    }

    public void setExpansivityConsumption(BigDecimal expansivityConsumption) {
        this.expansivityConsumption = expansivityConsumption;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    public String getSettleType() {
        return settleType;
    }

    public void setSettleType(String settleType) {
        this.settleType = settleType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateYmd() {
        return createYmd;
    }

    public void setCreateYmd(String createYmd) {
        this.createYmd = createYmd == null ? null : createYmd.trim();
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}