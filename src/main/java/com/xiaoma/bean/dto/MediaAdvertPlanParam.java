package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * Created by Administrator on 2019/4/13.
 */
public class MediaAdvertPlanParam implements Serializable {

    @ApiModelProperty(value = "计费形式")
    private String billingType;

    @ApiModelProperty(value = "广告类型编码")
    private String showCode;

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    @Override
    public String toString() {
        return "MediaAdvertPlanParam{" +
                "billingType='" + billingType + '\'' +
                ", showCode='" + showCode + '\'' +
                '}';
    }
}
