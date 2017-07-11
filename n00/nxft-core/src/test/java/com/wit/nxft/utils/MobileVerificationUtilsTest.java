package com.wit.nxft.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wit.fxp.nxft.utils.MobileVerificationUtils;

public class MobileVerificationUtilsTest {

    @Test
    public void divide2PhoneTest() {
        // given

        // when

        // then
        assertEquals(true, MobileVerificationUtils.isPhoneLegal("15999947554"));
    }
}
