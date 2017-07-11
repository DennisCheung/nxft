package com.wit.fxp.nxft.ui.workbench;

import java.io.Serializable;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.ui.ViewName;

@PrototypeScope
@SpringView(name = ViewName.WORKBENCH_VIEW_NAME)
public class WorkbenchViewImpl extends VerticalLayout implements WorkbenchView, View, Serializable {

    private static final long serialVersionUID = 1L;
    private final VerticalLayout mainWarpLayout = new VerticalLayout();

    public WorkbenchViewImpl() {
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void initView(Component grab, Component todo) {
        addComponent(mainWarpLayout);
        setComponentAlignment(mainWarpLayout, Alignment.TOP_CENTER);
        mainWarpLayout.addComponents(grab, todo);
        mainWarpLayout.setComponentAlignment(grab, Alignment.TOP_CENTER);
        mainWarpLayout.setComponentAlignment(todo, Alignment.TOP_CENTER);
        addStyle();
    }

    private void addStyle() {
        addStyleName("workbench");
        mainWarpLayout.addStyleName("workbenchwarp");
        mainWarpLayout.setWidthUndefined();
        this.setWidth("100%");
        this.setHeight("100%");
    }

}
