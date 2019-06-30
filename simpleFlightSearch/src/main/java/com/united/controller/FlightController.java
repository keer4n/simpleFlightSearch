package com.united.controller;

import java.text.ParseException;
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
	private IFlightService iflightService;

	@GetMapping
	public ResponseEntity<List<Flight>> getFlights(HttpServletRequest request, HttpServletResponse response) {
		return new ResponseEntity<>(this.iflightService.getAllFlights(), new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping (value = "/{flightNumber}")
	public ResponseEntity<List<Flight>> getFlightsbyId(HttpServletRequest request, HttpServletResponse response, @PathVariable ("flightNumber") int flightNumber){
		return new ResponseEntity<>(this.iflightService.getFlightByFlightNumber(flightNumber), new HttpHeaders(), HttpStatus.OK);
	}
	
	@PostMapping(value= "/search" )
	public ResponseEntity<Object> searchFlights(@RequestBody FlightSearchDTO flightSearchDTO) throws ParseException{
		List<Flight> flights = new ArrayList<Flight>();
		if(flightSearchDTO.getSearchCriteria() == SearchCriteria.LOCATIONS) {
			flights = this.iflightService.getFLightByAddressAndDeparture(flightSearchDTO.getDestinationOrOrigin(), flightSearchDTO.getQueryDate() );
		}
		else if (flightSearchDTO.getSearchCriteria() == SearchCriteria.FLIGHTNUMBER) {
			flights = this.iflightService.getFlightByFlightNumberAndDate(flightSearchDTO.getFlightNumber(), flightSearchDTO.getQueryDate());
		}
		return new ResponseEntity <> (flights, new HttpHeaders(), HttpStatus.OK);
	}

}
