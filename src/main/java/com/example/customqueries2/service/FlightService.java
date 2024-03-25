package com.example.customqueries2.service;

import com.example.customqueries2.entity.Flight;
import com.example.customqueries2.entity.StatusEnum;
import com.example.customqueries2.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    public List<Flight> generateFlights(Integer flightNumber) {
        List<Flight> flights = new ArrayList<>();

        for(int i = 0; i < flightNumber; i++) {
            Flight flight = new Flight();
            flight.setDescription("Description: " + randomString());
            flight.setFromAirport("From: " + randomString());
            flight.setToAirport("To: " + randomString());
            flight.setStatus(StatusEnum.randomStatus());
            flights.add(flight);
        }
        List<Flight> flightSaved = flightRepository.saveAll(flights);
        return flightSaved;
    }

    private String randomString() {
        UUID randomUUID = UUID.randomUUID();
        String randomString = randomUUID.toString().replaceAll("-", "");

        return randomString.substring(22);
    }

    public List<Flight> getAllOrderFromAirport() {
        List<Flight> flights = flightRepository.findAllByOrderByFromAirport();

        return flights;
    }

    public List<Flight> getAllFlightOnTime() {
        List<Flight> flights = flightRepository.findAll();

        flights.removeIf(flight -> flight.getStatus().equals(StatusEnum.DELAYED) || flight.getStatus().equals(StatusEnum.CANCELLED));

        return flights;
    }

    public List<Flight> getAllByStatusOrStatus(StatusEnum status1, StatusEnum status2) {
        List<Flight> flights = flightRepository.findAllByStatusOrStatus(status1, status2);
        return flights;
    }

}
