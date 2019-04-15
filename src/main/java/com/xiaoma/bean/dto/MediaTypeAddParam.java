package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体类型
 * @author mmh
 * @date 2019/3/27
 */
@ApiModel(value = "媒体类型新增模型")
public class MediaTypeAddParam implements Serializable {

    @ApiModelProperty(value = "媒体类型名称")
    private String mediaTypeName;

    public String getMediaTypeName() {
        return mediaTypeName;
    }

    public void setMediaTypeName(String mediaTypeName) {
        this.mediaTypeName = mediaTypeName;
    }

    @Override
    public String toString() {
        return "MediaTypeAddParam{" +
                "mediaTypeName='" + mediaTypeName + '\'' +
                '}';
    }
}
