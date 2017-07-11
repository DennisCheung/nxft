package com.wit.fxp.nxft.ui.usermain.block.worktips;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

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
import com.wit.fxp.nxft.menu.model.DeliveNumModel;

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
@SpringView(name = KitchenWorkTipsView.NAME)
public class KitchenWorkTipsViewImpl extends CustomComponent implements KitchenWorkTipsView, View, Serializable {

    private static final long serialVersionUID = 1L;

    private final VerticalLayout mainvly = new VerticalLayout();
    private final Label title = new Label("工作日志区");
    private final HorizontalLayout charthly = new HorizontalLayout();

    private HighChart acceptNoteChart;
    private HighChart refuseNoteChart;
    private HighChart compountFoodChart;

    @Override
    public void initView(KitchenWorkTipsPresenter presenter) {
        this.setCompositionRoot(mainvly);
        addStyle();
        buildView();
        bind(presenter);
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

    @Override
    public void refreshData(DeliveNumModel deliveNum) {
        HighChartsSeries acceptChartsSeries = this.acceptNoteChart.getChartConfiguration().getSeriesList().get(0);
        acceptChartsSeries.clearData();
        acceptChartsSeries.addData(new StringIntData("当天早餐已配", deliveNum.getToday().getBreakfastNum()));
        acceptChartsSeries.addData(new StringIntData("当天午餐已配", deliveNum.getToday().getLunchNum()));
        acceptChartsSeries.addData(new StringIntData("当天晚餐已配", deliveNum.getToday().getDinnerNum()));
        try {
            acceptNoteChart.redraw(acceptNoteChart.getChartConfiguration());
        }
        catch (HighChartsException e2) {
            e2.printStackTrace();
        }

        HighChartsSeries refuseChartsSeries = this.refuseNoteChart.getChartConfiguration().getSeriesList().get(0);
        refuseChartsSeries.clearData();
        refuseChartsSeries.addData(new StringIntData("本周早餐已配", deliveNum.getWeek().getBreakfastNum()));
        refuseChartsSeries.addData(new StringIntData("本周午餐已配", deliveNum.getWeek().getLunchNum()));
        refuseChartsSeries.addData(new StringIntData("本周晚餐已配", deliveNum.getWeek().getDinnerNum()));
        try {
            refuseNoteChart.redraw(refuseNoteChart.getChartConfiguration());
        }
        catch (HighChartsException e2) {
            e2.printStackTrace();
        }

        HighChartsSeries compountChartsSeries = this.compountFoodChart.getChartConfiguration().getSeriesList().get(0);
        compountChartsSeries.clearData();
        compountChartsSeries.addData(new StringIntData("本月早餐已配", deliveNum.getMonth().getBreakfastNum()));
        compountChartsSeries.addData(new StringIntData("本月午餐已配", deliveNum.getMonth().getLunchNum()));
        compountChartsSeries.addData(new StringIntData("本月晚餐已配", deliveNum.getMonth().getDinnerNum()));
        try {
            compountFoodChart.redraw(compountFoodChart.getChartConfiguration());
        }
        catch (HighChartsException e2) {
            e2.printStackTrace();
        }
    }

    private void buildView() {
        mainvly.addComponents(title, charthly);
        this.mainvly.setComponentAlignment(charthly, Alignment.MIDDLE_CENTER);
        configureChart();
        charthly.addComponents(this.acceptNoteChart, this.refuseNoteChart, this.compountFoodChart);
    }

    private void configureChart() {
        Page page = Page.getCurrent();
        int browserWindowWidth = page.getBrowserWindowWidth();
        if (this.acceptNoteChart == null) {
            List<String> categories = Arrays.asList("当天早餐已配", "当天午餐已配", "当天晚餐已配");
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
            columnConfiguration.setColors(Arrays.asList(new Color(255, 157, 65), new Color(255, 157, 65), new Color(255, 157, 65)));

            try {
                columnConfiguration.setTitle("当天配餐");
                columnConfiguration.setTitleFontSize(14);
                acceptNoteChart = HighChartFactory.renderChart(columnConfiguration);
                acceptNoteChart.setWidth(browserWindowWidth / 3.3 + "px");
                acceptNoteChart.setHeight("270px");
                acceptNoteChart.setStyleName("chart1");
            }
            catch (HighChartsException e2) {
                e2.printStackTrace();
            }
        }
        if (this.refuseNoteChart == null) {
            List<String> categories = Arrays.asList("本周早餐已配", "本周午餐已配", "本周晚餐已配");
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
            columnConfiguration.setColors(Arrays.asList(new Color(173, 209, 69), new Color(173, 209, 69), new Color(173, 209, 69)));

            try {
                columnConfiguration.setTitle("本周配餐");
                columnConfiguration.setTitleFontSize(14);
                refuseNoteChart = HighChartFactory.renderChart(columnConfiguration);
                refuseNoteChart.setWidth(browserWindowWidth / 3.3 + "px");
                refuseNoteChart.setHeight("270px");
                refuseNoteChart.setStyleName("chart2");
            }
            catch (HighChartsException e2) {
                e2.printStackTrace();
            }
        }
        if (this.compountFoodChart == null) {
            List<String> categories = Arrays.asList("本月早餐已配", "本月午餐已配", "本月晚餐已配");
            ChartConfiguration columnConfiguration = new ChartConfiguration();
            columnConfiguration.getxAxis().setLabelsEnabled(true);
            columnConfiguration.getxAxis().setCategories(categories);
            columnConfiguration.getyAxis().setLabelsEnabled(true);
            columnConfiguration.setChartType(ChartType.COLUMN);
            columnConfiguration.setLegendEnabled(false);
            ColumnChartPlotOptions columnChartPlotOptions = new ColumnChartPlotOptions();
            columnConfiguration.setPlotOptions(columnChartPlotOptions);
            ColumnChartSeries columnChartSeries = new ColumnChartSeries("数量");
            columnConfiguration.setColors(Arrays.asList(new Color(255, 185, 0), new Color(255, 185, 0), new Color(255, 185, 0)));
            columnConfiguration.getSeriesList().add(columnChartSeries);

            try {
                columnConfiguration.setTitle("本月配餐");
                columnConfiguration.setTitleFontSize(14);
                compountFoodChart = HighChartFactory.renderChart(columnConfiguration);
                compountFoodChart.setWidth(browserWindowWidth / 3.3 + "px");
                compountFoodChart.setHeight("270px");
            }
            catch (HighChartsException e2) {
                e2.printStackTrace();
            }
        }

        page.addBrowserWindowResizeListener(e -> {
            acceptNoteChart.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
            refuseNoteChart.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
            compountFoodChart.setWidth(page.getBrowserWindowWidth() / 3.3 + "px");
        });
    }

    private void bind(KitchenWorkTipsPresenter presenter) {
    }

    private void addStyle() {
        mainvly.setSizeFull();
        this.mainvly.addStyleName("WorkTipsView");
        this.charthly.setWidth("98%");
        this.charthly.addStyleName("charthly");
        this.title.addStyleName("tipTitle");
    }

}
