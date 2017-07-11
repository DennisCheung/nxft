package com.wit.fxp.nxft.ui.components;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.datatype.RadioOption;

/**
 * 文件主项目选项
 * @author qiuxu
 *
 */
public class QuestionComponent extends HorizontalLayout {

    private static final long serialVersionUID = 1L;

    private final Label title;
    private final WRadioButton item;

    public QuestionComponent(IdAndName title) {
        this.title = new Label();
        this.title.setId(title.getId());
        this.title.setValue(title.getName());
        item = new WRadioButton();
        item.initOptions();
        addComponents(this.title, item);
    }

    public Label getTitle() {
        return title;
    }

    public WRadioButton getItem() {
        return item;
    }

    public RadioOption<Integer> getValue() {
        return new RadioOption<Integer>(title.getId(), title.getValue(), item.getValue() == IdAndName.EMPTY ? null : Integer.parseInt(item.getValue().getId()),
                null);
    }

}
