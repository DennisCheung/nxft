package com.wit.fxp.nxft.menu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.benewit.core.env.CurrentDate;
import com.wit.Invoker;
import com.wit.fxp.domain.datatype.IdAndObject;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.person.Disease;
import com.wit.fxp.nxft.DBC;
import com.wit.fxp.nxft.domain.model.dict.repo.NxftDictRepo;
import com.wit.fxp.nxft.domain.model.meal.MealScheDayData;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.meal.MealSchenote;
import com.wit.fxp.nxft.domain.model.meal.MealSet;
import com.wit.fxp.nxft.domain.model.meal.repo.NxftMealSetRepo;
import com.wit.fxp.nxft.mapper.MealSetMapper;
import com.wit.fxp.nxft.menu.model.AddMealScheDayCommand;
import com.wit.fxp.nxft.menu.model.AddMealSetCommand;
import com.wit.fxp.nxft.menu.model.HbcDiseaseModel;
import com.wit.fxp.nxft.menu.model.MealScheDayModel;
import com.wit.fxp.nxft.menu.model.MealSchenoteModel;
import com.wit.fxp.nxft.menu.model.MealSetModel;
import com.wit.fxp.nxft.paging.PagingInfo;
import com.wit.utils.DateUtils;

@Transactional
@Component(NxftMealSetApp.BEAN_NAME)
public class NxftMealSetAppImpl implements NxftMealSetApp {

    private final InvocationContext ic;
    private final NxftMealSetRepo nxftMealSetRepo;
    private final NxftDictRepo nxftDictRepo;

    @Autowired
    public NxftMealSetAppImpl(InvocationContext ic, NxftMealSetRepo nxftMealSetRepo, NxftDictRepo nxftDictRepo) {
        this.ic = ic;
        this.nxftMealSetRepo = nxftMealSetRepo;
        this.nxftDictRepo = nxftDictRepo;
    }

    @Override
    public void addMealSet(Invoker invoker, AddMealSetCommand command) {
        Actor actor = this.ic.createActor(invoker);
        String mealSetNo = this.ic.generateBillNumber("NXFT_MEAL_ID"); //暂时办法，TODO
        Integer pepperyLevel = Integer.valueOf(command.getPepperyLevel() == null || command.getPepperyLevel().getId() == null ? "0" : command.getPepperyLevel().getId());
        String mealSetCode = command.getMealSetCode();
        mealSetCode = (mealSetCode == null || "".equals(mealSetCode)) ? mealSetNo : mealSetCode;
        MealSet mealSet = MealSet.fullMealSetBuilder()
                ._id________________(mealSetNo)
                ._mealCode__________(mealSetCode)
                ._mealName__________(command.getMealSetName())
                ._mealContent_______(command.getMealSetContent())
                ._tabooDisease______(null)
                ._pepperyLevel______(pepperyLevel == 0 ? null : pepperyLevel)
                ._mealPrice_________(command.getMealPrice())
                ._photoId___________(command.getPhotoId())
                ._kitchenCircleId___(actor.getCircle().getId())
                ._available_________(true)
                ._mealDesc__________(command.getMealSetDesc())
                ._kitchenTeamId_____(actor.getTeam().getId())
                ._build_();
        this.nxftMealSetRepo.saveMealSet(mealSet);
    }

    @Override
    public void editMealSet(String mealSetId, AddMealSetCommand command) {
        MealSet mealSet = this.nxftMealSetRepo.findMealSet(mealSetId);
        Integer pepperyLevel = Integer.valueOf(command.getPepperyLevel() == null || command.getPepperyLevel().getId() == null ? "0" : command.getPepperyLevel().getId());
        String mealSetCode = command.getMealSetCode();
        mealSetCode = (mealSetCode == null || "".equals(mealSetCode)) ? this.ic.generateBillNumber("NXFT_MEAL_ID") : mealSetCode;
        if (mealSet != null) {
            mealSet.更新()
                    ._mealSetCode___(mealSetCode)
                    ._mealName______(command.getMealSetName())
                    ._mealContent___(command.getMealSetContent())
                    ._pepperyLevel__(pepperyLevel == 0 ? null : pepperyLevel)
                    ._mealPrice_____(command.getMealPrice())
                    ._mealDesc______(command.getMealSetDesc())
                    ._invoke_();
        }
    }

    @Override
    public List<MealSetModel> findMealSetList(String teamId, PagingInfo pageInfo) {
        if (pageInfo.isNeedResetTotalNum()) {
            Long totalNum = this.nxftMealSetRepo.findMealSetCount(teamId);
            pageInfo.setTotalRecord(totalNum.intValue());
        }
        List<MealSet> mealSetList = this.nxftMealSetRepo.findMealSetList(teamId, pageInfo.getStartIndex(), pageInfo.getPageSize());
        List<MealSetModel> collect = mealSetList.stream().map(e -> {
            MealSetModel mapMealSet = MealSetMapper.INSTANCE.mapMealSet(e);
            mapMealSet.setLogcdate(e.getLogInfo().getLogcdate());
            return mapMealSet;
        })
                .collect(Collectors.toList());

        return collect;
    }

    @Override
    public List<MealSchenoteModel> findMealSchenoteList(String teamId, PagingInfo pageInfo, Date beginDate, Date endDate) {
        if (pageInfo.isNeedResetTotalNum()) {
            Long totalNum = this.nxftMealSetRepo.findMealSchenoteCount(teamId, beginDate, endDate);
            pageInfo.setTotalRecord(totalNum.intValue());
        }
        List<MealSchenote> mealSchenoteList = this.nxftMealSetRepo.findMealSchenoteList(teamId, beginDate, endDate, pageInfo.getStartIndex(), pageInfo.getPageSize());
        return MealSetMapper.INSTANCE.mapMealSchenote(mealSchenoteList);
    }

    @Override
    public List<MealSetModel> findMealSetList(String teamId) {
        List<MealSet> mealSetList = this.nxftMealSetRepo.findMealSetList(teamId);
        return MealSetMapper.INSTANCE.mapMealSet(mealSetList);
    }

    @Override
    public List<MealSetModel> findMealSetList(String teamId, String searchValue) {
        List<MealSet> mealSetList = this.nxftMealSetRepo.findMealSetList(teamId, searchValue);
        return MealSetMapper.INSTANCE.mapMealSet(mealSetList);
    }

    @Override
    public MealSetModel findMealSet(String id) {
        MealSet mealSet = this.nxftMealSetRepo.findMealSet(id);
        return MealSetMapper.INSTANCE.mapMealSet(mealSet);
    }

    @Override
    public MealSchenoteModel newMaxEndDate(Invoker invoker) {
        Actor actor = this.ic.createActor(invoker);
        MealSchenote lastMealSchenote = this.nxftMealSetRepo.findLastMealSchenote(actor.getTeam().getId());
        Date newMaxEndDate = null;
        Calendar calendar = new GregorianCalendar();
        Date currentDate = this.ic.now();
        if (lastMealSchenote == null) {
            calendar.setTime(currentDate);
            int i = calendar.get(Calendar.DAY_OF_WEEK);
            if (i == 1) {
                calendar.add(Calendar.DAY_OF_WEEK, 7);
                newMaxEndDate = calendar.getTime();
            }
            else {
                calendar.set(Calendar.DAY_OF_WEEK, 0);
                calendar.add(Calendar.DAY_OF_WEEK, 8);
                newMaxEndDate = calendar.getTime();
            }
        }
        else {
            Date maxEndDate = lastMealSchenote.getScheInfo().getEndDate();
            calendar.setTime(maxEndDate);
            int i = calendar.get(Calendar.DAY_OF_WEEK);
            if (i == 1) {
                calendar.add(Calendar.DAY_OF_WEEK, 7);
            }
            else {
                calendar.add(Calendar.DAY_OF_WEEK, 15 - i);
            }
            newMaxEndDate = calendar.getTime();
        }
        calendar.setTime(newMaxEndDate);
        calendar.add(Calendar.DAY_OF_WEEK, -6);
        MealSchenote mealSchenote = MealSchenote.fullMealSchenoteBuilder()
                ._id____________(this.ic.generateId(MealSchenote.class))
                ._scheInfo______(MealSchenote.ScheInfo.fullBuilder()
                        ._schenoteDesc______(null)
                        ._kitchenCircleId___(actor.getCircle().getId())
                        ._beginDate_________(calendar.getTime())
                        ._kitchenTeamId_____(actor.getTeam().getId())
                        ._endDate___________(newMaxEndDate)
                        ._periodModel_______(DBC.排班周期模式.周.value())
                        ._build_())
                ._createInfo____(MealSchenote.CreateInfo.fullBuilder()
                        ._createTime________(currentDate)
                        ._createUserId______(actor.getUser().getId())
                        ._createNickname____(actor.getUser().getBasicInfo().getNickname())
                        ._build_())
                ._publishInfo___(MealSchenote.PublishInfo.EMPTY)
                ._build_();
        this.nxftMealSetRepo.saveMealSchenote(mealSchenote);
        return MealSetMapper.INSTANCE.mapMealSchenote(mealSchenote);
    }

    @Override
    public MealSchenoteModel findMealSchenote(String schenoteId) {
        MealSchenote mealSchenote = this.nxftMealSetRepo.findMealSchenoteById(schenoteId);
        return MealSetMapper.INSTANCE.mapMealSchenote(mealSchenote);
    }

    @Override
    public void editMealScheDays(AddMealScheDayCommand command) {
        MealSchenote mealSchenote = this.nxftMealSetRepo.findMealSchenoteById(command.getMealSchenoteId());
        List<MealSet> mealSetList = this.nxftMealSetRepo.findMealSetList(command.getMealIds());
        Map<String, MealSet> collect = mealSetList.stream().collect(Collectors.toMap(MealSet::getId, e -> e));
        List<IdAndObject<String, MealScheDayData>> idAndObjects = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(command.getMealDate());
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        command.getMealIds().forEach(m -> {
            MealSet mealSet = collect.get(m);
            String mealTypeId = command.getMealTypeId();
            String mealTypeName = DBC.餐别.of(mealTypeId).name();
            IdAndObject<String, MealScheDayData> idAndObject = IdAndObject.<String, MealScheDayData>builder()
                    ._id________(m)
                    ._object____(MealScheDayData.builder()
                            ._mealDate______(command.getMealDate())
                            ._week__________((week - 1) == 0 ? 7 : (week - 1))
                            ._mealTypeId____(mealTypeId)
                            ._mealTypeName__(mealTypeName)
                            ._mealId________(mealSet.getId())
                            ._mealCode______(mealSet.getMealCode())
                            ._mealName______(mealSet.getMealName())
                            ._mealContent___(mealSet.getMealContent())
                            ._mealPrice_____(mealSet.getMealPrice())
                            ._scheduleDesc__(null)
                            ._build_())
                    ._build_();
            idAndObjects.add(idAndObject);
        });
        List<IdAndObject<String, MealScheDayData>> idAndObjectsOld = new ArrayList<>();
        mealSchenote.getMealSchedaySet().forEach(e -> {
            if (!DateUtils.getBegin(e.getMealDate()).equals(DateUtils.getBegin(command.getMealDate()))
                    || !e.getMealTypeId().equals(command.getMealTypeId())) {
                IdAndObject<String, MealScheDayData> idAndObject = IdAndObject.<String, MealScheDayData>builder()
                        ._id________(e.getId())
                        ._object____(MealScheDayData.builder()
                                ._mealDate______(e.getMealDate())
                                ._week__________(e.getWeek())
                                ._mealTypeId____(e.getMealTypeId())
                                ._mealTypeName__(e.getMealTypeName())
                                ._mealId________(e.getMealId())
                                ._mealCode______(e.getMealCode())
                                ._mealName______(e.getMealName())
                                ._mealContent___(e.getMealContent())
                                ._mealPrice_____(e.getMealPrice())
                                ._scheduleDesc__(e.getScheduleDesc())
                                ._build_())
                        ._build_();
                idAndObjectsOld.add(idAndObject);
            }
        });
        idAndObjects.addAll(idAndObjectsOld);
        mealSchenote.updateMealScheDays(idAndObjects, ic);
    }

    @Override
    public List<MealScheDayModel> findMealScheDay(String mealSchenoteId, Date mealDate, String mealTypeId) {
        List<MealScheday> mealScheDay = this.nxftMealSetRepo.findMealScheDay(mealSchenoteId, DateUtils.getBegin(mealDate), DateUtils.getEnd(mealDate), mealTypeId);
        return MealSetMapper.INSTANCE.mapMealScheDayModel(mealScheDay);
    }

    @Override
    public void returnPublishSchenote(Invoker invoker, String schenoteId) {
        MealSchenote mealSchenote = this.nxftMealSetRepo.findMealSchenoteById(schenoteId);
        mealSchenote.returnPublish();
        mealSchenote.getMealSchedaySet().forEach(e -> {
            e.returnPublish();
        });
    }

    @Override
    public void publishSchenote(Invoker invoker, String schenoteId) {
        MealSchenote mealSchenote = this.nxftMealSetRepo.findMealSchenoteById(schenoteId);
        Actor actor = this.ic.createActor(invoker);
        mealSchenote.发布()
                ._publishInfo___(MealSchenote.PublishInfo.fullBuilder()
                        ._isPublished_______(true)
                        ._publishTime_______(new CurrentDate().getCurrentDate())
                        ._publishUserId_____(actor.getUser().getId())
                        ._publishNickname___(actor.getUser().getBasicInfo().getNickname())
                        ._build_())
                ._invoke_();
        mealSchenote.getMealSchedaySet().forEach(e -> {
            e.publish();
        });
    }

    @Override
    public void deleteSchenote(String schenoteId) {
        this.nxftMealSetRepo.deleteSchenoteByid(schenoteId);
    }

    @Override
    public List<HbcDiseaseModel> findHbcDisease() {
        List<Disease> hbcDisease = this.nxftDictRepo.findHbcDisease();
        return MealSetMapper.INSTANCE.mapHbcDisease(hbcDisease);
    }

}
