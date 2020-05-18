package org.capg.flightmgt.service;

import java.math.BigInteger;

import javax.transaction.Transactional;

import org.capg.flightmgt.dao.IFlightDao;
import org.capg.flightmgt.entities.Flight;
import org.capg.flightmgt.exceptions.InvalidArgumentException;
import org.capg.flightmgt.exceptions.InvalidFlightNumberException;
import org.capg.flightmgt.util.FlightValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.util.Optional;

@Service
@Transactional
public class FlightServiceImpl implements IFlightService {

	private IFlightDao dao;

	public IFlightDao getDao() {
		return dao;
	}
	@Autowired
	public void setDao(IFlightDao dao) {
		this.dao = dao;
	}

	/***
	 * @param flight
	 * 		throw exception if flight is null
	 * @return return the object of flight after adding flight in the list
	 */
	@Override
	public Flight addFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		
		flight = dao.save(flight);
		return flight;
	}
	/***
	 * @param flight
	 * 		throw exception if flight is null
	 * @return return the object of flight after modifying flight in the list
	 */
	@Override
	public Flight modifyFlight(Flight flight) {
		if(flight==null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		flight=dao.save(flight);
		return flight;
		
	}
	/***
	 * @param flightNumber
	 * 		throw exception if flight number is null
	 * @return return the object of flight after fetching flight from the list
	 */
	@Override
	public Flight viewFlight(BigInteger flightNumber) {
		Optional<Flight> optional=dao.findById(flightNumber);
		if(optional.isPresent()) {
		Flight	flight=optional.get();
		return flight;
			
		}
		else
			throw new InvalidFlightNumberException("Invalid Flight Number");
	}
	/***
	 * @param
	 * 
	 * @return return the list of all flight
	 */
	@Override
	public List<Flight> viewFlight(){
		List<Flight> flightList=dao.findAll();
		return flightList;
	}
	
	/***
	 * @param flightNumber as BigInteger
	 *  delete flight from list by id
	 * @return return void
	 */
	
	@Override
	public Boolean deleteFlight(BigInteger flightNumber) {
		if (flightNumber == null) {
			throw new InvalidFlightNumberException("Flight Number is invalid"); 
		}
		if(dao.existsById(flightNumber)) {
			dao.deleteById(flightNumber);
			return true;
		}
		return false;
	}
	
	/***
	 * @param flight
	 * 	validate flight
	 * @return return void
	 */
	@Override
	public void validateFlight(Flight flight ){
		FlightValidation.validateFlight(flight);
		}

	
		
			
	}
