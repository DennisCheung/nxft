package com.wit.fxp.nxft.ui.block.foodmenu;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.List;

import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.common.LayoutUtils;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.menu.model.AddMealSetCommand;
import com.wit.fxp.nxft.menu.model.HbcDiseaseModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.nxft.ui.NumberAndLettersValidator;
import com.wit.fxp.vaadin.server.data.fieldgroup.FxpBeanFieldGroup;
import com.wit.fxp.vaadin.ui.WNativeSelect;

/**
 * @author wck
 *
 */
@PrototypeScope
@SpringView(name = AddMealSetView.NAME)
public class AddMealSetViewImpl extends Window implements AddMealSetView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();

    private final HorizontalLayout titlehly = new HorizontalLayout();
    private final Label title = new Label("新增套餐");

    private final VerticalLayout formvly = new VerticalLayout();
    private final TextField mealSetCode = new TextField();
    private final TextField mealSetName = new TextField();
    private final TextField mealSetContent = new TextField();
    private final TextField price = new TextField();
    private final WNativeSelect pungent = new WNativeSelect();
    private final TextField mealSetDesc = new TextField();

    private final Button cancelBtn = new Button("取消");
    private final Button confirmBtn = new Button("保存");
    private final HorizontalLayout btnhly = new HorizontalLayout();

    @Autowired
    @Qualifier("validator")
    private Validator javaxValidator;

    @Override
    public void initView(AddMealSetPresenter presenter, boolean isEdit) {
        buildView();
        addStyle();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void initDict(List<HbcDiseaseModel> hbcDisease, List<MealTypeModel> mealTypeList) {
    }

    @Override
    public void refreshData(MealSetModel mealSet) {
        if (mealSet == null) {
            return;
        }
        title.setValue("修改套餐");
        mealSetName.setValue(mealSet.getMealName());
        mealSetContent.setValue(mealSet.getMealContent());
        DecimalFormat df = new DecimalFormat("########0.00");
        price.setValue(df.format(mealSet.getMealPrice()));
        Integer pepperyLevel = mealSet.getPepperyLevel();
        String pungentId = "0";
        String pungentName = null;
        if (pepperyLevel != null) {
            pungentId = pepperyLevel.toString();
            pungentName = pepperyLevel == 1 ? "有辣" : "无辣";
        }
        else {
            pungentName = "--请选择--";
        }
        pungent.select(new IdAndName(pungentId, pungentName));
        mealSetDesc.setValue(mealSet.getMealDesc());
        mealSetCode.setValue(mealSet.getMealCode());
    }

    private void bind(AddMealSetPresenter presenter) {
        pungent.addWSelectItem(null, "--请选择--");
        pungent.addWSelectItem("1", "有辣");
        pungent.addWSelectItem("2", "无辣");
        pungent.bindData();

        this.cancelBtn.addClickListener(e -> {
            this.close();
        });

        AddMealSetCommand command = new AddMealSetCommand();
        FxpBeanFieldGroup<AddMealSetCommand> group = new FxpBeanFieldGroup<>(javaxValidator, AddMealSetCommand.class);
        group.setItemDataSource(command);
        group.bind(mealSetName, "mealSetName");
        group.bind(mealSetCode, "mealSetCode");
        group.bind(mealSetContent, "mealSetContent");
        group.bind(price, "mealPrice");
        group.bind(pungent, "pepperyLevel");
        group.bind(mealSetDesc, "mealSetDesc");
        this.confirmBtn.addClickListener(e -> {
            try {
                group.commit();
                presenter.saveMealSet(command);
                this.close();
            }
            catch (CommitException e1) {
                Notification.show("您输入的数据有误，请检查！", Notification.Type.WARNING_MESSAGE);
                e1.getInvalidFields().keySet().forEach(field -> field.markAsDirty());
            }
        });
        pungent.select(new IdAndName(null, "--请选择--"));

        mealSetCode.addValidator(new NumberAndLettersValidator("只允许输入数字或字母"));
    }

    private void addStyle() {
        this.mainvly.addStyleName("AddMealSetView");
        this.mainvly.setWidth("100%");
        this.center();
        this.titlehly.setWidth("100%");
        this.setWidth("550px");
        this.setHeightUndefined();
        this.setResizable(false);
        this.setClosable(false);

        this.titlehly.addStyleName("titlehly");
        this.title.addStyleName("title");

        this.formvly.addStyleName("formvly");
        this.mealSetCode.addStyleName("mealSetNo");
        this.mealSetName.addStyleName("mealSetName");
        this.mealSetContent.addStyleName("mealSetContent");
        this.price.addStyleName("price");
        this.pungent.addStyleName("pungent");
        this.mealSetDesc.addStyleName("mealSetDesc");
        this.cancelBtn.addStyleName("cancelBtn");
        this.confirmBtn.addStyleName("confirmBtn");
        this.btnhly.addStyleName("btnhly");

        mealSetContent.setInputPrompt("菜1+菜2+菜3+汤");
        mealSetContent.setDescription("菜1+菜2+菜3+汤");

        pungent.setNullSelectionAllowed(false);
    }

    private void buildView() {
        this.setContent(mainvly);

        mainvly.addComponents(titlehly, formvly, btnhly);
        btnhly.addComponents(cancelBtn, confirmBtn);

        titlehly.addComponent(title);

        formvly.addComponent(LayoutUtils.getHorLayout("套餐编号：", "100px", mealSetCode, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("套餐名称：", "100px", mealSetName, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("套餐内容：", "100px", mealSetContent, ""));
        formvly.addComponent(LayoutUtils.getHorLayout("单价：", "100px", price, "", "元"));
        formvly.addComponent(LayoutUtils.getHorLayout("辣：", "100px", pungent, "150px"));
        formvly.addComponent(LayoutUtils.getHorLayout("备注：", "100px", mealSetDesc, ""));
    }

}
