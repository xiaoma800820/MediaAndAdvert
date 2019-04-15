package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 充值参数封装
 * @author mmh
 * @date 2019/3/25
 */
public class RechargeParam implements Serializable {

    @ApiModelProperty(value = "广告主id")
    private String advertiserId;
    @ApiModelProperty(value = "充值金额")
    private Long rechargeNum;

    public Long getRechargeNum() {
        return rechargeNum;
    }

    public void setRechargeNum(Long rechargeNum) {
        this.rechargeNum = rechargeNum;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    @Override
    public String toString() {
        return "RechargeParam{" +
                "advertiserId='" + advertiserId + '\'' +
                ", rechargeNum=" + rechargeNum +
                '}';
    }
}
