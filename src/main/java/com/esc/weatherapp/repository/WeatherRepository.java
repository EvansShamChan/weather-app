package com.esc.weatherapp.repository;

import com.esc.weatherapp.entity.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Long> {
}
