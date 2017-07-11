package com.wit.fxp.nxft.compound;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.core.env.CurrentDate;
import com.wit.Invoker;
import com.wit.datatype.IdAndName;
import com.wit.error.UserVisibleException;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.compound.model.DeliveNoteModel;
import com.wit.fxp.nxft.compound.model.HandCreatCompoundCommand;
import com.wit.fxp.nxft.compound.model.MealTypeModel;
import com.wit.fxp.nxft.compound.model.NxftOrderCollectModel;
import com.wit.fxp.nxft.compound.model.NxftOrderDetailModel;
import com.wit.fxp.nxft.domain.model.dict.MealType;
import com.wit.fxp.nxft.domain.model.dict.SubjectType;
import com.wit.fxp.nxft.domain.model.dict.repo.NxftDictRepo;
import com.wit.fxp.nxft.domain.model.order.DeliveCreateLog;
import com.wit.fxp.nxft.domain.model.order.DeliveDetail;
import com.wit.fxp.nxft.domain.model.order.DeliveDetailNum;
import com.wit.fxp.nxft.domain.model.order.DeliveNote;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.repo.NxftDeliveRepo;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.mapper.CompoundOrderMapper;
import com.wit.fxp.nxft.menu.model.DeliveNumModel;
import com.wit.fxp.nxft.menu.model.DeliveNumModel.DeliveDetailNumModel;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.fxp.nxft.schedule.NxftOrderGroupModel;
import com.wit.fxp.nxft.schedule.configure.CompoundMealJobConfigure;
import com.wit.utils.DateUtils;

@Transactional
@Component(NxftCompoundApp.BEAN_NAME)
public class NxftCompoundAppImpl implements NxftCompoundApp {

    private final InvocationContext ic;
    private final CompoundMealJobConfigure compoundMealJobConfigure;
    private final NxftDictRepo nxftDictRepo;
    private final NxftDeliveRepo nxftDeliveRepo;
    private final SubjectRepo subjectRepo;

    private Map<String, Team> teamCache = new HashMap<>();

    @Autowired
    public NxftCompoundAppImpl(InvocationContext ic, NxftDictRepo nxftDictRepo, CompoundMealJobConfigure compoundMealJobConfigure,
            NxftDeliveRepo nxftDeliveRepo, SubjectRepo subjectRepo) {
        this.ic = ic;
        this.compoundMealJobConfigure = compoundMealJobConfigure;
        this.nxftDictRepo = nxftDictRepo;
        this.nxftDeliveRepo = nxftDeliveRepo;
        this.subjectRepo = subjectRepo;
    }

    @Override
    public void compoundCreateEveryDay(Date currentDate) {
        List<MealType> mealTypes = this.nxftDictRepo.findAllMealType();
        Calendar cal = new GregorianCalendar();
        for (int i = 0; i < mealTypes.size(); i++) {
            cal.setTime(currentDate);
            MealType mealType = mealTypes.get(i);
            String mealTime = mealType.getMealTime();
            String hourStr = mealTime.substring(0, 2);
            String minuteStr = mealTime.substring(2);
            int hourInt = Integer.parseInt(hourStr);
            int minuteInt = Integer.parseInt(minuteStr);
            cal.set(Calendar.HOUR_OF_DAY, hourInt);
            cal.set(Calendar.MINUTE, minuteInt);
            cal.add(Calendar.HOUR_OF_DAY, -mealType.getOrderBefore());
            Date mealTypeTime = cal.getTime();
            if (currentDate.after(mealTypeTime)) {
                List<DeliveCreateLog> deliveCreateLog = this.nxftDeliveRepo.findDeliveCreateLog(DateUtils.getBegin(currentDate),
                        DateUtils.getEnd(currentDate), mealType.getId());
                //检索 配送单生成日志表 nxft.delive_create_log，看小于 5月6日11点 即  5月6日早餐、5月6日午餐 的配送单是否生成,
                //未生成就需要生成
                if (deliveCreateLog.size() >= 1) {
                    // 已生成，不生成配送单
                    continue;
                }
                else {
                    createDeliveNote(mealType, currentDate);
                }
            }
        }
    }

    private void createDeliveNote(MealType mealType, Date currentDate) {
        List<NxftOrder> unDeliveOrder = this.nxftDeliveRepo.findUnDeliveOrder(mealType.getId(), DateUtils.getBegin(currentDate), DateUtils.getEnd(currentDate));
        //1、插 配送单生成日志表 nxft.delive_create_log
        Map<String, List<NxftOrderGroupModel>> collect = unDeliveOrder.stream().map(e -> {
            String groupId = e.getMealInfo().getKitchenCircleId() + "@" + e.getMealInfo().getKitchenTeamId() + "@" + DateUtils.getShortDate(e.getMealInfo().getMealDate())
                    + "@" + e.getMealInfo().getMealTypeId() + "@" + e.getSubjectInfo().getDeliveSiteId() + "@" + e.getSubjectInfo().getDeliveType();
            return NxftOrderGroupModel.builder()
                    ._groupId___(groupId)
                    ._order_____(e)
                    ._build_();
        })
                .collect(Collectors.groupingBy(NxftOrderGroupModel::getGroupId));

        Iterator<Entry<String, List<NxftOrderGroupModel>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<NxftOrderGroupModel>> next = iterator.next();
            List<NxftOrderGroupModel> value = next.getValue();
            NxftOrderGroupModel first = value.get(0);
            QuanlityUtils qu = new QuanlityUtils();
            String quanlitydesc = value.stream().map(e -> {
                qu.add(e.getOrder().getSettleInfo().getQuantity());
                return e.getOrder().getMealInfo().getMealName() + e.getOrder().getSettleInfo().getQuantity() + "份";
            })
                    .collect(Collectors.joining("，"));

            String format = String.format("配送订餐(%s)", first.getOrder().getSubjectInfo().getDeliveSiteName());
            Team team = getTeam(first.getOrder().getSubjectInfo().getDeliveSiteId());
            if (team == null) {
                throw new UserVisibleException("助餐点相应的team记录为空，teamId=" + first.getOrder().getSubjectInfo().getDeliveSiteId());
            }
            DeliveNote deliveNote = DeliveNote.fullDeliveNoteBuilder()
                    ._id____________(ic.generateBillNumber("NXFT_DELIVE_NOTE_ID")) // 暂时先用这个
                    ._deliveInfo____(DeliveNote.DeliveInfo.fullBuilder()
                            ._circleId__________(first.getOrder().getSubjectInfo().getCircleId())
                            ._deliveType________(first.getOrder().getSubjectInfo().getDeliveType())
                            ._deliveSiteId______(first.getOrder().getSubjectInfo().getDeliveSiteId())
                            ._deliveSiteName____(first.getOrder().getSubjectInfo().getDeliveSiteName())
                            ._kitchenCircleId___(first.getOrder().getMealInfo().getKitchenCircleId())
                            ._kitchenTeamId_____(first.getOrder().getMealInfo().getKitchenTeamId())
                            ._mealDate__________(first.getOrder().getMealInfo().getMealDate())
                            ._week______________(first.getOrder().getMealInfo().getWeek())
                            ._mealTypeId________(first.getOrder().getMealInfo().getMealTypeId())
                            ._mealTypeName______(first.getOrder().getMealInfo().getMealTypeName())
                            ._quantity__________(qu.get())
                            ._quantityDesc______(quanlitydesc)
                            ._deliveAddr________(team.getAddress())
                            ._contactPerson_____(team.getContactPerson())
                            ._contactMobile_____(team.getContactMobile())
                            ._build_())
                    ._createInfo____(DeliveNote.CreateInfo.fullBuilder()
                            ._createTime________(currentDate)
                            ._createUserId______(this.compoundMealJobConfigure.getJobUserid())
                            ._createUserName____(this.compoundMealJobConfigure.getJobNickname())
                            ._build_())
                    ._lastState_____(DeliveNote.LastState.fullBuilder()
                            ._lastState_____(DBC.配送订单状态.已接单.value())
                            ._lastTime______(currentDate)
                            ._lastUserId____(this.compoundMealJobConfigure.getJobUserid())
                            ._lastNickname__(this.compoundMealJobConfigure.getJobNickname())
                            ._lastDesc______(null)
                            ._build_())
                    ._nextNode______(DeliveNote.NextNode.fullBuilder()
                            ._nextNodeId________("DELIVE")
                            ._nextNodeContent___(format)
                            ._build_())
                    ._completeInfo__(DeliveNote.CompleteInfo.EMPTY)
                    ._build_();
            this.nxftDeliveRepo.saveDeliveNote(deliveNote);
            Map<String, List<NxftOrderGroupModel>> detailCollect = value.stream().map(e -> {
                String groupId = e.getOrder().getMealInfo().getMealId();
                return NxftOrderGroupModel.builder()
                        ._groupId___(groupId)
                        ._order_____(e.getOrder())
                        ._build_();
            })
                    .collect(Collectors.groupingBy(NxftOrderGroupModel::getGroupId));
            Iterator<Entry<String, List<NxftOrderGroupModel>>> detailIt = detailCollect.entrySet().iterator();
            while (detailIt.hasNext()) {
                Entry<String, List<NxftOrderGroupModel>> detailNext = detailIt.next();
                QuanlityUtils qu2 = new QuanlityUtils();
                detailNext.getValue().forEach(dv -> {
                    qu2.add(dv.getOrder().getSettleInfo().getQuantity());
                });
                NxftOrderGroupModel nxftOrderGroup = detailNext.getValue().get(0);
                DeliveDetail deliveDetail = DeliveDetail.fullDeliveDetailBuilder()
                        ._id____________(ic.generateId(DeliveDetail.class))
                        ._mealId________(nxftOrderGroup.getOrder().getMealInfo().getMealId())
                        ._mealCode______(nxftOrderGroup.getOrder().getMealInfo().getMealCode())
                        ._mealName______(nxftOrderGroup.getOrder().getMealInfo().getMealName())
                        ._quantity______(qu2.get())
                        ._deliveNoteId__(deliveNote.getId())
                        ._build_();
                deliveNote.新增详情()
                        ._detail____(deliveDetail)
                        ._invoke_();
                detailNext.getValue().forEach(dn -> {
                    String nextNodeDesc;
                    if (DBC.配送方式.到户.value().equals(dn.getOrder().getSubjectInfo().getDeliveType())) {
                        nextNodeDesc = String.format("配送订餐" + "(%s %s)", dn.getOrder().getSubjectInfo().getSubjectName(), dn.getOrder().getSubjectInfo().getAddress());
                    }
                    else {
                        nextNodeDesc = String.format("配送订餐" + "(%s %s)", dn.getOrder().getSubjectInfo().getSubjectName(), dn.getOrder().getSubjectInfo().getDeliveSiteName());
                    }
                    dn.getOrder().配送()
                    ._deliveNoteId__(deliveNote.getId())
                    ._lastState_____(NxftOrder.LastState.fullBuilder()
                            ._lastState_____(DBC.助餐订单状态.已接单.getValue())
                            ._lastTime______(currentDate)
                            ._lastUserId____(this.compoundMealJobConfigure.getJobUserid())
                            ._lastNickname__(this.compoundMealJobConfigure.getJobNickname())
                            ._lastDesc______(null)
                            ._build_())
                    ._nextNode______(NxftOrder.NextNode.fullBuilder()
                            ._nextNodeId________("DELIVE")
                            ._nextNodeContent___(nextNodeDesc)
                            ._build_())
                    ._invoke_();
                });
            }
        }

        DeliveCreateLog createLog = DeliveCreateLog.fullDeliveCreateLogBuilder()
                ._id____________(ic.generateId(DeliveCreateLog.class))
                ._mealDate______(DateUtils.getBegin(currentDate))
                ._mealTypeId____(mealType.getId())
                ._createTime____(currentDate)
                ._logDesc_______(null)
                ._build_();
        this.nxftDeliveRepo.saveDeliveCreateLog(createLog);
    }

    @Override
    public void handCompoundCreate(Invoker invoker, HandCreatCompoundCommand command) {
        Actor actor = this.ic.createActor(invoker);
        List<NxftOrder> unDeliveOrder = this.nxftDeliveRepo.findUnDeliveOrder(actor.getTeam().getId(), command.getMealTypeId(),
                DateUtils.getBegin(command.getMealDate()), DateUtils.getEnd(command.getMealDate()));

        //1、插 配送单生成日志表 nxft.delive_create_log
        Map<String, List<NxftOrderGroupModel>> collect = unDeliveOrder.stream().map(e -> {
            String groupId = e.getMealInfo().getKitchenCircleId() + "@" + e.getMealInfo().getKitchenTeamId() + "@" + DateUtils.getShortDate(e.getMealInfo().getMealDate())
                    + "@" + e.getMealInfo().getMealTypeId() + "@" + e.getSubjectInfo().getDeliveSiteId() + "@" + e.getSubjectInfo().getDeliveType();
            return NxftOrderGroupModel.builder()
                    ._groupId___(groupId)
                    ._order_____(e)
                    ._build_();
        })
                .collect(Collectors.groupingBy(NxftOrderGroupModel::getGroupId));
        Iterator<Entry<String, List<NxftOrderGroupModel>>> iterator = collect.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<String, List<NxftOrderGroupModel>> next = iterator.next();
            List<NxftOrderGroupModel> value = next.getValue();
            NxftOrderGroupModel first = value.get(0);
            QuanlityUtils qu = new QuanlityUtils();
            String quanlitydesc = value.stream().map(e -> {
                qu.add(e.getOrder().getSettleInfo().getQuantity());
                return e.getOrder().getMealInfo().getMealName() + e.getOrder().getSettleInfo().getQuantity() + "份";
            })
                    .collect(Collectors.joining("，"));

            String format = String.format("配送订餐(%s)", first.getOrder().getSubjectInfo().getDeliveSiteName());
            Team team = getTeam(first.getOrder().getSubjectInfo().getDeliveSiteId());
            if (team == null) {
                throw new UserVisibleException("助餐点相应的team记录为空，teamId=" + first.getOrder().getSubjectInfo().getDeliveSiteId());
            }
            DeliveNote deliveNote = DeliveNote.fullDeliveNoteBuilder()
                    ._id____________(ic.generateBillNumber("NXFT_DELIVE_NOTE_ID")) // 暂时先用这个
                    ._deliveInfo____(DeliveNote.DeliveInfo.fullBuilder()
                            ._circleId__________(first.getOrder().getSubjectInfo().getCircleId())
                            ._deliveType________(first.getOrder().getSubjectInfo().getDeliveType())
                            ._deliveSiteId______(first.getOrder().getSubjectInfo().getDeliveSiteId())
                            ._deliveSiteName____(first.getOrder().getSubjectInfo().getDeliveSiteName())
                            ._kitchenCircleId___(first.getOrder().getMealInfo().getKitchenCircleId())
                            ._kitchenTeamId_____(first.getOrder().getMealInfo().getKitchenTeamId())
                            ._mealDate__________(first.getOrder().getMealInfo().getMealDate())
                            ._week______________(first.getOrder().getMealInfo().getWeek())
                            ._mealTypeId________(first.getOrder().getMealInfo().getMealTypeId())
                            ._mealTypeName______(first.getOrder().getMealInfo().getMealTypeName())
                            ._quantity__________(qu.get())
                            ._quantityDesc______(quanlitydesc)
                            ._deliveAddr________(team.getAddress())
                            ._contactPerson_____(team.getContactPerson())
                            ._contactMobile_____(team.getContactMobile())
                            ._build_())
                    ._createInfo____(DeliveNote.CreateInfo.fullBuilder()
                            ._createTime________(this.ic.now())
                            ._createUserId______(actor.getUser().getId())
                            ._createUserName____(actor.getUser().getBasicInfo().getNickname())
                            ._build_())
                    ._lastState_____(DeliveNote.LastState.fullBuilder()
                            ._lastState_____(DBC.配送订单状态.已接单.value())
                            ._lastTime______(this.ic.now())
                            ._lastUserId____(actor.getUser().getId())
                            ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                            ._lastDesc______(null)
                            ._build_())
                    ._nextNode______(DeliveNote.NextNode.fullBuilder()
                            ._nextNodeId________("DELIVE")
                            ._nextNodeContent___(format)
                            ._build_())
                    ._completeInfo__(DeliveNote.CompleteInfo.EMPTY)
                    ._build_();
            this.nxftDeliveRepo.saveDeliveNote(deliveNote);
            Map<String, List<NxftOrderGroupModel>> detailCollect = value.stream().map(e -> {
                String groupId = e.getOrder().getMealInfo().getMealId();
                return NxftOrderGroupModel.builder()
                        ._groupId___(groupId)
                        ._order_____(e.getOrder())
                        ._build_();
            })
                    .collect(Collectors.groupingBy(NxftOrderGroupModel::getGroupId));
            Iterator<Entry<String, List<NxftOrderGroupModel>>> detailIt = detailCollect.entrySet().iterator();
            while (detailIt.hasNext()) {
                Entry<String, List<NxftOrderGroupModel>> detailNext = detailIt.next();
                QuanlityUtils qu2 = new QuanlityUtils();
                detailNext.getValue().forEach(dv -> {
                    qu2.add(dv.getOrder().getSettleInfo().getQuantity());
                });
                NxftOrderGroupModel nxftOrderGroup = detailNext.getValue().get(0);
                DeliveDetail deliveDetail = DeliveDetail.fullDeliveDetailBuilder()
                        ._id____________(ic.generateId(DeliveDetail.class))
                        ._mealId________(nxftOrderGroup.getOrder().getMealInfo().getMealId())
                        ._mealCode______(nxftOrderGroup.getOrder().getMealInfo().getMealCode())
                        ._mealName______(nxftOrderGroup.getOrder().getMealInfo().getMealName())
                        ._quantity______(qu2.get())
                        ._deliveNoteId__(deliveNote.getId())
                        ._build_();
                deliveNote.新增详情()
                        ._detail____(deliveDetail)
                        ._invoke_();
                detailNext.getValue().forEach(dn -> {
                    String nextNodeDesc;
                    if (DBC.配送方式.到户.value().equals(dn.getOrder().getSubjectInfo().getDeliveType())) {
                        nextNodeDesc = String.format("配送订餐" + "(%s %s)", dn.getOrder().getSubjectInfo().getSubjectName(), dn.getOrder().getSubjectInfo().getAddress());
                    }
                    else {
                        nextNodeDesc = String.format("配送订餐" + "(%s %s)", dn.getOrder().getSubjectInfo().getSubjectName(), dn.getOrder().getSubjectInfo().getDeliveSiteName());
                    }
                    dn.getOrder().配送()
                    ._deliveNoteId__(deliveNote.getId())
                    ._lastState_____(NxftOrder.LastState.fullBuilder()
                            ._lastState_____(DBC.助餐订单状态.已接单.getValue())
                            ._lastTime______(this.ic.now())
                            ._lastUserId____(actor.getUser().getId())
                            ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                            ._lastDesc______(null)
                            ._build_())
                    ._nextNode______(NxftOrder.NextNode.fullBuilder()
                            ._nextNodeId________("DELIVE")
                            ._nextNodeContent___(nextNodeDesc)
                            ._build_())
                    ._invoke_();
                });
            }
        }
    }

    @Override
    public List<NxftOrderDetailModel> findOrderDetail(String teamId, Date orderCreateB, Date orderCreateE, Date mealTimeB, Date mealTimeE, String subjectName,
            String orderState, String deliveSiteId, String subjectType, PagingInfo pageInfo) {
        if (pageInfo.isNeedResetTotalNum()) {
            Long totalNum = this.nxftDeliveRepo.findOrderDetailCount(teamId, orderCreateB, orderCreateE,
                    mealTimeB, mealTimeE, subjectName, orderState, deliveSiteId, subjectType);
            pageInfo.setTotalRecord(totalNum.intValue());
        }
        List<NxftOrder> orderDetail = this.nxftDeliveRepo.findOrderDetail(teamId, orderCreateB, orderCreateE,
                mealTimeB, mealTimeE, subjectName, orderState, deliveSiteId, subjectType, pageInfo.getStartIndex(), pageInfo.getPageSize());
        return CompoundOrderMapper.INSTANCE.mapOrder(orderDetail);
    }

    @Override
    public List<DeliveNoteModel> findDeliveNote(String teamId, PagingInfo pageInfo, Date mealDate, String state, String mealTypeId) {
        if (pageInfo.isNeedResetTotalNum()) {
            Long totalNum = this.nxftDeliveRepo.findDeliveNoteCount(teamId, DateUtils.getBegin(mealDate), DateUtils.getEnd(mealDate), state, mealTypeId);
            pageInfo.setTotalRecord(totalNum.intValue());
        }
        List<DeliveNote> deliveNote = this.nxftDeliveRepo.findDeliveNote(teamId, DateUtils.getBegin(mealDate), DateUtils.getEnd(mealDate), state, mealTypeId);
        return CompoundOrderMapper.INSTANCE.mapDeliveNote(deliveNote);
    }

    class QuanlityUtils {
        Integer i = 0;

        public void add(Integer n) {
            i += n;
        }

        public Integer get() {
            return i;
        }
    }

    @Override
    public void confirmDelive(Invoker invoker, String id) {
        Actor actor = this.ic.createActor(invoker);
        DeliveNote deliveNote = this.nxftDeliveRepo.findDeliveNoteById(id);
        deliveNote.配送()
                ._lastState_____(DeliveNote.LastState.fullBuilder()
                        ._lastState_____(DBC.配送订单状态.已配送.value())
                        ._lastTime______(this.ic.now())
                        ._lastUserId____(actor.getUser().getId())
                        ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                        ._lastDesc______(null)
                        ._build_())
                ._nextNode______(DeliveNote.NextNode.fullBuilder()
                        ._nextNodeId________("ARRIVE")
                        ._nextNodeContent___("送达订餐(" + deliveNote.getDeliveInfo().getDeliveSiteName() + ")")
                        ._build_())
                ._completeInfo__(DeliveNote.CompleteInfo.EMPTY)
                ._invoke_();
        List<NxftOrder> nxftOrders = this.nxftDeliveRepo.findNxftOrderByDeliveNoteId(id);
        nxftOrders.forEach(e -> {
            e.配送成功()
            ._lastState_____(NxftOrder.LastState.fullBuilder()
                            ._lastState_____(DBC.助餐订单状态.已配送.getValue())
                            ._lastTime______(this.ic.now())
                            ._lastUserId____(actor.getUser().getId())
                            ._lastNickname__(actor.getUser().getBasicInfo().getNickname())
                            ._lastDesc______(null)
                            ._build_())
            ._nextNode______(NxftOrder.NextNode.fullBuilder()
                    ._nextNodeId________("GIVE")
                    ._nextNodeContent___("发放订餐" + "(" + e.getSubjectInfo().getSubjectName() + " " + e.getSubjectInfo().getDeliveSiteName() + ")")
                    ._build_())
            ._complateInfo__(NxftOrder.CompleteInfo.EMPTY)
                ._invoke_();
        });
    }

    @Override
    public List<NxftOrderCollectModel> findNxftOrder(String teamId, Date beginDate, Date endDate) {
        List<NxftOrder> nxftOrder = this.nxftDeliveRepo.findNxftOrder(teamId, DateUtils.getBegin(beginDate), DateUtils.getEnd(endDate));
        return CompoundOrderMapper.INSTANCE.mapNxftOrderCollect(nxftOrder);
    }

    @Override
    public void confirmDelive(Invoker invoker, List<String> ids) {
        ids.forEach(e -> {
            confirmDelive(invoker, e);
        });
    }

    @Override
    public DeliveNumModel findDeliveNum(String teamId) {
        DeliveNumModel m = new DeliveNumModel();
        Date currentDate = new CurrentDate().getCurrentDate();
        Calendar calendar = new GregorianCalendar();
        Calendar calendar2 = new GregorianCalendar();
        List<DeliveDetailNum> today = this.nxftDeliveRepo.findDeliveDetailByTime(teamId, DateUtils.getBegin(currentDate), DateUtils.getEnd(currentDate));
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
        DeliveDetailNumModel detailt = new DeliveDetailNumModel(b, l, d);
        m.setToday(detailt);
        calendar.setTime(currentDate);
        calendar2.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_WEEK, 1);
        calendar2.set(Calendar.DAY_OF_WEEK, calendar2.getActualMaximum(Calendar.DAY_OF_WEEK));
        List<DeliveDetailNum> week = this.nxftDeliveRepo.findDeliveDetailByTime(teamId, DateUtils.getBegin(calendar.getTime()), DateUtils.getEnd(calendar2.getTime()));
        b = 0;
        l = 0;
        d = 0;
        for (int i = 0; i < week.size(); i++) {
            DeliveDetailNum de = week.get(i);
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
        DeliveDetailNumModel detailw = new DeliveDetailNumModel(b, l, d);
        m.setWeek(detailw);
        calendar.setTime(currentDate);
        calendar2.setTime(currentDate);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar2.set(Calendar.DAY_OF_MONTH, calendar2.getActualMaximum(Calendar.DAY_OF_MONTH));
        List<DeliveDetailNum> month = this.nxftDeliveRepo.findDeliveDetailByTime(teamId, DateUtils.getBegin(calendar.getTime()), DateUtils.getEnd(calendar2.getTime()));
        b = 0;
        l = 0;
        d = 0;
        for (int i = 0; i < month.size(); i++) {
            DeliveDetailNum de = month.get(i);
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
        DeliveDetailNumModel detailm = new DeliveDetailNumModel(b, l, d);
        m.setMonth(detailm);
        return m;
    }

    @Override
    public NxftOrderDetailModel findNxftOrder(String orderId) {
        NxftOrder nxftOrder = this.nxftDeliveRepo.findNxftOrderById(orderId);
        return CompoundOrderMapper.INSTANCE.mapOrder(nxftOrder);
    }

    @Override
    public List<MealTypeModel> findMealTypeList() {
        List<MealType> mealType = this.nxftDictRepo.findAllMealType();
        return CompoundOrderMapper.INSTANCE.mapMealType(mealType);
    }

    @Override
    public List<IdAndName> findDeliveSites(String kitchenTeamId) {
        List<Team> teams = this.nxftDeliveRepo.findDeliveSiteByKitchenTeamId(kitchenTeamId);
        return teams.stream().map(e -> new IdAndName(e.getId(), e.getTeamName())).collect(Collectors.toList());
    }

    @Override
    public List<IdAndName> findSubjectTypes() {
        List<SubjectType> types = subjectRepo.findAllTypes();
        return types.stream()
                .map(e -> new IdAndName(e.getId(), e.getSubjectTypeName()))
                .collect(Collectors.toList());
    }

    private Team getTeam(String teamId) {
        Team team = teamCache.get(teamId);
        if (team == null) {
            team = this.nxftDictRepo.findTeamById(teamId);
            teamCache.put(teamId, team);
        }
        return team;
    }

}
