package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * 此组件作用于弹窗确认
 * 带主标题与副标题，均可选
 * @author wck
 *
 */
public class ConfirmWindow extends Window {

    private static final long serialVersionUID = 1L;

    private final Label tipLabel = new Label("");
    private final TextField valueTx = new TextField();
    private final Button confirmBtn = new Button("确定");
    private final Button cancelBtn = new Button("取消");
    private final VerticalLayout mainLayout = new VerticalLayout();
    private final VerticalLayout tipLayout = new VerticalLayout();
    private final HorizontalLayout btnLayout = new HorizontalLayout();

    public ConfirmWindow() {
        center();
        setWidth("320px");
        setHeight("200px");
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

    public String getValueTx() {
        if (this.valueTx.getValue() == null) {
            return "";
        }
        else {
            return this.valueTx.getValue();
        }
    }

    private void buildView() {
        setContent(this.mainLayout);
        this.setCaption("<span style='font-size:18px; font-weight:bold;'>系统提示</span>");
        this.setCaptionAsHtml(true);
        this.mainLayout.addComponents(tipLayout, valueTx, btnLayout);
        this.mainLayout.setSizeFull();
        this.tipLayout.addComponent(tipLabel);
        this.btnLayout.addComponents(confirmBtn, cancelBtn);
        this.mainLayout.setComponentAlignment(tipLayout, Alignment.MIDDLE_CENTER);
        this.mainLayout.setComponentAlignment(btnLayout, Alignment.BOTTOM_CENTER);
    }

    private void addstyle() {
        this.mainLayout.addStyleName("confirmWindowStyle");
        this.tipLabel.addStyleName("tipLabelstyle");
        this.valueTx.addStyleName("valueTxstyle");
        this.confirmBtn.addStyleName("confirmBtnstyle");
        this.cancelBtn.addStyleName("cancelBtnstyle");
        this.tipLayout.addStyleName("tipLayoutstyle");
        this.btnLayout.addStyleName("btnLayoutstyle");
    }

}
