package com.united.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.united.entity.Flight;
import com.united.entity.FlightJson;
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
	
	public List<Flight> getFlightByFlightNumberAndDate(int number, Date date) throws ParseException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateQuery = formatter.format(date);		
		System.out.println(dateQuery);
		return this.flightRepository.findByFlightNumberandDeparture(number, dateQuery);
	}
	
	public List<Flight> getFLightByAddressAndDeparture(String originOrDestinationAddress, Date departure) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateQuery = formatter.format(departure);
		return this.flightRepository.findByAddressAndDeparture(originOrDestinationAddress, dateQuery);
	}
}
