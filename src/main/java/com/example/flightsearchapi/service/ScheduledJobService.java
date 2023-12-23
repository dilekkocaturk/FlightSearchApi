package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduledJobService {

    @Autowired
    private MockApiService mockApiService;

    @Autowired
    private FlightService flightService;

    @Scheduled(cron = "0 0 2 * * *") // Her gün saat 02:00'de çalışacak
    public void fetchAndSaveFlightData() {
        // Mock third-party API'dan uçuş bilgilerini al
        List<Flight> flights = mockApiService.fetchFlights();

        // Uçuş bilgilerini veritabanına kaydet
        if (flights != null) {
            flightService.saveAllFlights(flights);
            System.out.println("Uçuş bilgileri başarıyla veritabanına kaydedildi.");
        } else {
            // Hata durumunu logla
            System.err.println("Mock API'den uçuş bilgileri alınamadı.");
        }
    }
}