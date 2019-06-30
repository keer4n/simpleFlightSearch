package com.united.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FlightJson {

	private int flightNumber;
	private String carrier;
	private String origin;
	private String departure;
	private String destination;
	private String arrival;
	private String aircraft;
	private double distance;
	private String travelTime;
	private String status;
	
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getDate() {
		System.out.println(this.departure.substring(0, 10));
		return this.departure.substring(0, 10);
	}	
}
