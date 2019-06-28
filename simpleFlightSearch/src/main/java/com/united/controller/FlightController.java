package com.united.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.united.dto.FlightSearchDTO;
import com.united.entity.Flight;
import com.united.services.IFlightService;
import com.united.util.common.SearchCriteria;
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/flights")
@RestController
public class FlightController {
	
	@Autowired
	private IFlightService flightService;

	@GetMapping
	public ResponseEntity<List<Flight>> getFlights(HttpServletRequest request, HttpServletResponse response){
		return new ResponseEntity<>(this.flightService.getAllFlights(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping (value = "{/flightNumber}")
	public ResponseEntity<List<Flight>> getFlightsbyId(HttpServletRequest request, HttpServletResponse response, @PathVariable ("flightNumber") int flightNumber){
		return new ResponseEntity<>(this.flightService.getFlightByFlightNumber(flightNumber), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value= "/search" )
	public ResponseEntity<Object> searchFlights(@RequestBody FlightSearchDTO flightSearchDTO){
		List<Flight> flights = new ArrayList<Flight>();
		System.out.println(flightSearchDTO.getQueryDate());
		if(flightSearchDTO.getSearchCriteria() == SearchCriteria.LOCATIONS) {
			System.out.println("Searching based on location and date");
			flights = this.flightService.getFLightByAddressAndDeparture(flightSearchDTO.getDestinationOrOrigin(), flightSearchDTO.getQueryDate() );
		}
		else if (flightSearchDTO.getSearchCriteria() == SearchCriteria.FLIGHTNUMBER) {
			System.out.println("Search based on flight number and date");
			flights = this.flightService.getFlightByFlightNumberAndDate(flightSearchDTO.getFlightNumber(), flightSearchDTO.getQueryDate());
		}
		return new ResponseEntity <> (flights, new HttpHeaders(), HttpStatus.OK);
	}

}
