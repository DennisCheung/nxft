package com.wit.hnxft.subject;

import java.util.Date;
import java.util.List;

import com.wit.hnxft.model.HnxftSubjectCountModel;
import com.wit.hnxft.model.HnxftSubjectModel;

/**
 * 助餐点工作站对象接口
 * @author lyb
 *
 */
public interface HnxftSubjectApp {

    /**
     * 统计客户
     * @param teamId
     * @return
     */
    HnxftSubjectCountModel statisticsSubject(String teamId);

    /**
     * 根据客户工作圈id以及客户id查找助餐点工作站对象
     * @param circleId
     * @param personId
     * @return
     */
    HnxftSubjectModel findHnxftSubjectModel(String circleId, String personId);

    /**
     * 得到助餐点下所有客户
     * @param teamId
     * @param date
     * @return
     */
    List<HnxftSubjectModel> findAllSubejct(String teamId, Date date);

    /**
     * 根据电话号码全号得到客户
     * @param mobile
     * @param date
     * @param teamId
     * @return
     */
    HnxftSubjectModel findSubjectByMobile(String mobile, Date date, String teamId) throws MobileVerificationException;
}
