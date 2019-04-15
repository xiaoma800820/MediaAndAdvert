package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 广告主修改参数
 * @author mmh
 * @date 2019/4/4
 */
public class AdvertiserEditParam implements Serializable {

    @ApiModelProperty(value = "广告主id")
    private String advertiserId;
    @ApiModelProperty(value = "公司")
    private String company;
    @ApiModelProperty(value = "联系人")
    private String contactName;
    @ApiModelProperty(value = "性别")
    private Integer sex;
    @ApiModelProperty(value = "用户名")
    private String advertiserPhone;

    public String getAdvertiserId() {
        return advertiserId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

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

    @Override
    public String toString() {
        return "AdvertiserEditParam{" +
                "advertiserId='" + advertiserId + '\'' +
                ", company='" + company + '\'' +
                ", contactName='" + contactName + '\'' +
                ", sex=" + sex +
                ", advertiserPhone='" + advertiserPhone + '\'' +
                '}';
    }
}
