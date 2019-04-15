package com.xiaoma.exception;

import com.xiaoma.utils.ResultCodes;
import com.xiaoma.utils.RetInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一的异常处理类
 * @author mmh
 * @date 2018/7/9
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public RetInfo handle(Exception e){
        RetInfo retInfo = new RetInfo();
        if (e instanceof GlobalException){
            GlobalException globalException = (GlobalException) e;
            retInfo.setResultCodes(globalException.getResultCode());
            log.error("===exception print >>>" + retInfo.toString());
            return  retInfo;
        }else {
            //将系统异常以打印出来
            log.error("============[系统异常]{}>>>>>>>>>>>",e);
            retInfo.setResultCodes(ResultCodes.SYS_EXCEPTION);
            return retInfo;
        }
    }
}
