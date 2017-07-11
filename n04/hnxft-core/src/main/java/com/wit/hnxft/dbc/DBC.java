package com.wit.hnxft.dbc;

/**
 * 数据库常量。
 *
 * @author lyb
 *
 */
public class DBC {

    public enum 子系统 {
        助餐点工作站("ZCDGZZ"),
        定餐工作站("DCGZZ"),
        配餐工作站("PCGZZ");

        private final String value;

        子系统(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
