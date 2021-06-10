package ru.getman.java.core.project.model;

import ru.getman.java.core.project.entity.DailyForecast;

import java.util.List;

public interface IWeatherRepository {

    List<DailyForecast> fetchWeatherFromApi(Period period);

    List<DailyForecast> readWeatherFromDb();

    void saveWeatherInfoInDb(List<DailyForecast> weatherObjects);
}
