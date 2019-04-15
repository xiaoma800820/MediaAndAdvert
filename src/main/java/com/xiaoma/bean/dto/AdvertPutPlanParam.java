package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 广告投放计划新增参数
 * @author mmh
 * @date 2019/3/26
 */
public class AdvertPutPlanParam implements Serializable {


    @ApiModelProperty(value = "广告的id")
    private String advertId;
    @ApiModelProperty(value = "计费形式")
    private String billingType;
    @ApiModelProperty(value = "单价(元)")
    private BigDecimal price;
    @ApiModelProperty(value = "限额(元)")
    private BigDecimal quota;
    @ApiModelProperty(value = "膨胀系数")
    private BigDecimal expansivity;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
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

    @Override
    public String toString() {
        return "AdvertPutPlanParam{" +
                "advertId='" + advertId + '\'' +
                ", billingType='" + billingType + '\'' +
                ", price=" + price +
                ", quota=" + quota +
                ", expansivity=" + expansivity +
                '}';
    }
}
