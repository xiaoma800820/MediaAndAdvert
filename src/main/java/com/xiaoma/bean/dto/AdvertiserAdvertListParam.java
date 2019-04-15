package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告主查询广告列表参数
 * @author mmh
 * @date 2019/4/4
 */
public class AdvertiserAdvertListParam extends PageInfo implements Serializable {

    @ApiModelProperty(value = "广告名称")
    private String advertName;

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    @Override
    public String toString() {
        return "AdvertiserAdvertListParam{" +
                "advertName='" + advertName + '\'' +
                '}';
    }
}
