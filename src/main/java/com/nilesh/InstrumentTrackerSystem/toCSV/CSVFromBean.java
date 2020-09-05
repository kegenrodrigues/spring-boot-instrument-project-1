package com.nilesh.InstrumentTrackerSystem.toCSV;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.nilesh.InstrumentTrackerSystem.csvBeans.EmployeeCSV;
import com.nilesh.InstrumentTrackerSystem.csvBeans.InstLoggerCSV;
import com.nilesh.InstrumentTrackerSystem.csvBeans.InstrumentCSV;
import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;
import com.nilesh.InstrumentTrackerSystem.service.EmployeeServiceImpl;
import com.nilesh.InstrumentTrackerSystem.service.InstLoggerServiceImpl;
import com.nilesh.InstrumentTrackerSystem.service.InstrumentServiceImpl;
import com.nilesh.InstrumentTrackerSystem.utility.PathHelperGuide;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

@Component
public class CSVFromBean { 
	
	@Autowired
	InstLoggerServiceImpl instLoggerServiceImpl;
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@Autowired
	InstrumentServiceImpl instrumentServiceImpl;
	
	@SuppressWarnings("deprecation")
	public void fetchReport(String storePath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException 
	{ 
		String CSV_LOCATION = PathHelperGuide.provideFullPath(storePath);

			FileWriter writer = new FileWriter(CSV_LOCATION); 
			writer.append("instLoggerId,inTime,outTime,empId,instId,currentDate,modelNo,iP");
			writer.append("\n");
			
			List<InstLoggerEntity> instLogList = new ArrayList<InstLoggerEntity>(); 
			instLogList = instLoggerServiceImpl.fetchListFor();
			
			List<InstLoggerCSV> instLogCSVList = new ArrayList<InstLoggerCSV>();
			
			for(InstLoggerEntity instLogger: instLogList) {
				InstLoggerCSV instLogCSV = new InstLoggerCSV();
				instLogCSV.setEmpId(instLogger.getEmpId());
				instLogCSV.setInstId(instLogger.getInstId());
				instLogCSV.setInstLoggerId(instLogger.getInstLoggerId());
				instLogCSV.setInTime(instLogger.getInTime().getTime().toGMTString());
				if(instLogger.getOutTime() == null) {
					instLogCSV.setOutTime("");
				}else {
					instLogCSV.setOutTime(instLogger.getOutTime().getTime().toGMTString());
				}
				instLogCSV.setCurrentDate(instLogger.getCurrentDate().toString());
				instLogCSV.setModelNo(instLogger.getModelNo());
				instLogCSV.setiP(instLogger.getiP());
				instLogCSVList.add(instLogCSV);
			}
						ColumnPositionMappingStrategy<InstLoggerCSV> mappingStrategy= new ColumnPositionMappingStrategy<InstLoggerCSV>(); 
			mappingStrategy.setType(InstLoggerCSV.class); 
 
			String[] columns = new String[]{ "instLoggerId","inTime","outTime","empId","instId","currentDate","modelNo","iP"}; 
			mappingStrategy.setColumnMapping(columns); 
			 
			StatefulBeanToCsvBuilder<InstLoggerCSV> builder = new StatefulBeanToCsvBuilder<InstLoggerCSV>(writer); 
			StatefulBeanToCsv<InstLoggerCSV> beanWriter = builder.withMappingStrategy(mappingStrategy).build(); 

			beanWriter.write(instLogCSVList); 

			writer.close(); 
	} 
	
	public void fetchEmployees(String storePath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		String CSV_LOCATION = PathHelperGuide.provideFullPath(storePath);
	
		FileWriter writer = new FileWriter(CSV_LOCATION); 
		writer.append("empId");
		writer.append("\n");
		 
		List<EmployeeEntity> empList = new ArrayList<EmployeeEntity>(); 
		empList = employeeServiceImpl.fetchEmployeeList();
		
		List<EmployeeCSV> employeeCSVList = new ArrayList<EmployeeCSV>();
		
		for(EmployeeEntity empEnt: empList) {
			EmployeeCSV employeeCSV = new EmployeeCSV();
			employeeCSV.setEmpId(empEnt.getEmpId());
			employeeCSVList.add(employeeCSV);
		}

		ColumnPositionMappingStrategy<EmployeeCSV> mappingStrategy= new ColumnPositionMappingStrategy<EmployeeCSV>(); 
		mappingStrategy.setType(EmployeeCSV.class); 

		String[] columns = new String[]{ "empId"}; 
		mappingStrategy.setColumnMapping(columns); 
		
		StatefulBeanToCsvBuilder<EmployeeCSV> builder = new StatefulBeanToCsvBuilder<EmployeeCSV>(writer); 
		StatefulBeanToCsv<EmployeeCSV> beanWriter = builder.withMappingStrategy(mappingStrategy).build(); 

		beanWriter.write(employeeCSVList); 

		writer.close(); 
		
	}
		public void fetchInstruments(String storePath) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
			String CSV_LOCATION = PathHelperGuide.provideFullPath(storePath);

			FileWriter writer = new FileWriter(CSV_LOCATION); 
			writer.append("instId,modelNo,iP");
			writer.append("\n");
			 
			List<InstrumentEntity> instList = new ArrayList<InstrumentEntity>(); 
			instList = instrumentServiceImpl.fetchInstrumentList();
			
			List<InstrumentCSV> instrumentCSVList = new ArrayList<InstrumentCSV>();
			
			for(InstrumentEntity instEnt: instList) {
				InstrumentCSV instrumentCSV = new InstrumentCSV();
				instrumentCSV.setInstId(instEnt.getInstId());
				instrumentCSV.setModelNo(instEnt.getModelNo());
				instrumentCSV.setiP(instEnt.getiP());
				instrumentCSVList.add(instrumentCSV);
			}

			ColumnPositionMappingStrategy<InstrumentCSV> mappingStrategy= new ColumnPositionMappingStrategy<InstrumentCSV>(); 
			mappingStrategy.setType(InstrumentCSV.class); 

			String[] columns = new String[]{ "instId","modelNo","iP"}; 
			mappingStrategy.setColumnMapping(columns); 
			
			StatefulBeanToCsvBuilder<InstrumentCSV> builder = new StatefulBeanToCsvBuilder<InstrumentCSV>(writer); 
			StatefulBeanToCsv<InstrumentCSV> beanWriter = builder.withMappingStrategy(mappingStrategy).build(); 

			beanWriter.write(instrumentCSVList); 

			writer.close(); 
				
		}	
} 

