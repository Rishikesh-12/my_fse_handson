package com.cognizant;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Stock;
import com.cognizant.service.StockService;

@SpringBootApplication
public class OrmLearn2Application {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearn2Application.class);
	private static StockService stockService;
	
	public static void main(String[] args) {
		LOGGER.info("Inside main");
		ApplicationContext context = SpringApplication.run(OrmLearn2Application.class, args);
		stockService = context.getBean(StockService.class);
		testFbStock();
		testGoogleStock();
		testHighStock();
		testNetflixStock();
		
	}

	private static void testFbStock() {
		LOGGER.info("Start");
		List<Stock> stock = stockService.getFb();
		LOGGER.debug("Stock={}", stock);
		LOGGER.info("End");
	}

	private static void testGoogleStock() {
		LOGGER.info("Start");
		List<Stock> stock = stockService.getGoogle();
		LOGGER.debug("Stock={}", stock);
		LOGGER.info("End");
	}

	private static void testNetflixStock() {
		LOGGER.info("Start");
		List<Stock> stock = stockService.getNetflix();
		LOGGER.debug("Stock={}", stock);
		LOGGER.info("End");
	}

	private static void testHighStock() {
		LOGGER.info("Start");
		List<Stock> stock = stockService.getHigh();
		LOGGER.debug("Stock={}", stock);
		LOGGER.info("End");
	}
	
}
