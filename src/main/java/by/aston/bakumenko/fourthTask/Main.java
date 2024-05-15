package by.aston.bakumenko.fourthTask;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8",},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            ArrayProcessor processor = new ArrayProcessor();
            int sum = processor.processArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}