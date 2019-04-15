package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体信息列表查询参数
 * @author mmh
 * @date 2019/3/26
 */
public class MediaQryListParam extends PageInfo implements Serializable {

    @ApiModelProperty(value = "媒体主手机号")
    private String mediaPhone;
    @ApiModelProperty(value = "媒体名称")
    private String mediaName;

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

    @Override
    public String toString() {
        return "MediaQryListParam{" +
                "mediaPhone='" + mediaPhone + '\'' +
                ", mediaName='" + mediaName + '\'' +
                '}';
    }
}
