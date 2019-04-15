package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 收款方式
 * @author mmh
 * @date 2019/3/25
 */
public class PayeeQryParam implements Serializable {

    @ApiModelProperty(value = "收款方式id")
    private String payeeId;

    public String getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(String payeeId) {
        this.payeeId = payeeId;
    }

    @Override
    public String toString() {
        return "PayeeQryParam{" +
                "payeeId='" + payeeId + '\'' +
                '}';
    }
}
