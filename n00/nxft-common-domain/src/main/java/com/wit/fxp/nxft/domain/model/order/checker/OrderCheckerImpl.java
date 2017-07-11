package com.wit.fxp.nxft.domain.model.order.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderCheckerImpl implements OrderChecker {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerimpl.template
     */

    private final OrderCheckerRepo repo;

    /**
     * 创建{@link OrderCheckerImpl}对象。
     *
     * @param repo 仓储
     */
    @Autowired
    public OrderCheckerImpl(OrderCheckerRepo repo) {
        this.repo = repo;
    }

    // CHECKSTYLE IGNORE MethodLength FOR NEXT 1 LINES
    @Override
    public void checkDomains() {

        // 配送单生成日志
        this.repo.findDeliveCreateLog();

        // 配送单明细
        this.repo.findDeliveDetail();

        // 配送单
        this.repo.findDeliveNote();

        // 配餐订单
        this.repo.findNxftOrder();
    }

}
