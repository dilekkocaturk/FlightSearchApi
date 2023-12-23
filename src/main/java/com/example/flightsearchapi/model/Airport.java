package com.example.flightsearchapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "airports")
@ApiModel(value = "Airport Model", description = "Airport Class Variables")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID of the Airport")
    private Long id;

    @Column(name = "city")
    @ApiModelProperty(value = "City of the Airport")
    private String city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Airport() {
    }
    public Airport(String city) {
        this.city = city;
    }
}