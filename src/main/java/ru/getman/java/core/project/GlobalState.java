package ru.getman.java.core.project;

import java.sql.Connection;

public final class GlobalState {

    private static GlobalState INSTANCE;
    private String selectedCity = null;
    public final static String API_KEY = "CA5kztbUGZ4FjA5Rfb28i1xWvRKAr8n1";
    public final String DB_NAME = "application.db";

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    private GlobalState() {
    }

    public static GlobalState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new GlobalState();
        }
        return INSTANCE;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }
}
