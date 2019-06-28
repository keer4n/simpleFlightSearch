package com.united.dto;

import java.util.Date;

import com.united.util.common.SearchCriteria;

public class FlightSearchDTO {
	private Date queryDate;
	private int flightNumber;
	private String destinationOrOrigin;
	private SearchCriteria searchCriteria;

	
	public String getDestinationOrOrigin() {
		return destinationOrOrigin;
	}
	public void setDestinationOrOrigin(String destinationOrOrigin) {
		this.destinationOrOrigin = destinationOrOrigin;
	}
	
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}
	public Date getQueryDate() {
		return queryDate;
	}
	public void setQueryDate(Date queryDate) {
		this.queryDate = queryDate;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
}
	
	