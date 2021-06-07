package ru.getman.java.core.awesome_project;

import ru.getman.java.core.awesome_project.view.IUserInterface;
import ru.getman.java.core.awesome_project.view.UserInterface;

public class Main {

    public static void main(String[] args) {
        IUserInterface userInterface = new UserInterface();
        userInterface.showUI();
    }
}
