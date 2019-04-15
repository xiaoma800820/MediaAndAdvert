package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 帐号密码登录model
 * @author mmh
 * @date 2019/3/18
 */
@ApiModel(value = "手机号密码模型")
public class LoginParam implements Serializable {

    @ApiModelProperty(value = "手机号")
    private String userPhone;
    @ApiModelProperty(value = "密码")
    private String passWord;

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "userPhone='" + userPhone + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
