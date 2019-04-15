package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 媒体膨胀系数修改
 * @author mmh
 * @date 2019/3/26
 */
public class MediaExpansivityParam implements Serializable {

    @ApiModelProperty(value = "媒体投放计划id")
    private String mediaPlanId;
    @ApiModelProperty(value = "膨胀系数：保留1位小数")
    private BigDecimal expansivity;

    public String getMediaPlanId() {
        return mediaPlanId;
    }

    public void setMediaPlanId(String mediaPlanId) {
        this.mediaPlanId = mediaPlanId;
    }

    public BigDecimal getExpansivity() {
        return expansivity;
    }

    public void setExpansivity(BigDecimal expansivity) {
        this.expansivity = expansivity;
    }

    @Override
    public String toString() {
        return "MediaExpansivityParam{" +
                "mediaPlanId='" + mediaPlanId + '\'' +
                ", expansivity=" + expansivity +
                '}';
    }
}
