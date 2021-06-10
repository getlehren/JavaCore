package ru.getman.java.core.project.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.getman.java.core.project.GlobalState;

public class DailyForecast {
    @JsonProperty(value = "Date")
    private String date;
    @JsonProperty(value = "Temperature")
    private Temperature temperature;
    @JsonProperty(value = "Day")
    private Day day;
    @JsonProperty(value = "Night")
    private Night night;

    private String city = GlobalState.getInstance().getSelectedCity();

    public DailyForecast(String date, Temperature temperature, Day day, Night night, String city) {
        this.date = date;
        this.temperature = temperature;
        this.day = day;
        this.night = night;
        this.city = city;
    }

    public DailyForecast() {
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "В городе " + city + " на дату: " + date
                + "\nОжидается: \nДнем: " + day.getIconPhrase()
                + "\nНочью: " + night.getIconPhrase()
                + "\nТемпература от " + temperature.getMaximum().getValue() + " до " + temperature.getMinimum().getValue() + "\n";
    }
}