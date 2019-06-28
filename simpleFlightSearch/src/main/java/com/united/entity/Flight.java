package com.united.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.sql.Timestamp;

@Entity
public class Flight {
	
	@Id
	private int flightNumber;
	
	@Column(name = "CARRIER")
	private String carrier;
	
	@Column(name = "ORIGIN")
	private String origin;
	
	@Column(name = "DEPARTURE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date departure;
	
	@Column(name = "DESTINATION")
	private String destination;
	
	@Column(name = "ARRIVAL")
	@Temporal(TemporalType.TIMESTAMP)
	private Date arrival;
	
	@Column(name = "AIRCRAFT")
	private String aircraft;
	
	@Column(name = "DISTANCE")
	private double distance;
	
	@Column(name = "TRAVELTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date travelTime;
	
	@Column(name = "STATUS")
	private String status;
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
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
	public Date getDeparture() {
		return departure;
	}
	public void setDeparture(Timestamp departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Date getArrival() {
		return arrival;
	}
	public void setArrival(Timestamp arrival) {
		this.arrival = arrival;
	}
	public String getAircraft() {
		return aircraft;
	}
	public void setAircraft(String aircraft) {
		this.aircraft = aircraft;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Date getTravelTime() {
		return travelTime;
	}
	public void setTravelTime(Date travelTime) {
		this.travelTime = travelTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
