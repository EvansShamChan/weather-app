package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sys")
public class Sys {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "type")
    private int type;

    @Column(name = "message")
    private double message;

    @Column(name = "country")
    private String country;

    @Column(name = "sunrise")
    private int sunrise;

    @Column(name = "sunset")
    private int sunset;
}
