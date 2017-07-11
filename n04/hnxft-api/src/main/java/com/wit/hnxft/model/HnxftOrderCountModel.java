package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 订单统计模型
 * @author lyb
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class HnxftOrderCountModel {

    /** 1. [不可空] 当天订餐*/
    private int dayCount;

    /** 2. [不可空] 当周订餐*/
    private int weekCount;

    /** 3. [不可空] 当月订餐*/
    private int monthCount;

}
