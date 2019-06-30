package com.united.services.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.united.entity.Flight;
import com.united.entity.FlightJson;
import com.united.exception.CustomJSONParseErrorException;
import com.united.services.IFlightJsonService;
import com.united.services.IFlightService;

@Service
@Transactional
public class FlightServiceJson implements IFlightJsonService{
	
	private List<FlightJson> getAllFlightsData () throws CustomJSONParseErrorException {
		Gson gson = new Gson();
		FlightJson[] results = null;
		try {
			results = gson.fromJson(new FileReader("src/main/resources/flights.json"), FlightJson[].class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			throw new CustomJSONParseErrorException("Error Parsing the Json File");
		}
		System.out.println(gson.toJson(results));
		return Arrays.asList(results);
	}
	
	public List<FlightJson> getAllFlights () throws CustomJSONParseErrorException {
		return getAllFlightsData();
	}

	@Override
	public List<FlightJson> getFlightByFlightNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightJson> getFlightByFlightNumberAndDate(int flightNumber, Date date) throws CustomJSONParseErrorException {
		List<FlightJson> flightjsons =  getAllFlightsData();
		SimpleDateFormat fmtr = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = fmtr.format(date);
		System.out.println(newDate);
		return flightjsons.stream().
				filter(flightjson -> flightjson.getFlightNumber() == flightNumber && flightjson.getDate().equals(newDate)).collect(Collectors.toList());
	}

	@Override
	public List<FlightJson> getFLightByAddressAndDate(String originOrDestinationAddress, Date date) throws CustomJSONParseErrorException {
		List<FlightJson> flightjsons =  getAllFlightsData();
		SimpleDateFormat fmtr = new SimpleDateFormat("yyyy-MM-dd");
		String newDate = fmtr.format(date);
		System.out.println(newDate);
		return flightjsons.stream().
				filter(flightjson -> flightjson.getDestination().equals(originOrDestinationAddress) || 
						flightjson.getOrigin().equals(originOrDestinationAddress) && 
						flightjson.getDate().equals(newDate)).collect(Collectors.toList());
	}

}
