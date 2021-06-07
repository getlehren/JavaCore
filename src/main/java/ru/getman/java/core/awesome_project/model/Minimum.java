package ru.getman.java.core.awesome_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Minimum {
    @JsonProperty(value = "Value")
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
