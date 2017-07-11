package com.wit.fxp.nxft.ui;

import javax.servlet.http.Cookie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.events.EventBus;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Widgetset;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinService;
import com.vaadin.shared.ui.ui.Transport;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.wit.env.FxpConstants;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.ui.HasEventBus;
import com.wit.fxp.ui.annotation.LoadingOnStartup;
import com.wit.fxp.ui.error.handler.FxpErrorHandler;
import com.wit.fxp.ui.event.StartupEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.user.HasUserSession;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.user.UserSessionCreator;
import com.wit.fxp.ui.workspace.HasWorkspacePresenter;
import com.wit.fxp.ui.workspace.WorkspacePresenter;

@Title("健康助餐服务系统--坐席工作站")
@SpringUI(path = "/meal")
@Push(transport = Transport.LONG_POLLING)
@Theme("tests-valo-facebook")
@Widgetset("com.wit.fxp.widgetset.AppWidgetSet")
@PreserveOnRefresh
public class MealUI extends UI implements HasEventBus, HasWorkspacePresenter, HasUserSession {

    private static final long serialVersionUID = 8968332560859790861L;

    @Value("${fxp.sendMailOnError:false}")
    private boolean sendEmailOnError;

    @Value("${fxp.exrptName:exrpt}")
    private String exrptName;

    @Autowired private ApplicationContext applicationContext;
    @Autowired private EventBus.UIEventBus eventBus;
    @Autowired private SpringViewProvider viewProvider;
    @Autowired private NxftMealViewChangeListener viewChangeListener;

    @Autowired
    @NxftMealMainPresenterBean
    private AbstractPresenter<? extends Component> mainPresenter;

    @Autowired private UserSessionCreator userSessionCreator;
    @Autowired private UserSession userSession;

    @Override
    protected void init(VaadinRequest request) {
        // 全局错误处理器
        setErrorHandler(new FxpErrorHandler(applicationContext, sendEmailOnError, exrptName));

        Navigator navigator = new Navigator(this, this);
        navigator.addProvider(viewProvider);
        navigator.addViewChangeListener(viewChangeListener);
        setNavigator(navigator);

        setContent(mainPresenter.getView());

        // 子系统登录
        userSessionCreator.createUserSession(DBC.子系统.定餐工作站.value());

        // 加载带LoadingOnStartup注解的对象
        applicationContext.getBeansWithAnnotation(LoadingOnStartup.class);

        saveCookie();

        // 系统启动
        eventBus.publish(this, new StartupEvent());
    }

    @Override
    public EventBus getEventBus() {
        return eventBus;
    }

    /**
     * 返回工作空间。
     *
     * @return
     */
    @Override
    public WorkspacePresenter getWorkspacePresenter() {
        return HasWorkspacePresenter.class.cast(mainPresenter).getWorkspacePresenter();
    }

    private void saveCookie() {
        Cookie cookie = new Cookie(FxpConstants.URL_COOKIE_NAME, "/v/meal");
        cookie.setMaxAge(-1);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        VaadinService.getCurrentResponse().addCookie(cookie);
    }

    @Override
    public UserSession getUserSession() {
        return userSession;
    }

}
