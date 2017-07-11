package com.wit.fxp.nxft.it.it002;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.Invoker;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest02;
import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.AddMealSetCommand;

//@Ignore
public class IT002001_新建套餐 extends AbstractDBUnitTest02 {

    private static final String PATH = "002/002001_新建套餐/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void addMealSet() throws Exception {

        //given
        Invoker invoker = Invoker.builder()
                ._teamId____("3020101")
                ._userId____("00041")
                ._build_();
        AddMealSetCommand command = AddMealSetCommand.builder()
                ._mealSetCode_______("01")
                ._mealSetName_______("早餐A套餐")
                ._mealSetContent____("包子、馒头、白粥")
                ._pepperyLevel______(null)
                ._mealPrice_________(5d)
                ._photoId___________(null)
                ._mealSetDesc_______("配咸菜")
                ._build_();

        //when
        NxftMealSetApp app = getBeanForTesting(NxftMealSetApp.class);
        app.addMealSet(invoker, command);
        //then
    }

}
