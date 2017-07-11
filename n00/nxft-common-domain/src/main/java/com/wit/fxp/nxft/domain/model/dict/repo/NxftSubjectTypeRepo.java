package com.wit.fxp.nxft.domain.model.dict.repo;

import java.util.List;

import com.wit.fxp.nxft.domain.model.dict.SubjectType;

/**
 * 对象类型
 * @author lyb
 *
 */
public interface NxftSubjectTypeRepo {

    /**
     * 得到所有对象类型
     * @return
     */
    List<SubjectType> findSubjectTypeList();
}
