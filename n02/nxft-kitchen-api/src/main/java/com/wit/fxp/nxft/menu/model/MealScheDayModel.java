package com.wit.fxp.nxft.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MealScheDayModel {
    private String id;

    /** 2. [不可空] 厨房工作圈id */
    private String kitchenCircleId;

    /** 2.1. [不可空] 厨房teamid */
    private String kitchenTeamId;

    /** 3. [不可空] 排班单id */
    private String schenoteId;

    /** 4. [不可空] 就餐日期 */
    private java.util.Date mealDate;

    /** 5. [不可空] 周几 */
    private Integer week;

    /** 6. [不可空] 餐别ID */
    private String mealTypeId;

    /** 7. [不可空] 餐别名称 */
    private String mealTypeName;

    /** 8. [不可空] 套餐id */
    private String mealId;

    /** 9. [不可空] 套餐CODE */
    private String mealCode;

    /** 10. [不可空] 套餐名称 */
    private String mealName;

    /** 11. [可空] 套餐内容 */
    private String mealContent;

    /** 12. [不可空] 单价 */
    private Double mealPrice;

    /** 13. [可空] 备注 */
    private String scheduleDesc;

    /** 14. [不可空] 是否已发布？ Y/N */
    private Boolean isPublished;
}
