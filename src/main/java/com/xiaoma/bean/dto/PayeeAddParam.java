package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 媒体主收款方式添加参数
 * @author mmh
 * @date 2019/3/25
 */
public class PayeeAddParam implements Serializable {

    @ApiModelProperty(value = "收款方式名称")
    private String typeName;
    @ApiModelProperty(value = "收款人姓名")
    private String payee;
    @ApiModelProperty(value = "支付宝账号")
    private String alipayAccount;
    @ApiModelProperty(value = "开户行")
    private String openingBank;
    @ApiModelProperty(value = "卡号")
    private String bankAccount;
    @ApiModelProperty(value = "所属账号id：媒体主id")
    private String ownerId;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getPayee() {
        return payee;
    }

    public void setPayee(String payee) {
        this.payee = payee;
    }

    public String getAlipayAccount() {
        return alipayAccount;
    }

    public void setAlipayAccount(String alipayAccount) {
        this.alipayAccount = alipayAccount;
    }

    public String getOpeningBank() {
        return openingBank;
    }

    public void setOpeningBank(String openingBank) {
        this.openingBank = openingBank;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "PayeeAddParam{" +
                "typeName='" + typeName + '\'' +
                ", payee='" + payee + '\'' +
                ", alipayAccount='" + alipayAccount + '\'' +
                ", openingBank='" + openingBank + '\'' +
                ", bankAccount='" + bankAccount + '\'' +
                ", ownerId='" + ownerId + '\'' +
                '}';
    }
}
