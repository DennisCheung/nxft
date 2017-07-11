package com.wit.hbcs.qic.it.htmldb.it004;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.hbcs.qic.it.htmldb.base.seperate.AbstractHbcsqSeperateHtmlDbTest;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionMainPage;
import com.wit.hbcs.qic.it.htmldb.page.svcnote.TehEmpSessionOpeatorPage;

public class IT004001 extends AbstractHbcsqSeperateHtmlDbTest {

    private static final String PATH = "qic/004/004001_接受服务单/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void 接受服务单() throws Exception {
        // given
        mockUser("ipaprilzone");

        // when
        TehEmpSessionMainPage page = TehEmpSessionMainPage.to(driver);

        TehEmpSessionOpeatorPage tehEmpSessionOpeatorPage = page.accept(TehEmpSessionOpeatorPage.class);

        //then
        // 通过获取页面元素的值达到等待页面加载完成的效果，否则服务端可能尚未执行完毕
        tehEmpSessionOpeatorPage.getDescTextArea().getText();

        assertEquals("订单详情", tehEmpSessionOpeatorPage.getTitle());
    }
}
