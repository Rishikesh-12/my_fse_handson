package com.flightManagement;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.flightManagement.model.Flight;
import com.flightManagement.model.Passenger;

@SpringBootApplication
public class FlightManagementApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightManagementApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(FlightManagementApplication.class, args);
		function();
	}
	
	public static void function() { 
		Flight ecoFlight = new Flight(1,"Economy",new ArrayList<Passenger>());
		LOGGER.debug(ecoFlight.toString());
		
		Flight buFlight = new Flight(2,"Bussiness",new ArrayList<Passenger>());
		LOGGER.debug(buFlight.toString());
		
		LOGGER.info("Adding vip passengers");
		Passenger vipPassenger = new Passenger("Jerry",true);
		ecoFlight.addPassengers(vipPassenger);
		buFlight.addPassengers(vipPassenger);
		LOGGER.debug(ecoFlight.toString());
		LOGGER.debug(buFlight.toString());
		
		LOGGER.info("Adding non vip passengers");
		Passenger nonVipPassenger = new Passenger("Tom",false);
		ecoFlight.addPassengers(nonVipPassenger);
		buFlight.addPassengers(nonVipPassenger);
		LOGGER.debug(ecoFlight.toString());
		LOGGER.debug(buFlight.toString());
		
		LOGGER.info("Removing vip passengers");
		if(vipPassenger.isVip()) {
			ecoFlight.removePassengers(vipPassenger);
		}
		
		if(vipPassenger.isVip()) {
			buFlight.removePassengers(vipPassenger);
		}
		

		LOGGER.debug(ecoFlight.toString());
		LOGGER.debug(buFlight.toString());
		
		LOGGER.info("Removing non vip passengers");
		if(!nonVipPassenger.isVip()) {
			ecoFlight.removePassengers(nonVipPassenger);
		}
		
		if(!nonVipPassenger.isVip()) {
			buFlight.removePassengers(nonVipPassenger);
		}
		
		LOGGER.debug(ecoFlight.toString());
		LOGGER.debug(buFlight.toString());
	}

}
