package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体投放计划查询参数
 * @author mmh
 * @date 2019/3/26
 */
public class MediaPlanQryListParam extends PageInfo implements Serializable {
    @ApiModelProperty(value = "媒体名称")
    private String mediaName;
    @ApiModelProperty(value = "计费形式")
    private String billingType;

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    @Override
    public String toString() {
        return "MediaPlanQryListParam{" +
                "mediaName='" + mediaName + '\'' +
                ", billingType='" + billingType + '\'' +
                '}';
    }
}
