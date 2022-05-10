package com.project.cotafacil;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.log4j.Log4j2;

@Log4j2
@SpringBootApplication
public class CotafacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotafacilApplication.class, args);
		log.info("Cotafacil started successfully at {}", LocalDateTime.now());
	}

}
