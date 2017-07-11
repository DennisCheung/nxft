// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.subject.base;

/**
 * 配餐对象食物禁忌工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String pkId 主键id
 * 2. [不可空] String foodProhibitId 食物禁忌id
 * 3. [不可空] String foodProhibitName 食物禁忌名称
 * 4. [不可空] Boolean isother 是否是其他项 Y/N  其他项需手工输入备注
 * 5. [不可空] String subjectId 对象id
 * 6. [可空] String foodProhibitDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-subject/java/domain/com/wit/fxp/nxft/domain/model/subject/base/NxftSubjectFoodProhibit.html">NxftSubjectFoodProhibit代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractNxftSubjectFoodProhibit {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String foodProhibitId, String foodProhibitName, Boolean isother, String subjectId, String foodProhibitDesc) {

        if (foodProhibitId == null) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[foodProhibitId(食物禁忌id)]属性不能为空。");
        }

        if (foodProhibitId != null && foodProhibitId.length() > 32) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[foodProhibitId(食物禁忌id)]属性超长，最大允许32，实际为" + foodProhibitId.length() + "。");
        }

        if (foodProhibitName == null) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[foodProhibitName(食物禁忌名称)]属性不能为空。");
        }

        if (foodProhibitName != null && foodProhibitName.length() > 40) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[foodProhibitName(食物禁忌名称)]属性超长，最大允许40，实际为" + foodProhibitName.length() + "。");
        }

        if (isother == null) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[isother(是否是其他项 Y/N  其他项需手工输入备注)]属性不能为空。");
        }

        if (subjectId == null) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[subjectId(对象id)]属性不能为空。");
        }

        if (subjectId != null && subjectId.length() > 32) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[subjectId(对象id)]属性超长，最大允许32，实际为" + subjectId.length() + "。");
        }

        if (foodProhibitDesc != null && foodProhibitDesc.length() > 256) {
            throw new RuntimeException("[NxftSubjectFoodProhibit(配餐对象食物禁忌)]对象的[foodProhibitDesc(备注)]属性超长，最大允许256，实际为" + foodProhibitDesc.length() + "。");
        }
    }

}
