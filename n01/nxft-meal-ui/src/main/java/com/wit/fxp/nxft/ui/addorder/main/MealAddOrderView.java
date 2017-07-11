package com.wit.fxp.nxft.ui.addorder.main;

import java.util.Date;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.app.common.model.KitchenMenuData;
import com.wit.fxp.nxft.app.model.SubjectModel;

public interface MealAddOrderView extends View, Component {

    String NAME = "mealAddOrderView";

    void initView(MealAddOrderPresenter presenter);

    void addMeal(List<KitchenMenuData> datas, MealAddOrderPresenter presenter);

    void addDate(Date next);

    void refreshSubjectInfo(SubjectModel subject, Double yue);
}
