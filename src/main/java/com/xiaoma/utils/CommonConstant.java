package com.xiaoma.utils;


import java.util.Random;
import java.util.UUID;

/**
 * 常用的公用的工具类
 * @author mmh
 * @date 2018/6/6
 */
public class CommonConstant {


    private CommonConstant(){
        //私有方法安全保证
    }

    /**
     * 标准常量值
     */
    public static final int STANDARD_ZERO = 0;
    public static final int STANDARD_ONE = 1;
    public static final int STANDARD_TWO = 2;
    public static final int STANDARD_THREE = 3;




    public static final String READER_ADMIN_KEY = "readeradminkey";
    public static final String READER_ADVERT_KEY = "readeradvertkey";
    public static final String READER_MEDIA_KEY = "readermediakey";
    public static final String ADVERTISER_PRE = "GGZ";

    public static final String FILE_URL= "https://innjoe-header-icon.oss-cn-hangzhou.aliyuncs.com";



    /**
     * 个推推送透传消息的类型key
     * 声音色设置,屏幕亮度设置。
     * 广告分配的通知、
     * 强制更新客户机版本的通知。
     */
    public static final String POS_MACHINE_VOICE_SET = "POS_MACHINE_VOICE_SET";
    public static final String POS_MACHINE_SCREEN_SET = "POS_MACHINE_SCREEN_SET";
    public static final String POS_MACHINE_ADVERT_DISTRIBUTE = "POS_MACHINE_ADVERT_DISTRIBUTE";
    public static final String POS_MACHINE_VERSION_FORCE_UPDATE = "POS_MACHINE_VERSION_FORCE_UPDATE";
    public static final String POS_SPIT_PAPER = "POS_SPIT_PAPER";
    public static final String POS_SPIT_PAPER_CHECK = "POS_SPIT_PAPER_CHECK";
    public static final String POS_FILL_PAPER = "POS_FILL_PAPER";




    /**
     * 后端签名签名key
     * 移动端签名Key
     */
    public static final String SIGN_NAME_KEY = "READER";
    public static final String SIGN_MOVE_KEY = "U2FsdGVkX18yG2ZPbHwWmaUIGXIY72kp2gOIueBXYIs=";


    /**
     * 生成UUID唯一不重复字符串
     */
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }

    /**
     * 获取1到num之间的随机数
     * @param num 区间
     * @return 随机整数
     */
    public static int getRandRangeNumBer(int num){
        Random rand = new Random();
        return rand.nextInt(num) + 1;
    }

    /**
     * 获取8位验证码
     * @return 验证码字符串
     */
    public static String getSmsRandomCode(){
        String sources = "0123456789";
        Random rand = new Random();
        StringBuffer flag = new StringBuffer();
        for (int i = 0; i < 8;i++){
            flag.append(sources.charAt(rand.nextInt(9)) + "");
        }
        return flag.toString();
    }

    /**
     * 获取编码组织的位数
     * @param codePrefix 编码前缀
     * @param digits 位数
     * @param currentNum 当前数字
     * @return 重新编码结果
     */
    public static String getCodeId(String codePrefix,int digits,int currentNum){
        currentNum = currentNum + 1;
        if (currentNum < 10){
            codePrefix = codePrefix + "000";
        }else if (currentNum < 100){
            codePrefix = codePrefix + "00";
        }else if (currentNum < 1000){
            codePrefix = codePrefix + "0";
        }
        String nextCodeId = codePrefix + currentNum;
        return nextCodeId;
    }
}
