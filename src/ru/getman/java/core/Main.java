package ru.getman.java.core;

public class Main {

    public static void main(String[] args) {

        String[][] array =
                {{"1","mew","1","1"},
                {"1","1","qwe","1"},
                {"1","mnm","1","1"},
              //  {"1","t","1","1"}, //для проверки массива 4х4
                {"1","asd","1","fff"}};
        Lesson2 homework = new Lesson2();


        try {
            System.out.println(homework.sumArrayElements(array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
