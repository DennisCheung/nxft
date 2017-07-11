package com.wit.hnxft.order;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.circle.Team;
import com.wit.fxp.domain.service.person.PersonService;
import com.wit.fxp.domain.service.team.GzqTeamService;
import com.wit.fxp.nxft.domain.model.dict.repo.NxftDictRepo;
import com.wit.fxp.nxft.domain.model.meal.MealScheday;
import com.wit.fxp.nxft.domain.model.meal.MealSchenote;
import com.wit.fxp.nxft.domain.model.meal.repo.NxftMealSetRepo;
import com.wit.fxp.nxft.domain.model.order.NxftOrder;
import com.wit.fxp.nxft.domain.model.order.repo.NxftDeliveRepo;
import com.wit.fxp.nxft.domain.model.order.repo.NxftOrderRepo;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.repo.NxftSubjectRepo;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.hnxft.api.order.HnxftOrderApp;
import com.wit.hnxft.mapper.HnxftDeliveNoteMapper;
import com.wit.hnxft.mapper.HnxftMealTypeMapper;
import com.wit.hnxft.mapper.HnxftOrderMapper;
import com.wit.hnxft.mapper.HnxftSubjectQueryMapper;
import com.wit.hnxft.mapper.HnxtDeliveDetailMapper;
import com.wit.hnxft.model.HnxftDeliveNoteModel;
import com.wit.hnxft.model.HnxftMealTypeModel;
import com.wit.hnxft.model.HnxftOrderCountModel;
import com.wit.hnxft.model.HnxftOrderModel;
import com.wit.hnxft.model.HnxftQuerySubjectOrderModel;
import com.wit.hnxft.model.HnxftSchenoteModel;
import com.wit.hnxft.model.HnxftSchenoteModel.WeekTime;
import com.wit.hnxft.model.HnxtDeliveDetailModel;

@Component
@Transactional
public class HnxftOrderAppImpl implements HnxftOrderApp {

    @Autowired private InvocationContext ic;
    @Autowired private NxftSubjectRepo nxftSubjectRepo;
    @Autowired private NxftOrderRepo nxftOrderRepo;
    @Autowired private NxftMealSetRepo nxftMealSetRepo;
    @Autowired private NxftDictRepo nxftDictRepo;
    @Autowired private SubjectRepo subjectRepo;
    @Autowired private PersonService personService;
    @Autowired private NxftDeliveRepo nxftDeliveRepo;
    @Autowired private GzqTeamService gzqTeamService;

    @Override
    public HnxftOrderCountModel statisticsOrder(String teamId) {
        return HnxftOrderCountModel.builder()
                ._dayCount______(this.nxftOrderRepo.findOrderCountByTeamId(teamId, DateUtils.getBegin(this.ic.now()),
                        DateUtils.getEnd(this.ic.now())))
                ._weekCount_____(this.nxftOrderRepo.findOrderCountByTeamId(teamId, DateUtils.getBegin(DateUtils.getWeekBegin(this.ic.now())),
                        DateUtils.getEnd(DateUtils.getWeekEnd(this.ic.now()))))
                ._monthCount____(this.nxftOrderRepo.findOrderCountByTeamId(teamId, DateUtils.getBegin(DateUtils.getMonthBegin()),
                        DateUtils.getEnd(DateUtils.getMonthEnd())))
                ._build_();
    }

    @Override
    public List<HnxftOrderModel> findHnxftOrderList(String teamId, Date time, String mealTypeId) {
        List<NxftOrder> list = this.nxftOrderRepo.findNxftOrderList(teamId, time, mealTypeId);
        if (list.isEmpty()) {
            return new ArrayList<HnxftOrderModel>();
        }
        else {
            return list.stream().map(e -> {
                NxftSubject subject = this.subjectRepo.findById(e.getSubjectInfo().getSubjectId());
                String personPhone = this.personService.得到客户联系电话(subject.getPersonInfo().getPersonId());
                return HnxftOrderMapper.INSTANCE.map(e, this.nxftMealSetRepo.findMealSet(e.getMealInfo().getMealId()).getContent(), personPhone);
            }).collect(Collectors.toList());
        }
    }

    @Override
    public List<HnxftMealTypeModel> findAllMealType() {
        return HnxftMealTypeMapper.INSTANCE.map(this.nxftDictRepo.findAllMealType());
    }

    @Override
    public List<HnxftQuerySubjectOrderModel> findHnxftOrderModelListBySubject(String teamId, Date date) {
        List<NxftSubject> subjectList = this.nxftSubjectRepo.findNxftSubjectByTeamId(teamId);
        if (subjectList.isEmpty()) {
            return null;
        }
        else {
            return subjectList.stream()
                .map(e -> {
                    Account account = this.subjectRepo.findAccountByPersonId(e.getPersonInfo().getPersonId());
                    List<NxftOrder> list = this.nxftOrderRepo.findOrderDeatil(teamId, e.getId(), DateUtils.getBegin(this.getLastTenTime(date)), date);
                    String phone = this.personService.得到客户联系电话(e.getPersonInfo().getPersonId());
                    if (!list.isEmpty()) {
                        double ownExpenseSum = 0.0;
                        double govCoseSum = 0.0;
                        for (int i = 0; i < list.size(); i++) {
                            ownExpenseSum += list.get(i).getSettleInfo().getSumPayment();
                            govCoseSum += list.get(i).getSettleInfo().getSumReceivable();
                        }
                        List<HnxftOrderModel> detailsList = list.stream().map(i -> {
                            NxftSubject subject = this.subjectRepo.findById(i.getSubjectInfo().getSubjectId());
                            String personPhone = this.personService.得到客户联系电话(subject.getPersonInfo().getPersonId());
                            return HnxftOrderMapper.INSTANCE.map(i, this.nxftMealSetRepo.findMealSet(i.getMealInfo().getMealId()).getContent(), personPhone);
                        }).collect(Collectors.toList());
                        return HnxftSubjectQueryMapper.INSTANCE.map(e.getId(), e.getPersonInfo().getSubjectName(),
                                String.valueOf(account.getBalanceCash()), detailsList, list.size(), phone, ownExpenseSum, govCoseSum);
                    }
                    else {
                        return HnxftSubjectQueryMapper.INSTANCE.map(e.getId(), e.getPersonInfo().getSubjectName(),
                                String.valueOf(account.getBalanceCash()), new ArrayList<HnxftOrderModel>(), 0, phone, 0.0, 0.0);
                    }
                }).collect(Collectors.toList());
        }
    }

    @Override
    public List<HnxftDeliveNoteModel> findHnxftDeliveNoteList(String teamId, String state) {
        Date now = this.ic.now();
        Date before = this.getLastTwoTime(this.ic.now());
        return HnxftDeliveNoteMapper.INSTANCE.map(this.nxftDeliveRepo.findDeliveNote(teamId, before, now, state));
    }

    @Override
    public List<HnxtDeliveDetailModel> findHnxftDeliveDetailList(String deliveId) {
        return HnxtDeliveDetailMapper.INSTANCE.map(this.nxftDeliveRepo.findDeliveDetailByDeliveId(deliveId));
    }

    @Override
    public List<HnxftOrderModel> findHnxftOrderListForTransmission(String teamId, Date date, String mealTypeId) {
        Date d = com.wit.fxp.nxft.utils.DateUtils.getBegin(date);
        List<NxftOrder> list = this.nxftOrderRepo.findNxftOrderListByDate(teamId, d, mealTypeId);
        if (list.isEmpty()) {
            return null;
        }
        else {
            return list.stream().map(e -> {
                NxftSubject subject = this.subjectRepo.findById(e.getSubjectInfo().getSubjectId());
                String mealContext = this.nxftMealSetRepo.findMealSet(e.getMealInfo().getMealId()).getContent();
                String personMobile = this.personService.得到客户联系电话(subject.getPersonInfo().getPersonId());
                return HnxftOrderMapper.INSTANCE.map(e, mealContext, personMobile);
            }).collect(Collectors.toList());
        }
    }

    @Override
    public HnxftSchenoteModel findScheData(String teamId, String weekDateBegin) {
        Team team = gzqTeamService.findTeamById(teamId);
        Date begin = DateUtils.parseShortDate(weekDateBegin);
        if (begin == null) {
            begin = this.ic.now();
        }
        begin = getWeekBegin(begin);
        Date end = getWeekEnd(begin);
        MealSchenote schenote = this.nxftMealSetRepo.findMealSchenoteByZCDGZZ(team.getCircle().getId(), DateUtils.getBegin(begin), DateUtils.getEnd(end));
        if (schenote == null) {
            return null;
        }
        String breakfast = com.wit.fxp.nxft.DBC.餐别.早餐.value();
        String lunch = com.wit.fxp.nxft.DBC.餐别.午餐.value();
        String dinner = com.wit.fxp.nxft.DBC.餐别.晚餐.value();
        Set<MealScheday> mealSchedaySet = schenote.getMealSchedaySet();
        Map<String, List<MealScheday>> mealType = mealSchedaySet.stream().collect(Collectors.groupingBy(MealScheday::getMealTypeId));
        Iterator<Entry<String, List<MealScheday>>> iterator = mealType.entrySet().iterator();
        HnxftSchenoteModel result = new HnxftSchenoteModel();
        List<WeekTime> weeks = getWeekTime(begin);
        result.setWeekTimes(weeks);
        while (iterator.hasNext()) {
            Entry<String, List<MealScheday>> next = iterator.next();
            if (breakfast.equals(next.getKey())) {
                HnxftSchenoteModel.MealTypeModel mt = getWeekData(next.getValue());
                result.setBreakfast(mt);
            }
            else if (lunch.equals(next.getKey())) {
                HnxftSchenoteModel.MealTypeModel mt = getWeekData(next.getValue());
                result.setLunch(mt);
            }
            else if (dinner.equals(next.getKey())) {
                HnxftSchenoteModel.MealTypeModel mt = getWeekData(next.getValue());
                result.setDinner(mt);
            }
        }
        return result;
    }

    @Override
    public Date plusWeek(String preDate, Integer add) {
        if (preDate == null) {
            return this.ic.now();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(DateUtils.parseShortDate(preDate));
        calendar.add(Calendar.WEEK_OF_MONTH, add);
        return calendar.getTime();
    }

    private List<WeekTime> getWeekTime(Date begin) {
        String[] w = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(begin);
        List<WeekTime> list = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            list.add(new WeekTime(DateUtils.getBegin(calendar.getTime()), w[i], i));
            calendar.add(GregorianCalendar.DATE, 1);
        }
        return list;
    }

    private HnxftSchenoteModel.MealTypeModel getWeekData(List<MealScheday> value) {
        Map<Integer, List<MealScheday>> collect = value.stream().collect(Collectors.groupingBy(MealScheday::getWeek));
        Iterator<Entry<Integer, List<MealScheday>>> iterator = collect.entrySet().iterator();
        HnxftSchenoteModel.MealTypeModel result = new HnxftSchenoteModel.MealTypeModel();
        while (iterator.hasNext()) {
            Entry<Integer, List<MealScheday>> next = iterator.next();
            switch (next.getKey()) {
            case 1:
                result.setMon(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            case 2:
                result.setTues(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            case 3:
                result.setWed(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            case 4:
                result.setThur(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            case 5:
                result.setFri(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            case 6:
                result.setSat(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            default:
                result.setSun(next.getValue().stream().map(e -> e.getMealName()).collect(Collectors.toList()));
                break;
            }
        }
        return result;
    }

    private Date getLastTenTime(Date currentDate) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(GregorianCalendar.DATE, -10);
        return calendar.getTime();
    }

    private Date getLastTwoTime(Date currentDate) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(currentDate);
        calendar.add(GregorianCalendar.DATE, -2);
        return calendar.getTime();
    }

    private Date getWeekEnd(Date begin) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(begin);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        Date end = null;
        if (i == 1) {
            end = calendar.getTime();
        }
        else {
            calendar.set(Calendar.DAY_OF_WEEK, 0);
            calendar.add(Calendar.DAY_OF_WEEK, 1);
            end = calendar.getTime();
        }
        return end;
    }

    private Date getWeekBegin(Date begin) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(begin);
        int i = calendar.get(Calendar.DAY_OF_WEEK);
        Date b = null;
        if (i == 1) {
            calendar.add(Calendar.DAY_OF_WEEK, -6);
            b = calendar.getTime();
        }
        else {
            calendar.set(Calendar.DAY_OF_WEEK, 2);
            b = calendar.getTime();
        }
        return b;
    }

}
