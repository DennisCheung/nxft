package com.wit.fxp.nxft.ui.block.recharge.moneylist;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.model.MoneyListData;
import com.wit.fxp.nxft.app.model.SelectMoneyListInfo;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = MoneyListView.NAME)
public class MoneyListPresenter extends AbstractPresenter<MoneyListView> {

    @Autowired private SubjecctApp app;
    @Autowired private UserSession userSession;

    @Autowired
    public MoneyListPresenter(EventBus.UIEventBus eventBus, MoneyListView view) {
        super(eventBus, view);
    }

    public void postInit() {
        getView().initView(this);
        showValue(SelectMoneyListInfo.builder()
                ._begin_____(DBC.BEGINTIME)
                ._end_______(DBC.ENDTIME)
                ._isMine____(false)
                ._build_());
    }

    public void showValue(SelectMoneyListInfo info) {
        DecimalFormat d = new DecimalFormat("#.00");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<MoneyListData> datas = app.findMoneyListData(userSession.getInvoker(), info);
        getView().refreshView(datas.stream().map(e -> MoneyListViewModel.builder()
                ._name__(e.getName())
                ._phone_(e.getPhone())
                ._time__(sdf.format(e.getTime()))
                ._jine__(d.format(e.getJine()) + "")
                ._yue___(d.format(e.getYue()) + "")
                ._hand__(e.getHandname())
                ._build_()).collect(Collectors.toList()));
    }

}
