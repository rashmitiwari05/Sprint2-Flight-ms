package org.capg.flightmgt.controller;


import java.math.BigInteger;

import org.capg.flightmgt.dto.FlightDto;
import org.capg.flightmgt.entities.Flight;
import org.capg.flightmgt.service.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class FlightRestController {



	    private static final Logger Log= LoggerFactory.getLogger(FlightRestController.class);

	    @Autowired
	    private IFlightService flightService;

 @PostMapping("/add")
  public ResponseEntity<Flight> addFlight(@RequestBody FlightDto flightDto){
	        Flight flight = convertFromDto(flightDto);
	             flight = flightService.addFlight(flight);
	        ResponseEntity<Flight> response = new ResponseEntity<>(flight, HttpStatus.OK);
	       
	        return response;
	    }
 
 
 
 private Flight convertFromDto(FlightDto flightDto){
	      Flight flight = new Flight();
	     flight.setCarrierName(flightDto.getCarrierName());
	          flight.setFlightModel(flightDto.getFlightModel());
	      flight.setSeatCapacity(flightDto.getSeatCapacity());
	        return flight;
	    }
 
 
 
@GetMapping("/get/{flightNumber}")
	 public ResponseEntity<Flight> findFlightById(@PathVariable("flightNumber") BigInteger flightNumber){
	   
	Flight flight = flightService.viewFlight(flightNumber);
	     
	ResponseEntity<Flight> response = new ResponseEntity<>(flight,HttpStatus.OK);
	        return response;
	    }
}
