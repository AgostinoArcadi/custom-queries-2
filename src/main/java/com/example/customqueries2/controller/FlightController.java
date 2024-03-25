package com.example.customqueries2.controller;

import com.example.customqueries2.entity.Flight;
import com.example.customqueries2.entity.StatusEnum;
import com.example.customqueries2.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @PostMapping("/generate-flights")
    public ResponseEntity<List<Flight>> generateFlights(@RequestParam(required = false, defaultValue = "100") Integer n) {
        List<Flight> flights = flightService.generateFlights(n);

        return ResponseEntity.ok().body(flights);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Flight>> getAllOrderByFromAirport() {
        List<Flight> flights = flightService.getAllOrderByFromAirport();

        return ResponseEntity.ok().body(flights);
    }

    @GetMapping("get-ontime")
    public ResponseEntity<List<Flight>> getAllFlightOnTime() {
        List<Flight> flights = flightService.getAllFlightOnTime();

        return ResponseEntity.ok().body(flights);
    }

    @GetMapping("get-by-status")
    public ResponseEntity<List<Flight>> getAllByStatusOrStatus(@RequestParam StatusEnum p1, @RequestParam StatusEnum p2) {
        List<Flight> flights = flightService.getAllByStatusOrStatus(p1, p2);

        return ResponseEntity.ok().body(flights);
    }

}
