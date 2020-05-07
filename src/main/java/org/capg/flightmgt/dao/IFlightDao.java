
	package org.capg.flightmgt.dao;

	import java.math.BigInteger;

	import org.capg.flightmgt.entities.Flight;
	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	@Repository
	public interface IFlightDao extends JpaRepository<Flight,BigInteger> {

	}


