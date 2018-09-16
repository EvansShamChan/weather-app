package com.esc.weatherapp.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class WeatherDto {
    private Date date;
    private Double temp;
    private Integer humidity;
    private Integer pressure;
    private Integer wind_deg;
    private Integer wind_speed;
}
