package com.xiaoma.bean.dto;

import com.xiaoma.utils.PageInfo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告投放列表查询
 * @author mmh
 * @date 2019/3/26
 */
public class AdvertPlanQryListParam extends PageInfo implements Serializable {

    @ApiModelProperty(value = "广告名称")
    private String advertName;

    @ApiModelProperty(value = "计费形式")
    private String billingType;

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    @Override
    public String toString() {
        return "AdvertPlanQryListParam{" +
                "advertName='" + advertName + '\'' +
                ", billingType='" + billingType + '\'' +
                '}';
    }
}
