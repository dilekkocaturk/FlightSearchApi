package com.example.flightsearchapi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "flights")
@ApiModel(value = "Flight Model", description = "Flight Class Variables")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "ID of the Flight")
    private Long id;

    @Column(name = "departureAirport")
    @ApiModelProperty(value = "DepartureAirport of the Flight")
    private String departureAirport;
    @Column(name = "arrivalAirport")
    @ApiModelProperty(value = "ArrivalAirport of the Flight")
    private String arrivalAirport;
    @Column(name = "departureDateTime")
    @ApiModelProperty(value = "DepartureDateTime of the Flight")
    private Date departureDateTime;
    @Column(name = "returnDateTime")
    @ApiModelProperty(value = "ReturnDateTime of the Flight")
    private Date returnDateTime;
    @Column(name = "price")
    @ApiModelProperty(value = "Price of the Flight")
    private double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(Date departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public Date getReturnDateTime() {
        return returnDateTime;
    }

    public void setReturnDateTime(Date returnDateTime) {
        this.returnDateTime = returnDateTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Flight() {
    }

    public Flight(String departureAirport, String arrivalAirport, Date departureDateTime, Date returnDateTime, double price) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDateTime = departureDateTime;
        this.returnDateTime = returnDateTime;
        this.price = price;
    }

}