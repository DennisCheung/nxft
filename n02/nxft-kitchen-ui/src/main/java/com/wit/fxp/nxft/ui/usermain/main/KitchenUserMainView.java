package com.wit.fxp.nxft.ui.usermain.main;

import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.ui.Component;
import com.wit.fxp.nxft.ui.usermain.TeamViewModel;

/**
 * 我的主页(操作员主页)
 * @author qiuxu
 *
 */
public interface KitchenUserMainView extends View, Component {

    void refreshView(Component shortCutMenu, Component workTips, Component notice);

    void refreshLoginInfo(String userId, String nickName, String deptName);

    void initChangeSiteMenu(List<TeamViewModel> models, KitchenUserMainPresenter scToolbarPresenter);
}
