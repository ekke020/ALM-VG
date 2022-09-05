package com.alm.vg.app;

public class Operations {

    public enum Operation {
        ADDITION, SUBTRACTION
    }

    public static int add(int x, int y) {
        return x + y;
    }

    public static int subtract(int x, int y) {
        return x - y;
    }
}
