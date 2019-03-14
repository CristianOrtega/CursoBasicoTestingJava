package com.platzi.javatest.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringUtilTest {

    @Test
    public void repeatStringOnce(){
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));
    }

    @Test
    public void repeatStringMultipleTimes(){
        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 3));
    }

    @Test
    public void repeatStringZeroTimes(){
        Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void repeatStringNegativeTimes(){
        Assert.assertEquals("", StringUtil.repeat("hola", -1));
    }

    @Test
    public void stringIsNotEmpty(){
        assertFalse(StringUtil.isEmpty("test"));
    }

    @Test
    public void stringIsEmpty(){
        assertTrue(StringUtil.isEmpty(""));
    }

    @Test
    public void stringIsNull(){
        assertTrue(StringUtil.isEmpty(null));
    }

    @Test
    public void stringWithSpaceIsEmpty(){
        assertTrue(StringUtil.isEmpty(" "));
    }

}