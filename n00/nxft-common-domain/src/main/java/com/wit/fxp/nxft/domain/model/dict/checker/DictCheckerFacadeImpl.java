package com.wit.fxp.nxft.domain.model.dict.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 检查{@code com.wit.fxp.nxft.domain.model.dict}下的所有实体在数据库中是否存在相应的数据表。
 *
 * @author Benewit Code Generator V1.0
 */
@Service
public class DictCheckerFacadeImpl implements DictCheckerFacade {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerfacadeimpl.template
     */

    private final DictChecker checker;

    /**
     * WEB服务需要此构造函数。
     */
    public DictCheckerFacadeImpl() {
        this(null);
    }

    /**
     * 构造函数。
     */
    @Autowired
    public DictCheckerFacadeImpl(DictChecker checker) {
        this.checker = checker;
    }

    @Override
    public void checkDomains() {
        this.checker.checkDomains();
    }

}
