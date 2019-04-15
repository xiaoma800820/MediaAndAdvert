package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体播放回写参数
 * @author mmh
 * @date 2019/4/8
 */
public class MediaWriterParam implements Serializable {

    @ApiModelProperty(value = "广告Id")
    private String advertId;
    @ApiModelProperty(value = "计划id")
    private String planId;
    @ApiModelProperty(value = "媒体key")
    private String accessId;


    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "MediaWriterParam{" +
                "advertId='" + advertId + '\'' +
                ", planId='" + planId + '\'' +
                ", accessId='" + accessId + '\'' +
                '}';
    }
}
