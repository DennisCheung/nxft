package com.wit.fxp.nxft.domain.model.sis.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SisCheckerImpl implements SisChecker {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerimpl.template
     */

    private final SisCheckerRepo repo;

    /**
     * 创建{@link SisCheckerImpl}对象。
     *
     * @param repo 仓储
     */
    @Autowired
    public SisCheckerImpl(SisCheckerRepo repo) {
        this.repo = repo;
    }

    // CHECKSTYLE IGNORE MethodLength FOR NEXT 1 LINES
    @Override
    public void checkDomains() {

        // 配餐服务资源
        this.repo.findSisServiceResource();
    }

}
