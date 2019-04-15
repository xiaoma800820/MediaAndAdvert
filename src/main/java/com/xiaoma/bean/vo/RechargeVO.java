package com.xiaoma.bean.vo;

import java.math.BigDecimal;

/**
 * Created by Administrator on 2019/4/8.
 */
public class RechargeVO {

    private String advertiserId;

    private String advertiserPhone;

    private BigDecimal rechargeNum;

    private String createYmd;

    private String billNo;

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

    public BigDecimal getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(BigDecimal rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public String getCreateYmd() {
        return createYmd;
    }

    public void setCreateYmd(String createYmd) {
        this.createYmd = createYmd;
    }

    public String getBillNo() {
        return billNo;
    }

    public void setBillNo(String billNo) {
        this.billNo = billNo;
    }

    @Override
    public String toString() {
        return "RechargeVO{" +
                "advertiserId='" + advertiserId + '\'' +
                ", advertiserPhone='" + advertiserPhone + '\'' +
                ", rechargeNum=" + rechargeNum +
                ", createYmd='" + createYmd + '\'' +
                ", billNo='" + billNo + '\'' +
                '}';
    }
}
