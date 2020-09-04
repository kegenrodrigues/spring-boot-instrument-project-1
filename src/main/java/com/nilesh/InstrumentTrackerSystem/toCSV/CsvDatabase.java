package com.nilesh.InstrumentTrackerSystem.toCSV;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.repository.EmployeeDAOImpl;

@Component
public class CsvDatabase {

	@Autowired
	EmployeeDAOImpl theEmployeeDAOImpl;
	
	public void csvToDatabase(File file){
		System.out.println("The file name is"+file.getName()+"");
		
		theEmployeeDAOImpl.insertFromCSV(file);
		
		
		
	}
	
}
