package com.nilesh.InstrumentTrackerSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.nilesh.InstrumentTrackerSystem.gui.Login;
import com.nilesh.InstrumentTrackerSystem.repository.EmployeeDAOImpl;
import com.nilesh.InstrumentTrackerSystem.service.EmployeeServiceImpl;

@SpringBootApplication
public class InstrumentTrackerSystemApplication{
	
	@Autowired
	EmployeeDAOImpl employeeDAOImpl;
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	public static void main(String[] args) {
		//ApplicationContext ctx = SpringApplication.run(InstrumentTrackerSystemApplication.class, args);
		
	    ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);
	    //AppPrincipalFrame appFrame = ctx.getBean(AppPrincipalFrame.class);
	
	    
	    Login theLogin = ctx.getBean(Login.class);
	    theLogin.makeLoginPage();
		
		EmployeeServiceImpl theEmployeeServiceImpl = ctx.getBean(EmployeeServiceImpl.class);
		
		System.out.println(theEmployeeServiceImpl.findAll());
//		  var ctx = new SpringApplicationBuilder(SwingApp.class)
//	                .headless(false).run(args);
	}	
}
