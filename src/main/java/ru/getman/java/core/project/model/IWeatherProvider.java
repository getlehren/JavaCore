package ru.getman.java.core.project.model;

import ru.getman.java.core.project.entity.DailyForecast;

import java.io.IOException;
import java.util.List;

public interface IWeatherProvider {
    List<DailyForecast> getWeather(Period period) throws IOException;
}
