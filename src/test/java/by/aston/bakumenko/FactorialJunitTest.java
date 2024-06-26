package by.aston.bakumenko;

import by.aston.bakumenko.seventhTask.Factorial;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertThrows;

public class FactorialJunitTest {
    @Test
    public void testFactorialOfOne() {
        Assert.assertEquals(1, Factorial.factorial(1));
    }

    @Test
    public void testFactorialOfFive() {
        Assert.assertEquals(120, Factorial.factorial(5));
    }

    @Test
    public void testFactorialOfTen() {
        Assert.assertEquals(3628800, Factorial.factorial(10));
    }

    @Test
    public void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
    }
}