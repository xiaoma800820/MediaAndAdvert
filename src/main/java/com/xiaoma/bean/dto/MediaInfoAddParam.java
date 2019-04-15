package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体信息添加参数封装
 * @author mmh
 * @date 2019/3/25
 */
public class MediaInfoAddParam implements Serializable {


    @ApiModelProperty(value = "媒体主id")
    private String mediaOwnerId;
    @ApiModelProperty(value = "媒体主手机号")
    private String mediaPhone;
    @ApiModelProperty(value = "媒体名称")
    private String mediaName;
    @ApiModelProperty(value = "媒体类型id")
    private Long mediaTypeId;
    @ApiModelProperty(value = "广告位")
    private String advertPosition;
    @ApiModelProperty(value = "广告类型")
    private String advertShowType;

    public String getMediaOwnerId() {
        return mediaOwnerId;
    }

    public void setMediaOwnerId(String mediaOwnerId) {
        this.mediaOwnerId = mediaOwnerId;
    }

    public String getMediaPhone() {
        return mediaPhone;
    }

    public void setMediaPhone(String mediaPhone) {
        this.mediaPhone = mediaPhone;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    public Long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public String getAdvertPosition() {
        return advertPosition;
    }

    public void setAdvertPosition(String advertPosition) {
        this.advertPosition = advertPosition;
    }

    public String getAdvertShowType() {
        return advertShowType;
    }

    public void setAdvertShowType(String advertShowType) {
        this.advertShowType = advertShowType;
    }

    @Override
    public String toString() {
        return "MediaInfoAddParam{" +
                "mediaOwnerId='" + mediaOwnerId + '\'' +
                ", mediaPhone='" + mediaPhone + '\'' +
                ", mediaName='" + mediaName + '\'' +
                ", mediaTypeId=" + mediaTypeId +
                ", advertPosition='" + advertPosition + '\'' +
                ", advertShowType='" + advertShowType + '\'' +
                '}';
    }
}
