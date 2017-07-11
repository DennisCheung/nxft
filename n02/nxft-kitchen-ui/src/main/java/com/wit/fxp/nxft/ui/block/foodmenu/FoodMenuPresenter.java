package com.wit.fxp.nxft.ui.block.foodmenu;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.common.NxftConfirmWindow;
import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.ui.block.event.RefreshFoodMenuEvent;
import com.wit.fxp.nxft.ui.block.event.RefreshMealScheEvent;
import com.wit.fxp.nxft.ui.block.foodmenu.model.MealSetVModel;
import com.wit.fxp.nxft.ui.block.foodmenu.model.MenuFoodMenuVModel;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.utils.DateUtils;

@PrototypeScope
@VaadinPresenter(viewName = FoodMenuView.NAME)
public class FoodMenuPresenter extends AbstractPagePresenter<FoodMenuView> {

    private final ApplicationContext applicationContext;
    private final UserSession userSession;
    private final NxftMealSetApp nxftMealSetApp;

    @Autowired
    public FoodMenuPresenter(EventBus.UIEventBus eventBus, FoodMenuView view, ApplicationContext applicationContext,
            UserSession userSession, NxftMealSetApp nxftMealSetApp) {
        super(eventBus, view);
        this.applicationContext = applicationContext;
        this.userSession = userSession;
        this.nxftMealSetApp = nxftMealSetApp;
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        this.getView().refreshPublish();
        this.getView().refresh();
    }

    public void refreshMealSetData(PagingInfo pageInfo) {
        List<MealSetModel> mealSet = this.nxftMealSetApp.findMealSetList(this.userSession.getTeamId(), pageInfo);
        List<MealSetVModel> vmodelList = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("########0.00");
        mealSet.forEach(e -> {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            Button view = new Button("查看");
            Button edit = new Button("修改");
            horizontalLayout.addComponent(view);
            horizontalLayout.addComponent(edit);
            view.addClickListener(e1 -> {
                ViewMealSetPresenter bean = this.applicationContext.getBean(ViewMealSetPresenter.class);
                bean.postInit(e.getId());
                UI.getCurrent().addWindow((Window) bean.getView());
            });
            edit.addClickListener(e2 -> {
                AddMealSetPresenter bean = this.applicationContext.getBean(AddMealSetPresenter.class);
                Object[] objs = {true, e.getId()};
                bean.postInit(objs);
                UI.getCurrent().addWindow((Window) bean.getView());
            });
            String disease = e.getMealDiseaseSet().stream().map(d -> d.getDiseaseName()).collect(Collectors.joining("、"));
            vmodelList.add(MealSetVModel.builder()
                    ._id________________(e.getId())
                    ._mealSetNo_________(e.getMealCode())
                    ._mealSetName_______(e.getMealName())
                    ._mealSetContent____(e.getMealContent())
                    ._price_____________(df.format(e.getMealPrice()))
                    ._pungent___________(e.getPepperyLevel() != null && 1 == e.getPepperyLevel() ? "有辣" : "无辣")
                    ._mealSetDesc_______(e.getMealDesc())
                    ._createTime________(DateUtils.getLongDate(e.getLogcdate()))
                    ._mealDisease_______(disease)
                    ._handleLayout______(horizontalLayout)
                    ._build_());
        });
        getView().refreshData(vmodelList);
    }

    public void addMealSet() {
        AddMealSetPresenter viewPresnter = this.applicationContext.getBean(AddMealSetPresenter.class);
        Object[] objs = {false, null};
        viewPresnter.postInit(objs);
        UI.getCurrent().addWindow((Window) viewPresnter.getView());
    }

    public void addFoodMenu() {
        AddFoodMenuPresenter addPresnter = this.applicationContext.getBean(AddFoodMenuPresenter.class);
        addPresnter.postInit(null);
        UI.getCurrent().addWindow((Window) addPresnter.getView());
    }

    @EventBusListenerMethod
    public void on(RefreshFoodMenuEvent event) {
        this.getView().refresh();
    }

    @EventBusListenerMethod
    public void on(RefreshMealScheEvent event) {
        this.getView().refreshPublish();
    }

    public void refreshMealScheData(PagingInfo pageInfo, Date beginDate, Date endDate) {
        List<MealSchenoteModel> mealSchenoteList = this.nxftMealSetApp.findMealSchenoteList(this.userSession.getTeamId(), pageInfo, beginDate, endDate);
        List<MenuFoodMenuVModel> vmodelList = new ArrayList<>();
        mealSchenoteList.forEach(e -> {
            HorizontalLayout horizontalLayout = new HorizontalLayout();
            Button view = new Button("查看");
            Button publish = new Button("发布");
            Button returnPublish = new Button("撤销发布");
            horizontalLayout.addComponent(view);
            if (e.getPublishInfo().getIsPublished()) {
                horizontalLayout.addComponent(returnPublish);
            }
            else {
                horizontalLayout.addComponent(publish);
            }
            publish.addClickListener(e1 -> publish(e.getId()));
            returnPublish.addClickListener(e2 -> returnPublish(e.getId()));
            view.addClickListener(e3 -> viewSchenote(e.getId()));
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            String bf = dateFormat.format(e.getScheInfo().getBeginDate());
            String ef = dateFormat.format(e.getScheInfo().getEndDate());
            Label menuState = new Label(e.getPublishInfo().getIsPublished() ? "已发布" : "待发布");
            if (e.getPublishInfo().getIsPublished()) {
                menuState.addStyleName("published");
            }
            else {
                menuState.addStyleName("noPublished");
            }
            vmodelList.add(MenuFoodMenuVModel.builder()
                    ._id____________(e.getId())
                    ._menuName______(DBC.排班周期模式.周.name() + "菜谱")
                    ._timePeriod____(bf + "-" + ef)
                    ._menuState_____(menuState)
                    ._createTime____(e.getCreateInfo().getCreateTime())
                    ._handleLayout__(horizontalLayout)
                    ._build_());
        });
        getView().refreshPublishData(vmodelList);
    }

    private void viewSchenote(String id) {
        AddFoodMenuPresenter addPresnter = this.applicationContext.getBean(AddFoodMenuPresenter.class);
        addPresnter.postInit(id);
        UI.getCurrent().addWindow((Window) addPresnter.getView());
    }

    private void returnPublish(String schenoteId) {
        NxftConfirmWindow cw = new NxftConfirmWindow();
        Button.ClickListener clickListener = new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                nxftMealSetApp.returnPublishSchenote(userSession.getInvoker(), schenoteId);
                getView().refreshPublish();
            }
        };
        cw.initView("撤销发布", "确认撤销发布？", "取消", "撤销发布", clickListener);
        UI.getCurrent().addWindow(cw);
    }

    private void publish(String schenoteId) {
        NxftConfirmWindow cw = new NxftConfirmWindow();
        Button.ClickListener clickListener = new Button.ClickListener() {
            private static final long serialVersionUID = 1L;

            @Override
            public void buttonClick(ClickEvent event) {
                nxftMealSetApp.publishSchenote(userSession.getInvoker(), schenoteId);
                getView().refreshPublish();
            }
        };
        cw.initView("发布", "一经发布不得再修改和撤销数据！是否发布当条数据？", "取消", "确认发布", clickListener);
        UI.getCurrent().addWindow(cw);
    }

}
