package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Flight;
import com.example.flightsearchapi.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    public Flight getFlightById(Long id) {
        return flightRepository.findById(id).orElse(null);
    }

    public Flight saveFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }

    // Yeni metotlar
    public Flight searchOneWayFlight(String departure, String arrival, Date departureDate) {
        Flight oneWayFlight = new Flight();
        oneWayFlight.setDepartureAirport(departure);
        oneWayFlight.setArrivalAirport(arrival);
        oneWayFlight.setDepartureDateTime(departureDate);
        return oneWayFlight;
    }

    public void saveAllFlights(List<Flight> flights) {
        flightRepository.saveAll(flights);
    }
}