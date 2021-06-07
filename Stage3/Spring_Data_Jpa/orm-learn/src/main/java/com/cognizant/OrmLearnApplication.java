package com.cognizant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Country;
import com.cognizant.service.CountryService;
import com.cognizant.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;


	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
		getAllCountriesTest();
		testAddCountry();
		testUpdateCountry();
		testDeleteCountry();
		testListCountriesByNamePart();
		testListCountriesByNameStart();

	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void getAllCountriesTest() {

		LOGGER.info("Start");
		Country country = null;
		try {
			country = countryService.findCountryByCode("IN");
		} catch (CountryNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");

	}

	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("Ri");
		country.setName("Rishi");
		countryService.addCountry(country);
		LOGGER.info("Country Added Successfully!");
		LOGGER.info("End");
	}

	private static void testUpdateCountry() {
		LOGGER.info("Start");
		try {
			countryService.updateCountry("Ri", "Rashmi");
			LOGGER.info("Country Updated Successfully!");
		} catch (CountryNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("End");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start");
		try {
			countryService.deleteCountry("Ri");
			LOGGER.info("Country Deleted Successfully!");
		} catch (CountryNotFoundException e) {
			LOGGER.info(e.getMessage());
		}
		LOGGER.info("End");
	}

	private static void testListCountriesByNamePart() {
		LOGGER.info("Start");
		List<Country> countries = countryService.searchByNamePart("ou");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testListCountriesByNameStart() {
		LOGGER.info("Start");
		List<Country> countries = countryService.searchByNameStart("R");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

}
