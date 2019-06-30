package com.united.services;

import java.util.Date;
import java.util.List;

import com.united.entity.Flight;
import com.united.entity.FlightJson;
import com.united.exception.CustomJSONParseErrorException;

public interface IFlightJsonService {
		public List<FlightJson> getAllFlights() throws CustomJSONParseErrorException;
		public List<FlightJson> getFlightByFlightNumber(int id);
		public List<FlightJson> getFlightByFlightNumberAndDate(int flightNumber, Date queryDate) throws CustomJSONParseErrorException;
		public List<FlightJson> getFLightByAddressAndDate(String originOrDestinationAddress, Date date) throws CustomJSONParseErrorException;

	}

