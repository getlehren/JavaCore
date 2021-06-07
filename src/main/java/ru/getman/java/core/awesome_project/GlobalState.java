package ru.getman.java.core.awesome_project;

public final class GlobalState {

    private static GlobalState INSTANCE;
    private String selectedCity = null;
    public final static String API_KEY = "qDZyXoe2DBvZ9Dh83ztlOyiHJx6b5zea";


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
