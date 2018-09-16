package com.esc.weatherapp.repository;

import com.esc.weatherapp.entity.WeatherDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherDesc, Long> {

    @Query(value = "select min(temp) from weather_desc join main on weather_desc.main_id = main.id " +
            "where name = :city and weather_date >= :from and weather_date <= :to", nativeQuery = true)
    Integer getMinTempValue(@Param("city") String city, @Param("from") Date fromDate, @Param("to") Date toDate);

    @Query(value = "select max(temp) from weather_desc join main on weather_desc.main_id = main.id " +
            "where name = :city and weather_date >= :from and weather_date <= :to", nativeQuery = true)
    Integer getMaxTempValue(@Param("city") String city, @Param("from") Date fromDate, @Param("to") Date toDate);

    @Query(value = "select avg(temp) from weather_desc join main on weather_desc.main_id = main.id " +
            "where name = :city and weather_date >= :from and weather_date <= :to", nativeQuery = true)
    Integer getAvgTempValue(@Param("city") String city, @Param("from") Date fromDate, @Param("to") Date toDate);

    @Query(value = "select min(temp) from weather_desc join main on weather_desc.main_id = main.id " +
            "where name = :city and weather_date >= current_date - interval '7 days' and weather_date <= current_date",
            nativeQuery = true)
    Integer getWeekMinTempValue(@Param("city") String city);

    @Query(value = "select max(temp) from weather_desc join main on weather_desc.main_id = main.id " +
            "where name = :city and weather_date >= current_date - interval '7 days' and weather_date <= current_date",
            nativeQuery = true)
    Integer getWeekMaxTempValue(@Param("city") String city);

    @Query(value = "select avg(temp) from weather_desc join main on weather_desc.main_id = main.id " +
            "where name = :city and weather_date >= current_date - interval '7 days' and weather_date <= current_date",
            nativeQuery = true)
    Integer getWeekAvgTempValue(@Param("city") String city);

    List<WeatherDesc> getAllByName(String name);
}
