package com.wit.fxp.nxft.domain.model.subject.service;

import com.wit.fxp.domain.invocation.Actor;
import com.wit.fxp.domain.invocation.InvocationContext;
import com.wit.fxp.domain.model.person.Person;
import com.wit.fxp.nxft.domain.model.subject.AddSubjectData;

public interface SubjectService {

    void addSubjectIsPerson(InvocationContext ic, Actor actor, Person person, AddSubjectData data);

    void addSubjectAndPerson(InvocationContext ic, Actor actor, AddSubjectData data);
}
