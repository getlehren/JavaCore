package ru.getman.java.core.project.model;


import ru.getman.java.core.project.entity.DailyForecast;

import java.util.List;

public interface ILocalStorageProvider {

    void saveWeather(List<DailyForecast> dailyForecast);

    List<DailyForecast> getAllWeather();

}
