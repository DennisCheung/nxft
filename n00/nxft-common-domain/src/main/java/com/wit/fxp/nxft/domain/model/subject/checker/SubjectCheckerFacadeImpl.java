package com.wit.fxp.nxft.domain.model.subject.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 检查{@code com.wit.fxp.nxft.domain.model.subject}下的所有实体在数据库中是否存在相应的数据表。
 *
 * @author Benewit Code Generator V1.0
 */
@Service
public class SubjectCheckerFacadeImpl implements SubjectCheckerFacade {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerfacadeimpl.template
     */

    private final SubjectChecker checker;

    /**
     * WEB服务需要此构造函数。
     */
    public SubjectCheckerFacadeImpl() {
        this(null);
    }

    /**
     * 构造函数。
     */
    @Autowired
    public SubjectCheckerFacadeImpl(SubjectChecker checker) {
        this.checker = checker;
    }

    @Override
    public void checkDomains() {
        this.checker.checkDomains();
    }

}
