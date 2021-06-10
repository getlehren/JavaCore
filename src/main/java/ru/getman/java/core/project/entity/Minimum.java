package ru.getman.java.core.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Minimum {
    @JsonProperty(value = "Value")
    private Double value;

    public Minimum(Double value) {
        this.value = value;
    }

    public Minimum() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
