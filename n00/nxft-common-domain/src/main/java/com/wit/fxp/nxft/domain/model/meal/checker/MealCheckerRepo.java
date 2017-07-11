package com.wit.fxp.nxft.domain.model.meal.checker;

public interface MealCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepo.template
     */

    // 每天菜谱
    void findMealScheday();

    // 菜谱安排单
    void findMealSchenote();

    // 套餐字典
    void findMealSet();

}
