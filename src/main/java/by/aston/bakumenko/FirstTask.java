package by.aston.bakumenko;

public class FirstTask {
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign() {
        int a = 22;
        int b = -1;

        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        } else System.out.println("Сумма отрицательная");
    }

    public static void printColor() {
        int value = 101;
        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Желтый");
        } else
            System.out.println("Зеленый");
    }

    public static void compareNumbers() {
        int a = 46;
        int b = 0;
        if (a >= b) {
            System.out.println("a>=b");
        } else System.out.println("a<b");
    }

    public static boolean checkBoolean() {
        int a = 11;
        int b = -1;

        return a + b >= 10 && a + b <= 20;
    }

    public static boolean positiveOrNegativeNumber(int number) {
        return number >= 0 && number < 0;
    }

    public static boolean isNegative(int number) {
        return number < 0 && number > 0;
    }

    public static void outputArgument(String x, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(x);
        }
    }

    public static boolean booleanLeapYear() {
        int year = 2024;
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void replaceValue() {
        int[] array = {1, 1, 1, 0, 0, 1, 1, 0};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] == 0 ? 1 : 0;
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void fillInArrayDifferentNumber() {
        int[] array = new int[100];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void multiplyNumberArray() {
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void createSquareArray() {
        int size = 5;
        int[][] array = new int[size][size];

        for (int i = 0; i < size; i++) {
            array[i][i] = 1;
            array[i][size - 1 - i] = 1;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printArrayOfArgument(int initialValue, int len) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
            System.out.print(array[i] + " ");
        }
    }

}