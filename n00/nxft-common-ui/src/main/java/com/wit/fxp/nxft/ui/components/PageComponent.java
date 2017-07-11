package com.wit.fxp.nxft.ui.components;

import com.vaadin.data.validator.RegexpValidator;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.wit.fxp.nxft.app.page.PageInfo;

/**
 * 分页控件
 * @author wck
 *
 */
public class PageComponent extends CustomComponent {
    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainLayout = new VerticalLayout();
    private final VerticalLayout topLayout = new VerticalLayout();
    private final HorizontalLayout bottomLayout = new HorizontalLayout();
    private final HorizontalLayout leftBottomLayout = new HorizontalLayout();
    private final HorizontalLayout rightBottomLayout = new HorizontalLayout();
    private boolean isAddHandlerListener = false;

    private final Button prePageBtn = new Button("上一页");
    private final Button nextPageBtn = new Button("下一页");
    private final TextField currentPageField = new TextField();
    private final Button currentPageBtn = new Button("前进");
    private final Label totalPageNum = new Label();
    private final Button firstPageBtn = new Button("第一页");
    private final Button lastPageBtn = new Button("最后一页");

    private Button queryBtn;

    private final PageInfo pageInfo = new PageInfo();

    public void postInit(AbstractComponent component) {
        buildView(component);
    }

    public void postInit(AbstractComponent component, Button queryBtn, Integer pageSize) {
        buildView(component);
        this.queryBtn = queryBtn;
        this.pageInfo.setPageSize(pageSize);
    }

    public void postInit(AbstractComponent component, Button queryBtn, Integer pageSize, PageHandleListener listener) {
        buildView(component);
        this.queryBtn = queryBtn;
        this.pageInfo.setPageSize(pageSize);
        this.pageListener = listener;
        addClickListener();
    }

    private void buildView(AbstractComponent component) {
        addStyle();
        setCompositionRoot(mainLayout);
        mainLayout.addComponent(topLayout);
        mainLayout.addComponent(bottomLayout);

        topLayout.addComponent(component);
        bottomLayout.addComponents(leftBottomLayout, rightBottomLayout);
        HorizontalLayout rightBottomWarphly = new HorizontalLayout();
        rightBottomLayout.addComponent(rightBottomWarphly);
        Label currPageLabel = new Label("当前第");
        Label totalPageLabel = new Label("总共");
        rightBottomWarphly.addComponents(currPageLabel, currentPageField, new Label("页"), currentPageBtn, totalPageLabel, totalPageNum, new Label("页"));
        rightBottomWarphly.addComponents(firstPageBtn, prePageBtn, nextPageBtn, lastPageBtn);
        rightBottomLayout.setComponentAlignment(rightBottomWarphly, Alignment.MIDDLE_RIGHT);
    }

    private void addStyle() {
        mainLayout.addStyleName("pageComponent");
        topLayout.addStyleName("topLayout");
        bottomLayout.addStyleName("bottomLayout");
        bottomLayout.setWidth("100%");
        rightBottomLayout.setWidth("100%");
        currentPageField.setWidth("40px");
        currentPageField.setHeight("25px");
        rightBottomLayout.addStyleName("lineheight30");
        totalPageNum.addStyleName("contentLabel-blue");

        this.currentPageField.addValidator(new RegexpValidator("^[0-9]+$", "请输入数字！"));
    }

    public interface PageHandleListener extends java.util.EventListener {
        void handleEvent(PageInfo pageInfo);
    }

    private PageHandleListener pageListener;

    public void addHandleListener(PageHandleListener listener) {
        pageListener = listener;
        addClickListener();
    }

    private void addClickListener() {
        if (this.isAddHandlerListener) {
            return;
        }
        else {
            this.isAddHandlerListener = true;
        }
        this.prePageBtn.addClickListener(e -> {
            if (this.pageListener == null) {
                return;
            }
            if (this.pageInfo.isNeedResetTotalNum()) {
                this.pageInfo.setNeedResetTotalNum(false);
            }
            this.pageInfo.setStartIndex(this.pageInfo.getStartIndex() - this.pageInfo.getPageSize());
            this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
            if (this.pageInfo.getStartIndex() < 0) {
                Notification.show("已经是第一页！");
                this.pageInfo.setStartIndex(0);
                this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
                return;
            }
            this.pageListener.handleEvent(this.pageInfo);
            this.totalPageNum.setValue(this.pageInfo.getTotalPage() + "");
            this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
        });
        this.nextPageBtn.addClickListener(e -> {
            if (this.pageListener == null) {
                return;
            }
            if (this.pageInfo.isNeedResetTotalNum()) {
                this.pageInfo.setNeedResetTotalNum(false);
            }
            this.pageInfo.setStartIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
            this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
            if (this.pageInfo.getStartIndex() >= this.pageInfo.getTotalRecord()) {
                Notification.show("已经是最后一页！");
                this.pageInfo.setStartIndex(this.pageInfo.getTotalRecord());
                this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
                return;
            }
            this.pageListener.handleEvent(this.pageInfo);
            this.totalPageNum.setValue(this.pageInfo.getTotalPage() + "");
            this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
        });
        if (this.queryBtn != null) {
            this.queryBtn.addClickListener(e -> {
                if (this.pageListener == null) {
                    return;
                }
                if (!this.pageInfo.isNeedResetTotalNum()) {
                    this.pageInfo.setNeedResetTotalNum(true);
                }
                this.pageInfo.setStartIndex(0);
                this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
                this.pageListener.handleEvent(this.pageInfo);
                this.totalPageNum.setValue(this.pageInfo.getTotalPage() + "");
                this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
            });
        }
        this.firstPageBtn.addClickListener(e -> {
            if (this.pageListener == null) {
                return;
            }
            if (this.pageInfo.isNeedResetTotalNum()) {
                this.pageInfo.setNeedResetTotalNum(false);
            }
            this.pageInfo.setStartIndex(0);
            this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
            this.pageListener.handleEvent(this.pageInfo);
            this.totalPageNum.setValue(this.pageInfo.getTotalPage() + "");
            this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
        });
        this.lastPageBtn.addClickListener(e -> {
            if (this.pageListener == null) {
                return;
            }
            if (this.pageInfo.isNeedResetTotalNum()) {
                this.pageInfo.setNeedResetTotalNum(false);
            }
            this.pageInfo.setStartIndex((this.pageInfo.getTotalPage() - 1) * this.pageInfo.getPageSize());
            this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
            this.pageListener.handleEvent(this.pageInfo);
            this.totalPageNum.setValue(this.pageInfo.getTotalPage() + "");
            this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
        });
        this.currentPageBtn.addClickListener(e -> {
            if (this.pageListener == null) {
                return;
            }
            try {
                String value = this.currentPageField.getValue();
                int currPage = Integer.parseInt(value);
                if (this.pageInfo.isNeedResetTotalNum()) {
                    this.pageInfo.setNeedResetTotalNum(false);
                }
                if (currPage > this.pageInfo.getTotalPage()) {
                    Notification.show("输入的页数不应该大于总共页数，也不应低于0！");
                    this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
                    return;
                }
                this.pageInfo.setStartIndex((currPage - 1) * this.pageInfo.getPageSize());
                this.pageInfo.setEndIndex(this.pageInfo.getStartIndex() + this.pageInfo.getPageSize());
                this.pageListener.handleEvent(this.pageInfo);
                this.totalPageNum.setValue(this.pageInfo.getTotalPage() + "");
                this.currentPageField.setValue(this.pageInfo.getCurrPage() + "");
            }
            catch (NumberFormatException e1) {
                Notification.show("请输入数字！");
            }
        });
    }
}
