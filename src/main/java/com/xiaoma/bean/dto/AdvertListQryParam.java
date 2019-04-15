package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告列表查询参数
 * @author mmh
 * @date 2019/3/26
 */
public class AdvertListQryParam extends PageInfo implements Serializable {

    @ApiModelProperty(value = "广告主手机号")
    private String advertiserPhone;

    @ApiModelProperty(value = "广告名称")
    private String advertName;

    public String getAdvertiserPhone() {
        return advertiserPhone;
    }

    public void setAdvertiserPhone(String advertiserPhone) {
        this.advertiserPhone = advertiserPhone;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    @Override
    public String toString() {
        return "AdvertListQryParam{" +
                "advertiserPhone='" + advertiserPhone + '\'' +
                ", advertName='" + advertName + '\'' +
                '}';
    }
}
