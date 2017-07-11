package com.wit.nxft.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wit.fxp.nxft.utils.MathUtils;

public class MathUtilsTest {

    @Test
    public void divide2DoubleTest() {
        // given

        // when

        // then
        assertEquals(23.4666, MathUtils.divide2Double("65", "2.77", 3), 0.001);
    }

}
