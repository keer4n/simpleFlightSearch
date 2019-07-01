import { Component, OnInit } from '@angular/core';
import { SrchService } from '../srch.service';
import { FlightDetails } from '../dto/flightDetails';

@Component({
  selector: 'app-result',
  templateUrl: './result.component.html',
  styleUrls: ['./result.component.css']
})
export class ResultComponent implements OnInit {
  results: FlightDetails[];
  display: boolean = false;

  constructor(private srchService: SrchService) {
   }

   ngOnInit() {
    this.srchService.userInputEmitter.subscribe(results => {
      this.results = results;
      if (results == null) {
        this.display = false;
      } else {
        this.display = true;
      }
    });
  }

}
