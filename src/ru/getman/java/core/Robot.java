package ru.getman.java.core;

public class Robot implements Athlete {

    private int endurance;
    private int jumpHeight;
    private String name;

    public Robot(String name, int endurance, int jumpHeight) {
        this.name = name;
        this.endurance = endurance;
        this.jumpHeight = jumpHeight;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getJumpHeight() {
        return jumpHeight;
    }

    public String getName() {
        return name;
    }

    @Override
    public void jump() {
        System.out.println("Robot " + name + " is jumping");
    }

    @Override
    public void run() {
        System.out.println("Robot " + name + " is running");
    }

    @Override
    public void tryToPass(Obstacle obstacle) {
        if (obstacle instanceof Wall) {
            if (((Wall) obstacle).getHeight() <= jumpHeight) {
                jump();
            } else {
                System.out.println("Robot " + name +  " failed to jump, wall is to height");
            }
        } else {
            if (((Track) obstacle).getLength() <= endurance) {
                run();
            } else {
                System.out.println("Robot " + name + " failed to run, he is tired");
            }
        }
    }
}
