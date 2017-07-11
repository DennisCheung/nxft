package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.fxp.nxft.app.common.model.MyOrderList;

public class MyOrderListComonent extends VerticalLayout {

    private Button deleteBtn;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MyOrderListComonent(MyOrderList list) {
        deleteBtn = new Button("x");
        deleteBtn.addStyleName(ValoTheme.BUTTON_QUIET);
        VerticalLayout ordervly = new VerticalLayout();
        ordervly.setId(list.getMealTypeId());
        HorizontalLayout titlehly = new HorizontalLayout();
        Label lb1 = new Label(list.getMealName());
        ordervly.setWidth("150px");
        ordervly.setHeight("50px");
        ordervly.addStyleName("ordervly");
        ordervly.addComponents(titlehly, lb1);
        titlehly.addComponent(new Label(list.getMealTypeName()));
        titlehly.addComponent(deleteBtn);
        titlehly.setComponentAlignment(deleteBtn, Alignment.MIDDLE_RIGHT);
        titlehly.setWidth("100%");

    }

    public Button getDeleteBtn() {
        return deleteBtn;
    }

    public void setDeleteBtn(Button deleteBtn) {
        this.deleteBtn = deleteBtn;
    }

}
