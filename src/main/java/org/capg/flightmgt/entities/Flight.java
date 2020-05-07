package org.capg.flightmgt.entities;

import java.math.BigInteger;

import javax.persistence.*;


@Entity
@Table(name="flights")
public class Flight {
@Id
@GeneratedValue
private BigInteger flightNumber;

public BigInteger getFlightNumber() {
	return flightNumber;
}

public void setFlightNumber(BigInteger flightNumber) {
	this.flightNumber = flightNumber;
}

private String flightModel;

public String getFlightModel() {
	return flightModel;
}

public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}

private String carrierName;

public String getCarrierName() {
	return carrierName;
}

public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}

private int seatCapacity;

public int getSeatCapacity() {
	return seatCapacity;
}

public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}
public Flight(){
	
}


public Flight(BigInteger flightNumber, String flightModel, String carrierName, int seatCapacity) {
	
	this.flightNumber = flightNumber;
	this.flightModel = flightModel;
	this.carrierName = carrierName;
	this.seatCapacity = seatCapacity;
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Flight other = (Flight) obj;
	if (flightNumber == null) {
		if (other.flightNumber != null)
			return false;
	} else if (!flightNumber.equals(other.flightNumber))
		return false;
	return true;
}


@Override
public int hashCode() {
	return flightNumber.hashCode();
}



@Override
public String toString() {
	return "Flight [Flight Number : " + flightNumber + " Carrier Name : " + carrierName + "Flight Model : "
			+ flightModel + " Seat Capacity : " + seatCapacity + "]";
}
}
