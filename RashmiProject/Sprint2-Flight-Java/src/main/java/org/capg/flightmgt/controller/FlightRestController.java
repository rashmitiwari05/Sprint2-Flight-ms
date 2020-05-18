package org.capg.flightmgt.controller;


import java.math.BigInteger;
import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.capg.flightmgt.dto.FlightDto;
import org.capg.flightmgt.entities.Flight;
import org.capg.flightmgt.exceptions.FlightNotFoundException;
import org.capg.flightmgt.service.IFlightService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/flights")
@Validated
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
            flight.setFlightNumber(flightDto.getFlightNumber());
      	    flight.setCarrierName(flightDto.getCarrierName());
      	    flight.setFlightModel(flightDto.getFlightModel());
      	    flight.setSeatCapacity(flightDto.getSeatCapacity());
      	    return flight;
      	    }
        
        
        
        @PutMapping("/update/{flightNumber}")
        public ResponseEntity<Flight> modifyFlight(@RequestBody FlightDto flightDto , @PathVariable("flightNumber") BigInteger flightNumber){
            Flight flight = convertFromDto(flightDto);
            flight.setFlightNumber(flightNumber);
            flight = flightService.modifyFlight(flight);
            ResponseEntity<Flight> response = new ResponseEntity<>(flight,HttpStatus.OK);
            return response;
        }
        
        	
        
        @GetMapping("/get/{flightNumber}")
        public ResponseEntity<Flight> findFlightById(@PathVariable("flightNumber") BigInteger flightNumber){
    	    Flight flight = flightService.viewFlight(flightNumber);
    	    ResponseEntity<Flight> response = new ResponseEntity<>(flight,HttpStatus.OK);
    	    return response;
        }
	   
        
        @GetMapping
        public ResponseEntity<List<Flight>> viewFlight(){
            List<Flight> flightList = flightService.viewFlight();
            ResponseEntity<List<Flight>> response = new ResponseEntity<>(flightList,HttpStatus.OK);
            return response;
        }
        
        
        @DeleteMapping("/delete/{flightNumber}")
        public ResponseEntity<Boolean> deleteFlight(@PathVariable("flightNumber") BigInteger flightNumber){
            Boolean result = flightService.deleteFlight(flightNumber);
            ResponseEntity<Boolean> response = new ResponseEntity<>(result,HttpStatus.OK);
            return response;
        }
        
        @ExceptionHandler(FlightNotFoundException.class)
        public ResponseEntity<String>handleFlightNotFound(FlightNotFoundException ex){
            Log.error("Flight not found exception",ex);
            String msg=ex.getMessage();
            ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.NOT_FOUND);
            return response;
        }

        
        @ExceptionHandler(ConstraintViolationException.class)
        public ResponseEntity<String>handleConstraintViolate(ConstraintViolationException ex){
            Log.error("constraint violation",ex);
            String msg=ex.getMessage();
            ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
            return response;
        }
        
        @ExceptionHandler(Throwable.class)
        public ResponseEntity<String>handleAll(Throwable ex){
            Log.error("Something went wrong",ex);
            String msg=ex.getMessage();
            ResponseEntity<String>response=new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
            return response;
        }
        
        
 

}
