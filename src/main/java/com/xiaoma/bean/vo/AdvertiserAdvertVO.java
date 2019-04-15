package com.xiaoma.bean.vo;

/**
 * 广告主广告列表vo
 * @author mmh
 * @date 2019/4/4
 */
public class AdvertiserAdvertVO {

    private String advertId;

    private String advertName;

    private String advertUrl;

    private String showName;

    private Integer advertStatus;

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

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Integer getAdvertStatus() {
        return advertStatus;
    }

    public void setAdvertStatus(Integer advertStatus) {
        this.advertStatus = advertStatus;
    }

    @Override
    public String toString() {
        return "AdvertiserAdvertVO{" +
                "advertId='" + advertId + '\'' +
                ", advertName='" + advertName + '\'' +
                ", advertUrl='" + advertUrl + '\'' +
                ", showName='" + showName + '\'' +
                ", advertStatus=" + advertStatus +
                '}';
    }
}
