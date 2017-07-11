// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.dict.base;

/**
 * 饮食偏好工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String foodLoveId 饮食偏好ID
 * 2. [不可空] String foodLoveCode 饮食偏好代码
 * 3. [不可空] String foodLoveName 饮食偏好名称
 * 4. [不可空] Boolean isother 是否是其他项 Y/N  其他项需手工输入备注
 * 5. [可空] String foodLoveDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-dict/java/domain/com/wit/fxp/nxft/domain/model/dict/base/FoodLove.html">FoodLove代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractFoodLove {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String foodLoveCode, String foodLoveName, Boolean isother, String foodLoveDesc) {

        if (foodLoveCode == null) {
            throw new RuntimeException("[FoodLove(饮食偏好)]对象的[foodLoveCode(饮食偏好代码)]属性不能为空。");
        }

        if (foodLoveCode != null && foodLoveCode.length() > 8) {
            throw new RuntimeException("[FoodLove(饮食偏好)]对象的[foodLoveCode(饮食偏好代码)]属性超长，最大允许8，实际为" + foodLoveCode.length() + "。");
        }

        if (foodLoveName == null) {
            throw new RuntimeException("[FoodLove(饮食偏好)]对象的[foodLoveName(饮食偏好名称)]属性不能为空。");
        }

        if (foodLoveName != null && foodLoveName.length() > 40) {
            throw new RuntimeException("[FoodLove(饮食偏好)]对象的[foodLoveName(饮食偏好名称)]属性超长，最大允许40，实际为" + foodLoveName.length() + "。");
        }

        if (isother == null) {
            throw new RuntimeException("[FoodLove(饮食偏好)]对象的[isother(是否是其他项 Y/N  其他项需手工输入备注)]属性不能为空。");
        }

        if (foodLoveDesc != null && foodLoveDesc.length() > 256) {
            throw new RuntimeException("[FoodLove(饮食偏好)]对象的[foodLoveDesc(备注)]属性超长，最大允许256，实际为" + foodLoveDesc.length() + "。");
        }
    }

}
