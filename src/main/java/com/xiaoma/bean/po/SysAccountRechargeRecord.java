package com.xiaoma.bean.po;

import java.math.BigDecimal;
import java.util.Date;

public class SysAccountRechargeRecord {

    private Long rechargeId;

    private String advertiserId;

    private String advertiserPhone;

    private BigDecimal rechargeBefore;

    private BigDecimal rechargeBack;

    private BigDecimal rechargeNum;

    private Date createTime;

    private String transactionSerialNumber;

    private String remark;

    private String createYmd;

    private String billNo;

    public Long getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Long rechargeId) {
        this.rechargeId = rechargeId;
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
        this.advertiserPhone = advertiserPhone == null ? null : advertiserPhone.trim();
    }

    public BigDecimal getRechargeBefore() {
        return rechargeBefore;
    }

    public void setRechargeBefore(BigDecimal rechargeBefore) {
        this.rechargeBefore = rechargeBefore;
    }

    public BigDecimal getRechargeBack() {
        return rechargeBack;
    }

    public void setRechargeBack(BigDecimal rechargeBack) {
        this.rechargeBack = rechargeBack;
    }

    public BigDecimal getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(BigDecimal rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTransactionSerialNumber() {
        return transactionSerialNumber;
    }

    public void setTransactionSerialNumber(String transactionSerialNumber) {
        this.transactionSerialNumber = transactionSerialNumber == null ? null : transactionSerialNumber.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getCreateYmd() {
        return createYmd;
    }

    public void setCreateYmd(String createYmd) {
        this.createYmd = createYmd == null ? null : createYmd.trim();
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo == null ? null : billNo.trim();
    }
}