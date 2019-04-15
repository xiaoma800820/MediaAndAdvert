package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告信息更新参数模型
 * @author mmh
 * @date 2019/3/25
 */
public class AdvertInfoEditParam extends AdvertInfoAddParam implements Serializable {

    @ApiModelProperty(value = "广告信息主键")
    private String advertId;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    @Override
    public String toString() {
        return "AdvertInfoEditParam{" +
                "advertId='" + advertId + '\'' +
                '}';
    }
}
