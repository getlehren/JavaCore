package ru.getman.java.core.project.model;


import ru.getman.java.core.project.entity.DailyForecast;

import java.io.IOException;
import java.util.List;

public class WeatherRepository implements IWeatherRepository {

    IWeatherProvider apiWeatherProvider = new AccuWeatherProvider();
    ILocalStorageProvider localStorageProvider = new SqLiteWeatherStorage();

    @Override
    public List<DailyForecast> fetchWeatherFromApi(Period period) {
        List<DailyForecast> weather = null;
        try {
            weather = apiWeatherProvider.getWeather(period);
            if (weather != null) {
                saveWeatherInfoInDb(weather);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }

    @Override
    public List<DailyForecast> readWeatherFromDb() {
        List<DailyForecast> dbResult = localStorageProvider.getAllWeather();
        for (DailyForecast forecast : dbResult) {
            System.out.println(forecast);
        }
        return dbResult;
    }

    @Override
    public void saveWeatherInfoInDb(List<DailyForecast> dailyForecasts) {
        localStorageProvider.saveWeather(dailyForecasts);
    }
}
