package com.wit.fxp.nxft.ui.block.subject;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;
import org.vaadin.spring.events.annotation.EventBusListenerMethod;

import com.benewit.core.env.RuntimeContext;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.app.selectdata.SubjectSelectInfo;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshSubjectManagerEvent;
import com.wit.fxp.nxft.ui.block.subject.add.AddSubjectPresenter;
import com.wit.fxp.nxft.ui.block.subject.show.ShowSubjectPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.user.UserSession;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;

@PrototypeScope
@VaadinPresenter(viewName = SubjectManagerView.NAME)
public class SubjectManagerPresenter extends AbstractPagePresenter<SubjectManagerView> {

    @Autowired private UserSession userSession;
    @Autowired private SubjecctApp app;
    @Autowired private RuntimeContext runtimeContext;
    @Autowired private ApplicationContext applicationContext;

    @Autowired
    public SubjectManagerPresenter(EventBus.UIEventBus eventBus, SubjectManagerView view) {
        super(eventBus, view);
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(this);
        refreshAll();
        refreshTeam();
    }

    public void refreshTeam() {
        List<IdAndName> teams = app.findTeams(userSession.getCircleId());
        getView().refreshTeams(teams);
    }

    public void refreshAll() {

        getView().refreshData(toViewModels(app.findSubjects(userSession.getInvoker(), null, 0)));

        int rowCount = app.fintSubjectRowCount(userSession.getInvoker(), null);
        int pageNum = (rowCount - 1) / 8 + 1;
        getView().refreshPageInfo(String.valueOf(pageNum), rowCount);
    }

    public int getPageTotalNum(SubjectSelectInfo info) {
        int rowCount = app.fintSubjectRowCount(userSession.getInvoker(), info);
        return (rowCount - 1) / 8 + 1;
    }

    public void subjectQuery(SubjectSelectInfo info, int pageNum) {
        List<SubjectModel> models = app.findSubjects(userSession.getInvoker(), info, pageNum);
        getView().refreshData(toViewModels(models));

        int rowCount = app.fintSubjectRowCount(userSession.getInvoker(), info);
        int pageSize = (rowCount - 1) / 8 + 1;
        getView().refreshPageInfo(String.valueOf(pageSize), rowCount);
    }

    public List<SubjectViewModel> toViewModels(List<SubjectModel> models) {
        return models.stream()
                .map(e -> {
                    HorizontalLayout hor = new HorizontalLayout();
                    Button btn2 = new Button("详情");
                    btn2.setStyleName(ValoTheme.BUTTON_LINK);
                    hor.addComponents(btn2);
                    btn2.addClickListener(f -> openShow(e.getId()));

                    SubjectViewModel model = SubjectViewModel.builder()
                              ._subjectId_(e.getId())
                              ._name______(e.getPersonInfo().getSubjectName())
                              ._gender____(e.getPersonInfo().getSexName())
                              ._age_______(com.wit.fxp.nxft.utils.DateUtils.calcAge(runtimeContext.getCurrentDate(), e.getPersonInfo().getBirthDate()))
                              ._idNo______(e.getSubjectInfo().getDeliveSiteName())
                              ._type______(e.getSubjectInfo().getSubjectTypeName())
                              ._phone_____(e.getContactPhone())
                              ._sendType__(e.getSubjectInfo().getDeliveType().equals("SITE") ? "助餐点" : "到户上门")
                              ._address___(new Label(e.getAddress()))
                              ._hand______(hor)
                              ._build_();
                    return model;
                })
                  .collect(Collectors.toList());
    }

    public void openAddSubject() {
        AddSubjectPresenter presenter = applicationContext.getBean(AddSubjectPresenter.class);
        presenter.postInit();
        UI.getCurrent().addWindow((Window) presenter.getView());
    }

    private void openShow(String subjectId) {
        ShowSubjectPresenter presenter = applicationContext.getBean(ShowSubjectPresenter.class);
        presenter.postInit(subjectId);
        UI.getCurrent().addWindow((Window) presenter.getView());
    }

    @EventBusListenerMethod
    void onAddSubject(RefreshSubjectManagerEvent event) {
        refreshAll();
    }

}
