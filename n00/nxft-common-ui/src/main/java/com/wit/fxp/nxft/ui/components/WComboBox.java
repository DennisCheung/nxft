package com.wit.fxp.nxft.ui.components;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.wit.datatype.IdAndName;

public class WComboBox extends ComboBox {

    private static final long serialVersionUID = 1L;
    private BeanItemContainer<IdAndName> wItemContaner = new BeanItemContainer<IdAndName>(IdAndName.class);
    private boolean isBind = false;

    public WComboBox(String caption) {
        super(caption);
        this.setNewItemsAllowed(false);
        this.setImmediate(true);
    }

    public WComboBox() {
        super();
        this.setNewItemsAllowed(false);
        this.setImmediate(true);
    }

    /** 绑定数据。为了提升界面体验，将Load数据和绑定数据分开了。  */
    public void bindWData() {
        if (!this.isBind) {
            this.setContainerDataSource(wItemContaner);
            this.setItemCaptionMode(ItemCaptionMode.PROPERTY);
            this.setItemCaptionPropertyId("name");
            this.isBind = true;
        }
    }

    /** 添加项目 */
    public Item addWSelectItem(String itemId, String itemCaption) {
        this.isBind = false;
        return this.wItemContaner.addItem(new IdAndName(itemId, itemCaption));
    }

    public void removeWAllItems() {
        this.removeAllItems();
        this.wItemContaner.removeAllItems();
        this.isBind = false;
    }

    public boolean isWEmpty() {
        return (this.wItemContaner.size() == 0);
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
            return IdAndName.EMPTY;
        }
    }

}
