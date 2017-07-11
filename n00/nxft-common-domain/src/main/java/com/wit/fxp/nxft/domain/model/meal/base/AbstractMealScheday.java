// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.meal.base;

/**
 * 每天菜谱工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String scheduleId 安排id
 * 2. [不可空] String kitchenCircleId 厨房工作圈id
 * 2.1. [不可空] String kitchenTeamId 厨房teamid
 * 3. [不可空] String schenoteId 排班单id
 * 4. [不可空] java.util.Date mealDate 就餐日期
 * 5. [不可空] Integer week 周几
 * 6. [不可空] String mealTypeId 餐别ID
 * 7. [不可空] String mealTypeName 餐别名称
 * 8. [不可空] String mealId 套餐id
 * 9. [不可空] String mealCode 套餐CODE
 * 10. [不可空] String mealName 套餐名称
 * 11. [可空] String mealContent 套餐内容
 * 12. [不可空] Double mealPrice 单价
 * 13. [可空] String scheduleDesc 备注
 * 14. [不可空] Boolean isPublished 是否已发布？ Y/N
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-meal/java/domain/com/wit/fxp/nxft/domain/model/meal/base/MealScheday.html">MealScheday代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractMealScheday {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String kitchenCircleId, String kitchenTeamId, String schenoteId, java.util.Date mealDate, Integer week, String mealTypeId, String mealTypeName, String mealId, String mealCode, String mealName, String mealContent, Double mealPrice, String scheduleDesc, Boolean isPublished) {

        if (kitchenCircleId == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[kitchenCircleId(厨房工作圈id)]属性不能为空。");
        }

        if (kitchenCircleId != null && kitchenCircleId.length() > 32) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[kitchenCircleId(厨房工作圈id)]属性超长，最大允许32，实际为" + kitchenCircleId.length() + "。");
        }

        if (kitchenTeamId == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[kitchenTeamId(厨房teamid)]属性不能为空。");
        }

        if (kitchenTeamId != null && kitchenTeamId.length() > 32) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[kitchenTeamId(厨房teamid)]属性超长，最大允许32，实际为" + kitchenTeamId.length() + "。");
        }

        if (schenoteId == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[schenoteId(排班单id)]属性不能为空。");
        }

        if (schenoteId != null && schenoteId.length() > 32) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[schenoteId(排班单id)]属性超长，最大允许32，实际为" + schenoteId.length() + "。");
        }

        if (mealDate == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealDate(就餐日期)]属性不能为空。");
        }

        if (week == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[week(周几)]属性不能为空。");
        }

        if (mealTypeId == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealTypeId(餐别ID)]属性不能为空。");
        }

        if (mealTypeId != null && mealTypeId.length() > 32) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealTypeId(餐别ID)]属性超长，最大允许32，实际为" + mealTypeId.length() + "。");
        }

        if (mealTypeName == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealTypeName(餐别名称)]属性不能为空。");
        }

        if (mealTypeName != null && mealTypeName.length() > 40) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealTypeName(餐别名称)]属性超长，最大允许40，实际为" + mealTypeName.length() + "。");
        }

        if (mealId == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealId(套餐id)]属性不能为空。");
        }

        if (mealId != null && mealId.length() > 32) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealId(套餐id)]属性超长，最大允许32，实际为" + mealId.length() + "。");
        }

        if (mealCode == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealCode(套餐CODE)]属性不能为空。");
        }

        if (mealCode != null && mealCode.length() > 30) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealCode(套餐CODE)]属性超长，最大允许30，实际为" + mealCode.length() + "。");
        }

        if (mealName == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealName(套餐名称)]属性不能为空。");
        }

        if (mealName != null && mealName.length() > 40) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealName(套餐名称)]属性超长，最大允许40，实际为" + mealName.length() + "。");
        }

        if (mealContent != null && mealContent.length() > 60) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealContent(套餐内容)]属性超长，最大允许60，实际为" + mealContent.length() + "。");
        }

        if (mealPrice == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[mealPrice(单价)]属性不能为空。");
        }

        if (scheduleDesc != null && scheduleDesc.length() > 256) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[scheduleDesc(备注)]属性超长，最大允许256，实际为" + scheduleDesc.length() + "。");
        }

        if (isPublished == null) {
            throw new RuntimeException("[MealScheday(每天菜谱)]对象的[isPublished(是否已发布？ Y/N)]属性不能为空。");
        }
    }

}
