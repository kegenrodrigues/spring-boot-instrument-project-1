package com.nilesh.InstrumentTrackerSystem.utility;

import java.io.File;
import java.util.Calendar;

public class PathHelperGuide {
	
	
	public static String provideFullPath(String storePath) {
		Calendar cal = Calendar.getInstance();
		String calendarCSV = cal.getTime().toString();
		calendarCSV = calendarCSV.replaceAll("\\s", "");
		calendarCSV = calendarCSV.replaceAll(":", "");
		String CSV_LOCATION = storePath+File.separator+calendarCSV+".csv";
		return CSV_LOCATION;
	}
}
