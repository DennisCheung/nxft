package com.wit.fxp.nxft.ui.components;

import java.io.Serializable;

import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

/**
 * 此类由一个CheckBox和一个TextField组成
 * 口 标题：____________ （*）
 * @author lyb
 *
 */
public class HoCheckBoxAndTextField extends HorizontalLayout implements Serializable {
    private static final long serialVersionUID = 1L;

    private CheckBox checklf = new CheckBox();

    private Boolean isRequired;

    private TextField tfright = new TextField();

    private Label lbRequired = new Label("*");

    /**
     *
     * @param cbCaption     左边的标题
     * @param isRequired    可以设置当checkbox被选中时，textfield必填
     */
    public HoCheckBoxAndTextField(String cbCaption, Boolean isRequired) {
        this.setSizeUndefined();
        checklf.setCaption(cbCaption);
        this.addComponents(checklf, tfright);

        setIfRequired(isRequired);
        this.setStyleName("HoCheckBoxAndTextField");
    }

    public CheckBox getChecklf() {
        return checklf;
    }

    public void setChecklf(CheckBox checklf) {
        this.checklf = checklf;
    }

    public TextField getTfright() {
        return tfright;
    }

    public void setTfrgint(TextField tfright) {
        this.tfright = tfright;
    }

    public Boolean getRequired() {
        return isRequired;
    }

    public void setRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Label getLbRequired() {
        return lbRequired;
    }

    public void setLbRequired(Label lbRequired) {
        this.lbRequired = lbRequired;
    }

    public void setIfRequired(Boolean isRequired) {
        checklf.addValueChangeListener(e -> {
            if (checklf.getValue()) {
                if (isRequired) {
                    this.removeComponent(tfright);
                    this.addComponents(lbRequired, tfright);
                }
            }
            else {
                this.removeComponent(lbRequired);
            }
        });
    }

}
