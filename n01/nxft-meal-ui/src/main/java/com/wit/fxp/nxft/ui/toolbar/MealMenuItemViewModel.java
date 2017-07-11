package com.wit.fxp.nxft.ui.toolbar;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class MealMenuItemViewModel {

    private String menuText;
    private String menuName;
    private Consumer<String> cmd;

}
