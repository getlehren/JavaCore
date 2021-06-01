package ru.getman.java.core;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AppData appdata = new AppData();

        appdata.addDataToFile(new int[] {1, 2, 3, 9, 5, 6, 7, 8, 9, 0}, "data");
    }
}
