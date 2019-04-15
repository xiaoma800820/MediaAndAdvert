package com.xiaoma.utils;

import io.swagger.annotations.ApiModelProperty;

/**
 * 分页信息类
 *
 * @author mmh
 * @date 2017\10\19 0019
 */
public class PageInfo {

    /**
     * 请求的页码
     */
    @ApiModelProperty(value = "请求页码")
    private Integer pageNo;
    /**
     * 每页行数
     */
    @ApiModelProperty(value = "单页行数")
    private Integer pageSize;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo == null){
            this.pageNo = 1;
        }else {
            this.pageNo = pageNo;
        }
//        this.pageNo = pageNo == null ? 1 : pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize == null){
            this.pageSize = 10;
        }else {
            this.pageSize = pageSize;
        }

    }
}
