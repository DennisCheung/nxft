// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.order.base;

import com.benewit.core.utils.SafeCopier;

/**
 * 配餐订单工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String orderId 订单ID
 * 2. [不可空] String subjectId 对象id
 * 3. [不可空] String subjectName 姓名
 * 4. [不可空] String sexId 性别id
 * 5. [不可空] String sexName 性别name
 * 6. [不可空] String contactPhone 联系电话
 * 7. [不可空] String regionId 行政区域ID
 * 8. [不可空] String regionName 行政区域名称
 * 9. [可空] String address 详细地址
 * 10. [不可空] String subjectTypeId 对象类型id
 * 11. [不可空] String subjectTypeName 对象类型名称
 * 11.1. [可空] String lunchBoxNo 饭盒编号
 * 12. [可空] String subjectDesc 对象备注
 * 13. [不可空] String circleId 客户所属的工作圈id
 * 14. [不可空] String deliveType 配送方式  助餐点 SITE  到户上门  HOME
 * 15. [不可空] String deliveSiteId 配送地点id
 * 16. [不可空] String deliveSiteName 配送地点名称 当 fdelive_type = HOME 填 faddress
 * 16.1. [不可空] String deliveAddr 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name
 * 17. [不可空] Double deliveFee 配送费
 * 18. [不可空] String kitchenCircleId 厨房圈id
 * 19. [不可空] String kitchenTeamId 厨房teamid
 * 20. [不可空] java.util.Date mealDate 就餐日期
 * 21. [不可空] Integer week 周几
 * 22. [不可空] String mealTypeId 餐别ID
 * 23. [不可空] String mealTypeName 餐别名称
 * 24. [不可空] String mealId 套餐id
 * 25. [不可空] String mealCode 套餐CODE
 * 26. [不可空] String mealName 套餐名称
 * 26.1. [可空] String mealContent 套餐内容
 * 27. [不可空] Double mealPrice 单价
 * 28. [可空] String scheduleDesc 备注
 * 29. [不可空] Integer quantity 数量
 * 30. [不可空] Double sumTotal 金额
 * 31. [不可空] Double sumPayment 个人自付金额
 * 32. [不可空] Double sumReceivable 应收金额
 * 33. [可空] String deliveNoteId 配送单id
 * 34. [不可空] java.util.Date createTime 创建时间
 * 37. [不可空] String createUserId 创建操作员id
 * 38. [不可空] String createUserName 创建操作员姓名
 * 38.1. [不可空] String createWay 订餐方式  坐席  助餐点
 * 39. [不可空] String lastState 最后状态，完成时ID
 * 40. [不可空] java.util.Date lastTime 最新完成时间
 * 41. [不可空] String lastUserId 最新完成操作员id
 * 42. [不可空] String lastNickname 最新完成操作员name
 * 43. [可空] String lastDesc 流程备注，如为退单，填退单原因。
 * 44. [可空] String nextNodeId 下一环节 常量，和环节状态、备注同时更新
 * 45. [可空] String nextNodeContent 下一环节工作内容
 * 46. [不可空] Boolean isComplete 是否已完成？  Y/N
 * 47. [可空] String completeState 完成状态  SUCCESS  成功  FAIL 失败（取消）
 * 48. [可空] String failReasonName 失败原因名称  常量  客户取消
 * 49. [可空] java.util.Date completeTime 完成时间
 * 50. [可空] String completeUserId 完成操作员工号id
 * 51. [可空] String completeNickname 完成操作员姓名
 * 52. [可空] String completeDesc 完成备注
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-order/java/domain/com/wit/fxp/nxft/domain/model/order/base/NxftOrder.html">NxftOrder代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractNxftOrder {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String deliveNoteId, _SubjectInfo subjectInfo, _MealInfo mealInfo, _SettleInfo settleInfo, _CreateInfo createInfo, _LastState lastState, _NextNode nextNode, _CompleteInfo completeInfo) {

        if (deliveNoteId != null && deliveNoteId.length() > 32) {
            throw new RuntimeException("[NxftOrder(配餐订单)]对象的[deliveNoteId(配送单id)]属性超长，最大允许32，实际为" + deliveNoteId.length() + "。");
        }

        if (subjectInfo != null) {
            checkComponentProperties("NxftOrder#subjectInfo", subjectInfo);
        }

        if (mealInfo != null) {
            checkComponentProperties("NxftOrder#mealInfo", mealInfo);
        }

        if (settleInfo != null) {
            checkComponentProperties("NxftOrder#settleInfo", settleInfo);
        }

        if (createInfo != null) {
            checkComponentProperties("NxftOrder#createInfo", createInfo);
        }

        if (lastState != null) {
            checkComponentProperties("NxftOrder#lastState", lastState);
        }

        if (nextNode != null) {
            checkComponentProperties("NxftOrder#nextNode", nextNode);
        }

        if (completeInfo != null) {
            checkComponentProperties("NxftOrder#completeInfo", completeInfo);
        }
    }

    /**
     * 检查[对象信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param subjectInfo 对象信息
     */
    private static void checkComponentProperties(String compPropertyName, _SubjectInfo subjectInfo) {

        if (subjectInfo.getSubjectId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectId(对象id)]属性不能为空。");
        }

        if (subjectInfo.getSubjectId() != null && subjectInfo.getSubjectId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectId(对象id)]属性超长，最大允许32，实际为" + subjectInfo.getSubjectId().length() + "。");
        }

        if (subjectInfo.getSubjectName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectName(姓名)]属性不能为空。");
        }

        if (subjectInfo.getSubjectName() != null && subjectInfo.getSubjectName().length() > 80) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectName(姓名)]属性超长，最大允许80，实际为" + subjectInfo.getSubjectName().length() + "。");
        }

        if (subjectInfo.getSexId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexId(性别id)]属性不能为空。");
        }

        if (subjectInfo.getSexId() != null && subjectInfo.getSexId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexId(性别id)]属性超长，最大允许32，实际为" + subjectInfo.getSexId().length() + "。");
        }

        if (subjectInfo.getSexName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexName(性别name)]属性不能为空。");
        }

        if (subjectInfo.getSexName() != null && subjectInfo.getSexName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sexName(性别name)]属性超长，最大允许30，实际为" + subjectInfo.getSexName().length() + "。");
        }

        if (subjectInfo.getContactPhone() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[contactPhone(联系电话)]属性不能为空。");
        }

        if (subjectInfo.getContactPhone() != null && subjectInfo.getContactPhone().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[contactPhone(联系电话)]属性超长，最大允许30，实际为" + subjectInfo.getContactPhone().length() + "。");
        }

        if (subjectInfo.getRegionId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[regionId(行政区域ID)]属性不能为空。");
        }

        if (subjectInfo.getRegionId() != null && subjectInfo.getRegionId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[regionId(行政区域ID)]属性超长，最大允许32，实际为" + subjectInfo.getRegionId().length() + "。");
        }

        if (subjectInfo.getRegionName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[regionName(行政区域名称)]属性不能为空。");
        }

        if (subjectInfo.getRegionName() != null && subjectInfo.getRegionName().length() > 80) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[regionName(行政区域名称)]属性超长，最大允许80，实际为" + subjectInfo.getRegionName().length() + "。");
        }

        if (subjectInfo.getAddress() != null && subjectInfo.getAddress().length() > 200) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[address(详细地址)]属性超长，最大允许200，实际为" + subjectInfo.getAddress().length() + "。");
        }

        if (subjectInfo.getSubjectTypeId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeId(对象类型id)]属性不能为空。");
        }

        if (subjectInfo.getSubjectTypeId() != null && subjectInfo.getSubjectTypeId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeId(对象类型id)]属性超长，最大允许32，实际为" + subjectInfo.getSubjectTypeId().length() + "。");
        }

        if (subjectInfo.getSubjectTypeName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeName(对象类型名称)]属性不能为空。");
        }

        if (subjectInfo.getSubjectTypeName() != null && subjectInfo.getSubjectTypeName().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectTypeName(对象类型名称)]属性超长，最大允许30，实际为" + subjectInfo.getSubjectTypeName().length() + "。");
        }

        if (subjectInfo.getSubjectDesc() != null && subjectInfo.getSubjectDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[subjectDesc(对象备注)]属性超长，最大允许256，实际为" + subjectInfo.getSubjectDesc().length() + "。");
        }

        if (subjectInfo.getCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[circleId(客户所属的工作圈id)]属性不能为空。");
        }

        if (subjectInfo.getCircleId() != null && subjectInfo.getCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[circleId(客户所属的工作圈id)]属性超长，最大允许32，实际为" + subjectInfo.getCircleId().length() + "。");
        }

        if (subjectInfo.getDeliveType() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveType(配送方式  助餐点 SITE  到户上门  HOME)]属性不能为空。");
        }

        if (subjectInfo.getDeliveType() != null && subjectInfo.getDeliveType().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveType(配送方式  助餐点 SITE  到户上门  HOME)]属性超长，最大允许30，实际为" + subjectInfo.getDeliveType().length() + "。");
        }

        if (subjectInfo.getDeliveSiteId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteId(配送地点id)]属性不能为空。");
        }

        if (subjectInfo.getDeliveSiteId() != null && subjectInfo.getDeliveSiteId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteId(配送地点id)]属性超长，最大允许32，实际为" + subjectInfo.getDeliveSiteId().length() + "。");
        }

        if (subjectInfo.getDeliveSiteName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteName(配送地点名称 当 fdelive_type = HOME 填 faddress)]属性不能为空。");
        }

        if (subjectInfo.getDeliveSiteName() != null && subjectInfo.getDeliveSiteName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveSiteName(配送地点名称 当 fdelive_type = HOME 填 faddress)]属性超长，最大允许40，实际为" + subjectInfo.getDeliveSiteName().length() + "。");
        }

        if (subjectInfo.getDeliveAddr() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveAddr(配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name)]属性不能为空。");
        }

        if (subjectInfo.getDeliveAddr() != null && subjectInfo.getDeliveAddr().length() > 100) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveAddr(配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name)]属性超长，最大允许100，实际为" + subjectInfo.getDeliveAddr().length() + "。");
        }

        if (subjectInfo.getLunchBoxNo() != null && subjectInfo.getLunchBoxNo().length() > 20) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lunchBoxNo(饭盒编号)]属性超长，最大允许20，实际为" + subjectInfo.getLunchBoxNo().length() + "。");
        }
    }

    /**
     * 检查[菜谱信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param mealInfo 菜谱信息
     */
    private static void checkComponentProperties(String compPropertyName, _MealInfo mealInfo) {

        if (mealInfo.getKitchenCircleId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenCircleId(厨房圈id)]属性不能为空。");
        }

        if (mealInfo.getKitchenCircleId() != null && mealInfo.getKitchenCircleId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenCircleId(厨房圈id)]属性超长，最大允许32，实际为" + mealInfo.getKitchenCircleId().length() + "。");
        }

        if (mealInfo.getKitchenTeamId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenTeamId(厨房teamid)]属性不能为空。");
        }

        if (mealInfo.getKitchenTeamId() != null && mealInfo.getKitchenTeamId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[kitchenTeamId(厨房teamid)]属性超长，最大允许32，实际为" + mealInfo.getKitchenTeamId().length() + "。");
        }

        if (mealInfo.getMealDate() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealDate(就餐日期)]属性不能为空。");
        }

        if (mealInfo.getWeek() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[week(周几)]属性不能为空。");
        }

        if (mealInfo.getMealTypeId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeId(餐别ID)]属性不能为空。");
        }

        if (mealInfo.getMealTypeId() != null && mealInfo.getMealTypeId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeId(餐别ID)]属性超长，最大允许32，实际为" + mealInfo.getMealTypeId().length() + "。");
        }

        if (mealInfo.getMealTypeName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeName(餐别名称)]属性不能为空。");
        }

        if (mealInfo.getMealTypeName() != null && mealInfo.getMealTypeName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealTypeName(餐别名称)]属性超长，最大允许40，实际为" + mealInfo.getMealTypeName().length() + "。");
        }

        if (mealInfo.getMealId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealId(套餐id)]属性不能为空。");
        }

        if (mealInfo.getMealId() != null && mealInfo.getMealId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealId(套餐id)]属性超长，最大允许32，实际为" + mealInfo.getMealId().length() + "。");
        }

        if (mealInfo.getMealCode() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealCode(套餐CODE)]属性不能为空。");
        }

        if (mealInfo.getMealCode() != null && mealInfo.getMealCode().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealCode(套餐CODE)]属性超长，最大允许30，实际为" + mealInfo.getMealCode().length() + "。");
        }

        if (mealInfo.getMealName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealName(套餐名称)]属性不能为空。");
        }

        if (mealInfo.getMealName() != null && mealInfo.getMealName().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealName(套餐名称)]属性超长，最大允许40，实际为" + mealInfo.getMealName().length() + "。");
        }

        if (mealInfo.getMealPrice() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealPrice(单价)]属性不能为空。");
        }

        if (mealInfo.getScheduleDesc() != null && mealInfo.getScheduleDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[scheduleDesc(备注)]属性超长，最大允许256，实际为" + mealInfo.getScheduleDesc().length() + "。");
        }

        if (mealInfo.getMealContent() != null && mealInfo.getMealContent().length() > 60) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[mealContent(套餐内容)]属性超长，最大允许60，实际为" + mealInfo.getMealContent().length() + "。");
        }
    }

    /**
     * 检查[结算信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param settleInfo 结算信息
     */
    private static void checkComponentProperties(String compPropertyName, _SettleInfo settleInfo) {

        if (settleInfo.getQuantity() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[quantity(数量)]属性不能为空。");
        }

        if (settleInfo.getDeliveFee() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[deliveFee(配送费)]属性不能为空。");
        }

        if (settleInfo.getSumTotal() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sumTotal(金额)]属性不能为空。");
        }

        if (settleInfo.getSumPayment() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sumPayment(个人自付金额)]属性不能为空。");
        }

        if (settleInfo.getSumReceivable() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[sumReceivable(应收金额)]属性不能为空。");
        }
    }

    /**
     * 检查[创建信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param createInfo 创建信息
     */
    private static void checkComponentProperties(String compPropertyName, _CreateInfo createInfo) {

        if (createInfo.getCreateTime() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createTime(创建时间)]属性不能为空。");
        }

        if (createInfo.getCreateUserId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建操作员id)]属性不能为空。");
        }

        if (createInfo.getCreateUserId() != null && createInfo.getCreateUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserId(创建操作员id)]属性超长，最大允许32，实际为" + createInfo.getCreateUserId().length() + "。");
        }

        if (createInfo.getCreateUserName() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserName(创建操作员姓名)]属性不能为空。");
        }

        if (createInfo.getCreateUserName() != null && createInfo.getCreateUserName().length() > 50) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createUserName(创建操作员姓名)]属性超长，最大允许50，实际为" + createInfo.getCreateUserName().length() + "。");
        }

        if (createInfo.getCreateWay() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createWay(订餐方式  坐席  助餐点)]属性不能为空。");
        }

        if (createInfo.getCreateWay() != null && createInfo.getCreateWay().length() > 20) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[createWay(订餐方式  坐席  助餐点)]属性超长，最大允许20，实际为" + createInfo.getCreateWay().length() + "。");
        }
    }

    /**
     * 检查[上次状态]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param lastState 上次状态
     */
    private static void checkComponentProperties(String compPropertyName, _LastState lastState) {

        if (lastState.getLastState() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastState(最后状态，完成时ID)]属性不能为空。");
        }

        if (lastState.getLastState() != null && lastState.getLastState().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastState(最后状态，完成时ID)]属性超长，最大允许30，实际为" + lastState.getLastState().length() + "。");
        }

        if (lastState.getLastTime() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastTime(最新完成时间)]属性不能为空。");
        }

        if (lastState.getLastUserId() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastUserId(最新完成操作员id)]属性不能为空。");
        }

        if (lastState.getLastUserId() != null && lastState.getLastUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastUserId(最新完成操作员id)]属性超长，最大允许32，实际为" + lastState.getLastUserId().length() + "。");
        }

        if (lastState.getLastNickname() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastNickname(最新完成操作员name)]属性不能为空。");
        }

        if (lastState.getLastNickname() != null && lastState.getLastNickname().length() > 40) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastNickname(最新完成操作员name)]属性超长，最大允许40，实际为" + lastState.getLastNickname().length() + "。");
        }

        if (lastState.getLastDesc() != null && lastState.getLastDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[lastDesc(流程备注，如为退单，填退单原因。)]属性超长，最大允许256，实际为" + lastState.getLastDesc().length() + "。");
        }
    }

    /**
     * 检查[下一环节]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param nextNode 下一环节
     */
    private static void checkComponentProperties(String compPropertyName, _NextNode nextNode) {

        if (nextNode.getNextNodeId() != null && nextNode.getNextNodeId().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[nextNodeId(下一环节 常量，和环节状态、备注同时更新)]属性超长，最大允许30，实际为" + nextNode.getNextNodeId().length() + "。");
        }

        if (nextNode.getNextNodeContent() != null && nextNode.getNextNodeContent().length() > 300) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[nextNodeContent(下一环节工作内容)]属性超长，最大允许300，实际为" + nextNode.getNextNodeContent().length() + "。");
        }
    }

    /**
     * 检查[完成信息]组件里的字段长度和非空限制。
     *
     * @param compPropertyName 组件在实体中的属性全名
     * @param completeInfo 完成信息
     */
    private static void checkComponentProperties(String compPropertyName, _CompleteInfo completeInfo) {

        if (completeInfo.getIsComplete() == null) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[isComplete(是否已完成？  Y/N)]属性不能为空。");
        }

        if (completeInfo.getCompleteState() != null && completeInfo.getCompleteState().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeState(完成状态  SUCCESS  成功  FAIL 失败（取消）)]属性超长，最大允许30，实际为" + completeInfo.getCompleteState().length() + "。");
        }

        if (completeInfo.getFailReasonName() != null && completeInfo.getFailReasonName().length() > 50) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[failReasonName(失败原因名称  常量  客户取消)]属性超长，最大允许50，实际为" + completeInfo.getFailReasonName().length() + "。");
        }

        if (completeInfo.getCompleteUserId() != null && completeInfo.getCompleteUserId().length() > 32) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeUserId(完成操作员工号id)]属性超长，最大允许32，实际为" + completeInfo.getCompleteUserId().length() + "。");
        }

        if (completeInfo.getCompleteNickname() != null && completeInfo.getCompleteNickname().length() > 30) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeNickname(完成操作员姓名)]属性超长，最大允许30，实际为" + completeInfo.getCompleteNickname().length() + "。");
        }

        if (completeInfo.getCompleteDesc() != null && completeInfo.getCompleteDesc().length() > 256) {
            throw new RuntimeException("[" + compPropertyName + "]组件的[completeDesc(完成备注)]属性超长，最大允许256，实际为" + completeInfo.getCompleteDesc().length() + "。");
        }
    }

    // ---------- _SubjectInfo组件定义
    /**
     * [组件类] 对象信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _SubjectInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 对象id */
        protected final String subjectId;

        /** [不可空] 姓名 */
        protected final String subjectName;

        /** [不可空] 性别id */
        protected final String sexId;

        /** [不可空] 性别name */
        protected final String sexName;

        /** [不可空] 联系电话 */
        protected final String contactPhone;

        /** [不可空] 行政区域ID */
        protected final String regionId;

        /** [不可空] 行政区域名称 */
        protected final String regionName;

        /** [可空] 详细地址 */
        protected final String address;

        /** [不可空] 对象类型id */
        protected final String subjectTypeId;

        /** [不可空] 对象类型名称 */
        protected final String subjectTypeName;

        /** [可空] 对象备注 */
        protected final String subjectDesc;

        /** [不可空] 客户所属的工作圈id */
        protected final String circleId;

        /** [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        protected final String deliveType;

        /** [不可空] 配送地点id */
        protected final String deliveSiteId;

        /** [不可空] 配送地点名称 当 fdelive_type = HOME 填 faddress */
        protected final String deliveSiteName;

        /** [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        protected final String deliveAddr;

        /** [可空] 饭盒编号 */
        protected final String lunchBoxNo;

        // _SubjectInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _SubjectInfo() {
            subjectId = null;
            subjectName = null;
            sexId = null;
            sexName = null;
            contactPhone = null;
            regionId = null;
            regionName = null;
            address = null;
            subjectTypeId = null;
            subjectTypeName = null;
            subjectDesc = null;
            circleId = null;
            deliveType = null;
            deliveSiteId = null;
            deliveSiteName = null;
            deliveAddr = null;
            lunchBoxNo = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _SubjectInfo(_SubjectInfo copy) {
            this( copy.subjectId, copy.subjectName, copy.sexId, copy.sexName, copy.contactPhone, copy.regionId, copy.regionName, copy.address, copy.subjectTypeId, copy.subjectTypeName, copy.subjectDesc, copy.circleId, copy.deliveType, copy.deliveSiteId, copy.deliveSiteName, copy.deliveAddr, copy.lunchBoxNo);
        }

        /**
         * 完整构造函数。
         *
         * @param subjectId [不可空] 对象id
         * @param subjectName [不可空] 姓名
         * @param sexId [不可空] 性别id
         * @param sexName [不可空] 性别name
         * @param contactPhone [不可空] 联系电话
         * @param regionId [不可空] 行政区域ID
         * @param regionName [不可空] 行政区域名称
         * @param address [可空] 详细地址
         * @param subjectTypeId [不可空] 对象类型id
         * @param subjectTypeName [不可空] 对象类型名称
         * @param subjectDesc [可空] 对象备注
         * @param circleId [不可空] 客户所属的工作圈id
         * @param deliveType [不可空] 配送方式  助餐点 SITE  到户上门  HOME
         * @param deliveSiteId [不可空] 配送地点id
         * @param deliveSiteName [不可空] 配送地点名称 当 fdelive_type = HOME 填 faddress
         * @param deliveAddr [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name
         * @param lunchBoxNo [可空] 饭盒编号
         */
        protected _SubjectInfo(String subjectId, String subjectName, String sexId, String sexName, String contactPhone, String regionId, String regionName, String address, String subjectTypeId, String subjectTypeName, String subjectDesc, String circleId, String deliveType, String deliveSiteId, String deliveSiteName, String deliveAddr, String lunchBoxNo) {
            this.subjectId = SafeCopier.copy(subjectId);
            this.subjectName = SafeCopier.copy(subjectName);
            this.sexId = SafeCopier.copy(sexId);
            this.sexName = SafeCopier.copy(sexName);
            this.contactPhone = SafeCopier.copy(contactPhone);
            this.regionId = SafeCopier.copy(regionId);
            this.regionName = SafeCopier.copy(regionName);
            this.address = SafeCopier.copy(address);
            this.subjectTypeId = SafeCopier.copy(subjectTypeId);
            this.subjectTypeName = SafeCopier.copy(subjectTypeName);
            this.subjectDesc = SafeCopier.copy(subjectDesc);
            this.circleId = SafeCopier.copy(circleId);
            this.deliveType = SafeCopier.copy(deliveType);
            this.deliveSiteId = SafeCopier.copy(deliveSiteId);
            this.deliveSiteName = SafeCopier.copy(deliveSiteName);
            this.deliveAddr = SafeCopier.copy(deliveAddr);
            this.lunchBoxNo = SafeCopier.copy(lunchBoxNo);
        }


        // _SubjectInfo属性的getter/setter


        /** @return [不可空] 对象id */
        public String getSubjectId() {
            return SafeCopier.copy(subjectId);
        }

        /** @return [不可空] 姓名 */
        public String getSubjectName() {
            return SafeCopier.copy(subjectName);
        }

        /** @return [不可空] 性别id */
        public String getSexId() {
            return SafeCopier.copy(sexId);
        }

        /** @return [不可空] 性别name */
        public String getSexName() {
            return SafeCopier.copy(sexName);
        }

        /** @return [不可空] 联系电话 */
        public String getContactPhone() {
            return SafeCopier.copy(contactPhone);
        }

        /** @return [不可空] 行政区域ID */
        public String getRegionId() {
            return SafeCopier.copy(regionId);
        }

        /** @return [不可空] 行政区域名称 */
        public String getRegionName() {
            return SafeCopier.copy(regionName);
        }

        /** @return [可空] 详细地址 */
        public String getAddress() {
            return SafeCopier.copy(address);
        }

        /** @return [不可空] 对象类型id */
        public String getSubjectTypeId() {
            return SafeCopier.copy(subjectTypeId);
        }

        /** @return [不可空] 对象类型名称 */
        public String getSubjectTypeName() {
            return SafeCopier.copy(subjectTypeName);
        }

        /** @return [可空] 对象备注 */
        public String getSubjectDesc() {
            return SafeCopier.copy(subjectDesc);
        }

        /** @return [不可空] 客户所属的工作圈id */
        public String getCircleId() {
            return SafeCopier.copy(circleId);
        }

        /** @return [不可空] 配送方式  助餐点 SITE  到户上门  HOME */
        public String getDeliveType() {
            return SafeCopier.copy(deliveType);
        }

        /** @return [不可空] 配送地点id */
        public String getDeliveSiteId() {
            return SafeCopier.copy(deliveSiteId);
        }

        /** @return [不可空] 配送地点名称 当 fdelive_type = HOME 填 faddress */
        public String getDeliveSiteName() {
            return SafeCopier.copy(deliveSiteName);
        }

        /** @return [不可空] 配送地址  当 fdelive_type = HOME 填 faddress  = SITE 填 fdelive_site_name */
        public String getDeliveAddr() {
            return SafeCopier.copy(deliveAddr);
        }

        /** @return [可空] 饭盒编号 */
        public String getLunchBoxNo() {
            return SafeCopier.copy(lunchBoxNo);
        }

        // _SubjectInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(subjectId);
            builder.append(subjectName);
            builder.append(sexId);
            builder.append(sexName);
            builder.append(contactPhone);
            builder.append(regionId);
            builder.append(regionName);
            builder.append(address);
            builder.append(subjectTypeId);
            builder.append(subjectTypeName);
            builder.append(subjectDesc);
            builder.append(circleId);
            builder.append(deliveType);
            builder.append(deliveSiteId);
            builder.append(deliveSiteName);
            builder.append(deliveAddr);
            builder.append(lunchBoxNo);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _SubjectInfo other = (_SubjectInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(subjectId, other.subjectId);
            builder.append(subjectName, other.subjectName);
            builder.append(sexId, other.sexId);
            builder.append(sexName, other.sexName);
            builder.append(contactPhone, other.contactPhone);
            builder.append(regionId, other.regionId);
            builder.append(regionName, other.regionName);
            builder.append(address, other.address);
            builder.append(subjectTypeId, other.subjectTypeId);
            builder.append(subjectTypeName, other.subjectTypeName);
            builder.append(subjectDesc, other.subjectDesc);
            builder.append(circleId, other.circleId);
            builder.append(deliveType, other.deliveType);
            builder.append(deliveSiteId, other.deliveSiteId);
            builder.append(deliveSiteName, other.deliveSiteName);
            builder.append(deliveAddr, other.deliveAddr);
            builder.append(lunchBoxNo, other.lunchBoxNo);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("subjectId", subjectId);
            builder.append("subjectName", subjectName);
            builder.append("sexId", sexId);
            builder.append("sexName", sexName);
            builder.append("contactPhone", contactPhone);
            builder.append("regionId", regionId);
            builder.append("regionName", regionName);
            builder.append("address", address);
            builder.append("subjectTypeId", subjectTypeId);
            builder.append("subjectTypeName", subjectTypeName);
            builder.append("subjectDesc", subjectDesc);
            builder.append("circleId", circleId);
            builder.append("deliveType", deliveType);
            builder.append("deliveSiteId", deliveSiteId);
            builder.append("deliveSiteName", deliveSiteName);
            builder.append("deliveAddr", deliveAddr);
            builder.append("lunchBoxNo", lunchBoxNo);
            return builder.toString();
        }

    }    // _SubjectInfo

    // ---------- _MealInfo组件定义
    /**
     * [组件类] 菜谱信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _MealInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 厨房圈id */
        protected final String kitchenCircleId;

        /** [不可空] 厨房teamid */
        protected final String kitchenTeamId;

        /** [不可空] 就餐日期 */
        protected final java.util.Date mealDate;

        /** [不可空] 周几 */
        protected final Integer week;

        /** [不可空] 餐别ID */
        protected final String mealTypeId;

        /** [不可空] 餐别名称 */
        protected final String mealTypeName;

        /** [不可空] 套餐id */
        protected final String mealId;

        /** [不可空] 套餐CODE */
        protected final String mealCode;

        /** [不可空] 套餐名称 */
        protected final String mealName;

        /** [不可空] 单价 */
        protected final Double mealPrice;

        /** [可空] 备注 */
        protected final String scheduleDesc;

        /** [可空] 套餐内容 */
        protected final String mealContent;

        // _MealInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _MealInfo() {
            kitchenCircleId = null;
            kitchenTeamId = null;
            mealDate = null;
            week = null;
            mealTypeId = null;
            mealTypeName = null;
            mealId = null;
            mealCode = null;
            mealName = null;
            mealPrice = null;
            scheduleDesc = null;
            mealContent = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _MealInfo(_MealInfo copy) {
            this( copy.kitchenCircleId, copy.kitchenTeamId, copy.mealDate, copy.week, copy.mealTypeId, copy.mealTypeName, copy.mealId, copy.mealCode, copy.mealName, copy.mealPrice, copy.scheduleDesc, copy.mealContent);
        }

        /**
         * 完整构造函数。
         *
         * @param kitchenCircleId [不可空] 厨房圈id
         * @param kitchenTeamId [不可空] 厨房teamid
         * @param mealDate [不可空] 就餐日期
         * @param week [不可空] 周几
         * @param mealTypeId [不可空] 餐别ID
         * @param mealTypeName [不可空] 餐别名称
         * @param mealId [不可空] 套餐id
         * @param mealCode [不可空] 套餐CODE
         * @param mealName [不可空] 套餐名称
         * @param mealPrice [不可空] 单价
         * @param scheduleDesc [可空] 备注
         * @param mealContent [可空] 套餐内容
         */
        protected _MealInfo(String kitchenCircleId, String kitchenTeamId, java.util.Date mealDate, Integer week, String mealTypeId, String mealTypeName, String mealId, String mealCode, String mealName, Double mealPrice, String scheduleDesc, String mealContent) {
            this.kitchenCircleId = SafeCopier.copy(kitchenCircleId);
            this.kitchenTeamId = SafeCopier.copy(kitchenTeamId);
            this.mealDate = SafeCopier.copy(mealDate);
            this.week = SafeCopier.copy(week);
            this.mealTypeId = SafeCopier.copy(mealTypeId);
            this.mealTypeName = SafeCopier.copy(mealTypeName);
            this.mealId = SafeCopier.copy(mealId);
            this.mealCode = SafeCopier.copy(mealCode);
            this.mealName = SafeCopier.copy(mealName);
            this.mealPrice = SafeCopier.copy(mealPrice);
            this.scheduleDesc = SafeCopier.copy(scheduleDesc);
            this.mealContent = SafeCopier.copy(mealContent);
        }


        // _MealInfo属性的getter/setter


        /** @return [不可空] 厨房圈id */
        public String getKitchenCircleId() {
            return SafeCopier.copy(kitchenCircleId);
        }

        /** @return [不可空] 厨房teamid */
        public String getKitchenTeamId() {
            return SafeCopier.copy(kitchenTeamId);
        }

        /** @return [不可空] 就餐日期 */
        public java.util.Date getMealDate() {
            return SafeCopier.copy(mealDate);
        }

        /** @return [不可空] 周几 */
        public Integer getWeek() {
            return SafeCopier.copy(week);
        }

        /** @return [不可空] 餐别ID */
        public String getMealTypeId() {
            return SafeCopier.copy(mealTypeId);
        }

        /** @return [不可空] 餐别名称 */
        public String getMealTypeName() {
            return SafeCopier.copy(mealTypeName);
        }

        /** @return [不可空] 套餐id */
        public String getMealId() {
            return SafeCopier.copy(mealId);
        }

        /** @return [不可空] 套餐CODE */
        public String getMealCode() {
            return SafeCopier.copy(mealCode);
        }

        /** @return [不可空] 套餐名称 */
        public String getMealName() {
            return SafeCopier.copy(mealName);
        }

        /** @return [不可空] 单价 */
        public Double getMealPrice() {
            return SafeCopier.copy(mealPrice);
        }

        /** @return [可空] 备注 */
        public String getScheduleDesc() {
            return SafeCopier.copy(scheduleDesc);
        }

        /** @return [可空] 套餐内容 */
        public String getMealContent() {
            return SafeCopier.copy(mealContent);
        }

        // _MealInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(kitchenCircleId);
            builder.append(kitchenTeamId);
            builder.append(mealDate);
            builder.append(week);
            builder.append(mealTypeId);
            builder.append(mealTypeName);
            builder.append(mealId);
            builder.append(mealCode);
            builder.append(mealName);
            builder.append(mealPrice);
            builder.append(scheduleDesc);
            builder.append(mealContent);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _MealInfo other = (_MealInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(kitchenCircleId, other.kitchenCircleId);
            builder.append(kitchenTeamId, other.kitchenTeamId);
            builder.append(mealDate, other.mealDate);
            builder.append(week, other.week);
            builder.append(mealTypeId, other.mealTypeId);
            builder.append(mealTypeName, other.mealTypeName);
            builder.append(mealId, other.mealId);
            builder.append(mealCode, other.mealCode);
            builder.append(mealName, other.mealName);
            builder.append(mealPrice, other.mealPrice);
            builder.append(scheduleDesc, other.scheduleDesc);
            builder.append(mealContent, other.mealContent);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("kitchenCircleId", kitchenCircleId);
            builder.append("kitchenTeamId", kitchenTeamId);
            builder.append("mealDate", mealDate);
            builder.append("week", week);
            builder.append("mealTypeId", mealTypeId);
            builder.append("mealTypeName", mealTypeName);
            builder.append("mealId", mealId);
            builder.append("mealCode", mealCode);
            builder.append("mealName", mealName);
            builder.append("mealPrice", mealPrice);
            builder.append("scheduleDesc", scheduleDesc);
            builder.append("mealContent", mealContent);
            return builder.toString();
        }

    }    // _MealInfo

    // ---------- _SettleInfo组件定义
    /**
     * [组件类] 结算信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _SettleInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 数量 */
        protected final Integer quantity;

        /** [不可空] 配送费 */
        protected final Double deliveFee;

        /** [不可空] 金额 */
        protected final Double sumTotal;

        /** [不可空] 个人自付金额 */
        protected final Double sumPayment;

        /** [不可空] 应收金额 */
        protected final Double sumReceivable;

        // _SettleInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _SettleInfo() {
            quantity = null;
            deliveFee = null;
            sumTotal = null;
            sumPayment = null;
            sumReceivable = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _SettleInfo(_SettleInfo copy) {
            this( copy.quantity, copy.deliveFee, copy.sumTotal, copy.sumPayment, copy.sumReceivable);
        }

        /**
         * 完整构造函数。
         *
         * @param quantity [不可空] 数量
         * @param deliveFee [不可空] 配送费
         * @param sumTotal [不可空] 金额
         * @param sumPayment [不可空] 个人自付金额
         * @param sumReceivable [不可空] 应收金额
         */
        protected _SettleInfo(Integer quantity, Double deliveFee, Double sumTotal, Double sumPayment, Double sumReceivable) {
            this.quantity = SafeCopier.copy(quantity);
            this.deliveFee = SafeCopier.copy(deliveFee);
            this.sumTotal = SafeCopier.copy(sumTotal);
            this.sumPayment = SafeCopier.copy(sumPayment);
            this.sumReceivable = SafeCopier.copy(sumReceivable);
        }


        // _SettleInfo属性的getter/setter


        /** @return [不可空] 数量 */
        public Integer getQuantity() {
            return SafeCopier.copy(quantity);
        }

        /** @return [不可空] 配送费 */
        public Double getDeliveFee() {
            return SafeCopier.copy(deliveFee);
        }

        /** @return [不可空] 金额 */
        public Double getSumTotal() {
            return SafeCopier.copy(sumTotal);
        }

        /** @return [不可空] 个人自付金额 */
        public Double getSumPayment() {
            return SafeCopier.copy(sumPayment);
        }

        /** @return [不可空] 应收金额 */
        public Double getSumReceivable() {
            return SafeCopier.copy(sumReceivable);
        }

        // _SettleInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(quantity);
            builder.append(deliveFee);
            builder.append(sumTotal);
            builder.append(sumPayment);
            builder.append(sumReceivable);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _SettleInfo other = (_SettleInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(quantity, other.quantity);
            builder.append(deliveFee, other.deliveFee);
            builder.append(sumTotal, other.sumTotal);
            builder.append(sumPayment, other.sumPayment);
            builder.append(sumReceivable, other.sumReceivable);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("quantity", quantity);
            builder.append("deliveFee", deliveFee);
            builder.append("sumTotal", sumTotal);
            builder.append("sumPayment", sumPayment);
            builder.append("sumReceivable", sumReceivable);
            return builder.toString();
        }

    }    // _SettleInfo

    // ---------- _CreateInfo组件定义
    /**
     * [组件类] 创建信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CreateInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 创建时间 */
        protected final java.util.Date createTime;

        /** [不可空] 创建操作员id */
        protected final String createUserId;

        /** [不可空] 创建操作员姓名 */
        protected final String createUserName;

        /** [不可空] 订餐方式  坐席  助餐点 */
        protected final String createWay;

        // _CreateInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CreateInfo() {
            createTime = null;
            createUserId = null;
            createUserName = null;
            createWay = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CreateInfo(_CreateInfo copy) {
            this( copy.createTime, copy.createUserId, copy.createUserName, copy.createWay);
        }

        /**
         * 完整构造函数。
         *
         * @param createTime [不可空] 创建时间
         * @param createUserId [不可空] 创建操作员id
         * @param createUserName [不可空] 创建操作员姓名
         * @param createWay [不可空] 订餐方式  坐席  助餐点
         */
        protected _CreateInfo(java.util.Date createTime, String createUserId, String createUserName, String createWay) {
            this.createTime = SafeCopier.copy(createTime);
            this.createUserId = SafeCopier.copy(createUserId);
            this.createUserName = SafeCopier.copy(createUserName);
            this.createWay = SafeCopier.copy(createWay);
        }


        // _CreateInfo属性的getter/setter


        /** @return [不可空] 创建时间 */
        public java.util.Date getCreateTime() {
            return SafeCopier.copy(createTime);
        }

        /** @return [不可空] 创建操作员id */
        public String getCreateUserId() {
            return SafeCopier.copy(createUserId);
        }

        /** @return [不可空] 创建操作员姓名 */
        public String getCreateUserName() {
            return SafeCopier.copy(createUserName);
        }

        /** @return [不可空] 订餐方式  坐席  助餐点 */
        public String getCreateWay() {
            return SafeCopier.copy(createWay);
        }

        // _CreateInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(createTime);
            builder.append(createUserId);
            builder.append(createUserName);
            builder.append(createWay);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _CreateInfo other = (_CreateInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(createTime, other.createTime);
            builder.append(createUserId, other.createUserId);
            builder.append(createUserName, other.createUserName);
            builder.append(createWay, other.createWay);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("createTime", createTime);
            builder.append("createUserId", createUserId);
            builder.append("createUserName", createUserName);
            builder.append("createWay", createWay);
            return builder.toString();
        }

    }    // _CreateInfo

    // ---------- _LastState组件定义
    /**
     * [组件类] 上次状态。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _LastState extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 最后状态，完成时ID */
        protected final String lastState;

        /** [不可空] 最新完成时间 */
        protected final java.util.Date lastTime;

        /** [不可空] 最新完成操作员id */
        protected final String lastUserId;

        /** [不可空] 最新完成操作员name */
        protected final String lastNickname;

        /** [可空] 流程备注，如为退单，填退单原因。 */
        protected final String lastDesc;

        // _LastState的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _LastState() {
            lastState = null;
            lastTime = null;
            lastUserId = null;
            lastNickname = null;
            lastDesc = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _LastState(_LastState copy) {
            this( copy.lastState, copy.lastTime, copy.lastUserId, copy.lastNickname, copy.lastDesc);
        }

        /**
         * 完整构造函数。
         *
         * @param lastState [不可空] 最后状态，完成时ID
         * @param lastTime [不可空] 最新完成时间
         * @param lastUserId [不可空] 最新完成操作员id
         * @param lastNickname [不可空] 最新完成操作员name
         * @param lastDesc [可空] 流程备注，如为退单，填退单原因。
         */
        protected _LastState(String lastState, java.util.Date lastTime, String lastUserId, String lastNickname, String lastDesc) {
            this.lastState = SafeCopier.copy(lastState);
            this.lastTime = SafeCopier.copy(lastTime);
            this.lastUserId = SafeCopier.copy(lastUserId);
            this.lastNickname = SafeCopier.copy(lastNickname);
            this.lastDesc = SafeCopier.copy(lastDesc);
        }


        // _LastState属性的getter/setter


        /** @return [不可空] 最后状态，完成时ID */
        public String getLastState() {
            return SafeCopier.copy(lastState);
        }

        /** @return [不可空] 最新完成时间 */
        public java.util.Date getLastTime() {
            return SafeCopier.copy(lastTime);
        }

        /** @return [不可空] 最新完成操作员id */
        public String getLastUserId() {
            return SafeCopier.copy(lastUserId);
        }

        /** @return [不可空] 最新完成操作员name */
        public String getLastNickname() {
            return SafeCopier.copy(lastNickname);
        }

        /** @return [可空] 流程备注，如为退单，填退单原因。 */
        public String getLastDesc() {
            return SafeCopier.copy(lastDesc);
        }

        // _LastState组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(lastState);
            builder.append(lastTime);
            builder.append(lastUserId);
            builder.append(lastNickname);
            builder.append(lastDesc);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _LastState other = (_LastState) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(lastState, other.lastState);
            builder.append(lastTime, other.lastTime);
            builder.append(lastUserId, other.lastUserId);
            builder.append(lastNickname, other.lastNickname);
            builder.append(lastDesc, other.lastDesc);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("lastState", lastState);
            builder.append("lastTime", lastTime);
            builder.append("lastUserId", lastUserId);
            builder.append("lastNickname", lastNickname);
            builder.append("lastDesc", lastDesc);
            return builder.toString();
        }

    }    // _LastState

    // ---------- _NextNode组件定义
    /**
     * [组件类] 下一环节。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _NextNode extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [可空] 下一环节 常量，和环节状态、备注同时更新 */
        protected final String nextNodeId;

        /** [可空] 下一环节工作内容 */
        protected final String nextNodeContent;

        // _NextNode的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _NextNode() {
            nextNodeId = null;
            nextNodeContent = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _NextNode(_NextNode copy) {
            this( copy.nextNodeId, copy.nextNodeContent);
        }

        /**
         * 完整构造函数。
         *
         * @param nextNodeId [可空] 下一环节 常量，和环节状态、备注同时更新
         * @param nextNodeContent [可空] 下一环节工作内容
         */
        protected _NextNode(String nextNodeId, String nextNodeContent) {
            this.nextNodeId = SafeCopier.copy(nextNodeId);
            this.nextNodeContent = SafeCopier.copy(nextNodeContent);
        }


        // _NextNode属性的getter/setter


        /** @return [可空] 下一环节 常量，和环节状态、备注同时更新 */
        public String getNextNodeId() {
            return SafeCopier.copy(nextNodeId);
        }

        /** @return [可空] 下一环节工作内容 */
        public String getNextNodeContent() {
            return SafeCopier.copy(nextNodeContent);
        }

        // _NextNode组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(nextNodeId);
            builder.append(nextNodeContent);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _NextNode other = (_NextNode) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(nextNodeId, other.nextNodeId);
            builder.append(nextNodeContent, other.nextNodeContent);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("nextNodeId", nextNodeId);
            builder.append("nextNodeContent", nextNodeContent);
            return builder.toString();
        }

    }    // _NextNode

    // ---------- _CompleteInfo组件定义
    /**
     * [组件类] 完成信息。按不可变（Immutable）类设计，并且各字段都被定义为{@code final}修改权限。
     *
     * @author Benewit Code Generator V1.0
     */
    public abstract static class _CompleteInfo extends com.benewit.entity.AbstractComponent implements java.io.Serializable {

        private static final long serialVersionUID = 1L;

        private static final int C_21 = 21;
        private static final int C_31 = 31;

        /** [不可空] 是否已完成？  Y/N */
        protected final Boolean isComplete;

        /** [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        protected final String completeState;

        /** [可空] 失败原因名称  常量  客户取消 */
        protected final String failReasonName;

        /** [可空] 完成时间 */
        protected final java.util.Date completeTime;

        /** [可空] 完成操作员工号id */
        protected final String completeUserId;

        /** [可空] 完成操作员姓名 */
        protected final String completeNickname;

        /** [可空] 完成备注 */
        protected final String completeDesc;

        // _CompleteInfo的构造函数


        /** 默认构造函数，置各字段为{@code null}值。本构造函数仅供Hibernate使用。 */
        protected _CompleteInfo() {
            isComplete = false;
            completeState = null;
            failReasonName = null;
            completeTime = null;
            completeUserId = null;
            completeNickname = null;
            completeDesc = null;
        }

        /**
         * 拷贝构造函数。
         *
         * @param copy 准备从中拷贝其属性的同类型对象
         */
        protected _CompleteInfo(_CompleteInfo copy) {
            this( copy.isComplete, copy.completeState, copy.failReasonName, copy.completeTime, copy.completeUserId, copy.completeNickname, copy.completeDesc);
        }

        /**
         * 完整构造函数。
         *
         * @param isComplete [不可空] 是否已完成？  Y/N
         * @param completeState [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消）
         * @param failReasonName [可空] 失败原因名称  常量  客户取消
         * @param completeTime [可空] 完成时间
         * @param completeUserId [可空] 完成操作员工号id
         * @param completeNickname [可空] 完成操作员姓名
         * @param completeDesc [可空] 完成备注
         */
        protected _CompleteInfo(Boolean isComplete, String completeState, String failReasonName, java.util.Date completeTime, String completeUserId, String completeNickname, String completeDesc) {
            this.isComplete = SafeCopier.copy(isComplete);
            this.completeState = SafeCopier.copy(completeState);
            this.failReasonName = SafeCopier.copy(failReasonName);
            this.completeTime = SafeCopier.copy(completeTime);
            this.completeUserId = SafeCopier.copy(completeUserId);
            this.completeNickname = SafeCopier.copy(completeNickname);
            this.completeDesc = SafeCopier.copy(completeDesc);
        }


        // _CompleteInfo属性的getter/setter


        /** @return [不可空] 是否已完成？  Y/N */
        public Boolean getIsComplete() {
            return SafeCopier.copy(isComplete);
        }

        /** @return [可空] 完成状态  SUCCESS  成功  FAIL 失败（取消） */
        public String getCompleteState() {
            return SafeCopier.copy(completeState);
        }

        /** @return [可空] 失败原因名称  常量  客户取消 */
        public String getFailReasonName() {
            return SafeCopier.copy(failReasonName);
        }

        /** @return [可空] 完成时间 */
        public java.util.Date getCompleteTime() {
            return SafeCopier.copy(completeTime);
        }

        /** @return [可空] 完成操作员工号id */
        public String getCompleteUserId() {
            return SafeCopier.copy(completeUserId);
        }

        /** @return [可空] 完成操作员姓名 */
        public String getCompleteNickname() {
            return SafeCopier.copy(completeNickname);
        }

        /** @return [可空] 完成备注 */
        public String getCompleteDesc() {
            return SafeCopier.copy(completeDesc);
        }

        // _CompleteInfo组件的hashCode()、equals()和toString()方法

        @Override
        public int hashCode() {
            org.apache.commons.lang.builder.HashCodeBuilder builder = new org.apache.commons.lang.builder.HashCodeBuilder(C_21, C_31);
            builder.append(isComplete);
            builder.append(completeState);
            builder.append(failReasonName);
            builder.append(completeTime);
            builder.append(completeUserId);
            builder.append(completeNickname);
            builder.append(completeDesc);
            return builder.toHashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || this.getClass() != obj.getClass()) {
                return false;
            }

            _CompleteInfo other = (_CompleteInfo) obj;

            org.apache.commons.lang.builder.EqualsBuilder builder = new org.apache.commons.lang.builder.EqualsBuilder();
            builder.append(isComplete, other.isComplete);
            builder.append(completeState, other.completeState);
            builder.append(failReasonName, other.failReasonName);
            builder.append(completeTime, other.completeTime);
            builder.append(completeUserId, other.completeUserId);
            builder.append(completeNickname, other.completeNickname);
            builder.append(completeDesc, other.completeDesc);
            return builder.isEquals();
        }

        @Override
        public String toString() {
            org.apache.commons.lang.builder.ToStringBuilder builder = new org.apache.commons.lang.builder.ToStringBuilder(this);
            builder.append("isComplete", isComplete);
            builder.append("completeState", completeState);
            builder.append("failReasonName", failReasonName);
            builder.append("completeTime", completeTime);
            builder.append("completeUserId", completeUserId);
            builder.append("completeNickname", completeNickname);
            builder.append("completeDesc", completeDesc);
            return builder.toString();
        }

    }    // _CompleteInfo

}
