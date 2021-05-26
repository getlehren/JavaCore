package ru.getman.java.core;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PhoneDirectory {

    private Map<String, Set<String>> directory = new HashMap<>();

    public Map<String, Set<String>> getDirectory() {
        return directory;
    }

    public void setDirectory(Map<String, Set<String>> directory) {
        this.directory = directory;
    }

    public void add(String name, String number) {
        if (directory.containsKey(name)) {
            Set<String> phone = directory.get(name);
            phone.add(number);
        } else {
            Set<String> phone = new HashSet<>();
            phone.add(number);
            directory.put(name, phone);
        }
    }

    public void get(String name) {
        System.out.println( name + " = " + directory.get(name));
    }
}
