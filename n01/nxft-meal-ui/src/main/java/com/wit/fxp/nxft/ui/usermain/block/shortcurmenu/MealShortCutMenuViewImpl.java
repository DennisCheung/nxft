package com.wit.fxp.nxft.ui.usermain.block.shortcurmenu;

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
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.MenuItemNames;

@PrototypeScope
@SpringView(name = MealShortCutMenuView.NAME)
public class MealShortCutMenuViewImpl extends CustomComponent implements MealShortCutMenuView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Image titledot = new Image();
    private final Label title = new Label("常用功能");
    private final HorizontalLayout buttons = new HorizontalLayout();
    private final HorizontalLayout buttonsSec = new HorizontalLayout();
    private final Button btn1 = new Button(MenuItemNames.助餐主界面菜单.对象管理.name());
    private final Button btn2 = new Button(MenuItemNames.助餐主界面菜单.订单管理.name());
    private final Button btn3 = new Button(MenuItemNames.助餐主界面菜单.充值.name());

    public void buildView() {
        this.setCompositionRoot(mainvly);
        //titledot.setSource(new ThemeResource("image/title-dot.png"));
        HorizontalLayout titlehly = new HorizontalLayout();
        titlehly.addComponents(titledot, title);
        mainvly.addComponents(titlehly, buttons, buttonsSec);
        buttons.addComponents(btn1, btn2, btn3);

        btn1.setData(MenuItemNames.助餐主界面菜单.对象管理.value());
        btn2.setData(MenuItemNames.助餐主界面菜单.订单管理.value());
        btn3.setData(MenuItemNames.助餐主界面菜单.充值.value());
    }

    public void bind(MealShortCutMenuPresenter presenter) {
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
    public void initView(MealShortCutMenuPresenter presenter) {

        buildView();
        bind(presenter);
        addStyle();
    }

    private void addStyle() {
        this.mainvly.addStyleName("shortcutmenuview");
        title.addStyleName("shortcuttitle");
        this.titledot.addStyleName("titledot");
    }

}
