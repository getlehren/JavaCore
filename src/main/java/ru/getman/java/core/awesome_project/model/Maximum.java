package ru.getman.java.core.awesome_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
    @JsonProperty(value = "Value")
    private Double value;

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
