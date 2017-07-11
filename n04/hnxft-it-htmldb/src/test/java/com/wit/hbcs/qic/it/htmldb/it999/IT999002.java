package com.wit.hbcs.qic.it.htmldb.it999;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.hbcs.qic.it.htmldb.base.seperate.AbstractHbcsqSeperateHtmlDbTest;

public class IT999002 extends AbstractHbcsqSeperateHtmlDbTest {

    private static final String PATH = "qic/999/999998_空验证/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void 分离测试模式() throws Exception {
        mockUser("wj");
    }
}
