package com.wit.fxp.nxft.personpage;

import java.util.Map;
import java.util.WeakHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.Component;
import com.wit.fxp.nxft.personpage.section.PersonPageInfoHandler;
import com.wit.fxp.nxft.personpage.section.PersonPageRightPartParams;
import com.wit.fxp.nxft.personpage.section.PersonWorkPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;

@PrototypeScope
@VaadinPresenter(viewName = PersonPageView.NAME)
public class PersonPagePresenter extends AbstractPagePresenter<PersonPageView> {

    private final Map<String, PersonPageInfoHandler> personInfoPresenterMap = new WeakHashMap<>();
    private final ApplicationContext applicationContext;

    private PersonPageInfoHandler personPageInfoHandler;
    private PersonWorkPresenter personWorkPresenter;

    private String subjectId;

    @Autowired
    public PersonPagePresenter(EventBus.UIEventBus eventBus, PersonPageView view,
            ApplicationContext applicationContext) {
        super(eventBus, view);
        this.applicationContext = applicationContext;
    }

    @Override
    public void initPage(Object parameters) {
        if (parameters != null && parameters instanceof PersonPageRightPartParams) {
            Map<String, PersonPageInfoHandler> personInfoViewMap = this.applicationContext.getBeansOfType(PersonPageInfoHandler.class);
            for (Map.Entry<String, PersonPageInfoHandler> entry : personInfoViewMap.entrySet()) {
                personInfoPresenterMap.put(entry.getValue().viewName(), entry.getValue());
            }
            PersonPageRightPartParams params = (PersonPageRightPartParams) parameters;
            this.subjectId = params.getSubjectId();
            personWorkPresenter = params.getPersonWorkPresenter();
            personWorkPresenter.postInit(this, this.subjectId, params.getParams());
            getView().initView(this, this.subjectId);
            getView().refreshData();
            setBottomRight(personWorkPresenter.getPersonView());
        }
        else {
            throw new IllegalArgumentException("参数为空或者参数错误!请检查");
        }

    }

    private void setBottomRight(Component component) {
        getView().setBottomRight(component);
    }

    public void openPersonInfoView(String viewName, Object params, Object id) {
        personPageInfoHandler = this.personInfoPresenterMap.get(viewName);
        if (personPageInfoHandler == null) {
            throw new RuntimeException("暂无相关实现界面！");
        }
        getView().setPersonInfoShowView(personPageInfoHandler.handle(this, this.subjectId, params));
    }

    public void setBottomRightView(PersonWorkPresenter personWorkPresenter) {
        this.personWorkPresenter = personWorkPresenter;
        setBottomRight(personWorkPresenter.getPersonView());
    }

    public void setBottomRightView(PersonWorkPresenter personWorkPresenter, Object params) {
        this.personWorkPresenter = personWorkPresenter;
        personWorkPresenter.postInit(this, this.subjectId, params);
        setBottomRight(personWorkPresenter.getPersonView());
    }

    public void refreshLeftPage() {
        if (this.personPageInfoHandler != null) {
            this.personPageInfoHandler.handle(this, subjectId, null);
        }
    }

}
