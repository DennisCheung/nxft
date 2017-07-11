package com.wit.hnxft.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 工作组模型
 * @author lyb
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@BuilderCall
public class HnxftTeamModel {

    /** 1. [不可空] 工作组id */
    private String id;

    /** 2. [不可空] 工作组应用id */
    private String appId;

    /** 3. [不可空] 工作组名称 */
    private String teamName;

    /** 4. [不可空] 工作圈id */
    private String circleId;

    /** 5. [不可空] 是否可用？ */
    private Boolean available;

    /** 6. [可空] 备注 */
    private String teamDesc;

    /** 7. [不可空] 创建时间 */
    private java.util.Date createTime;

    /** 8. [不可空] 创建操作员id */
    private String createUserId;

    /** 9. [不可空] 创建操作员姓名 */
    private String createUserName;
}
