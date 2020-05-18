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
  fetched:Flight=null;
  foundStatus=null;
  constructor() { }

  ngOnInit(): void {
  }


  findFlightById(form:any){
    let details=form.value;
    let flightnumber = details.flightnumber;
    let fetched:Observable<Flight>=this.service.findFlightById(flightnumber);
    fetched.subscribe(
      Flight=>{
        this.foundStatus=Flight;
        this.foundStatus="found";
      },
      err=>{
        this.foundStatus="notfound";
        console.log("error while fetching");
      }
    );
  }
}
