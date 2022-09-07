package depricated;

import depricated.Operations;
import depricated.SimpleCalc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalcTest {

    private SimpleCalc calc;

    @BeforeEach
    void init() throws Exception {
        calc = new SimpleCalc();
        Field value1 = calc.getClass().getDeclaredField("value1");
        value1.setAccessible(true);
        value1.set(calc, 2);
        Field value2 = calc.getClass().getDeclaredField("value2");
        value2.setAccessible(true);
        value2.set(calc, 2);
    }

    @Test
    void requestTest() {

    }

    @Test
    void calculateResultTest() {
        assertEquals(4, calc.calculateResult());
        assertEquals(calc.getState(), SimpleCalc.State.PRINT);
    }

    @Test
    void chooseOperationTest() {
        calc.chooseOperation("1");
        assertEquals(Operations.Operation.ADDITION, calc.getOperation());
        calc.chooseOperation("2");
        assertEquals(Operations.Operation.SUBTRACTION, calc.getOperation());
    }
}