package com.wit.fxp.nxft.common.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.AbstractSelect.ItemCaptionMode;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomField;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.wit.datatype.IdAndName;

public class OptionGroupAndTextField extends CustomField<List<IdAndName>> {

    private static final long serialVersionUID = 1L;

    private final HorizontalLayout horMainLayout = new HorizontalLayout();

    private final BeanItemContainer<IdAndName> container = new BeanItemContainer<IdAndName>(IdAndName.class);
    private final OptionGroup radio = new OptionGroup();
    private final TextField other = new TextField();
    private boolean isUseCheckBox = false;
    private List<IdAndName> value = null;

    public OptionGroupAndTextField() {
        horMainLayout.addStyleName(ValoTheme.LAYOUT_HORIZONTAL_WRAPPING);
        build();
    }

    public OptionGroupAndTextField(boolean isUseCheckBox) {
        this();
        this.isUseCheckBox = isUseCheckBox;
        build();
    }

    private void build() {
        if (!isUseCheckBox) {
            other.addStyleName("contentlabel");
            radio.setMultiSelect(true);
            radio.setImmediate(true);
            radio.addStyleName("wradio");
            radio.setContainerDataSource(container);
            radio.setItemCaptionMode(ItemCaptionMode.PROPERTY);
            radio.setItemCaptionPropertyId("name");
            horMainLayout.addComponents(radio);
            other.addStyleName("wradio");
        }
    }

    public void removeWAllItems() {
        this.radio.removeAllItems();
        this.container.removeAllItems();
        this.other.clear();
    }

    private void addWOption(String id, String name) {
        CheckBox checkBox = new CheckBox(name);
        checkBox.setId(id);
        horMainLayout.addComponent(checkBox);
        if ("99".equals(id) || "其他".equals(name)) {
            horMainLayout.addComponent(other);
            checkBox.addValueChangeListener(e -> {
                if (checkBox.getValue()) {
                    other.setReadOnly(false);
                }
                else {
                    other.setReadOnly(true);
                }
            });
        }
    }

    private void addOOption(String id, String name) {
        this.container.addItem(new IdAndName(id, name));
        if ("99".equals(id) || "其他".equals(name)) {
            horMainLayout.addComponent(other);
        }
    }

    public OptionGroupAndTextField addOption(String id, String name) {
        if (this.isUseCheckBox) {
            addWOption(id, name);
        }
        else {
            addOOption(id, name);
        }
        return this;
    }

    @Override
    public List<IdAndName> getValue() {
        if (this.isUseCheckBox) {
            Iterator<Component> coms = horMainLayout.iterator();
            List<IdAndName> list = new ArrayList<>();
            while (coms.hasNext()) {
                Component com = coms.next();
                if (com instanceof CheckBox) {
                    CheckBox checkBox = (CheckBox) com;
                    if (checkBox.getValue()) {
                        if ("99".equals(checkBox.getId()) || "其他".equals(checkBox.getCaption())) {
                            list.add(new IdAndName(checkBox.getId(), other.getValue()));
                        }
                        else {
                            list.add(new IdAndName(checkBox.getId(), checkBox.getCaption()));
                        }
                    }
                }
            }
            value = list;
            return list;
        }
        else {
            List<IdAndName> itemIds = this.container.getItemIds();
            List<IdAndName> collect = itemIds.stream()
                    .filter(e -> this.radio.isSelected(e))
                    .map(e -> {
                        if ("99".equals(e.getId()) || "其他".equals(e.getName())) {
                            e.setName(this.other.getValue());
                        }
                        return e;
                    })
                    .collect(Collectors.toList());
            value = collect;
            return collect;
        }
    }

    @Override
    protected Component initContent() {
        return horMainLayout;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends List<IdAndName>> getType() {
        return (Class<? extends List<IdAndName>>) value.getClass();
    }

    public void selectItem(Object itemId) {
        radio.select(itemId);
    }

    public void selectOtherItem(Object itemId, String otherValue) {
        radio.select(itemId);
        this.other.setValue(otherValue);
    }

}
