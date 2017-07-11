package com.wit.fxp.nxft.ui.usermain.block.worktips;

import java.io.Serializable;
import java.util.Iterator;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.ThemeResource;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.Runo;

@PrototypeScope
@SpringView(name = WorkTipsView.NAME)
public class WorkTipsViewImpl extends CustomComponent implements WorkTipsView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout contenthly = new HorizontalLayout();

    private final GridLayout leftGrid = new GridLayout();

    private final VerticalLayout rightLayout = new VerticalLayout();

    private final Label title = new Label("工作提醒");

    private final Button refreshBtn = new Button("");

    @Override
    public void refreshData(WorkTipsModel workTipsModel) {
    }

    @Override
    public void initView(WorkTipsPresenter presenter) {
        this.setCompositionRoot(mainvly);
        addStyle();
        buildView();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    private void buildView() {
        HorizontalLayout titleHor = new HorizontalLayout();
        titleHor.addStyleName("titlehor");
        titleHor.addComponents(this.title, this.refreshBtn);
        this.refreshBtn.setIcon(new ThemeResource("ico/fresh2.png"));
        this.mainvly.addComponent(titleHor);
        this.mainvly.addComponent(contenthly);
        this.contenthly.addComponent(this.leftGrid);
        this.contenthly.addComponent(this.rightLayout);

        buildLeftGrid();
    }

    private void bind(WorkTipsPresenter presenter) {
        refreshBtn.addClickListener(e -> refreshAll(presenter));
    }

    private void refreshAll(WorkTipsPresenter presenter) {
        presenter.refreshData();
    }

    private void addStyle() {
        mainvly.setSizeFull();
        this.mainvly.addStyleName("WorkTipsView");
        title.addStyleName("title-1");
        this.leftGrid.setRows(5);
        this.leftGrid.setColumns(2);
        this.leftGrid.setColumnExpandRatio(0, 5);
        this.leftGrid.setColumnExpandRatio(1, 2);
    }

    private void buildLeftGrid() {
        Iterator<Component> iterator = this.leftGrid.iterator();
        while (iterator.hasNext()) {
            Component next = iterator.next();
            if (next instanceof Button) {
                Button button = (Button) next;
                button.addStyleName(Runo.BUTTON_LINK);
                button.setWidth("80px");
            }
        }
    }

}
