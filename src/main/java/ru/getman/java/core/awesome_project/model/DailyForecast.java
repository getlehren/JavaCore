package ru.getman.java.core.awesome_project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.getman.java.core.awesome_project.GlobalState;

public class DailyForecast {
    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Temperature")
    private Temperature temperature;
    @JsonProperty(value = "Day")
    private Day day;
    @JsonProperty(value = "Night")
    private Night night;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Night getNight() {
        return night;
    }

    public void setNight(Night night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "В городе " + GlobalState.getInstance().getSelectedCity() + " на дату: " + date
                + "\nОжидается: \nДнем: " + day.getIconPhrase()
                + "\nНочью: " + night.getIconPhrase()
                + "\nТемпература от " + temperature.getMin().getValue() + " до " + temperature.getMax().getValue() + "\n";
    }
}