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

@PrototypeScope
@SpringView(name = ShortCutMenuView.NAME)
public class ShortCutMenuViewImpl extends CustomComponent implements ShortCutMenuView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("常用功能");
    private final HorizontalLayout buttons = new HorizontalLayout();
    private final HorizontalLayout buttonsSec = new HorizontalLayout();
    private final Button btn1 = new Button("主界面菜单");

    public void buildView() {
        this.setCompositionRoot(mainvly);
        mainvly.addComponents(title, buttons, buttonsSec);
        buttons.addComponents(btn1); //暂时不添加基础档案,后面实现再加上

        btn1.setData("主界面菜单");
    }

    public void bind(ShortCutMenuPresenter presenter) {
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
    public void initView(ShortCutMenuPresenter presenter) {

        buildView();
        bind(presenter);
        addStyle();
    }

    private void addStyle() {
        this.mainvly.addStyleName("shortcutmenuview");
    }

}
