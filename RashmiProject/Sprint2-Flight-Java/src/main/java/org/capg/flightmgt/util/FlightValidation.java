package org.capg.flightmgt.util;

import org.capg.flightmgt.entities.Flight;
import org.capg.flightmgt.exceptions.InvalidCarrierNameException;
import org.capg.flightmgt.exceptions.InvalidFlightModelException;
import org.capg.flightmgt.exceptions.InvalidFlightNumberException;
import org.capg.flightmgt.exceptions.InvalidSeatCapacityException;

public class FlightValidation {
	
	/***
	 * @param flight
	 *  		throw invalid flight number exception if flight number is null or flight number is not equal to 12 digits
	 *  		throw invalid flight model exception if flight model is null
	 *          throw invalid carrier name exception if flight carrier name is null
	 *  		throw invalid seat capacity exception if seat capacity is negative
	 * @return return void
	 */
	
	public static void validateFlight(Flight flight) {
		
		if ((flight.getFlightNumber() == null) || (flight.toString().length() != 12)) {
			throw new InvalidFlightNumberException("Invalid Flight Number");
		}
		if (flight.getFlightModel() == null) {
			throw new InvalidFlightModelException("Invalid Flight Model");
		}
		if (flight.getCarrierName()== null) {
			throw new InvalidCarrierNameException("Invalid Carrier Name");
		}
		if (flight.getSeatCapacity() < 0) {
			throw new InvalidSeatCapacityException("Invalid Seat Capacity");
		}
	}
}
