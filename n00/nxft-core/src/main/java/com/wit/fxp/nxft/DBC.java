package com.wit.fxp.nxft;

import java.util.Date;

import com.wit.fxp.nxft.utils.DateUtils;

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

    public enum 助餐订单状态 {
        初始("初始"),
        已派单("已派单"),
        已接单("已接单"),
        已配送("已配送"),
        已取消("已取消");
        private final String value;

        助餐订单状态(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum 助餐订单动作 {
        派单("NEW", "派单"),
        接单("ACCEPT", "接单"),
        配送("DELIVE", "配送"),
        取消("CANCEL", "取消");

        private final String nodeId;
        private final String nodeName;

        助餐订单动作(String nodeId, String nodeName) {
            this.nodeId = nodeId;
            this.nodeName = nodeName;
        }

        public String nodeId() {
            return nodeId;
        }

        public String nodeName() {
            return nodeName;
        }

        /**
         * @param nodeId
         * @return
         */
        public static 助餐订单动作 of(String nodeId) {
            助餐订单动作[] all = 助餐订单动作.values();
            for (助餐订单动作 e : all) {
                if (e.nodeId.equals(nodeId)) {
                    return e;
                }
            }

            throw new IllegalArgumentException("未知的助餐订单环节ID：" + nodeId);
        }
    }

    public static final Date BEGINTIME = DateUtils.parseLongDate("1949-10-01 00:00:00");
    public static final Date ENDTIME = DateUtils.parseLongDate("3000-10-01 00:00:00");

    public enum 订单统计类型 {
        当天订餐("TheDAY"),
        本周订餐("TheWEEK"),
        本月订餐("ThewMONTH");

        private final String value;

        订单统计类型(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 对象统计类型 {
        本周新增对象("NewInWeek"),
        总计("Count");

        private final String value;

        对象统计类型(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 排班周期模式 {
        周("WEEK"),
        月("MONTH");

        private final String value;

        排班周期模式(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 配送订单状态  {
        已接单("已接单"),
        已配送("已配送"),
        已送达("已送达");

        private final String value;

        配送订单状态(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 配送方式 {
        助餐点("SITE"),
        到户("HOME");

        private final String value;

        配送方式(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }

        public static 配送方式 of(String value) {
            配送方式[] all = 配送方式.values();
            for (配送方式 e : all) {
                if (e.value.equals(value)) {
                    return e;
                }
            }

            throw new IllegalArgumentException("未知的配送方式ID：" + value);
        }
    }

    public enum 助餐点数据墙选项 {
        概况("Survey"),
        点餐("Order"),
        查询("query");

        private final String value;

        助餐点数据墙选项(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 餐别 {
        早餐("1"),
        午餐("2"),
        晚餐("3");

        private final String value;

        public static 餐别 of(String value) {
            餐别[] all = 餐别.values();
            for (餐别 e : all) {
                if (e.value.equals(value)) {
                    return e;
                }
            }

            throw new IllegalArgumentException("未知的餐别ID：" + value);
        }

        餐别(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 短信业务 {
        坐席订餐("坐席订餐"),
        助餐点订餐("助餐点订餐"),
        充值("充值"),
        撤销充值("撤销充值");

        private final String value;

        短信业务(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
