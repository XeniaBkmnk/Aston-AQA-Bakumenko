package by.aston.bakumenko;

public class Factorial {
    public static long factorial(long n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число должно быть положительным!");
        }
        long result = 1;
        for (long i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}