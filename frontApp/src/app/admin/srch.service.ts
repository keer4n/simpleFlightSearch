import { Injectable, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { UserInput } from './dto/UserInput';
import { FlightDetails } from './dto/flightDetails';

@Injectable({
  providedIn: 'root'
})
export class SrchService {
userInputEmitter = new EventEmitter<FlightDetails[]>();

constructor(
  private http: HttpClient,
  private router: Router

) { }



public find(input) {
  return this.http.post("http://localhost:8080/flights/search", input);
}

public finfByFlightNumber(flightNumber: Number) {
  return this.http.get("http://localhost:8080/flights/" + flightNumber);
}

}