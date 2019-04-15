package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告展示类型
 * @author mmh
 * @date 2019/3/27
 */
@ApiModel(value = "广告展示类型新增参数封装")
public class ShowTypeAddParam implements Serializable {

    @ApiModelProperty(value = "编码(唯一)")
    private String showCode;
    @ApiModelProperty(value = "展示类型名称:开屏、竖屏等")
    private String showName;
    @ApiModelProperty(value = "详细描述")
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
        return "ShowTypeAddParam{" +
                "showCode='" + showCode + '\'' +
                ", showName='" + showName + '\'' +
                ", showDesc='" + showDesc + '\'' +
                '}';
    }
}
