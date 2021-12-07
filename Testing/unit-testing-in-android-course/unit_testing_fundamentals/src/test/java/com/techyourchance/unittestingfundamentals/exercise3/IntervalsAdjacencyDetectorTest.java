package com.techyourchance.unittestingfundamentals.exercise3;

import com.techyourchance.unittestingfundamentals.example3.Interval;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IntervalsAdjacencyDetectorTest {

    IntervalsAdjacencyDetector SUT;

    @Before
    public void setUp() throws Exception {
        SUT = new IntervalsAdjacencyDetector();
    }

    @Test
    public void SUT_isNotNull_true() {
        Assert.assertNotNull(SUT);
    }

    @Test
    public void isAdjacent_AdjacentIntervalsNoOverlap_true() {
        Interval interval1 = new Interval(3,5);
        Interval interval2 = new Interval(5,9);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_notAdjacentIntervalsNoOverlap_false() {
        Interval interval1 = new Interval(1,2);
        Interval interval2 = new Interval(5,10);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertFalse(var);
    }

    @Test
    public void isAdjacent_AdjacentIntervalsWithOverlap_false() {
        Interval interval1 = new Interval(3,5);
        Interval interval2 = new Interval(3,9);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertFalse(var);
    }
}