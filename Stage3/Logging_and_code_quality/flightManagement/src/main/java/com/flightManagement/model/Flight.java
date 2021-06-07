package com.flightManagement.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Flight {
	private int id;
	private String flightType;
	private List<Passenger> passengers;
	
	
	public boolean addPassengers(Passenger passenger) {
		passengers.add(passenger);
		return true;
	}
	
	public boolean removePassengers(Passenger passenger) {
		passengers.remove(passenger);
		return true;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

}
