package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2019/4/9.
 */
public class SettleParam implements Serializable {

    @ApiModelProperty(value = "结算单唯一id数组")
    private List<Long> settleIdS;

    public List<Long> getSettleIdS() {
        return settleIdS;
    }

    public void setSettleIdS(List<Long> settleIdS) {
        this.settleIdS = settleIdS;
    }

    @Override
    public String toString() {
        return "SettleParam{" +
                "settleIdS=" + settleIdS +
                '}';
    }
}
