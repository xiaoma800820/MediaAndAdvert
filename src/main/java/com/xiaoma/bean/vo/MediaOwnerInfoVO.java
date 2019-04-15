package com.xiaoma.bean.vo;

import java.io.Serializable;

/**
 * 媒体主个人信息vo
 * @author mmh
 * @date 2019/4/8
 */
public class MediaOwnerInfoVO implements Serializable{

    private String mediaOwnerId;

    private String payeeId;

    private PayeeVO payeeVO;

    private String mediaPhone;

    private String contactsName;

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

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }
}
