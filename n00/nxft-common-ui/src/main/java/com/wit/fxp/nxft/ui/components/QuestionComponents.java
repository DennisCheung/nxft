package com.wit.fxp.nxft.ui.components;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.datatype.RadioOption;

/**
 * 文件主项目选项
 * @author qiuxu
 *
 */
public class QuestionComponents extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    private QuestionComponent option;

    public QuestionComponents(List<IdAndName> titles) {
        titles.forEach(e -> {
            option = new QuestionComponent(e);
            option.getItem().setItemCaptionMode(ItemCaptionMode.EXPLICIT);
            option.getItem().setStyleName("optionItemStyle");
            addComponents(option);
        });

    }

    public List<RadioOption<Integer>> getValue() {
        List<RadioOption<Integer>> values = new ArrayList<RadioOption<Integer>>();
        Iterator<Component> coms = this.iterator();
        while (coms.hasNext()) {
            Component com = coms.next();
            if (com instanceof QuestionComponent) {
                values.add(((QuestionComponent) com).getValue());
            }
        }
        return values;
    }

    public QuestionComponent getOption() {
        return option;
    }

    public void setOption(QuestionComponent option) {
        this.option = option;
    }

}
