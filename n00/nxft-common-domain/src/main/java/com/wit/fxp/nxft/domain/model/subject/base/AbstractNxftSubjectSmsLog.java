// CHECKSTYLE:OFF

package com.wit.fxp.nxft.domain.model.subject.base;

/**
 * 暖心饭堂对象短信日志工具类。
 *
 * <p>本类型用到的数据库表中的字段汇总如下：
 * <pre>
 * 1. [主键] String smsId 短信id
 * 2. [不可空] String tspName 通讯服务商如：云之讯、容联 协同通讯
 * 3. [不可空] String subjectId 监测对象ID
 * 4. [不可空] String subjectName 对象姓名
 * 5. [不可空] String circleId 客户所属的工作圈id
 * 6. [不可空] java.util.Date createTime 创建时间
 * 7. [不可空] String smsContent 短信内容
 * 8. [不可空] String smsType 短信类型  TEXT  文字短信  VOICE  语音短信
 * 9. [可空] String smsDesc 业务说明,如 坐席订餐、助餐点订餐
 * 10. [不可空] String toNumber 客户电话号码
 * 11. [不可空] String toName 短信接收人姓名
 * 12. [可空] String relationName 与对象关系name，本人或对象联系人关系
 * 13. [可空] String userCircleId 操作员圈id
 * 14. [可空] String userTeamId 操作员工作组id
 * 15. [不可空] String userUserId 操作员id
 * 16. [不可空] String userNickname 操作员姓名
 * </pre>
 *
 * <p>
 *
 * <p><a href="file:///D:/wtsoft/wtdevappnew/deploy/../sw/output/nxft-subject/java/domain/com/wit/fxp/nxft/domain/model/subject/base/NxftSubjectSmsLog.html">NxftSubjectSmsLog代码模板</a>
 *
 * @author Benewit Code Generator V1.0
 */
public abstract class AbstractNxftSubjectSmsLog {

    /*
     * 本程序不允许修改！！！
     *
     * Created by Benewit Code Generator V1.0
     * codegen/templates//java/java-entabsdomain.template
     */

    /**
     * 检查基本字段和组件字段的长度和非空限制。
     */
    public static void checkProperties(String tspName, String subjectId, String subjectName, String circleId, java.util.Date createTime, String smsContent, String smsType, String smsDesc, String toNumber, String toName, String relationName, String userCircleId, String userTeamId, String userUserId, String userNickname) {

        if (tspName == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[tspName(通讯服务商如：云之讯、容联 协同通讯)]属性不能为空。");
        }

        if (tspName != null && tspName.length() > 30) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[tspName(通讯服务商如：云之讯、容联 协同通讯)]属性超长，最大允许30，实际为" + tspName.length() + "。");
        }

        if (subjectId == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[subjectId(监测对象ID)]属性不能为空。");
        }

        if (subjectId != null && subjectId.length() > 32) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[subjectId(监测对象ID)]属性超长，最大允许32，实际为" + subjectId.length() + "。");
        }

        if (subjectName == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[subjectName(对象姓名)]属性不能为空。");
        }

        if (subjectName != null && subjectName.length() > 50) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[subjectName(对象姓名)]属性超长，最大允许50，实际为" + subjectName.length() + "。");
        }

        if (circleId == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[circleId(客户所属的工作圈id)]属性不能为空。");
        }

        if (circleId != null && circleId.length() > 32) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[circleId(客户所属的工作圈id)]属性超长，最大允许32，实际为" + circleId.length() + "。");
        }

        if (createTime == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[createTime(创建时间)]属性不能为空。");
        }

        if (smsContent == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[smsContent(短信内容)]属性不能为空。");
        }

        if (smsContent != null && smsContent.length() > 1000) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[smsContent(短信内容)]属性超长，最大允许1000，实际为" + smsContent.length() + "。");
        }

        if (smsType == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[smsType(短信类型  TEXT  文字短信  VOICE  语音短信)]属性不能为空。");
        }

        if (smsType != null && smsType.length() > 32) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[smsType(短信类型  TEXT  文字短信  VOICE  语音短信)]属性超长，最大允许32，实际为" + smsType.length() + "。");
        }

        if (smsDesc != null && smsDesc.length() > 256) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[smsDesc(业务说明,如 坐席订餐、助餐点订餐)]属性超长，最大允许256，实际为" + smsDesc.length() + "。");
        }

        if (toNumber == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[toNumber(客户电话号码)]属性不能为空。");
        }

        if (toNumber != null && toNumber.length() > 20) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[toNumber(客户电话号码)]属性超长，最大允许20，实际为" + toNumber.length() + "。");
        }

        if (toName == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[toName(短信接收人姓名)]属性不能为空。");
        }

        if (toName != null && toName.length() > 40) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[toName(短信接收人姓名)]属性超长，最大允许40，实际为" + toName.length() + "。");
        }

        if (relationName != null && relationName.length() > 30) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[relationName(与对象关系name，本人或对象联系人关系)]属性超长，最大允许30，实际为" + relationName.length() + "。");
        }

        if (userCircleId != null && userCircleId.length() > 32) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[userCircleId(操作员圈id)]属性超长，最大允许32，实际为" + userCircleId.length() + "。");
        }

        if (userTeamId != null && userTeamId.length() > 32) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[userTeamId(操作员工作组id)]属性超长，最大允许32，实际为" + userTeamId.length() + "。");
        }

        if (userUserId == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[userUserId(操作员id)]属性不能为空。");
        }

        if (userUserId != null && userUserId.length() > 32) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[userUserId(操作员id)]属性超长，最大允许32，实际为" + userUserId.length() + "。");
        }

        if (userNickname == null) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[userNickname(操作员姓名)]属性不能为空。");
        }

        if (userNickname != null && userNickname.length() > 40) {
            throw new RuntimeException("[NxftSubjectSmsLog(暖心饭堂对象短信日志)]对象的[userNickname(操作员姓名)]属性超长，最大允许40，实际为" + userNickname.length() + "。");
        }
    }

}
