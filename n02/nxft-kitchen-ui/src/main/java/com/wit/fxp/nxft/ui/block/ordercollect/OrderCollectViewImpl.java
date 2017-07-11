package com.wit.fxp.nxft.ui.block.ordercollect;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.vaadin.spring.annotation.PrototypeScope;

import com.benewit.core.env.CurrentDate;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.compound.model.NxftOrderCollectModel;
import com.wit.fxp.nxft.utils.DateUtils;

/**
 *
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = OrderCollectView.NAME)
public class OrderCollectViewImpl extends CustomComponent implements OrderCollectView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final VerticalLayout topvly = new VerticalLayout();
    private final VerticalLayout bottomvly = new VerticalLayout();

    private final Button printOrderBtn = new Button("打印订单");

    private final GridLayout dayGrid = new GridLayout(3, 6);

    private final VerticalLayout day1Breakfastvly = new VerticalLayout();
    private final HorizontalLayout day1BreakfastTitlehly = new HorizontalLayout();
    private final Label day1BreakfastTitle = new Label("11111");
    private final VerticalLayout day1BreakfastContentvly = new VerticalLayout();

    private final VerticalLayout day1Lunchvly = new VerticalLayout();
    private final HorizontalLayout day1LunchTitlehly = new HorizontalLayout();
    private final Label day1LunchTitle = new Label("2222");
    private final VerticalLayout day1LunchContentvly = new VerticalLayout();

    private final VerticalLayout day1Dinnervly = new VerticalLayout();
    private final HorizontalLayout day1DinnerTitlehly = new HorizontalLayout();
    private final Label day1DinnerTitle = new Label("3333");
    private final VerticalLayout day1DinnerContentvly = new VerticalLayout();

    private final VerticalLayout day2Breakfastvly = new VerticalLayout();
    private final HorizontalLayout day2BreakfastTitlehly = new HorizontalLayout();
    private final Label day2BreakfastTitle = new Label("4444");
    private final VerticalLayout day2BreakfastContentvly = new VerticalLayout();

    private final VerticalLayout day2Lunchvly = new VerticalLayout();
    private final HorizontalLayout day2LunchTitlehly = new HorizontalLayout();
    private final Label day2LunchTitle = new Label("55555");
    private final VerticalLayout day2LunchContentvly = new VerticalLayout();

    private final VerticalLayout day2Dinnervly = new VerticalLayout();
    private final HorizontalLayout day2DinnerTitlehly = new HorizontalLayout();
    private final Label day2DinnerTitle = new Label("66666");
    private final VerticalLayout day2DinnerContentvly = new VerticalLayout();

    private final VerticalLayout day3Breakfastvly = new VerticalLayout();
    private final HorizontalLayout day3BreakfastTitlehly = new HorizontalLayout();
    private final Label day3BreakfastTitle = new Label("77777");
    private final VerticalLayout day3BreakfastContentvly = new VerticalLayout();

    private final VerticalLayout day3Lunchvly = new VerticalLayout();
    private final HorizontalLayout day3LunchTitlehly = new HorizontalLayout();
    private final Label day3LunchTitle = new Label("88888");
    private final VerticalLayout day3LunchContentvly = new VerticalLayout();

    private final VerticalLayout day3Dinnervly = new VerticalLayout();
    private final HorizontalLayout day3DinnerTitlehly = new HorizontalLayout();
    private final Label day3DinnerTitle = new Label("9999999");
    private final VerticalLayout day3DinnerContentvly = new VerticalLayout();

    @Override
    public void initView(OrderCollectPresenter presenter) {
        buildView();
        addStyle();
        bind(presenter);
    }

    @Override
    public void initData(List<NxftOrderCollectModel> nxftOrder) {
        CurrentDate currentDate = new CurrentDate();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate.getCurrentDate());
        List<NxftOrderCollectModel> todayList = nxftOrder.stream().filter(e -> {
            Date mealDate = e.getMealDate();
            Date today = currentDate.getCurrentDate();
            if ((mealDate.after(DateUtils.getBegin(today)) && mealDate.before(DateUtils.getEnd(today)))
                    || mealDate.equals(DateUtils.getBegin(today)) || mealDate.equals(DateUtils.getEnd(today))) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        calendar.add(Calendar.DATE, 1);
        List<NxftOrderCollectModel> tomorrowList = nxftOrder.stream().filter(e -> {
            Date day = calendar.getTime();
            Date mealDate = e.getMealDate();
            if ((mealDate.after(DateUtils.getBegin(day)) && mealDate.before(DateUtils.getEnd(day)))
                    || mealDate.equals(DateUtils.getBegin(day)) || mealDate.equals(DateUtils.getEnd(day))) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        calendar.add(Calendar.DATE, 1);
        List<NxftOrderCollectModel> afterTomorrowList = nxftOrder.stream().filter(e -> {
            Date day = calendar.getTime();
            Date mealDate = e.getMealDate();
            if ((mealDate.after(DateUtils.getBegin(day)) && mealDate.before(DateUtils.getEnd(day)))
                    || mealDate.equals(DateUtils.getBegin(day)) || mealDate.equals(DateUtils.getEnd(day))) {
                return true;
            }
            return false;
        }).collect(Collectors.toList());

        refreshTodayData(todayList);
        refreshTomorrowData(tomorrowList);
        refreshDayAfterTomorrowData(afterTomorrowList);

    }

    private void refreshTodayData(List<NxftOrderCollectModel> todayList) {
        int breakfastQuantity = 0;
        int lunchQuantity = 0;
        int dinnerQuantity = 0;
        day1BreakfastContentvly.removeAllComponents();
        day1LunchContentvly.removeAllComponents();
        day1DinnerContentvly.removeAllComponents();
        Map<String, List<NxftOrderCollectModel>> collect = todayList.stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealTypeId));
        Iterator<Entry<String, List<NxftOrderCollectModel>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<NxftOrderCollectModel>> next = iterator.next();
            switch (next.getKey()) {
            case "1":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect1 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it21 = mealNameCollect1.entrySet().iterator();
                while (it21.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it21.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        breakfastQuantity += o.getQuantity();
                    }
                    day1BreakfastContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;
            case "2":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect2 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it22 = mealNameCollect2.entrySet().iterator();
                while (it22.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it22.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        lunchQuantity += o.getQuantity();
                    }
                    day1LunchContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;
            case "3":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect3 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it23 = mealNameCollect3.entrySet().iterator();
                while (it23.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it23.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        dinnerQuantity += o.getQuantity();
                    }
                    day1DinnerContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;

            default:
                break;
            }
        }
        day1BreakfastTitle.setValue("早餐(" + breakfastQuantity + ")");
        day1LunchTitle.setValue("午餐(" + lunchQuantity + ")");
        day1DinnerTitle.setValue("晚餐(" + dinnerQuantity + ")");
        if (day1BreakfastContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day1BreakfastContentvly.addComponent(c);
        }
        if (day1LunchContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day1LunchContentvly.addComponent(c);
        }
        if (day1DinnerContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day1DinnerContentvly.addComponent(c);
        }
    }

    private void refreshTomorrowData(List<NxftOrderCollectModel> tomorrowList) {
        int breakfastQuantity = 0;
        int lunchQuantity = 0;
        int dinnerQuantity = 0;
        day2BreakfastContentvly.removeAllComponents();
        day2LunchContentvly.removeAllComponents();
        day2DinnerContentvly.removeAllComponents();
        Map<String, List<NxftOrderCollectModel>> collect = tomorrowList.stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealTypeId));
        Iterator<Entry<String, List<NxftOrderCollectModel>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<NxftOrderCollectModel>> next = iterator.next();
            switch (next.getKey()) {
            case "1":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect1 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it21 = mealNameCollect1.entrySet().iterator();
                while (it21.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it21.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        breakfastQuantity += o.getQuantity();
                    }
                    day2BreakfastContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;
            case "2":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect2 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it22 = mealNameCollect2.entrySet().iterator();
                while (it22.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it22.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        lunchQuantity += o.getQuantity();
                    }
                    day2LunchContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;
            case "3":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect3 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it23 = mealNameCollect3.entrySet().iterator();
                while (it23.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it23.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        dinnerQuantity += o.getQuantity();
                    }
                    day2DinnerContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;

            default:
                break;
            }
        }
        day2BreakfastTitle.setValue("早餐(" + breakfastQuantity + ")");
        day2LunchTitle.setValue("午餐(" + lunchQuantity + ")");
        day2DinnerTitle.setValue("晚餐(" + dinnerQuantity + ")");
        if (day2BreakfastContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day2BreakfastContentvly.addComponent(c);
        }
        if (day2LunchContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day2LunchContentvly.addComponent(c);
        }
        if (day2DinnerContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day2DinnerContentvly.addComponent(c);
        }
    }

    private void refreshDayAfterTomorrowData(List<NxftOrderCollectModel> afterTomorrowList) {
        int breakfastQuantity = 0;
        int lunchQuantity = 0;
        int dinnerQuantity = 0;
        day3BreakfastContentvly.removeAllComponents();
        day3LunchContentvly.removeAllComponents();
        day3DinnerContentvly.removeAllComponents();
        Map<String, List<NxftOrderCollectModel>> collect = afterTomorrowList.stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealTypeId));
        Iterator<Entry<String, List<NxftOrderCollectModel>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<NxftOrderCollectModel>> next = iterator.next();
            switch (next.getKey()) {
            case "1":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect1 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it21 = mealNameCollect1.entrySet().iterator();
                while (it21.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it21.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        breakfastQuantity += o.getQuantity();
                    }
                    day3BreakfastContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;
            case "2":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect2 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it22 = mealNameCollect2.entrySet().iterator();
                while (it22.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it22.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        lunchQuantity += o.getQuantity();
                    }
                    day3LunchContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;
            case "3":
                Map<String, List<NxftOrderCollectModel>> mealNameCollect3 = next.getValue().stream().collect(Collectors.groupingBy(NxftOrderCollectModel::getMealName));
                Iterator<Entry<String, List<NxftOrderCollectModel>>> it23 = mealNameCollect3.entrySet().iterator();
                while (it23.hasNext()) {
                    Entry<String, List<NxftOrderCollectModel>> n2 = it23.next();
                    int i = 0;
                    for (NxftOrderCollectModel o : n2.getValue()) {
                        i += o.getQuantity();
                        dinnerQuantity += o.getQuantity();
                    }
                    day3DinnerContentvly.addComponent(new Label(n2.getKey() + "(" + i + "份)"));
                }
                break;

            default:
                break;
            }
        }
        day3BreakfastTitle.setValue("早餐(" + breakfastQuantity + ")");
        day3LunchTitle.setValue("午餐(" + lunchQuantity + ")");
        day3DinnerTitle.setValue("晚餐(" + dinnerQuantity + ")");
        if (day3BreakfastContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day3BreakfastContentvly.addComponent(c);
        }
        if (day3LunchContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day3LunchContentvly.addComponent(c);
        }
        if (day3DinnerContentvly.getComponentCount() == 0) {
            Label c = new Label("当前餐别没有数据");
            c.addStyleName("warntiplabel");
            day3DinnerContentvly.addComponent(c);
        }
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    private void bind(OrderCollectPresenter presenter) {
        this.printOrderBtn.addClickListener(e -> presenter.printOrder());
    }

    private void addStyle() {
        Page page = Page.getCurrent();
        if (page.getBrowserWindowWidth() > 1230) {
            this.mainvly.setWidth(page.getBrowserWindowWidth() + "px");
        }
        else {
            this.mainvly.setWidth("1366px");
        }
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                this.mainvly.setWidth(page.getBrowserWindowWidth() + "px");
            }
        });
        this.mainvly.addStyleName("OrderCollectView");

        this.dayGrid.setWidth("900px");

        this.topvly.addStyleName("topvly");
        this.bottomvly.addStyleName("bottomvly");

        this.printOrderBtn.addStyleName("printOrderBtn");

        this.dayGrid.addStyleName("dayGrid");

        this.day1Breakfastvly.addStyleName("day1Breakfastvly");
        this.day1BreakfastTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day1Breakfastvly.setWidth("95%");
        this.day1BreakfastTitle.addStyleName("day1BreakfastTitle");
        this.day1BreakfastContentvly.addStyleName("day1BreakfastContentvly");

        this.day1Lunchvly.addStyleName("day1Breakfastvly");
        this.day1Lunchvly.setWidth("95%");
        this.day1LunchTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day1LunchTitle.addStyleName("day1BreakfastTitle");
        this.day1LunchContentvly.addStyleName("day1BreakfastContentvly");

        this.day1Dinnervly.addStyleName("day1Breakfastvly");
        this.day1Dinnervly.setWidth("95%");
        this.day1DinnerTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day1DinnerTitle.addStyleName("day1BreakfastTitle");
        this.day1DinnerContentvly.addStyleName("day1BreakfastContentvly");

        this.day2Breakfastvly.addStyleName("day1Breakfastvly");
        this.day2Breakfastvly.setWidth("95%");
        this.day2BreakfastTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day2BreakfastTitle.addStyleName("day1BreakfastTitle");
        this.day2BreakfastContentvly.addStyleName("day1BreakfastContentvly");

        this.day2Lunchvly.addStyleName("day1Breakfastvly");
        this.day2Lunchvly.setWidth("95%");
        this.day2LunchTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day2LunchTitle.addStyleName("day1BreakfastTitle");
        this.day2LunchContentvly.addStyleName("day1BreakfastContentvly");

        this.day2Dinnervly.addStyleName("day1Breakfastvly");
        this.day2Dinnervly.setWidth("95%");
        this.day2DinnerTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day2DinnerTitle.addStyleName("day1BreakfastTitle");
        this.day2DinnerContentvly.addStyleName("day1BreakfastContentvly");

        this.day3Breakfastvly.addStyleName("day1Breakfastvly");
        this.day3Breakfastvly.setWidth("95%");
        this.day3BreakfastTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day3BreakfastTitle.addStyleName("day1BreakfastTitle");
        this.day3BreakfastContentvly.addStyleName("day1BreakfastContentvly");

        this.day3Lunchvly.addStyleName("day1Breakfastvly");
        this.day3Lunchvly.setWidth("95%");
        this.day3LunchTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day3LunchTitle.addStyleName("day1BreakfastTitle");
        this.day3LunchContentvly.addStyleName("day1BreakfastContentvly");

        this.day3Dinnervly.addStyleName("day1Breakfastvly");
        this.day3Dinnervly.setWidth("95%");
        this.day3DinnerTitlehly.addStyleName("day1BreakfastTitlehly");
        this.day3DinnerTitle.addStyleName("day1BreakfastTitle");
        this.day3DinnerContentvly.addStyleName("day1BreakfastContentvly");

    }

    private void buildView() {
        this.setCompositionRoot(mainvly);

        mainvly.addComponents(topvly, bottomvly);

        topvly.addComponent(dayGrid);
        bottomvly.addComponent(printOrderBtn);

        configureGrid();
        buildGrid();

        day1Breakfastvly.addComponents(day1BreakfastTitlehly, day1BreakfastContentvly);
        day1BreakfastTitlehly.addComponent(day1BreakfastTitle);

        day1Lunchvly.addComponents(day1LunchTitlehly, day1LunchContentvly);
        day1LunchTitlehly.addComponent(day1LunchTitle);

        day1Dinnervly.addComponents(day1DinnerTitlehly, day1DinnerContentvly);
        day1DinnerTitlehly.addComponent(day1DinnerTitle);

        day2Breakfastvly.addComponents(day2BreakfastTitlehly, day2BreakfastContentvly);
        day2BreakfastTitlehly.addComponent(day2BreakfastTitle);

        day2Lunchvly.addComponents(day2LunchTitlehly, day2LunchContentvly);
        day2LunchTitlehly.addComponent(day2LunchTitle);

        day2Dinnervly.addComponents(day2DinnerTitlehly, day2DinnerContentvly);
        day2DinnerTitlehly.addComponent(day2DinnerTitle);

        day3Breakfastvly.addComponents(day3BreakfastTitlehly, day3BreakfastContentvly);
        day3BreakfastTitlehly.addComponent(day3BreakfastTitle);

        day3Lunchvly.addComponents(day3LunchTitlehly, day3LunchContentvly);
        day3LunchTitlehly.addComponent(day3LunchTitle);

        day3Dinnervly.addComponents(day3DinnerTitlehly, day3DinnerContentvly);
        day3DinnerTitlehly.addComponent(day3DinnerTitle);
    }

    private void buildGrid() {
        Date d = new Date();
        Calendar cal = new GregorianCalendar();
        cal.setTime(d);
        Label day1 = new Label("今天(" + DateUtils.getChineseShortDate(cal.getTime()) + ")");
        cal.add(Calendar.DATE, 1);
        Label day2 = new Label("明天(" + DateUtils.getChineseShortDate(cal.getTime()) + ")");
        cal.add(Calendar.DATE, 1);
        Label day3 = new Label("后天(" + DateUtils.getChineseShortDate(cal.getTime()) + ")");
        day1.addStyleName("dayTitle");
        day2.addStyleName("dayTitle");
        day3.addStyleName("dayTitle");
        this.dayGrid.addComponent(day1, 0, 0);
        this.dayGrid.addComponent(day2, 0, 2);
        this.dayGrid.addComponent(day3, 0, 4);

        this.dayGrid.addComponent(day1Breakfastvly, 0, 1);
        this.dayGrid.addComponent(day1Lunchvly, 1, 1);
        this.dayGrid.addComponent(day1Dinnervly, 2, 1);

        this.dayGrid.addComponent(day2Breakfastvly, 0, 3);
        this.dayGrid.addComponent(day2Lunchvly, 1, 3);
        this.dayGrid.addComponent(day2Dinnervly, 2, 3);

        this.dayGrid.addComponent(day3Breakfastvly, 0, 5);
        this.dayGrid.addComponent(day3Lunchvly, 1, 5);
        this.dayGrid.addComponent(day3Dinnervly, 2, 5);
    }

    private void configureGrid() {
        this.dayGrid.setColumnExpandRatio(0, 1f);
        this.dayGrid.setColumnExpandRatio(1, 1f);
        this.dayGrid.setColumnExpandRatio(2, 1f);
        this.dayGrid.setRowExpandRatio(0, 1f);
        this.dayGrid.setRowExpandRatio(1, 8f);
        this.dayGrid.setRowExpandRatio(2, 1f);
        this.dayGrid.setRowExpandRatio(3, 8f);
        this.dayGrid.setRowExpandRatio(4, 1f);
        this.dayGrid.setRowExpandRatio(5, 8f);
    }

}
