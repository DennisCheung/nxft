package com.wit.fxp.nxft.ui.components;

import java.util.Set;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.OptionGroup;
import com.wit.datatype.option.support.CommonOption;
import com.wit.datatype.option.support.CommonOptionGroup;

/**
 *
 * @author qiuxu
 *
 */
public class OptionBox extends OptionGroup {

    private static final long serialVersionUID = 1L;

    private static final String CAPTION_PROPERTY_ID = "definition.name";

    private final CommonOptionGroup optionGroup;

    public OptionBox(CommonOptionGroup optionGroup) {
        super(optionGroup.getGroup().getName(), new BeanItemContainer<>(CommonOption.class));

        this.optionGroup = optionGroup;
        setModel();

        ((BeanItemContainer<?>) this.getContainerDataSource()).addNestedContainerProperty(CAPTION_PROPERTY_ID);
        this.setItemCaptionPropertyId(CAPTION_PROPERTY_ID);

        optionGroup.getOptions().forEach(e -> {
            addItem(e);
            if (e.isSelected()) {
                select(e);
            }
        });
    }

    public void setModel() {
        this.setImmediate(true);
        this.setMultiSelect(true);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Set<CommonOption> getValue() {
        return (Set<CommonOption>) super.getValue();
    }

    public CommonOptionGroup getOptionGroup() {
        changeOptionSelectStatus();
        return optionGroup;
    }

    private void changeOptionSelectStatus() {
        optionGroup.getOptions().forEach(e -> e.setSelected(false));

        getValue().forEach(e -> {
            e.setSelected(optionGroup.getOption(e.getDefinition().getId()) != null);
        });
    }

    /**
     * 遍历多选框的值。如果选择了其他。返回
     * @return otherItem
     */
    public boolean getSelectedOther() {
        Set<CommonOption> selectedItems = getValue();
        for (CommonOption item : selectedItems) {
            if (item.getDefinition().isOther()) {
                return true;
            }
        }

        return false;
    }

}
