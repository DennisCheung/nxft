package com.wit.hnxft.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 助餐点工作站查询对象消费明细模型
 * @author lyb
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class HnxftQuerySubjectOrderModel {

    /** 1. [不可空] 对象id */
    private String subjectId;

    /** 2. [不可空] 对象手机号码 */
    private String mobile;

    /** 3. [不可空] 对象名称*/
    private String subjectName;

    /** 4. [不可空] 余额*/
    private String balance;

    /** 5. [不可空] 消费数量*/
    private int costNum;

    /** 6. [不可空] 自费总计 */
    private double ownExpenseSum;

    /** 7. [不可空] 政府资助总计 */
    private double govCostSum;

    /** 8. [可空] 消费明细 */
    List<HnxftOrderModel> list = new ArrayList<HnxftOrderModel>();
}
