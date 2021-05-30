package ru.getman.java.core;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        AppData appdata = new AppData();
        appdata.createNewDocument("data");
        appdata.addDataToFile(100, 200, 123, "data");
        appdata.addDataToFile(300, 400, 500, "data");
        appdata.addDataToFile(500, 200, 153, "data");
        appdata.addDataToFile(200, 200, 540, "data");
        appdata.addDataToFile(300, 380, 123, "data");
        appdata.addDataToFile(900, 660, 580, "data");
        appdata.addDataToFile(700, 120, 183, "data");
        appdata.addDataToFile(800, 500, 590, "data");
        appdata.fileLoader("data");
        appdata.printFile();
    }
}
