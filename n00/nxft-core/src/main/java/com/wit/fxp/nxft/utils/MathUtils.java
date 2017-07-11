package com.wit.fxp.nxft.utils;

import java.math.BigDecimal;

public class MathUtils {

    /**
     * 关于java的数学计算精度问题：
     * http://soft.chinabyte.com/database/397/12077897.shtml
     * http://oracle-9i.iteye.com/blog/1103316
     * @param num1
     * @param num2
     * @return
     */
    public static double add2Double(String num1, String num2) {
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        return b1.add(b2).doubleValue();
    }

    public static double substract2Double(String num1, String num2) {
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        return b1.subtract(b2).doubleValue();
    }

    public static double multiply2Double(String num1, String num2) {
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        return b1.multiply(b2).doubleValue();
    }

    /**
     *  默认为四舍五入模式
     * @param num1 被除数
     * @param num2 除数
     * @param scale 精度，小数点
     * @return
     */
    public static double divide2Double(String num1, String num2, int scale) {
        BigDecimal b1 = new BigDecimal(num1);
        BigDecimal b2 = new BigDecimal(num2);
        return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**  四舍五入 */
    public static double roundHalfUp(Double num1, int newScale) {
        BigDecimal b1 = new BigDecimal(num1);
        return b1.setScale(newScale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
