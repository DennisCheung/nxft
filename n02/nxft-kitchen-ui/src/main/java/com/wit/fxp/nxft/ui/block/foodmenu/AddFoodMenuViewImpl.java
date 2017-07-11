package com.wit.fxp.nxft.ui.block.foodmenu;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.DateField;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.utils.DateUtils;

/**
 * @author wck
 * 菜谱坑爹
 */
@PrototypeScope
@SpringView(name = AddFoodMenuView.NAME)
public class AddFoodMenuViewImpl extends Window implements AddFoodMenuView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();
    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("新增周菜谱");

    private final HorizontalLayout timehly = new HorizontalLayout();
    private final DateField beginTime = new DateField();
    private final DateField endTime = new DateField();

    private final GridLayout weekGrid = new GridLayout(8, 4);

    private final Button closeBtn = new Button("关闭");
    private final Button confirmBtn = new Button("确定");
    private final HorizontalLayout btnhly = new HorizontalLayout();
    private final Map<Integer, VerticalLayout> contentvlyMap = new HashMap<>();

    private Date weekBeginDate = null;
    private Date weekEndDate = null;

    @Override
    public void initView(AddFoodMenuPresenter presenter) {
        buildView(presenter);
        addStyle();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    private void bind(AddFoodMenuPresenter presenter) {
        closeBtn.addClickListener(e -> {
            this.close();
            Iterator<VerticalLayout> iterator = contentvlyMap.values().iterator();
            boolean isHasAddMealSet = false;
            while (iterator.hasNext()) {
                VerticalLayout next = iterator.next();
                if (next.getComponentCount() > 0) {
                    isHasAddMealSet = true;
                }
            }
            presenter.refreshScheMana(isHasAddMealSet);
        });
        confirmBtn.addClickListener(e -> {
            this.close();
            Iterator<VerticalLayout> iterator = contentvlyMap.values().iterator();
            boolean isHasAddMealSet = false;
            while (iterator.hasNext()) {
                VerticalLayout next = iterator.next();
                if (next.getComponentCount() > 0) {
                    isHasAddMealSet = true;
                }
            }
            presenter.refreshScheMana(isHasAddMealSet);
            if (isHasAddMealSet) {
                Notification.show("周菜谱数据已保存");
            }
        });
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
        this.mainvly.addStyleName("AddFoodMenuView");
        this.weekGrid.addStyleName("weekgrid");
        this.weekGrid.setWidth("100%");
        this.weekGrid.setHeight("460px");
        this.btnhly.setWidth("100%");
        this.mainvly.setWidth("100%");
        this.center();
        this.setWidth("1200px");
        this.setHeightUndefined();
        this.setResizable(false);
        this.setClosable(false);

        this.titlehly.addStyleName("titlehly");
        this.title.addStyleName("title");
        timehly.addStyleName("timehly");
        this.beginTime.setDateFormat("yyyy年MM月dd日");
        this.endTime.setDateFormat("yyyy年MM月dd日");

        this.weekGrid.addStyleName("weekGrid");

        this.closeBtn.addStyleName("closeBtn");
        this.confirmBtn.addStyleName("confirmBtn");
        this.btnhly.addStyleName("btnhly");
    }

    @Override
    public void initData(MealSchenoteModel mealSchenoteModel, AddFoodMenuPresenter presenter) {
        this.weekBeginDate = mealSchenoteModel.getScheInfo().getBeginDate();
        this.weekEndDate = mealSchenoteModel.getScheInfo().getEndDate();

        this.beginTime.setValue(this.weekBeginDate);
        this.endTime.setValue(this.weekEndDate);
        this.beginTime.setEnabled(false);
        this.endTime.setEnabled(false);
        buildWeekGrid(mealSchenoteModel, presenter);
    }

    @Override
    public void refreshData(List<MealScheDayModel> mealScheDay, Date mealDate, String mealTypeId) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(mealDate);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        int week = (i - 1) == 0 ? 6 : (i - 2);
        int key = Integer.parseInt(mealTypeId) * 10 + week;
        VerticalLayout verticalLayout = contentvlyMap.get(key);
        if (verticalLayout != null) {
            verticalLayout.removeAllComponents();
            mealScheDay.forEach(e -> {
                verticalLayout.addComponent(new Label(e.getMealName()));
            });
        }
    }

    @Override
    public void refreshData(List<MealScheDayModel> mealSchedaySet) {
        Map<Integer, List<MealScheDayModel>> collect1 = mealSchedaySet.stream().collect(Collectors.groupingBy(MealScheDayModel::getWeek));
        Iterator<Entry<Integer, List<MealScheDayModel>>> weekIt = collect1.entrySet().iterator();
        contentvlyMap.values().forEach(e -> {
            e.removeAllComponents();
        });
        while (weekIt.hasNext()) {
            Entry<Integer, List<MealScheDayModel>> next = weekIt.next();
            next.getValue().forEach(e -> {
                int key = Integer.parseInt(e.getMealTypeId()) * 10 + (next.getKey() - 1);
                VerticalLayout verticalLayout = contentvlyMap.get(key);
                if (verticalLayout != null) {
                    verticalLayout.addComponent(new Label(e.getMealName()));
                }
            });
        }
    }

    private void buildView(AddFoodMenuPresenter presenter) {
        this.setContent(mainvly);

        mainvly.addComponents(this.titlehly, timehly, this.weekGrid, this.btnhly);
        this.titlehly.addComponents(this.title);
        timehly.addComponent(LayoutUtils.getHorLayout("时段：", "", beginTime, "", endTime, "", "", "至"));
        this.btnhly.addComponents(this.closeBtn, this.confirmBtn);
        this.btnhly.setComponentAlignment(this.closeBtn, Alignment.MIDDLE_RIGHT);
        this.btnhly.setComponentAlignment(this.confirmBtn, Alignment.MIDDLE_LEFT);

    }

    private void buildWeekGrid(MealSchenoteModel mealSchenoteModel, AddFoodMenuPresenter presenter) {
        configureGrid();

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(mealSchenoteModel.getScheInfo().getBeginDate());
        String[] weekStrs = new String[] {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        Label component0 = new Label("时间");
        component0.addStyleName("component0");
        this.weekGrid.addComponent(component0, 0, 0);
        for (int i = 0; i < 7; i++) {
            Date time = calendar.getTime();
            if (i == 0) {
                this.weekBeginDate = time;
            }
            if (i == 6) {
                this.weekEndDate = time;
            }
            VerticalLayout weekTitle = new VerticalLayout();
            weekTitle.addStyleName("weekTitle");
            Label weekName = new Label(weekStrs[i]);
            Label timeName = new Label(DateUtils.getShortDate(time));
            weekName.addStyleName("weekTitleWeekName");
            timeName.addStyleName("weekTitleTimeName");
            weekTitle.addComponents(timeName, weekName);
            weekTitle.setData(time);
            this.weekGrid.addComponent(weekTitle, i + 1, 0);

            for (int j = 1; j < 4; j++) {
                int k = j * 10;
                VerticalLayout contentvly = new VerticalLayout();
                contentvly.setId(j + "");
                contentvly.addStyleName("weekcontentvly");
                VerticalLayout menuSet = new VerticalLayout();
                Button add = new Button();
                if (mealSchenoteModel.getPublishInfo().getIsPublished()) {
                    add.addStyleName("weekview");
                }
                else {
                    add.addStyleName("weekadd");
                }
                menuSet.addStyleName("menuSetvly");
                contentvly.addComponents(menuSet, add);
                contentvlyMap.put(k + i, menuSet);
                this.weekGrid.addComponent(contentvly, i + 1, j);

                add.addClickListener(e -> {
                    Date mealDate = DateUtils.getBegin((Date) weekTitle.getData());
                    presenter.selectMenu(mealDate, contentvly.getId());
                });
            }
            calendar.add(Calendar.DATE, 1);
        }
        Label breakfastName = new Label("早餐");
        Label lunchName = new Label("午餐");
        Label dinnerName = new Label("晚餐");
        this.weekGrid.addComponent(breakfastName, 0, 1);
        this.weekGrid.addComponent(lunchName, 0, 2);
        this.weekGrid.addComponent(dinnerName, 0, 3);
        breakfastName.addStyleName("foodtype");
        lunchName.addStyleName("foodtype");
        dinnerName.addStyleName("foodtype");
    }

    private void configureGrid() {
        this.weekGrid.setColumnExpandRatio(0, 1f);
        this.weekGrid.setColumnExpandRatio(1, 4f);
        this.weekGrid.setColumnExpandRatio(2, 4f);
        this.weekGrid.setColumnExpandRatio(3, 4f);
        this.weekGrid.setColumnExpandRatio(4, 4f);
        this.weekGrid.setColumnExpandRatio(5, 4f);
        this.weekGrid.setColumnExpandRatio(6, 4f);
        this.weekGrid.setColumnExpandRatio(7, 4f);
        this.weekGrid.setRowExpandRatio(0, 1f);
        this.weekGrid.setRowExpandRatio(1, 5f);
        this.weekGrid.setRowExpandRatio(2, 5f);
        this.weekGrid.setRowExpandRatio(3, 5f);
    }

}
