package com.xiaoma.bean.vo;

import java.math.BigDecimal;

/**
 * 已结算单的vo
 * @author mmh
 * @date 2019/4/8
 */
public class SettleHasVO  {

    private Long accountSettleId;

    private String billNo;

    private String advertName;

    private String billingType;

    private Long consumptionNum;

    private BigDecimal expansivity;

    private BigDecimal expansivityConsumption;

    private BigDecimal price;

    private BigDecimal settleAmount;

    private String settleType;

    private String createYmd;

    private String userId;

    private String userName;

    private String payeeId;

    private String payeeName;

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
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

    public Long getConsumptionNum() {
        return consumptionNum;
    }

    public void setConsumptionNum(Long consumptionNum) {
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

    public String getCreateYmd() {
        return createYmd;
    }

    public void setCreateYmd(String createYmd) {
        this.createYmd = createYmd;
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

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
    }

    public Long getAccountSettleId() {
        return accountSettleId;
    }

    public void setAccountSettleId(Long accountSettleId) {
        this.accountSettleId = accountSettleId;
    }
}
