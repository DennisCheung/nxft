package com.wit.fxp.nxft.ui.usermain.block.notice;

import java.io.Serializable;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@PrototypeScope
@SpringView(name = KitchenNoticeView.NAME)
public class KitchenNoticeViewImpl extends CustomComponent implements KitchenNoticeView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final VerticalLayout contentvly = new VerticalLayout();
    private final VerticalLayout content = new VerticalLayout();
    private final Label tipLabel = new Label();

    public KitchenNoticeViewImpl() {
        buildView();
        bind();
    }

    public void buildView() {
        addStyle();
        this.setCompositionRoot(mainvly);
        VerticalLayout mainVer = new VerticalLayout();
        mainVer.addComponents(contentvly);
        contentvly.addComponents(tipLabel, content);
        mainvly.addComponents(mainVer);
        tipLabel.setValue("更新提示");
    }

    public void bind() {

    }

    public void addStyle() {
        this.mainvly.addStyleName("noticeview-main");
        this.contentvly.addStyleName("contentvly");
        this.content.addStyleName("content");
        this.tipLabel.addStyleName("tipLabel");
        this.mainvly.setWidth("93%");
        this.mainvly.setHeight("200px");
        this.content.setWidth("98%");
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshData(String content) {
        this.content.removeAllComponents();
        Label notice = new Label(content);
        notice.setWidth("90%");
        notice.addStyleName("noticelb");
        this.content.addComponent(notice);
    }

}
