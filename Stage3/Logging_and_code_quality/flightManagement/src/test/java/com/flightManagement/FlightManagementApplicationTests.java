package com.flightManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.flightManagement.model.Flight;
import com.flightManagement.model.Passenger;

@SpringBootTest
class FlightManagementApplicationTests {

	Flight flight = new Flight(1, "Economy", new ArrayList<Passenger>());
	Passenger nonVipPassenger = new Passenger("Tom", false);
	Passenger vipPassenger = new Passenger("Jerry", true);

	@Test
	public void economyFlightTest() {
		assertEquals("Economy", flight.getFlightType());
	}

	@Test
	public void bussinessFlightTest() {
		Flight busFlight = new Flight(1, "Bussiness", new ArrayList<Passenger>());
		assertEquals("Bussiness", busFlight.getFlightType());
	}

	@Test
	public void vipPassengerTest() {
		assertEquals(vipPassenger.isVip(), true);
	}

	@Test
	public void nonVipPassengerTest() {
		assertEquals(nonVipPassenger.isVip(), false);
	}

	@Test
	public void addPassengerTest() {

		flight.addPassengers(vipPassenger);
		assertEquals(1, flight.getPassengers().size());
	}

	@Test
	public void removePassengerTest() {

		flight.removePassengers(vipPassenger);
		assertEquals(0, flight.getPassengers().size());
	}
}

