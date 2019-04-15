package com.xiaoma.utils;

/**
 * 应用请求响应结果码
 * @author mmh
 * @date 2018/6/6
 */
public enum  ResultCodes {

    SUCCESS(0, "成功"),
    FAILED(-1,"失败"),
    SUCCESS_NO_DATA(1, "查询无数据"),
    PARAMETER_INVALID(2, "参数错误"),
    MOBILE_ERROR(3,"手机号错误"),
    ID_CARD_ERROR(4,"身份证号错误"),
    DATA_ERROR(5, "数据错误或状态信息更改"),



    SYS_EXCEPTION(9999, "系统异常"),
    XXXXX(-10000000, "异常");


    private int code;
    private String message;

    ResultCodes(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
