package com.nilesh.InstrumentTrackerSystem.utility;

import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class DateAndTimeAssist {

	public Date convertToDateAndTime() {
		
		Date date = new Date();
		return date;
	}
	public void timePass() {
		System.out.println("Its timepass");
	}
	
}
