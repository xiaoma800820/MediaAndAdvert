package com.xiaoma.bean.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/4/11.
 */
public class AdvertiserSettleVO implements Serializable {

    private String billNo;
    private String createYMD;
    private String advertName;
    private String recordType;
    private String billingType;
    private BigDecimal price;
    private BigDecimal consumptionNum;
    private BigDecimal settleAmount;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    public String getCreateYMD() {
        return createYMD;
    }

    public void setCreateYMD(String createYMD) {
        this.createYMD = createYMD;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
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
}
