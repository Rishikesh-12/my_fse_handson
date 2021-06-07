package com.cognizant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.Model.Attempt;
import com.cognizant.Services.AttemptService;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static AttemptService attemptService;

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		attemptService = context.getBean(AttemptService.class);
		LOGGER.info("Inside main");
		testGetAttempt();
	}

	public static void testGetAttempt() {
		LOGGER.info("Start");
		Attempt attempt = attemptService.getAttempyById(1, 1);
		LOGGER.debug("Attempt 1 of user 1 are :{}", attempt);
		LOGGER.info("End");
	}

}
