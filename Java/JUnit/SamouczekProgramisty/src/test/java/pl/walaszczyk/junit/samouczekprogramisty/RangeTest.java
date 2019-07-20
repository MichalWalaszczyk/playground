/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.walaszczyk.junit.samouczekprogramisty;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Michał Walaszczyk
 */
public class RangeTest {
    
    private Range correctRange;

    public RangeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
    @Before
    public void setUp() {
        System.out.println("Set up");
        this.correctRange = new Range(10, 20);
    }
    
    @After
    public void tearDown() {
        System.out.println("Tear down");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear down class");
    }

    @Test
    public void shouldSayThat15IsInRange() {
        System.out.println("shouldSayThat15IsInRange");
        assertTrue(this.correctRange.isRange(15));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenLowerBoundIsLargerThanUpperBound() {        
        System.out.println("shouldThrowIllegalArgumentExceptionWhenLowerBoundIsLargerThanUpperBound");
        new Range(20, 10);
    }

    @Test
    public void shouldHaveProperErrorMessageWhenInstantiatingRangeObject() {
        try {
            System.out.println("shouldHaveProperErrorMessageWhenInstantiatingRangeObject");
            new Range(20, 10);
            fail("Exception wasn't thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("Lower bound is bigger than upperbound.", e.getMessage());
        }
    }
}
