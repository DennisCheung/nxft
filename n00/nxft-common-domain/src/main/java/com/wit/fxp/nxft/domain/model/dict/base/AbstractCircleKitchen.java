// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.dict.base;

/**
 * 工作圈厨房签约工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String signId 签约id
 * 2. [不可空] String circleId 所属的工作圈id
 * 3. [不可空] String kitchenCircleId 厨房圈id
 * 4. [不可空] Double deliveFee 配送费
 * 5. [可空] String kitchenDesc 备注
 * 13. [不可空] String kitchenTeamId 厨房teamid
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-dict/java/domain/com/wit/fxp/nxft/domain/model/dict/base/CircleKitchen.html">CircleKitchen代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractCircleKitchen {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String circleId, String kitchenCircleId, Double deliveFee, String kitchenDesc, String kitchenTeamId) {

        if (circleId == null) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[circleId(所属的工作圈id)]属性不能为空。");
        }

        if (circleId != null && circleId.length() > 32) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[circleId(所属的工作圈id)]属性超长，最大允许32，实际为" + circleId.length() + "。");
        }

        if (kitchenCircleId == null) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[kitchenCircleId(厨房圈id)]属性不能为空。");
        }

        if (kitchenCircleId != null && kitchenCircleId.length() > 32) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[kitchenCircleId(厨房圈id)]属性超长，最大允许32，实际为" + kitchenCircleId.length() + "。");
        }

        if (deliveFee == null) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[deliveFee(配送费)]属性不能为空。");
        }

        if (kitchenDesc != null && kitchenDesc.length() > 256) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[kitchenDesc(备注)]属性超长，最大允许256，实际为" + kitchenDesc.length() + "。");
        }

        if (kitchenTeamId == null) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[kitchenTeamId(厨房teamid)]属性不能为空。");
        }

        if (kitchenTeamId != null && kitchenTeamId.length() > 32) {
            throw new RuntimeException("[CircleKitchen(工作圈厨房签约)]对象的[kitchenTeamId(厨房teamid)]属性超长，最大允许32，实际为" + kitchenTeamId.length() + "。");
        }
    }

}
