package com.esc.weatherapp.dto;

import lombok.Data;

@Data
public class StatisticDto {
    private Integer min;
    private Integer max;
    private Integer avg;
    private String city;
}
