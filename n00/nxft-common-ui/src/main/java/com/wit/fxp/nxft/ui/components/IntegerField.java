package com.wit.fxp.nxft.ui.components;

import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.TextField;

/**
 * 数字输入框，只允许输入数字，输入别的自动置空输入框。
 *
 * @author qiuxu
 *
 */
public class IntegerField extends TextField implements TextChangeListener {

    private static final long serialVersionUID = 1L;

    public IntegerField() {
        setImmediate(true);
        setTextChangeEventMode(TextChangeEventMode.EAGER);
        addTextChangeListener(this);
    }

    @Override
    public void textChange(TextChangeEvent event) {
        String text = event.getText();
        try {
            new Long(text);
        }
        catch (NumberFormatException e) {
            setValue("");
        }
    }

}
