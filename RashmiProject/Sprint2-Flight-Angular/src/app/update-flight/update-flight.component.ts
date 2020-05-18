import { Component, OnInit } from '@angular/core';
import { FlightService } from '../services/flightservice';
import { Flight } from '../model/flight';

@Component({
  selector: 'app-update-flight',
  templateUrl: './update-flight.component.html',
  styleUrls: ['./update-flight.component.css']
})
export class UpdateFlightComponent implements OnInit {

 
  updatedFlight:Flight=null;
  service:FlightService;
  
  
  constructor(service:FlightService) {
    this.service=service;
   }
  
  
   
  ngOnInit(): void {
  }
  updateFlight(flightForm:any){
    let details=flightForm.value;
    let flightnumber=details.flightnumber;
    let flightmodel=details.flightmodel;
    let carriername=details.carriername;
    let seatcapacity = details.seatcapacity;
    
    this.updatedFlight=new Flight();
    
    this.updatedFlight.flightModel=flightmodel;
    this.updatedFlight.carrierName=carriername;
    this.updatedFlight.seatCapacity=seatcapacity;
   let result= this.service.updateFlight(flightnumber);
    
    result.subscribe((flight:Flight)=>{
      
    },
    err=>{
    console.log("err="+err);
    } );
    flightForm.reset();

  }
  
}

