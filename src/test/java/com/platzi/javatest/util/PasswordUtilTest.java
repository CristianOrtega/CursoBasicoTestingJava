package com.platzi.javatest.util;

import org.junit.Test;

import static com.platzi.javatest.util.PasswordUtil.SecurityLevel.*;
import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weakWhenHasLessThan8Letters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("123aa!"));
    }

    @Test
    public void weakWhenHasOnlyLetters(){
        assertEquals(WEAK, PasswordUtil.assessPassword("abcdefgh"));
    }

    @Test
    public void mediumWhenHasLettersAndNumber(){
        assertEquals(MEDIUM, PasswordUtil.assessPassword("abcd1234"));
    }

    @Test
    public void strongWhenHasLettersNumbersAndSymbols(){
        assertEquals(STRONG, PasswordUtil.assessPassword("abcd123!"));
    }

}