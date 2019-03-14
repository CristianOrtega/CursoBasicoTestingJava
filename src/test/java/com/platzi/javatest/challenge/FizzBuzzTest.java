package com.platzi.javatest.challenge;

import org.junit.Test;

import static org.junit.Assert.*;

public class FizzBuzzTest {

    private FizzBuzz fizzBuzz = new FizzBuzz();

    @Test
    public void isNumberDivisibleForThree(){
        assertEquals("Fizz", fizzBuzz.getFizzBuzz(9));
    }

    @Test
    public void isNumberDivisibleForFive(){
        assertEquals("Buzz", fizzBuzz.getFizzBuzz(20));
    }

    @Test
    public void isNumberDivisibleForThreeAndFive(){
        assertEquals("FizzBuzz", fizzBuzz.getFizzBuzz(15));
    }

}