package com.esc.weatherapp.service;

import com.esc.weatherapp.dto.StatisticDto;

public interface WeatherService {
    String url = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";

    StatisticDto getWeatherStatisticByCity(String city, String fromDate, String toDate);
}
