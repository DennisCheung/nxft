// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.subject.base;

/**
 * 配餐对象疾病工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String pkId 主键id
 * 2. [不可空] String diseaseId 疾病id
 * 3. [不可空] String diseaseName 疾病名称
 * 4. [不可空] String subjectId 对象id
 * 5. [可空] String diseaseDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-subject/java/domain/com/wit/fxp/nxft/domain/model/subject/base/NxftSubjectDisease.html">NxftSubjectDisease代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractNxftSubjectDisease {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String diseaseId, String diseaseName, String subjectId, String diseaseDesc) {

        if (diseaseId == null) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[diseaseId(疾病id)]属性不能为空。");
        }

        if (diseaseId != null && diseaseId.length() > 32) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[diseaseId(疾病id)]属性超长，最大允许32，实际为" + diseaseId.length() + "。");
        }

        if (diseaseName == null) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[diseaseName(疾病名称)]属性不能为空。");
        }

        if (diseaseName != null && diseaseName.length() > 40) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[diseaseName(疾病名称)]属性超长，最大允许40，实际为" + diseaseName.length() + "。");
        }

        if (subjectId == null) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[subjectId(对象id)]属性不能为空。");
        }

        if (subjectId != null && subjectId.length() > 32) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[subjectId(对象id)]属性超长，最大允许32，实际为" + subjectId.length() + "。");
        }

        if (diseaseDesc != null && diseaseDesc.length() > 256) {
            throw new RuntimeException("[NxftSubjectDisease(配餐对象疾病)]对象的[diseaseDesc(备注)]属性超长，最大允许256，实际为" + diseaseDesc.length() + "。");
        }
    }

}
