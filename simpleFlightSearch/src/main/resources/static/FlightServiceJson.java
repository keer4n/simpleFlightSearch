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
	
	public List<FlightJson> getAllFlights () throws CustomJSONParseErrorException {
		Gson gson = new Gson();
		FlightJson[] results = null;
		try {
			results = gson.fromJson(new FileReader("src/main/resources/flights.json"), FlightJson[].class);
		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {
			throw new CustomJSONParseErrorException("Erro Parsing the Json File");
		}
		System.out.println(gson.toJson(results));
		return Arrays.asList(results);
	}

	@Override
	public List<FlightJson> getFlightByFlightNumber(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FlightJson> getFlightByFlightNumberAndDate(String flightNumber, Date date) throws CustomJSONParseErrorException {

		List<FlightJson> flightjsons =  getAllFlights();
		System.out.println(flightjsons.getClass());
		return flightjsons.stream().
				filter(flightjson -> flightjson.getFlightNumber().equals(flightNumber) && 
				flightjson.getDate().equals(date)).collect(Collectors.toList());
	}

	@Override
	public List<FlightJson> getFLightByAddressAndDeparture(String originOrDestinationAddress, Date departure) {
		// TODO Auto-generated method stub
		return null;
	}
}
