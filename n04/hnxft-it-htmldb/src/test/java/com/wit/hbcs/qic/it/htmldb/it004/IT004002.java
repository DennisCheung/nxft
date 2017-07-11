package com.wit.hbcs.qic.it.htmldb.it004;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.hbcs.qic.it.htmldb.base.seperate.AbstractHbcsqSeperateHtmlDbTest;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionMainPage;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionRufusePage;

public class IT004002 extends AbstractHbcsqSeperateHtmlDbTest {

    private static final String PATH = "qic/004/004002_拒绝服务单/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void 拒绝服务单() throws Exception {
        // given
        mockUser("ipaprilzone");

        // when
        TehEmpSessionMainPage page = TehEmpSessionMainPage.to(driver);

        TehEmpSessionRufusePage tehEmpSessionRufusePage =  page.refuse(TehEmpSessionRufusePage.class);

        //then
        assertEquals("已拒绝订单", tehEmpSessionRufusePage.getState().getText());
        assertEquals("已拒绝订单", tehEmpSessionRufusePage.getTitle());
    }
}
