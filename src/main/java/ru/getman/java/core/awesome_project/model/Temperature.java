package ru.getman.java.core.awesome_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {
    @JsonProperty(value = "Minimum")
    private Minimum max;
    @JsonProperty(value = "Maximum")
    private Maximum min;

    public Minimum getMax() {
        return max;
    }

    public void setMax(Minimum max) {
        this.max = max;
    }

    public Maximum getMin() {
        return min;
    }

    public void setMin(Maximum min) {
        this.min = min;
    }
}
