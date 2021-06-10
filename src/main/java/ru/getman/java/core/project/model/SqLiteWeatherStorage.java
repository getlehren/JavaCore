package ru.getman.java.core.project.model;


import ru.getman.java.core.project.GlobalState;
import ru.getman.java.core.project.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SqLiteWeatherStorage implements ILocalStorageProvider {

    static {
        try {
            GlobalState.getInstance()
                    .getConnection()
                    .createStatement()
                    .executeUpdate("CREATE TABLE IF NOT EXISTS weather (id INTEGER PRIMARY KEY AUTOINCREMENT, city TEXT, date TEXT, weatherDay TEXT, weatherNight TEXT, tempMin TEXT, tempMax TEXT)");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    @Override
    public void saveWeather(List<DailyForecast> dailyForecast) {
        try {
            Connection connection = GlobalState.getInstance().getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO weather (city, date, weatherDay, weatherNight, tempMin, tempMax) VALUES (?,?,?,?,?,?)");
            for (DailyForecast forecast : dailyForecast) {
                statement.setString(1, forecast.getCity());
                statement.setString(2, forecast.getDate());
                statement.setString(3, forecast.getDay().getIconPhrase());
                statement.setString(4, forecast.getNight().getIconPhrase());
                statement.setString(5, forecast.getTemperature().getMaximum().getValue().toString());
                statement.setString(6, forecast.getTemperature().getMinimum().getValue().toString());
                statement.addBatch();
            }
            statement.executeBatch();
            statement.close();
            GlobalState.getInstance().getConnection().setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<DailyForecast> getAllWeather() {
        List<DailyForecast> forecastList = new ArrayList<>();
        try {
            Connection connection = GlobalState.getInstance().getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
            while (resultSet.next()) {
                forecastList.add(new DailyForecast(
                        resultSet.getString(3),
                        new Temperature(new Minimum(resultSet.getDouble(6)), new Maximum(resultSet.getDouble(7))),
                        new Day(resultSet.getString(4)),
                        new Night(resultSet.getString(5)),
                        resultSet.getString(2)
                ));
            }
            statement.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return forecastList;
    }
}
