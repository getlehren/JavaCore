package ru.getman.java.core;

public class Swap {

    public <T> T[] swapElements(T[] arr, int first, int second) {
        T temp;
        temp = arr[second];
        arr[second] = arr[first];
        arr[first] = temp;
        return arr;
    }

}
