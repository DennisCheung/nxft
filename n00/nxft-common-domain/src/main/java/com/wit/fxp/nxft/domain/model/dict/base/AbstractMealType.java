// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.dict.base;

/**
 * 餐别字典工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String mealTypeId 餐别类型id
 * 2. [不可空] String mealTypeName 餐别类型名称
 * 3. [不可空] String mealTime 就餐时间  24YYMM
 * 4. [不可空] Integer orderBefore 下单提前小时数
 * 5. [可空] String orderRuleDesc 规则描述  例如  晚上8：00前，可点次日早餐
 * 6. [不可空] Boolean available 是否可用？
 * 7. [可空] String mealTypeDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-dict/java/domain/com/wit/fxp/nxft/domain/model/dict/base/MealType.html">MealType代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractMealType {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String mealTypeName, String mealTime, Integer orderBefore, String orderRuleDesc, Boolean available, String mealTypeDesc) {

        if (mealTypeName == null) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[mealTypeName(餐别类型名称)]属性不能为空。");
        }

        if (mealTypeName != null && mealTypeName.length() > 40) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[mealTypeName(餐别类型名称)]属性超长，最大允许40，实际为" + mealTypeName.length() + "。");
        }

        if (mealTime == null) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[mealTime(就餐时间  24YYMM)]属性不能为空。");
        }

        if (mealTime != null && mealTime.length() > 4) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[mealTime(就餐时间  24YYMM)]属性超长，最大允许4，实际为" + mealTime.length() + "。");
        }

        if (orderBefore == null) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[orderBefore(下单提前小时数)]属性不能为空。");
        }

        if (orderRuleDesc != null && orderRuleDesc.length() > 256) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[orderRuleDesc(规则描述  例如  晚上8：00前，可点次日早餐)]属性超长，最大允许256，实际为" + orderRuleDesc.length() + "。");
        }

        if (available == null) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[available(是否可用？)]属性不能为空。");
        }

        if (mealTypeDesc != null && mealTypeDesc.length() > 256) {
            throw new RuntimeException("[MealType(餐别字典)]对象的[mealTypeDesc(备注)]属性超长，最大允许256，实际为" + mealTypeDesc.length() + "。");
        }
    }

}
