package com.wit.fxp.nxft.ui.handler;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.wit.fxp.nxft.MenuItemNames;
import com.wit.fxp.nxft.ui.block.foodorder.FoodOrderView;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandler;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

/**
 * 订单管理
 * @author wck
 */
@SpringComponent
public class FoodOrderMenuHandler implements KitchenMenuHandler {

    @Override
    public String menuName() {
        return MenuItemNames.配餐主界面菜单.订单管理.value();
    }

    @Override
    public void handle(UI ui) {
        // 订单管理
        WorkspaceUtils.getMainWorkspace(ui).openPage(DefaultPageContext.builder()
                ._viewName__________(FoodOrderView.NAME)
                ._key_______________(FoodOrderView.NAME)
                ._title_____________(FoodOrderView.TITLE)
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }
}
