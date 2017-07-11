package com.wit.fxp.nxft.ui.handler;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.wit.fxp.nxft.MenuItemNames;
import com.wit.fxp.nxft.ui.block.foodmenu.FoodMenuView;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandler;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

/**
 * 菜谱管理
 * @author wck
 */
@SpringComponent
public class FoodMenuMenuHandler implements KitchenMenuHandler {

    @Override
    public String menuName() {
        return MenuItemNames.配餐主界面菜单.菜谱管理.value();
    }

    @Override
    public void handle(UI ui) {
        // 菜谱管理
        WorkspaceUtils.getMainWorkspace(ui).openPage(DefaultPageContext.builder()
                ._viewName__________(FoodMenuView.NAME)
                ._key_______________(FoodMenuView.NAME)
                ._title_____________(FoodMenuView.TITLE)
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }
}
