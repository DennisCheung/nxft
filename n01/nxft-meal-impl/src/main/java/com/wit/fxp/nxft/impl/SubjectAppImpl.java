package com.wit.fxp.nxft.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.Invoker;
import com.wit.datatype.IdAndName;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.account.AccountList;
import com.wit.fxp.domain.model.account.AccountPerson;
import com.wit.fxp.domain.model.account.repo.AccountRepo;
import com.wit.fxp.domain.model.basic.RegionNameView;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.domain.model.person.repo.PersonRepo;
import com.wit.fxp.domain.repo.RegionalismRepo;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.SubjecctApp;
import com.wit.fxp.nxft.app.command.AddSubjectCommand;
import com.wit.fxp.nxft.app.common.model.OrderModel;
import com.wit.fxp.nxft.app.model.MoneyListData;
import com.wit.fxp.nxft.app.model.SelectMoneyListInfo;
import com.wit.fxp.nxft.app.model.SubjectAccountList;
import com.wit.fxp.nxft.app.model.SubjectModel;
import com.wit.fxp.nxft.app.model.SubjectMoneyData;
import com.wit.fxp.nxft.app.selectdata.MoneySelectInfo;
import com.wit.fxp.nxft.app.selectdata.SubjectSelectInfo;
import com.wit.fxp.nxft.domain.model.dict.FoodLove;
import com.wit.fxp.nxft.domain.model.dict.FoodProhibit;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;
import com.wit.fxp.nxft.domain.model.subject.AddSubjectData;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog;
import com.wit.fxp.nxft.domain.model.subject.SmsLogData;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.domain.model.subject.service.SubjectService;
import com.wit.fxp.nxft.impl.mapper.OrderMapper;
import com.wit.fxp.nxft.impl.mapper.SubjectMapper;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.fxp.tsp.client.EcpAccount;
import com.wit.fxp.tsp.client.TspClient;
import com.wit.fxp.validation.idcardnumber.IdCardNumber;
import com.wit.fxp.validation.idcardnumber.IdCardNumberParser;
import com.wit.tsp.v3.TspName;
import com.wit.tsp.v3.outbound.SendSmsCommand;

@Component
@Transactional
public class SubjectAppImpl implements SubjecctApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectAppImpl.class);

    @Autowired private InvocationContext ic;

    @Autowired private SubjectService service;
    @Autowired private SubjectRepo subjectRepo;
    @Autowired private RegionalismRepo regionRepo;
    @Autowired private IdCardNumberParser parser;
    @Autowired private AccountRepo aRepo;
    @Autowired private PersonRepo personRepo;
    @Autowired private TspClient tspClient;

    @Override
    public List<SubjectModel> findSubjects(Invoker invoker, SubjectSelectInfo info, int pageNum) {
        Actor actor = ic.createActor(invoker);

        if (info == null) {
            return SubjectMapper.INSTANCE.map(subjectRepo.findAllSubjects(actor.getCircle().getId(), actor.getTeam().getId(), pageNum));
        }
        else {
            return SubjectMapper.INSTANCE.map(subjectRepo.findSubjectByQuery(actor.getCircle().getId(), actor.getTeam().getId(),
                    info.getName(), info.getPhone(), info.getSendType(), pageNum));
        }
    }

    @Override
    public List<SubjectMoneyData> findMoneySubjects(Invoker invoker, MoneySelectInfo info, int pageNum) {
        Actor actor = ic.createActor(invoker);
        if (info == null) {
            List<NxftSubject> subjects = subjectRepo.findAllSubjects(actor.getCircle().getId(), actor.getTeam().getId(), pageNum);
            return subjects.stream().map(e -> {
                String personId = e.getPersonInfo().getPersonId();
                Account account = subjectRepo.findAccountByPersonId(personId);
                SubjectMoneyData data = SubjectMoneyData.builder()
                        ._subjectId_(e.getId())
                        ._name______(e.getPersonInfo().getSubjectName())
                        ._gender____(e.getPersonInfo().getSexName())
                        ._type______(e.getSubjectInfo().getSubjectTypeName())
                        ._yue_______(account.getBalanceCash())
                        ._touzhi____(e.getSubjectInfo().getOverdraft())
                        ._phone_____(e.getContactPhone())
                        ._build_();
                return data;
            }).collect(Collectors.toList());
        }
        else {
            List<NxftSubject> subjects = subjectRepo.findMaSubjectByQuery(actor.getCircle().getId(), actor.getTeam().getId(),
                    info.getName(), info.getPhone(), info.getIsOver(), pageNum);
            return subjects.stream().map(e -> {
                SubjectMoneyData data = SubjectMoneyData.builder()
                        ._subjectId_(e.getId())
                        ._name______(e.getPersonInfo().getSubjectName())
                        ._gender____(e.getPersonInfo().getSexName())
                        ._type______(e.getSubjectInfo().getSubjectTypeName())
                        ._yue_______(subjectRepo.findAccountByPersonId(e.getPersonInfo().getPersonId()).getBalanceCash())
                        ._touzhi____(e.getSubjectInfo().getOverdraft())
                        ._phone_____(e.getContactPhone())
                        ._build_();
                return data;
            }).collect(Collectors.toList());
        }

    }

    @Override
    public int fintMoneySubjectRowCount(Invoker invoker, MoneySelectInfo info) {
        Actor actor = ic.createActor(invoker);
        if (info == null) {
            return subjectRepo.findAllSubjectsCount(actor.getCircle().getId(), actor.getTeam().getId());
        }
        else {
            return subjectRepo.findMaSubjectCountByQuery(actor.getCircle().getId(), actor.getTeam().getId(), info.getName(),
                    info.getPhone(), info.getIsOver()).size();
        }
    }

    @Override
    public int fintSubjectRowCount(Invoker invoker, SubjectSelectInfo info) {
        Actor actor = ic.createActor(invoker);

        if (info == null) {
            return subjectRepo.findAllSubjectsCount(actor.getCircle().getId(), actor.getTeam().getId());
        }
        else {
            return subjectRepo.findSubjectCountByQuery(actor.getCircle().getId(), actor.getTeam().getId(), info.getName(),
                    info.getPhone(), info.getSendType());
        }
    }

    @Override
    public void addSubject(Invoker invoker, AddSubjectCommand command) {
        Actor actor = ic.createActor(invoker);
        Person person =  subjectRepo.findPersonByPhone(command.getPhone());
        if (person == null) {
            person = subjectRepo.findPersonByIdNo(command.getIdNo());
        }

        IdCardNumber card = parser.parseIdCardNumber(command.getIdNo());

        AddSubjectData data = AddSubjectData.builder()
                ._name______________(command.getName())
                ._phone_____________(command.getPhone())
                ._idNo______________(command.getIdNo())
                ._gender____________(new IdAndName(card.getGender().name().equals("男") ? "1" : "2", card.getGender().name()))
                ._birthDay__________(card.getBirthday())
                ._region____________(new IdAndName(command.getRegionId(), calcRegionName(command.getRegionId())))
                ._address___________(command.getAddress())
                ._jinjiname_________(command.getJinjiName())
                ._jinjiphone________(command.getJinjiPhone())
                ._subjectType_______(new IdAndName(command.getSubjectType().getId(), command.getSubjectType().getName()))
                ._subjectDesc_______(command.getDesc())
                ._dType_____________(command.getSendType().getId())
                ._team______________(command.getMealSite())
                ._dd________________(command.getOverDraft() == null ? null : Double.parseDouble(command.getOverDraft()))
                ._diseases__________(command.getDiseases().stream().map(e -> e).collect(Collectors.toList()))
                ._wnjinji___________(command.getWnjinji())
                ._wrahuji___________(command.getWrahuji())
                ._livingConditions__(command.getLivingConditions().stream().map(e -> e).collect(Collectors.toList()))
                ._wrafuzhu__________(command.isWrafuzhu())
                ._wchfuzhu__________(command.getWchfuzhu())
                ._wraguom___________(command.isWraguom())
                ._tfguom____________(command.getTfguom())
                ._wchjinji__________(command.getWchjinji().stream().map(e -> e).collect(Collectors.toList()))
                ._tfjinji___________(command.getTfjinji())
                ._lunchBoxNo________(command.getLunchBoxNo())
                ._subjectFoodLove___(command.getSubjectFoodLove())
                ._isMealHelp________(command.isMealHelp())
                ._build_();

        if (person != null) {
            service.addSubjectIsPerson(ic, actor, person, data);
        }
        else {
            service.addSubjectAndPerson(ic, actor, data);
        }

    }

    @Override
    public List<IdAndName> findSubjectTypes() {
        List<SubjectType> types = subjectRepo.findAllTypes();
        return types.stream()
                .map(e -> new IdAndName(e.getId(), e.getSubjectTypeName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<IdAndName> findTeams(String circleId) {
        List<Team> teams = subjectRepo.findTeamsByCircleId(circleId);
        return teams.stream().map(e -> new IdAndName(e.getId(), e.getTeamName())).collect(Collectors.toList());
    }

    private String calcRegionName(String regionId) {
        RegionNameView region = regionRepo.findRegionNameViewById(regionId);
        if (region == null) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        if (region.getProvinceName() != null) {
            builder.append(region.getProvinceName());
        }

        if (region.getCityName() != null) {
            builder.append(region.getCityName());
        }

        if (region.getDistrictName() != null) {
            builder.append(region.getDistrictName());
        }

        if (region.getStreetName() != null) {
            builder.append(region.getStreetName());
        }

        if (region.getCommitteeName() != null) {
            builder.append(region.getCommitteeName());
        }

        return builder.toString();
    }

    @Override
    public void editSubject(Invoker invoker, AddSubjectCommand command) {
        NxftSubject subject = subjectRepo.findById(command.getSubjectId());
        IdCardNumber card = parser.parseIdCardNumber(command.getIdNo());

        AddSubjectData data = AddSubjectData.builder()
                ._name______________(command.getName())
                ._phone_____________(command.getPhone())
                ._idNo______________(command.getIdNo())
                ._gender____________(new IdAndName(card.getGender().name().equals("男") ? "1" : "2", card.getGender().name()))
                ._birthDay__________(card.getBirthday())
                ._region____________(new IdAndName(command.getRegionId(), calcRegionName(command.getRegionId())))
                ._address___________(command.getAddress())
                ._jinjiname_________(command.getJinjiName())
                ._jinjiphone________(command.getJinjiPhone())
                ._subjectType_______(new IdAndName(command.getSubjectType().getId(), command.getSubjectType().getName()))
                ._subjectDesc_______(command.getDesc())
                ._dType_____________(command.getSendType().getId())
                ._team______________(command.getMealSite())
                ._dd________________(command.getOverDraft() == null ? null : Double.parseDouble(command.getOverDraft()))
                ._diseases__________(command.getDiseases().stream().map(e -> e).collect(Collectors.toList()))
                ._wnjinji___________(command.getWnjinji())
                ._wrahuji___________(command.getWrahuji())
                ._livingConditions__(command.getLivingConditions().stream().map(e -> e).collect(Collectors.toList()))
                ._wrafuzhu__________(command.isWrafuzhu())
                ._wchfuzhu__________(command.getWchfuzhu())
                ._wraguom___________(command.isWraguom())
                ._tfguom____________(command.getTfguom())
                ._wchjinji__________(command.getWchjinji().stream().map(e -> e).collect(Collectors.toList()))
                ._tfjinji___________(command.getTfjinji())
                ._lunchBoxNo________(command.getLunchBoxNo())
                ._subjectFoodLove___(command.getSubjectFoodLove())
                ._isMealHelp________(command.isMealHelp())
                ._build_();
        subject.update(data);
        Person person = personRepo.findById(subject.getPersonInfo().getPersonId());
        person.updateBasicInfo(Person.BasicInfo.fullBuilder()
                ._personName____(command.getName())
                ._idtypeId______("01")
                ._idtypeName____("二代身份证")
                ._idNo__________(command.getIdNo())
                ._sexId_________(card.getGender().name().equals("男") ? "1" : "2")
                ._sexName_______(card.getGender().name())
                ._birthDate_____(DateUtils.parseShortDate(card.getBirthday()))
                ._build_());
        if (command.getPhone() != null) {
            person.updatePhone(command.getPhone());
        }
        subject.updateSubjectDisease(ic, new ArrayList<IdAndName>(command.getDiseases()));
        subject.updateFoodbiHits(ic, new ArrayList<IdAndName>(command.getWchjinji()));
        subject.updateLivingCon(ic, new ArrayList<IdAndName>(command.getLivingConditions()));
    }

    @Override
    public SubjectModel findSubjectModel(String id) {
        return SubjectMapper.INSTANCE.map(subjectRepo.findById(id));
    }

    @Override
    public OrderModel findOrderModel(String id) {
        return OrderMapper.INSTANCE.map(subjectRepo.findOrderById(id));
    }

    @Override
    public List<SubjectAccountList> findAccountList(String subjectId) {
        NxftSubject subject = subjectRepo.findById(subjectId);
        Account account = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
        List<AccountList> lists = aRepo.findListByAccountId(account.getId());
        return lists.stream().map(e -> new SubjectAccountList(subjectId, e.getCreateTime(), e.getListAmount()))
                .collect(Collectors.toList());
    }

    @Override
    public SubjectMoneyData findSubjectMoney(String subjectId) {
        NxftSubject subject = subjectRepo.findById(subjectId);
        Account account = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
        return SubjectMoneyData.builder()
                ._subjectId_(subjectId)
                ._name______(subject.getPersonInfo().getSubjectName())
                ._gender____(subject.getPersonInfo().getSexName())
                ._type______(subject.getSubjectInfo().getSubjectTypeName())
                ._yue_______(account.getBalanceCash())
                ._touzhi____(subject.getSubjectInfo().getOverdraft())
                ._phone_____(subject.getContactPhone())
                ._build_();
    }

    @Override
    public void recharge(Invoker invoker, String subjectId, Double money, String appId) {
        Actor actor = ic.createActor(invoker);
        NxftSubject subject = subjectRepo.findById(subjectId);
        Account account = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
        AccountList al = AccountList.fullAccountListBuilder()
                ._id____________________(ic.generateId(AccountList.class))
                ._accountId_____________(account.getId())
                ._listType______________("充值")
                ._listAmount____________(money)
                ._listSummary___________("坐席代充值")
                ._orderId_______________(null)
                ._listDesc______________(null)
                ._createTime____________(ic.now())
                ._createApplicationId___(appId)
                ._createUserId__________(actor.getUser().getId())
                ._createUserName________(actor.getUser().getBasicInfo().getNickname())
                ._build_();
        account.add(money);
        aRepo.addAccountList(al);

        if (subject.getContactPhone() == null) {
            LOGGER.warn("该对象手机号码为空！客户ID = {}", subject.getId());
        }
        else {
            Account accountNow = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
            String content = getContent(subject, ic.now(), money, accountNow.getBalanceCash());
            EcpAccount ecpAccount = tspClient.getEcpAccount(subject.getPersonInfo().getCircleId());
            SendSmsCommand command = SendSmsCommand.builder()
                    ._tspName_______(TspName.协同通讯)
                    ._tspKeys_______(ecpAccount.getEcpKeys())
                    ._account_______(ecpAccount.getAccount())
                    ._toNum_________(subject.getContactPhone())
                    ._templateId____("")
                    ._params________(new String[] {content})
                    ._build_();
            tspClient.sendSms(command);

            NxftSubjectSmsLog log = NxftSubjectSmsLog.newNxftSubjectSmsLog(ic, actor, getData(subject, content));
            subjectRepo.addSmsLog(log);
        }
    }

    private String getContent(NxftSubject subject, Date time, Double addNo, Double nowNo) {
        String content = String.format("【福来健康】：%s于%s充值%s成功！当前账户余额为%s元",
                subject.getPersonInfo().getSubjectName(), DateUtils.getLongDate(time),
                addNo, nowNo);
        return content;
    }

    private SmsLogData getData(NxftSubject subject, String content) {
        return SmsLogData.builder()
                ._subject_______(new IdAndName(subject.getId(), subject.getPersonInfo().getSubjectName()))
                ._tspName_______(TspName.协同通讯.name())
                ._smsContent____(content)
                ._smsDesc_______(DBC.短信业务.充值.value())
                ._toNumber______(subject.getContactPhone())
                ._toName________(subject.getPersonInfo().getSubjectName())
                ._build_();
    }

    @Override
    public List<MoneyListData> findMoneyListData(Invoker invoker, SelectMoneyListInfo info) {
        Actor actor = ic.createActor(invoker);
        List<AccountList> lists = aRepo.findListByQuery(info.getBegin(), info.getEnd(),
                info.isMine(), actor.getUser().getId());
        return lists.stream().map(e -> {
            AccountPerson ap = aRepo.findAc(e.getAccountId());
            Account a = subjectRepo.findAccountByPersonId(ap.getPersonId());
            NxftSubject subject = subjectRepo.findSubjectByPersonId(ap.getPersonId());
            MoneyListData data = MoneyListData.builder()
                    ._name______(subject.getPersonInfo().getSubjectName())
                    ._phone_____(subject.getContactPhone())
                    ._time______(e.getCreateTime())
                    ._jine______(e.getListAmount())
                    ._yue_______(a.getBalanceCash())
                    ._handname__(e.getCreateUserName())
                    ._build_();
            return data;
        }).collect(Collectors.toList());
    }

    @Override
    public List<IdAndName> findSubjectDiseases() {
        List<Disease> diseases = subjectRepo.findDiseases();
        return diseases.stream().map(e -> new IdAndName(e.getId(), e.getDiseaseName())).collect(Collectors.toList());
    }

    @Override
    public void cancelMoney(String appId, Invoker invoker, String subjectId, Double money) {
        Actor actor = ic.createActor(invoker);
        NxftSubject subject = subjectRepo.findById(subjectId);
        Account a = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
        a.updateCash(money);
        AccountList al = AccountList.fullAccountListBuilder()
                ._id____________________(ic.generateId(AccountList.class))
                ._accountId_____________(a.getId())
                ._listType______________("撤销")
                ._listAmount____________(money)
                ._listSummary___________("坐席撤销充值")
                ._orderId_______________(null)
                ._listDesc______________(null)
                ._createTime____________(ic.now())
                ._createApplicationId___(appId)
                ._createUserId__________(actor.getUser().getId())
                ._createUserName________(actor.getUser().getBasicInfo().getNickname())
                ._build_();
        aRepo.addAccountList(al);
    }

    @Override
    public SubjectModel findSubjectByIdNo(String idNo) {
        return SubjectMapper.INSTANCE.map(subjectRepo.findSubjectByIdNo(idNo));
    }

    @Override
    public SubjectModel findSubjectByPhone(String phone) {
        return SubjectMapper.INSTANCE.map(subjectRepo.findSubjectByPhone(phone));
    }

    @Override
    public void cancelRecjarge(String subjectId) {
        NxftSubject subject = subjectRepo.findById(subjectId);
        Account account = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
        List<AccountList> list = aRepo.findListByAccountId(account.getId());
        AccountList al = list.get(0);
        subjectRepo.deleteAccountList(al);
    }

    @Override
    public List<IdAndName> findFoodhibits() {
        List<FoodProhibit> hits = subjectRepo.findHibits();
        return hits.stream().map(e -> new IdAndName(e.getId(), e.getFoodProhibitName())).collect(Collectors.toList());
    }

    @Override
    public List<IdAndName> findFoodLove() {
        List<FoodLove> fls = subjectRepo.findFoodLove();
        return fls.stream()
                .map(e -> new IdAndName(e.getId(), e.getFoodLoveName()))
                .collect(Collectors.toList());
    }

}
