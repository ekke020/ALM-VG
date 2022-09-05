package com.alm.vg.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void shouldReturnFour() {
        assertEquals(4, App.add(2, 2));
    }

    @Test
    public void shouldReturnTwo() {
        assertEquals(2, App.subtract(4, 2));
    }
}
