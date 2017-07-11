package com.wit.fxp.nxft.ui.block.recharge;

import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import lombok.Getter;

@Getter
public class MyWindow extends Window {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainLayout = new VerticalLayout();

    private final VerticalLayout mainContentLayout = new VerticalLayout();

    public MyWindow() {
        this.setContent(mainLayout);
        mainLayout.addComponent(mainContentLayout);
        mainLayout.setSizeFull();
        mainContentLayout.setWidth("100%");
        this.setResizable(false);
        this.setModal(true);
        this.center();
    }

    public MyWindow(String title) {
        this();
        this.setCaption(title);
    }

}
