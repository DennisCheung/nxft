package com.wit.fxp.nxft.ui.toolbar.menuhandler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MenuHandlerConfiguration {

    @Autowired ApplicationContext applicationContext;

    /**
     * 菜单处理器
     * menuHandlerManager 名称必须全局唯一！
     * @return
     */
    @Bean
    public MenuHandlerManager menuHandlerManager() {
        Map<String, MenuHandler> handlers = applicationContext.getBeansOfType(MenuHandler.class);

        MenuHandlerManager manager = new MenuHandlerManager();
        for (Map.Entry<String, MenuHandler> entry : handlers.entrySet()) {
            manager.registerTaskHandler(entry.getValue());
        }
        return manager;
    }

}
