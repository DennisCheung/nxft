package com.wit.fxp.nxft.ui.usermain.block.worktips;

import java.util.Date;

import com.vaadin.ui.Button;
import com.vaadin.ui.Image;

import lombok.Value;
import lombok.experimental.BuilderCall;

@Value
@BuilderCall
public class MealWorkTipsModel {
    private String id;
    private Image typeImage;
    private String taskContent;
    private Date taskTime;
    private Button handleBtn;
}
