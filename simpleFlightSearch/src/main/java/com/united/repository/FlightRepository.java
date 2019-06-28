package com.united.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.united.entity.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer>{
	List<Flight> findAll();
	List<Flight> findByflightNumber (int flightNumber);

	@Query("SELECT f FROM Flight f WHERE f.flightNumber = ?1")
	List<Flight> findByFlightNumberAndDeparture(int flightNumber, Date departure);
	

	@Query(value = "SELECT * FROM flight WHERE (origin = ?1 OR destination = ?1) AND DATE(departure) = DATE(?2)", nativeQuery = true)
	List<Flight> findByAddressAndDeparture(String destination, String departure);

	@Query(value = "SELECT * FROM flight WHERE flight_number = ?1 AND DATE(departure) = DATE(?2)", nativeQuery = true)
	List<Flight> findByFlightNumberandDeparture(int flightNumber, String endDate);
}
