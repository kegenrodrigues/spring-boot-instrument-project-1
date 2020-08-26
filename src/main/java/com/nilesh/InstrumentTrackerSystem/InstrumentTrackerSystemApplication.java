package com.nilesh.InstrumentTrackerSystem;

import java.util.Calendar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;
import com.nilesh.InstrumentTrackerSystem.gui.Login;
import com.nilesh.InstrumentTrackerSystem.service.EmployeeServiceImpl;
import com.nilesh.InstrumentTrackerSystem.service.InstLoggerServiceImpl;
import com.nilesh.InstrumentTrackerSystem.service.InstrumentServiceImpl;

@SpringBootApplication
public class InstrumentTrackerSystemApplication{

	public static void main(String[] args) {

		
		
		
		Calendar startTime = Calendar.getInstance();
		
		startTime.set(2020, Calendar.MONTH, Calendar.DATE, 0, 0, 0);
	
		Calendar inTime = Calendar.getInstance();
		inTime.set(2020, 8, 24, 5, 48, 58);
		
		Calendar outTime = Calendar.getInstance();
		outTime.set(2020, 8, 26, 3, 45, 34);
		
		Calendar theTime = Calendar.getInstance();
		outTime.set(2020, 8, 26, 3, 45, 37);
		
		Calendar timeNow = Calendar.getInstance();
		timeNow.getTime();

	    ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);
	    
		EmployeeServiceImpl theEmployeeServiceImpl = ctx.getBean(EmployeeServiceImpl.class);
		InstrumentServiceImpl theInstrumentServiceImpl = ctx.getBean(InstrumentServiceImpl.class);
		InstLoggerServiceImpl theInstLoggerServiceImpl = ctx.getBean(InstLoggerServiceImpl.class);

		
		System.out.println(theInstLoggerServiceImpl.insertToTable(theTime,"E101", "I104")); 
		
		
//	    Login theLogin = ctx.getBean(Login.class);
//		theLogin.makeLoginPage();
		
		
		System.out.println(theEmployeeServiceImpl.findById("E101").getEmpId());
		
		
		
		
		
		
		
		
		
		
		EmployeeEntity employee1 = new EmployeeEntity();
		employee1.setEmpId("E101");
		
		InstrumentEntity instrument1 = new InstrumentEntity();
		instrument1.setInstId("I104");;
			
		InstLoggerEntity entry1 = new InstLoggerEntity("E101", "I104",inTime, outTime, true);
	
//		theEmployeeServiceImpl.save(employee1);
//		theInstrumentServiceImpl.save(instrument1);
//		theInstLoggerServiceImpl.save(entry1);
//		
		
		theInstLoggerServiceImpl.findByPair(startTime, inTime, outTime,timeNow, "E101", "I104");
		
		
		
		System.out.println(theInstLoggerServiceImpl.findByPair("E101", "I104").get(0).getOutTime().getTime());
//		if(theInstLoggerServiceImpl.findByPair("E101", "I104").get(0).getEntryStatus()==true){
//			System.out.println("Yes its 1");
//		}
//		else {
//			System.out.println("Its false");
//			System.out.println("Its false");
//		}
		
	}	
}

//##############//	    Login theLogin = ctx.getBean(Login.class);
//##############//		theLogin.makeLoginPage();
//##############//		System.out.println(theEmployeeServiceImpl.findById("E101").getEmpId());

//AppPrincipalFrame appFrame = ctx.getBean(AppPrincipalFrame.class);

//ApplicationContext ctx = SpringApplication.run(InstrumentTrackerSystemApplication.class, args);

//java.util.Date dt = new java.util.Date();
//
//java.text.SimpleDateFormat sdf = 
//     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//String currentTime = sdf.format(dt);

//theEmployeeServiceImpl.deleteById("E101");
//var ctx = new SpringApplicationBuilder(SwingApp.class)
//          .headless(false).run(args);
