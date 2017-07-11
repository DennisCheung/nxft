package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * 此组件作用于弹窗确认
 * 带主标题与输入区
 * @author lyb
 *
 */
public class ConfirmAndTextAreaWindow extends Window {
    private static final long serialVersionUID = 1L;

    private final Label tipLabel = new Label("");
    private final TextArea descTa = new TextArea();
    private final Button confirmBtn = new Button("确定");
    private final Button cancelBtn = new Button("取消");
    private final VerticalLayout mainLayout = new VerticalLayout();
    private final VerticalLayout tipLayout = new VerticalLayout();
    private final HorizontalLayout btnLayout = new HorizontalLayout();

    public ConfirmAndTextAreaWindow() {
        center();
        setWidth("320px");
        setHeight("250px");
        setResizable(false);
        setModal(true);
        setClosable(false);
        buildView();
        addstyle();
    }

    public void addConfirmBtnClickLisenter(Button.ClickListener clickListener) {
        this.confirmBtn.addClickListener(clickListener);
    }

    public void addCancelBtnClickLisenter(Button.ClickListener clickListener) {
        this.cancelBtn.addClickListener(clickListener);
    }

    public void setTipVlaue(String value) {
        this.tipLabel.setValue(value);
    }

    public TextArea getTextArea() {
        return this.descTa;
    }

    private void buildView() {
        setContent(this.mainLayout);
        this.mainLayout.addComponents(tipLayout, descTa, btnLayout);
        this.mainLayout.setSizeFull();
        this.tipLayout.addComponent(tipLabel);
        this.btnLayout.addComponents(confirmBtn, cancelBtn);
        this.mainLayout.setComponentAlignment(tipLayout, Alignment.MIDDLE_CENTER);
        this.mainLayout.setComponentAlignment(btnLayout, Alignment.BOTTOM_CENTER);
    }

    public void setComponentsCaption(String catption) {
        this.setCaption(catption);
        this.setCaptionAsHtml(true);
    }

    private void addstyle() {
        this.mainLayout.addStyleName("ConfirmAndTestAreaWindow");
        this.btnLayout.addStyleName("confirm-btn");
        this.tipLabel.addStyleName("tipLabelstyle");
    }
}
