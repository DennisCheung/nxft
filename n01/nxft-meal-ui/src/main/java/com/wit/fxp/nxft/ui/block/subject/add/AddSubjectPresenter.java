package com.wit.fxp.nxft.ui.block.subject.add;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.datatype.IdAndName;
import com.wit.fxp.file.app.dict.DictApp;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.command.AddSubjectCommand;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshChartEvent;
import com.wit.fxp.nxft.ui.block.recharge.event.RefreshSubjectManagerEvent;
import com.wit.fxp.ui.presenter.AbstractPresenter;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.regionalism.RegionalismPresenter;
import com.wit.fxp.ui.user.UserSession;

@PrototypeScope
@VaadinPresenter(viewName = AddSubjectView.NAME)
public class AddSubjectPresenter extends AbstractPresenter<AddSubjectView> {

    @Autowired private SubjecctApp app;
    @Autowired private DictApp dictApp;
    @Autowired private UserSession userSession;
    @Autowired private RegionalismPresenter regPresenter;

    @Autowired
    public AddSubjectPresenter(EventBus.UIEventBus eventBus, AddSubjectView view) {
        super(eventBus, view);
    }

    public void postInit() {
        getView().initView(this, regPresenter);
        refreshDict();
    }

    public SubjectModel findByIdNo(String idNo) {
        return app.findSubjectByIdNo(idNo);
    }

    public SubjectModel findByPhone(String phone) {
        return app.findSubjectByPhone(phone);
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

        regPresenter.initView();
        regPresenter.getView().setEditMode(true);
        getView().showRegion(regPresenter.getView());
    }

    public void addSubject(AddSubjectCommand command) {
        command.setRegionId(regPresenter.getView().getRegionId());
        app.addSubject(userSession.getInvoker(), command);

        getEventBus().publish(this, new RefreshSubjectManagerEvent());
        getEventBus().publish(this, new RefreshChartEvent());
    }

}
