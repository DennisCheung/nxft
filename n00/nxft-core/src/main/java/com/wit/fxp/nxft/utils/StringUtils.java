package com.wit.fxp.nxft.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public abstract class StringUtils {

    /**
     * 生成uuid
     *
     * @return uuid
     */
    public static String generateUuid() {
        UUID id = UUID.randomUUID();
        String[] array = id.toString().split("-");
        StringBuffer sb = new StringBuffer();
        for (String str : array) {
            sb.append(str.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 判断字符串是否未null或者""
     *
     * @param str
     *            字符串
     * @return 判断结果
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str)) {
            return true;
        }

        return false;
    }

    // 转换成首字母大写。例如把abc转换成Abc。
    public static String capital(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        else {
            return s.substring(0, 1).toUpperCase() + s.substring(1);
        }
    }

    // 转换成首字母小写。例如把Abc转换成abc。
    public static String camel(String s) {
        if (s == null || "".equals(s)) {
            return s;
        }
        else {
            return s.substring(0, 1).toLowerCase() + s.substring(1);
        }
    }

    // 把用特殊符号分割的字符串转换成LIST
    public static List<String> getListFromString(String str, char delimiter) {
        if (str == null) {
            throw new IllegalArgumentException("参数不能为空。");
        }
        else {
            String regex;
            {
                // TODO 其它正则表达式中的特殊符号
                if (delimiter == '.') {
                    regex = "\\.";
                }
                else {
                    regex = String.valueOf(delimiter);
                }
            }

            List<String> results = new ArrayList<String>();
            Collections.addAll(results, str.split(regex));
            return results;
        }
    }

    /**
     * 字符串大于或等于比较。
     *
     * @param s1
     * @param s2
     */
    public static boolean equalsOrGreaterThan(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (i >= s2.length()) {
                break;
            }
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 > c2) {
                return true;
            }
            else if (c1 < c2) {
                return false;
            }
        }

        return s1.length() >= s2.length();
    }

    /** 判断是否为数字, 0 到 9  ， 不能有 + 前缀 */
    public static boolean isNumberic(String numstr) {
        return isPositiveInteger(numstr) || isNegtiveInteger(numstr) || isFloat(numstr);
    }

    /** 匹配非负整数 正整数 或 0 ， 不能有 + 前缀
     * http://tool.oschina.net/regex/#
     */
    public static boolean isPositiveInteger(String numstr) {
        if (!isEmpty(numstr)) {
            return numstr.matches("^[1-9]\\d*|0$");
        }
        else {
            return false;
        }
    }

    /** 匹配非正整数 负整数 或 0 ，前面可以有 - 前缀
     * http://tool.oschina.net/regex/#
     */
    public static boolean isNegtiveInteger(String numstr) {
        if (!isEmpty(numstr)) {
            return numstr.matches("^-[1-9]\\d*|0$");
        }
        else {
            return false;
        }
    }

    /**
     * 匹配浮点数，必须含小数点.
     * @param numstr
     * @return
     */
    public static boolean isFloat(String numstr) {
        if (!isEmpty(numstr)) {
            return numstr.matches("^[1-9]\\d*\\.\\d*|0\\.\\d*[1-9]\\d*$");
        }
        else {
            return false;
        }
    }

    public static String null2Empty(String s) {
        return s == null ? "" : s;
    }

}
