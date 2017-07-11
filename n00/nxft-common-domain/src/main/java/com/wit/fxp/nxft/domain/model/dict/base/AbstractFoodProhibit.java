// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.dict.base;

/**
 * 食物禁忌工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String foodProhibitId 食物禁忌ID
 * 2. [不可空] String foodProhibitCode 食物禁忌代码
 * 3. [不可空] String foodProhibitName 食物禁忌名称
 * 4. [不可空] Boolean isother 是否是其他项 Y/N  其他项需手工输入备注
 * 5. [可空] String foodProhibitDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-dict/java/domain/com/wit/fxp/nxft/domain/model/dict/base/FoodProhibit.html">FoodProhibit代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractFoodProhibit {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String foodProhibitCode, String foodProhibitName, Boolean isother, String foodProhibitDesc) {

        if (foodProhibitCode == null) {
            throw new RuntimeException("[FoodProhibit(食物禁忌)]对象的[foodProhibitCode(食物禁忌代码)]属性不能为空。");
        }

        if (foodProhibitCode != null && foodProhibitCode.length() > 8) {
            throw new RuntimeException("[FoodProhibit(食物禁忌)]对象的[foodProhibitCode(食物禁忌代码)]属性超长，最大允许8，实际为" + foodProhibitCode.length() + "。");
        }

        if (foodProhibitName == null) {
            throw new RuntimeException("[FoodProhibit(食物禁忌)]对象的[foodProhibitName(食物禁忌名称)]属性不能为空。");
        }

        if (foodProhibitName != null && foodProhibitName.length() > 40) {
            throw new RuntimeException("[FoodProhibit(食物禁忌)]对象的[foodProhibitName(食物禁忌名称)]属性超长，最大允许40，实际为" + foodProhibitName.length() + "。");
        }

        if (isother == null) {
            throw new RuntimeException("[FoodProhibit(食物禁忌)]对象的[isother(是否是其他项 Y/N  其他项需手工输入备注)]属性不能为空。");
        }

        if (foodProhibitDesc != null && foodProhibitDesc.length() > 256) {
            throw new RuntimeException("[FoodProhibit(食物禁忌)]对象的[foodProhibitDesc(备注)]属性超长，最大允许256，实际为" + foodProhibitDesc.length() + "。");
        }
    }

}
