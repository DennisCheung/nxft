package com.wit.fxp.nxft.ui.components;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;

public class WNotification extends Notification  {

    private static final long serialVersionUID = 1L;

    /** 显示提示信息  */
    public static void showInfo(String caption) {
        show(caption, Notification.Type.HUMANIZED_MESSAGE);
    }

    /** 显示警告信息  */
    public static void showWarn(String caption) {
        show(caption, Notification.Type.ERROR_MESSAGE);
    }

    public static void show(String caption, Type type) {
        Notification notification = new Notification(caption, type);
        notification.setDelayMsec(-1);
        notification.show(Page.getCurrent());
    }

    public WNotification(String caption, String description, Type type) {
        super(caption, description, type);
    }

    public WNotification(String caption, String description) {
        super(caption, description);
    }

    public WNotification(String caption, Type type) {
        super(caption, type);
    }

    public WNotification(String caption) {
        super(caption);
    }

    public WNotification(String caption, String description, Type type, boolean htmlContentAllowed) {
        super(caption, description, type, htmlContentAllowed);
    }

}
