package by.aston.bakumenko.seventhTask;

public class Main {
    public static void main(String[] args) {
        try {
            int number = 0;
            long fact = Factorial.factorial(number);
            System.out.println("Факториал числа " + number + " равен " + fact);
            number = 5;
            fact = Factorial.factorial(number);
            System.out.println("Факториал числа " + number + " равен " + fact);
            number = 11;
            fact = Factorial.factorial(number);
            System.out.println("Факториал числа " + number + " равен " + fact);
            number = -1;
            fact = Factorial.factorial(number);
            System.out.println("Факториал числа " + number + " равен " + fact);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}