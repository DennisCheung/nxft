package com.wit.fxp.nxft.it.it003;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest02;
import com.wit.utils.DateUtils;

public class IT003011_自动生成配送单 extends AbstractDBUnitTest02 {

    private static final String PATH = "003/003011_自动生成配送单/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void createData() throws Exception {

        //given

        //when
        runtimeContext.setDevMode(DateUtils.parseLongDate("2017-05-06 11:00:00.0"));
        NxftCompoundApp app = getBeanForTesting(NxftCompoundApp.class);
        app.compoundCreateEveryDay(runtimeContext.getCurrentDate());

        //then
    }

}
