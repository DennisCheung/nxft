package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HnxtDeliveDetailModel {

    /** 1. [不可空] 配餐单明细id */
    private String id;

    /** 2. [不可空] 套餐id */
    private String mealId;

    /** 3. [不可空] 套餐CODE */
    private String mealCode;

    /** 4. [不可空] 套餐名称 */
    private String mealName;

    /** 5. [不可空] 数量 */
    private Integer quantity;

    /** 6. [可空] 配送单id */
    private String deliveNoteId;
}
