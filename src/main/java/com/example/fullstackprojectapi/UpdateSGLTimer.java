package com.example.fullstackprojectapi;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Component

public class UpdateSGLTimer {
	@Scheduled(fixedRate = 60000)
	public void timer() throws FileNotFoundException {
		CSVDataLoader.updateSQL();
	}
}