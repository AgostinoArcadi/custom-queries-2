package com.example.customqueries2.repository;

import com.example.customqueries2.entity.Flight;
import com.example.customqueries2.entity.StatusEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    Page<Flight> findAllByOrderByFromAirport(Pageable pageable);

    List<Flight> findAllByStatusOrStatus(StatusEnum status1, StatusEnum status2);

}
