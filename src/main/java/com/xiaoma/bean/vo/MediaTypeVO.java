package com.xiaoma.bean.vo;

import java.io.Serializable;

/**
 * 媒体类型VO封装
 * @author mmh
 * @date 2019/3/27
 */
public class MediaTypeVO implements Serializable {

    private Long mediaTypeId;

    private String mediaTypeName;

    public Long getMediaTypeId() {
        return mediaTypeId;
    }

    public void setMediaTypeId(Long mediaTypeId) {
        this.mediaTypeId = mediaTypeId;
    }

    public String getMediaTypeName() {
        return mediaTypeName;
    }

    public void setMediaTypeName(String mediaTypeName) {
        this.mediaTypeName = mediaTypeName;
    }

    @Override
    public String toString() {
        return "MediaTypeVO{" +
                "mediaTypeId=" + mediaTypeId +
                ", mediaTypeName='" + mediaTypeName + '\'' +
                '}';
    }
}
