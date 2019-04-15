package com.xiaoma.bean.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 媒体信息VO
 * @author mmh
 * @date 2019/3/26
 */
public class MediaInfoVO implements Serializable {

    private String mediaId;

    private String mediaOwnerId;

    private String mediaPhone;

    private String mediaName;

    private String mediaTypeName;

    private String advertPosition;

    private String advertShowType;

    private String showTypeName;

    private Integer status;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

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

    public String getMediaTypeName() {
        return mediaTypeName;
    }

    public void setMediaTypeName(String mediaTypeName) {
        this.mediaTypeName = mediaTypeName;
    }

    public String getAdvertPosition() {
        return advertPosition;
    }

    public void setAdvertPosition(String advertPosition) {
        this.advertPosition = advertPosition;
    }

    public String getShowTypeName() {
        return showTypeName;
    }

    public void setShowTypeName(String showTypeName) {
        this.showTypeName = showTypeName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAdvertShowType() {
        return advertShowType;
    }

    public void setAdvertShowType(String advertShowType) {
        this.advertShowType = advertShowType;
    }
}
