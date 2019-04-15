package com.xiaoma.bean.dto;

import com.xiaoma.bean.vo.PayeeVO;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体主个人信息更新参数
 * @author mmh
 * @date 2019/4/8
 */
public class MediaOwnerUpdateParam implements Serializable {

    @ApiModelProperty(value = "媒体主id")
    private String mediaOwnerId;
    @ApiModelProperty(value = "支付方式")
    private PayeeVO payeeVO;
    @ApiModelProperty(value = "联系人")
    private String contactsName;
    @ApiModelProperty(value = "性别")
    private Integer sex;

    public String getMediaOwnerId() {
        return mediaOwnerId;
    }

    public void setMediaOwnerId(String mediaOwnerId) {
        this.mediaOwnerId = mediaOwnerId;
    }

    public PayeeVO getPayeeVO() {
        return payeeVO;
    }

    public void setPayeeVO(PayeeVO payeeVO) {
        this.payeeVO = payeeVO;
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

    @Override
    public String toString() {
        return "MediaOwnerUpdateParam{" +
                "mediaOwnerId='" + mediaOwnerId + '\'' +
                ", payeeVO=" + payeeVO +
                ", contactsName='" + contactsName + '\'' +
                ", sex=" + sex +
                '}';
    }
}
