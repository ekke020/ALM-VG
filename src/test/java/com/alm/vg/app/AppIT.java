package com.alm.vg.app;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AppIT {

    private static SimpleCalc calc;

    @BeforeAll
    static void init() throws Exception {
        calc = new SimpleCalc();
        Optional<Field> field = Stream.of(calc.getClass().getDeclaredFields())
                .filter(f -> f.getName().equals("scanner"))
                .findFirst();
        field.get().setAccessible(true);
        field.get().set(calc, new Scanner(new File("src/test/resources/input.txt")));
        field.get().setAccessible(false);
    }

    @Test
    void integrationTest() {
        calc.run();
        assertEquals(2, calc.getValue1());
        assertEquals(2, calc.getValue2());
        assertEquals(3, calc.getResult());
    }

}
