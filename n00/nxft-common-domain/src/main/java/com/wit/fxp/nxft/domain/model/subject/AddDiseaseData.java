package com.wit.fxp.nxft.domain.model.subject;

import com.wit.datatype.IdAndName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class AddDiseaseData {

    private String subjectId;

    private IdAndName disease;

    private String diseaseDesc;

}
