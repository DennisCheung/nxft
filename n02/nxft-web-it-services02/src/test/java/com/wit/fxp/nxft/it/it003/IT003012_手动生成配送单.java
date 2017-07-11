package com.wit.fxp.nxft.it.it003;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.Invoker;
import com.wit.fxp.nxft.compound.NxftCompoundApp;
import com.wit.fxp.nxft.compound.model.HandCreatCompoundCommand;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest02;
import com.wit.utils.DateUtils;

public class IT003012_手动生成配送单 extends AbstractDBUnitTest02 {

    private static final String PATH = "003/003012_手动生成配送单/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void createData() throws Exception {

        //given
        Invoker invoker = Invoker.builder()
                ._teamId____("3020101")
                ._userId____("00041")
                ._build_();
        HandCreatCompoundCommand command = HandCreatCompoundCommand.builder()
                ._mealDate______(DateUtils.parseShortDate("2017-05-06"))
                ._mealTypeId____("2")
                ._build_();

        //when
        runtimeContext.setDevMode(DateUtils.parseLongDate("2017-05-06 11:00:00.0"));
        NxftCompoundApp app = getBeanForTesting(NxftCompoundApp.class);
        app.handCompoundCreate(invoker, command);

        //then
    }

}
