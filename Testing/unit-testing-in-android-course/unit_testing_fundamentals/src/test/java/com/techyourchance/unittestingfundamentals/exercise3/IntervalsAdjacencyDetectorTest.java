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
    public void isAdjacent_differentSignalAdjacentIntervals_true() {
        Interval interval1 = new Interval(-5,-3);
        Interval interval2 = new Interval(-5,9);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_differentSignalNotAdjacentIntervals_false() {
        Interval interval1 = new Interval(-5,-2);
        Interval interval2 = new Interval(6,9);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_differentSignalContainedIntervals_false() {
        Interval interval1 = new Interval(-5,10);
        Interval interval2 = new Interval(-2,5);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertFalse(var);
    }

    @Test
    public void isAdjacent_positiveSignalAdjacentIntervals_true() {
        Interval interval1 = new Interval(5,15);
        Interval interval2 = new Interval(15,30);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_positiveSignalNotAdjacentIntervals_false() {
        Interval interval1 = new Interval(0,5);
        Interval interval2 = new Interval(10,15);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_positiveSignalContainedIntervals_false() {
        Interval interval1 = new Interval(0,25);
        Interval interval2 = new Interval(5,10);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertFalse(var);
    }

    @Test
    public void isAdjacent_negativeSignalAdjacentIntervals_true() {
        Interval interval1 = new Interval(-60,-3);
        Interval interval2 = new Interval(-3,-1);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_negativeSignalNotAdjacentIntervals_false() {
        Interval interval1 = new Interval(-75,-59);
        Interval interval2 = new Interval(-40,-30);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertTrue(var);
    }

    @Test
    public void isAdjacent_negativeSignalContainedIntervals_false() {
        Interval interval1 = new Interval(-150,-98);
        Interval interval2 = new Interval(-120,-110);
        //Arrange
        boolean var = SUT.isAdjacent(interval1, interval2);
        //Act
        //Assert
        Assert.assertFalse(var);
    }
}