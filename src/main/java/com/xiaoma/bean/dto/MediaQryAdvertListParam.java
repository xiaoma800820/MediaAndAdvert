package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

/**
 * 媒体主查看广告列表
 * @author mmh
 * @date 2019/4/8
 */
public class MediaQryAdvertListParam implements Serializable {


    @ApiModelProperty(value = "编码(唯一)")
    private String showCode;

    @ApiModelProperty(value = "媒体访问key")
    private String accessId;

    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    @Override
    public String toString() {
        return "MediaQryAdvertListParam{" +
                "showCode='" + showCode + '\'' +
                ", accessId='" + accessId + '\'' +
                '}';
    }
}
