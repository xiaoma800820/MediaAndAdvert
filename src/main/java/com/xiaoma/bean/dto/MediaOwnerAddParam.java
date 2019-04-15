package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体主新增参数封装
 * @author mmh
 * @date 2019/3/25
 */
public class MediaOwnerAddParam implements Serializable {

    @ApiModelProperty(value = "手机号")
    private String mediaPhone;
    @ApiModelProperty(value = "联系人")
    private String contactsName;
    @ApiModelProperty(value = "性别:1男2女3保密")
    private Integer sex;
    @ApiModelProperty(value = "密码")
    private String passWord;


    public String getMediaPhone() {
        return mediaPhone;
    }

    public void setMediaPhone(String mediaPhone) {
        this.mediaPhone = mediaPhone;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "MediaOwnerAddParam{" +
                "mediaPhone='" + mediaPhone + '\'' +
                ", contactsName='" + contactsName + '\'' +
                ", sex=" + sex +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
