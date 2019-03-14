package com.platzi.javatest.discount;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    private PriceCalculator calculator;

    @Before
    public void setup(){
        calculator = new PriceCalculator();
    }

    @Test
    public void totalZeroWhenThereArePrices() {
        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void totalIsTheSumOfPrices(){
        calculator.addPrice(10.2);
        calculator.addPrice(15.5);
        assertThat(calculator.getTotal(), is(25.7));
    }

    @Test
    public void applyDiscountToPrices(){
        calculator.addPrice(100);
        calculator.addPrice(50);
        calculator.addPrice(50);
        calculator.setDiscount(25);
        assertThat(calculator.getTotal(), is(150.0));
    }

}