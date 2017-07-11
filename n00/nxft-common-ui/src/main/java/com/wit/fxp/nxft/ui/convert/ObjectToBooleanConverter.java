package com.wit.fxp.nxft.ui.convert;

import java.util.Locale;

import com.vaadin.data.util.converter.Converter;
import com.wit.datatype.IdAndName;

public class ObjectToBooleanConverter implements Converter<Object, Boolean> {

    private static final long serialVersionUID = 1L;

    @Override
    public Boolean convertToModel(Object value, Class<? extends Boolean> targetType, Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (value == null) {
            return null;
        }

        // Remove leading and trailing white space
        value = ((IdAndName) value).getName();

        if ("是".equals(value) || "".equals(value) || null == value) {
            return true;
        }
        else if ("否".equals(value)) {
            return false;
        }
        else {
            throw new ConversionException("Cannot convert " + value + " to "
                    + getModelType().getName());
        }
    }

    @Override
    public Object convertToPresentation(Boolean value, Class<? extends Object> targetType, Locale locale) throws com.vaadin.data.util.converter.Converter.ConversionException {
        if (value == null) {
            return new IdAndName("2", "否");
        }
        if (value) {
            return new IdAndName("1", "是");
        }
        else {
            return new IdAndName("2", "否");
        }
    }

    @Override
    public Class<Boolean> getModelType() {
        return Boolean.class;
    }

    @Override
    public Class<Object> getPresentationType() {
        return Object.class;
    }

}
