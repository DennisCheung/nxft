// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.dict.base;

/**
 * 配餐对象补贴标准设置工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String assistanceId 补助id
 * 2. [不可空] String circleId 客户所属的工作圈id
 * 3. [不可空] String subjectTypeId 对象类型ID
 * 4. [不可空] String mealTypeId 餐别类型id
 * 5. [不可空] String assistanceModel 补助模式 RADIO 比例  FEE 金额
 * 6. [可空] Double assistanceRatio 补助比例
 * 7. [可空] Double assistanceFee 补助金额
 * 8. [可空] String assistanceDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-dict/java/domain/com/wit/fxp/nxft/domain/model/dict/base/SubjectAssistance.html">SubjectAssistance代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractSubjectAssistance {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String circleId, String subjectTypeId, String mealTypeId, String assistanceModel, Double assistanceRatio, Double assistanceFee, String assistanceDesc) {

        if (circleId == null) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[circleId(客户所属的工作圈id)]属性不能为空。");
        }

        if (circleId != null && circleId.length() > 32) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[circleId(客户所属的工作圈id)]属性超长，最大允许32，实际为" + circleId.length() + "。");
        }

        if (subjectTypeId == null) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[subjectTypeId(对象类型ID)]属性不能为空。");
        }

        if (subjectTypeId != null && subjectTypeId.length() > 32) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[subjectTypeId(对象类型ID)]属性超长，最大允许32，实际为" + subjectTypeId.length() + "。");
        }

        if (mealTypeId == null) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[mealTypeId(餐别类型id)]属性不能为空。");
        }

        if (mealTypeId != null && mealTypeId.length() > 32) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[mealTypeId(餐别类型id)]属性超长，最大允许32，实际为" + mealTypeId.length() + "。");
        }

        if (assistanceModel == null) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[assistanceModel(补助模式 RADIO 比例  FEE 金额)]属性不能为空。");
        }

        if (assistanceModel != null && assistanceModel.length() > 30) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[assistanceModel(补助模式 RADIO 比例  FEE 金额)]属性超长，最大允许30，实际为" + assistanceModel.length() + "。");
        }

        if (assistanceDesc != null && assistanceDesc.length() > 256) {
            throw new RuntimeException("[SubjectAssistance(配餐对象补贴标准设置)]对象的[assistanceDesc(备注)]属性超长，最大允许256，实际为" + assistanceDesc.length() + "。");
        }
    }

}
