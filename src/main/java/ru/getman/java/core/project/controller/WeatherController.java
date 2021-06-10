package ru.getman.java.core.project.controller;

import ru.getman.java.core.project.entity.DailyForecast;
import ru.getman.java.core.project.model.IWeatherRepository;
import ru.getman.java.core.project.model.Period;
import ru.getman.java.core.project.model.WeatherRepository;

import java.util.List;

public class WeatherController implements IWeatherController {

    private IWeatherRepository weatherRepository = new WeatherRepository();

    @Override
    public void onUserInput(int command) {

        switch (command) {
            case 1:
                getCurrentWeather(Period.NOW);
                break;
            case 2:
                getCurrentWeather(Period.FIVE_DAYS);
                System.exit(1);
            case 3:
                getAllFromDB();
                break;
            default:
                System.out.println("НЕТ ТАКОЙ КОМАНДЫ!");
                System.exit(1);
        }
    }

    private void getAllFromDB() {
        weatherRepository.readWeatherFromDb();
    }

    private void getCurrentWeather(Period period) {
        List<DailyForecast> forecastList;
        forecastList = weatherRepository.fetchWeatherFromApi(period);
        for (DailyForecast forecast : forecastList) {
            System.out.println(forecast);
        }
    }
}
