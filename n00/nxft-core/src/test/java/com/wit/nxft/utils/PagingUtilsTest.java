package com.wit.nxft.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.wit.fxp.nxft.utils.PagingUtils;

public class PagingUtilsTest {

    @Test
    public void divide2PagingTest() {
        // given

        // when

        // then
        assertEquals(41, PagingUtils.getBeginPagNum(3, 20));

        assertEquals(44, PagingUtils.getEndPagNum(3, 44, 20));
    }
}
