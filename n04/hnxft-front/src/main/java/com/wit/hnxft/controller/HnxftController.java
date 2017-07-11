package com.wit.hnxft.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.benewit.core.env.RuntimeContext;
import com.wit.Invoker;
import com.wit.fxp.nxft.app.AddNxftOrderCommand;
import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.nxft.app.common.model.KitchenMenuData;
import com.wit.hnxft.api.OrderQueryCommand;
import com.wit.hnxft.api.order.HnxftOrderApp;
import com.wit.hnxft.api.team.HnxftTeamApp;
import com.wit.hnxft.command.AddOrderCommand;
import com.wit.hnxft.dbc.DBC;
import com.wit.hnxft.model.HnxftCircleAndTeamModel;
import com.wit.hnxft.model.HnxftDeliveNoteModel;
import com.wit.hnxft.model.HnxftMealTypeModel;
import com.wit.hnxft.model.HnxftOrderCountModel;
import com.wit.hnxft.model.HnxftOrderModel;
import com.wit.hnxft.model.HnxftQuerySubjectOrderModel;
import com.wit.hnxft.model.HnxftSchenoteModel;
import com.wit.hnxft.model.HnxftSubjectCountModel;
import com.wit.hnxft.model.HnxftSubjectModel;
import com.wit.hnxft.model.HnxftTeamModel;
import com.wit.hnxft.model.HnxtDeliveDetailModel;
import com.wit.hnxft.subject.HnxftSubjectApp;
import com.wit.hnxft.subject.MobileVerificationException;
import com.wit.hnxft.user.CurrentUser;
import com.wit.hnxft.user.HnxftUserApp;
import com.wit.utils.DateUtils;

/**
 *  助餐点数据墙-接口
 */
@RestController
public class HnxftController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HnxftController.class);

    @Autowired private HnxftOrderApp hnxftOrderApp;
    @Autowired private HnxftUserApp hnxftUserApp;
    @Autowired private HnxftSubjectApp hnxftSubjectApp;
    @Autowired private HnxftTeamApp hnxftTeamApp;
    @Autowired private AddOrderApp addOrderApp;
    @Autowired private CurrentUser currentUser;
    @Autowired private RuntimeContext runtimeContext;
    @Autowired private HttpSession session;

    /**
     * 查询工作圈-助餐点列表
     * @return
     */
    @GetMapping(value = "/app/queryCircleAndTeam")
    public HnxftCircleAndTeamModel queryCircleAndTeam() {
        LOGGER.info("controller层:收到查询工作圈我的工作圈-组信息 userId={}", this.currentUser.getUserId());
        HnxftCircleAndTeamModel model = this.hnxftTeamApp.findCircleAndTeam(this.currentUser.getUserId());
        return model;
    }

    /**
     * 得到操作员所属的助餐点工作站列表
     * @return
     */
    @GetMapping(value = "/app/findUserTeam")
    public List<HnxftTeamModel> findUserTeam() {
        LOGGER.info("controller层:收到查询操作员所属助餐点列表请求, 操作员:userId={}", this.currentUser.getUserId());
        List<HnxftTeamModel> list = this.hnxftTeamApp.findUserTeam(this.currentUser.getUserId(), DBC.子系统.助餐点工作站.value());
        return list;
    }

    /**
     * 得到助餐点数据墙-客户统计数据
     * @param teamId
     * @return
     */
    @GetMapping(value = "/app/statisticsSubject")
    public HnxftSubjectCountModel statisticsSubject(@RequestParam String teamId) {
        LOGGER.info("controller层:收到得到助餐点数据墙-客户统计数据请求, 操作员:userId={}", this.currentUser.getUserId());
        HnxftSubjectCountModel model = this.hnxftSubjectApp.statisticsSubject(teamId);
        return model;
    }

    /**
     * 得到助餐点数据墙-订单统计数据
     * @return
     */
    @GetMapping(value = "/app/statisticsOrder")
    public HnxftOrderCountModel statisticsOrder(@RequestParam String teamId) {
        LOGGER.info("controller层:收到得到助餐点数据墙-订单统计数据请求, 操作员:userId={}", this.currentUser.getUserId());
        HnxftOrderCountModel model = this.hnxftOrderApp.statisticsOrder(teamId);
        return model;
    }

    /**
     * 查询助餐点下所有客户
     * @param teamId
     * @return
     */
    @GetMapping(value = "/app/findAllSubejct")
    public List<HnxftSubjectModel> findAllSubejct(@RequestParam String teamId) {
        LOGGER.info("controller层:收到查询助餐点下所有对象请求, 操作员:userId={}, 助餐点:teamId={}", this.currentUser.getUserId(), teamId);
        List<HnxftSubjectModel> list = this.hnxftSubjectApp.findAllSubejct(teamId, this.runtimeContext.getCurrentDate());
        return list;
    }

    /**
     * 得到今日菜谱
     * @param circleId
     * @param personId
     * @param dateStr
     * @return
     * @throws ParseException
     */
    @GetMapping(value = "/app/findAllDatas")
    public List<KitchenMenuData> findAllDatas(@RequestParam String circleId, @RequestParam String personId, @RequestParam String dateStr) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LOGGER.info("controller层:收到查询菜谱详情请求, 操作员:userId={}", this.currentUser.getUserId());
        List<KitchenMenuData> list = this.addOrderApp.findAllDatas(circleId, personId, dateFormat.parse(dateStr));
        return list;
    }

    /**
     * 根据工作圈id以及客户编号得到助餐点工作站对象
     * @param circleId
     * @param personId
     * @return
     */
    @GetMapping(value = "/app/findHnxftSubjectModel")
    public HnxftSubjectModel findHnxftSubjectModel(@RequestParam String circleId, @RequestParam String personId) {
        LOGGER.info("controller层:收到查询助餐点工作站对象请求, 操作员:userId={}, 对象:personId={}, 对象所属工作圈:circleId={}", this.currentUser.getUserId(), personId, circleId);
        HnxftSubjectModel model = this.hnxftSubjectApp.findHnxftSubjectModel(circleId, personId);
        return model;
    }

    /**
     * 助餐点工作站下单
     * @param c
     */
    @RequestMapping(value = "/app/addOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public void deleteCircle(@RequestBody AddOrderCommand c) {
        LOGGER.info("controller层:收到助餐点工作站下单请求 操作员:userId={}, 助餐点工作站对象:personId={}", this.currentUser.getUserId(), c.getPersonId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String teamId = c.getCommands().get(0).getTeamId();
        List<AddNxftOrderCommand> lists = c.getCommands().stream().map(e -> {
            Date d = new Date();
            try {
                d = dateFormat.parse(e.getMealDate());
            }
            catch (ParseException e1) {
                e1.printStackTrace();
            }
            AddNxftOrderCommand m = AddNxftOrderCommand.builder()
                    ._mealDate______(d)
                    ._mealTypeId____(e.getMealTypeId())
                    ._mealId________(e.getMealId())
                    ._build_();
            return m;
        }).collect(Collectors.toList());
        this.addOrderApp.派单(Invoker.builder()
                ._teamId____(teamId)
                ._userId____(this.currentUser.getUserId())
                ._build_(), c.getPersonId(), lists, "2");
    }

    /**
     * 查询助餐点工作站当餐订单汇总
     * @param teamId
     * @param mealTypeId
     * @param time
     * @return
     */
    @GetMapping(value = "/app/findHnxftOrderList")
    public List<HnxftOrderModel> findHnxftOrderList(@RequestParam String teamId, @RequestParam String mealTypeId, @RequestParam String time) throws ParseException {
        LOGGER.info("controller层:收到查询助餐点工作站当餐订单汇总请求, 操作员:userId={}, 助餐点工作站:temaId={}", this.currentUser.getUserId(), teamId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<HnxftOrderModel> list = this.hnxftOrderApp.findHnxftOrderList(teamId, DateUtils.getBeginTime(dateFormat.parse(time)), mealTypeId);
        return list;
    }

    /**
     * 查找所有餐别类型
     * @return
     */
    @GetMapping(value = "/app/findAllMealType")
    public List<HnxftMealTypeModel> findAllMealType() {
        LOGGER.info("controller层:收到查询所有餐别类型请求, 操作员:userId={}", this.currentUser.getUserId());
        List<HnxftMealTypeModel> list = this.hnxftOrderApp.findAllMealType();
        return list;
    }

    /**
     * 查询助餐点工作站对象消费明细(近十天内)
     * @param teamId
     * @param personId
     * @return
     */
    @GetMapping(value = "/app/findHnxftOrderModelListBySubject")
    public List<HnxftQuerySubjectOrderModel> findHnxftOrderModelListBySubject(@RequestParam String teamId) {
        LOGGER.info("controller层:收到查询助餐点工作站对象消费明细(近十天内)请求, 操作员:userId={}", this.currentUser.getUserId());
        List<HnxftQuerySubjectOrderModel> list = this.hnxftOrderApp.findHnxftOrderModelListBySubject(teamId, runtimeContext.getCurrentDate());
        return list;
    }

    /**
     * 验证操作员
     * @return
     */
    @GetMapping(value = "/app/verificationUser")
    public boolean verificationUser(@RequestParam String password) {
        LOGGER.info("controller层:收到得到助餐点数据墙-验证操作员权限请求, 操作员:userId={}", this.currentUser.getUserId());
        boolean isUser = this.hnxftUserApp.verificationUser(this.currentUser.getUserId(), password);
        return isUser;
    }

    /**
     * 点餐时验证操作员
     * @return
     */
    @GetMapping(value = "/app/orderVerificationUser")
    public boolean orderVerificationUser(@RequestParam String password) {
        LOGGER.info("controller层:收到得到助餐点数据墙-点餐时验证操作员权限请求, 操作员:userId={}", this.currentUser.getUserId());
        boolean isUser = this.hnxftUserApp.verificationUser(this.currentUser.getUserId(), password);
        this.session.setAttribute("isOpeator", isUser);
        return isUser;
    }

    /**
     * 操作员验证退出点餐权限
     * @return
     */
    @GetMapping(value = "/app/orderAntiVerification")
    public void orderAntiVerification() {
        LOGGER.info("controller层:收到得到助餐点数据墙-退出点餐权限请求, 操作员:userId={}", this.currentUser.getUserId());
        this.session.removeAttribute("isOpeator");
    }

    /**
     * 操作员验证退出点餐权限
     * 返回true，查询到了操作员点餐权限会话，即意味着可以继续点餐
     * 返回false，查询不到操作员点餐权限会话，即意味着不可以继续点餐
     * @return
     */
    @GetMapping(value = "/app/queryOpeatorSession")
    public boolean queryOpeatorSession() {
        LOGGER.info("controller层: 收到查询操作员会话请求, 操作员:userId={}", this.currentUser.getUserId());
        if (this.session.getAttribute("isOpeator") == null) {
            LOGGER.info("无操作员权限会话", this.currentUser.getUserId());
            return false;
        }
        LOGGER.info("有操作员权限会话", this.currentUser.getUserId());
        return true;
    }

    /**
     * 根据手机号码全号得到客户
     * @param teamId 选择的助餐点工作组id
     * @param mobile 界面输入的手机号码
     * @return
     */
    @GetMapping(value = "/app/findSubjectByMobile")
    public HnxftSubjectModel findSubjectByMobile(@RequestParam String teamId, @RequestParam String mobile) {
        LOGGER.info("controller层:收到查询助餐点下所有对象请求, 操作员:userId={}, 助餐点:teamId={}", this.currentUser.getUserId(), teamId);
        HnxftSubjectModel model = this.hnxftSubjectApp.findSubjectByMobile(mobile, this.runtimeContext.getCurrentDate(), teamId);
        return model;
    }

    /**
     * 查找配送单
     * @param teamId 助餐点
     * @param state 状态
     * @return
     */
    @GetMapping(value = "/app/findHnxftDeliveNote")
    public List<HnxftDeliveNoteModel> findHnxftDeliveNote(@RequestParam String teamId, @RequestParam String state) {
        LOGGER.info("controller层:收到查询助餐点下配送单请求请求, 操作员:userId={}, 助餐点:teamId={}", this.currentUser.getUserId(), teamId);
        List<HnxftDeliveNoteModel> list = this.hnxftOrderApp.findHnxftDeliveNoteList(teamId, state);
        return list;
    }

    /**
     * 查找配送单明细
     * @param deliveId
     * @return
     */
    @GetMapping(value = "/app/findHnxtDeliveDetai")
    public List<HnxtDeliveDetailModel> findHnxtDeliveDetai(@RequestParam String deliveId) {
        LOGGER.info("controller层:收到查询助餐点配送单明细请求, 操作员:deliveId={}", deliveId);
        List<HnxtDeliveDetailModel> list = this.hnxftOrderApp.findHnxftDeliveDetailList(deliveId);
        return list;
    }

    /**
     * 查找助餐点下可进行发放的订单
     * @param teamId 助餐点id
     * @param data 日期
     * @param mealTypeId 餐别id
     * @return
     */
    @RequestMapping(value = "/app/findForTransmission", method = {RequestMethod.POST, RequestMethod.GET})
    public List<HnxftOrderModel> findForTransmission(@RequestParam String teamId, @RequestParam String data, @RequestParam String mealTypeId) throws ParseException {
        LOGGER.info("controller层:收到查询助餐点下可进行发放的订单请求, 操作员:userId={}, 助餐点:teamId={}", this.currentUser.getUserId(), teamId);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<HnxftOrderModel> list = this.hnxftOrderApp.findHnxftOrderListForTransmission(teamId, DateUtils.getBeginTime(dateFormat.parse(data)), mealTypeId);
        return list;
    }

    /**
     * 确认配送单
     * @param c
     */
    @RequestMapping(value = "/app/confirmDeliveNote", method = {RequestMethod.POST, RequestMethod.GET})
    public void confirmDeliveNote(@RequestParam String teamId, @RequestParam String deliveId) {
        LOGGER.info("controller层:收到助餐点确认配送单请求 操作员:userId={}, 助餐点工作站对象:teamId={}, 配送单id:deliveId={}", this.currentUser.getUserId(), deliveId);
        this.addOrderApp.comfirmDeliveNote(deliveId, this.currentUser.getUserId(), teamId);
    }

    /**
     * 发放订单
     * @param c
     */
    @RequestMapping(value = "/app/transmissionOrder", method = {RequestMethod.POST, RequestMethod.GET})
    public void transmissionOrder(@RequestBody OrderQueryCommand cmd) {
        if (cmd.getList().isEmpty()) {
            LOGGER.error("controller层:数据有误，请求失败，请选择有效订单");
        }
        else {
            cmd.getList().forEach(e -> {
                LOGGER.info("controller层:收到助餐点发放订单请求 操作员:userId={}, 助餐点工作站对象:teamId={}, 订单id:orderId={}", this.currentUser.getUserId(), e);
                this.addOrderApp.transmissionOrder(e, this.currentUser.getUserId(), cmd.getTeamId());
            });
        }
    }

    @GetMapping(value = "/app/findScheData")
    public HnxftSchenoteModel findScheData(String teamId, String weekDateBegin) {
        return this.hnxftOrderApp.findScheData(teamId, weekDateBegin);
    }

    @GetMapping(value = "/app/plusWeek")
    public Date plusWeek(String preDate, Integer add) {
        return this.hnxftOrderApp.plusWeek(preDate, add);
    }

    @ExceptionHandler
    @ResponseStatus
    private Map<String, String> onPrivilegeError(MobileVerificationException ex) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("error", ex.getMessage());
        return map;
    }
}
