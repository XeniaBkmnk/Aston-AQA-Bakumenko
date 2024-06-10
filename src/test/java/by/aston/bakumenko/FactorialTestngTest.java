package by.aston.bakumenko;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FactorialTestngTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void testFactorialOfEleven() {
        assertEquals(39916800, Factorial.factorial(11));
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumber() {
        Factorial.factorial(-1);
    }
}