package com.xiaoma.bean.po;

import java.util.Date;

public class SysUserLoginLog {
    private Long loginId;

    private String loginAccount;

    private Date loginTime;

    private String loginIp;

    private String lgoinDesc;

    private String token;

    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp == null ? null : loginIp.trim();
    }

    public String getLgoinDesc() {
        return lgoinDesc;
    }

    public void setLgoinDesc(String lgoinDesc) {
        this.lgoinDesc = lgoinDesc == null ? null : lgoinDesc.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}