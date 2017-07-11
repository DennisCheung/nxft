package com.wit.fxp.nxft.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectTypeModel {

    private String id;

    /** 2. [不可空] 对象类型CODE */
    private String subjectTypeCode;

    /** 3. [不可空] 对象类型名称 */
    private String subjectTypeName;

    /** 4. [不可空] 是否可用？ */
    private Boolean available;

    /** 5. [可空] 备注 */
    private String subjectTypeDesc;
}
