package ru.getman.java.core;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Weather {
    private final static String API_KEY = "Uw9EPBAx9AH8rIpgqHCfMBRMfxhMUjYD";
    private final static String HOST = "dataservice.accuweather.com";
    private final static String API_VERSION = "v1";
    private final static String FORECAST = "forecasts";
    private final static String FORECAST_PERIOD = "5day";
    private final static String LOCATION_KEY = "474212_PC";
    private final static String FORECAST_TYPE = "daily";
    private final static String LANGUAGE_RU = "ru-ru";

    private String response;

    private OkHttpClient client = new OkHttpClient();

//    http://{{api} or {{apidev}}.accuweather.com/forecasts/{version}/daily/5day/{locationKey}{.{format}}
//     ?apikey={your key}{&language={language code}}{&details={true or false}}{&metric={true or false}}

    private HttpUrl url = new HttpUrl.Builder()
            .scheme("http")
            .host(HOST)
            .addPathSegment(FORECAST)
            .addPathSegment(API_VERSION)
            .addPathSegment(FORECAST_TYPE)
            .addPathSegment(FORECAST_PERIOD)
            .addPathSegment(LOCATION_KEY)
            .addQueryParameter("apikey", API_KEY)
            .addQueryParameter("language", LANGUAGE_RU)
            .addQueryParameter("details", "false")
            .addQueryParameter("metric", "true")
            .build();

    private Request request = new Request.Builder()
            .addHeader("accept", "application/json")
            .url(url)
            .build();


    public void printFiveDayForecast() {
        try {
            response = client.newCall(request).execute().body().string();
            System.out.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
