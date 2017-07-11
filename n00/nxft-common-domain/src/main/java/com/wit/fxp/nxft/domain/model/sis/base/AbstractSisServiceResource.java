// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.sis.base;

/**
 * 配餐服务资源工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String sisId 统计id
 * 2. [不可空] String circleId 工作圈id
 * 3. [不可空] String indicatorId 统计指标ID(常量)
 * 4. [不可空] String indicatorName 统计指标名称
 * 5. [不可空] Integer quantity 数量
 * 6. [可空] String dataDesc 备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-sis/java/domain/com/wit/fxp/nxft/domain/model/sis/base/SisServiceResource.html">SisServiceResource代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractSisServiceResource {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String circleId, String indicatorId, String indicatorName, Integer quantity, String dataDesc) {

        if (circleId == null) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[circleId(工作圈id)]属性不能为空。");
        }

        if (circleId != null && circleId.length() > 32) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[circleId(工作圈id)]属性超长，最大允许32，实际为" + circleId.length() + "。");
        }

        if (indicatorId == null) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[indicatorId(统计指标ID(常量))]属性不能为空。");
        }

        if (indicatorId != null && indicatorId.length() > 32) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[indicatorId(统计指标ID(常量))]属性超长，最大允许32，实际为" + indicatorId.length() + "。");
        }

        if (indicatorName == null) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[indicatorName(统计指标名称)]属性不能为空。");
        }

        if (indicatorName != null && indicatorName.length() > 60) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[indicatorName(统计指标名称)]属性超长，最大允许60，实际为" + indicatorName.length() + "。");
        }

        if (quantity == null) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[quantity(数量)]属性不能为空。");
        }

        if (dataDesc != null && dataDesc.length() > 256) {
            throw new RuntimeException("[SisServiceResource(配餐服务资源)]对象的[dataDesc(备注)]属性超长，最大允许256，实际为" + dataDesc.length() + "。");
        }
    }

}
