package com.xiaoma.exception;


import com.xiaoma.utils.ResultCodes;

/**
 * 应用异常类
 * @author mmh
 */
public class GlobalException extends RuntimeException{

    private ResultCodes resultCode;


    public GlobalException() {
        super();
    }

    public GlobalException(ResultCodes resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCodes getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodes resultCode) {
        this.resultCode = resultCode;
    }
}
