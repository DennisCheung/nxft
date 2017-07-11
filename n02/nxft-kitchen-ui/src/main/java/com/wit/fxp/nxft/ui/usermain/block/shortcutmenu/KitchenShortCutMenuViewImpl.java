package com.wit.fxp.nxft.ui.usermain.block.shortcutmenu;

import java.io.Serializable;
import java.util.Iterator;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.MenuItemNames;

@PrototypeScope
@SpringView(name = KitchenShortCutMenuView.NAME)
public class KitchenShortCutMenuViewImpl extends CustomComponent implements KitchenShortCutMenuView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("常用功能");
    private final HorizontalLayout buttons = new HorizontalLayout();
    private final HorizontalLayout buttonsSec = new HorizontalLayout();
    private final Button btn0 = new Button(MenuItemNames.配餐主界面菜单.订单汇总.name());
    private final Button btn1 = new Button(MenuItemNames.配餐主界面菜单.订单管理.name());
    private final Button btn2 = new Button(MenuItemNames.配餐主界面菜单.配餐管理.name());
    private final Button btn3 = new Button(MenuItemNames.配餐主界面菜单.菜谱管理.name());

    public void buildView() {
        this.setCompositionRoot(mainvly);
        HorizontalLayout titlehly = new HorizontalLayout();
        titlehly.addComponents(title);
        mainvly.addComponents(titlehly, buttons, buttonsSec);
        buttons.addComponents(btn0, btn1, btn2, btn3);

        btn0.setData(MenuItemNames.配餐主界面菜单.订单汇总.value());
        btn1.setData(MenuItemNames.配餐主界面菜单.订单管理.value());
        btn2.setData(MenuItemNames.配餐主界面菜单.配餐管理.value());
        btn3.setData(MenuItemNames.配餐主界面菜单.菜谱管理.value());
    }

    public void bind(KitchenShortCutMenuPresenter presenter) {
        Iterator<Component> btns = buttons.iterator();
        while (btns.hasNext()) {
            Component next = btns.next();
            if (next instanceof Button) {
                Button btn = (Button) next;
                btn.addClickListener(e -> presenter.onShortCurtButtonClick(e.getButton().getData().toString()));
            }
        }
        Iterator<Component> btns2 = buttonsSec.iterator();
        while (btns2.hasNext()) {
            Component next = btns2.next();
            if (next instanceof Button) {
                Button btn = (Button) next;
                btn.addClickListener(e -> presenter.onShortCurtButtonClick(e.getButton().getData().toString()));
            }
        }
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void initView(KitchenShortCutMenuPresenter presenter) {

        buildView();
        bind(presenter);
        addStyle();
    }

    private void addStyle() {
        this.mainvly.addStyleName("shortcutmenuview");
        title.addStyleName("shortcuttitle");
    }

}
