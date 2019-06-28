package com.united.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.united.entity.Flight;
import com.united.repository.FlightRepository;
import com.united.services.IFlightService;

@Component
public class FlightService implements IFlightService{
	
	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAllFlights() {
		return this.flightRepository.findAll();
	}
	
	public Flight getFlightByFlightNumber() {
		return this.flightRepository.findByflightNumber();
	}

}
