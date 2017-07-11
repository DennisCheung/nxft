package com.wit.fxp.nxft.it.it002;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.Invoker;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest02;
import com.wit.fxp.nxft.menu.NxftMealSetApp;

public class IT002011_新增周菜谱单头 extends AbstractDBUnitTest02 {

    private static final String PATH = "002/002011_新增周菜谱单头/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testNxft() throws Exception {

        //given
        Invoker invoker = Invoker.builder()
                ._teamId____("3020101")
                ._userId____("00041")
                ._build_();

        //when
        NxftMealSetApp app = getBeanForTesting(NxftMealSetApp.class);
        app.newMaxEndDate(invoker);
        //then
    }

}
