package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "main")
public class Main {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "temp")
    private double temp;

    @Column(name = "pressure")
    private int pressure;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "temp_min")
    private double temp_min;

    @Column(name = "temp_max")
    private double temp_max;
}
