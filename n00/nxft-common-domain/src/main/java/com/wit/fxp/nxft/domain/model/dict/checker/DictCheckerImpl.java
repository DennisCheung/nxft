package com.wit.fxp.nxft.domain.model.dict.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictCheckerImpl implements DictChecker {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerimpl.template
     */

    private final DictCheckerRepo repo;

    /**
     * 创建{@link DictCheckerImpl}对象。
     *
     * @param repo 仓储
     */
    @Autowired
    public DictCheckerImpl(DictCheckerRepo repo) {
        this.repo = repo;
    }

    // CHECKSTYLE IGNORE MethodLength FOR NEXT 1 LINES
    @Override
    public void checkDomains() {

        // 工作圈厨房签约
        this.repo.findCircleKitchen();

        // 饮食偏好
        this.repo.findFoodLove();

        // 食物禁忌
        this.repo.findFoodProhibit();

        // 餐别字典
        this.repo.findMealType();

        // 配餐对象补贴标准设置
        this.repo.findSubjectAssistance();

        // 配餐对象类型字典
        this.repo.findSubjectType();
    }

}
