package org.capg.flightmgt.dto;

import java.math.BigInteger;

public class FlightDto {
		private BigInteger flightNumber;
	    private String flightModel;
	    private String carrierName;
	    private int seatCapacity;
	    
	    public BigInteger getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(BigInteger flightNumber) {
			this.flightNumber = flightNumber;
		}
		
		 public String getFlightModel() {
		        return flightModel;
		    }

			public void setFlightModel(String flightModel) {
		        this.flightModel = flightModel;
		    }

	    public String getCarrierName() {
	        return carrierName;
	    }

	    public void setCarrierName(String carrierName) {
	        this.carrierName = carrierName;
	    }

	  
	    public int getSeatCapacity() {
	        return seatCapacity;
	    }

	    public void setSeatCapacity(int seatCapacity) {
	        this.seatCapacity = seatCapacity;
	    }
	}

