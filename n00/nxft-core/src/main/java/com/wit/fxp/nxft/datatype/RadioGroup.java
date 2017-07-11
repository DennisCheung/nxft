package com.wit.fxp.nxft.datatype;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

/**
 * 选项组
 * @author qiuxu
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class RadioGroup<T, V> {

    private RadioOption<T> option;

    private List<RadioOption<V>> options;

}
