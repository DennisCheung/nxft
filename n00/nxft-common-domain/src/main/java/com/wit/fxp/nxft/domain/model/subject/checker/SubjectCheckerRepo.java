package com.wit.fxp.nxft.domain.model.subject.checker;

public interface SubjectCheckerRepo {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerrepo.template
     */

    // 配餐对象
    void findNxftSubject();

    // 配餐对象疾病
    void findNxftSubjectDisease();

    // 配餐对象食物禁忌
    void findNxftSubjectFoodProhibit();

    // 配餐对象居住情况
    void findNxftSubjectLivingCondi();

    // 暖心饭堂对象短信日志
    void findNxftSubjectSmsLog();

}
