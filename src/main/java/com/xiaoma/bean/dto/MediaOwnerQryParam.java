package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体主查询参数
 * @author mmh
 * @date 2019/3/25
 */
public class MediaOwnerQryParam extends PageInfo implements Serializable {

    @ApiModelProperty(value = "媒体主手机号")
    private String mediaPhone;

    public String getMediaPhone() {
        return mediaPhone;
    }

    public void setMediaPhone(String mediaPhone) {
        this.mediaPhone = mediaPhone;
    }

    @Override
    public String toString() {
        return "MediaOwnerQryParam{" +
                "mediaPhone='" + mediaPhone + '\'' +
                '}';
    }
}
