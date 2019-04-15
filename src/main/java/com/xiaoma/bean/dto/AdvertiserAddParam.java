package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告主新增参数封装
 * @author mmh
 * @date 2019/3/20
 */
public class AdvertiserAddParam implements Serializable {

    @ApiModelProperty(value = "公司名称")
    private String company;
    @ApiModelProperty(value = "联系人")
    private String contactName;
    @ApiModelProperty(value = "性别：1男，2是女，3保密")
    private Integer sex;
    @ApiModelProperty(value = "帐号电话")
    private String advertiserPhone;
    @ApiModelProperty(value = "密码")
    private String passWord;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAdvertiserPhone() {
        return advertiserPhone;
    }

    public void setAdvertiserPhone(String advertiserPhone) {
        this.advertiserPhone = advertiserPhone;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "AdvertiserAddParam{" +
                "company='" + company + '\'' +
                ", contactName='" + contactName + '\'' +
                ", sex=" + sex +
                ", advertiserPhone='" + advertiserPhone + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
