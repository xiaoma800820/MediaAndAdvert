package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告投放计划状态更新参数
 * @author mmh
 * @date 2019/3/26
 */
public class PutPlanStatusParam implements Serializable {

    @ApiModelProperty(value = "广告投放计划id")
    private String advertPlanId;
    @ApiModelProperty(value = "状态更新：0是空闲，1是投放中，2是已停止")
    private Integer status;

    public String getAdvertPlanId() {
        return advertPlanId;
    }

    public void setAdvertPlanId(String advertPlanId) {
        this.advertPlanId = advertPlanId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PutPlanStatusParam{" +
                "advertPlanId='" + advertPlanId + '\'' +
                ", status=" + status +
                '}';
    }
}
