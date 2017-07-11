package com.wit.fxp.nxft.ui.usermain.block.notice;

import java.io.Serializable;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.spring.annotation.PrototypeScope;

@PrototypeScope
@SpringView(name = NoticeView.NAME)
public class NoticeViewImpl extends CustomComponent implements NoticeView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("公告栏");

    private final TextArea content = new TextArea();

    public NoticeViewImpl() {
        buildView();
        bind();
    }

    public void buildView() {
        addStyle();
        this.setCompositionRoot(mainvly);
        VerticalLayout mainVer = new VerticalLayout();
        mainVer.addComponents(title, content);
        mainvly.addComponents(mainVer);
    }

    public void bind() {

    }

    public void addStyle() {
        this.mainvly.addStyleName("noticeview-main");
        this.mainvly.setWidth("100%");
        this.mainvly.setHeight("570px");
        this.title.addStyleName("title-1");
        this.content.setWidth("98%");
        this.content.setHeight("550px");
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshData(String content) {
        this.content.setValue(content);
    }

}
