package ru.getman.java.core.awesome_project.controller;

import ru.getman.java.core.awesome_project.model.AccuWeatherProvider;
import ru.getman.java.core.awesome_project.model.IWeatherProvider;
import ru.getman.java.core.awesome_project.model.Period;

public class WeatherController implements IWeatherController {

    private IWeatherProvider weatherProvider = new AccuWeatherProvider();

    @Override
    public void onUserInput(int command) {

        switch (command) {
            case 1:
                getCurrentWeather(Period.NOW);
                break;
            case 2:
                getCurrentWeather(Period.FIVE_DAYS);
                System.exit(1);
            default:
                System.out.println("НЕТ ТАКОЙ КОМАНДЫ!");
                System.exit(1);
        }
    }

    private void getCurrentWeather(Period period) {
        weatherProvider.getWeather(period);
    }
}
