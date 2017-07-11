package com.wit.fxp.nxft.domain.model.subject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wit.DBC;
import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.account.Account;
import com.wit.fxp.domain.model.account.AccountPerson;
import com.wit.fxp.domain.model.family.Family;
import com.wit.fxp.domain.model.family.repo.FamilyRepo;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.domain.model.person.repo.PersonRepo;
import com.wit.fxp.nxft.domain.model.subject.AddSubjectData;
import com.wit.fxp.nxft.domain.model.subject.NxftSubject;
import com.wit.fxp.nxft.domain.model.subject.repo.SubjectRepo;
import com.wit.utils.DateUtils;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired private SubjectRepo repo;
    @Autowired private FamilyRepo familyRepo;
    @Autowired private PersonRepo personRepo;
    @Autowired private InvocationContext ic;

    @Override
    public void addSubjectIsPerson(InvocationContext ic, Actor actor, Person person, AddSubjectData data) {
        NxftSubject subject = NxftSubject.newNxftSubjectPerson(ic, actor, person, data);
        subject.updateSubjectDisease(ic, data.getDiseases());
        subject.updateFoodbiHits(ic, data.getWchjinji());
        subject.updateLivingCon(ic, data.getLivingConditions());
        repo.addSubject(subject);
        Account a = repo.findAccountByPersonId(person.getId());
        if (a == null) {
            addAccount(person);
        }

    }

    @Override
    public void addSubjectAndPerson(InvocationContext ic, Actor actor, AddSubjectData data) {
        Family.BasicInfo basicInfo = Family.BasicInfo.fullBuilder()
                ._familyCode________(ic.generateBillNumber(DBC.单据号类型.家庭编号.value()))
                ._familyMember______(data.getName())
                ._agentUserId_______(null)
                ._agentName_________(data.getName())
                ._agentMobile_______(data.getPhone())
                ._familyPhone_______(data.getPhone())
                ._regionId__________(data.getRegion().getId())
                ._regionName________(data.getRegion().getName())
                ._address___________(data.getAddress())
                ._latitude__________(null)
                ._longitude_________(null)
                ._livingCondiName___(null)
                ._familyLastPhone___(null)
                ._familyDesc________(null)
                ._build_();

        Family.CircleInfo circleInfo = Family.CircleInfo.fullBuilder()
                ._circleId__(actor.getCircle().getId())
                ._teamId____(repo.findCreateFamilyTeam(actor.getCircle().getId()).get(0).getId())
                ._build_();

        Family.CreateInfo createInfo = Family.CreateInfo.fullBuilder()
                ._createDate________(ic.now())
                ._createUserId______(actor.getUser().getId())
                ._createUserName____(actor.getUser().getBasicInfo().getNickname())
                ._build_();
        Family family = Family.newFamily(ic, basicInfo, circleInfo, createInfo);
        familyRepo.saveFamily(family);

        Person person = Person.座席()
                ._ic________________(ic)
                ._personCode________(ic.generateBillNumber(DBC.单据号类型.客户编号.value()))
                ._userId____________(null)
                ._basicInfo_________(Person.BasicInfo.fullBuilder()
                        ._personName____(data.getName())
                        ._idtypeId______("01")
                        ._idtypeName____("二代身份证")
                        ._idNo__________(data.getIdNo())
                        ._sexId_________(data.getGender().getId())
                        ._sexName_______(data.getGender().getName())
                        ._birthDate_____(DateUtils.parseShortDate(data.getBirthDay()))
                        ._build_())
                 ._familyInfo________(Person.FamilyInfo.fullBuilder()
                         ._houseRelationName_("户主")
                         ._familyId__________(family.getId())
                         ._houseRelationId___("01")
                         ._build_())
                 ._expandInfo________(Person.ExpandInfo.EMPTY)
                  ._relationInfo______(Person.RelationInfo.fullBuilder()
                          ._personMobile__(data.getPhone())
                          ._workunitName__(null)
                          ._build_())
                   ._medinsumethInfo___(Person.MedinsumethInfo.EMPTY)
                   ._economystateInfo__(Person.EconomystateInfo.EMPTY)
                    ._registerInfo______(Person.RegisterInfo.fullBuilder()
                            ._registWay_________("SEAT")  // TODO
                            ._createDate________(ic.now())
                            ._createUserId______(actor.getUser().getId())
                            ._createUserName____(actor.getUser().getBasicInfo().getNickname())
                            ._build_())
                    ._fulai_____________(Person.FulaiserviceInfo.EMPTY)
                    ._opinfo____________(Person.CircleInfo.fullBuilder()
                            ._circleId__(actor.getCircle().getId())
                            ._build_())
                    ._build_();
        personRepo.savePerson(person);

        NxftSubject subject = NxftSubject.newNxftSubjectPerson(ic, actor, person, data);
        subject.updateSubjectDisease(ic, data.getDiseases());
        subject.updateFoodbiHits(ic, data.getWchjinji());
        subject.updateLivingCon(ic, data.getLivingConditions());
        repo.addSubject(subject);
        addAccount(person);
    }

    public void addAccount(Person person) {
        String accountId = ic.generateId(Account.class);
        Account account = Account.fullAccountBuilder()
                ._id____________(accountId)
                ._accountName___(person.getBasicInfo().getPersonName())
                ._balanceCash___(0.0)
                ._account_______(null)
                ._build_();
        repo.addAccount(account);
        repo.addAcountPerson(AccountPerson.fullAccountPersonBuilder()
                        ._id________(accountId)
                        ._personId__(person.getId())
                        ._build_());

    }

}
