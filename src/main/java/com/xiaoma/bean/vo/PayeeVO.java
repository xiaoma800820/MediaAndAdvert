package com.xiaoma.bean.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 支付收款方式
 * @author mmh
 * @date 2019/4/8
 */
public class PayeeVO implements Serializable {

    @ApiModelProperty(value = "支付方式Id")
    private String payeeId;
    @ApiModelProperty(value = "支付方式名称")
    private String typeName;
    @ApiModelProperty(value = "收款人")
    private String payee;
    @ApiModelProperty(value = "支付宝账号")
    private String alipayAccount;
    @ApiModelProperty(value = "开户行名称")
    private String openingBank;
    @ApiModelProperty(value = "开户账号")
    private String bankAccount;

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

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
}
