package com.wit.fxp.nxft.personpage;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.data.Item;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.Tree;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.personpage.leftmenu.LeftMenuContainerUtil;
import com.wit.fxp.nxft.utils.StringUtils;
import com.wit.fxp.vaadin.ui.HorLabelAndLabel;

/**
 * 客户主页
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = PersonPageView.NAME)
public class PersonPageViewImpl extends CustomComponent implements PersonPageView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();
    private final VerticalLayout mainWrapvly = new VerticalLayout();

    private final HorizontalLayout tophly = new HorizontalLayout();
    private final HorizontalLayout topLefthly = new HorizontalLayout();
    private final HorizontalLayout topRighthly = new HorizontalLayout();
    private final Button callBtn = new Button("呼叫");
    private final Button smsBtn = new Button("短信");
    private final HorizontalSplitPanel bottomhsp = new HorizontalSplitPanel();

    private final HorizontalSplitPanel bottomLefthsp = new HorizontalSplitPanel();
    private final VerticalLayout bottomRightvly = new VerticalLayout();

    private final Label personName = new Label();
    private final HorLabelAndLabel personSex = new HorLabelAndLabel("性别", "");
    private final HorLabelAndLabel personAge = new HorLabelAndLabel("年龄", "");
    private final HorLabelAndLabel mobile = new HorLabelAndLabel("手机号码", "");
    private final HorLabelAndLabel address = new HorLabelAndLabel("地址", "");

    private final VerticalLayout leftMenuLayout = new VerticalLayout();
    private final Tree menuTree = new Tree();
    @Autowired private LeftMenuContainerUtil leftMenuContainerUtil;

    @Override
    public void initView(PersonPagePresenter presenter, String subjectId) {
        buildView(subjectId);
        configure();
        addStyle();
        bind(presenter);
    }

    @Override
    public void setBottomRight(Component component) {
        this.bottomhsp.setSecondComponent(component);
    }

    @Override
    public void refreshData() {
    }

    @Override
    public void setPersonInfoShowView(Component personView) {
        if (personView != null) {
            this.bottomLefthsp.setSecondComponent(personView);
        }
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    @Override
    public void selectSfNote(String sfNoteId) {
        menuTree.getItemIds().forEach(e -> {
            Item item = menuTree.getItem(e);
            Object id = item.getItemProperty(LeftMenuContainerUtil.ID).getValue();
            if (id != null && sfNoteId.equals(id.toString())) {
                menuTree.select(e);
                menuTree.expandItemsRecursively(menuTree.getParent(e));
            }
        });
    }

    private void bind(PersonPagePresenter presenter) {
        menuTree.addValueChangeListener(e -> {
            Item item = menuTree.getItem(e.getProperty().getValue());
            if (item != null && item.getItemProperty(LeftMenuContainerUtil.VIEWNAME) != null) {
                Object viewName = item.getItemProperty(LeftMenuContainerUtil.VIEWNAME).getValue();
                Object params = item.getItemProperty(LeftMenuContainerUtil.PARAMS).getValue();
                Object id = item.getItemProperty(LeftMenuContainerUtil.ID).getValue();
                if (!StringUtils.isEmpty(String.valueOf(viewName))) {
                    presenter.openPersonInfoView(String.valueOf(viewName), params, id);
                }
                else {
                    if (menuTree.isExpanded(e.getProperty().getValue())) {
                        menuTree.collapseItemsRecursively(e.getProperty().getValue());
                    }
                    else {
                        menuTree.expandItemsRecursively(e.getProperty().getValue());
                    }
                }
            }
        });
    }

    private void addStyle() {
        Page page = Page.getCurrent();
        if (page.getBrowserWindowWidth() > 1230) {
            this.mainvly.setWidth(page.getBrowserWindowWidth() - 4 + "px");
        }
        else {
            this.mainvly.setWidth("1356px");
        }
        mainvly.setHeight(page.getBrowserWindowHeight() - 95 + "px");
        topLefthly.setWidth((Float.parseFloat(page.getBrowserWindowWidth() + "") / 1356f) * 1150 + "px");
        page.addBrowserWindowResizeListener(e -> {
            if (page.getBrowserWindowWidth() > 1230) {
                this.mainvly.setWidth(page.getBrowserWindowWidth() - 4 + "px");
                topLefthly.setWidth((Float.parseFloat(page.getBrowserWindowWidth() + "") / 1356f) * 1150 + "px");
            }
            if (page.getBrowserWindowHeight() > 590) {
                mainvly.setHeight(page.getBrowserWindowHeight() - 95 + "px");
            }
        });
        this.mainvly.addStyleName("personpageview");
        this.tophly.addStyleName("tophly");
        this.bottomhsp.addStyleName("bottomhsp");
        this.bottomLefthsp.addStyleName("bottomlefthsp");
        this.personName.addStyleName("personname");
        this.topLefthly.addStyleName("toplefthly");
        this.topRighthly.addStyleName("toprighthly");
        this.topRighthly.addStyleName("btn-1");
        this.leftMenuLayout.setSizeFull();
    }

    private void buildView(String subjectId) {
        mainvly.addComponents(mainWrapvly);
        mainWrapvly.addComponents(tophly);
        mainWrapvly.addComponents(bottomhsp);
        bottomhsp.setFirstComponent(bottomLefthsp);
        bottomhsp.setSecondComponent(bottomRightvly);
        HorizontalLayout hor1 = new HorizontalLayout();
        HorizontalLayout hor2 = new HorizontalLayout();
        hor2.addComponents(personName, personSex, personAge, mobile, address);
        topLefthly.addComponent(hor2);
        topRighthly.addComponents(callBtn, smsBtn);
        hor1.addComponents(topLefthly, topRighthly);
        tophly.addComponent(hor1);

        buildBottomLeft(subjectId);
        this.setCompositionRoot(mainvly);
    }

    private void buildBottomLeft(String subjectId) {
        this.bottomLefthsp.setFirstComponent(leftMenuLayout);
        this.bottomLefthsp.setSecondComponent(new Label("健康监测！"));
        buildLeftMenuLayout(subjectId);
    }

    private void buildLeftMenuLayout(String subjectId) {
        leftMenuLayout.addComponent(menuTree);
        menuTree.setContainerDataSource(leftMenuContainerUtil.getContainer(subjectId));
        menuTree.setImmediate(true);
        menuTree.setItemCaptionPropertyId(LeftMenuContainerUtil.NAME);
        menuTree.setItemCaptionMode(ItemCaptionMode.PROPERTY);
    }

    private void configure() {
        tophly.setWidth("100%");
        tophly.setHeight("40px");
        bottomhsp.setWidth("100%");
        bottomhsp.setHeight("1000px");
        bottomhsp.setSplitPosition(50, Unit.PERCENTAGE);
        bottomLefthsp.setWidth("99%");
        bottomLefthsp.setHeight("100%");
        bottomLefthsp.setSplitPosition(20, Unit.PERCENTAGE);
        bottomRightvly.setWidth("100%");
        bottomRightvly.setHeight("100%");
        personName.setWidth("180px");
        personSex.getLbright().setWidth("60px");
        personAge.getLbright().setWidth("60px");
        mobile.getLbright().setWidth("200px");
        address.getLbright().setWidth("390px");
    }

}
