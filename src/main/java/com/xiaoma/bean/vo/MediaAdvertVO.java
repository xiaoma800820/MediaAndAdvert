package com.xiaoma.bean.vo;

import java.io.Serializable;

/**
 *
 * @author Administrator
 * @date 2019/4/8
 */
public class MediaAdvertVO implements Serializable {

    private String planId;

    private String advertId;

    private String advertName;

    private String advertUrl;

    private String advertShowType;

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

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    @Override
    public String toString() {
        return "MediaAdvertVO{" +
                "planId='" + planId + '\'' +
                ", advertId='" + advertId + '\'' +
                ", advertName='" + advertName + '\'' +
                ", advertUrl='" + advertUrl + '\'' +
                ", advertShowType='" + advertShowType + '\'' +
                '}';
    }
}
