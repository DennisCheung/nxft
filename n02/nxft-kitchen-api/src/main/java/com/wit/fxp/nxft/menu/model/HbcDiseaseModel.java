package com.wit.fxp.nxft.menu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class HbcDiseaseModel {
    private String id;

    /** 2. [不可空] 常见疾病代码 */
    private String diseaseCode;

    /** 3. [可空] 国标代码 */
    private String diseaseGbcode;

    /** 4. [不可空] 居住情况名称 */
    private String diseaseName;

    /** 5. [不可空] 是否是其他项 Y/N  其他项需手工输入备注 */
    private Boolean isother;

    /** 6. [不可空] 是否可用？ */
    private Boolean available;

    /** 7. [不可空] 排序号 */
    private Double ordernum;

    /** 8. [可空] 备注 */
    private String diseaseDesc;
}
