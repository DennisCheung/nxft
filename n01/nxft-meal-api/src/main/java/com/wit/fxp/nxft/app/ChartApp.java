package com.wit.fxp.nxft.app;

import java.util.Date;
import java.util.List;

import com.wit.datatype.IdAndName;

/**
 * 我的主页：柱状图服务。
 *
 * @author qiuxu
 *
 */
public interface ChartApp {

    List<IdAndName> findChartSubjects(String circleId, Date now);

    List<IdAndName> findChartResources(String circleId);

    List<IdAndName> findChartOrders(String circleId, Date now);
}
