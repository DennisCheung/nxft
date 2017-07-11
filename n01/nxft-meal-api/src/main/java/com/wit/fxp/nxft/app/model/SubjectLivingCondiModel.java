package com.wit.fxp.nxft.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectLivingCondiModel {

    private String id;

    /** 2. [不可空] 居住情况ID */
    private String livingCondiId;

    /** 3. [不可空] 居住情况名称 */
    private String livingCondiName;

    /** 4. [不可空] 是否是其他项 Y/N  其他项需手工输入备注 */
    private Boolean isother;

    /** 5. [不可空] 对象id */
    private String subjectId;

    /** 6. [可空] 备注 */
    private String livingCondiDesc;
}
