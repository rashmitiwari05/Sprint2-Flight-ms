package org.capg.flightmgt.service;

import javax.transaction.Transactional;

import org.capg.flightmgt.dao.IFlightDao;
import org.capg.flightmgt.entities.Flight;
import org.capg.flightmgt.exceptions.InvalidArgumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	
	@Override
	public Flight addFlight(Flight flight) {
		if (flight == null) {
			throw new InvalidArgumentException("Invalid Argument");
		}
		
		flight = dao.save(flight);
		return flight;
	}
}