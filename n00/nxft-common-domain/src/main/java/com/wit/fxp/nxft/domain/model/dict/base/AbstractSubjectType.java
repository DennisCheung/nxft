// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.dict.base;

/**
 * 配餐对象类型字典工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String subjectTypeId 对象类型id
 * 2. [不可空] String subjectTypeCode 对象类型CODE
 * 3. [不可空] String subjectTypeName 对象类型名称
 * 4. [不可空] Boolean available 是否可用？
 * 5. [可空] String subjectTypeDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-dict/java/domain/com/wit/fxp/nxft/domain/model/dict/base/SubjectType.html">SubjectType代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractSubjectType {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String subjectTypeCode, String subjectTypeName, Boolean available, String subjectTypeDesc) {

        if (subjectTypeCode == null) {
            throw new RuntimeException("[SubjectType(配餐对象类型字典)]对象的[subjectTypeCode(对象类型CODE)]属性不能为空。");
        }

        if (subjectTypeCode != null && subjectTypeCode.length() > 30) {
            throw new RuntimeException("[SubjectType(配餐对象类型字典)]对象的[subjectTypeCode(对象类型CODE)]属性超长，最大允许30，实际为" + subjectTypeCode.length() + "。");
        }

        if (subjectTypeName == null) {
            throw new RuntimeException("[SubjectType(配餐对象类型字典)]对象的[subjectTypeName(对象类型名称)]属性不能为空。");
        }

        if (subjectTypeName != null && subjectTypeName.length() > 40) {
            throw new RuntimeException("[SubjectType(配餐对象类型字典)]对象的[subjectTypeName(对象类型名称)]属性超长，最大允许40，实际为" + subjectTypeName.length() + "。");
        }

        if (available == null) {
            throw new RuntimeException("[SubjectType(配餐对象类型字典)]对象的[available(是否可用？)]属性不能为空。");
        }

        if (subjectTypeDesc != null && subjectTypeDesc.length() > 256) {
            throw new RuntimeException("[SubjectType(配餐对象类型字典)]对象的[subjectTypeDesc(备注)]属性超长，最大允许256，实际为" + subjectTypeDesc.length() + "。");
        }
    }

}
