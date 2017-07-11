package com.wit.fxp.nxft.ui.block.recharge.showinfo;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@PrototypeScope
@SpringView(name = ShowRechargeView.NAME)
public class ShowRechargeViewImpl extends Window implements ShowRechargeView, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final Label title = new Label("查看最近10条充值记录");

    private final VerticalLayout list = new VerticalLayout();

    private final Button btn = new Button("关闭");

    @Autowired
    @Qualifier("validator")
    private javax.validation.Validator javaxValidator;

    @Override
    public void initView(ShowRechargePresenter presenter) {
        center();
        this.setResizable(false);
        this.setSizeUndefined();
        this.setModal(true);
        this.setContent(mainvly);
        buildView();
        bind(presenter);

    }

    public void buildView() {
        addStyle();
        this.setContent(mainvly);
        mainvly.addComponents(title, list, btn);
    }

    public void addStyle() {
        this.mainvly.addStyleName("ShowRechargeViewImpl");
        this.mainvly.setWidth("100%");
        this.title.addStyleName("title");
        this.list.addStyleName("list");

        this.btn.addStyleName("btn");

    }

    public void bind(ShowRechargePresenter presenter) {
        btn.addClickListener(e -> this.close());
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshView(List<ShowRechargeViewModel> models) {
        list.removeAllComponents();
        models.forEach(e -> {
            HorizontalLayout hor = new HorizontalLayout();
            Label lb1 = new Label(e.getTime() + "-" + e.getWeek());
            Label lb2 = new Label("充值：" + e.getMoney());
            hor.addComponents(lb1, lb2);
            list.addComponent(hor);
        });
    }

}
