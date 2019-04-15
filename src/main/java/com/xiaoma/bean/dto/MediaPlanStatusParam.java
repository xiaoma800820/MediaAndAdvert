package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体投放计划状态更新参数
 * @author mmh
 * @date 2019/3/26
 */
public class MediaPlanStatusParam implements Serializable {

    @ApiModelProperty(value = "媒体投放计划id")
    private String mediaPlanId;
    @ApiModelProperty(value = "状态更新：0是空闲，1是投放中，2是已停止")
    private Integer status;

    public String getMediaPlanId() {
        return mediaPlanId;
    }

    public void setMediaPlanId(String mediaPlanId) {
        this.mediaPlanId = mediaPlanId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MediaPlanStatusParam{" +
                "mediaPlanId='" + mediaPlanId + '\'' +
                ", status=" + status +
                '}';
    }
}
