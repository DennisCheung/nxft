package com.wit.fxp.nxft.domain.model.subject.repo;

import java.util.Date;
import java.util.List;

import com.wit.fxp.nxft.domain.model.subject.NxftSubject;

/**
 * 对象
 * @author lyb
 *
 */
public interface NxftSubjectRepo {

    /**
     * 根据工作圈id以及客户id查找对象
     * @param circleId
     * @param personId
     * @return
     */
    NxftSubject findNxftSubject(String circleId, String personId);

    /**
     * 根据teamId跟personId查找客户
     * @param teamId
     * @param personId
     * @return
     */
    NxftSubject findNxftSubjectByTeam(String teamId, String personId);

    /**
     * 根据助餐点id以及客户id查找对象
     * @param teamId
     * @param personId
     * @return
     */
    List<NxftSubject> findNxftSubjectByTeamId(String teamId);

    /**
     * 一定时间范围内创建的对象人数
     * @param teamId
     * @param begin
     * @param end
     * @return
     */
    int newCreateSubjectInDate(String teamId, Date begin, Date end);

    /**
     * 对象类型相应人数
     * @param teamId
     * @param type
     * @return
     */
    int subjectCountInType(String teamId, String typeCode);

    /**
     * 根据工作组查找对象列表
     * @param teamId
     * @return
     */
    List<NxftSubject> findSubjectListByTeamId(String teamId);

    /**
     *
     * @param circleId
     * @return
     */
    List<NxftSubject> findSubjectListByCircleid(String teamId, Integer startIndex, Integer pageSize);
}
