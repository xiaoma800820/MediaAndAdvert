package com.xiaoma.utils;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 数据中心专用日期工具类
 * 提供日期的转换、比较、格式化、获取指定日期
 * 等常用方法
 * Created by mamh on 2017\8\19 0019.
 */
@Slf4j
public class XmDateUtil {

    /**
     * 时间间隔量：日
     */
    private final static int DATE_INTERVAL_DAY = 1;
    /**
     * 时间间隔量：周
     */
    private final static int DATE_INTERVAL_WEEK = 2;
    /**
     * 时间间隔量：月
     */
    private final static int DATE_INTERVAL_MONTH = 3;
    /**
     * 时间间隔量：年
     */
    private final static int DATE_INTERVAL_YEAR = 4;
    /**
     * 时间间隔量：小时
     */
    public final static int DATE_INTERVAL_HOUR = 5;
    /**
     * 时间间隔量：分钟
     */
    public final static int DATE_INTERVAL_MINUTE = 6;
    /**
     * 时间间隔量：秒
     */
    private final static int DATE_INTERVAL_SECOND = 7;

    /**
     * 时间格式：年月日  日期
     */
    public final static String DATE_FORMAT_YMD = "yyyy-MM-dd";
    /**
     * 时间格式：年月
     */
    public final static String DATE_FORMAT_YM ="yyyy-MM";
    /**
     * 时间格式：年月日时分秒 日期+时间
     */
    public final static String DATE_FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期类型转换格式
     */
    private static final String[] parsePatterns = new String[] {
            "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss",
            "MM-dd", "MMdd",
            "yyyy-MM-dd", "yyyyMMdd",
            "yyyy-MM", "yyyyMM",
            "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd", "yyyy/MM",
            "yyyy-MM-dd HH:mm:ss.SSS", "yyyy/MM/dd HH:mm:ss.SSS"
    };

    /**
     * 时间类型转换为字符串类型
     * @param date 时间
     * @param dateFormat 格式类型
     * @return 字符串格式类型参数
     */
    public static String dateFormat(Date date, String dateFormat) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

    /**
     * 字符串类型转换到日期类型
     * 指定转换格式
     * @param date 时间参数
     * @param dateFormat  转换格式
     * @return 日期类型
     */
    public static Date dateFormat(String date, String dateFormat) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        try {
            return format.parse(date);
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    /**
     * 时间格式的调整
     * 从某一种格式转换为另一种格式
     * @param date 时间
     * @param dateFormat 格式
     * @return 指定格式的时间
     */
    public static Date getDate(Date date, String dateFormat) {
        return dateFormat(dateFormat(date, dateFormat), dateFormat);
    }

    /**
     * 获取时间类型的年月日格式的当前时间
     * @return 年月日格式的时间
     */
    public static Date getNowDate() {
        return dateFormat(dateFormat(new Date(), DATE_FORMAT_YMD), DATE_FORMAT_YMD);
    }

    /**
     * 获取当前日期的格式年月日字符串类型
     * @return 字符串
     */
    public static String getNowStringDate() {
        return dateFormat(new Date(), DATE_FORMAT_YMD);
    }

    /**
     * 时间类型 年月日时分秒格式当前时间
     * @return 时间类型
     */
    public static Date getNowTime() {
        return dateFormat(dateFormat(new Date(), DATE_FORMAT_YMDHMS), DATE_FORMAT_YMDHMS);
    }

    /**
     * 年月日时分秒格式当前时间字符串类型
     * @return 字符串类型
     */
    public static String getNowStringTime() {
        return dateFormat(new Date(), DATE_FORMAT_YMDHMS);
    }

    /**
     * 获取的明天的时间年月日
     * @return 明天的时间
     */
    public static Date getTomorrowDate(){
        return  dateAdd(DATE_INTERVAL_DAY, getNowDate(),1);
    }

    /**
     * 获取年月日明天的日期
     * @return 字符型
     */
    public static String getTomorrowStringDate() {
        return dateFormat(getTomorrowTime(), DATE_FORMAT_YMD);
    }

    /**
     * 获取明天的时间 日期+时分秒
     * @return 日期类型
     */
    public static Date getTomorrowTime() {
        return dateAdd(DATE_INTERVAL_DAY, getNowTime(), 1);
    }

    /**
     * 获取昨天的日期 年月日类型
     * @return 日期类型
     */
    public static Date getYesterdayDate() {
        return dateAdd(DATE_INTERVAL_DAY, getNowDate(), -1);
    }

    /**
     * 获取指定时间所在月第一天 年月日格式
     * @param date 日期类型参数
     * @return 日期类型
     */
    public static Date getFirst(Date date) {
        Calendar firstDate = Calendar.getInstance();
        firstDate.setTime(date);
        firstDate.set(Calendar.DATE, 1); // 设为月初
        return getDate(firstDate.getTime(), DATE_FORMAT_YMD);
    }

    /**
     * 获取当月的第一天 年月日格式
     * @return 日期类型
     */
    public static Date getMonthFirst() {
        Calendar firstDate = Calendar.getInstance();
        firstDate.set(Calendar.DATE, 1); // 设为月初
        return getDate(firstDate.getTime(), DATE_FORMAT_YMD);
    }

    /**
     * 获取指定日期所在月的最后一天
     * @param date 日期类型
     * @return 日期类型
     */
    public static Date getLast(Date date) {
        date = dateAdd(DATE_INTERVAL_MONTH, date, 1); // 获得该日期下月的今天
        Date nextMonthFirst = getFirst(date); // 获得该日期下月初
        return getYesterMonthLast(nextMonthFirst); // 下月初-1得到上月末
    }

    /**
     * 获取上月的最后天，根据当前月的第一天
     * @param date 指定日期类型的所属月第一天
     * @return 日期类型
     */
    public static Date getYesterMonthLast(Date date) {
        return dateAdd(DATE_INTERVAL_DAY, date, -1);
    }

    /**
     * 获取下一个月的第一天 年月日格式
     * @return 日期类型
     */
    public static Date getNextMonthFirst() {
        Calendar lastDate = Calendar.getInstance();
        lastDate.add(Calendar.MONTH, 1); // 加一个月
        lastDate.set(Calendar.DATE, 1);  // 把日期设置为当月第一天
        return getDate(lastDate.getTime(), DATE_FORMAT_YMD);
    }

    /**
     * 获取本周周几的时间 年月日格式
     * @param addDay 周几顺序 1~7
     * @return 日期类型
     */
    public static Date getDayOfWeek(int addDay) {
        Calendar c = Calendar.getInstance();
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0) {day_of_week = 7;}
        c.add(Calendar.DATE, -day_of_week + addDay);
        return getDate(c.getTime(), DATE_FORMAT_YMD);
    }

    /**
     * 获取本周周一时间 年月日格式
     * @return 日期类型
     */
    public static Date getMondayOfThisWeek() {
        return getDayOfWeek(1);
    }

    /**
     * 获取本周周日
     * @return 日期类型
     */
    public static Date getSundayOfThisWeek() {
        return getDayOfWeek(7);
    }

    /**
     * 获取下周一
     * @return 日期类型
     */
    public static Date getMondayOfNextWeek() {
        return getDayOfWeek(8);
    }

    /**
     * 获取下周日
     * @return 日期类型
     */
    public static Date getSundayOfNextWeek() {
        return getDayOfWeek(14);
    }

    /**
     * 获取上周一
     * @return 日期类型
     */
    public static Date getMondayOfLastWeek() {
        return getDayOfWeek(-6);
    }
    /**
     * 获取上周日
     * @return 日期类型
     */
    public static Date getSundayOfLastWeek() {
        return getDayOfWeek(0);
    }

    /**
     *获取指定时间 星期几
     * @param date 时间
     * @return 星期几
     */
    public static String getWeekOfDate(Date date) {
        if (date == null) {
            return null;
        }
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }

    /**
     * 获取指定时间是星期几
     * @param date 时间
     * @return
     */
    public static int getWeekNoOfDate(Date date) {
        if (date == null){ return 0;}
        int[] weekDays = {7, 1, 2, 3, 4, 5, 6};
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0){ w = 0;}
        return weekDays[w];
    }

    /**
     * 时间是否是今天
     * @param date 时间
     * @return 布尔
     */
    public static boolean isToday(Date date) {
        if (date == null) {return false;}
        return getNowStringDate().equals(dateFormat(date, DATE_FORMAT_YMD));
    }

    /**
     * 时间是否是昨天
     * @param date 时间
     * @return 布尔
     */
    public static boolean isYesterday(Date date){
        if (date == null) {return false;}
        return dateFormat(getYesterdayDate(), DATE_FORMAT_YMD).equals(dateFormat(date, DATE_FORMAT_YMD));
    }

    /**
     * 时间是否合法
     * @param date 时间
     * @param dateFormat 时间格式
     * @return 布尔类型
     */
    public static boolean isValidDate(String date, String dateFormat) {
        try {
            new SimpleDateFormat(dateFormat).parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * 时间的加法
     * 以时间间隔类型匹配 加项
     * @param interval
     * @param date
     * @param num
     * @return
     */
    public static Date dateAdd(int interval, Date date, int num) {
        if (date == null) {return null;}
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (interval) {
            case DATE_INTERVAL_DAY:
                calendar.add(Calendar.DATE, num);
                break;
            case DATE_INTERVAL_WEEK:
                calendar.add(Calendar.WEEK_OF_MONTH, num);
                break;
            case DATE_INTERVAL_MONTH:
                calendar.add(Calendar.MONTH, num);
                break;
            case DATE_INTERVAL_YEAR:
                calendar.add(Calendar.YEAR, num);
                break;
            case DATE_INTERVAL_HOUR:
                calendar.add(Calendar.HOUR, num);
                break;
            case DATE_INTERVAL_MINUTE:
                calendar.add(Calendar.MINUTE, num);
                break;
            case DATE_INTERVAL_SECOND:
                calendar.add(Calendar.SECOND, num);
                break;
            default:
        }
        return calendar.getTime();
    }

    /**
     * 两个日期的时间差 保留两位小数，等级标准的差额
     * @param interval 返回时间等级(1:返回天;2:返回天-小时;3:返回天-小时-分4:返回天-小时-分-秒;)
     * @param date  时间
     * @param compare 比较时间
     * @return double类型
     */
    public static double getDateDiff(int interval, Date date, Date compare) {
        if (date == null || compare == null) {
            return 0;
        }
        double result = 0;
        double time = 0;
        Calendar calendar = null;
        switch (interval) {
            case DATE_INTERVAL_DAY:
                time = date.getTime() - compare.getTime();
                result = time / 1000d / 60d / 60d / 24d;
                break;
            case DATE_INTERVAL_HOUR:
                time = date.getTime() - compare.getTime();
                result = time / 1000d / 60d / 60d;
                break;
            case DATE_INTERVAL_MINUTE:
                time = date.getTime() / 1000d / 60d;
                result = time - compare.getTime() / 1000d / 60d;
                break;
            case DATE_INTERVAL_MONTH:
                calendar = Calendar.getInstance();
                calendar.setTime(date);
                time = calendar.get(Calendar.YEAR) * 12d;
                calendar.setTime(compare);
                time -= calendar.get(Calendar.YEAR) * 12d;
                calendar.setTime(date);
                time += calendar.get(Calendar.MONTH);
                calendar.setTime(compare);
                result = time - calendar.get(Calendar.MONTH);
                break;
            case DATE_INTERVAL_SECOND:
                time = date.getTime() - compare.getTime();
                result = time / 1000d;
                break;
            case DATE_INTERVAL_WEEK:
                calendar = Calendar.getInstance();
                calendar.setTime(date);
                time = calendar.get(Calendar.YEAR) * 52d;
                calendar.setTime(compare);
                time -= calendar.get(Calendar.YEAR) * 52d;
                calendar.setTime(date);
                time += calendar.get(Calendar.WEEK_OF_YEAR);
                calendar.setTime(compare);
                result = time - calendar.get(Calendar.WEEK_OF_YEAR);
                break;
            case DATE_INTERVAL_YEAR:
                calendar = Calendar.getInstance();
                calendar.setTime(date);
                time = calendar.get(Calendar.YEAR);
                calendar.setTime(compare);
                result = time - (double)calendar.get(Calendar.YEAR);
                break;
            default:
                break;
        }
        return new BigDecimal(result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 两个时间差，返回字符串 按等级返回
     * @param level 等级1:返回天;2:返回天-小时;3:返回天-小时-分4:返回天-小时-分-秒;
     * @param date 时间
     * @param compare 比较时间
     * @return 字符串
     */
    public static String getDateBetween(Integer level, Date date, Date compare) {
        if (date == null || compare == null) {
            return null;
        }
        long s = new BigDecimal(getDateDiff(DATE_INTERVAL_SECOND, date, compare)).setScale(2, BigDecimal.ROUND_HALF_UP).longValue();
        int ss = 1;
        int mi = ss * 60;
        int hh = mi * 60;
        int dd = hh * 24;

        long day = s / dd;
        long hour = (s - day * dd) / hh;
        long minute = (s - day * dd - hour * hh) / mi;
        long second = (s - day * dd - hour * hh - minute * mi) / ss;
        String flag =(day < 0 || hour < 0 || minute < 0 || second < 0) ? "-" : "";
        day = Math.abs(day);
        hour = Math.abs(hour);
        minute = Math.abs(minute);
        second = Math.abs(second);
        StringBuilder result = new StringBuilder(flag);
        switch (level) {
            case 1:
                if (day != 0) {
                    result.append(day).append("天");
                }
                break;
            case 2:
                if (day != 0) {
                    result.append(day).append("天");
                }
                if (hour != 0) {
                    result.append(hour).append("小时");
                }
                break;
            case 3:
                if (day != 0) {
                    result.append(day).append("天");
                }
                if (hour != 0) {
                    result.append(hour).append("小时");
                }
                if (minute != 0) {
                    result.append(minute).append("分");
                }
                break;
            case 4:
                if (day != 0) {
                    result.append(day).append("天");
                }
                if (hour != 0) {
                    result.append(hour).append("小时");
                }
                if (minute != 0) {
                    result.append(minute).append("分");
                }
                if (second != 0) {
                    result.append(second).append("秒");
                }
                break;
            default:
                break;
        }
        return result.toString();
    }
}
