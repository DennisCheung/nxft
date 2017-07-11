package com.wit.fxp.nxft.ui.components;

/**
 * 用于选择控件 Combobox ,select 控件中同时保存ID及内容。
 * @author Administrator
 *
 */
public class WSelectItem {

    private String itemId;
    private String itemCaption;
    private Object itemContent;

    public WSelectItem(String itemId, String itemCaption) {
        this(itemId, itemCaption, null);
    }

    public WSelectItem(String itemId, String itemCaption, Object itemContent) {
        this.itemId = itemId;
        this.itemCaption = itemCaption;
        this.itemContent = itemContent;
    }

    public String getItemId() {
        return itemId;
    }

    public Object getItemContent() {
        return itemContent;
    }

    public String getItemCaption() {
        return itemCaption;
    }

    @Override
    public int hashCode() {
        return this.itemId.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        else {
            WSelectItem data = (WSelectItem) obj;
            return this.getItemId().equals(data.getItemId());
        }
    }
}
