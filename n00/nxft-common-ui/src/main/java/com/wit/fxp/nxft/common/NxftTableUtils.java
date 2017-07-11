package com.wit.fxp.nxft.common;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Table;

public class NxftTableUtils {

    private final List<String> propertyIds = new ArrayList<>();
    private final List<Float> expandRatios = new ArrayList<>();
    private final List<String> headers = new ArrayList<>();

    public static NxftTableUtils getInstance() {
        NxftTableUtils utils = new NxftTableUtils();
        return utils;
    }

    public NxftTableUtils addPropertyArray(String propertyId, Float expandRatio, String columnHeader) {
        propertyIds.add(propertyId);
        expandRatios.add(expandRatio);
        headers.add(columnHeader);
        return this;
    }

    public void initTable(Table table, BeanItemContainer<?> container) {
        table.setContainerDataSource(container);
        for (int i = 0; i < propertyIds.size(); i++) {
            container.addNestedContainerProperty(propertyIds.get(i));
            table.setColumnExpandRatio(propertyIds.get(i), expandRatios.get(i));
        }
        table.setVisibleColumns(propertyIds.toArray());
        String[] strs = new String[headers.size()];
        table.setColumnHeaders(headers.toArray(strs));
    }
}
