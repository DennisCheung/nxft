package com.wit.fxp.nxft.ui.block.subject;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.BuilderCall;

@Data
@AllArgsConstructor
@NoArgsConstructor
@BuilderCall
public class SubjectViewModel {

    private String subjectId;

    private String name;

    private String gender;

    private String age;

    private String idNo;

    private String type;

    private String phone;

    private String sendType;

    private Label address;

    private HorizontalLayout hand;

}
