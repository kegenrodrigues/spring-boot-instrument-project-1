package com.nilesh.InstrumentTrackerSystem.toCSV;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.repository.EmployeeDAOImpl;
import com.nilesh.InstrumentTrackerSystem.repository.InstrumentDAOImpl;

@Component
public class CsvDatabase {

	@Autowired
	EmployeeDAOImpl theEmployeeDAOImpl;
	
	@Autowired
	InstrumentDAOImpl theInstrumentDAOImpl;
	
	public void csvToEmpDatabase(File file){
		System.out.println("The file name is"+file.getName()+"");
		
		theEmployeeDAOImpl.insertFromCSV(file);
		
	}
	
	public void csvToInstDatabase(File file){
		System.out.println("The file name is"+file.getName()+"");
		
		theInstrumentDAOImpl.insertFromCSV(file);
		
	}
}
