package ru.getman.java.core.awesome_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }
}
