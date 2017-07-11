package com.wit.fxp.nxft.ui.usermain.main;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.ui.MealViewName;
import com.wit.fxp.nxft.ui.usermain.TeamViewModel;
import com.wit.fxp.nxft.ui.usermain.block.notice.MealNoticePresenter;
import com.wit.fxp.nxft.ui.usermain.block.shortcurmenu.MealShortCutMenuPresenter;
import com.wit.fxp.nxft.ui.usermain.block.worktips.MealWorkTipsPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.user.UserSessionCreator;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;
import com.wit.fxp.user.org.OrgUserLoginApp;
import com.wit.fxp.user.org.OrgUserLoginInfo;

@PrototypeScope
@VaadinPresenter(viewName = MealViewName.MEAL_MAIN_VIEW_NAME)
public class MealUserMainPresenter extends AbstractPagePresenter<MealUserMainView> {

    private final ApplicationContext applicationContext;
    private final UserSession userSession;
    private final OrgUserLoginApp loginApp;
    private final UserSessionCreator userSessionCreator;

    @Autowired
    public MealUserMainPresenter(EventBus.UIEventBus eventBus, MealUserMainView view, ApplicationContext applicationContext, UserSession userSession,
            OrgUserLoginApp loginApp, UserSessionCreator userSessionCreator) {
        super(eventBus, view);
        this.applicationContext = applicationContext;
        this.userSession = userSession;
        this.loginApp = loginApp;
        this.userSessionCreator = userSessionCreator;
    }

    @Override
    public void initPage(Object parameters) {
        refreshLoginInfo();
        shuaxin();
    }

    private void refreshLoginInfo() {
        getView().refreshLoginInfo(userSession.getUserId(), userSession.getNickname(), userSession.getTeamName());
    }

    public void refreshPage(String teamId) {
        loginApp.updateDefaultLoginTeam(userSession.getUserId(), DBC.子系统.定餐工作站.value(), teamId);

        UserSession newUserSession = userSessionCreator.createUserSession(DBC.子系统.定餐工作站.value());
        getView().refreshLoginInfo(newUserSession.getUserId(), newUserSession.getNickname(), newUserSession.getTeamName());
        shuaxin();
    }

    private void shuaxin() {
        MealShortCutMenuPresenter shortcut = applicationContext.getBean(MealShortCutMenuPresenter.class);
        shortcut.postInit();

        MealWorkTipsPresenter worktips = applicationContext.getBean(MealWorkTipsPresenter.class);
        worktips.postInit();
        worktips.refreshData();

        MealNoticePresenter notice = applicationContext.getBean(MealNoticePresenter.class);
        notice.refreshData();

        getView().refreshView(shortcut.getView(), worktips.getView(), notice.getView());

        List<OrgUserLoginInfo> loginInfos = loginApp.findTeamMembers(DBC.子系统.定餐工作站.value(), userSession.getUserId());

        getView().initChangeSiteMenu(toTeamViewModels(loginInfos), this);
    }

    private List<TeamViewModel> toTeamViewModels(List<OrgUserLoginInfo> infos) {
        return infos.stream()
                .filter(f -> f.getTeamId() != userSession.getTeamId())
                .map(e -> TeamViewModel.builder()
                        ._name______(e.getCircleName() + "：" + e.getTeamName())
                        ._circleId__(e.getCircleId())
                        ._teamId____(e.getTeamId())
                        ._build_())
                .collect(Collectors.toList());
    }

}
