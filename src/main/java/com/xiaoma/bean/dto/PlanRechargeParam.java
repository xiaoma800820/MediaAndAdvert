package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 计划充值金额系数
 * @author mmh
 * @date 2019/4/4
 */
public class PlanRechargeParam implements Serializable {

    @ApiModelProperty(value = "计划id")
    private String planId;

    @ApiModelProperty(value = "投放充值倍数")
    private Integer times;

    public Integer getTimes() {
        return times;
    }

    public void setTimes(Integer times) {
        this.times = times;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "PlanRechargeParam{" +
                "planId='" + planId + '\'' +
                ", times=" + times +
                '}';
    }
}
