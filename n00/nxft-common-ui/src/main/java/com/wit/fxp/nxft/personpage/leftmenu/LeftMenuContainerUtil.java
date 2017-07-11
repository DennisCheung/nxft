package com.wit.fxp.nxft.personpage.leftmenu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.HierarchicalContainer;
import com.wit.fxp.nxft.personpage.section.PersonMenuName;

import lombok.Value;

/**
 * 抑制警告的必要性参考 https://vaadin.com/forum/#!/thread/3304206/11244960
 * @author wck
 *
 */
@PrototypeScope
@Component
public class LeftMenuContainerUtil {

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String PARAMS = "params";
    public static final String VIEWNAME = "viewName";

    private final Map<String, Object> containerMap = new HashMap<>();

    public Container getContainer(String subjectId) {
        HierarchicalContainer container = new HierarchicalContainer();

        container.addContainerProperty(ID, String.class, null);
        container.addContainerProperty(NAME, String.class, null);
        container.addContainerProperty(PARAMS, Object.class, null);
        container.addContainerProperty(VIEWNAME, String.class, null);

        Iterator<MenuClass> iterator = getMenuItemList().iterator();
        while (iterator.hasNext()) {
            MenuClass next = iterator.next();
            Object itemId = container.addItem();
            Item classNewItem = container.getItem(itemId);
            @SuppressWarnings("unchecked")
            Property<String> classNameProperty = classNewItem.getItemProperty(NAME);
            classNameProperty.setValue(next.getName());
            @SuppressWarnings("unchecked")
            Property<Object> paramsProperty = classNewItem.getItemProperty(PARAMS);
            paramsProperty.setValue(subjectId);
            @SuppressWarnings("unchecked")
            Property<String> viewNameProperty = classNewItem.getItemProperty(VIEWNAME);
            viewNameProperty.setValue(next.getViewName());
            container.setChildrenAllowed(itemId, next.isAllowChild());
            containerMap.put(next.getId(), itemId);
        }

        return container;
    }

    private List<MenuClass> getMenuItemList() {
        List<MenuClass> list = new ArrayList<>();
        list.add(new MenuClass(菜单接口类型.基本资料.value(), 菜单接口类型.基本资料.name(), null, PersonMenuName.SUBJECT_INFO, false));
        list.add(new MenuClass(菜单接口类型.智能设备.value(), 菜单接口类型.智能设备.name(), null, "", true));
        list.add(new MenuClass(菜单接口类型.券.value(), 菜单接口类型.券.name(), null, "ViewServicePlanView", false));
        list.add(new MenuClass(菜单接口类型.理疗保健.value(), 菜单接口类型.理疗保健.name(), null, "", true));
        list.add(new MenuClass(菜单接口类型.咨询服务.value(), 菜单接口类型.咨询服务.name(), null, "", true));
        list.add(new MenuClass(菜单接口类型.服务评价.value(), 菜单接口类型.服务评价.name(), null, "", true));
        return list;
    }

    @Value
    private class MenuClass {
        private String id;
        private String name;
        private Object params;
        private String viewName;
        private boolean allowChild;
    }

    public enum 菜单接口类型 {
        基本资料("basicInfo"),
        智能设备("intelligentDevice"),
        券("voucher"),
        理疗保健("physicalTherapyAndHealthCare"),
        咨询服务("consultingService"),
        服务评价("serviceEvaluation");

        private final String value;

        菜单接口类型(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

}
