package com.xiaoma.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 媒体主财务信息VO
 * @author mmh
 * @date 2019/4/11
 */
public class MediaSettleVO implements Serializable {


    private String billNo;

    private String createYmd;

    private String advertName;

    private String billingType;

    private BigDecimal price;

    private BigDecimal consumptionNum;

    private BigDecimal settleAmount;

    private Integer status;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getCreateYmd() {
        return createYmd;
    }

    public void setCreateYmd(String createYmd) {
        this.createYmd = createYmd;
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

    public BigDecimal getConsumptionNum() {
        return consumptionNum;
    }

    public void setConsumptionNum(BigDecimal consumptionNum) {
        this.consumptionNum = consumptionNum;
    }

    public BigDecimal getSettleAmount() {
        return settleAmount;
    }

    public void setSettleAmount(BigDecimal settleAmount) {
        this.settleAmount = settleAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
