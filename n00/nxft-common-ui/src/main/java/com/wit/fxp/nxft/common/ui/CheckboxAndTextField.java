package com.wit.fxp.nxft.common.ui;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.common.LayoutUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CheckboxAndTextField extends CustomComponent {

    private static final long serialVersionUID = 1L;

    private final HorizontalLayout horMainLayout = new HorizontalLayout();

    private Boolean isHasOther = false;

    private final CheckBox checkBox = new CheckBox();
    private final TextField other = new TextField();
    private final TextField year = new TextField();
    private final TextField month = new TextField();

    public CheckboxAndTextField() {
        setCompositionRoot(horMainLayout);
        horMainLayout.addStyleName("medicalinput");
        year.setWidth("60px");
        month.setWidth("60px");
    }

    public void addOption(String id, String name, Boolean isHasOther) {
        this.isHasOther = isHasOther;
        checkBox.setId(id);
        checkBox.setCaption(name);
        horMainLayout.addComponent(checkBox);
        if (isHasOther) {
            horMainLayout.addComponent(other);
            checkBox.addValueChangeListener(e -> {
                if (checkBox.getValue()) {
                    other.setReadOnly(false);
                }
                else {
                    other.setReadOnly(true);
                }
            });
        }
        horMainLayout.addComponent(LayoutUtils.getHorLayout("确诊时间", "70px", year, "", month, "", "月", "年"));
    }

    public MedicalInputValue getValue() {
        MedicalInputValue value = new MedicalInputValue();
        if (this.isHasOther) {
            value.setIdAndName(new IdAndName(checkBox.getId(), other.getValue()));
        }
        else {
            value.setIdAndName(new IdAndName(checkBox.getId(), checkBox.getCaption()));
        }
        value.setIsChecked(checkBox.getValue());
        value.setYear(year.getValue());
        value.setMonth(month.getValue());
        return value;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public class MedicalInputValue {
        private Boolean isChecked;
        private IdAndName idAndName;
        private String year;
        private String month;
    }

}
