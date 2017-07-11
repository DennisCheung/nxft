package com.wit.fxp.nxft.impl;

import java.text.SimpleDateFormat;
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
import com.wit.fxp.domain.model.account.repo.AccountRepo;
import com.wit.fxp.domain.model.circle.Application;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.domain.model.person.repo.PersonRepo;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.app.AddNxftOrderCommand;
import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.nxft.app.common.model.KitchenMenuData;
import com.wit.fxp.nxft.app.common.model.OptionData;
import com.wit.fxp.nxft.domain.model.dict.CircleKitchen;
import com.wit.fxp.nxft.domain.model.dict.MealType;
import com.wit.fxp.nxft.domain.model.dict.SubjectAssistance;
import com.wit.fxp.nxft.domain.model.dict.repo.NxftDictRepo;
import com.wit.fxp.nxft.domain.model.meal.MealDisease;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.OrderMoney;
import com.wit.fxp.nxft.domain.model.order.repo.NxftDeliveRepo;
import com.wit.fxp.nxft.domain.model.order.repo.NxftOrderRepo;
import com.wit.fxp.nxft.domain.model.order.service.NxftOrderService;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.NxftSubjectSmsLog;
import com.wit.fxp.nxft.domain.model.subject.SmsLogData;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.fxp.tsp.client.EcpAccount;
import com.wit.fxp.tsp.client.TspClient;
import com.wit.tsp.v3.TspName;
import com.wit.tsp.v3.outbound.SendSmsCommand;

@Component
@Transactional
public class AddOrderAppImpl implements AddOrderApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddOrderAppImpl.class);

    @Autowired private NxftDictRepo dictRepo;
    @Autowired private NxftOrderService service;
    @Autowired private InvocationContext ic;
    @Autowired private SubjectRepo subjectRepo;
    @Autowired private NxftOrderRepo nxftRepo;
    @Autowired private AccountRepo aRepo;
    @Autowired private PersonRepo personRepo;
    @Autowired private NxftDeliveRepo nxftDeliveRepo;

    @Autowired private TspClient tspClient;

    @Override
    public List<IdAndName> findAllMealType() {
        return dictRepo.findAllMealType().stream().map(e -> new IdAndName(e.getId(), e.getMealTypeName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<KitchenMenuData> findAllDatas(String circleId, String personId, Date mealDate) {
        List<KitchenMenuData> datas = new ArrayList<>();
        CircleKitchen chen = subjectRepo.findKitchen(circleId);
        List<MealType> types = dictRepo.findAllMealType();
        types.forEach(e -> {
            List<MealScheday> meals = subjectRepo.findMealBykit(chen.getKitchenTeamId(), e.getId(), DateUtils.getBegin(mealDate));
            datas.add(KitchenMenuData.builder()
                        ._mealType__(new IdAndName(e.getId(), e.getMealTypeName()))
                        ._datas_____(meals.stream().map(f -> {
                            String name1 = getShow(f, ic.now(), e, mealDate, personId);
                            List<MealDisease> mealDiseases = subjectRepo.findMealDiseasesByMealId(f.getMealId());
                            OptionData d = OptionData.builder()
                                    ._mealDate__(DateUtils.getBeginDate(f.getMealDate()))
                                    ._option____(new IdAndName(f.getMealId(), getItemName(name1, mealDiseases)))
                                    ._isEnable__(checkIsOver(f, ic.now(), e.getMealTime(), e.getOrderBefore()) && checkIsHas(personId, mealDate, e.getId(), f.getMealId()))
                                    ._isDisease_(mealDiseases.size() > 0)
                                    ._build_();
                            return d;
                        }).collect(Collectors.toList()))
                        ._build_());
        });
        return datas;
    }

    private String getItemName(String name, List<MealDisease> mealDiseases) {
        return name;
    }

    private String getShow(MealScheday f, Date now, MealType e, Date mealDate, String personId) {
        String value = f.getMealName() + "(" + f.getMealContent() + ")，" + f.getMealPrice() + "元";
        if (!checkIsHas(personId, mealDate, e.getId(), f.getMealId())) {
            return value + "【已点】";
        }
        else if (!checkIsOver(f, ic.now(), e.getMealTime(), e.getOrderBefore())) {
            return value + "【已过期】";
        }
        else {
            return value;
        }

    }

    /**
     * 当前真实时间必须小于中间框框那个时间拼接上mealType里面的精确就餐时间减去提前的小时数。
     * @param day 每天菜谱对象。
     * @param now 当前真实时间。
     * @param mealTime 精确就餐时间如 0700.
     * @param before 提前的小时数
     * @return
     */
    private boolean checkIsOver(MealScheday day, Date now, String mealTime, int before) {
        String a = mealTime.substring(0, 2);
        String b = mealTime.substring(2, 4);
        String c = a + ":" + b + ":00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String meal = sdf.format(day.getMealDate());
        String mealDate = meal + " " + c;
        Date md = DateUtils.parseLongDate(mealDate);
        return now.getTime() < (md.getTime() - before * 3600000);
    }

    private boolean checkIsHas(String personId, Date mealDate, String mealTypeId, String mealId) {
        NxftSubject subject = subjectRepo.findSubjectByPersonId(personId);
        if (subject == null) {
            return false;
        }
        else {
            NxftOrder order = nxftRepo.findNxftOrder(subject.getId(), mealDate, mealTypeId, mealId);
            if (order != null) {
                LOGGER.info("找到了！时间={}, personId={}, mealTypeId={}, mealId={}", mealDate.toString(), personId, mealTypeId, mealId);
            }
            else {
                LOGGER.info("没找到了！时间={}, personId={}, mealTypeId={}, mealId={}", mealDate.toString(), personId, mealTypeId, mealId);
            }
            return order == null;
        }
    }

    @Override
    public void 派单(Invoker invoker, String personId, List<AddNxftOrderCommand> commands, String type) {
        Actor actor = ic.createActor(invoker);
        NxftSubject subject = subjectRepo.findSubjectByPersonId(personId);
        Double[] payInfo = new Double[]{0.0, 0.0};
        commands.forEach(command -> {
            CircleKitchen chen = subjectRepo.findKitchen(actor.getCircle().getId());
            MealScheday day = subjectRepo.findMealScheDay(chen.getKitchenTeamId(), command.getMealDate(), command.getMealId(), command.getMealTypeId());
            SubjectAssistance sa = subjectRepo.findSa(subject.getPersonInfo().getCircleId(), subject.getSubjectInfo().getSubjectTypeId(), day.getMealTypeId());
            Double receivable = sa.补助(1 * day.getMealPrice());
            OrderMoney money = OrderMoney.builder()
                    ._deliveFee_____(chen.getDeliveFee())
                    ._quantity______(1)
                    ._sumTotal______(1 * day.getMealPrice())
                    ._sumPayment____(1 * day.getMealPrice() - receivable)
                    ._sumReceivable_(receivable)
                    ._build_();
            payInfo[0] += (day.getMealPrice() - receivable);
            payInfo[1] += (receivable);
            NxftOrder order = NxftOrder.newNxftOrder(ic, actor, subject, day, money, type);
            service.派单(ic, actor, order);
            subjectRepo.addOrder(order);

            Account account = subjectRepo.findAccountByPersonId(personId);
            account.updateCash(money.getSumPayment());
            AccountList al = AccountList.fullAccountListBuilder()
                    ._id____________________(ic.generateId(AccountList.class))
                    ._accountId_____________(account.getId())
                    ._listType______________("消费")
                    ._listAmount____________(-money.getSumPayment())
                    ._listSummary___________("订餐")
                    ._orderId_______________(order.getId())
                    ._listDesc______________(null)
                    ._createTime____________(ic.now())
                    ._createApplicationId___("DCGZZ")
                    ._createUserId__________(actor.getUser().getId())
                    ._createUserName________(actor.getUser().getBasicInfo().getNickname())
                    ._build_();
            aRepo.addAccountList(al);
        });

        Person person = personRepo.findById(personId);
        if (person.getRelationInfo().getPersonMobile() == null) {
            LOGGER.warn("该对象手机号码为空！客户ID = {}", personId);
        }
        else {
            Account account = subjectRepo.findAccountByPersonId(personId);
            String content = getSmsContent(actor.getCircle().getId(), subject.getPersonInfo().getSubjectName(),
                    DateUtils.getLongDate(ic.now()), commands, payInfo, account.getBalanceCash());
            EcpAccount ecpAccount = tspClient.getEcpAccount(person.getCircleInfo().getCircleId());
            SendSmsCommand command = SendSmsCommand.builder()
                    ._tspName_______(TspName.协同通讯)
                    ._tspKeys_______(ecpAccount.getEcpKeys())
                    ._account_______(ecpAccount.getAccount())
                    ._toNum_________(person.getRelationInfo().getPersonMobile())
                    ._templateId____("")
                    ._params________(new String[] {content})
                    ._build_();
            tspClient.sendSms(command);

            NxftSubjectSmsLog log = NxftSubjectSmsLog.newNxftSubjectSmsLog(ic, actor, getData(subject, content));
            subjectRepo.addSmsLog(log);
        }

    }

    private SmsLogData getData(NxftSubject subject, String content) {
        return SmsLogData.builder()
                ._subject_______(new IdAndName(subject.getId(), subject.getPersonInfo().getSubjectName()))
                ._tspName_______(TspName.协同通讯.name())
                ._smsContent____(content)
                ._smsDesc_______(DBC.短信业务.坐席订餐.value())
                ._toNumber______(subject.getContactPhone())
                ._toName________(subject.getPersonInfo().getSubjectName())
                ._build_();
    }

    private String getSmsContent(String circleId, String subjectName, String time, List<AddNxftOrderCommand> commands,
            Double[] payInfo, Double cash) {
        CircleKitchen chen = subjectRepo.findKitchen(circleId);
        String nv = commands.stream()
                .map(e -> {
                    MealScheday day = subjectRepo.findMealScheDay(chen.getKitchenTeamId(), e.getMealDate(), e.getMealId(), e.getMealTypeId());
                    String a = DateUtils.getChineseShortDate(e.getMealDate()) + "" + day.getMealTypeName() + "：" + day.getMealName();
                    return a;
                })
                .collect(Collectors.joining(";"));
        String content = String.format("【福来健康】：%s于%s订餐%s份下单成功！[%s]。政府补贴%s元，自费%s元，当前账户余额%s元。",
                subjectName, time, commands.size(), nv, payInfo[1], payInfo[0], cash);
        return content;
    }

    @Override
    public boolean findSubjectByPersonId(String personId) {
        NxftSubject subject = subjectRepo.findSubjectByPersonId(personId);
        return subject == null;
    }

    @Override
    public void 取消(Invoker invoker, String orderId) {
        NxftOrder order = nxftRepo.findById(orderId);
        Actor actor = ic.createActor(invoker);
        order.取消(ic, actor);

        NxftSubject subject = subjectRepo.findById(order.getSubjectInfo().getSubjectId());
        Account account = subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId());
        account.add(order.getSettleInfo().getSumPayment());
        AccountList al = AccountList.fullAccountListBuilder()
                ._id____________________(ic.generateId(AccountList.class))
                ._accountId_____________(account.getId())
                ._listType______________("消费")
                ._listAmount____________(order.getSettleInfo().getSumPayment())
                ._listSummary___________("订餐")
                ._orderId_______________(order.getId())
                ._listDesc______________(null)
                ._createTime____________(ic.now())
                ._createApplicationId___("DCGZZ")
                ._createUserId__________(actor.getUser().getId())
                ._createUserName________(actor.getUser().getBasicInfo().getNickname())
                ._build_();
        aRepo.addAccountList(al);
    }

    @Override
    public void comfirmDeliveNote(String deliveId, String userId, String teamId) {
        //1、更新配送单 nxft.delive_note 状态
        Invoker invoker = Invoker.builder()
                ._teamId____(teamId)
                ._userId____(userId)
                ._build_();
        DeliveNote note = this.nxftDeliveRepo.findDeliveNoteById(deliveId);
        Actor actor = ic.createActor(invoker);
        note.确认()
        ._lastState_____(DeliveNote.LastState.fullBuilder()
                ._lastState_____(com.wit.fxp.nxft.DBC.配送订单状态.已送达.value())
                ._lastTime______(ic.now())
                ._lastUserId____(actor.getUser().getId())
                ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                ._lastDesc______(null)
                ._build_())
        ._completeInfo__(DeliveNote.CompleteInfo.fullBuilder()
                ._isComplete________(true)
                ._completeState_____("SUCCESS")
                ._failReasonName____(null)
                ._completeTime______(ic.now())
                ._completeUserId____(actor.getUser().getId())
                ._completeNickname__(actor.getUser().getBasicInfo().getNickname())
                ._completeDesc______(null)
                ._build_())
        ._nextNode______(DeliveNote.NextNode.fullBuilder()
                ._nextNodeId________(null)
                ._nextNodeContent___(null)
                ._build_())
            ._invoke_();
    }

    @Override
    public void transmissionOrder(String orderId, String userId, String teamId) {
        Invoker invoker = Invoker.builder()
                ._teamId____(teamId)
                ._userId____(userId)
                ._build_();
        Actor actor = ic.createActor(invoker);
        NxftOrder order = this.nxftRepo.findById(orderId);
        order.发放(ic, actor);
    }

    @Override
    public String findUpdateContent(String applicationId) {
        Application app = subjectRepo.findApplicationById(applicationId);
        return app.getApplicationDesc();
    }

}
