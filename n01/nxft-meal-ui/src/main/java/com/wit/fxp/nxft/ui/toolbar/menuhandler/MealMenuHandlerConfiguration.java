package com.wit.fxp.nxft.ui.toolbar.menuhandler;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MealMenuHandlerConfiguration {

    @Autowired ApplicationContext applicationContext;

    /**
     * 菜单处理器
     * menuHandlerManager 名称必须全局唯一！方法名全局唯一
     * @return
     */
    @Bean
    public MealMenuHandlerManager mealMenuHandlerManager() {
        Map<String, MealMenuHandler> handlers = applicationContext.getBeansOfType(MealMenuHandler.class);

        MealMenuHandlerManager manager = new MealMenuHandlerManager();
        for (Map.Entry<String, MealMenuHandler> entry : handlers.entrySet()) {
            manager.registerTaskHandler(entry.getValue());
        }
        return manager;
    }

}
