package com.wit.fxp.nxft.ui.block.recharge.showinfo;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.model.SubjectAccountList;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = ShowRechargeView.NAME)
public class ShowRechargePresenter extends AbstractPresenter<ShowRechargeView> {

    @Autowired private UserSession userSession;

    @Autowired private SubjecctApp subjectdApp;

    @Autowired
    public ShowRechargePresenter(EventBus.UIEventBus eventBus, ShowRechargeView view) {
        super(eventBus, view);
    }

    public void postInit() {
        getView().initView(this);
    }

    public void showValue(List<SubjectAccountList> lists) {
        java.text.DecimalFormat d = new DecimalFormat("#.00");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int[] count = new int[]{0};
        Button btn = new Button("撤销充值");
        btn.addStyleName(ValoTheme.BUTTON_LINK);
        List<ShowRechargeViewModel> viewModels = new ArrayList<>();
        lists.forEach(e -> {
            count[0] += 1;
            int w = getWeek(e.getCreateTime());
            if (count[0] == 1) {
                btn.addClickListener(ff -> cancelMoney(e.getSubjectId(), e.getMoney()));
            }
            viewModels.add(ShowRechargeViewModel.builder()
                    ._time__(sdf.format(e.getCreateTime()))
                    ._week__("星期" + getbWeek(w))
                    ._money_(d.format(e.getMoney()) + "元")
                    ._btn___(count[0] == 1 ? btn : null)
                    ._build_());
        });
        getView().refreshView(viewModels);
    }

    private void cancelMoney(String subjecdtId, Double money) {
        subjectdApp.cancelMoney(userSession.getApplicationId(), userSession.getInvoker(), subjecdtId, money);
        subjectdApp.cancelRecjarge(subjecdtId);
        Notification.show("撤销成功！");
        getEventBus().publish(this, new RefreshEvent());
        List<SubjectAccountList> lists = subjectdApp.findAccountList(subjecdtId);
        showValue(lists);
    }

    private String getbWeek(int index) {
        String[] week = {"错误", "一", "二", "三", "四", "五", "六", "天"};
        return week[index];
    }

    private int getWeek(Date date) {
        Calendar cl = Calendar.getInstance();
        cl.setTime(date);
        int w = cl.get(Calendar.DAY_OF_WEEK) - 1;
        if (w <= 0) {
            w = 7;
        }
        return w;
    }

}
