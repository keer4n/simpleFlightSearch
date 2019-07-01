import { Component, OnInit } from '@angular/core';
import { SrchService } from '../srch.service';
import { FlightDetails } from '../dto/flightDetails';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  results: FlightDetails[];
  display: boolean;

  constructor(private srchService: SrchService, private router: Router) {
    this.display = false;
    this.results = null;
   }

   ngOnInit() {
    this.srchService.userInputEmitter.subscribe(results => {
      this.results = results;
      if (this.results[0] != null) {
        this.display = true;
      }
    });
  }

}
