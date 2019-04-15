package com.xiaoma.utils;

import java.io.Serializable;

/**
 * RestFull封装访问结果封装
 * @author mmh
 * @date 2018/6/6
 */
public class RetInfo<T> implements Serializable {

    /**
     * 错误代码 0:成功  其他为异常
     */
    private int code;

    /**
     * 错误详细信息
     */
    private String message = "成功";

    /**
     * 返回的数据，调用失败的是，返回数据为null
     */
    private T data;

    private Long pages;



    public RetInfo() {
    //构造保护
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RetInfo(ResultCodes resultCodes) {
        this.code = resultCodes.getCode();
        this.message = resultCodes.getMessage();
    }

    public void setResultCodes(ResultCodes resultCodes) {
        this.code = resultCodes.getCode();
        this.message = resultCodes.getMessage();
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "RetInfo{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

}
