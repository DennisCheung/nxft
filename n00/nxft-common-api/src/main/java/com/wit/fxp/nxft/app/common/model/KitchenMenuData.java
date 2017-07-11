package com.wit.fxp.nxft.app.common.model;

import java.util.List;

import com.wit.datatype.IdAndName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class KitchenMenuData {

    private IdAndName mealType;

    private List<OptionData> datas;
}
