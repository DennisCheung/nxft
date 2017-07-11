package com.wit.hnxft.subject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.domain.service.person.PersonService;
import com.wit.fxp.nxft.domain.model.dict.repo.NxftSubjectTypeRepo;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.repo.NxftSubjectRepo;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.fxp.nxft.utils.DateUtils;
import com.wit.hnxft.mapper.HnxftSubjectMapper;
import com.wit.hnxft.model.HnxftSubjectCountModel;
import com.wit.hnxft.model.HnxftSubjectModel;

@Transactional
@Component
public class HnxftSubjectAppImpl implements HnxftSubjectApp {

    @Autowired private NxftSubjectTypeRepo nxftSubjectTypeRepo;
    @Autowired private NxftSubjectRepo nxftSubjectRepo;
    @Autowired private SubjectRepo subjectRepo;
    @Autowired private PersonService personService;
    @Autowired private InvocationContext ic;

    @Override
    public HnxftSubjectCountModel statisticsSubject(String teamId) {
        return HnxftSubjectCountModel.builder()
                ._newInWeekCount____(this.nxftSubjectRepo.newCreateSubjectInDate(teamId, DateUtils.getBegin(DateUtils.getWeekBegin(this.ic.now())),
                        DateUtils.getEnd(DateUtils.getWeekEnd(this.ic.now()))))
                ._count_____________(this.nxftSubjectRepo.newCreateSubjectInDate(teamId, null, null))
                ._list______________(this.nxftSubjectTypeRepo.findSubjectTypeList()
                        .stream()
                        .map(e -> {
                            return HnxftSubjectCountModel.NameAndCount.builder()
                            ._name__(e.getSubjectTypeName())
                            ._count_(this.nxftSubjectRepo.subjectCountInType(teamId, e.getSubjectTypeCode()))
                            ._build_();
                        }).collect(Collectors.toList()))
                ._build_();
    }

    @Override
    public HnxftSubjectModel findHnxftSubjectModel(String circleId, String personId) {
        NxftSubject subject = this.nxftSubjectRepo.findNxftSubject(circleId, personId);
        if (subject == null) {
            return null;
        }
        else {
            String balance = String.valueOf(this.subjectRepo.findAccountByPersonId(subject.getPersonInfo().getPersonId()).getBalanceCash());
            String age = this.personService.得到客户(subject.getPersonInfo().getPersonId()).getBasicInfo().calcAge(this.ic.now());
            if (subject.getNxftSubjectDiseaseSet().isEmpty()) {
                return HnxftSubjectMapper.INSTANCE.map(subject, balance, age, null);
            }
            else {
                String disease = subject.getNxftSubjectDiseaseSet().stream().map(i -> i.getDiseaseName())
                         .collect(Collectors.joining("、"));
                return HnxftSubjectMapper.INSTANCE.map(subject, balance, age, disease);
            }
        }
    }

    @Override
    public List<HnxftSubjectModel> findAllSubejct(String teamId, Date date) {
        List<NxftSubject> list = this.nxftSubjectRepo.findSubjectListByTeamId(teamId);
        if (!list.isEmpty()) {
            return list.stream().map(e -> {
                String balance = String.valueOf(this.subjectRepo.findAccountByPersonId(e.getPersonInfo().getPersonId()).getBalanceCash());
                String age = this.personService.得到客户(e.getPersonInfo().getPersonId()).getBasicInfo().calcAge(date);
                if (e.getNxftSubjectDiseaseSet().isEmpty()) {
                    return HnxftSubjectMapper.INSTANCE.map(e, balance, age, null);
                }
                else {
                    String disease = e.getNxftSubjectDiseaseSet().stream().map(i -> i.getDiseaseName())
                            .collect(Collectors.joining("、"));
                    return HnxftSubjectMapper.INSTANCE.map(e, balance, age, disease);
                }
            }).collect(Collectors.toList());
        }
        return new ArrayList<HnxftSubjectModel>();
    }

    @Override
    public HnxftSubjectModel findSubjectByMobile(String mobile, Date date, String teamId) throws MobileVerificationException {
        //TODO 暂时不需要手机号码验证，目前是手机号码与座机号码均可
//        if (!MobileVerificationUtils.isPhoneLegal(mobile)) {
//            throw new MobileVerificationException("输入的手机号码格式有误!");
//        }
        Person person = this.personService.根据电话号码全号得到客户(mobile);
        if (person == null) {
            return null;
        }
        else {
            NxftSubject nxftSubject = this.nxftSubjectRepo.findNxftSubjectByTeam(teamId, person.getId());
            if (nxftSubject == null) {
                return null;
            }
            else {
                String balance = String.valueOf(this.subjectRepo.findAccountByPersonId(nxftSubject.getPersonInfo().getPersonId()).getBalanceCash());
                String age = this.personService.得到客户(nxftSubject.getPersonInfo().getPersonId()).getBasicInfo().calcAge(date);
                if (nxftSubject.getNxftSubjectDiseaseSet().isEmpty()) {
                    return HnxftSubjectMapper.INSTANCE.map(nxftSubject, balance, age, null);
                }
                else {
                    String disease = nxftSubject.getNxftSubjectDiseaseSet().stream().map(i -> i.getDiseaseName())
                            .collect(Collectors.joining("、"));
                    return HnxftSubjectMapper.INSTANCE.map(nxftSubject, balance, age, disease);
                }
            }
        }
    }

}
