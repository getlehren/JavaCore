package ru.getman.java.core.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Maximum {
    @JsonProperty(value = "Value")
    private Double value;

    public Maximum(Double value) {
        this.value = value;
    }

    public Maximum() {
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
