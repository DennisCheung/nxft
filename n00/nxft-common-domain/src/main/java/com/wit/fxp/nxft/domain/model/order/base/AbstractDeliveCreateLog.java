// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.order.base;

/**
 * 配送单生成日志工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String logId 日志id
 * 2. [不可空] java.util.Date mealDate 就餐日期
 * 3. [不可空] String mealTypeId 餐别ID
 * 4. [不可空] java.util.Date createTime 创建时间
 * 5. [可空] String logDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-order/java/domain/com/wit/fxp/nxft/domain/model/order/base/DeliveCreateLog.html">DeliveCreateLog代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractDeliveCreateLog {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(java.util.Date mealDate, String mealTypeId, java.util.Date createTime, String logDesc) {

        if (mealDate == null) {
            throw new RuntimeException("[DeliveCreateLog(配送单生成日志)]对象的[mealDate(就餐日期)]属性不能为空。");
        }

        if (mealTypeId == null) {
            throw new RuntimeException("[DeliveCreateLog(配送单生成日志)]对象的[mealTypeId(餐别ID)]属性不能为空。");
        }

        if (mealTypeId != null && mealTypeId.length() > 32) {
            throw new RuntimeException("[DeliveCreateLog(配送单生成日志)]对象的[mealTypeId(餐别ID)]属性超长，最大允许32，实际为" + mealTypeId.length() + "。");
        }

        if (createTime == null) {
            throw new RuntimeException("[DeliveCreateLog(配送单生成日志)]对象的[createTime(创建时间)]属性不能为空。");
        }

        if (logDesc != null && logDesc.length() > 256) {
            throw new RuntimeException("[DeliveCreateLog(配送单生成日志)]对象的[logDesc(备注)]属性超长，最大允许256，实际为" + logDesc.length() + "。");
        }
    }

}
