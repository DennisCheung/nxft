package com.wit.hnxft.command;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 下订单
 *
 * @author lyb
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddOrderCommand {

    /** 1. [不可空] 客户id */
    private String personId;

    /** 2. [不可空] 明细 */
    private List<AddOrderCommandDetails> commands = new ArrayList<AddOrderCommandDetails>();

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @BuilderCall
    public static class AddOrderCommandDetails {

        /** 1. [不可空] 助餐点id */
        private String teamId;

        /** 2. [不可空] 订餐日期 */
        private String mealDate;

        /** 3. [不可空] 餐别id */
        private String mealTypeId;

        /** 4. [不可空] 套餐id */
        private String mealId;
    }
}
