package com.example.fullstackprojectapi;

import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.fullstackprojectapi.CSVDataLoader.updateSQL;

class UpdateSGLTimer {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		  @Override
		  public void run() {
			  try {
				  updateSQL();
			  } catch (FileNotFoundException e) {
				  throw new RuntimeException(e);
			  }
		  }
		}, 0, 1000);//wait 0 milliseconds before doing the action and do it every 1000ms (1 second)
	}
}