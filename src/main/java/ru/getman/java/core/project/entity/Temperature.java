package ru.getman.java.core.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty(value = "Minimum")
    private Minimum minimum;
    @JsonProperty(value = "Maximum")
    private Maximum maximum;

    public Temperature(Minimum minimum, Maximum maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Temperature() {
    }

    public Minimum getMinimum() {
        return minimum;
    }

    public void setMinimum(Minimum minimum) {
        this.minimum = minimum;
    }

    public Maximum getMaximum() {
        return maximum;
    }

    public void setMaximum(Maximum maximum) {
        this.maximum = maximum;
    }
}
