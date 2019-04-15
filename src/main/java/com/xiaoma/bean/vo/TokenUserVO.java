package com.xiaoma.bean.vo;

import java.io.Serializable;

/**
 * 用户访问token
 * 对象信息封装
 * @author mmh
 * @date 2018/10/17
 */
public class TokenUserVO implements Serializable {

    private String userId;
    private String phoneNo;
    private String contactName;
    private long balance;
    private String token;
    private Integer docType;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getDocType() {
        return docType;
    }

    public void setDocType(Integer docType) {
        this.docType = docType;
    }

    @Override
    public String toString() {
        return "TokenUserVO{" +
                "userId='" + userId + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", contactName='" + contactName + '\'' +
                ", balance=" + balance +
                ", token='" + token + '\'' +
                ", docType=" + docType +
                '}';
    }
}
