package org.capg.flightmgt.service;

import java.math.BigInteger;
import java.util.List;

import org.capg.flightmgt.entities.Flight;

public interface IFlightService {
	public Flight addFlight(Flight flight);
	public Flight modifyFlight(Flight flight);
	public Flight viewFlight(BigInteger flightNumber);
	public List<Flight> viewFlight();
   public  void deleteFlight(BigInteger flightNumber);
    public void validateFlight(Flight flight);
}
