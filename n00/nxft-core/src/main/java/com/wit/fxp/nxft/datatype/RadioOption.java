package com.wit.fxp.nxft.datatype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 选项
 * @author qiuxu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class RadioOption<T> {

    private String id;

    private String name;

    private T value;

    private String otherDesc;

}
