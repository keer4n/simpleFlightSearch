package com.united.repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.united.entity.Flight;

@Repository
public interface FlightRepository extends CrudRepository<Flight, Integer>{
	List<Flight> findAll();
	List<Flight> findByflightNumber (int flightNumber);

	@Query("SELECT f FROM Flight f WHERE f.flightNumber = ?1")
	List<Flight> findByFlightNumberAndDeparture(int flightNumber, Date departure);
	
	@Query("SELECT f from Flight f WHERE f.destination = ?1 OR f.origin = ?1" )
	List<Flight> findByAddressAndDeparture(String destination, Date departure);
}
