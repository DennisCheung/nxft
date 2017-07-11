package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HnxftCircleModel {

    /** 1. [不可空] id*/
    private String id;

    /** 2. [不可空] 工作圈名称 */
    private String circleName;

    /** 3. [不可空] 工作圈简称 */
    private String circleShortName;

    /** 4. [不可空] 老板id */
    private String bossId;

    /** 5. [可空] 备注 */
    private String circleDesc;

    /** 6. [不可空] 创建时间 */
    private java.util.Date createTime;

    /** 7. [不可空] 创建操作员id */
    private String createUserId;

    /** 8. [不可空] 创建操作员姓名 */
    private String createUserName;

    /** 9. [不可空] 工作圈所属工作组数量 */
    private int teamNum;

    /** 9. [不可空] 是否工作圈管理员 */
    private Boolean isAdmin;
}
