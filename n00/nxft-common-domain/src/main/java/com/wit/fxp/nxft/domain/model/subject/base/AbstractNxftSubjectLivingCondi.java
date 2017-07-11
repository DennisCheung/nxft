// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.subject.base;

/**
 * 配餐对象居住情况工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String pkId 主键id
 * 2. [不可空] String livingCondiId 居住情况ID
 * 3. [不可空] String livingCondiName 居住情况名称
 * 4. [不可空] Boolean isother 是否是其他项 Y/N  其他项需手工输入备注
 * 5. [不可空] String subjectId 对象id
 * 6. [可空] String livingCondiDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-subject/java/domain/com/wit/fxp/nxft/domain/model/subject/base/NxftSubjectLivingCondi.html">NxftSubjectLivingCondi代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractNxftSubjectLivingCondi {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String livingCondiId, String livingCondiName, Boolean isother, String subjectId, String livingCondiDesc) {

        if (livingCondiId == null) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[livingCondiId(居住情况ID)]属性不能为空。");
        }

        if (livingCondiId != null && livingCondiId.length() > 32) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[livingCondiId(居住情况ID)]属性超长，最大允许32，实际为" + livingCondiId.length() + "。");
        }

        if (livingCondiName == null) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[livingCondiName(居住情况名称)]属性不能为空。");
        }

        if (livingCondiName != null && livingCondiName.length() > 40) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[livingCondiName(居住情况名称)]属性超长，最大允许40，实际为" + livingCondiName.length() + "。");
        }

        if (isother == null) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[isother(是否是其他项 Y/N  其他项需手工输入备注)]属性不能为空。");
        }

        if (subjectId == null) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[subjectId(对象id)]属性不能为空。");
        }

        if (subjectId != null && subjectId.length() > 32) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[subjectId(对象id)]属性超长，最大允许32，实际为" + subjectId.length() + "。");
        }

        if (livingCondiDesc != null && livingCondiDesc.length() > 256) {
            throw new RuntimeException("[NxftSubjectLivingCondi(配餐对象居住情况)]对象的[livingCondiDesc(备注)]属性超长，最大允许256，实际为" + livingCondiDesc.length() + "。");
        }
    }

}
