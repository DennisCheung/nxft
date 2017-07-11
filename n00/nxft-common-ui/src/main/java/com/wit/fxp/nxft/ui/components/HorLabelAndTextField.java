package com.wit.fxp.nxft.ui.components;

import java.io.Serializable;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;

/**
 * 此类由一个Label和一个textfield组成
 * 姓名：____________ （*）
 * @author qiuxu
 *
 */
public class HorLabelAndTextField extends HorizontalLayout implements Serializable {

    private static final long serialVersionUID = 1L;

    private Label lbleft = new Label();

    private Boolean isRequired;

    private TextField tfright = new TextField();

    private Label lbRequired = new Label("*");

    /**
     * @param leftName  左边的名称
     * @param isRequired  是否必填
     */
    public HorLabelAndTextField(String leftName, Boolean isRequired) {
        this.setSizeUndefined();
        this.setStyleName("labelAndTextFieldStyle");
        tfright.setStyleName("tfrightstyle");
        lbleft.setStyleName("lblbleftstyle");
        lbleft.setValue(leftName + "：");
        lbRequired.setStyleName("requiredstyle");
        lbRequired.setVisible(isRequired);
        this.addComponents(lbRequired, lbleft, tfright);
    }

    public Label getLbleft() {
        return lbleft;
    }

    public void setLbleft(Label lbleft) {
        this.lbleft = lbleft;
    }

    public TextField getTfright() {
        return tfright;
    }

    public void setTfright(TextField tfright) {
        this.tfright = tfright;
    }

    public Boolean getLbisRequired() {
        return isRequired;
    }

    public void setLbisRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Boolean getIsRequired() {
        return isRequired;
    }

    public void setIsRequired(Boolean isRequired) {
        this.isRequired = isRequired;
    }

    public Label getLbRequired() {
        return lbRequired;
    }

    public void setLbRequired(Label lbRequired) {
        this.lbRequired = lbRequired;
    }

}
