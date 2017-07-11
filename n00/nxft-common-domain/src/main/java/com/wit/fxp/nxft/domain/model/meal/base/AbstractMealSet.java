// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.meal.base;

/**
 * 套餐字典工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String mealId 套餐id
 * 2. [不可空] String mealCode 套餐CODE
 * 3. [不可空] String mealName 套餐名称
 * 4. [不可空] String mealContent 套餐内容
 * 5. [可空] String tabooDisease 禁忌疾病，名称逗号分隔
 * 6. [可空] Integer pepperyLevel 辣度
 * 7. [不可空] Double mealPrice 单价
 * 8. [可空] String photoId 最新图片id
 * 9. [不可空] String kitchenCircleId 厨房圈id
 * 10. [不可空] Boolean available 是否可用？
 * 11. [可空] String mealDesc 备注
 * 19. [不可空] String kitchenTeamId 厨房teamid
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-meal/java/domain/com/wit/fxp/nxft/domain/model/meal/base/MealSet.html">MealSet代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractMealSet {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String mealCode, String mealName, String mealContent, String tabooDisease, Integer pepperyLevel, Double mealPrice, String photoId, String kitchenCircleId, Boolean available, String mealDesc, String kitchenTeamId) {

        if (mealCode == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealCode(套餐CODE)]属性不能为空。");
        }

        if (mealCode != null && mealCode.length() > 30) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealCode(套餐CODE)]属性超长，最大允许30，实际为" + mealCode.length() + "。");
        }

        if (mealName == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealName(套餐名称)]属性不能为空。");
        }

        if (mealName != null && mealName.length() > 40) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealName(套餐名称)]属性超长，最大允许40，实际为" + mealName.length() + "。");
        }

        if (mealContent == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealContent(套餐内容)]属性不能为空。");
        }

        if (mealContent != null && mealContent.length() > 60) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealContent(套餐内容)]属性超长，最大允许60，实际为" + mealContent.length() + "。");
        }

        if (tabooDisease != null && tabooDisease.length() > 100) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[tabooDisease(禁忌疾病，名称逗号分隔)]属性超长，最大允许100，实际为" + tabooDisease.length() + "。");
        }

        if (mealPrice == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealPrice(单价)]属性不能为空。");
        }

        if (photoId != null && photoId.length() > 32) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[photoId(最新图片id)]属性超长，最大允许32，实际为" + photoId.length() + "。");
        }

        if (kitchenCircleId == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[kitchenCircleId(厨房圈id)]属性不能为空。");
        }

        if (kitchenCircleId != null && kitchenCircleId.length() > 32) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[kitchenCircleId(厨房圈id)]属性超长，最大允许32，实际为" + kitchenCircleId.length() + "。");
        }

        if (available == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[available(是否可用？)]属性不能为空。");
        }

        if (mealDesc != null && mealDesc.length() > 256) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[mealDesc(备注)]属性超长，最大允许256，实际为" + mealDesc.length() + "。");
        }

        if (kitchenTeamId == null) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[kitchenTeamId(厨房teamid)]属性不能为空。");
        }

        if (kitchenTeamId != null && kitchenTeamId.length() > 32) {
            throw new RuntimeException("[MealSet(套餐字典)]对象的[kitchenTeamId(厨房teamid)]属性超长，最大允许32，实际为" + kitchenTeamId.length() + "。");
        }
    }

}
