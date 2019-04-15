package com.xiaoma.bean.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告展示类型VO
 * @author mmh
 * @date 2019/3/27
 */
public class ShowTypeVO implements Serializable {


    private String showCode;

    private String showName;

    private String showDesc;

    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc;
    }

    @Override
    public String toString() {
        return "ShowTypeVO{" +
                "showCode='" + showCode + '\'' +
                ", showName='" + showName + '\'' +
                ", showDesc='" + showDesc + '\'' +
                '}';
    }
}
