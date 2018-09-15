package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "weather")
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "date")
    private Date date;

    @Column(name = "humidity")
    private Integer humidity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wind_id")
    private Wind wind;

    @Column(name = "clouds")
    private Integer clouds;

    @Column(name = "temperature")
    private Integer temperature;
}
