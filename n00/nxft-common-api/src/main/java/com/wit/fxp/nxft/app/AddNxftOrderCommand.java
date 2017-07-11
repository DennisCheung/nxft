package com.wit.fxp.nxft.app;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 下单。
 *
 * @author qiuxu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddNxftOrderCommand {

    private Date mealDate; //订餐日期。

    private String mealTypeId; //餐别。

    private String mealId; //套餐id。
}
