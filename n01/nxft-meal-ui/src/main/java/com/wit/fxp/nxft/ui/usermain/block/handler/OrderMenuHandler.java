package com.wit.fxp.nxft.ui.usermain.block.handler;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.wit.fxp.nxft.MenuItemNames;
import com.wit.fxp.nxft.ui.block.order.OrderManagerView;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.MealMenuHandler;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

/**
 * 配餐管理
 * @author wck
 */
@SpringComponent
public class OrderMenuHandler implements MealMenuHandler {

    @Override
    public String menuName() {
        return MenuItemNames.助餐主界面菜单.订单管理.value();
    }

    @Override
    public void handle(UI ui) {
        // 菜谱管理
        WorkspaceUtils.getMainWorkspace(ui).openPage(DefaultPageContext.builder()
                ._viewName__________(OrderManagerView.NAME)
                ._key_______________(OrderManagerView.NAME)
                ._title_____________("订单管理")
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }
}
