package com.mycompany.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue( true );
    }

    @Test
    public void shouldReturnFour() {
        assertEquals(4, App.add(2,2));
    }

    @Test
    public void shouldReturnTwo() {
        assertEquals(2, App.subtract(4,2));
    }
}
