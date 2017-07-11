package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.wit.datatype.option.support.CommonOptionGroup;

public class OptionBoxVerticalLayout extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    private final OptionBox optionBox;
    private final TextField other;
    private boolean withOther;

    /**
     * 多选框加其他输入框
     * @param optionBox
     * @param other
     */
    public OptionBoxVerticalLayout(CommonOptionGroup optionGroup, boolean withOther) {
        this.optionBox = new OptionBox(optionGroup);
        this.withOther = withOther;
        this.other = new TextField();
        optionBox.setModel();
        addComponent(optionBox);
        if (withOther) {
            other.setValue(optionGroup.getOtherDesc() == null ? "" : optionGroup.getOtherDesc());
            other.setEnabled(optionBox.getSelectedOther());
            addOtherListener();
            addComponent(other);
        }
    }

    private void addOtherListener() {
        optionBox.addValueChangeListener(e -> other.setEnabled(optionBox.getSelectedOther()));
    }

    public CommonOptionGroup getValue() {
        CommonOptionGroup value = optionBox.getOptionGroup();
        if (withOther) {
            if (optionBox.getSelectedOther()) {
                value.setOtherDesc(other.getValue());
            }
            else {
                value.setOtherDesc(null);
            }
        }
        return value;
    }

    public OptionBox getOptionBox() {
        return optionBox;
    }

    public TextField getOther() {
        return other;
    }

}
