package ru.getman.java.core;


public class Lesson2 {

    public int sumArrayElements(String[][] array) throws MyArraySizeException {
        int sum = 0;

        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Массив не 4х4");
        }
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                try {
                    sum = sum + tryParse(array, row, col);
                } catch (MyArrayDataException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }

    private int tryParse(String[][] arr, int row, int col) throws MyArrayDataException {
        try {
            return Integer.parseInt(arr[row][col]);
        } catch (NumberFormatException e) {
            throw new MyArrayDataException("В ячейке [" + row + "]" + "[" + col + "] " +
                    "лежит символ или текст вместо числа ");
        }
    }
}
