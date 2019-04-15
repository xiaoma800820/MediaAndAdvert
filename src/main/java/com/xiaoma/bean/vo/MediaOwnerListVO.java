package com.xiaoma.bean.vo;

/**
 * Created by Administrator on 2019/4/8.
 */
public class MediaOwnerListVO {

    private String mediaOwnerId;

    private String payeeId;

    private String payeeName;

    private String mediaPhone;

    private String contactsName;

    private Integer sex;

    private Long currentBalance;

    public String getMediaOwnerId() {
        return mediaOwnerId;
    }

    public void setMediaOwnerId(String mediaOwnerId) {
        this.mediaOwnerId = mediaOwnerId;
    }

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    public String getPayeeName() {
        return payeeName;
    }

    public void setPayeeName(String payeeName) {
        this.payeeName = payeeName;
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

    public Long getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Long currentBalance) {
        this.currentBalance = currentBalance;
    }

    @Override
    public String toString() {
        return "MediaOwnerListVO{" +
                "mediaOwnerId='" + mediaOwnerId + '\'' +
                ", payeeId='" + payeeId + '\'' +
                ", payeeName='" + payeeName + '\'' +
                ", mediaPhone='" + mediaPhone + '\'' +
                ", contactsName='" + contactsName + '\'' +
                ", sex=" + sex +
                ", currentBalance=" + currentBalance +
                '}';
    }
}
