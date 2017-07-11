package com.wit.fxp.nxft.domain.model.meal.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 检查{@code com.wit.fxp.nxft.domain.model.meal}下的所有实体在数据库中是否存在相应的数据表。
 *
 * @author Benewit Code Generator V1.0
 */
@Service
public class MealCheckerFacadeImpl implements MealCheckerFacade {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerfacadeimpl.template
     */

    private final MealChecker checker;

    /**
     * WEB服务需要此构造函数。
     */
    public MealCheckerFacadeImpl() {
        this(null);
    }

    /**
     * 构造函数。
     */
    @Autowired
    public MealCheckerFacadeImpl(MealChecker checker) {
        this.checker = checker;
    }

    @Override
    public void checkDomains() {
        this.checker.checkDomains();
    }

}
