package com.wit.fxp.nxft.ui.toolbar.menuhandler;

import com.vaadin.ui.UI;

public interface MenuHandler {

    String menuName();

    void handle(UI ui);
}
