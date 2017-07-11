package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * example:    姓名：张三
 * @author qiuxu
 *
 */
public class HorLabelAndLabel extends HorizontalLayout {
    private static final long serialVersionUID = 1L;
    private  Label lbleft;
    private  Label lbright;

    public HorLabelAndLabel(String leftvalue, String rightvalue) {
        lbleft = new Label(leftvalue + "：");
        lbright = new Label(rightvalue);
        build();
    }

    public void build() {
        this.setSizeUndefined();
        lbleft.setStyleName("lbleftstyle");
        lbright.setStyleName("lbrightstyle");
        this.addComponents(lbleft, lbright);
    }

    public Label getLbleft() {
        return lbleft;
    }

    public void setLbleft(Label lbleft) {
        this.lbleft = lbleft;
    }

    public Label getLbright() {
        return lbright;
    }

    public void setLbright(Label lbright) {
        this.lbright = lbright;
    }

}
