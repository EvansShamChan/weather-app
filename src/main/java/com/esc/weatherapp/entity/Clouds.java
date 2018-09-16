package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clouds")
public class Clouds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;

    @Column(name = "all_int")
    private int all;
}