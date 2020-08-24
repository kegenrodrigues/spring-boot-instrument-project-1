package com.nilesh.InstrumentTrackerSystem;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nilesh.InstrumentTrackerSystem.entity.EmployeeEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstLoggerEntity;
import com.nilesh.InstrumentTrackerSystem.entity.InstrumentEntity;
import com.nilesh.InstrumentTrackerSystem.repository.EmployeeDAOImpl;
import com.nilesh.InstrumentTrackerSystem.service.EmployeeServiceImpl;
import com.nilesh.InstrumentTrackerSystem.service.InstLoggerServiceImpl;
import com.nilesh.InstrumentTrackerSystem.service.InstrumentServiceImpl;

@SpringBootApplication
public class InstrumentTrackerSystemApplication{
//	
//	@Autowired
//	EmployeeDAOImpl employeeDAOImpl;
//	
//	@Autowired
//	EmployeeServiceImpl employeeServiceImpl;
//	
//	@Autowired
//	InstLoggerServiceImpl instLoggerServiceImpl;
//	
	public static void main(String[] args) {
		Calendar inTime = Calendar.getInstance();
		inTime.set(2020, 8, 24, 5, 48, 58);
		
		Calendar outTime = Calendar.getInstance();
		outTime.set(2020, 8, 26, 3, 45, 34);
		
		//Date inTime = new Date();
		//Date outTime = new Date();

	    ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);
	    
		EmployeeServiceImpl theEmployeeServiceImpl = ctx.getBean(EmployeeServiceImpl.class);
		InstrumentServiceImpl theInstrumentServiceImpl = ctx.getBean(InstrumentServiceImpl.class);
		InstLoggerServiceImpl theInstLoggerServiceImpl = ctx.getBean(InstLoggerServiceImpl.class);

		EmployeeEntity employee1 = new EmployeeEntity();
		employee1.setEmpId("E101");
		
		InstrumentEntity instrument1 = new InstrumentEntity();
		instrument1.setInstId("I104");;
			
		InstLoggerEntity entry1 = new InstLoggerEntity("E101", "I104",inTime, outTime, true);
	
		theEmployeeServiceImpl.save(employee1);
		theInstrumentServiceImpl.save(instrument1);
		theInstLoggerServiceImpl.save(entry1);

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
