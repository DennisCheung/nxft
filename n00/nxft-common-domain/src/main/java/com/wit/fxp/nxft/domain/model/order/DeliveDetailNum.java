package com.wit.fxp.nxft.domain.model.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class DeliveDetailNum {

    private String mealTypeId;

    private Integer quanlity;
}
