package com.wit.fxp.nxft.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.benewit.core.env.CurrentDate;
import com.wit.fxp.nxft.compound.NxftCompoundApp;

/**
 * 后台作业（fuser_id= JOB） 每隔10分钟 启动作业，对未接单的订单，自动接单并生成配送单
 *
 */
@Service
public class CompoundCreateEveryDayJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompoundCreateEveryDayJob.class);

    @Autowired private NxftCompoundApp nxftCompoundApp;

    @Scheduled(cron = "${nxft.plan.creatcompound-task.cron}")
    public void createData() {

        LOGGER.debug("启动003011_自动生成配送单 ...");
        nxftCompoundApp.compoundCreateEveryDay(new CurrentDate().getCurrentDate());
        LOGGER.debug("结束003011_自动生成配送单 。");
    }

}
