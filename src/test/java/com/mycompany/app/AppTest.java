package com.mycompany.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    // Given test case from starter code
    @Test
    public void testAppConstructor() {
        int[] samplenewList = new int[]{1}; // Just a dummy list, not really needed.
        App app1 = new App(samplenewList);
        App app2 = new App(samplenewList);
        assertEquals(app1.getMessage(), app2.getMessage());
    }

    // Given test case from starter code
    @Test
    public void testAppMessage()
    {
        int[] samplenewList = new int[]{1}; // Just a dummy list, not really needed.
        App app = new App(samplenewList);
        assertEquals("Hello World!", app.getMessage());
    }

    // New test cases for method: containsDuplicates
    @Test
    public void emptyArrayCase(){
        int[] samplenewList = new int[]{1};
        App app = new App(samplenewList);
        boolean expectedValue = false;
        boolean actualValue = app.containsDuplicates();
        assertEquals(expectedValue, actualValue);
        
    }

    // New test cases for method: containsDuplicates
    @Test
    public void sampleDuplicatePassing1(){
        int[] samplenewList = new int[]{1,2,9,1,0,8,7};
        App app = new App(samplenewList);
        boolean expectedValue = true;
        boolean actualValue = app.containsDuplicates();
        assertEquals(expectedValue, actualValue);

    }

    // New test cases for method: containsDuplicates
    @Test
    public void sampleDuplicateFails1(){
        int[] samplenewList = new int[]{1,2,9,20,0,8,7};
        App app = new App(samplenewList);
        boolean expectedValue = false; // false is the correct choice. set to true to deliberately make test fail
        boolean actualValue = app.containsDuplicates();
        assertEquals(expectedValue, actualValue);

    }
}
