package com.wit.fxp.nxft.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.Invoker;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.nxft.app.OrderApp;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.app.selectdata.OrderSelectInfo;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.impl.mapper.OrderMapper;
import com.wit.fxp.nxft.impl.mapper.SubjectMapper;

@Component
@Transactional
public class OrderAppImpl implements OrderApp {

    @Autowired private InvocationContext ic;
    @Autowired private SubjectRepo subjectRepo;

    @Override
    public List<OrderModel> findOrders(Invoker invoker, OrderSelectInfo info, int pageNum) {
        Actor actor = ic.createActor(invoker);

        if (info == null) {
            return OrderMapper.INSTANCE.map(subjectRepo.findAllOrders(actor.getCircle().getId(), actor.getTeam().getId(), pageNum));
        }
        else {
            return OrderMapper.INSTANCE.map(subjectRepo.findOrderByQuery(actor.getCircle().getId(), actor.getTeam().getId(),
                    info.getCreateBegin(), info.getCreateEnd(), info.getEatBegin(), info.getEatEnd(), info.getName(),
                    info.getTeamId(), info.getSubjectTypeId(), info.getState(), pageNum));
        }
    }

    @Override
    public int fintOrderRowCount(Invoker invoker, OrderSelectInfo info) {
        Actor actor = ic.createActor(invoker);

        if (info == null) {
            return subjectRepo.findAllOrdersCount(actor.getCircle().getId(), actor.getTeam().getId());
        }
        else {
            return subjectRepo.findOrderCountByQuery(actor.getCircle().getId(), actor.getTeam().getId(), info.getCreateBegin(),
                    info.getCreateEnd(), info.getEatBegin(), info.getEatEnd(), info.getName(), info.getTeamId(), info.getSubjectTypeId(), info.getState());
        }
    }

    @Override
    public SubjectModel findSubjectModelByPersonId(String personId) {
        return SubjectMapper.INSTANCE.map(subjectRepo.findSubjectByPersonId(personId));
    }

    @Override
    public Double findYue(String personId) {
        Account a = subjectRepo.findAccountByPersonId(personId);
        return a.getBalanceCash();
    }

    @Override
    public String checkIsDisease(String mealId) {
        return subjectRepo.findMealDiseasesByMealId(mealId).stream()
                .map(e -> e.getDiseaseName()).collect(Collectors.joining("、"));
    }

}
