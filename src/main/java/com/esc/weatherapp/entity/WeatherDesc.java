package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Entity
public class WeatherDesc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "coord_id")
    private Coord coord;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "weather_id")
    private List<Weather> weather;

    @Column(name = "base")
    private String base;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "main_id")
    private Main main;

    @Column(name = "visibility")
    private int visibility;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wind_id")
    private Wind wind;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clouds_id")
    private Clouds clouds;

    @Column(name = "dt")
    private int dt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sys_id")
    private Sys sys;

    @Column(name = "name")
    private String name;

    @Column(name = "cod")
    private int cod;

    @Column(name = "weather_date")
    private Date date;

}