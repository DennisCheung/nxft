package com.wit.fxp.nxft.menu.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class MealSetModel {
    private String id;

    /** 2. [不可空] 套餐CODE */
    private String mealCode;

    /** 3. [不可空] 套餐名称 */
    private String mealName;

    /** 4. [不可空] 套餐内容 */
    private String mealContent;

    /** 5. [可空] 禁忌疾病，名称逗号分隔 */
    private String tabooDisease;

    /** 6. [可空] 辣度 */
    private Integer pepperyLevel;

    /** 7. [不可空] 单价 */
    private Double mealPrice;

    /** 8. [可空] 最新图片id */
    private String photoId;

    /** 9. [不可空] 厨房圈id */
    private String kitchenCircleId;

    /** 10. [不可空] 是否可用？ */
    private Boolean available;

    /** 11. [可空] 备注 */
    private String mealDesc;

    /** 19. [不可空] 厨房teamid */
    private String kitchenTeamId;

    private Date logcdate;

    private List<MealDiseaseModel> mealDiseaseSet;
}
