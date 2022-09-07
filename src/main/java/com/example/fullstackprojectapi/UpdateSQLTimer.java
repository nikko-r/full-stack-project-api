package com.example.fullstackprojectapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component

public class UpdateSQLTimer {
	private final ApplicationContext applicationContext;

	@Autowired

	public UpdateSQLTimer(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
	@Scheduled(fixedRate = 60000)
	public void timer() throws FileNotFoundException {
		CSVDataLoader csvDataLoader = applicationContext.getBean(CSVDataLoader.class);
		csvDataLoader.updateSQL();
	}
}