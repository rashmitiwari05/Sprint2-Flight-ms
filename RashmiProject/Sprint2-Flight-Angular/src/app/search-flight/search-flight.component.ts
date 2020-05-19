import { Component, OnInit } from '@angular/core';
import { FlightService } from '../services/flightservice';
import { Flight } from '../model/flight';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-search-flight',
  templateUrl: './search-flight.component.html',
  styleUrls: ['./search-flight.component.css']
})
export class SearchFlightComponent implements OnInit {
  service:FlightService;

  constructor(service:FlightService) {
    this.service=service;
   }

  ngOnInit(): void {
  }

  
  foundFlight=null;
  foundStatus=null;
  findFlight(form:any){
    let details=form.value;
    let flightNumber = details.flightNumber;
    let fetched:Observable<Flight>=this.service.findFlightById(flightNumber);
    fetched.subscribe(
      flight=>{
        this.foundFlight=flight;
        this.foundStatus="found";
      },
         err=>{
        this.foundStatus="notfound";
        console.log("error while fetching");
      }
    );
  }
}
