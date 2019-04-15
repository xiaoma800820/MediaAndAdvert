package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 密码修改参数
 * @author mmh
 * @date 2019/4/4
 */
public class PassWordUpdateParam implements Serializable {

    @ApiModelProperty(value = "旧密码")
    private String oldPassWord;
    @ApiModelProperty(value = "新密码")
    private String newPassWord;

    public String getOldPassWord() {
        return oldPassWord;
    }

    public void setOldPassWord(String oldPassWord) {
        this.oldPassWord = oldPassWord;
    }

    public String getNewPassWord() {
        return newPassWord;
    }

    public void setNewPassWord(String newPassWord) {
        this.newPassWord = newPassWord;
    }

    @Override
    public String toString() {
        return "PassWordUpdateParam{" +
                "oldPassWord='" + oldPassWord + '\'' +
                ", newPassWord='" + newPassWord + '\'' +
                '}';
    }
}
