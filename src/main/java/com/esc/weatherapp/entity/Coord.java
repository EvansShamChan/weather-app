package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "coord")
public class Coord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "lon")
    private double lon;

    @Column(name = "lat")
    private double lat;
}
