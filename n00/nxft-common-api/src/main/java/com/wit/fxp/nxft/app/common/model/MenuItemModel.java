package com.wit.fxp.nxft.app.common.model;

import lombok.AllArgsConstructor;
import lombok.Value;

/**
 * 菜单项目
 * @author Administrator
 *
 */
@Value
@AllArgsConstructor
public class MenuItemModel {

    private String menuText;
    private String menuName;

}
