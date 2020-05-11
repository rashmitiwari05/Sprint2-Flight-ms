package org.capg.flightmgt.entities;

import java.math.BigInteger;

import javax.persistence.*;


@Entity
@Table(name="flights")
public class Flight {
@Id
@GeneratedValue
private BigInteger flightNumber;



/***
 * 
 * @return flight number
 */
public BigInteger getFlightNumber() {
	return flightNumber;
}


/***
 * 
 * @param flightNumber
 * 			set flight number
 */
public void setFlightNumber(BigInteger flightNumber) {
	this.flightNumber = flightNumber;
}

private String flightModel;


/***
 * 
 * @return flight model
 */
public String getFlightModel() {
	return flightModel;
}



/***
 * 
 * @param flightNumber
 * 			set flight number
 */
public void setFlightModel(String flightModel) {
	this.flightModel = flightModel;
}

private String carrierName;


/***
 * 
 * @return carrier name
 */
public String getCarrierName() {
	return carrierName;
}



/***
 * 
 * @param carriername
 * 			set carrier name 
 */
public void setCarrierName(String carrierName) {
	this.carrierName = carrierName;
}

private int seatCapacity;



/***
 * 
 * @return seat capacity
 */
public int getSeatCapacity() {
	return seatCapacity;
}



/***
 * 
 * @param seatcapacity
 * 			seatcapacity
 */
public void setSeatCapacity(int seatCapacity) {
	this.seatCapacity = seatCapacity;
}


/***
 * default non parameterized constructor 
 */
public Flight(){
	
}



/***
* @param flightNumber   initialize the flightNumber
* @param flightModel	initialize flight model
* @param carrierName	initialize the carrier name
* @param seatCapacity	initialize seat capacity
*/
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



/***
 * override hash code
 */
@Override
public int hashCode() {
	return flightNumber.hashCode();
}


/***
 * return combine details of flight
 */
@Override
public String toString() {
	return "Flight [Flight Number : " + flightNumber + " Carrier Name : " + carrierName + "Flight Model : "
			+ flightModel + " Seat Capacity : " + seatCapacity + "]";
}
}
