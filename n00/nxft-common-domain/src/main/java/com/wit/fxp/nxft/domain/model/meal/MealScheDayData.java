package com.wit.fxp.nxft.domain.model.meal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MealScheDayData {
    /** 4. [不可空] 就餐日期 */
    private java.util.Date mealDate;

    /** 5. [不可空] 周几 */
    private Integer week;

    /** 6. [不可空] 餐别ID */
    private String mealTypeId;

    /** 7. [不可空] 餐别名称 */
    private String mealTypeName;

    /** 8. [不可空] 菜谱id */
    private String mealId;

    /** 9. [不可空] 菜谱CODE */
    private String mealCode;

    /** 10. [不可空] 菜谱名称 */
    private String mealName;

    /** 11. [可空] 套餐内容 */
    private String mealContent;

    /** 12. [不可空] 单价 */
    private Double mealPrice;

    /** 13. [可空] 备注 */
    private String scheduleDesc;
}
