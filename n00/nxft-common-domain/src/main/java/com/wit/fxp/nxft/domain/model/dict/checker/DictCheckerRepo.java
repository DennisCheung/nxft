package com.wit.fxp.nxft.domain.model.dict.checker;

public interface DictCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepo.template
     */

    // 工作圈厨房签约
    void findCircleKitchen();

    // 饮食偏好
    void findFoodLove();

    // 食物禁忌
    void findFoodProhibit();

    // 餐别字典
    void findMealType();

    // 配餐对象补贴标准设置
    void findSubjectAssistance();

    // 配餐对象类型字典
    void findSubjectType();

}
