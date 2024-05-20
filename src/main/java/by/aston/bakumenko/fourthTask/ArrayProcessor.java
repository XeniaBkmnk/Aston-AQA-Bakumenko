package by.aston.bakumenko.fourthTask;

import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {
    public int processArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int columns = array[0].length;
        int rows = array.length;
        if (rows != 4 || columns != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4");
        }
        for (int i = 0; i < rows; i++) {
            if (array[i].length != columns) {
                throw new MyArraySizeException("Размеры строк массива должны быть одинаковыми");
            }
        }
        int sum = 0;
        List<String> errorMessages = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    errorMessages.add("Неверные данные в ячейке [" + i + "][" + j + "]");
                }
            }
            if (!errorMessages.isEmpty()) {
                throw new MyArrayDataException(String.join(", ", errorMessages));
            }
        }
        return sum;
    }
}