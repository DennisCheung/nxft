package com.wit.fxp.nxft.domain.model.subject.checker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectCheckerImpl implements SubjectChecker {
    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     *  codegen/templates//java/java-checkerimpl.template
     */

    private final SubjectCheckerRepo repo;

    /**
     * 创建{@link SubjectCheckerImpl}对象。
     *
     * @param repo 仓储
     */
    @Autowired
    public SubjectCheckerImpl(SubjectCheckerRepo repo) {
        this.repo = repo;
    }

    // CHECKSTYLE IGNORE MethodLength FOR NEXT 1 LINES
    @Override
    public void checkDomains() {

        // 配餐对象
        this.repo.findNxftSubject();

        // 配餐对象疾病
        this.repo.findNxftSubjectDisease();

        // 配餐对象食物禁忌
        this.repo.findNxftSubjectFoodProhibit();

        // 配餐对象居住情况
        this.repo.findNxftSubjectLivingCondi();

        // 暖心饭堂对象短信日志
        this.repo.findNxftSubjectSmsLog();
    }

}
