package com.sanmateo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeachersApplication {
	private static final Logger logger = LoggerFactory.getLogger(TeachersApplication.class);

	public static void main(String[] args) {
		logger.info("Starting TeachersAPI..");
		SpringApplication.run(TeachersApplication.class, args);
		logger.info("TeachersAPI started..");
	}
}
