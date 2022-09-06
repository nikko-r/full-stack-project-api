package com.example.fullstackprojectapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FullStackProjectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FullStackProjectApiApplication.class, args);
	}

}


