package ru.getman.java.core;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AppData {

    private String[] headers;
    private int[][] data;

    public void createNewDocument(String name) throws IOException {

        File doc = new File(name + ".csv");
        doc.createNewFile();
        try (BufferedWriter out = new BufferedWriter(new FileWriter(doc))) {
            out.write("SideOne;SideTwo;SideThree");
        }
    }

    public void addDataToFile(int sideOne, int sideTwo, int sideThree, String filename) throws IOException {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(filename + ".csv", true))) {
            out.write("\n" + sideOne + ";" + sideTwo + ";" + sideThree);
        }
    }

    public void fileLoader(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename + ".csv"))) {
            String line = null;
            line = reader.readLine();
            headers = line.split("\\;");
            List<String> lines = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            data = new int[lines.size()][headers.length];
            for (int i = 0; i < data.length; i++) {
                String[] temp = lines.get(i).split("\\;");
                int[] tempInt = new int[headers.length];
                for (int j = 0; j < temp.length; j++) {
                    tempInt[j] = Integer.parseInt(temp[j]);
                }
                data[i] = tempInt;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printFile(){
        for (String head:headers) {
            System.out.print(head + ";");
        }
        System.out.println("");
        for (int[] a : data) {
            for (int i : a) {
                System.out.print(i + ";");
            }
            System.out.println("");
        }
    }
}

