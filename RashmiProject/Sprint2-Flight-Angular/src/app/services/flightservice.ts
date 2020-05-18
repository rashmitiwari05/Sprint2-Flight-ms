import { Injectable } from '@angular/core';
import { Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Flight } from '../model/flight';

@Injectable()
export class FlightService{
  
  client:HttpClient ;
  constructor(client:HttpClient ){
  this.client=client;
  }
 
 

  addFlight(flight:Flight): Observable<Flight>{
    let url="http://localhost:8086/flights/add";
    let result:Observable<Flight>= this.client.post<Flight>(url,flight);
    return result;
    }


    fetchAllFlight():Observable<Flight[]>
    {
      let url="http://localhost:8086/flights";
      let observable:Observable<Flight[]> =this.client.get<Flight[]>(url);
      return observable;
    }


    deleteFlightById(flightNumber:number){
      let url="http://localhost:8086/flights/delete/"+flightNumber;
      let result:Observable<boolean>=this.client.delete<boolean>(url);
      return result;
    }

     updateFlight(flightNumber:number): Observable<Flight>{
      let url="http://localhost:8086/flights/update/"+ flightNumber;
      let result:Observable<Flight>= this.client.put<Flight>(url,flightNumber);
      return result;
      }

      findFlightById(flightNumber:number):Observable<Flight>{
        let url="http://localhost:8086/flights/get/"+flightNumber;
        let observable:Observable<Flight> =this.client.get<Flight>(url);
        return observable;  
      }
  }
 
