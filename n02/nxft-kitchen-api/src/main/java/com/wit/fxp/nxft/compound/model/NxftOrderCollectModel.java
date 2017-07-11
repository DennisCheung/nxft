package com.wit.fxp.nxft.compound.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class NxftOrderCollectModel {
    private String id;

    /** [不可空] 就餐日期 */
    private java.util.Date mealDate;

    /** [不可空] 餐别ID */
    private String mealTypeId;

    /** [不可空] 餐别名称 */
    private String mealTypeName;

    /** [不可空] 套餐id */
    private String mealId;

    /** [不可空] 套餐名称 */
    private String mealName;

    /** [不可空] 数量 */
    private Integer quantity;

}
