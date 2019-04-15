package com.xiaoma.utils;



import com.xiaoma.exception.GlobalException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请求参数安全校验
 * @author mmh
 * @date 2018/7/9
 */
@Slf4j
public class ParamCheckUtil {

    private ParamCheckUtil() {
    }

    /**
     * 校验一个参数对象不能为null
     * @param o 参数对象
     */
    public static void validParamObjectNull(Object o) {
        if(o == null) {
            log.error("*SERVICE_ERROR* param is null");
            throw new GlobalException(ResultCodes.PARAMETER_INVALID);
        }
    }

    /**
     * 校验一个字符参数不能为Null且不能为空字符串
     * @param param 参数
     */
    public static void validParamStrNotNull(String param) {
        if(StringUtils.isEmpty(param)) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.PARAMETER_INVALID);
        }
    }

    /**
     * 校验一个整型参数值是0或者是1
     * @param status 参数值
     */
    public static void validStatusParamIsZeroAndOne(Integer status) {
        if(status == null || status.intValue() < 0 || status.intValue() > 1) {
            log.error("*SERVICE_ERROR* param status is {} out of defined", status);
            throw new GlobalException(ResultCodes.PARAMETER_INVALID);
        }
    }

    /**
     * 校验一个参数值大于等于0
     * @param param 参数
     */
    public static void validParamNotNullAndThanEqualZero(Integer param) {
        if(param == null || param.intValue() < 0) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.PARAMETER_INVALID);
        }
    }

    /**
     * 校验一个参数值大于0
     * @param param 参数
     */
    public static void validParamNotNullAndThanZero(Long param) {
        if(param == null || param.intValue() < 0) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.PARAMETER_INVALID);
        }
    }


    public static void validValueNotNullAndThanEqualZero(Integer param) {
        if(param == null || param.intValue() < 0) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.DATA_ERROR);
        }
    }

    public static void validValueBetweenZeroToTwo(Integer param) {
        if(param == null || param.intValue() < CommonConstant.STANDARD_ZERO || param.intValue() > CommonConstant.STANDARD_TWO) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.DATA_ERROR);
        }
    }

    public static void validValueNotNullAndThanZero(Long param) {
        if(param == null || param.longValue()< 0L) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.DATA_ERROR);
        }
    }





    public static void validValueNotNull(String param) {
        if(StringUtils.isEmpty(param)) {
            log.error("*SERVICE_ERROR* param is {}", param);
            throw new GlobalException(ResultCodes.DATA_ERROR);
        }
    }

    public static void validStatusIsZeroAndOne(Integer status) {
        if(status == null || status.intValue() < 0 || status.intValue() > 1) {
            log.error("*SERVICE_ERROR* status is {} out of defined", status);
            throw new GlobalException(ResultCodes.DATA_ERROR);
        }
    }





    public static void validObjectListNull(List o) {
        if(o == null || o.size() == 0) {
            log.error("*SERVICE_ERROR* param is null");
            throw new GlobalException(ResultCodes.DATA_ERROR);
        }
    }



    public static boolean validListNullAndSize0(List<?> list) {
        return list == null || list.size() == 0;
    }

    /**
     * 校验手机号是否正确
     * @param param 手机号
     */
    public static void validMobilePhone(String param){
        //符合手机号的正则表达式
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (param == null || param.length() != 11){
            log.error("===手机号为null，或长度不正确===");
            throw new GlobalException(ResultCodes.MOBILE_ERROR);
        }else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(param);
            boolean isMatch = m.matches();
            if (!isMatch){
                log.error("===手机号不符合===");
                throw new GlobalException(ResultCodes.MOBILE_ERROR);
            }
        }
    }

    /**
     * 检查身份证号格式
     * @param param 身份证号
     */
    public static void validIDNumber(String param){
        String reg = "^\\d{15}$|^\\d{17}[0-9Xx]$";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(param);
        boolean isMatch = m.matches();
        if (!isMatch){
            log.error("===身份证号格式不符合===");
            throw new GlobalException(ResultCodes.ID_CARD_ERROR);
        }
    }

//    public static void main(String args[]){
//        int mnyNum = (int) Math.round(0.1);
//        System.out.println("=============" + mnyNum);
//    }
    
}
