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
            for (String header : headers) {
                out.write(header + ";");
            }
            out.write("\n");
        }
    }

    public void addDataToFile(int[] line, String filename) throws IOException {
        fileLoader(filename);
        if (headers == null) {
            headers = new String[line.length];
            for (int i = 0; i < headers.length; i++) {
                headers[i] = "Header " + i;
            }
            createNewDocument("data");
        }
        if (headers.length >= line.length) {
            try (BufferedWriter out = new BufferedWriter(new FileWriter(filename + ".csv", true))) {
                for (int val : line) {
                    out.write(val + ";");
                }
                out.write("\n");
            }
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
}

