package com.wit.fxp.nxft.ui.usermain.block.worktips;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.vaadin.spring.annotation.PrototypeScope;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.server.Page;
import com.vaadin.shared.ui.colorpicker.Color;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.wit.datatype.IdAndName;

import at.downdrown.vaadinaddons.highchartsapi.HighChart;
import at.downdrown.vaadinaddons.highchartsapi.HighChartFactory;
import at.downdrown.vaadinaddons.highchartsapi.exceptions.HighChartsException;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartConfiguration;
import at.downdrown.vaadinaddons.highchartsapi.model.ChartType;
import at.downdrown.vaadinaddons.highchartsapi.model.data.base.StringIntData;
import at.downdrown.vaadinaddons.highchartsapi.model.plotoptions.ColumnChartPlotOptions;
import at.downdrown.vaadinaddons.highchartsapi.model.series.ColumnChartSeries;
import at.downdrown.vaadinaddons.highchartsapi.model.series.HighChartsSeries;

@PrototypeScope
@SpringView(name = MealWorkTipsView.NAME)
public class MealWorkTipsViewImpl extends CustomComponent implements MealWorkTipsView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainly = new VerticalLayout();

    private final Label title = new Label("工作日志区");

    private final HorizontalLayout mhor = new HorizontalLayout();

    private final VerticalLayout vly1 = new VerticalLayout();
    private final VerticalLayout vly3 = new VerticalLayout();
    private final VerticalLayout vly4 = new VerticalLayout();

    private HighChart hc1;
    private HighChart hc3;
    private HighChart hc4;

    public void buildView() {

        this.mainly.addComponents(title, mhor);
        this.mainly.setComponentAlignment(mhor, Alignment.MIDDLE_CENTER);
        mhor.addComponents(this.vly4, this.vly3, this.vly1);
        this.setCompositionRoot(mainly);
    }

    private void buildHcs1(List<IdAndName> data, String width) {
        HighChartsSeries hcs1 = this.getCs1(data.stream().map(e -> e.getId()).collect(Collectors.toList()), width);
        hcs1.clearData();
        data.forEach(e -> {
            hcs1.addData(new StringIntData(e.getId(), Integer.parseInt(e.getName())));
        });
        try {
            this.hc1.redraw(this.hc1.getChartConfiguration());
        }
        catch (HighChartsException e2) {
            e2.printStackTrace();
        }
    }

    private HighChartsSeries getCs1(List<String> categories, String width) {
        if (this.hc1 == null) {
            ChartConfiguration columnConfiguration = new ChartConfiguration();
            columnConfiguration.getxAxis().setLabelsEnabled(true);
            columnConfiguration.getxAxis().setCategories(categories);
            columnConfiguration.getyAxis().setLabelsEnabled(true);
            columnConfiguration.setChartType(ChartType.COLUMN);
            columnConfiguration.setLegendEnabled(false);
            ColumnChartPlotOptions columnChartPlotOptions = new ColumnChartPlotOptions();
            columnConfiguration.setPlotOptions(columnChartPlotOptions);
            ColumnChartSeries columnChartSeries = new ColumnChartSeries("数量");
            columnConfiguration.getSeriesList().add(columnChartSeries);
            columnConfiguration.setColors(Arrays.asList(
                    new Color(248, 163, 72)
                    ));

            try {
                columnConfiguration.setTitle("订单");
                this.hc1 = HighChartFactory.renderChart(columnConfiguration);
                this.hc1.setWidth(width);
                this.hc1.setHeight("235px");
                this.vly1.addComponent(this.hc1);
                return columnChartSeries;
            }
            catch (HighChartsException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return this.hc1.getChartConfiguration().getSeriesList().get(0);
    }

    private void buildHcs3(List<IdAndName> data, String width) {
        HighChartsSeries hcs3 = this.getCs3(data.stream().map(e -> e.getId()).collect(Collectors.toList()), width);
        hcs3.clearData();
        data.forEach(e -> {
            hcs3.addData(new StringIntData(e.getId(), Integer.parseInt(e.getName())));
        });

        try {
            this.hc3.redraw(this.hc3.getChartConfiguration());
        }
        catch (HighChartsException e2) {
            e2.printStackTrace();
        }
    }

    private HighChartsSeries getCs3(List<String> categories, String width) {
        if (this.hc3 == null) {
            ChartConfiguration columnConfiguration = new ChartConfiguration();
            columnConfiguration.getxAxis().setLabelsEnabled(true);
            columnConfiguration.getxAxis().setCategories(categories);
            columnConfiguration.getyAxis().setLabelsEnabled(true);
            columnConfiguration.setChartType(ChartType.COLUMN);
            columnConfiguration.setLegendEnabled(false);
            ColumnChartPlotOptions columnChartPlotOptions = new ColumnChartPlotOptions();
            columnConfiguration.setPlotOptions(columnChartPlotOptions);
            ColumnChartSeries columnChartSeries = new ColumnChartSeries("数量");
            columnConfiguration.getSeriesList().add(columnChartSeries);
            columnConfiguration.setColors(Arrays.asList(
                    new Color(178, 208, 59)
                    ));

            try {
                columnConfiguration.setTitle("助餐对象");
                this.hc3 = HighChartFactory.renderChart(columnConfiguration);
                this.hc3.setWidth(width);
                this.hc3.setHeight("235px");
                this.vly3.addComponent(this.hc3);
                return columnChartSeries;
            }
            catch (HighChartsException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return this.hc3.getChartConfiguration().getSeriesList().get(0);
    }

    private void buildHcs4(List<IdAndName> data, String width) {
        HighChartsSeries hcs4 = this.getCs4(data.stream().map(e -> e.getId()).collect(Collectors.toList()), width);
        hcs4.clearData();
        data.forEach(e -> {
            hcs4.addData(new StringIntData(e.getId(), Integer.parseInt(e.getName())));
        });

        try {
            this.hc4.redraw(this.hc4.getChartConfiguration());
        }
        catch (HighChartsException e2) {
            e2.printStackTrace();
        }
    }

    private HighChartsSeries getCs4(List<String> categories, String width) {
        if (this.hc4 == null) {
            ChartConfiguration columnConfiguration = new ChartConfiguration();
            columnConfiguration.getxAxis().setLabelsEnabled(true);
            columnConfiguration.getxAxis().setCategories(categories);
            columnConfiguration.getyAxis().setLabelsEnabled(true);
            columnConfiguration.setChartType(ChartType.COLUMN);
            columnConfiguration.setLegendEnabled(false);
            ColumnChartPlotOptions columnChartPlotOptions = new ColumnChartPlotOptions();
            columnConfiguration.setPlotOptions(columnChartPlotOptions);
            ColumnChartSeries columnChartSeries = new ColumnChartSeries("数量");
            columnConfiguration.getSeriesList().add(columnChartSeries);
            columnConfiguration.setColors(Arrays.asList(
                    new Color(255, 188, 13)
                    ));

            try {
                columnConfiguration.setTitle("资源");
                this.hc4 = HighChartFactory.renderChart(columnConfiguration);
                this.hc4.setWidth(width);
                this.hc4.setHeight("235px");
                this.vly4.addComponent(this.hc4);
                return columnChartSeries;
            }
            catch (HighChartsException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return this.hc4.getChartConfiguration().getSeriesList().get(0);
    }

    public void bind(MealWorkTipsPresenter presenter) {
        Page page = Page.getCurrent();
        page.addBrowserWindowResizeListener(e -> {
            this.hc1.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
            this.hc3.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
            this.hc4.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
        });
    }

    private void addStyle() {
        this.mainly.addStyleName("NxftAssistChartViewImplstyle");
        mhor.setStyleName("mwtpsmhorstyle");
        title.setStyleName("mealworititlestyle");
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

    @Override
    public void initView(MealWorkTipsPresenter nxftAssistChartPresenter) {
        buildView();
        bind(nxftAssistChartPresenter);
        addStyle();
    }

    @Override
    public void reDraw(List<IdAndName> orderData, List<IdAndName> subjectData, List<IdAndName> resourceData) {
        Page page = Page.getCurrent();
        int browserWindowWidth = page.getBrowserWindowWidth();
        String width = browserWindowWidth / 3.3 + "px";
        buildHcs1(orderData, width);
        buildHcs3(subjectData, width);
        buildHcs4(resourceData, width);
        page.addBrowserWindowResizeListener(e -> {
            this.hc1.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
            this.hc3.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
            this.hc4.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
        });
    }
}
