package com.wit.fxp.nxft.ui.block.subject.show;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.vaadin.ui.Notification;
import com.wit.datatype.IdAndName;
import com.wit.fxp.file.app.dict.DictApp;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.command.AddSubjectCommand;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.regionalism.RegionalismPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = ShowSubjectView.NAME)
public class ShowSubjectPresenter extends AbstractPresenter<ShowSubjectView> {

    @Autowired private SubjecctApp app;
    @Autowired private UserSession userSession;
    @Autowired private RegionalismPresenter regPresenter;
    @Autowired private DictApp dictApp;

    private String subjectId;

    @Autowired
    public ShowSubjectPresenter(EventBus.UIEventBus eventBus, ShowSubjectView view) {
        super(eventBus, view);
    }

    public void postInit(String subjectId) {
        getView().initView(this);
        this.subjectId = subjectId;
        refreshDict();
        showValue();
    }

    public boolean checkIdNo(String idNo) {
        SubjectModel model = app.findSubjectByIdNo(idNo);
        return !(model != null && !model.getId().equals(subjectId));
    }

    public boolean checkPhone(String phone) {
        SubjectModel model = app.findSubjectByPhone(phone);
        return !(model != null && !model.getId().equals(subjectId));
    }

    public void refreshDict() {
        List<IdAndName> diseases = app.findSubjectDiseases();
        List<IdAndName> teams = app.findTeams(userSession.getCircleId());
        List<IdAndName> types = app.findSubjectTypes();
        List<IdAndName> hits = app.findFoodhibits();
        List<IdAndName> livs = dictApp.getLivingCondiModels().stream().map(e -> new IdAndName(e.getId(), e.getLivingCondiName()))
                .collect(Collectors.toList());
        List<IdAndName> govs = dictApp.findGovHelps();
        List<IdAndName> relations = dictApp.getHouseRelationModels().stream().map(e -> new IdAndName(e.getId(), e.getHouseRelationName()))
                .collect(Collectors.toList());
        List<IdAndName> fls = app.findFoodLove();
        getView().refreshDict(teams, types, diseases, livs, govs, hits, relations, fls);
    }

    public void editSubject(AddSubjectCommand command) {
        if (regPresenter.getView().getRegionId() == null) {
            Notification.show("请选择行政区划！");
            return;
        }
        command.setSubjectId(subjectId);
        command.setRegionId(regPresenter.getView().getRegionId());
        app.editSubject(userSession.getInvoker(), command);
    }

    public void showValue() {
        SubjectModel model = app.findSubjectModel(subjectId);
        getView().refreshValue(model);

        regPresenter.initView();
        regPresenter.getView().setEditMode(true);
        regPresenter.showRegionalism(model.getRegionId());
        getView().showRegion(regPresenter.getView());
    }

}
