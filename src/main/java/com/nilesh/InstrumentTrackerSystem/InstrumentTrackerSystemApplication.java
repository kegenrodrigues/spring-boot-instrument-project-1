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

	    @SuppressWarnings("unused")
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(InstrumentTrackerSystemApplication.class).headless(false).run(args);

	}	

	@Override
	public void run(String... args) throws Exception {
		theLogin.makeLoginPage();
	}	
}

