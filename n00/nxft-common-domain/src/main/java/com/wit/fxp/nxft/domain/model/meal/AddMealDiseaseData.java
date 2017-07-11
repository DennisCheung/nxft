package com.wit.fxp.nxft.domain.model.meal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddMealDiseaseData {
    /** 2. [不可空] 疾病id */
    private String diseaseId;

    /** 3. [不可空] 疾病名称 */
    private String diseaseName;

    /** 5. [可空] 备注 */
    private String diseaseDesc;
}
