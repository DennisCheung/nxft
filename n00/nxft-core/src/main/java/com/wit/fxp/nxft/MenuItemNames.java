package com.wit.fxp.nxft;

public class MenuItemNames {

    public enum 配餐主界面菜单 {
        菜谱管理("foodMenu"),
        订单管理("foodOrder"),
        配餐管理("compoundFood"),
        订单汇总("orderCollect");

        private final String value;

        配餐主界面菜单(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public enum 助餐主界面菜单 {
        对象管理("subjectMenu"),
        订单管理("mealOrderMenu"),
        充值("rechargeMenu");

        private final String value;

        助餐主界面菜单(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }
}
