package com.wit.fxp.nxft.common;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class NxftConfirmWindow extends Window {
    private static final long serialVersionUID = 1L;

    private final Label titleLabel = new Label();
    private final Label contentLabel = new Label();
    private final Button cancelBtn = new Button("取消");
    private final Button confirmBtn = new Button("确定");

    private final VerticalLayout mainvly = new VerticalLayout();
    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final VerticalLayout contentvly = new VerticalLayout();
    private final HorizontalLayout btnhly = new HorizontalLayout();

    public void initView(String title, String content, String cancelCaption, String confirmCaption, Button.ClickListener confirmClick) {
        build();
        addStyle();
        titleLabel.setValue(title);
        contentLabel.setValue(content);
        cancelBtn.setCaption(cancelCaption);
        confirmBtn.setCaption(confirmCaption);
        confirmBtn.addClickListener(confirmClick);
        cancelBtn.addClickListener(e -> {
            this.close();
        });
        confirmBtn.addClickListener(e -> {
            this.close();
        });
    }

    private void addStyle() {
        titleLabel.addStyleName("titleLabel");
        contentLabel.addStyleName("contentLabel");
        cancelBtn.addStyleName("cancelBtn");
        confirmBtn.addStyleName("confirmBtn");

        mainvly.addStyleName("NxftConfirmWindow");
        titlehly.addStyleName("titlehly");
        contentvly.addStyleName("contentvly");
        btnhly.addStyleName("btnhly");
    }

    private void build() {
        this.setContent(mainvly);
        this.setWidth("350px");
        this.center();
        this.setResizable(false);
        this.setClosable(false);
        mainvly.addComponents(titlehly, contentvly, btnhly);
        titlehly.addComponent(titleLabel);
        contentvly.addComponent(contentLabel);
        btnhly.addComponents(cancelBtn, confirmBtn);
        btnhly.setComponentAlignment(cancelBtn, Alignment.MIDDLE_RIGHT);
        titlehly.setWidth("100%");
        contentvly.setWidth("100%");
        btnhly.setWidth("100%");
    }

}
