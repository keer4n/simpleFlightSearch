import { Component, OnInit } from '@angular/core';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { SrchService } from '../srch.service';
import { Router } from '@angular/router';
import { UserInput } from '../dto/UserInput';
import { FlightDetails } from '../dto/flightDetails';
import * as enLocale from 'date-fns/locale/en';
import { DatepickerOptions } from 'ng2-datepicker';


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
  //date : Date;
  options: DatepickerOptions = {
    locale: enLocale,
    barTitleFormat: 'MMMM YYYY',
  };
  
  constructor(
    private formBuilder: FormBuilder,
    private srchService: SrchService,
    private router: Router) {
    this.searchForm = formBuilder.group({
      flightNumber: ['', [Validators.required]],
      date: ['', [Validators.required]],
      remember: [1, [Validators.required]]
    });

    //this.date = new Date(Date.now());

    this.searchFormTwo = formBuilder.group({
      address: ['', [Validators.required]],
      newDate: ['', [Validators.required]],
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
    this.userInput = {
      queryDate: this.searchFormTwo.value.newDate,
      flightNumber: null,
      destinationOrOrigin: this.searchFormTwo.value.address,
      searchCriteria:  "LOCATIONS"
    };
    
    this.srchService.find(this.userInput)
    .subscribe(res => {
      this.results = res as FlightDetails[];
      this.srchService.userInputEmitter.emit(this.results);
    },
    err => console.log(err)
    );

  }


}
