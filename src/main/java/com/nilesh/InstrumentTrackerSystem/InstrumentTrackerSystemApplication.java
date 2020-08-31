package com.nilesh.InstrumentTrackerSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nilesh.InstrumentTrackerSystem.gui.Login;

@SpringBootApplication
public class InstrumentTrackerSystemApplication implements CommandLineRunner{

	@Autowired
	public Login theLogin;
	public static void main(String[] args) {
		

	
	    ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);
	    //new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);
//	    EventQueue.invokeLater(() -> {
//	    	//InstrumentTrackerSystemApplication ex = ctx.getBean(InstrumentTrackerSystemApplication.class);
//	    	InstrumentServiceImpl theInstrumentServiceImpl = ctx.getBean(InstrumentServiceImpl.class);
//	    	Login theLogin = ctx.getBean(Login.class);
//			theLogin.makeLoginPage();
//	    });
	    
//	    
//	    
//		EmployeeServiceImpl theEmployeeServiceImpl = ctx.getBean(EmployeeServiceImpl.class);
//		InstrumentServiceImpl theInstrumentServiceImpl = ctx.getBean(InstrumentServiceImpl.class);
//		InstLoggerServiceImpl theInstLoggerServiceImpl = ctx.getBean(InstLoggerServiceImpl.class);
//		CSVFromBean theBeanToCSV = ctx.getBean(CSVFromBean.class);
//		
	
	//	theBeanToCSV.fetchReport();
		
//		Calendar startTime = Calendar.getInstance();
//		
//		startTime.set(2020, Calendar.MONTH, Calendar.DATE, 0, 0, 0);
//	
//		Calendar inTime = Calendar.getInstance();
//		inTime.set(2020, 8, 24, 5, 48, 58);
//		
//		Calendar outTime = Calendar.getInstance();
//		outTime.set(2020, 8, 26, 3, 45, 34);
//		
//		Calendar theTime = Calendar.getInstance();
//		outTime.set(2020, 8, 26, 3, 45, 37);
//		
//		Calendar timeNow = Calendar.getInstance();
//		timeNow.getTime();


		
//		EmployeeEntity employee1 = new EmployeeEntity();
//		employee1.setEmpId("E101");
//		
//		InstrumentEntity instrument1 = new InstrumentEntity();
//		instrument1.setInstId("I104");
//
//		theEmployeeServiceImpl.save(employee1);
//		theInstrumentServiceImpl.save(instrument1);
//		System.out.println(theInstLoggerServiceImpl.insertToTable(timeNow,"E101", "I104")); 
//		
		
		
//		
//		
//		EmployeeEntity employee2 = new EmployeeEntity();
//		employee2.setEmpId("E102");
//		
//		InstrumentEntity instrument2 = new InstrumentEntity();
//		instrument2.setInstId("I103");
//
//		theEmployeeServiceImpl.save(employee2);
//		theInstrumentServiceImpl.save(instrument2);
//		System.out.println(theInstLoggerServiceImpl.insertToTable(timeNow,"E102", "I103")); 
//		System.out.println(theInstLoggerServiceImpl.insertToTable(timeNow,"E101", "I104")); 
//		
//		

		
		
//System.out.println(theEmployeeServiceImpl.findById("E101").getEmpId());
		

//			
//		InstLoggerEntity entry1 = new InstLoggerEntity("E101", "I104",inTime, outTime, true);
//	

//		theInstLoggerServiceImpl.save(entry1);
//		
//		
//		//theInstLoggerServiceImpl.findByPair(startTime, inTime, outTime,timeNow, "E101", "I104");
//		System.out.println(theInstLoggerServiceImpl.insertToTable(timeNow,"E101","I104"));
//		
//		
		
		//System.out.println(theInstLoggerServiceImpl.findByPair("E101", "I104").get(0).getOutTime().getTime());

	}	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		theLogin.makeLoginPage();
	}	
}

