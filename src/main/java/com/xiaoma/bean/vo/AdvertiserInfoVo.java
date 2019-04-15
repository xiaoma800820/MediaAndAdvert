package com.xiaoma.bean.vo;

import java.io.Serializable;

/**
 * 广告主详细信息vo
 * @author mmh
 * @date 2019/4/4
 */
public class AdvertiserInfoVo implements Serializable {

    private String advertiserId;

    private String company;

    private String contactName;

    private Integer sex;

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
}
