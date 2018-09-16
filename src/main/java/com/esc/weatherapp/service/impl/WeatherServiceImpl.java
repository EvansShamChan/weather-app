package com.esc.weatherapp.service.impl;

import com.esc.weatherapp.converter.StringToSqlDateConverter;
import com.esc.weatherapp.converter.UrlToOjectConverter;
import com.esc.weatherapp.converter.WeatherDtoConverter;
import com.esc.weatherapp.dto.StatisticDto;
import com.esc.weatherapp.dto.WeatherDto;
import com.esc.weatherapp.entity.WeatherDesc;
import com.esc.weatherapp.exception.DatePeriodException;
import com.esc.weatherapp.repository.WeatherRepository;
import com.esc.weatherapp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${all_available_countries_name}")
    private String[] cities;

    @Value("${openweathermap_apikey}")
    private String api_key;

    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public StatisticDto getWeatherStatisticByCity(String city, String fromDate, String toDate) {
        if (fromDate.isEmpty() && toDate.isEmpty()) {
            return getWeekStatistic(city);
        } else if(fromDate.isEmpty() || toDate.isEmpty()) {
            throw new DatePeriodException(DATE_PERIOD_ERROR_TEXT);
        } else {
            return getStatisticByDatePeriod(city, fromDate, toDate);
        }
    }

    private StatisticDto getStatisticByDatePeriod(String city, String fromDate, String toDate) {
        Date newFromDate = StringToSqlDateConverter.getSqlDate(fromDate);
        Date newToDate = StringToSqlDateConverter.getSqlDate(toDate);
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setCity(city);
        statisticDto.setMin(weatherRepository.getMinTempValue(city, newFromDate, newToDate));
        statisticDto.setMax(weatherRepository.getMaxTempValue(city, newFromDate, newToDate));
        statisticDto.setAvg(weatherRepository.getAvgTempValue(city, newFromDate, newToDate));
        return statisticDto;
    }

    private StatisticDto getWeekStatistic(String city) {
        StatisticDto statisticDto = new StatisticDto();
        statisticDto.setCity(city);
        statisticDto.setMax(weatherRepository.getWeekMaxTempValue(city));
        statisticDto.setMin(weatherRepository.getWeekMinTempValue(city));
        statisticDto.setAvg(weatherRepository.getWeekAvgTempValue(city));
        return statisticDto;
    }

    public List<WeatherDto> getWeatherInfo(String city) {
        List<WeatherDesc> allByName = weatherRepository.getAllByName(city);
        List<WeatherDto> dto = allByName.stream().map(m -> WeatherDtoConverter.convertToWeatherDto(m))
                .collect(Collectors.toList());
        return dto;
    }

    @Scheduled(fixedRate = 3600000) // 1 hour
    public void saveCurrentWeather() throws IOException {
        for (String city : cities) {
            WeatherDesc objectByUrl = UrlToOjectConverter.getObjectByUrl(new URL(String.format(URL, city, api_key)));
            objectByUrl.setDate(new Date(System.currentTimeMillis()));
            weatherRepository.save(objectByUrl);
        }
    }
}
