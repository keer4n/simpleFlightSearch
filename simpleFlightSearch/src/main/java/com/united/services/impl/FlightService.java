package com.united.services.impl;

import java.util.Date;
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
	
	public List<Flight> getFlightByFlightNumber(int flightNumber) {
		return this.flightRepository.findByflightNumber(flightNumber);
	}
	
	public List<Flight> getFlightByFlightNumberAndDate(int number, Date date) {
		return this.flightRepository.findByFlightNumberAndDeparture(number, date);
	}
	
	public List<Flight> getFLightByAddressAndDeparture(String originOrDestinationAddress, Date departure) {
		return this.flightRepository.findByAddressAndDeparture(originOrDestinationAddress, departure);
	}


}
