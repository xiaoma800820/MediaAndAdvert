package com.xiaoma.bean.po;

import java.util.Date;

public class SysBillingConfig {
    private String billingCode;

    private String billingDesc;

    private Date createTime;

    private Date updateTime;

    private Integer status;

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode == null ? null : billingCode.trim();
    }

    public String getBillingDesc() {
        return billingDesc;
    }

    public void setBillingDesc(String billingDesc) {
        this.billingDesc = billingDesc == null ? null : billingDesc.trim();
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
}