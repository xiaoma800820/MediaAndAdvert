package com.xiaoma.bean.bo;

import java.io.Serializable;

/**
 * 广告主业务查询统计类
 * @author mmh
 * @date 2019/4/11
 */
public class SysAdvertAdvertiserBO implements Serializable{


    private String advertId;

    private int playNum;

    public String getAdvertId() {
        return advertId;
    }

    public void setAdvertId(String advertId) {
        this.advertId = advertId;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    @Override
    public String toString() {
        return "SysAdvertAdvertiserBO{" +
                "advertId='" + advertId + '\'' +
                ", playNum=" + playNum +
                '}';
    }
}
