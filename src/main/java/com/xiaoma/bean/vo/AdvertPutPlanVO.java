package com.xiaoma.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 广告投放计划vo
 * @author mmh
 * @date 2019/3/26
 */
public class AdvertPutPlanVO implements Serializable {

    private String advertPlanId;

    private String advertId;

    private String advertName;

    private String billingType;

    private BigDecimal price;

    private BigDecimal quota;

    private BigDecimal expansivity;

    private BigDecimal balance;

    private Integer status;

    public String getAdvertPlanId() {
        return advertPlanId;
    }

    public void setAdvertPlanId(String advertPlanId) {
        this.advertPlanId = advertPlanId;
    }

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
