package com.techyourchance.unittestingfundamentals.exercise1;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

public class NegativeNumberValidatorTest {

    public NegativeNumberValidator SUT = new NegativeNumberValidator();

    @Test
    public void sutIsNotNull() {
        Assert.assertNotNull(SUT);
    }

    @Test
    public void isNumberNegative() {
        int num = -5;
        Assert.assertEquals(true, SUT.isNegative(num));
    }

    @Test
    public void isNumberPositive() {
        int num = 2;
        Assert.assertEquals(false, SUT.isNegative(num));
    }

    @Test
    public void isNegativeZero() {
        int num = 0;
        Assert.assertEquals(false, SUT.isNegative(num));
    }
}