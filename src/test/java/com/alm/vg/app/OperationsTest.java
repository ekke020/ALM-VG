package com.alm.vg.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    public void shouldReturnFour() {
        assertEquals(4, Operations.add(2, 2));
    }

    @Test
    public void shouldReturnTwo() {
        assertEquals(2, Operations.subtract(4, 2));
    }

}