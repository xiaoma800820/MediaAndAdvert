package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 密码修改请求参数
 * @author mmh
 * @date 2019/3/25
 */
public class PassWordParam implements Serializable {

    @ApiModelProperty(value = "原密码")
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
        return "PassWordParam{" +
                "oldPassWord='" + oldPassWord + '\'' +
                ", newPassWord='" + newPassWord + '\'' +
                '}';
    }
}
