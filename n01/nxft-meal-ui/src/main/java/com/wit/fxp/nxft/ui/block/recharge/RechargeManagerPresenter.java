package com.wit.fxp.nxft.ui.block.recharge;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.model.SubjectAccountList;
import com.wit.fxp.nxft.app.model.SubjectMoneyData;
import com.wit.fxp.nxft.app.selectdata.MoneySelectInfo;
import com.wit.fxp.nxft.ui.block.recharge.add.RechargePresenter;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshEvent;
import com.wit.fxp.nxft.ui.block.recharge.moneylist.MoneyListPresenter;
import com.wit.fxp.nxft.ui.block.recharge.showinfo.ShowRechargePresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;

@PrototypeScope
@VaadinPresenter(viewName = RechargeManagerView.NAME)
public class RechargeManagerPresenter extends AbstractPagePresenter<RechargeManagerView> {

    @Autowired private ApplicationContext applicationContext;
    @Autowired private UserSession userSession;
    @Autowired private SubjecctApp app;

    @Autowired
    public RechargeManagerPresenter(EventBus.UIEventBus eventBus, RechargeManagerView view) {
        super(eventBus, view);
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        refreshAll();
    }

    public void refreshAll() {
        getView().refreshData(toViewModels(app.findMoneySubjects(userSession.getInvoker(), null, 0)));

        int rowCount = app.fintMoneySubjectRowCount(userSession.getInvoker(), null);
        int pageNum = (rowCount - 1) / 8 + 1;
        getView().refreshPageInfo(String.valueOf(pageNum), rowCount);
    }

    public int getPageTotalNum(MoneySelectInfo info) {
        int rowCount = app.fintMoneySubjectRowCount(userSession.getInvoker(), info);
        return (rowCount - 1) / 8 + 1;
    }

    public void subjectQuery(MoneySelectInfo info, int pageNum) {
        List<SubjectMoneyData> models = app.findMoneySubjects(userSession.getInvoker(), info, pageNum);
        getView().refreshData(toViewModels(models));

        int rowCount = app.fintMoneySubjectRowCount(userSession.getInvoker(), info);
        int pageSize = (rowCount - 1) / 8 + 1;
        getView().refreshPageInfo(String.valueOf(pageSize), rowCount);
    }

    public List<RechargeViewModel> toViewModels(List<SubjectMoneyData> models) {
        return models.stream().map(e -> {
            HorizontalLayout hor = new HorizontalLayout();
            Button btn1 = new Button("充值");
            Button btn2 = new Button("查看");
            btn1.addStyleName(ValoTheme.BUTTON_LINK);
            btn2.addStyleName(ValoTheme.BUTTON_LINK);
            btn1.addClickListener(ee -> openRecharge(e.getSubjectId()));
            btn2.addClickListener(ff -> openShow(e.getSubjectId()));
            hor.addComponents(btn1, btn2);
            RechargeViewModel model = RechargeViewModel.builder()
                    ._subjectId_(e.getSubjectId())
                    ._name______(e.getName())
                    ._gender____(e.getGender())
                    ._type______(e.getType())
                    ._yue_______(e.getYue())
                    ._touzhi____(e.getTouzhi())
                    ._phone_____(e.getPhone())
                    ._hand______(hor)
                    ._build_();
            return model;
        }).collect(Collectors.toList());
    }

    private void openRecharge(String subjectId) {
        RechargePresenter presenter = applicationContext.getBean(RechargePresenter.class);
        presenter.postInit(subjectId);
        UI.getCurrent().addWindow((Window) presenter.getView());
    }

    private void openShow(String subjectId) {
        List<SubjectAccountList> lists = app.findAccountList(subjectId);
        if (lists.size() > 0) {
            ShowRechargePresenter presenter = applicationContext.getBean(ShowRechargePresenter.class);
            presenter.postInit();
            presenter.showValue(lists);
            UI.getCurrent().addWindow((Window) presenter.getView());
        }
        else {
            Notification.show("暂无充值记录！");
        }

    }

    public void openMoneyList() {
        MoneyListPresenter presenter = applicationContext.getBean(MoneyListPresenter.class);
        presenter.postInit();
        UI.getCurrent().addWindow((Window) presenter.getView());
    }

    @EventBusListenerMethod
    void onReresh(RefreshEvent event) {
        refreshAll();
    }

}
