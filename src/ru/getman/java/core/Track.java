package ru.getman.java.core;

public class Track extends Obstacle {
    private int length;

    public Track(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

}
