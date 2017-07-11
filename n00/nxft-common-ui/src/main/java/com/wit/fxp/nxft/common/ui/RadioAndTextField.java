package com.wit.fxp.nxft.common.ui;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;

public class RadioAndTextField extends CustomField<IdAndName> {

    private static final long serialVersionUID = 1L;

    private final HorizontalLayout horMainLayout = new HorizontalLayout();
    private final BeanItemContainer<IdAndName> container = new BeanItemContainer<IdAndName>(IdAndName.class);
    private final OptionGroup radio = new OptionGroup();
    private final TextField other = new TextField();

    public RadioAndTextField() {
        super();
        horMainLayout.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        radio.setMultiSelect(false);
        radio.setImmediate(true);
        radio.addStyleName("wradio");
        radio.setContainerDataSource(container);
        radio.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        radio.setItemCaptionPropertyId("name");
        other.addStyleName("wradio");
        horMainLayout.addComponents(radio);
    }

    public void addOption(String id, String name) {
        this.container.addItem(new IdAndName(id, name));
        if ("99".equals(id) || "其他".equals(name)) {
            horMainLayout.addComponent(other);
        }
    }

    public void removeWAllItems() {
        this.radio.removeAllItems();
        this.container.removeAllItems();
        this.other.clear();
    }

    @Override
    public IdAndName getValue() {
        IdAndName value = (IdAndName) this.radio.getValue();
        if (value != null) {
            if ("99".equals(value.getId()) || "其他".equals(value.getName())) {
                return new IdAndName(value.getId(), this.other.getValue());
            }
            else {
                return value;
            }
        }
        else {
            return IdAndName.EMPTY;
        }
    }

    @Override
    protected Component initContent() {
        return horMainLayout;
    }

    @Override
    public Class<? extends IdAndName> getType() {
        return IdAndName.class;
    }

}
