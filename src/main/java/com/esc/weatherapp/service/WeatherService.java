package com.esc.weatherapp.service;

import com.esc.weatherapp.dto.StatisticDto;
import com.esc.weatherapp.dto.WeatherDto;

import java.util.List;

public interface WeatherService {
    String URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s";
    String DATE_PERIOD_ERROR_TEXT = "You should enter both datepickers or none of them";

    StatisticDto getWeatherStatisticByCity(String city, String fromDate, String toDate);

    List<WeatherDto> getWeatherInfo(String city);
}
