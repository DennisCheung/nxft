package com.wit.hbcs.qic.it.htmldb.it007;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.hbcs.qic.it.htmldb.base.seperate.AbstractHbcsqSeperateHtmlDbTest;
import com.wit.hbcs.qic.it.htmldb.page.order.ConversationPage;
import com.wit.hbcs.qic.it.htmldb.page.order.NewOrderPage;
import com.wit.hbcs.qic.it.htmldb.page.order.OrderedPage;

public class IT007041 extends AbstractHbcsqSeperateHtmlDbTest {
    private static final String PATH = "qic/007/007041_求助服务单_受理订单/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void 受理() throws Exception {
        // given
        mockUser("ipaprilzone");

        String messageId = "12345";
        String noteId = "0001";

        NewOrderPage page = NewOrderPage.to(driver, messageId, noteId);
        ConversationPage cpage = page.accept(ConversationPage.class);
        OrderedPage opage = cpage.show(OrderedPage.class);
        assertEquals("已接单", opage.getType().getText());
    }
}
