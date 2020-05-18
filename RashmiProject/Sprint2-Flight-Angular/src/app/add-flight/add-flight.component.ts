import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight';
import { FlightService } from '../services/flightservice';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-add-flight',
  templateUrl: './add-flight.component.html',
  styleUrls: ['./add-flight.component.css']
})
export class AddFlightComponent implements OnInit {
  service:FlightService;
  
  constructor(service:FlightService) {
    this.service=service;
   }
    
   addedFlight:Flight=null;

  ngOnInit(): void {
  }

     addFlight(flightForm:any){
    let datails=flightForm.value;
    let flightnumber=datails.flightnumber;
    let flightmodel=datails.flightmodel;
    let carriername=datails.carriername;
    let seatcapacity=datails.seatcapacity;
    this.addedFlight=new Flight();
    this.addedFlight.flightNumber=flightnumber;
    this.addedFlight.flightModel=flightmodel;
    this.addedFlight.carrierName=carriername;
    this.addedFlight.seatCapacity=seatcapacity;
    //let flight=new Flight(flightnumber,flightmodel,carriername,seatcapacity);
    let result:Observable<Flight>=this.service.addFlight(this.addedFlight); // adding to the store
    result.subscribe((flight:Flight)=>{
      this.addedFlight=flight;
    },
    err=>{
      console.log("err="+err);
      } );
    
   
  }
  }


