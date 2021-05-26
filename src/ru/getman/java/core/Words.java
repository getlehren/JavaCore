package ru.getman.java.core;

import java.util.*;

public class Words {

    public void returnUnique(String[] word) {

        List<String> myList = Arrays.asList(word);

        Set<String> srtSet = new HashSet<>(myList);
        System.out.println(srtSet);
    }

    public void count(String[] words) {
        List<String> myList = Arrays.asList(words);
        Map<String, Integer> result = new HashMap<>();
        int count = 0;
        String tempWord;

        for (String word : myList) {
            tempWord = word;
            for (int i = 0; i < myList.size(); i++) {
                if (myList.get(i).equals(tempWord)) {
                    count++;
                }
            }
            result.put(tempWord, count);
            tempWord = "";
            count = 0;
        }
        System.out.println(result);
    }
}
