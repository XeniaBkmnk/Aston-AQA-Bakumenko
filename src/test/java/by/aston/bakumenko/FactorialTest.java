package by.aston.bakumenko;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTest {
    @Test(description = "Факториал 0 должен быть 1")
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test(description = "Факториал 5 должен быть 120")
    public void testFactorialOfFive() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test(description = "Факториал 11 должен быть 39916800")
    public void testFactorialOfEleven() {
        assertEquals(39916800, Factorial.factorial(11));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Factorial.factorial(-1);
    }
}