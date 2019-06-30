package com.united.services;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import com.united.entity.Flight;

public interface IFlightService {
	
	public List<Flight> getAllFlights();
	public List<Flight> getFlightByFlightNumber(int id);
	public List<Flight> getFlightByFlightNumberAndDate(int flightNumber, Date queryDate) throws ParseException;
	public List<Flight> getFLightByAddressAndDeparture(String originOrDestinationAddress, Date departure);

}
