package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

/**
 * 该视图用于那种元素比较少的弹窗界面 添加 编辑
 * 一般样式为 最上面标题。中间formLayou表单元素，下面 编辑添加保存按钮，退出按钮
 * 添加的元素跟顺序有关系 (从上到下) 跟指定类型有关
 * 使用的时候需要给它设置一个样式 （设置一个 宽 高 然后居中显示）
 * @author qiuxu
 *
 */
@SuppressWarnings("serial")
public class OperationLayout extends VerticalLayout {

    /**
     * 顶部块
     * 标题元素 用来显示该视图标题
     */
    private final Label lbtitle = new Label();
    private final HorizontalLayout horTitle = new HorizontalLayout();

    /**
     *中间快
     *表单元素
     */
    private final FormLayout formLayout = new FormLayout();

    /**
     * 按钮 当传入2个 Button（一般是 保存 取消）自动加入到这里
     */
    private final HorizontalLayout horButton = new HorizontalLayout();

    /**
     * Constructs an empty OperationLayout.
     */
    public OperationLayout() {
        setWidth("100%");
        addStyle();
        setTopInfo();
        addComponents(horTitle, formLayout, horButton);
    }

    /**
     * 设置标题
     * @param title
     */
    public void setTitle(String title) {
        lbtitle.setValue(title);
    }

    /**
     * 设置顶部区域
     */
    private void setTopInfo() {
        horTitle.addComponent(lbtitle);
    }

    /**
     * 样式控制
     */
    private void addStyle() {
        this.setSizeUndefined();
        formLayout.setSizeFull();
        horTitle.setSizeFull();
        horButton.setSizeUndefined();
        this.setStyleName("operationstyle");
        horTitle.addStyleName("hortitlestyle");
        formLayout.addStyleName("formstyle");
        horButton.addStyleName("horbuttonstyle");
    }

    /**
     * 单个添加
     * @param c
     */
    public void addMyComponent(Component c) {
        if (c instanceof Button) {
            horButton.addComponents(c);
        }
        else {
            formLayout.addComponents(c);
        }

    }

    /**
     * 一次性添加(跟左右顺序有没有关系  暂时未做测试)
     * @param components
     */
    public void addMyComponents(Component...components) {
        for (Component component : components) {
            if (component instanceof Button) {
                horButton.addComponents(component);
            }
            else {
                formLayout.addComponents(component);
            }
        }
    }

}
