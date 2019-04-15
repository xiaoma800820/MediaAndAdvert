package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告信息添加参数
 * @author mmh
 * @date 2019/3/20
 */
public class AdvertInfoAddParam implements Serializable {

    @ApiModelProperty(value = "广告主主键Id")
    private String advertiserId;
    @ApiModelProperty(value = "广告主手机号")
    private String advertiserPhone;
    @ApiModelProperty(value = "广告名称")
    private String advertName;
    @ApiModelProperty(value = "广告链接")
    private String advertUrl;
    @ApiModelProperty(value = "广告类型")
    private String advertShowType;

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl;
    }

    public String getAdvertShowType() {
        return advertShowType;
    }

    public void setAdvertShowType(String advertShowType) {
        this.advertShowType = advertShowType;
    }

    public String getAdvertiserPhone() {
        return advertiserPhone;
    }

    public void setAdvertiserPhone(String advertiserPhone) {
        this.advertiserPhone = advertiserPhone;
    }

    @Override
    public String toString() {
        return "AdvertInfoAddParam{" +
                "advertiserId='" + advertiserId + '\'' +
                ", advertiserPhone='" + advertiserPhone + '\'' +
                ", advertName='" + advertName + '\'' +
                ", advertUrl='" + advertUrl + '\'' +
                ", advertShowType='" + advertShowType + '\'' +
                '}';
    }
}
