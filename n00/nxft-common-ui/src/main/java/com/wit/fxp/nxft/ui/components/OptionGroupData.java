package com.wit.fxp.nxft.ui.components;

import java.io.Serializable;

public class OptionGroupData implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String item;

    public OptionGroupData(String id, String item) {
        this.id = id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    /**
     * 如果返回true  hashCode 必须相等
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        else {
            OptionGroupData data = (OptionGroupData) obj;
            return this.getId().equals(data.getId());
        }
    }

}
