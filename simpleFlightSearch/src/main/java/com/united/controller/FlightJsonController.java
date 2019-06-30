package com.united.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.united.dto.FlightSearchDTO;
import com.united.entity.Flight;
import com.united.entity.FlightJson;
import com.united.exception.CustomJSONParseErrorException;
import com.united.services.IFlightJsonService;
import com.united.util.common.SearchCriteria;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/flightsjson")
@Controller
public class FlightJsonController {
	
	@Autowired
	private IFlightJsonService iFlightJsonService;

	@GetMapping
	public ResponseEntity<?> getFlights(HttpServletRequest request, HttpServletResponse response) throws CustomJSONParseErrorException  {
			return new ResponseEntity<List<FlightJson>>(this.iFlightJsonService.getAllFlights(), new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping(value= "/search" )
	public ResponseEntity<?> searchFlights(@RequestBody FlightSearchDTO flightSearchDTO) throws CustomJSONParseErrorException {
		List<FlightJson> flights = new ArrayList<FlightJson>();
		if(flightSearchDTO.getSearchCriteria() == SearchCriteria.LOCATIONS) {
			flights = this.iFlightJsonService.getFLightByAddressAndDate(flightSearchDTO.getDestinationOrOrigin(), flightSearchDTO.getQueryDate() );
		}
		else if (flightSearchDTO.getSearchCriteria() == SearchCriteria.FLIGHTNUMBER) {
			flights = this.iFlightJsonService.getFlightByFlightNumberAndDate(flightSearchDTO.getFlightNumber(), flightSearchDTO.getQueryDate());
		}
		return new ResponseEntity <List<FlightJson>> (flights, new HttpHeaders(), HttpStatus.OK);
	}

}
