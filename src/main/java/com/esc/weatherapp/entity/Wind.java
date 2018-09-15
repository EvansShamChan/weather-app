package com.esc.weatherapp.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "name")
public class Wind {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "speed")
    private Integer speed;

    @Column(name = "deg")
    private Integer deg;
}
