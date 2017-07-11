package com.wit.fxp.nxft.common;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.wit.fxp.nxft.utils.StringUtils;

public class LayoutUtils {

    public static HorizontalLayout getHorLayout(String caption, String captionWidth, Component component, String width) {
        HorizontalLayout horLayout = new HorizontalLayout();
        horLayout.addStyleName("lineheight30");
        if (component == null) {
            return horLayout;
        }
        if (!StringUtils.isEmpty(caption)) {
            Label captionLabel = new Label(caption, ContentMode.HTML);
            captionLabel.setWidth(captionWidth);
            captionLabel.addStyleName("alignright");
            captionLabel.addStyleName("layoutUtilsTitle");
            horLayout.addComponent(captionLabel);
        }
        if (component instanceof Label) {
            component.addStyleName("contentLabel");
        }
        if (!StringUtils.isEmpty(width)) {
            component.setWidth(width);
        }
        horLayout.addComponent(component);
        return horLayout;
    }

    public static HorizontalLayout getHorLayout(String caption, String captionWidth, Component component, String width, String unit) {
        HorizontalLayout horLayout = new HorizontalLayout();
        horLayout.addStyleName("lineheight30");
        if (component == null) {
            return horLayout;
        }
        if (!StringUtils.isEmpty(caption)) {
            Label captionLabel = new Label(caption, ContentMode.HTML);
            captionLabel.setWidth(captionWidth);
            captionLabel.addStyleName("alignright");
            horLayout.addComponent(captionLabel);
        }
        if (component instanceof Label) {
            component.addStyleName("contentLabel");
        }
        if (!StringUtils.isEmpty(width)) {
            component.setWidth(width);
        }
        horLayout.addComponent(component);
        if (!StringUtils.isEmpty(unit)) {
            horLayout.addComponent(new Label(unit, ContentMode.HTML));
        }
        return horLayout;
    }

    public static HorizontalLayout getHorLayout(String caption, String captionWidth, Component component, String width, Component component2,
            String width2, String unit) {
        HorizontalLayout horLayout = new HorizontalLayout();
        horLayout.addStyleName("lineheight30");
        if (component == null || component2 == null) {
            return horLayout;
        }
        if (!StringUtils.isEmpty(caption)) {
            Label captionLabel = new Label(caption, ContentMode.HTML);
            horLayout.addComponent(captionLabel);
            if (!StringUtils.isEmpty(captionWidth)) {
                captionLabel.setWidth(captionWidth);
                captionLabel.addStyleName("alignright");
            }
        }
        if (component instanceof Label) {
            component.addStyleName("contentLabel");
        }
        if (component2 instanceof Label) {
            component2.addStyleName("contentLabel");
        }
        if (!StringUtils.isEmpty(width)) {
            component.setWidth(width);
        }
        if (!StringUtils.isEmpty(width2)) {
            component2.setWidth(width2);
        }
        horLayout.addComponent(component);
        horLayout.addComponent(new Label("-"));
        horLayout.addComponent(component2);
        if (!StringUtils.isEmpty(unit)) {
            horLayout.addComponent(new Label(unit, ContentMode.HTML));
        }
        return horLayout;
    }

    public static HorizontalLayout getHorLayout(String caption, String captionWidth, Component component, String width, Component component2,
            String width2, String unit, String spiltStr) {
        HorizontalLayout horLayout = new HorizontalLayout();
        horLayout.addStyleName("lineheight30");
        if (component == null || component2 == null) {
            return horLayout;
        }
        if (!StringUtils.isEmpty(caption)) {
            Label captionLabel = new Label(caption, ContentMode.HTML);
            horLayout.addComponent(captionLabel);
            if (!StringUtils.isEmpty(captionWidth)) {
                captionLabel.setWidth(captionWidth);
                captionLabel.addStyleName("alignright");
            }
        }
        if (component instanceof Label) {
            component.addStyleName("contentLabel");
        }
        if (component2 instanceof Label) {
            component2.addStyleName("contentLabel");
        }
        if (!StringUtils.isEmpty(width)) {
            component.setWidth(width);
        }
        if (!StringUtils.isEmpty(width2)) {
            component2.setWidth(width2);
        }
        horLayout.addComponent(component);
        horLayout.addComponent(new Label(spiltStr));
        horLayout.addComponent(component2);
        if (!StringUtils.isEmpty(unit)) {
            horLayout.addComponent(new Label(unit, ContentMode.HTML));
        }
        return horLayout;
    }

    public static HorizontalLayout getHorLayout(String caption, String captionWidth, TextField component, String width, Button component2,
            String width2) {
        HorizontalLayout horLayout = new HorizontalLayout();
        horLayout.addStyleName("lineheight30");
        if (component == null || component2 == null) {
            return horLayout;
        }
        if (!StringUtils.isEmpty(caption)) {
            Label captionLabel = new Label(caption, ContentMode.HTML);
            horLayout.addComponent(captionLabel);
            if (!StringUtils.isEmpty(captionWidth)) {
                captionLabel.setWidth(captionWidth);
                captionLabel.addStyleName("alignright");
            }
        }
        if (!StringUtils.isEmpty(width)) {
            component.setWidth(width);
        }
        if (!StringUtils.isEmpty(width2)) {
            component2.setWidth(width2);
        }
        horLayout.addComponent(component);
        horLayout.addComponent(component2);
        component2.addStyleName("textfieldbutton");
        return horLayout;
    }
}
