package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.service.AirportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
@Api(value = "Airport API Documentation")
public class AirportController {
    @Autowired
    private AirportService airportService;

    @GetMapping
    @ApiOperation(value = "Get all airports", notes = "Get a list of all airports")
    public List<Airport> getAllAirports() {
        return airportService.getAllAirports();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get airport by ID", notes = "Get airport information by providing its ID")
    public Airport getAirportById(@PathVariable @ApiParam(value = "ID of the airport") Long id) {
        return airportService.getAirportById(id);
    }

    @PostMapping
    @ApiOperation(value = "Save a new airport", notes = "Save a new airport to the system")
    public Airport saveAirport(@RequestBody Airport airport) {
        return airportService.saveAirport(airport);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete airport by ID", notes = "Delete an airport by providing its ID")
    public void deleteAirport(@PathVariable @ApiParam(value = "ID of the airport") Long id) {
        airportService.deleteAirport(id);
    }
}