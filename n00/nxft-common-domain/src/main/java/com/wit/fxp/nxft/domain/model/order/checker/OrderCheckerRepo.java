package com.wit.fxp.nxft.domain.model.order.checker;

public interface OrderCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepo.template
     */

    // 配送单生成日志
    void findDeliveCreateLog();

    // 配送单明细
    void findDeliveDetail();

    // 配送单
    void findDeliveNote();

    // 配餐订单
    void findNxftOrder();

}
