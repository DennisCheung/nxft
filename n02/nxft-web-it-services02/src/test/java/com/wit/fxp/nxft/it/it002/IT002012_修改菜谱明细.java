package com.wit.fxp.nxft.it.it002;

import java.util.Arrays;

import org.junit.Test;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.wit.fxp.nxft.it.base.AbstractDBUnitTest02;
import com.wit.fxp.nxft.menu.NxftMealSetApp;
import com.wit.fxp.nxft.menu.model.AddMealScheDayCommand;
import com.wit.utils.DateUtils;

public class IT002012_修改菜谱明细 extends AbstractDBUnitTest02 {

    private static final String PATH = "002/002012_修改菜谱明细/";

    @Test
    @DatabaseSetup(PATH + "before.xml")
    @ExpectedDatabase(value = PATH + "after.xml", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testNxft() throws Exception {

        //given
        AddMealScheDayCommand command = AddMealScheDayCommand.builder()
                ._mealSchenoteId____("6001")
                ._mealTypeId________("1")
                ._mealDate__________(DateUtils.parseLongDate("2017-05-08 00:00:00.0"))
                ._mealIds___________(Arrays.asList("3020101", "3020102"))
                ._build_();

        //when
        NxftMealSetApp app = getBeanForTesting(NxftMealSetApp.class);
        app.editMealScheDays(command);
        //then
    }

}
