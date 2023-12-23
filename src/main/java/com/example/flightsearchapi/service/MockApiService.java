package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Flight;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class MockApiService {

    public List<Flight> fetchFlights() {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Flight>> typeReference = new TypeReference<>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/mock_flights.json");

        try {
            List<Flight> flights = objectMapper.readValue(inputStream, typeReference);
            return flights;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}