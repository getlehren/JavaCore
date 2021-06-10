package ru.getman.java.core.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Day {
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;

    public Day(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public Day() {
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }
}
