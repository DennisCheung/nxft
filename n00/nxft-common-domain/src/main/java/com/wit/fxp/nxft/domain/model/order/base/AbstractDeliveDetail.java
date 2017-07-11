// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.order.base;

/**
 * 配送单明细工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String detailId 明细ID
 * 2. [不可空] String mealId 套餐id
 * 3. [不可空] String mealCode 套餐CODE
 * 4. [不可空] String mealName 套餐名称
 * 5. [不可空] Integer quantity 数量
 * 6. [可空] String deliveNoteId 配送单id
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-order/java/domain/com/wit/fxp/nxft/domain/model/order/base/DeliveDetail.html">DeliveDetail代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractDeliveDetail {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String mealId, String mealCode, String mealName, Integer quantity, String deliveNoteId) {

        if (mealId == null) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[mealId(套餐id)]属性不能为空。");
        }

        if (mealId != null && mealId.length() > 32) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[mealId(套餐id)]属性超长，最大允许32，实际为" + mealId.length() + "。");
        }

        if (mealCode == null) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[mealCode(套餐CODE)]属性不能为空。");
        }

        if (mealCode != null && mealCode.length() > 30) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[mealCode(套餐CODE)]属性超长，最大允许30，实际为" + mealCode.length() + "。");
        }

        if (mealName == null) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[mealName(套餐名称)]属性不能为空。");
        }

        if (mealName != null && mealName.length() > 40) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[mealName(套餐名称)]属性超长，最大允许40，实际为" + mealName.length() + "。");
        }

        if (quantity == null) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[quantity(数量)]属性不能为空。");
        }

        if (deliveNoteId != null && deliveNoteId.length() > 32) {
            throw new RuntimeException("[DeliveDetail(配送单明细)]对象的[deliveNoteId(配送单id)]属性超长，最大允许32，实际为" + deliveNoteId.length() + "。");
        }
    }

}
