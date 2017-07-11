package com.wit.fxp.nxft.ui.workbench;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import org.vaadin.spring.events.EventBus;

import com.wit.fxp.nxft.ui.ViewName;
import com.wit.fxp.ui.presenter.VaadinPresenter;
import com.wit.fxp.ui.todo.dept.DeptTodoPresenter;
import com.wit.fxp.ui.todo.user.UserTodoPresenter;
import com.wit.fxp.ui.workspace.AbstractPagePresenter;

@PrototypeScope
@VaadinPresenter(viewName = ViewName.WORKBENCH_VIEW_NAME)
public class WorkbenchPresenter extends AbstractPagePresenter<WorkbenchView> {

    @Autowired private DeptTodoPresenter deptTaskPresenter;
    @Autowired private UserTodoPresenter userTaskPresenter;

    @Autowired
    public WorkbenchPresenter(EventBus.UIEventBus eventBus, WorkbenchView view) {
        super(eventBus, view);
    }

    @Override
    public void initPage(Object parameters) {
        getView().initView(deptTaskPresenter.getView(), userTaskPresenter.getView());

        deptTaskPresenter.postInit();
        userTaskPresenter.postInit();
    }

}
