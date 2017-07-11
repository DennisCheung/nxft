package com.wit.fxp.nxft.ui.components;

import java.util.Set;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.OptionGroup;
import com.wit.datatype.IdAndName;

/**
 *
 * @author qiuxu
 *
 */
public class WCheckBox extends OptionGroup {

    private static final long serialVersionUID = 1L;

    private BeanItemContainer<IdAndName> container = new BeanItemContainer<IdAndName>(IdAndName.class);

    public WCheckBox() {
        super();
        this.setImmediate(true);
        this.setMultiSelect(true);
    }

    public WCheckBox(String caption) {
        super(caption);
        this.setStyleName("myWoptiongroupstyle");
        this.setImmediate(true);
        this.setMultiSelect(true);
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

    @SuppressWarnings("unchecked")
    @Override
    public Set<IdAndName> getValue() {
        return ((Set<IdAndName>) super.getValue());
    }

    public BeanItemContainer<IdAndName> getContainer() {
        return container;
    }

    public void setContainer(BeanItemContainer<IdAndName> container) {
        this.container = container;
    }

}
