package com.wit.fxp.nxft.ui.components;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.NativeSelect;
import com.wit.datatype.IdAndName;

public class WNativeSelect extends NativeSelect {

    private static final long serialVersionUID = 1L;
    private BeanItemContainer<IdAndName> container = new BeanItemContainer<IdAndName>(IdAndName.class);

    public WNativeSelect() {
        super();
        this.setNewItemsAllowed(false);
        this.setImmediate(false);
    }

    public WNativeSelect(String caption) {
        super(caption);
        this.setNewItemsAllowed(false);
        this.setImmediate(false);
    }

    public void bindData() {
        this.setContainerDataSource(container);
        this.setItemCaptionMode(ItemCaptionMode.PROPERTY);
        this.setItemCaptionPropertyId("name");
    }

    /** 添加项目 */
    public Item addWSelectItem(String itemId, String itemCaption) {
        return this.container.addItem(new IdAndName(itemId, itemCaption));
    }

    /** 设置没有项目被选中  */
    public void clearSelected() {
        this.select(this.getNullSelectionItemId());
    }

    /** 取得被选中的项目 */
    public IdAndName getSelectedWItem() {
        if (this.getValue() != null) {
            return (IdAndName) this.getValue();
        }
        else {
            return null;
        }
    }

}
