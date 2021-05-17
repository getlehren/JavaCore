package ru.getman.java.core;

public class Main {

    public static void main(String[] args) {


        Obstacle[] obstacles = {new Wall(2), new Track(500)};
        Athlete[] athletes = {new Cat("Barsik", 500, 2),
                new Cat("Vaskya", 200, 1),
                new Human("Kostik", 300, 3),
                new Human("Petr", 100, 100),
                new Robot("Vedroid",200, 2),
                new Robot("C3PO", 400, 400)};

        for (int i = 0; i < athletes.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                athletes[i].tryToPass(obstacles[j]);
            }
        }
    }
}
