package com.wit.fxp.nxft.ui.components;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Component;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;

public class WGridComponent<T> extends GridLayout {

    private static final long serialVersionUID = 1L;
    private List<Function<T, ?>> fields;

    public void initView(Object[] titles, Float[] widths, List<Function<T, ?>> fields) {
        validateParamSize(titles, widths, fields);

        this.fields = fields;
        this.setColumns(titles.length);

        for (int i = 0; i < titles.length; i++) {
            Object title = titles[i];
            Float width = widths[i];
            if (title instanceof String) {
                Label component = new Label((String) title);
                component.addStyleName("gridheader");
                this.addComponent(component, i, 0, i, 0);
            }
            else if (title instanceof Component) {
                this.addComponent((Component) title, i, 0, i, 0);
            }
            else if (title instanceof Date) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                this.addComponent(new Label(dateFormat.format((Date) title)), i, 0, i, 0);
            }
            else {
                throw new RuntimeException("不支持类型" + title.toString());
            }
            this.setColumnExpandRatio(i, width);
        }
    }

    private void validateParamSize(Object[] titles, Float[] widths, List<Function<T, ?>> fields) {
        int titleSize = titles.length;
        int widthSize = widths.length;
        int fieldSize = fields.size();
        if ((titleSize != widthSize) || (titleSize != fieldSize) || (widthSize != fieldSize)) {
            throw new RuntimeException("WGridComponent 控件initView(Object[] titles, Float[] widths, List<Function<T, ?>> fields) 方法三个数组"
                    + "或List集合参数里面元素个数应该一样");
        }
    }

    public void addAllData(Collection<T> d) {
        List<T> data = new ArrayList<>(d);
        int columns = this.fields.size();
        for (int m = 0; m < data.size(); m++) {
            T t = data.get(m);
            for (int i = 0; i < columns; i++) {
                Function<T, ?> function = this.fields.get(i);
                Object value = function.apply(t);
                if (value instanceof AbstractComponent) {
                    this.setRows(m + 2);
                    this.addComponent((Component) value, i, m + 1, i, m + 1);
                }
                else if (value instanceof String) {
                    this.setRows(m + 2);
                    this.addComponent(new Label((String) value), i, m + 1, i, m + 1);
                }
                else if (value instanceof Date) {
                    this.setRows(m + 2);
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    this.addComponent(new Label(dateFormat.format((Date) value)), i, m + 1, i, m + 1);
                }
                else {
                    throw new RuntimeException("不支持类型" + value.toString());
                }
            }
        }
    }

}
