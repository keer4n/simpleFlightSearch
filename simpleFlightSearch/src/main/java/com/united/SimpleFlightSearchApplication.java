package com.united;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleFlightSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleFlightSearchApplication.class, args);
	}

	@PostConstruct
	public void setTimeZoneUTC() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
