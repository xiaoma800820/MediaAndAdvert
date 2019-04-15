package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体广告投放参数
 * @author mmh
 * @date 2019/3/26
 */
public class MediaAdvertPut implements Serializable {

    @ApiModelProperty(value = "广告id")
    private String advertId;
    @ApiModelProperty(value = "广告名称")
    private String advertName;
    @ApiModelProperty(value = "权重因子：所有的因子加一起不能大于100")
    private Integer weightFactor;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public String getAdvertName() {
        return advertName;
    }

    public void setAdvertName(String advertName) {
        this.advertName = advertName;
    }

    public Integer getWeightFactor() {
        return weightFactor;
    }

    public void setWeightFactor(Integer weightFactor) {
        this.weightFactor = weightFactor;
    }

    @Override
    public String toString() {
        return "MediaAdvertPut{" +
                "advertId='" + advertId + '\'' +
                ", advertName='" + advertName + '\'' +
                ", weightFactor=" + weightFactor +
                '}';
    }
}
