package com.wit.fxp.nxft.ui.addorder.main;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.dialogs.ConfirmDialog;
import org.vaadin.spring.annotation.PrototypeScope;

import com.benewit.core.env.RuntimeContext;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.common.model.KitchenMenuData;
import com.wit.fxp.nxft.app.common.model.MyOrderList;
import com.wit.fxp.nxft.app.common.model.OptionData;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.ui.components.WRadioButton;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.fxp.nxft.utils.StringUtils;
import com.wit.fxp.vaadin.ui.HorLabelAndLabel;

@PrototypeScope
@SpringView(name = MealAddOrderView.NAME)
public class MealAddOrderViewImpl extends CustomComponent implements MealAddOrderView, Serializable {

    private static final long serialVersionUID = -5363855376879829655L;

    private final VerticalLayout mainvly = new VerticalLayout();
    private final HorizontalLayout topInfo = new HorizontalLayout();
    private final Label title = new Label("配餐信息：");
    private final HorLabelAndLabel type = new HorLabelAndLabel("对象类别", null);
    private final HorLabelAndLabel yue = new HorLabelAndLabel("余额", null);
    private final HorLabelAndLabel peisong = new HorLabelAndLabel("配送地址", null);
    private final HorLabelAndLabel diseaseType = new HorLabelAndLabel("常见疾病", null);

    private final GridLayout gridLayout = new GridLayout();

    private final VerticalLayout aavly = new VerticalLayout();
    private final HorizontalLayout dateHor = new HorizontalLayout();
    private final Button todatBtn = new Button("前一天");
    private final DateField df = new DateField();
    private final Button tomorrowBtn = new Button("后一天");

    private final HorizontalLayout showhor = new HorizontalLayout();
    private final Label lbshow = new Label();

    private final HorizontalLayout orderHor = new HorizontalLayout();

    private final HorizontalLayout btnHor = new HorizontalLayout();

    private final HorizontalLayout orderHorlayout = new HorizontalLayout();

    private final HorizontalLayout placeHor = new HorizontalLayout();
    private final Label orderPoorLb = new Label("订单池");
    private final Button plactBtn = new Button("去下单");

    private final HorizontalLayout dingdanchiLayout = new HorizontalLayout();
    private final HorizontalLayout dingdanchi = new HorizontalLayout();

    @Autowired private RuntimeContext rc;

    public void buildView() {
        this.setCompositionRoot(mainvly);
        mainvly.addComponents(topInfo, gridLayout);
        topInfo.addComponents(title, yue, type, peisong, diseaseType);
        topInfo.setWidth("1258px");
        topInfo.setExpandRatio(diseaseType, 1.0f);
        aavly.addComponents(dateHor, showhor);
        showhor.addComponent(lbshow);
        this.gridLayout.setColumns(1);
        this.gridLayout.setRows(6);
        this.dateHor.addComponents(this.todatBtn, this.df, this.tomorrowBtn);
        df.setDateFormat("yyyy-MM-dd");
        Date next = DateUtils.parseShortDate(DateUtils.getNextDay(rc.getCurrentDate()));
        df.setValue(next);
        this.placeHor.addComponents(this.orderPoorLb, plactBtn);
        this.orderHorlayout.addComponents(this.dingdanchiLayout);
        this.dingdanchiLayout.addComponents(this.dingdanchi);

        this.gridLayout.addComponent(this.aavly, 0, 0);
        this.gridLayout.addComponent(this.orderHor, 0, 1);
        this.gridLayout.addComponent(this.btnHor, 0, 2);
        this.gridLayout.addComponent(this.placeHor, 0, 3);
        this.gridLayout.addComponent(this.orderHorlayout, 0, 4);

        this.mainvly.setComponentAlignment(this.gridLayout, Alignment.MIDDLE_CENTER);
        addStyle();
    }

    public void bind(MealAddOrderPresenter presenter) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        todatBtn.addClickListener(e -> {
            String last = DateUtils.getLastDay(df.getValue());
            Date time = DateUtils.parseShortDate(last);
            df.setValue(time);
            if (sdf.format(df.getValue()).equals(sdf.format(rc.getCurrentDate()))) {
                todatBtn.setEnabled(false);
            }
            presenter.refreshAll(time);
        });
        tomorrowBtn.addClickListener(e -> {
            Date time = DateUtils.parseShortDate(DateUtils.getNextDay(df.getValue()));
            df.setValue(time);
            if (sdf.format(df.getValue()).compareTo(sdf.format(rc.getCurrentDate())) > 0) {
                todatBtn.setEnabled(true);
            }
            presenter.refreshAll(time);
        });
        plactBtn.addClickListener(e -> {
            List<MyOrderList> lists = getOrderValue();
            if (lists.size() <= 0) {
                Notification.show("请点餐！");
                return;
            }
            presenter.addOrder(lists, df.getValue());
        });
    }

    private List<MyOrderList> getOrderValue() {
        List<MyOrderList> lists = new ArrayList<>();
        Iterator<Component> coms = dingdanchi.iterator();
        while (coms.hasNext()) {
            Component com = coms.next();
            if (com instanceof VerticalLayout) {
                VerticalLayout ccc = ((VerticalLayout) com);
                lists.add((MyOrderList) ccc.getData());
            }
        }
        return lists;
    }

    private AbstractLayout buildSelectSiteInfo(MyOrderList list) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        int no = list.getMealName().indexOf("；");
        Button deleteBtn = new Button("x");
        deleteBtn.addStyleName(ValoTheme.BUTTON_QUIET);

        Label dietDateLabel = new Label();
        dietDateLabel.setValue(sdf1.format(DateUtils.parseShortDate(list.getMealDate())));

        VerticalLayout ordervly = new VerticalLayout();
        ordervly.addStyleName("rordervly");
        dietDateLabel.setStyleName("mealaddorderaabbccsstyle");
        ordervly.setId(list.getMealTypeId());
        ordervly.setData(list);
        HorizontalLayout titlehly = new HorizontalLayout();
        titlehly.addStyleName("titlehlyout");
        Label lb1 = new Label(no > 0 ? list.getMealName().substring(0, no) : list.getMealName());
        Label lb2 = new Label("数量：1份");
        lb1.addStyleName("lb1");
        ordervly.setWidth("285px");
        ordervly.addStyleName("ordervly");
        ordervly.addComponents(titlehly, lb1, lb2);
        Label lb1yyyy = new Label(list.getMealTypeName());
        titlehly.addComponents(lb1yyyy, dietDateLabel);
        titlehly.addComponent(deleteBtn);
        titlehly.setComponentAlignment(deleteBtn, Alignment.MIDDLE_RIGHT);
        titlehly.setWidth("100%");

        deleteBtn.addClickListener(e -> {
            if (sdf.format(df.getValue()).equals(list.getMealDate())) {
                cancelOrder(list, true);
            }
            else {
                dingdanchi.removeComponent(ordervly);
            }

        });
        return ordervly;
    }

    private void addStyle() {
        dingdanchi.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        dingdanchi.addStyleName("dingdanchistyle");
        this.gridLayout.setWidth("98%");

        this.mainvly.addStyleName("MealAddOrderViewImpl");

        this.dingdanchiLayout.addStyleName("dingdanchiLayout");
        this.topInfo.addStyleName("topInfo");
        this.title.addStyleName("title");
        this.diseaseType.addStyleName("diseaseType");
        this.type.addStyleName("type");
        this.yue.addStyleName("yue");
        this.peisong.addStyleName("peisong");

        this.gridLayout.addStyleName("maingridlayout");

        this.dateHor.addStyleName("NxftDateHor");
        this.todatBtn.addStyleName("NxftTodatBtn");
        this.tomorrowBtn.addStyleName("NxftTomorrowBtn");

        this.orderHor.addStyleName("NxftOrderHor");
        this.showhor.addStyleName("showhor");
        this.lbshow.addStyleName("lbshow");

        this.btnHor.addStyleName("NxftBtnHor");

        this.orderHorlayout.addStyleName("NxftOrderHorlayout");

        this.placeHor.addStyleName("NxftPlaceHor");
        this.orderPoorLb.addStyleName("NxftOrderPoorLb");
        this.plactBtn.addStyleName("plactBtn");
    }

    @Override
    public void initView(MealAddOrderPresenter scToolbarPresenter) {
        dingdanchi.removeAllComponents();
        buildView();
        addStyle();
        bind(scToolbarPresenter);
    }

    private void buildOrder(MyOrderList list) {
        boolean has = false;
        Iterator<Component> coms = dingdanchi.iterator();
        if (!coms.hasNext()) {
            dingdanchi.addComponent(buildSelectSiteInfo(list), 0);
        }
        else {
            while (coms.hasNext()) {
                Component com = coms.next();
                if (com instanceof VerticalLayout) {
                    VerticalLayout ver = (VerticalLayout) com;
                    if (list.getMealDate().equals(((MyOrderList) ver.getData()).getMealDate()) && list.getMealTypeId().equals(ver.getId())) {
                        dingdanchi.removeComponent(ver);
                        if (list.getMealId() != null) {
                            dingdanchi.addComponent(buildSelectSiteInfo(list), 0);
                        }
                        has = true;
                        break;
                    }
                }
            }
            if (!has) {
                dingdanchi.addComponent(buildSelectSiteInfo(list), 0);
            }

        }

    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    private void cancelOrder(MyOrderList list, boolean isSelect) {
        Iterator<Component> coms = orderHor.iterator();
        while (coms.hasNext()) {
            Component com = coms.next();
            if (com instanceof VerticalLayout) {
                VerticalLayout ver = (VerticalLayout) com;
                Iterator<Component> cc = ver.iterator();
                while (cc.hasNext()) {
                    Component c = cc.next();
                    if (c instanceof WRadioButton) {
                        WRadioButton wb = (WRadioButton) c;
                        if (wb.getId().equals(list.getMealDate()) && ((IdAndName) wb.getData()).getId().equals(list.getMealTypeId())) {
                            if (isSelect) {
                                wb.unselect(new IdAndName(list.getMealId(), list.getMealName()));
                            }
                            else {
                                wb.select(new IdAndName(list.getMealId(), list.getMealName()));
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void addMeal(List<KitchenMenuData> datas, MealAddOrderPresenter presenter) {
        orderHor.removeAllComponents();
        datas.forEach(e -> {
            VerticalLayout breakfastVer = new VerticalLayout();
            Label breakfastLb = new Label(e.getMealType().getName());
            breakfastVer.addComponents(breakfastLb);
            WRadioButton breakfastWcb = new WRadioButton();
            if (e.getDatas().size() <= 0) {
                Label lb = new Label("暂无配餐！");
                lb.addStyleName("NxftBreakfastWcb");
                breakfastVer.addComponents(lb);
            }
            else {
                e.getDatas().forEach(f -> {
                    breakfastWcb.setId(f.getMealDate());
                    breakfastWcb.setData(e.getMealType());
                    breakfastWcb.addOptionItem(f.getOption().getId(), f.getOption().getName());
                    breakfastWcb.setItemEnabled(new IdAndName(f.getOption().getId(), f.getOption().getName()), f.isEnable());

                });
                breakfastWcb.bindData();
                breakfastWcb.addValueChangeListener(ffff -> {
                    IdAndName value = breakfastWcb.getValue();
                    IdAndName v = (IdAndName) breakfastWcb.getData();
                    String diseaseDesc = presenter.checkIsDisease(value.getId());
                    if (value != IdAndName.EMPTY && !StringUtils.isEmpty(diseaseDesc)) {
                        String tip = value.getName().substring(0, value.getName().indexOf("，"));
                        ConfirmDialog.show(UI.getCurrent(), "点餐提醒", tip + "\n\n"
                                + "不适合(" + diseaseDesc + ")", "继续点餐", "退出", new ConfirmDialog.Listener() {

                                        private static final long serialVersionUID = 1L;

                                        @Override
                                        public void onClose(ConfirmDialog dialog) {
                                            if (dialog.isConfirmed()) {
                                                buildOrder(MyOrderList.builder()
                                                        ._mealDate______(breakfastWcb.getId())
                                                        ._mealId________(value.getId())
                                                        ._mealName______(value.getName())
                                                        ._mealTypeId____(v.getId())
                                                        ._mealTypeName__(v.getName())
                                                        ._build_());
                                            }
                                            else {
                                                breakfastWcb.unselect(value);
                                            }
                                        }
                                });
                    }
                    else {
                        buildOrder(MyOrderList.builder()
                                ._mealDate______(breakfastWcb.getId())
                                ._mealId________(value == null ? null : value.getId())
                                ._mealName______(value == null ? null : value.getName())
                                ._mealTypeId____(v.getId())
                                ._mealTypeName__(v.getName())
                                ._build_());
                    }

                });
                breakfastWcb.setEnabled(checkIsEnable(e.getDatas()));
                breakfastVer.addComponents(breakfastWcb);
            }

            breakfastVer.addStyleName("NxftBreakfastVer");
            breakfastLb.addStyleName("NxftBreakfastLb");
            breakfastWcb.addStyleName("NxftBreakfastWcb");

            orderHor.addComponent(breakfastVer);
        });

        List<MyOrderList> lists = getOrderValue();
        lists.forEach(ffff -> {
            cancelOrder(ffff, false);
        });
    }

    private boolean checkIsEnable(List<OptionData> datas) {
        boolean enable = true;
        for (OptionData data : datas) {
            if (!data.isEnable()) {
                enable = false;
                break;
            }
        }
        return enable;
    }

    @Override
    public void addDate(Date next) {
        df.setValue(next);
    }

    @Override
    public void refreshSubjectInfo(SubjectModel subject, Double yue) {
        if (subject != null) {
            type.getLbright().setValue(subject.getSubjectInfo().getSubjectTypeName());
            this.yue.getLbright().setValue(yue + "元");
            String addresss = subject.getAddress() == null ? "" : subject.getAddress();
            String addressss = (subject.getRegionName() + addresss).trim();
            peisong.getLbright().setValue(subject.getSubjectInfo().getDeliveType().equals("SITE") ? subject.getSubjectInfo().getDeliveSiteName()
                    : addressss);
            this.diseaseType.getLbright().setValue(subject.getSubjectInfo().getSubjectDisease());
        }
    }

}
