package com.wit.fxp.nxft.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author wd
 * @version 创建时间：2014-3-10 下午3:17:26
 * @declare
 */

public class DateUtils {
    private static String[] mweekDays = {"日", "一", "二", "三", "四", "五", "六"};

    public static String getChineseWeekDay(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        int w = cl.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return mweekDays[w];
    }

    /**
     * 获取标准的中国时间,格式：yyyy-MM-dd hh:mm:ss
     * @return 已格式化的时间
     */
    public static String getLongDate(Date date) {
        return date == null ? null : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(date);
    }

    /**
     * 获取标准的中国时间,格式：yyyy-MM-dd
     * @param date 需要格式化的时间对象
     * @return 已格式化的时间
     */
    public static String getShortDate(Date date) {
        return date == null ? null : new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date);
    }

    /**
     * 获取标准的中国时间,格式：yyyy年MM月dd日
     * @param date 需要格式化的时间对象
     * @return 已格式化的时间
     */
    public static String getChineseShortDate(Date date) {
        return date == null ? null : new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault()).format(date);
    }

    /**
     * 将长日期格式字符串转换为日期  yyyy-MM-dd HH:mm:ss
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date parseLongDate(String dateString) {
        String sfmtString = "yyyy-MM-dd HH:mm:ss";
        try {
            return new SimpleDateFormat(sfmtString, Locale.getDefault()).parse(dateString);
        }
        catch (ParseException e) {
            throw new RuntimeException("无法解析日期，输入的日期[ " + dateString + " ]需转成格式[ " + sfmtString + " ]");
        }
    }

    /**
     * 将长日期格式字符串转换为日期  yyyy-MM-dd
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date parseShortDate(String dateString) {
        String sfmtString = "yyyy-MM-dd";
        try {
            return new SimpleDateFormat(sfmtString, Locale.getDefault()).parse(dateString);
        }
        catch (ParseException e) {
            throw new RuntimeException("无法解析日期，输入的日期[ " + dateString + " ]需转成格式[ " + sfmtString + " ]");
        }
    }

    /**
     * 获取指定时间的标准起始时间,格式：yyyy-MM-dd 00:00:00
     * @param date 需要格式化的时间对象
     * @return 已格式化的时间
     */
    public static Date getBegin(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定时间的标准结束时间,格式:yyyy-MM-dd 23:59:59
     *
     * @return 已格式化的时间
     */
    public static Date getEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 将短格式自动补齐为 23:59:59
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static Date parseShortDateEndDay(String dateString) {
        String sfmtString = "yyyy-MM-dd HH:mm:ss";
        try {
            return new SimpleDateFormat(sfmtString, Locale.getDefault()).parse(dateString + " 23:59:59");
        }
        catch (ParseException e) {
            throw new RuntimeException("无法解析日期，输入的日期[ " + dateString + " ]需转成格式[ " + sfmtString + " ]");
        }
    }

    /**
     * 将时间转换成中文形式
     */
    public static String dateToCN(Date date) {
        if (null == date) {
            return null;
        }
        String[] array = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十",
                "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十", "二十一",
                "二十二", "二十三", "二十四", "二十五", "二十六", "二十七", "二十八", "二十九", "三十", "三十一",
                "三十三", "三十三", "三十四", "三十五", "三十六", "三十七", "三十八", "三十九", "四十", "四十一",
                "四十四", "四十四", "四十四", "四十五", "四十六", "四十七", "四十八", "四十九", "五十", "五十一",
                "五十五", "五十五", "五十四", "五十五", "五十六", "五十七", "五十八", "五十九"};

        StringBuffer cn = new StringBuffer();

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cn.append(array[cal.get(Calendar.HOUR_OF_DAY)]);
        cn.append("时");
        cn.append(array[cal.get(Calendar.MINUTE)]);
        cn.append("分");

        return cn.toString();

    }

    /**
     * 返回整数的年龄
     * @param birthday
     * @param nowdate
     * @return
     */
    public static int getAge(Date birthday, Date nowdate) {

        Calendar cal = Calendar.getInstance();
        cal.setTime(nowdate);

        if (cal.before(birthday)) {
            throw new IllegalArgumentException(
                "出生日期不能小于开始计算的日期！");
        }

        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthday);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                //monthNow==monthBirth
                if (dayOfMonthNow < dayOfMonthBirth) {
                    age--;
                }
            }
            else {
                //monthNow>monthBirth
                age--;
            }
        }
        return age;
    }

    /**
     * 检查是否日期
     * @param dateString
     * @return
     */
    public static boolean isDate(String dateString) {
        try {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            fmt.setLenient(false);
            fmt.parse(dateString);
            return true;
        }
        catch (ParseException e) {
            return false;
        }
    }

    /**
     * 以中文方式返回时间差 XX天XX时XX分XX秒
     * @param fmt    时间格式 %s天%s小时%s分%s秒
     * @param beginDate
     * @param endDate
     * @return
     */
    public static String getChineseDateBetween(String fmt, Date begin, Date end) {
        StringBuffer argBuf = new StringBuffer();
        String[] sary = fmt.split("%s");
        long l = (end.getTime() - begin.getTime()) / 1000;  //除以1000是为了转换成秒
        long day1, hour1, min1, second1;

        if (sary.length == 3) {
            // XX分XX秒
            min1 =  l / 60;
            second1 =  l - min1 * 60;
            argBuf.append(min1 + ",");
            argBuf.append(second1);
        }
        else if (sary.length == 4) {
            // XX时XX分XX秒
            hour1 = l / (60 * 60);
            min1 =  l / 60 - hour1 * 60;
            second1 =  l - hour1 * 60 * 60 - min1 * 60;
            argBuf.append(hour1 + ",");
            argBuf.append(min1 + ",");
            argBuf.append(second1);
        }
        else if (sary.length == 2) {
            // XX秒
            argBuf.append(l + ",");
        }
        else {
            day1 = l / (24 * 60 * 60);
            hour1 = (l / (60 * 60) - day1 * 24);
            min1 = ((l / 60) - day1 * 24 * 60 - hour1 * 60);
            second1 = (l - day1 * 24 * 60 * 60 - hour1 * 60 * 60 - min1 * 60);
            argBuf.append(day1 + ",");
            argBuf.append(hour1 + ",");
            argBuf.append(min1 + ",");
            argBuf.append(second1);
        }
        Object[] argary = argBuf.toString().split(",");
        return String.format(fmt, argary);
    }

    public static String getBeginDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:01");
        return sdf.format(date);
    }

    public static String getEndDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
        return sdf.format(date);
    }

    public static Date getWeekTime(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.DAY_OF_MONTH, -7);
        return cd.getTime();
    }

    public static Date getDayTime(Date date) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(date);
        cd.add(Calendar.HOUR_OF_DAY, -24);
        return cd.getTime();
    }

    /**
     * 获取指定时间的标准起始时间,格式：yyyy-MM-dd 00:00:00
     * @param date 需要格式化的时间对象
     * @return 已格式化的时间
     */
    public static Date getBeginTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 获取指定时间的标准结束时间,格式:yyyy-MM-dd 23:59:59
     *
     * @return 已格式化的时间
     */
    public static Date getEndTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 999);
        return cal.getTime();
    }

    /**
     * 指定时间的那一周的第一天。
     *
     * @param date
     * @return
     */
    public static Date getWeekBegin(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int d = 0;
        if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
            d = -6;
        }
        else {
            d = 2 - cal.get(Calendar.DAY_OF_WEEK);
        }
        cal.add(Calendar.DAY_OF_WEEK, d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * 指定时间的那一周的最后一天。
     *
     * @param date
     * @return
     */
    public static Date getWeekEnd(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(getWeekBegin(date));
        cal.add(Calendar.DAY_OF_WEEK, 6);
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        return cal.getTime();
    }

    /**
     * 当前时间所处月的第一天。支持闰年
     * @return
     */
    public static Date getMonthBegin() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 当前时间所处月的最后一天，支持闰年
     * @return
     */
    public static Date getMonthEnd() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        ca.set(Calendar.HOUR_OF_DAY, 23);
        ca.set(Calendar.MINUTE, 59);
        ca.set(Calendar.SECOND, 59);
        return ca.getTime();
    }

    public static String getNextDay(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        Date date = calendar.getTime();
        return sdf.format(date);
    }

    public static String getLastDay(Date now) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        Date date = calendar.getTime();
        return sdf.format(date);
    }

    public static String calcAge(Date currentDate, Date birthDay) {
        if (birthDay == null) {
            return null;
        }
        else {
            String age = getAge(birthDay, currentDate) + "岁";
            return age;
        }
    }
}
