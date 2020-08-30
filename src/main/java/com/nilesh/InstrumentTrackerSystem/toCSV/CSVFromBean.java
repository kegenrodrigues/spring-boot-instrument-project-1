package com.nilesh.InstrumentTrackerSystem.toCSV;


import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerCSV;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.service.InstLoggerServiceImpl;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;


@Component
public class CSVFromBean { 
	
	@Autowired
	InstLoggerServiceImpl instLoggerServiceImpl;
	
	public void fetchReport() 
	{ 

		// name of generated csv 
		final String CSV_LOCATION = "Nothing.csv"; 
//		CSVWriter csvWriter = null;

		try { 

			//Headers needs to be changed
			
			// Creating writer class to generate 
			// csv file 
		
			FileWriter writer = new FileWriter(CSV_LOCATION); 
			writer.append("instLoggerId,inTime,outTime,empId,instId,entryStatus");
			writer.append("\n");
			
			// create a list of employee 
			List<InstLoggerEntity> instLogList = new ArrayList<InstLoggerEntity>(); 
			instLogList = instLoggerServiceImpl.fetchListFor();
			
			List<InstLoggerCSV> instLogCSVList = new ArrayList<InstLoggerCSV>();
			
			for(InstLoggerEntity instLogger: instLogList) {
				InstLoggerCSV instLogCSV = new InstLoggerCSV();
				instLogCSV.setEmpId(instLogger.getEmpId());
				instLogCSV.setInstId(instLogger.getInstId());
				instLogCSV.setInstLoggerId(instLogger.getInstLoggerId());
				instLogCSV.setEntryStatus(instLogger.getEntryStatus());
				instLogCSV.setInTime(instLogger.getInTime().getTime().toGMTString());
				if(instLogger.getOutTime() == null) {
					instLogCSV.setOutTime("");
				}else {
					instLogCSV.setOutTime(instLogger.getOutTime().getTime().toGMTString());
				}
				instLogCSVList.add(instLogCSV);
			}

			System.out.println(instLogList);
			System.out.println(instLogList.get(0).getInTime().getTime());
			
			// Create Mapping Strategy to arrange the 
			// column name in order 
			ColumnPositionMappingStrategy<InstLoggerCSV> mappingStrategy= new ColumnPositionMappingStrategy<InstLoggerCSV>(); 
			mappingStrategy.setType(InstLoggerCSV.class); 

			// Arrange column name as provided in below array. 
			String[] columns = new String[]{ "instLoggerId","inTime","outTime","empId","instId","entryStatus"}; 
			mappingStrategy.setColumnMapping(columns); 
			
			// Creating StatefulBeanToCsv object 
			StatefulBeanToCsvBuilder<InstLoggerCSV> builder = new StatefulBeanToCsvBuilder<InstLoggerCSV>(writer); 
			StatefulBeanToCsv<InstLoggerCSV> beanWriter = builder.withMappingStrategy(mappingStrategy).build(); 

			// Write list to StatefulBeanToCsv object 
			beanWriter.write(instLogCSVList); 

			// closing the writer object 
			writer.close(); 
		} 
		catch (Exception e) { 
			e.printStackTrace(); 
		} 
	} 
} 













//csvWriter = new CSVWriter(new FileWriter("Employee.csv"));
//BeanToCsv bc = new BeanToCsv();

////mapping of columns with their positions
//ColumnPositionMappingStrategy mappingStrategy = 
//		new ColumnPositionMappingStrategy();
////Set mappingStrategy type to Employee Type
//mappingStrategy.setType(InstLoggerEntity.class);
////Fields in Employee Bean
//String[] columns = new String[]{"instLoggerId","inTime","outTime","empId","instId","entryStatus"};
////Setting the colums for mappingStrategy
//mappingStrategy.setColumnMapping(columns);
////Writing empList to csv file
//bc.write(mappingStrategy,csvWriter,instLogList);
//System.out.println("CSV File written successfully!!!");
//
//
//
//csvWriter.close();















