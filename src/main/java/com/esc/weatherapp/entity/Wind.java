package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "wind")
public class Wind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "speed")
    private int speed;

    @Column(name = "deg")
    private int deg;

    @Column(name = "gust")
    private String gust;
}
