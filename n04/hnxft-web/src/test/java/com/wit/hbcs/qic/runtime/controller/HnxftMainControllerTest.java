package com.wit.hbcs.qic.runtime.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

import com.wit.fxp.it.base.controller.AbstractFxpControllerTest;
import com.wit.hnxft.runtime.controller.HnxftMainController;
import com.wit.hnxft.runtime.db.DatabaseChecker;

public class HnxftMainControllerTest extends AbstractFxpControllerTest {

    @MockBean DatabaseChecker databaseChecker;
    @SpyBean HnxftMainController cut;

    @Test
    public void ping() throws Exception {
        mockMvc.perform(get("/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string("pong"));
    }

}
