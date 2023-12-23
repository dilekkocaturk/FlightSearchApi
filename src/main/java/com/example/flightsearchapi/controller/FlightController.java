package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.Flight;
import com.example.flightsearchapi.service.FlightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@Api(value = "Flight API Documentation")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    @ApiOperation(value = "Get all flights", notes = "Get a list of all flights")
    public List<Flight> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get flight by ID", notes = "Get flight information by providing its ID")
    public Flight getFlightById(@PathVariable @ApiParam(value = "ID of the flight")Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping
    @ApiOperation(value = "Save a new flight", notes = "Save a new flight to the system")
    public Flight saveFlight(@RequestBody Flight flight) {
        return flightService.saveFlight(flight);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete flight by ID", notes = "Delete a flight by providing its ID")
    public void deleteFlight(@PathVariable @ApiParam(value = "ID of the flight")Long id) {
        flightService.deleteFlight(id);
    }

    // Yeni API endpoint'i
    @GetMapping("/search")
    @ApiOperation(value = "Search flights", notes = "Search for flights based on departure, arrival, and dates")
    public List<Flight> searchFlights(
            @RequestParam String departure,
            @RequestParam String arrival,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date departureDate,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date returnDate
    ) {
        if (returnDate != null) {
            // Çift yönlü uçuş için
            return List.of(
                    flightService.searchOneWayFlight(departure, arrival, departureDate),
                    flightService.searchOneWayFlight(arrival, departure, returnDate)
            );
        } else {
            // Tek yönlü uçuş için
            return List.of(flightService.searchOneWayFlight(departure, arrival, departureDate));
        }
    }
}
