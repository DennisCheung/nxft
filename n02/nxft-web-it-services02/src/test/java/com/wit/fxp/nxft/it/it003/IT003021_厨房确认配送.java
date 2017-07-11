package com.wit.fxp.nxft.it.it003;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.Invoker;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest02;

public class IT003021_厨房确认配送 extends AbstractDBUnitTest02 {

    private static final String PATH = "003/003021_厨房确认配送/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testNxft() throws Exception {

        //given
        String id = "40001";
        Invoker invoker = Invoker.builder()
                ._teamId____("3020101")
                ._userId____("00041")
                ._build_();

        //when
        NxftCompoundApp app = getBeanForTesting(NxftCompoundApp.class);
        app.confirmDelive(invoker, id);

        //then
    }

}
