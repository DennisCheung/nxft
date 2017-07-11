package com.wit.fxp.nxft.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.ChartApp;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;
import com.wit.fxp.nxft.domain.model.order.DeliveDetailNum;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.utils.DateUtils;

@Component
@Transactional
public class ChartAppImpl implements ChartApp {

    @Autowired private SubjectRepo repo;

    @Override
    public List<IdAndName> findChartSubjects(String circleId, Date now) {
        List<IdAndName> datas = new ArrayList<IdAndName>();
        datas.add(new IdAndName("本月新增对象", String.valueOf(repo.findSubjectByDate(circleId,
                DateUtils.getMonthBegin(), DateUtils.getMonthEnd()))));
        List<SubjectType> types = repo.findAllTypes();
        types.forEach(e -> {
            datas.add(new IdAndName(e.getSubjectTypeName(), String.valueOf(repo.findSubjectByType(circleId, e.getSubjectTypeName()))));
        });
        datas.add(new IdAndName("全部", String.valueOf(repo.findSubjectByType(circleId, null))));
        return datas;
    }

    @Override
    public List<IdAndName> findChartResources(String circleId) {
        return repo.findAllByCircleId(circleId).stream()
                .map(e -> new IdAndName(e.getIndicatorName(), String.valueOf(e.getQuantity())))
                .collect(Collectors.toList());
    }

    @Override
    public List<IdAndName> findChartOrders(String circleId, Date now) {
        List<IdAndName> datas = new ArrayList<>();
        datas.add(new IdAndName("当天订单", String.valueOf(repo.findOrdersByDate(circleId,
                DateUtils.getBegin(now), DateUtils.getEnd(now)))));

        datas.add(new IdAndName("本周订单", String.valueOf(repo.findOrdersByDate(circleId,
                DateUtils.getBegin(DateUtils.getWeekBegin(now)), DateUtils.getEnd(DateUtils.getWeekEnd(now))))));

        datas.add(new IdAndName("本月订单", String.valueOf(repo.findOrdersByDate(circleId,
                DateUtils.getBegin(DateUtils.getMonthBegin()), DateUtils.getEnd(DateUtils.getMonthEnd())))));

        List<DeliveDetailNum> today = this.repo.findDeliveDetailByTime(circleId, now);
        int b = 0;
        int l = 0;
        int d = 0;
        for (int i = 0; i < today.size(); i++) {
            DeliveDetailNum de = today.get(i);
            if (DBC.餐别.早餐.value().equals(de.getMealTypeId())) {
                b += de.getQuanlity();
            }
            else if (DBC.餐别.午餐.value().equals(de.getMealTypeId())) {
                l += de.getQuanlity();
            }
            else {
                d += de.getQuanlity();
            }
        }

        int total = b + l + d;

        datas.add(new IdAndName("历史配餐订单", String.valueOf(total)));

        return datas;
    }

}
