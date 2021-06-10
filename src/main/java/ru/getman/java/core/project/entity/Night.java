package ru.getman.java.core.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Night {
    @JsonProperty(value = "IconPhrase")
    private String iconPhrase;

    public Night(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }

    public Night() {
    }

    public String getIconPhrase() {
        return iconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        this.iconPhrase = iconPhrase;
    }
}
