package com.wit.fxp.nxft.ui.components;

import java.util.List;
import java.util.stream.Collectors;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.OptionGroup;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.datatype.RadioOption;

/**
 *
 * @author qiuxu
 *
 */
public class WRadioButton extends OptionGroup {

    private static final long serialVersionUID = 1L;

    private BeanItemContainer<IdAndName> container = new BeanItemContainer<IdAndName>(IdAndName.class);

    public WRadioButton() {
        super();
        this.setImmediate(true);
    }

    public WRadioButton(String caption) {
        super(caption);
        this.setStyleName("myWoptiongroupstyle");
        this.setImmediate(true);
        this.setMultiSelect(false);
    }

    public void bindData() {
        this.setContainerDataSource(container);
        this.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        this.setItemCaptionPropertyId("name");

    }

    public Item addOptionItem(String id, String item) {
        return this.container.addItem(new IdAndName(id, item));
    }

    public void removeWAllItems() {
        this.removeAllItems();
        this.container.removeAllItems();

    }

    @Override
    public IdAndName getValue() {
        IdAndName value = (IdAndName) super.getValue();
        if (value != null) {
            return value;
        }
        else {
            return IdAndName.EMPTY;
        }

    }

    public List<RadioOption<Boolean>> getWholeValue() {
        return this.getContainerDataSource().getItemIds().stream()
        .map(e -> {
            IdAndName option = (IdAndName) e;
            RadioOption<Boolean> radio = new RadioOption<Boolean>(option.getId(), option.getName(), option == this.getValue(), null);
            return radio;
        })
        .collect(Collectors.toList());
    }

    public BeanItemContainer<IdAndName> getContainer() {
        return container;
    }

    public void setContainer(BeanItemContainer<IdAndName> container) {
        this.container = container;
    }

    public void initOptions() {
        this.addOptionItem("5", "很满意");
        this.addOptionItem("4", "满意");
        this.addOptionItem("3", "一般");
        this.addOptionItem("2", "不满意");
        this.addOptionItem("1", "很不满意");
        this.bindData();
    }

    @Override
    protected void setValue(Object newValue, boolean repaintIsNotNeeded) {
        IdAndName oldValue = this.getValue();
        if (oldValue != null && oldValue.equals(newValue)) {
            super.setValue(null, repaintIsNotNeeded);
        }
        else {
            super.setValue(newValue, repaintIsNotNeeded);
        }
    }

}
