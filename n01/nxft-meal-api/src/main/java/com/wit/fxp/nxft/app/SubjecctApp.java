package com.wit.fxp.nxft.app;

import java.util.List;

import com.wit.Invoker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.nxft.app.command.AddSubjectCommand;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.nxft.app.model.MoneyListData;
import com.wit.fxp.nxft.app.model.SelectMoneyListInfo;
import com.wit.fxp.nxft.app.model.SubjectAccountList;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.app.model.SubjectMoneyData;
import com.wit.fxp.nxft.app.selectdata.MoneySelectInfo;
import com.wit.fxp.nxft.app.selectdata.SubjectSelectInfo;

/**
 * 暖心饭堂对象管理服务。
 *
 * @author qiuxu
 *
 */
public interface SubjecctApp {

    List<SubjectModel> findSubjects(Invoker invoker, SubjectSelectInfo info, int pageNum);

    List<SubjectMoneyData> findMoneySubjects(Invoker invoker, MoneySelectInfo info, int pageNum);

    int fintSubjectRowCount(Invoker invoker, SubjectSelectInfo info);

    int fintMoneySubjectRowCount(Invoker invoker, MoneySelectInfo info);

    void addSubject(Invoker invoker, AddSubjectCommand command);

    void editSubject(Invoker invoker, AddSubjectCommand command);

    List<IdAndName> findSubjectTypes();

    List<IdAndName> findTeams(String circleId);

    List<IdAndName> findFoodhibits();

    List<IdAndName> findFoodLove();

    SubjectModel findSubjectModel(String id);

    OrderModel findOrderModel(String id);

    List<SubjectAccountList> findAccountList(String subjectId);

    SubjectMoneyData findSubjectMoney(String subjectId);

    void recharge(Invoker invoker, String subjectId, Double money, String appId);

    List<MoneyListData> findMoneyListData(Invoker invoker, SelectMoneyListInfo info);

    List<IdAndName> findSubjectDiseases();

    void cancelMoney(String appId, Invoker invoker, String subjectId, Double money);

    SubjectModel findSubjectByIdNo(String idNo);

    SubjectModel findSubjectByPhone(String phone);

    /**
     * 删除最新充值流水交易单
     * @param appId 应用Id
     * @param subjectId
     */
    void cancelRecjarge(String subjectId);
}
