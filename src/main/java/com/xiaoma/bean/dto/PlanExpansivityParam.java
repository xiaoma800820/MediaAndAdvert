package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 膨胀系数修改参数
 * @author mmh
 * @date 2019/3/26
 */
public class PlanExpansivityParam implements Serializable {

    @ApiModelProperty(value = "广告投放计划id")
    private String advertPlanId;
    @ApiModelProperty(value = "膨胀系数参数")
    private BigDecimal expansivity;

    public String getAdvertPlanId() {
        return advertPlanId;
    }

    public void setAdvertPlanId(String advertPlanId) {
        this.advertPlanId = advertPlanId;
    }

    public BigDecimal getExpansivity() {
        return expansivity;
    }

    public void setExpansivity(BigDecimal expansivity) {
        this.expansivity = expansivity;
    }

    @Override
    public String toString() {
        return "PlanExpansivityParam{" +
                "advertPlanId='" + advertPlanId + '\'' +
                ", expansivity=" + expansivity +
                '}';
    }
}
