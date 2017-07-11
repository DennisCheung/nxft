package com.wit.fxp.nxft.it.it003;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.fxp.nxft.app.AddOrderApp;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest00;

public class IT003021_厨房确认配送 extends AbstractDBUnitTest00 {

    private static final String PATH = "003/003031_助餐点确认送达/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void createData() throws Exception {

        //given

        //when
        AddOrderApp app = getBeanForTesting(AddOrderApp.class);
        app.comfirmDeliveNote("40001", "00001", "1000141");

        //then
    }
}
