package com.xiaoma.bean.vo;

import java.io.Serializable;

/**
 * 计费形式vo
 * @author mmh
 * @date 2019/3/27
 */
public class BillingConfigVO implements Serializable {

    private String billingCode;

    private String billingDesc;

    public String getBillingCode() {
        return billingCode;
    }

    public void setBillingCode(String billingCode) {
        this.billingCode = billingCode;
    }

    public String getBillingDesc() {
        return billingDesc;
    }

    public void setBillingDesc(String billingDesc) {
        this.billingDesc = billingDesc;
    }

    @Override
    public String toString() {
        return "BillingConfigVO{" +
                "billingCode='" + billingCode + '\'' +
                ", billingDesc='" + billingDesc + '\'' +
                '}';
    }
}
