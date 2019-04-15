package com.xiaoma.bean.po;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 广告主投放充值记录
 * @author mmh
 */
public class SysPlanRecharge {

    private String planRechargeNo;

    private String advertPlanId;

    private String advertId;

    private BigDecimal quota;

    private String creator;

    private Date createTime;

    private BigDecimal beforeBalance;

    private BigDecimal afterBalance;

    private Integer times;

    private Integer belongType;

    public String getPlanRechargeNo() {
        return planRechargeNo;
    }

    public void setPlanRechargeNo(String planRechargeNo) {
        this.planRechargeNo = planRechargeNo == null ? null : planRechargeNo.trim();
    }

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

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getBeforeBalance() {
        return beforeBalance;
    }

    public void setBeforeBalance(BigDecimal beforeBalance) {
        this.beforeBalance = beforeBalance;
    }

    public BigDecimal getAfterBalance() {
        return afterBalance;
    }

    public void setAfterBalance(BigDecimal afterBalance) {
        this.afterBalance = afterBalance;
    }

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public Integer getBelongType() {
        return belongType;
    }

    public void setBelongType(Integer belongType) {
        this.belongType = belongType;
    }
}