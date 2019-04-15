package com.xiaoma.bean.po;

import java.util.Date;

public class SysAdvertShowType {

    private String showCode;

    private String showName;

    private String showDesc;

    private Date createTime;

    private Date updateTime;

    private Integer advertDr;


    public String getShowCode() {
        return showCode;
    }

    public void setShowCode(String showCode) {
        this.showCode = showCode == null ? null : showCode.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getShowDesc() {
        return showDesc;
    }

    public void setShowDesc(String showDesc) {
        this.showDesc = showDesc == null ? null : showDesc.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAdvertDr() {
        return advertDr;
    }

    public void setAdvertDr(Integer advertDr) {
        this.advertDr = advertDr;
    }
}