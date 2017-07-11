package com.wit.fxp.nxft.domain.model.meal.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealCheckerImpl implements MealChecker {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerimpl.template
     */

    private final MealCheckerRepo repo;

    /**
     * 创建{@link MealCheckerImpl}对象。
     *
     * @param repo 仓储
     */
    @Autowired
    public MealCheckerImpl(MealCheckerRepo repo) {
        this.repo = repo;
    }

    // CHECKSTYLE IGNORE MethodLength FOR NEXT 1 LINES
    @Override
    public void checkDomains() {

        // 每天菜谱
        this.repo.findMealScheday();

        // 菜谱安排单
        this.repo.findMealSchenote();

        // 套餐字典
        this.repo.findMealSet();
    }

}
