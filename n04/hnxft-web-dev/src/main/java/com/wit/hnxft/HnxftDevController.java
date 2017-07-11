package com.wit.hnxft;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 开发测试用的控制器，模拟一个应用。
 *
 * @author yw
 *
 */
@Controller
public class HnxftDevController {

    @Autowired ServerProperties serverProperties;

    @RequestMapping(value = "/dev", method = RequestMethod.GET)
    public ModelAndView index() throws Exception {

        String hint = "";
        int proxyPort = getProxyPort();

        ModelAndView mav = new ModelAndView("dev/index");
        mav.addObject("now", new Date());
        mav.addObject("proxyPort", proxyPort);
        mav.addObject("serverPort", serverProperties.getPort());
        mav.addObject("hint", hint);
        return mav;
    }

    private int getProxyPort() {
        Pattern pattern = Pattern.compile("[a-z]+(\\d+(\\.\\d+)?$)");
        Matcher matcher = pattern.matcher(serverProperties.getContextPath());
        if (matcher.find()) {
            String port = matcher.group(1);
            return Integer.valueOf(port);
        }
        return 0;
    }

}
