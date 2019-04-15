package com.xiaoma.bean.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 媒体投放计划参数
 * @author mmh
 * @date 2019/3/26
 */
public class MediaPutPlanParam implements Serializable {

    @ApiModelProperty(value = "媒体id")
    private String mediaId;
    @ApiModelProperty(value = "媒体名称")
    private String mediaName;
    @ApiModelProperty(value = "计费形式")
    private String billingType;
    @ApiModelProperty(value = "单价元")
    private BigDecimal price;
    @ApiModelProperty(value = "限额元")
    private BigDecimal quota;
    @ApiModelProperty(value = "膨胀系数")
    private BigDecimal expansivity;
    @ApiModelProperty(value = "广告投放")
    private List<MediaAdvertPut> mediaAdvertPuts;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getBillingType() {
        return billingType;
    }

    public void setBillingType(String billingType) {
        this.billingType = billingType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getQuota() {
        return quota;
    }

    public void setQuota(BigDecimal quota) {
        this.quota = quota;
    }

    public BigDecimal getExpansivity() {
        return expansivity;
    }

    public void setExpansivity(BigDecimal expansivity) {
        this.expansivity = expansivity;
    }

    public List<MediaAdvertPut> getMediaAdvertPuts() {
        return mediaAdvertPuts;
    }

    public void setMediaAdvertPuts(List<MediaAdvertPut> mediaAdvertPuts) {
        this.mediaAdvertPuts = mediaAdvertPuts;
    }

    public String getMediaName() {
        return mediaName;
    }

    public void setMediaName(String mediaName) {
        this.mediaName = mediaName;
    }

    @Override
    public String toString() {
        return "MediaPutPlanParam{" +
                "mediaId='" + mediaId + '\'' +
                ", mediaName='" + mediaName + '\'' +
                ", billingType='" + billingType + '\'' +
                ", price=" + price +
                ", quota=" + quota +
                ", expansivity=" + expansivity +
                ", mediaAdvertPuts=" + mediaAdvertPuts +
                '}';
    }
}
