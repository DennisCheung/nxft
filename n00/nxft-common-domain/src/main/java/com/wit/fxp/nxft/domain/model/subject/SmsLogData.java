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
public class SmsLogData {

    private IdAndName subject;

    private String tspName;

    private String smsContent;

    private String smsDesc;

    private String toNumber;

    private String toName;

}
