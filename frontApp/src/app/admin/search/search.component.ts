import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { SrchService } from '../srch.service';
import { Router } from '@angular/router';
import { UserInput } from '../dto/UserInput';
import { FlightDetails } from '../dto/flightDetails';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  results: FlightDetails [] = [];

  ngOnInit() {
  }

  private userInput: UserInput;
  private searchForm: FormGroup;
  private searchFormTwo: FormGroup;

  
  constructor(
    private formBuilder: FormBuilder,
    private srchService: SrchService,
    private router: Router) {
    this.searchForm = formBuilder.group({
      flightNumber: ['', [Validators.required]],
      date: ['', [Validators.required]],
      remember: [1, [Validators.required]]
    });

    this.searchFormTwo = formBuilder.group({
      address: ['', [Validators.required]],
      date: ['', [Validators.required]],
      remember: [1, [Validators.required]]
    });

  }
 
  onSubmitFlightNumber() {
    console.log(this.searchForm);
    this.userInput = {
      queryDate: this.searchForm.value.date,
      flightNumber: this.searchForm.value.flightNumber,
      destinationOrOrigin: null,
      searchCriteria:  "FLIGHTNUMBER"
    };
    
    
    this.srchService.find(this.userInput)
    .subscribe(res => {
      this.results = res as FlightDetails [];
      console.log(this.results);
      this.srchService.userInputEmitter.emit(this.results);
    },
    err => console.log(err)
    );

  }


  onSubmitAddress() {
    console.log(this.searchForm);
    this.userInput.queryDate = this.searchForm.value.date;
    this.userInput.flightNumber = null;
    this.userInput.destinationOrOrigin = this.searchForm.value.address;
    this.userInput.searchCriteria = "FLIGHTNUMBER";
    
    this.srchService.find(this.userInput)
    .subscribe(res => {
      this.srchService.userInputEmitter.emit(res['data']);
    },
    err => console.log(err)
    );

  }


}
