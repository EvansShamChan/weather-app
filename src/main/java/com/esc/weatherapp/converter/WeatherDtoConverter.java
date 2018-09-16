package com.esc.weatherapp.converter;

import com.esc.weatherapp.dto.WeatherDto;
import com.esc.weatherapp.entity.WeatherDesc;
import org.springframework.stereotype.Component;

@Component
public class WeatherDtoConverter {

    public WeatherDto convertToWeatherDto(WeatherDesc weatherDesc) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setDate(weatherDesc.getDate());
        weatherDto.setHumidity(weatherDesc.getMain().getHumidity());
        weatherDto.setPressure(weatherDesc.getMain().getPressure());
        weatherDto.setTemp(weatherDesc.getMain().getTemp());
        weatherDto.setWind_deg(weatherDesc.getWind().getDeg());
        weatherDto.setWind_speed(weatherDesc.getWind().getSpeed());
        return weatherDto;
    }
}
