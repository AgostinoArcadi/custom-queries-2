package com.example.customqueries2.repository;

import com.example.customqueries2.entity.Flight;
import com.example.customqueries2.entity.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    List<Flight> findAllByOrderByFromAirport();

    List<Flight> findAllByStatusOrStatus(StatusEnum status1, StatusEnum status2);

}
