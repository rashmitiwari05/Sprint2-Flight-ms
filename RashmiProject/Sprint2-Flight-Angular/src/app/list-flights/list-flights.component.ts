import { Component, OnInit } from '@angular/core';
import { Flight } from '../model/flight';
import { FlightService } from '../services/flightservice';
import { Observable } from 'rxjs/internal/Observable';

@Component({
  selector: 'app-list-flights',
  templateUrl: './list-flights.component.html',
  styleUrls: ['./list-flights.component.css']
})
export class ListFlightsComponent implements OnInit {
  flightArr: Flight[]=[];
  

  service:FlightService;
  
  router: any;
  FlightService: any;


 
  ngOnInit() {
    
  }

  constructor(service:FlightService) {
  this.service=service;
  let observable:Observable<Flight[]>=this.service.fetchAllFlight();
  observable.subscribe(
    flight=>{
      this.flightArr=flight;
      console.log("length :"+this.flightArr.length);

     
    },
    err=>console.log(err)
    );
  }
  foundStatus=null;
  
  /*findFlightById(form:any){
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
  }*/
 
 
  
 
  /*deleteFlightById(flightnumber:number){
    let result:Observable<Flight>=this.service.deleteFlightById(flightnumber);
    result.subscribe(flight=>{
        this.removeLocalFlight(flightnumber);
    },
    err=>{
     console.log("err in deleteing flights="+err);
    })
      }*/
     
      deleteFlightById(flightNumber:number)
      {
     let result:Observable<boolean>=this.service.deleteFlightById(flightNumber);
     result.subscribe(flight=>{
         this.removeLocalFlight(flightNumber);
     },err=>{
      console.log("err in deleting ="+err);
     })   
   } 
      removeLocalFlight(flightNumber:number){
        let foundIndex=-1;
        for(let i=0;i<this.flightArr.length;i++){
          let flight=this.flightArr[i];
          if(flight.flightNumber===flightNumber){
            foundIndex=i;
            break;
          }
        }
        if(foundIndex<0){
          return;
        }
        this.flightArr.splice(foundIndex,1);
}
}
