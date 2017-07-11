package com.wit.fxp.nxft.ui.handler;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.UI;
import com.wit.fxp.nxft.MenuItemNames;
import com.wit.fxp.nxft.ui.block.compoundfood.CompoundFoodView;
import com.wit.fxp.nxft.ui.toolbar.menuhandler.KitchenMenuHandler;
import com.wit.fxp.ui.workspace.WorkspaceUtils;
import com.wit.fxp.ui.workspace.page.DefaultPageContext;

/**
 * 配餐管理
 * @author wck
 */
@SpringComponent
public class CompountFoodMenuHandler implements KitchenMenuHandler {

    @Override
    public String menuName() {
        return MenuItemNames.配餐主界面菜单.配餐管理.value();
    }

    @Override
    public void handle(UI ui) {
        // 菜谱管理
        WorkspaceUtils.getMainWorkspace(ui).openPage(DefaultPageContext.builder()
                ._viewName__________(CompoundFoodView.NAME)
                ._key_______________(CompoundFoodView.NAME)
                ._title_____________(CompoundFoodView.TITLE)
                ._initParameters____(null)
                ._toReInitOnSwitch__(false)
                ._closable__________(true)
                ._build_());
    }
}
