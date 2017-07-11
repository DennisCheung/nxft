package com.wit.hbcs.qic.it.htmldb.it004;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.hbcs.qic.it.htmldb.base.seperate.AbstractHbcsqSeperateHtmlDbTest;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionCancelPage;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionMainPage;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionOpeatorPage;

public class IT004003 extends AbstractHbcsqSeperateHtmlDbTest {
    private static final String PATH = "qic/004/004003_取消服务单/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void 取消服务单() throws Exception {
     // givenki
        mockUser("ipaprilzone");

        // when
        TehEmpSessionMainPage page = TehEmpSessionMainPage.to(driver);

        TehEmpSessionOpeatorPage tehEmpSessionOpeatorPage = page.accept(TehEmpSessionOpeatorPage.class);

        TehEmpSessionCancelPage tehEmpSessionCancelPage = tehEmpSessionOpeatorPage.cancel(TehEmpSessionCancelPage.class);

        //then
        assertEquals("已取消订单", tehEmpSessionCancelPage.getState().getText());
        assertEquals("已取消订单", tehEmpSessionCancelPage.getTitle());
    }
}
