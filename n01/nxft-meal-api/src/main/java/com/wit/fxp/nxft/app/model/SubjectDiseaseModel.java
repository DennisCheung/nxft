package com.wit.fxp.nxft.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectDiseaseModel {

    private String id;

    /** 2. [不可空] 疾病id */
    private String diseaseId;

    /** 3. [不可空] 疾病名称 */
    private String diseaseName;

    /** 4. [不可空] 对象id */
    private String subjectId;

    /** 5. [可空] 备注 */
    private String diseaseDesc;
}
