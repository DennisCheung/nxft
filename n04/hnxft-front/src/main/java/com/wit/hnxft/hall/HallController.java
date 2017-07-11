package com.wit.hnxft.hall;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wit.hnxft.api.team.HnxftTeamApp;
import com.wit.hnxft.model.HnxftTeamModel;
import com.wit.hnxft.user.CurrentUser;

/**
 *  新大厅入口
 */
@RestController
public class HallController {

    @Autowired CurrentUser currentUser;
    @Autowired HnxftTeamApp hnxftTeamApp;

    private static final Logger LOGGER = LoggerFactory.getLogger(HallController.class);

    @RequestMapping(value = "/hall/index", method = {RequestMethod.POST, RequestMethod.GET})
    public void openMyIndex(HttpServletRequest request) throws Exception {
        LOGGER.info("收到进入'我'请求" + this.currentUser.getUserId());
        List<HnxftTeamModel> list = this.hnxftTeamApp.findUserTeam(this.currentUser.getUserId(), com.wit.hnxft.dbc.DBC.子系统.助餐点工作站.value());
        list.size();
    }
}
