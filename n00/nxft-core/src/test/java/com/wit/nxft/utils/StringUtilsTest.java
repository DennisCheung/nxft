package com.wit.nxft.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.wit.fxp.nxft.utils.StringUtils;

public class StringUtilsTest {

    @Test
    public void equalsOrgreaterThan() {
        assertTrue(StringUtils.equalsOrGreaterThan("123", "123"));
        assertTrue(StringUtils.equalsOrGreaterThan("123", "120"));
        assertFalse(StringUtils.equalsOrGreaterThan("123", "124"));
        assertFalse(StringUtils.equalsOrGreaterThan("123", "1230"));
        assertFalse(StringUtils.equalsOrGreaterThan("123", "2"));
        assertTrue(StringUtils.equalsOrGreaterThan("2", "123"));
    }

}
