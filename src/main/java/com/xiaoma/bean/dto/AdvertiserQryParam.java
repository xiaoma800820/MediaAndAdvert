package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告主的查询参数
 * @author mmh
 * @date 2019/3/20
 */
public class AdvertiserQryParam extends PageInfo implements Serializable {

    @ApiModelProperty(value = "广告主手机号")
    private String advertiserPhone;



    public String getAdvertiserPhone() {
        return advertiserPhone;
    }

    public void setAdvertiserPhone(String advertiserPhone) {
        this.advertiserPhone = advertiserPhone;
    }

    @Override
    public String toString() {
        return "AdvertiserQryParam{" +
                "advertiserPhone='" + advertiserPhone + '\'' +
                '}';
    }
}
