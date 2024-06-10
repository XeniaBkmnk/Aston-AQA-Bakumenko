package by.aston.bakumenko;

import by.aston.bakumenko.seventhTask.Factorial;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    public void testFactorialOfOne() {
        assertEquals(1, Factorial.factorial(1));
    }

    @Test
    public void testFactorialOfFive() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void testFactorialOfTen() {
        assertEquals(3628800, Factorial.factorial(10));
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
    }
}