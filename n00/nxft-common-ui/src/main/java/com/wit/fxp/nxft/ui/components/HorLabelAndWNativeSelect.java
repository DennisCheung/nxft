package com.wit.fxp.nxft.ui.components;

import java.io.Serializable;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * 此类由一个Label和一个WNativeSelect组成
 * 类型：下拉选择
 * @author lyb
 *
 */
public class HorLabelAndWNativeSelect extends HorizontalLayout implements Serializable {

    private static final long serialVersionUID = 1L;

    private Label lbleft = new Label();

    private Boolean isRequired;

    private WNativeSelect nsright = new WNativeSelect();

    private Label lbRequired = new Label("*");

    /**
     * @param leftName  左边的名称
     * @param isRequired  是否必选
     */
    public HorLabelAndWNativeSelect(String leftName, Boolean isRequired) {
        this.setSizeUndefined();
        this.setStyleName("labelAndTextFieldStyle");
        nsright.setStyleName("tfrightstyle");
        lbleft.setStyleName("lblbleftstyle");
        lbleft.setValue(leftName + "：");
        lbRequired.setStyleName("requiredstyle");
        lbRequired.setVisible(isRequired);
        this.addComponents(lbRequired, lbleft, nsright);
    }

    public Label getLbleft() {
        return lbleft;
    }

    public void setLbleft(Label lbleft) {
        this.lbleft = lbleft;
    }

    public WNativeSelect getNsright() {
        return nsright;
    }

    public void setNsright(WNativeSelect nsright) {
        this.nsright = nsright;
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
