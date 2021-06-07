package ru.getman.java.core.awesome_project.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import ru.getman.java.core.awesome_project.GlobalState;

import java.io.IOException;
import java.util.List;

public class AccuWeatherProvider implements IWeatherProvider {

    private final String BASE_HOST = "dataservice.accuweather.com";
    private final String VERSION = "v1";
    private final static String FORECAST = "forecasts";
    private final static String FORECAST_FIVE_DAY = "5day";
    private final static String FORECAST_ONE_DAY = "1day";
    private final static String FORECAST_TYPE = "daily";
    private final static String LANGUAGE_RU = "ru-ru";
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Period period) {
        String key = detectCityKeyByName();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(VERSION)
                .addPathSegment(FORECAST_TYPE)
                .build();

        if (period.equals(Period.NOW)) {
            url = url.newBuilder().addPathSegment(FORECAST_ONE_DAY).build();
        } else if (period.equals(Period.FIVE_DAYS)) {
            url = url.newBuilder().addPathSegment(FORECAST_FIVE_DAY).build();
        }

        url = url.newBuilder()
                .addPathSegment(key)
                .addQueryParameter("apikey", GlobalState.getInstance().API_KEY)
                .addQueryParameter("language", LANGUAGE_RU)
                .addQueryParameter("details", "false")
                .addQueryParameter("metric", "true")
                .build();

        Request request = getRequest(url);

        try {
            fancyResponsePrint(request);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void fancyResponsePrint(Request request) throws IOException {
        Response response = okHttpClient.newCall(request).execute();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String jsonResponse = response.body().string();
        JsonNode jsonNode = objectMapper.readTree(jsonResponse).at("/DailyForecasts");

        List<DailyForecast> forecastList =
                objectMapper.readValue(jsonNode.toString(), new TypeReference<List<DailyForecast>>() {
                });

        for (DailyForecast forecast : forecastList) {
            System.out.println(forecast);
        }
    }

    @NotNull
    private Request getRequest(HttpUrl url) {
        return new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();
    }
    //http://dataservice.accuweather.com/forecasts/v1/daily/1day/{locationKey}

    private String detectCityKeyByName() {
        String selectedCity = GlobalState.getInstance().getSelectedCity();

        HttpUrl detectLocationURL = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment("locations")
                .addPathSegment(VERSION)
                .addPathSegment("cities")
                .addPathSegment("search")
                .addQueryParameter("apikey", GlobalState.getInstance().API_KEY)
                .addQueryParameter("q", selectedCity)
                .build();

        Request request = getRequest(detectLocationURL);

        Response locationResponse = null;
        try {
            locationResponse = okHttpClient.newCall(request).execute();

            if (!locationResponse.isSuccessful()) {
                throw new RuntimeException("Сервер ответил " + locationResponse.code());
            }

            String jsonResponse = locationResponse.body().string();

            if (objectMapper.readTree(jsonResponse).size() > 0) {
                String code = objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
                String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
                String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();

                System.out.printf("Найден город %s в стране %s, код - %s\n", cityName, countryName, code);
                return code;
            } else {
                throw new RuntimeException(selectedCity + "- такой город не найден");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
